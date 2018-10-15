package gov.hhs.batch.ehrp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.hhs.batch.ehrp.model.Approvals;
import gov.hhs.batch.ehrp.model.Candidates;
import gov.hhs.batch.ehrp.model.DepartmentHierarchy;
import gov.hhs.batch.ehrp.model.EmployeeReplacement;
import gov.hhs.batch.ehrp.model.EwitsDetails;
import gov.hhs.batch.ehrp.model.JobCodeDetail;
import gov.hhs.batch.ehrp.model.JobCodes;
import gov.hhs.batch.ehrp.model.Openings;
import gov.hhs.batch.ehrp.model.PositionDeptHierarchy;
import gov.hhs.batch.ehrp.model.PositionDetail;
import gov.hhs.batch.ehrp.model.Positions;
import gov.hhs.batch.ehrp.model.RequisitionDetail;
import gov.hhs.batch.ehrp.model.SalaryDetail;

@Component
public class EHRPXMLImportTasklet implements Tasklet {

	private static final Logger log = LoggerFactory.getLogger(EHRPXMLImportTasklet.class);
	
	@Autowired
	private EHRPProperties properties;
	@Autowired
	private DBProcessor dbProcessor;
	@Autowired
	private DataProcessor dataProcessor;
	private static List<RequisitionDetail> reqDetailResultList  = new ArrayList<RequisitionDetail>();
	private static List<JobCodes> jobCodeResultList = new ArrayList<JobCodes>();
	private static List<Positions> positionResultList = new ArrayList<Positions>();
	private static List<Openings> openingsResultList = new ArrayList<Openings>();
	private static List<Candidates> candidatesResultList = new ArrayList<Candidates>();
	private static List<DepartmentHierarchy> deptHierarchyResultList = new ArrayList<DepartmentHierarchy>();
	private static List<Approvals> approvalsResultList = new ArrayList<Approvals>();
	private static List<EwitsDetails> ewitsDetailsResultList = new ArrayList<EwitsDetails>();
	private static List<EmployeeReplacement> empReplResultList =  new ArrayList<EmployeeReplacement>();
	private static List<PositionDetail> positionDetailResultList = new ArrayList<PositionDetail>();
	private static List<JobCodeDetail> jobCodeDetailResultList = new ArrayList<JobCodeDetail>();
	private static List<SalaryDetail> salaryDetailResultList = new ArrayList<SalaryDetail>();
	private static List<PositionDeptHierarchy> posDeptHierarchyResultList = new ArrayList<PositionDeptHierarchy>();
	private List<String> jobOpeningNbrsList;
	
	private String fileDelimiter = "/";
	private int archiveCnt = 0;
	private int errorCnt = 0;
	private boolean filesDetected = false;
		
	public void setData(RequisitionDetail reqDetailResult, List<JobCodes> jobCodesList , List<Positions> positionsList, List<Openings> openingsList, List<Candidates> candidatesList, List<DepartmentHierarchy> deptHierarchyList, List<Approvals> approvalsList, List<EwitsDetails> ewitsDetailsList, List<EmployeeReplacement> empReplList, List<PositionDetail> positionDetailList, List<JobCodeDetail> jobCodeDetailList, List<SalaryDetail> salaryDetailList, List<PositionDeptHierarchy> posDeptHierarchyList) {
		this.reqDetailResultList.clear();
		this.reqDetailResultList.add(this.reqDetailResultList.size(), reqDetailResult);
		this.jobCodeResultList = jobCodesList;
		this.positionResultList = positionsList;
		this.openingsResultList = openingsList;
		this.candidatesResultList = candidatesList;
		this.deptHierarchyResultList = deptHierarchyList;
		this.approvalsResultList = approvalsList;
		this.ewitsDetailsResultList = ewitsDetailsList;
		this.empReplResultList = empReplList;
		this.positionDetailResultList = positionDetailList;
		this.jobCodeDetailResultList = jobCodeDetailList;
		this.salaryDetailResultList = salaryDetailList;
		this.posDeptHierarchyResultList = posDeptHierarchyList;
	
	}
	
	public void setProcessedData(List <RequisitionDetail> reqDtlList, List<JobCodes> jobCodesList, List<Positions> positionsList, List<Openings> openingsList, List<Candidates> candidatesList, List<DepartmentHierarchy> deptHierarchyList, List<Approvals> approvalsList, List<EwitsDetails> ewitsDetailsList, List<EmployeeReplacement> empReplList, List<PositionDetail> positionDetailList, List<JobCodeDetail> jobCodeDetailList, List<SalaryDetail> salaryDetailList, List<PositionDeptHierarchy> posDeptHierarchyList) {
		this.reqDetailResultList = reqDtlList;
		this.jobCodeResultList = jobCodesList;
		this.positionResultList = positionsList;
		this.openingsResultList = openingsList;
		this.candidatesResultList = candidatesList;
		this.deptHierarchyResultList = deptHierarchyList;
		this.approvalsResultList = approvalsList;
		this.ewitsDetailsResultList = ewitsDetailsList;
		this.empReplResultList = empReplList;
		this.positionDetailResultList = positionDetailList;
		this.jobCodeDetailResultList = jobCodeDetailList;
		this.salaryDetailResultList = salaryDetailList;
		this.posDeptHierarchyResultList = posDeptHierarchyList;
	}
	
	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		ArrayList fileList = new ArrayList();
		File inboundDir = new File(properties.getInboundDir());
		File processingDir = new File(properties.getProcessingDir());
		File errorDir = new File(properties.getErrorDir());
		File archiveDir = new File(properties.getArchiveDir());
		String currentFileName = "";
		File currentFile;
		
		try {
			
			//create a filter to search for file types
			String[] extensions = { "xml" };

			//Creates collection of existing job opening ids
			jobOpeningNbrsList= dbProcessor.selectJobOpeningNbrs();
					
			Thread.sleep(10000);
			//get a directory file listing based on extension
			fileList = new ArrayList(FileUtils.listFiles(inboundDir, extensions, false));
			
			if (fileList.size() > 0) {
				//There are file(s) to process
				log.debug("Files detected... preparing to process");
				
				try
				{
					fileList = getOrderedFileList(fileList);
				}
				catch (Exception e)
				{
					log.error(
						"The EHRP REQ OutBound files could not be sorted by the file Names. Hence aborting the task.");
					throw new Exception("The EHRP REQ OutBound files could not be sorted by the file Names.", e);
				}
				
				Iterator fileListIterator = fileList.iterator();
				
				archiveCnt = 0;
				errorCnt = 0;
				
				while (fileListIterator.hasNext()) {
					filesDetected = true;
					currentFile = ((File) fileListIterator.next());
					currentFileName = currentFile.getName();

					//move from inbound to processing directory
					FileUtils.copyFileToDirectory(currentFile, processingDir);
					FileUtils.forceDelete(currentFile);
					
					DOMXMLObject dom = new DOMXMLObject(new File(processingDir + fileDelimiter +  currentFileName));
					EHRPXMLObjectData data = new EHRPXMLObjectData(dom, jobOpeningNbrsList);

					try {
						//Process data with business rules
						dataProcessor.processData(reqDetailResultList,
											jobCodeResultList,
											positionResultList,
											openingsResultList,
											candidatesResultList,
											deptHierarchyResultList,
											approvalsResultList,
											ewitsDetailsResultList,
											empReplResultList,
											positionDetailResultList,
											jobCodeDetailResultList,
											salaryDetailResultList,
											posDeptHierarchyResultList);
						
						//Insert data into the BizFlow global schema (HHS_HR)
						dbProcessor.insertDataIntoDb(reqDetailResultList,
													jobCodeResultList,
													positionResultList,
													openingsResultList,
													candidatesResultList,
													deptHierarchyResultList,
													approvalsResultList,
													ewitsDetailsResultList,
													empReplResultList,
													positionDetailResultList,
													jobCodeDetailResultList,
													salaryDetailResultList,
													posDeptHierarchyResultList);
						
					} catch (Exception e) {				
						try {
							// copy the file to error directory for future investigation
							FileUtils.copyFile(new File(processingDir + fileDelimiter + currentFileName),
								new File(errorDir + fileDelimiter + currentFileName));
							FileUtils.forceDelete(new File(processingDir + fileDelimiter + currentFileName));
							errorCnt++;
							log.error("Error in importing the data into  EWITS for the file - " + currentFileName);
						} catch (Exception e1) {
							log.info(e1.getMessage() + "::" + e.getCause());
							continue;
						}
						
						log.info(e.getMessage() + "::" + e.getCause());
						continue;
					}
										
					// copy the file to the archive directory 
					FileUtils.copyFile(new File(processingDir + fileDelimiter + currentFileName),
						new File(archiveDir + fileDelimiter + currentFileName));
					FileUtils.forceDelete(new File(processingDir +  fileDelimiter + currentFileName));
					archiveCnt++;
				}
				
			}else {
				log.info(properties.getNoFilesMsg());
				filesDetected = false;
			}			

		}catch (Exception e) {
			
			try
			{
				// if it failed while processing a file then move the file to the error folder.
				if ((currentFileName != null) && !currentFileName.equals(""))
				{
					FileUtils.copyFile(new File(processingDir + fileDelimiter + currentFileName),
						new File(errorDir  + fileDelimiter + currentFileName));
					FileUtils.forceDelete(new File(processingDir + fileDelimiter + currentFileName));
					errorCnt++;
					log.error("Error in importing the data into  EWITS for the file - " + currentFileName);
				}
			}
			catch (IOException e1)
			{
				log.info(e1.getMessage() + "::" + e1.getCause());
			}
						
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
		}finally{
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(properties.getErrorName(),Integer.toString(errorCnt));
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(properties.getArchiveName(), Integer.toString(archiveCnt));
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(properties.getNoFilesName(), String.valueOf(filesDetected));
			return RepeatStatus.FINISHED;
		}
	}
	
	/**
	 * Function to return the sorted list of fileNames
	 *
	 * @param fileList Unordered list of filenames
	 *
	 * @return Returns ordered list of filenames
	 */
	private ArrayList getOrderedFileList(ArrayList fileList)
	{
		Collections.sort(fileList, new EHRPFileNameComparator());

		return fileList;
	}

}

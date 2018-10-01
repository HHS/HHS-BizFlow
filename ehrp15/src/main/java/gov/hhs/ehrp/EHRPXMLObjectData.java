package gov.hhs.ehrp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import gov.hhs.ehrp.model.Approvals;
import gov.hhs.ehrp.model.ApprovalsTags;
import gov.hhs.ehrp.model.Candidates;
import gov.hhs.ehrp.model.CandidatesTags;
import gov.hhs.ehrp.model.DepartmentHierarchy;
import gov.hhs.ehrp.model.DepartmentHierarchyTags;
import gov.hhs.ehrp.model.EmployeeReplacement;
import gov.hhs.ehrp.model.EmployeeReplacementTags;
import gov.hhs.ehrp.model.EwitsDetails;
import gov.hhs.ehrp.model.EwitsDetailsTags;
import gov.hhs.ehrp.model.JobCodeDetail;
import gov.hhs.ehrp.model.JobCodeDetailTags;
import gov.hhs.ehrp.model.JobCodeTags;
import gov.hhs.ehrp.model.JobCodes;
import gov.hhs.ehrp.model.Openings;
import gov.hhs.ehrp.model.OpeningsTags;
import gov.hhs.ehrp.model.PositionDeptHierarchy;
import gov.hhs.ehrp.model.PositionDeptHierarchyTags;
import gov.hhs.ehrp.model.PositionDetail;
import gov.hhs.ehrp.model.PositionDetailTags;
import gov.hhs.ehrp.model.Positions;
import gov.hhs.ehrp.model.PositionsTags;
import gov.hhs.ehrp.model.RequisitionDetail;
import gov.hhs.ehrp.model.RequisitionDetailTags;
import gov.hhs.ehrp.model.SalaryDetail;
import gov.hhs.ehrp.model.SalaryDetailTags;


public class EHRPXMLObjectData
{
	
	@Autowired
	private RequisitionDetailTags reqDetailTags;
	@Autowired
	private JobCodeTags jobCodeTags;
	@Autowired
	private PositionsTags positionsTags;
	@Autowired
	private OpeningsTags openingsTags;
	@Autowired
	private CandidatesTags candidatesTags;
	@Autowired
	private DepartmentHierarchyTags deptHierarchyTags;
	@Autowired
	private ApprovalsTags approvalsTags;
	@Autowired
	private EwitsDetailsTags ewitsDetailsTags;
	@Autowired
	EmployeeReplacementTags empReplTags;
	@Autowired
	private PositionDetailTags positionDetailTags;
	@Autowired
	private JobCodeDetailTags jobcodeDetailTags;
	@Autowired
	private SalaryDetailTags salaryDetailTags;
	@Autowired
	private PositionDeptHierarchyTags posDeptHierarchyTags;
	private RequisitionDetail reqDetailResult;
            
    private DOMXMLObject domObj = null;
    private List<String> jobOpeningNbrsList = new ArrayList<String>();


	/**
	 * Creates a new EHRPXMLObjectData object.
	 *
	 * @param domObj domObject created from an EHRP requisition XML file.
	 */
	public EHRPXMLObjectData(DOMXMLObject domObj)
	{
		this.domObj = domObj;
		loadData();
	}
	
	/**
	 * Creates a new EHRPXMLObjectData object.
	 *
	 * @param domObj domObject created from an EHRP requisition XML file.
	 * @param List<Integer> - passes in the list of job opening ids
	 */
	public EHRPXMLObjectData(DOMXMLObject domObj, List<String> jobOpeningNbrsList)
	{
		this.domObj = domObj;
		this.jobOpeningNbrsList = jobOpeningNbrsList;
		loadData();
	}

	/**
	 * function which loads the data.
	 */
	public void loadData()
	{
		EHRPXMLImportTasklet fileTasklet = new EHRPXMLImportTasklet();

		if (domObj != null)
		{
			reqDetailResult = new RequisitionDetail(); 
			reqDetailResult.setJobReqNbr(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getJobReqNumberTag())));
			reqDetailResult.setOriginatorId(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getOriginatorIdTag())));
			reqDetailResult.setOpenDt(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getOpenDtTag())));
			reqDetailResult.setJobReqStatus(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getJobReqStatusTag())));
			reqDetailResult.setBusinessUnit(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getBusinessUnitTag())));
			reqDetailResult.setDeptId(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getDeptIdReqDetTag())));
			reqDetailResult.setGvtRecrOffice(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getRecrOfficeTag())));
			reqDetailResult.setHeApprovalOprid(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getApprovalOpridTag())));
			reqDetailResult.setGvtSelOfficial(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getSelectingOfficalTag())));
			reqDetailResult.setStatusDt(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getStatusDtTag())));
			reqDetailResult.setOpeningsTarget(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getNumberOfOpeningsTag())));
			reqDetailResult.setSetIdDept(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getSetidDeptTag())));
			reqDetailResult.setCompany(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getCompanyTag())));
			reqDetailResult.setJobcode(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getJobCodeTag())));
			reqDetailResult.setPositionNbr(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getPositionNbrTag())));
			reqDetailResult.setLocation(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getLocationTag())));
			reqDetailResult.setPostingTitle(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getPostingTitleTag())));
			reqDetailResult.setDesiredStartDt(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getDesiredStartDtTag())));
			reqDetailResult.setAuthorizationDt(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getAuthorizationDtTag())));
			reqDetailResult.setCountry(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getCountryTag())));
			reqDetailResult.setGvtStaffSpclst(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getStaffSpclstTag())));
			reqDetailResult.setGvtConsiderArea(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getAOCTag())));
			reqDetailResult.setGvtRqsnType(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getRqsnTypeTag())));
			reqDetailResult.setInitiatorOprid(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getInitiatorOpridTag())));
			reqDetailResult.setComments(domObj.getNodeContent(domObj.getOnlyNode(reqDetailTags.getCommentsTag())));
			
			if(!(jobOpeningNbrsList.contains(reqDetailResult.getJobReqNbr()))) {
	            fileTasklet.setData(reqDetailResult,
    					loadJobCodesData(reqDetailResult.getJobReqNbr()),
    					loadPositions(reqDetailResult.getJobReqNbr()),
    					loadOpenings(reqDetailResult.getJobReqNbr()),
    					loadCandidatesData(reqDetailResult.getJobReqNbr()),
    					loadDeptHierarchy(reqDetailResult.getJobReqNbr()),
    					loadApprovals(reqDetailResult.getJobReqNbr()),
    					loadEwitsDetails(reqDetailResult.getJobReqNbr()),
    					loadEmployeeReplacement(reqDetailResult.getJobReqNbr()),
    					loadPositionDetail(reqDetailResult.getJobReqNbr()),
    					loadJobCodeDetail(reqDetailResult.getJobReqNbr()),
    					loadSalaryDetail(reqDetailResult.getJobReqNbr()),
    					loadPosDeptHierarchy(reqDetailResult.getJobReqNbr()));				
			}
		}
	}
	
	/**
	 * loads all values associated with jobCodes tags 
	 */
	private List<JobCodes> loadJobCodesData(String jobReqNbr)
	{
		JobCodes jobCodeResult = null;
		List<JobCodes> jobCodeResultList = new ArrayList<JobCodes>(); 
		NodeList jobCodeNodes = domObj.getNodeList(jobCodeTags.getJobCodesTag());

		if ((jobCodeNodes != null) && (jobCodeNodes.getLength() > 0))
		{
			for (int i = 0; i < jobCodeNodes.getLength(); i++)
			{
				Node jobCodeNode = jobCodeNodes.item(i);
				
				if (jobCodeNode != null) {
					
					jobCodeResult = new JobCodes();
					
					jobCodeResult.setJobReqNbr(jobReqNbr);
					jobCodeResult.setJobCode(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getJobcodeTag())));
					jobCodeResult.setPrimaryJobCode(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getPrimaryJobcodeTag())));
					jobCodeResult.setRegRegion(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getRegRegionTag())));
					jobCodeResult.setDesiredFullPart(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getDesiredFullPartTag())));
					jobCodeResult.setDesiredRegTemp(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getDesiredRegTempTag())));
					jobCodeResult.setStdHrs(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getStdHrsTag())));
					jobCodeResult.setStdHrsFreq(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getStdHrsFreqTag())));
					jobCodeResult.setDesiredShift(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getDesiredShiftTag())));
					jobCodeResult.setGvtRqsnSalFrom(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getRqsnSalFromTag())));
					jobCodeResult.setGvtRqsnSalTo(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getRqsnSalToTag())));
					jobCodeResult.setPayFreqAbbrev(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getPayFreqAbbrevTag())));
					jobCodeResult.setCurrencyCd(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getCurrencyCdTag())));
					jobCodeResult.setSalAdminPlan(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getSalAdminPlanTag())));
					jobCodeResult.setGrade(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getGradeTag())));
					jobCodeResult.setTravelPct(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getTravelPerctTag())));
					jobCodeResult.setManagerLvl(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getManagerLvlTag())));
					jobCodeResult.setFlsaStatus(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getFlsaStatusTag())));
					jobCodeResult.setSummerAppt(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getSummerApptTag())));
					jobCodeResult.setNteDate(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getNteDateTag())));
					jobCodeResult.setNteDays(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getNteDaysTag())));
					jobCodeResult.setLeoPosition(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getLeoPositionTag())));
					jobCodeResult.setPosnSensCd(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getPosnSensCdTag())));
					jobCodeResult.setTypeOfAppt(domObj.getNodeContent(domObj.getOnlyNode(jobCodeNode,jobCodeTags.getApptTypeTag())));	
				}				

				jobCodeResultList.add(jobCodeResult);
			}

		}
		return jobCodeResultList;
	}
	
	/**
	 * loads all values associated with positions tags 
	 */
	private List<Positions> loadPositions(String jobReqNbr)
	{
		Positions positionResult = null;
		List<Positions> positionResultList= new ArrayList<Positions>(); 
		NodeList positionNodes = domObj.getNodeList(positionsTags.getPositionsTag());
		
		if ((positionNodes != null) && (positionNodes.getLength() > 0))
		{
			for (int i = 0; i < positionNodes.getLength(); i++)
			{
				Node positionNode = positionNodes.item(i);
				
				if (positionNode != null) {
				
				positionResult = new Positions();
				
				positionResult.setJobReqNbr(jobReqNbr);
				positionResult.setPositionNbr(domObj.getNodeContent(domObj.getOnlyNode(positionNode, positionsTags.getPositionNbrTag())));
				positionResult.setPrimaryPositionFlag(domObj.getNodeContent(domObj.getOnlyNode(positionNode, positionsTags.getPrimaryPosnTag())));
				
				}

				positionResultList.add(positionResult);
			}
			
		}
		
		return positionResultList;
	}
	
	/**
	 * loads all values associated with openings tags 
	 */
	private List<Openings> loadOpenings(String jobReqNbr)
	{
		Openings openingsResult = null;
		List<Openings> openingsResultList= new ArrayList<Openings>(); 
		NodeList openingsNodes = domObj.getNodeList(openingsTags.getOpeningsTag());
		if ((openingsNodes != null) && (openingsNodes.getLength() > 0))
		{
			for (int i = 0; i < openingsNodes.getLength(); i++)
			{
				Node openingsNode = openingsNodes.item(i);
				
				if (openingsNode != null) {
					
					openingsResult = new Openings();
					
					openingsResult.setJobReqNbr(jobReqNbr);
					openingsResult.setLocation(domObj.getNodeContent(domObj.getOnlyNode(openingsNode, openingsTags.getLocationTag())));
					openingsResult.setPrimaryLocationFlag(domObj.getNodeContent(domObj.getOnlyNode(openingsNode, openingsTags.getPrimaryLocTag())));
					openingsResult.setDescr(domObj.getNodeContent(domObj.getOnlyNode(openingsNode, openingsTags.getDescrTag())));
				}
				
				openingsResultList.add(openingsResult);
			}

		}
		
		return openingsResultList;
	}
	
	/**
	 * loads all values associated with Candidates tags 
	 */
	private List<Candidates> loadCandidatesData(String jobReqNbr)
	{
		Candidates candidatesResult = null;
		List<Candidates> candidatesResultList = new ArrayList<Candidates>();
		NodeList candidateNodes = domObj.getNodeList(candidatesTags.getApplicantsTag());
		if ((candidateNodes != null) && (candidateNodes.getLength() > 0))
		{
			for (int i = 0; i < candidateNodes.getLength(); i++)
			{				
				Node candidateNode = candidateNodes.item(i);				
				
				if (candidateNode != null) {
				
					candidatesResult = new Candidates();
					
					candidatesResult.setJobReqNbr(jobReqNbr);
					candidatesResult.setSequenceNbr(domObj.getNodeContent(domObj.getOnlyNode(candidateNode, candidatesTags.getSeqNbrTag())));
					candidatesResult.setName(domObj.getNodeContent(domObj.getOnlyNode(candidateNode, candidatesTags.getApplicantNameTag())));
				}
			
				candidatesResultList.add(candidatesResult);
			}
			
		}
		
		return candidatesResultList;

	}
	
	/**
	 * loads all values associated with Department Hierarchy tags 
	 */
	private List<DepartmentHierarchy> loadDeptHierarchy(String jobReqNbr)
	{
		DepartmentHierarchy deptHierarchyResult = null;
		List<DepartmentHierarchy> deptHierarchyResultList = new ArrayList<DepartmentHierarchy>();
		NodeList deptHierarchyNodes = domObj.getNodeList(deptHierarchyTags.getDeptHierarchyTag());
		if ((deptHierarchyNodes != null) && (deptHierarchyNodes.getLength() > 0))
		{
			for (int i = 0; i < deptHierarchyNodes.getLength(); i++)
			{				
				Node deptHierarchyNode = deptHierarchyNodes.item(i);
								
				if (deptHierarchyNode != null) {
				
					deptHierarchyResult = new DepartmentHierarchy();
					
					deptHierarchyResult.setJobReqNbr(jobReqNbr);
					deptHierarchyResult.setSetId(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getSetIdTag())));
					deptHierarchyResult.setDeptId(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptIdTag())));
					deptHierarchyResult.setDescr(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptDescTag())));
					deptHierarchyResult.setParLine2(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptId2Tag())));
					deptHierarchyResult.setParDescr2(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptDesc2Tag())));
					deptHierarchyResult.setParLine3(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptId3Tag())));
					deptHierarchyResult.setParDescr3(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptDesc3Tag())));
					deptHierarchyResult.setParLine4(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptId4Tag())));
					deptHierarchyResult.setParDescr4(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptDesc4Tag())));
					deptHierarchyResult.setParLine5(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptId5Tag())));
					deptHierarchyResult.setParDescr5(domObj.getNodeContent(domObj.getOnlyNode(deptHierarchyNode, deptHierarchyTags.getDeptDesc5Tag())));
				}
				
				deptHierarchyResultList.add(deptHierarchyResult);
			}
			
		}
		
		return deptHierarchyResultList;

	}
	
	/**
	 * loads all values associated with Approvals tags 
	 */
	private List<Approvals> loadApprovals(String jobReqNbr)
	{
		Approvals approvalResult = null;
		List<Approvals> approvalResultList = new ArrayList<Approvals>();
		NodeList approvalNodes = domObj.getNodeList(approvalsTags.getApprovalsTag());

		if ((approvalNodes != null) && (approvalNodes.getLength() > 0))
		{
			for (int i = 0; i < approvalNodes.getLength(); i++)
			{				
				Node approvalNode = approvalNodes.item(i);
				
				if (approvalNode != null) {
				
					approvalResult = new Approvals();

					approvalResult.setJobReqNbr(jobReqNbr);
					approvalResult.setStep(domObj.getNodeContent(domObj.getOnlyNode(approvalNode, approvalsTags.getStepTag())));
					approvalResult.setStatus(domObj.getNodeContent(domObj.getOnlyNode(approvalNode, approvalsTags.getStatusTag())));
					approvalResult.setStatusDt(domObj.getNodeContent(domObj.getOnlyNode(approvalNode, approvalsTags.getStatusDtTag())));
					approvalResult.setOprid(domObj.getNodeContent(domObj.getOnlyNode(approvalNode, approvalsTags.getOpridTag())));
					approvalResult.setEmplid(domObj.getNodeContent(domObj.getOnlyNode(approvalNode, approvalsTags.getEmplidTag())));
					approvalResult.setComments(domObj.getNodeContent(domObj.getOnlyNode(approvalNode ,approvalsTags.getCommentsTag())));

				}
				
				approvalResultList.add(approvalResult);
			}
		}
		
		return approvalResultList;

	}
	
	/**
	 * loads all values associated with eWITS_Details tags 
	 */
	private List<EwitsDetails> loadEwitsDetails(String jobReqNbr)
	{
		EwitsDetails ewitsDetailResult = null;
		List<EwitsDetails> ewitsDetailResultList = new ArrayList<EwitsDetails>();
		NodeList ewitsDetailNodes = domObj.getNodeList(ewitsDetailsTags.getEwitsDetailsTag());
		if ((ewitsDetailNodes != null) && (ewitsDetailNodes.getLength() > 0))
		{
			for (int i = 0; i < ewitsDetailNodes.getLength(); i++)
			{				
				Node ewitsDetailNode = ewitsDetailNodes.item(i);
				
				if (ewitsDetailNode != null) {
				
					ewitsDetailResult = new EwitsDetails();
					
					ewitsDetailResult.setJobReqNbr(jobReqNbr);
					ewitsDetailResult.setPhysCompAllowance(domObj.getNodeContent(domObj.getOnlyNode(ewitsDetailNode, ewitsDetailsTags.getPhysicianCompAllowance())));
					ewitsDetailResult.setPhysDentistPay(domObj.getNodeContent(domObj.getOnlyNode(ewitsDetailNode, ewitsDetailsTags.getPhysicianDentistPay())));
					ewitsDetailResult.setNonStandardPay(domObj.getNodeContent(domObj.getOnlyNode(ewitsDetailNode, ewitsDetailsTags.getNonStandardPay())));
					ewitsDetailResult.setPositionDescr(domObj.getNodeContent(domObj.getOnlyNode(ewitsDetailNode, ewitsDetailsTags.getPositionDescription())));
					ewitsDetailResult.setRecruitmentIncentive(domObj.getNodeContent(domObj.getOnlyNode(ewitsDetailNode, ewitsDetailsTags.getRecruitmentIncentive())));
					ewitsDetailResult.setRelocationIncentive(domObj.getNodeContent(domObj.getOnlyNode(ewitsDetailNode, ewitsDetailsTags.getRecruitmentIncentive())));
					ewitsDetailResult.setCan(domObj.getNodeContent(domObj.getOnlyNode(ewitsDetailNode, ewitsDetailsTags.getCan())));
				}
				
				ewitsDetailResultList.add(ewitsDetailResult);
			}

		}
		
		return ewitsDetailResultList;

	}
	
	/**
	 * loads all values associated with Employee_Replacement tags 
	 */
	private List<EmployeeReplacement> loadEmployeeReplacement(String jobReqNbr)
	{
		EmployeeReplacement empRplResult = null;
		List<EmployeeReplacement> empRplResultList = new ArrayList<EmployeeReplacement>();
		NodeList empRplNodes = domObj.getNodeList(empReplTags.getEmployeeReplacementTag());
		if ((empRplNodes != null) && (empRplNodes.getLength() > 0))
		{
			for (int i = 0; i < empRplNodes.getLength(); i++)
			{				
				Node empRplNode = empRplNodes.item(i);
				
				if (empRplNode != null) {
				
					empRplResult = new EmployeeReplacement();
					
					empRplResult.setJobReqNbr(jobReqNbr);
					empRplResult.setViceEmplid(domObj.getNodeContent(domObj.getOnlyNode(empRplNode, empReplTags.getViceEmplidTag())));
					empRplResult.setDateVacated(domObj.getNodeContent(domObj.getOnlyNode(empRplNode, empReplTags.getDateVacatedTag())));
					empRplResult.setViceName(domObj.getNodeContent(domObj.getOnlyNode(empRplNode, empReplTags.getViceNameTag())));

				}
				
				empRplResultList.add(empRplResult);
			}

		}
		
		return empRplResultList;

	}

	
	/**
	 * loads all values associated with POSITION_DETAIL tags 
	 */
	private List<PositionDetail> loadPositionDetail(String jobReqNbr)
	{
		PositionDetail positionDetailResult = null;
		List<PositionDetail> positionDetailResultList = new ArrayList<PositionDetail>();
		NodeList positionDetailNodes = domObj.getNodeList(positionDetailTags.getPositionDetailTag());
		if ((positionDetailNodes != null) && (positionDetailNodes.getLength() > 0))
		{
			for (int i = 0; i < positionDetailNodes.getLength(); i++)
			{				
				Node positionDetailNode = positionDetailNodes.item(i);
				
				if (positionDetailNode != null) {
				
					positionDetailResult = new PositionDetail();
					
					positionDetailResult.setJobReqNbr(jobReqNbr);
					positionDetailResult.setPositionNbr(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getPositionNbrTag())));
					positionDetailResult.setReportsTo(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getReportsToTag())));
					positionDetailResult.setLocation(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getPositionLocationTag())));
					positionDetailResult.setStdHrsDflt(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getNumHoursTag())));
					positionDetailResult.setBargUnit(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getBargainUnitTag())));
					positionDetailResult.setPayPlan(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getPayPlanTag())));
					positionDetailResult.setWorkSched(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getWorkScheduleTag())));
					positionDetailResult.setOrgTtlDescr(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getPositionTitleTag())));
					positionDetailResult.setDrugTestReq(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getDrugTestReqTag())));
					positionDetailResult.setSeries(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getSeriesTag())));
					positionDetailResult.setPosnSensCd(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getPositionSensCodeTag())));
					positionDetailResult.setSecurityClearance(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getSecClearanceTypeTag())));
					positionDetailResult.setEmpFinInt(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getEmpFinIntTag())));
					positionDetailResult.setGradeDflt(domObj.getNodeContent(domObj.getOnlyNode(positionDetailNode, positionDetailTags.getGradeTag())));
				}
			
				positionDetailResultList.add(positionDetailResult);
			}

		}
		
		return positionDetailResultList;

	}
		
	
	/**
	 * loads all values associated with JOBCODE_DETAIL tags 
	 */
	private List<JobCodeDetail> loadJobCodeDetail(String jobReqNbr)
	{
		JobCodeDetail jobCodeDetailResult = null;
		List<JobCodeDetail> jobCodeDetailResultList = new ArrayList<JobCodeDetail>();
		NodeList jobCodeDetailNodes = domObj.getNodeList(jobcodeDetailTags.getJobcodeDetailTag());
		if ((jobCodeDetailNodes != null) && (jobCodeDetailNodes.getLength() > 0))
		{
			for (int i = 0; i < jobCodeDetailNodes.getLength(); i++)
			{				
				Node jobCodeDetailNode = jobCodeDetailNodes.item(i);
				
				if (jobCodeDetailNode != null) {
				
					jobCodeDetailResult = new JobCodeDetail();
					
					jobCodeDetailResult.setJobReqNbr(jobReqNbr);
					jobCodeDetailResult.setSalAdminPlan(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getSalAdminPlanTag())));
					jobCodeDetailResult.setJobCode(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getJobCodeTag())));
					jobCodeDetailResult.setGrade(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getGradeTag())));
					jobCodeDetailResult.setPayPlan(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getPayPlanTag())));
					jobCodeDetailResult.setSeries(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getSeriesTag())));
					jobCodeDetailResult.setOfficialDescr(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getOfficialDescrTag())));
					jobCodeDetailResult.setExecFinDiscl(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getFinDisclReqTag())));
					jobCodeDetailResult.setTargetGrade(domObj.getNodeContent(domObj.getOnlyNode(jobCodeDetailNode, jobcodeDetailTags.getTargetGradeTag())));

				}
				
				jobCodeDetailResultList.add(jobCodeDetailResult);
			}

		}
		
		return jobCodeDetailResultList;

	}

	/**
	 * loads all values associated with SALARY_DETAIL tags 
	 */
	private List<SalaryDetail> loadSalaryDetail(String jobReqNbr)
	{
		SalaryDetail salaryDetailResult = null;
		List<SalaryDetail> salaryDetailResultList = new ArrayList<SalaryDetail>();
		NodeList salaryDetailNodes = domObj.getNodeList(salaryDetailTags.getSalaryDetailTag());
		if ((salaryDetailNodes != null) && (salaryDetailNodes.getLength() > 0))
		{
			for (int i = 0; i < salaryDetailNodes.getLength(); i++)
			{				
				Node salaryDetailNode = salaryDetailNodes.item(i);
				
				if (salaryDetailNode != null) {
				
					salaryDetailResult = new SalaryDetail();
					
					salaryDetailResult.setJobReqNbr(jobReqNbr);
					salaryDetailResult.setJobCode(domObj.getNodeContent(domObj.getOnlyNode(salaryDetailNode, salaryDetailTags.getJobCodeTag())));
					salaryDetailResult.setMinSalary(domObj.getNodeContent(domObj.getOnlyNode(salaryDetailNode, salaryDetailTags.getSalaryMinTag())));
					salaryDetailResult.setMaxSalary(domObj.getNodeContent(domObj.getOnlyNode(salaryDetailNode, salaryDetailTags.getSalaryMaxTag())));
				}
				
				salaryDetailResultList.add(salaryDetailResult);
			}

		}
		
		return salaryDetailResultList;

	}
	
	/**
	 * loads all values associated with POSITION_DEPARTMENT_HIERARCHY tags 
	 */
	private List<PositionDeptHierarchy> loadPosDeptHierarchy(String jobReqNbr)
	{
		PositionDeptHierarchy posDeptHierarchyResult = null;
		List<PositionDeptHierarchy> posDeptHierarchyResultList = new ArrayList<PositionDeptHierarchy>();
		NodeList posDeptHierarchyNodes = domObj.getNodeList(posDeptHierarchyTags.getDeptHierarchyTag());
		if ((posDeptHierarchyNodes != null) && (posDeptHierarchyNodes.getLength() > 0))
		{
			for (int i = 0; i < posDeptHierarchyNodes.getLength(); i++)
			{				
				Node posDeptHierarchyNode = posDeptHierarchyNodes.item(i);
				
				if (posDeptHierarchyNode != null) {
				
					posDeptHierarchyResult = new PositionDeptHierarchy();
					
					posDeptHierarchyResult.setJobReqNbr(jobReqNbr);
					posDeptHierarchyResult.setPositionNbr(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getPositionNbrTag())));
					posDeptHierarchyResult.setSetId(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getSetIdTag())));
					posDeptHierarchyResult.setDeptId(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptIdTag())));
					posDeptHierarchyResult.setDescr(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptDescTag())));
					posDeptHierarchyResult.setParLine2(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptId2Tag())));
					posDeptHierarchyResult.setParDescr2(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptDesc2Tag())));
					posDeptHierarchyResult.setParLine3(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptId3Tag())));
					posDeptHierarchyResult.setParDescr3(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptDesc3Tag())));
					posDeptHierarchyResult.setParLine4(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptId4Tag())));
					posDeptHierarchyResult.setParDescr4(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptDesc4Tag())));
					posDeptHierarchyResult.setParLine5(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptId5Tag())));
					posDeptHierarchyResult.setParDescr5(domObj.getNodeContent(domObj.getOnlyNode(posDeptHierarchyNode, posDeptHierarchyTags.getDeptDesc5Tag())));
				}
				
				posDeptHierarchyResultList.add(posDeptHierarchyResult);
			}

		}
		
		return posDeptHierarchyResultList;

	}

}

package gov.hhs.ehrp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import gov.hhs.ehrp.model.Approvals;
import gov.hhs.ehrp.model.Candidates;
import gov.hhs.ehrp.model.DepartmentHierarchy;
import gov.hhs.ehrp.model.EmployeeReplacement;
import gov.hhs.ehrp.model.EwitsDetails;
import gov.hhs.ehrp.model.JobCodeDetail;
import gov.hhs.ehrp.model.JobCodes;
import gov.hhs.ehrp.model.Openings;
import gov.hhs.ehrp.model.PositionDeptHierarchy;
import gov.hhs.ehrp.model.PositionDetail;
import gov.hhs.ehrp.model.Positions;
import gov.hhs.ehrp.model.RequisitionDetail;
import gov.hhs.ehrp.model.SalaryDetail;

@Component
public class DataProcessor {
	/*
	 * processData- processes the EHRP data with business rules
	 */
	public void processData(List <RequisitionDetail> reqDetailList, 
							List<JobCodes> jobCodeList,
							List<Positions> positionsList, 
							List<Openings> openingsList, 
							List<Candidates> candidatesList, 
							List<DepartmentHierarchy> deptList, 
							List<Approvals> approvalsList, 
							List<EwitsDetails> ewitsDtlList, 
							List<EmployeeReplacement> empRplList, 
							List<PositionDetail> positionDtlList,
							List<JobCodeDetail> jobcodeDtlList,
							List<SalaryDetail> salaryDtlList,
							List<PositionDeptHierarchy> positionDeptList) {

		EHRPXMLImportTasklet fileTasklet = new EHRPXMLImportTasklet();

		fileTasklet.setProcessedData(processReqDtl(reqDetailList),
									 processJobCodes(jobCodeList),
									 processPositions(positionsList),
									 processOpenings(openingsList),
									 processCandiates(candidatesList),
									 processDept(deptList),
									 processApprovals(approvalsList),
									 processEwitsDtl(ewitsDtlList),
									 processEmplRpl(empRplList),
									 processPositionDtl(positionDtlList),
									 processJobCodeDtl(jobcodeDtlList),
									 processSalaryDtl(salaryDtlList),
									 processPosDept(positionDeptList));	
	}
	
	/*
	 * processReqDtl- Processes the Requisition Detail Data
	 */
	public List <RequisitionDetail> processReqDtl(List <RequisitionDetail> reqDtlList) {
		RequisitionDetail newReqDtl = null;
		List<RequisitionDetail> reqDtlFnlList = new ArrayList<RequisitionDetail>();

		for(RequisitionDetail reqDtl: reqDtlList) {
			if(!EHRPFileUtil.isNull(reqDtl.getJobReqNbr())) {
				newReqDtl = new RequisitionDetail();

				newReqDtl.setJobReqNbr(reqDtl.getJobReqNbr());
				newReqDtl.setOriginatorId(reqDtl.getOriginatorId());
				newReqDtl.setOpenDt(reqDtl.getOpenDt());
				newReqDtl.setJobReqStatus(reqDtl.getJobReqStatus());
				newReqDtl.setBusinessUnit(reqDtl.getBusinessUnit());
				newReqDtl.setDeptId(reqDtl.getDeptId());
				newReqDtl.setGvtRecrOffice(reqDtl.getGvtRecrOffice());
				newReqDtl.setHeApprovalOprid(reqDtl.getHeApprovalOprid());
				newReqDtl.setGvtSelOfficial(reqDtl.getGvtSelOfficial());
				newReqDtl.setStatusDt(reqDtl.getStatusDt());
				newReqDtl.setOpeningsTarget(reqDtl.getOpeningsTarget());
				newReqDtl.setSetIdDept(reqDtl.getSetIdDept());
				newReqDtl.setCompany(reqDtl.getCompany());
				newReqDtl.setJobcode(reqDtl.getJobcode());
				newReqDtl.setPositionNbr(reqDtl.getPositionNbr());
				newReqDtl.setLocation(reqDtl.getLocation());
				newReqDtl.setPostingTitle(reqDtl.getPostingTitle());
				newReqDtl.setDesiredStartDt(reqDtl.getDesiredStartDt());
				newReqDtl.setAuthorizationDt(reqDtl.getAuthorizationDt());
				newReqDtl.setCountry(reqDtl.getCountry());
				newReqDtl.setGvtStaffSpclst(reqDtl.getGvtStaffSpclst());
				newReqDtl.setGvtConsiderArea(reqDtl.getGvtConsiderArea());
				newReqDtl.setGvtRqsnType(reqDtl.getGvtRqsnType());
				newReqDtl.setInitiatorOprid(reqDtl.getInitiatorOprid());
				newReqDtl.setComments(reqDtl.getComments());
			}
			if (newReqDtl != null) {
				reqDtlFnlList.add(newReqDtl);
			}
		}

		return reqDtlFnlList;
	}
	
	/*
	 * processJobCodes- Processes the Job Codes Data
	 */
	public List<JobCodes> processJobCodes(List<JobCodes> jobCodeList) {
		List<JobCodes> jobCodeFnlList = new ArrayList<JobCodes>();
		JobCodes newJobCode = null;

		for(JobCodes jobCode: jobCodeList) {
			if(!EHRPFileUtil.isNull(jobCode.getJobCode())) {
				newJobCode = new JobCodes();
				
				newJobCode.setJobReqNbr(jobCode.getJobReqNbr());
				newJobCode.setJobCode(jobCode.getJobCode());
				newJobCode.setPrimaryJobCode(jobCode.getPrimaryJobCode());
				newJobCode.setRegRegion(jobCode.getRegRegion());
				newJobCode.setDesiredFullPart(jobCode.getDesiredFullPart());
				newJobCode.setDesiredRegTemp(jobCode.getDesiredRegTemp());
				newJobCode.setStdHrs(jobCode.getStdHrs());
				newJobCode.setStdHrsFreq(jobCode.getStdHrsFreq());
				newJobCode.setDesiredShift(jobCode.getDesiredShift());
				newJobCode.setGvtRqsnSalFrom(jobCode.getGvtRqsnSalFrom());
				newJobCode.setGvtRqsnSalTo(jobCode.getGvtRqsnSalTo());
				newJobCode.setPayFreqAbbrev(jobCode.getPayFreqAbbrev());
				newJobCode.setCurrencyCd(jobCode.getCurrencyCd());
				newJobCode.setSalAdminPlan(jobCode.getSalAdminPlan());
				newJobCode.setGrade(jobCode.getGrade());
				newJobCode.setTravelPct(jobCode.getTravelPct());
				newJobCode.setManagerLvl(jobCode.getManagerLvl());
				newJobCode.setFlsaStatus(jobCode.getFlsaStatus());
				newJobCode.setSummerAppt(jobCode.getSummerAppt());
				newJobCode.setNteDate(jobCode.getNteDate());
				newJobCode.setNteDays(jobCode.getNteDays());
				newJobCode.setLeoPosition(jobCode.getLeoPosition());
				newJobCode.setPosnSensCd(jobCode.getPosnSensCd());
				newJobCode.setTypeOfAppt(jobCode.getTypeOfAppt());
			}
			if (newJobCode!= null) {
				jobCodeFnlList.add(newJobCode);
			}
		}

		return jobCodeFnlList;
		
	}
	
	/*
	 * processPositions- Processes the Position Data
	 */
	public List<Positions> processPositions(List<Positions> positionsList) {
		List<Positions> positionsFnlList = new ArrayList<Positions>();
		Positions newPosition = null;

		for(Positions pos: positionsList) {
			if(!EHRPFileUtil.isNull(pos.getPositionNbr())) {
				newPosition = new Positions();
				
				newPosition.setJobReqNbr(pos.getJobReqNbr());
				newPosition.setPositionNbr(pos.getPositionNbr());
				newPosition.setPrimaryPositionFlag(pos.getPrimaryPositionFlag());

			}
			if (newPosition!= null) {
				positionsFnlList.add(newPosition);
			}
		}
		return positionsFnlList;		
	}
	
	
	/*
	 * processOpenings- Processes the Opening (Location) Data
	 */
	public List<Openings> processOpenings(List<Openings> openingsList) {
		List<Openings> openingsFnlList = new ArrayList<Openings>();
		Openings newOpening = null;

		for(Openings opening: openingsList) {
			if(!EHRPFileUtil.isNull(opening.getLocation())) {
				newOpening = new Openings();
				
				newOpening.setJobReqNbr(opening.getJobReqNbr());
				newOpening.setLocation(opening.getLocation());
				newOpening.setPrimaryLocationFlag(opening.getPrimaryLocationFlag());
				newOpening.setDescr(opening.getDescr());

			}
			if (newOpening!= null) {
				openingsFnlList.add(newOpening);
			}
		}
		return openingsFnlList;		
	}
	
	/*
	 * processCandiates- Processes the Candidate Name data
	 */
	public List<Candidates> processCandiates(List<Candidates> candidatesList) {
		List<Candidates> candidatesFnlList = new ArrayList<Candidates>();
		Candidates newCandidate = null;

		for(Candidates candidate: candidatesList) {
			if(!EHRPFileUtil.isNull(candidate.getName())) {
				newCandidate = new Candidates();
				
				newCandidate.setJobReqNbr(candidate.getJobReqNbr());
				newCandidate.setSequenceNbr(candidate.getSequenceNbr());
				newCandidate.setName(candidate.getName());

			}
			if (newCandidate!= null) {
				candidatesFnlList.add(newCandidate);
			}
		}
		return candidatesFnlList;		
	}
	
	/*
	 * processDept- Processes the Department Hierarchy data
	 */
	public List<DepartmentHierarchy> processDept(List<DepartmentHierarchy> deptList) {
		List<DepartmentHierarchy> deptFnlList = new ArrayList<DepartmentHierarchy>();
		DepartmentHierarchy newDept = null;

		for(DepartmentHierarchy dept: deptList) {
			if(!EHRPFileUtil.isNull(dept.getDeptId())) {
				newDept = new DepartmentHierarchy();
				
				newDept.setJobReqNbr(dept.getJobReqNbr());
				newDept.setSetId(dept.getSetId());
				newDept.setDeptId(dept.getDeptId());
				newDept.setDescr(dept.getDescr());
				newDept.setParLine2(dept.getParLine2());
				newDept.setParDescr2(dept.getParDescr2());
				newDept.setParLine3(dept.getParLine3());
				newDept.setParDescr3(dept.getParDescr3());
				newDept.setParLine4(dept.getParLine4());
				newDept.setParDescr4(dept.getParDescr4());
				newDept.setParLine5(dept.getParLine5());
				newDept.setParDescr5(dept.getParDescr5());
			}
			if (newDept!= null) {
				deptFnlList.add(newDept);
			}
		}
		return deptFnlList;		
	}
	
	/*
	 * processApprovals- Processes the Approval Comments data
	 */
	public List<Approvals> processApprovals(List<Approvals> approvalList) {
	
		return approvalList;		
	}
	
	/*
	 * processEwitsDtl- Processes the EWiTs Details data
	 */
	public List<EwitsDetails> processEwitsDtl(List<EwitsDetails> ewitsDtlList) {
		
		return ewitsDtlList;		
	}

	/*
	 * processEmplRpl- Processes the Employee Replacement data
	 */
	public List<EmployeeReplacement> processEmplRpl(List<EmployeeReplacement> empRplList) {
		List<EmployeeReplacement> empRplFnlList = new ArrayList<EmployeeReplacement>();
		EmployeeReplacement newEmpRpl = null;

		for(EmployeeReplacement empRpl: empRplList) {
			if(!EHRPFileUtil.isNull(empRpl.getViceEmplid())) {
				newEmpRpl = new EmployeeReplacement();
				
				newEmpRpl.setJobReqNbr(empRpl.getJobReqNbr());
				newEmpRpl.setViceEmplid(empRpl.getViceEmplid());
				newEmpRpl.setDateVacated(empRpl.getDateVacated());
				newEmpRpl.setViceName(empRpl.getViceName());
			}
			if (newEmpRpl!= null) {
				empRplFnlList.add(newEmpRpl);
			}
		}
		return empRplFnlList;		
	}
	
	/*
	 * processPositionDtl- Processes the Position Detail Data
	 */
	public List<PositionDetail> processPositionDtl(List<PositionDetail> positionDtlList) {
		List<PositionDetail> posDtlFnlLst = new ArrayList<PositionDetail>();
		PositionDetail newPosDtl = null;

		for(PositionDetail posDtl: positionDtlList) {
			if(!EHRPFileUtil.isNull(posDtl.getPositionNbr())) {
				newPosDtl = new PositionDetail();
				
				newPosDtl.setJobReqNbr(posDtl.getJobReqNbr());
				newPosDtl.setPositionNbr(posDtl.getPositionNbr());
				newPosDtl.setReportsTo(posDtl.getReportsTo());
				newPosDtl.setLocation(posDtl.getLocation());
				newPosDtl.setStdHrsDflt(posDtl.getStdHrsDflt());
				newPosDtl.setBargUnit(posDtl.getBargUnit());
				newPosDtl.setPayPlan(posDtl.getPayPlan());
				newPosDtl.setWorkSched(posDtl.getWorkSched());
				newPosDtl.setOrgTtlDescr(posDtl.getOrgTtlDescr());
				newPosDtl.setDrugTestReq(posDtl.getDrugTestReq());
				newPosDtl.setSeries(posDtl.getSeries());
				newPosDtl.setPosnSensCd(posDtl.getPosnSensCd());
				newPosDtl.setSecurityClearance(posDtl.getSecurityClearance());
				newPosDtl.setEmpFinInt(posDtl.getEmpFinInt());
				newPosDtl.setGradeDflt(posDtl.getGradeDflt());
			}
			if (newPosDtl!= null) {
				posDtlFnlLst.add(newPosDtl);
			}
		}
		return posDtlFnlLst;
	}
	

	
	/*
	 * processJobCodeDtl- Processes the JobCode Detail data
	 */
	public List<JobCodeDetail> processJobCodeDtl(List<JobCodeDetail> jobcodeDtlList) {
		List<JobCodeDetail> jobCodeDtlFnlLst = new ArrayList<JobCodeDetail>();
		JobCodeDetail newjobCodeDtl = null;

		for(JobCodeDetail jobCodeDtl: jobcodeDtlList) {
			if(!EHRPFileUtil.isNull(jobCodeDtl.getJobCode())) {
				newjobCodeDtl = new JobCodeDetail();
				
				newjobCodeDtl.setJobReqNbr(jobCodeDtl.getJobReqNbr());
				newjobCodeDtl.setJobCode(jobCodeDtl.getJobCode());
				newjobCodeDtl.setSalAdminPlan(jobCodeDtl.getSalAdminPlan());
				newjobCodeDtl.setGrade(jobCodeDtl.getGrade());
				newjobCodeDtl.setPayPlan(jobCodeDtl.getPayPlan());
				newjobCodeDtl.setSeries(jobCodeDtl.getSeries());
				newjobCodeDtl.setOfficialDescr(jobCodeDtl.getOfficialDescr());
				newjobCodeDtl.setExecFinDiscl(jobCodeDtl.getExecFinDiscl());
				newjobCodeDtl.setTargetGrade(jobCodeDtl.getTargetGrade());
			}
			if (newjobCodeDtl!= null) {
				jobCodeDtlFnlLst.add(newjobCodeDtl);
			}
		}
		return jobCodeDtlFnlLst;		
	}
	
	/*
	 * processSalaryDtl- Processes the Salary Detail data
	 */
	public List<SalaryDetail> processSalaryDtl(List<SalaryDetail> salaryDtlList) {
		List<SalaryDetail> salaryDtlFnlLst = new ArrayList<SalaryDetail>();
		SalaryDetail newSalaryDtl = null;

		for(SalaryDetail salaryDtl: salaryDtlList) {
			if(!EHRPFileUtil.isNull(salaryDtl.getJobCode())) {
				newSalaryDtl = new SalaryDetail();
				
				newSalaryDtl.setJobReqNbr(salaryDtl.getJobReqNbr());
				newSalaryDtl.setJobCode(salaryDtl.getJobCode());
				newSalaryDtl.setMinSalary(salaryDtl.getMinSalary());
				newSalaryDtl.setMaxSalary(salaryDtl.getMaxSalary());
			}
			if (newSalaryDtl!= null) {
				salaryDtlFnlLst.add(newSalaryDtl);
			}
		}
		return salaryDtlFnlLst;		
	}
	
	/*
	 * processPosDept- Processes the Position Department Hierarchy data
	 */
	public List<PositionDeptHierarchy> processPosDept(List<PositionDeptHierarchy> positionDeptList) {
		List<PositionDeptHierarchy> deptFnlList = new ArrayList<PositionDeptHierarchy>();
		PositionDeptHierarchy newDept = null;

		for(PositionDeptHierarchy dept: positionDeptList) {
			if(!EHRPFileUtil.isNull(dept.getPositionNbr())) {
				newDept = new PositionDeptHierarchy();
				
				newDept.setJobReqNbr(dept.getJobReqNbr());
				newDept.setPositionNbr(dept.getPositionNbr());
				newDept.setSetId(dept.getSetId());
				newDept.setDeptId(dept.getDeptId());
				newDept.setDescr(dept.getDescr());
				newDept.setParLine2(dept.getParLine2());
				newDept.setParDescr2(dept.getParDescr2());
				newDept.setParLine3(dept.getParLine3());
				newDept.setParDescr3(dept.getParDescr3());
				newDept.setParLine4(dept.getParLine4());
				newDept.setParDescr4(dept.getParDescr4());
				newDept.setParLine5(dept.getParLine5());
				newDept.setParDescr5(dept.getParDescr5());
			}
			if (newDept!=null) {
				deptFnlList.add(newDept);
			}
		}
		return deptFnlList;		
	}
	
}

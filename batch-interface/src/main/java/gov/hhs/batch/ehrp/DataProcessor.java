package gov.hhs.batch.ehrp;

import java.util.ArrayList;
import java.util.List;

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
		List<String> uniqueKey = new ArrayList<String>();

		for(RequisitionDetail reqDtl: reqDtlList) {
			if(!EHRPFileUtil.isNull(reqDtl.getJobReqNbr())) {
				if (!uniqueKey.contains(reqDtl.getJobReqNbr())) {
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
					
					uniqueKey.add(reqDtl.getJobReqNbr());	
				}
			}
			if (newReqDtl != null) {
				reqDtlFnlList.add(newReqDtl);
			}
			
			newReqDtl = null;
		}

		return reqDtlFnlList;
	}
	
	/*
	 * processJobCodes- Processes the Job Codes Data
	 */
	public List<JobCodes> processJobCodes(List<JobCodes> jobCodeList) {
		List<JobCodes> jobCodeFnlList = new ArrayList<JobCodes>();
		List<String> uniqueKey = new ArrayList<String>();
		JobCodes newJobCode = null;

		for(JobCodes jobCode: jobCodeList) {
			if(!EHRPFileUtil.isNull(jobCode.getJobCode())) {
				if (!uniqueKey.contains(jobCode.getJobReqNbr() + jobCode.getJobCode())) {
					
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
					
					uniqueKey.add(jobCode.getJobReqNbr() + jobCode.getJobCode());
				}				
			}
			
			if (newJobCode!= null) {
				jobCodeFnlList.add(newJobCode);
			}
			
			newJobCode = null;
		}

		return jobCodeFnlList;
		
	}
	
	/*
	 * processPositions- Processes the Position Data
	 */
	public List<Positions> processPositions(List<Positions> positionsList) {
		List<Positions> positionsFnlList = new ArrayList<Positions>();
		List<String> uniqueKey = new ArrayList<String>();
		Positions newPosition = null;

		for(Positions pos: positionsList) {
			if(!EHRPFileUtil.isNull(pos.getPositionNbr())) {
				if (!uniqueKey.contains(pos.getJobReqNbr() + pos.getPositionNbr())) {
				
					newPosition = new Positions();
					
					newPosition.setJobReqNbr(pos.getJobReqNbr());
					newPosition.setPositionNbr(pos.getPositionNbr());
					newPosition.setPrimaryPositionFlag(pos.getPrimaryPositionFlag());
					
					uniqueKey.add(pos.getJobReqNbr() + pos.getPositionNbr());
				}
			}
			if (newPosition!= null) {
				positionsFnlList.add(newPosition);
			}
			
			newPosition = null;
		}
		return positionsFnlList;		
	}
	
	
	/*
	 * processOpenings- Processes the Opening (Location) Data
	 */
	public List<Openings> processOpenings(List<Openings> openingsList) {
		List<Openings> openingsFnlList = new ArrayList<Openings>();
		List<String> uniqueKey = new ArrayList<String>();
		Openings newOpening = null;

		for(Openings opening: openingsList) {
			if(!EHRPFileUtil.isNull(opening.getLocation())) {
				if (!uniqueKey.contains(opening.getJobReqNbr() + opening.getLocation())) {
				
					newOpening = new Openings();
					
					newOpening.setJobReqNbr(opening.getJobReqNbr());
					newOpening.setLocation(opening.getLocation());
					newOpening.setPrimaryLocationFlag(opening.getPrimaryLocationFlag());
					newOpening.setDescr(opening.getDescr());
					
					uniqueKey.add(opening.getJobReqNbr() + opening.getLocation());
				}

			}
			if (newOpening!= null) {
				openingsFnlList.add(newOpening);
			}
			
			newOpening = null;
		}
		return openingsFnlList;		
	}
	
	/*
	 * processCandiates- Processes the Candidate Name data
	 */
	public List<Candidates> processCandiates(List<Candidates> candidatesList) {
		List<Candidates> candidatesFnlList = new ArrayList<Candidates>();
		List<String> uniqueKey = new ArrayList<String>();
		Candidates newCandidate = null;

		for(Candidates candidate: candidatesList) {
			if(!EHRPFileUtil.isNull(candidate.getName())) {
				if (!uniqueKey.contains(candidate.getJobReqNbr() + candidate.getSequenceNbr())) {
				
					newCandidate = new Candidates();
					
					newCandidate.setJobReqNbr(candidate.getJobReqNbr());
					newCandidate.setSequenceNbr(candidate.getSequenceNbr());
					newCandidate.setName(candidate.getName());
					
					uniqueKey.add(candidate.getJobReqNbr() + candidate.getSequenceNbr());
				}
			}
			if (newCandidate!= null) {
				candidatesFnlList.add(newCandidate);
			}
			
			newCandidate = null;
		}
		return candidatesFnlList;		
	}
	
	/*
	 * processDept- Processes the Department Hierarchy data
	 */
	public List<DepartmentHierarchy> processDept(List<DepartmentHierarchy> deptList) {
		List<DepartmentHierarchy> deptFnlList = new ArrayList<DepartmentHierarchy>();
		List<String> uniqueKey = new ArrayList<String>();
		DepartmentHierarchy newDept = null;

		for(DepartmentHierarchy dept: deptList) {
			if(!EHRPFileUtil.isNull(dept.getDeptId())) {
				if (!uniqueKey.contains(dept.getJobReqNbr())) {
					
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
					
					uniqueKey.add(dept.getJobReqNbr());	
				}
			}
			if (newDept!= null) {
				deptFnlList.add(newDept);
			}
			
			newDept = null;
		}
		return deptFnlList;		
	}
	
	/*
	 * processApprovals- Processes the Approval Comments data
	 */
	public List<Approvals> processApprovals(List<Approvals> approvalList) {
		List<Approvals> apprvlFnlList = new ArrayList<Approvals>();
		List<String> uniqueKey = new ArrayList<String>();
		Approvals newApproval = null;

		for(Approvals apprvl: approvalList) {
			if(!EHRPFileUtil.isNull(apprvl.getStep())) {
				if (!uniqueKey.contains(apprvl.getJobReqNbr() + apprvl.getStep())) {
					
					newApproval = new Approvals();
					
					newApproval.setJobReqNbr(apprvl.getJobReqNbr());
					newApproval.setStep(apprvl.getStep());
					newApproval.setStatus(apprvl.getStatus());
					newApproval.setStatusDt(apprvl.getStatusDt());
					newApproval.setOprid(apprvl.getOprid());
					newApproval.setEmplid(apprvl.getEmplid());
					newApproval.setComments(apprvl.getComments());
					
					uniqueKey.add(apprvl.getJobReqNbr() + apprvl.getStep());	
				}
			}
			if (newApproval!= null) {
				apprvlFnlList.add(newApproval);
			}
			
			newApproval = null;
		}
		return apprvlFnlList;			
	}
	
	/*
	 * processEwitsDtl- Processes the EWiTs Details data
	 */
	public List<EwitsDetails> processEwitsDtl(List<EwitsDetails> ewitsDtlList) {
		List<EwitsDetails> ewitsDtlFnlList = new ArrayList<EwitsDetails>();
		List<String> uniqueKey = new ArrayList<String>();
		EwitsDetails newEwitsDtl = null;

		for(EwitsDetails ewitDtl: ewitsDtlList) {
			if (!uniqueKey.contains(ewitDtl.getJobReqNbr())) {
					
				newEwitsDtl = new EwitsDetails();
					
				newEwitsDtl.setJobReqNbr(ewitDtl.getJobReqNbr());
				newEwitsDtl.setPhysCompAllowance(ewitDtl.getPhysCompAllowance());
				newEwitsDtl.setPhysDentistPay(ewitDtl.getPhysDentistPay());
				newEwitsDtl.setNonStandardPay(ewitDtl.getNonStandardPay());
				newEwitsDtl.setPositionDescr(ewitDtl.getPositionDescr());
				newEwitsDtl.setRecruitmentIncentive(ewitDtl.getRecruitmentIncentive());
				newEwitsDtl.setRelocationIncentive(ewitDtl.getRelocationIncentive());
				newEwitsDtl.setCan(ewitDtl.getCan());
					
				uniqueKey.add(ewitDtl.getJobReqNbr());	
			}
			
			if (newEwitsDtl!= null) {
				ewitsDtlFnlList.add(newEwitsDtl);
			}
			
			newEwitsDtl = null;
		}
			
		return ewitsDtlFnlList;		
	}

	/*
	 * processEmplRpl- Processes the Employee Replacement data
	 */
	public List<EmployeeReplacement> processEmplRpl(List<EmployeeReplacement> empRplList) {
		List<EmployeeReplacement> empRplFnlList = new ArrayList<EmployeeReplacement>();
		List<String> uniqueKey = new ArrayList<String>();
		EmployeeReplacement newEmpRpl = null;

		for(EmployeeReplacement empRpl: empRplList) {
			if(!EHRPFileUtil.isNull(empRpl.getViceEmplid())) {
				if (!uniqueKey.contains(empRpl.getJobReqNbr() + empRpl.getViceEmplid())) {
					
					newEmpRpl = new EmployeeReplacement();
					
					newEmpRpl.setJobReqNbr(empRpl.getJobReqNbr());
					newEmpRpl.setViceEmplid(empRpl.getViceEmplid());
					newEmpRpl.setDateVacated(empRpl.getDateVacated());
					newEmpRpl.setViceName(empRpl.getViceName());
					
					uniqueKey.add(empRpl.getJobReqNbr() + empRpl.getViceEmplid());	
				}
			}
			if (newEmpRpl!= null) {
				empRplFnlList.add(newEmpRpl);
			}
			
			newEmpRpl = null;
		}
		return empRplFnlList;		
	}
	
	/*
	 * processPositionDtl- Processes the Position Detail Data
	 */
	public List<PositionDetail> processPositionDtl(List<PositionDetail> positionDtlList) {
		List<PositionDetail> posDtlFnlLst = new ArrayList<PositionDetail>();
		List<String> uniqueKey = new ArrayList<String>();
		PositionDetail newPosDtl = null;

		for(PositionDetail posDtl: positionDtlList) {
			if(!EHRPFileUtil.isNull(posDtl.getPositionNbr())) {
				if (!uniqueKey.contains(posDtl.getJobReqNbr() + posDtl.getPositionNbr())) {
					
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
					
					uniqueKey.add(posDtl.getJobReqNbr() + posDtl.getPositionNbr());	
				}
			}
			if (newPosDtl!= null) {
				posDtlFnlLst.add(newPosDtl);
			}
			
			newPosDtl = null;
		}
		return posDtlFnlLst;
	}
	

	
	/*
	 * processJobCodeDtl- Processes the JobCode Detail data
	 */
	public List<JobCodeDetail> processJobCodeDtl(List<JobCodeDetail> jobcodeDtlList) {
		List<JobCodeDetail> jobCodeDtlFnlLst = new ArrayList<JobCodeDetail>();
		List<String> uniqueKey = new ArrayList<String>();
		JobCodeDetail newjobCodeDtl = null;

		for(JobCodeDetail jobCodeDtl: jobcodeDtlList) {
			if(!EHRPFileUtil.isNull(jobCodeDtl.getJobCode())) {
				if (!uniqueKey.contains(jobCodeDtl.getJobReqNbr() + jobCodeDtl.getJobCode())) {
					
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
					
					uniqueKey.add(jobCodeDtl.getJobReqNbr() + jobCodeDtl.getJobCode());	
				}
			}
			if (newjobCodeDtl!= null) {
				jobCodeDtlFnlLst.add(newjobCodeDtl);
			}
			
			newjobCodeDtl = null;
		}
		return jobCodeDtlFnlLst;		
	}
	
	/*
	 * processSalaryDtl- Processes the Salary Detail data
	 */
	public List<SalaryDetail> processSalaryDtl(List<SalaryDetail> salaryDtlList) {
		List<SalaryDetail> salaryDtlFnlLst = new ArrayList<SalaryDetail>();
		List<String> uniqueKey = new ArrayList<String>();
		SalaryDetail newSalaryDtl = null;

		for(SalaryDetail salaryDtl: salaryDtlList) {
			if((!EHRPFileUtil.isNull(salaryDtl.getJobCode())) && ((!EHRPFileUtil.isNull(salaryDtl.getMinSalary())) || (!EHRPFileUtil.isNull(salaryDtl.getMaxSalary())))) {
				if (!uniqueKey.contains(salaryDtl.getJobReqNbr() + salaryDtl.getJobCode())) {
					newSalaryDtl = new SalaryDetail();
					
					newSalaryDtl.setJobReqNbr(salaryDtl.getJobReqNbr());
					newSalaryDtl.setJobCode(salaryDtl.getJobCode());
					newSalaryDtl.setMinSalary(salaryDtl.getMinSalary());
					newSalaryDtl.setMaxSalary(salaryDtl.getMaxSalary());
					
					uniqueKey.add(salaryDtl.getJobReqNbr() + salaryDtl.getJobCode());	
				}
			}
			if (newSalaryDtl!= null) {
				salaryDtlFnlLst.add(newSalaryDtl);
			}
			
			newSalaryDtl = null;
		}
		return salaryDtlFnlLst;		
	}
	
	/*
	 * processPosDept- Processes the Position Department Hierarchy data
	 */
	public List<PositionDeptHierarchy> processPosDept(List<PositionDeptHierarchy> positionDeptList) {
		List<PositionDeptHierarchy> deptFnlList = new ArrayList<PositionDeptHierarchy>();
		List<String> uniqueKey = new ArrayList<String>();
		PositionDeptHierarchy newDept = null;

		for(PositionDeptHierarchy dept: positionDeptList) {
			if(!EHRPFileUtil.isNull(dept.getPositionNbr())) {
				if (!uniqueKey.contains(dept.getJobReqNbr() + dept.getPositionNbr())) {
					
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
					
					uniqueKey.add(dept.getJobReqNbr() + dept.getPositionNbr());	
				}
			}
			if (newDept!=null) {
				deptFnlList.add(newDept);
			}
			
			newDept = null;
		}
		return deptFnlList;		
	}
	
}

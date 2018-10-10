package gov.hhs.batch.ehrp;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class DBProcessor {
	
	@Autowired
	private EHRPProperties properties;
	@Autowired
	private DataSource hhsDataSource;
	
	/*
	 * selectJobOpeningNbrs - Selects existing job opening numbers
	 * and returns then in a list
	 */
	public List<String> selectJobOpeningNbrs() {
		List<String> jobOpeningNbrs;
		jobOpeningNbrs= new JdbcTemplate(hhsDataSource).queryForList(properties.getSqlSelectJobOpeningNbr(), String.class);
		return jobOpeningNbrs;
	}
	
	/*
	 * insertDataIntoDb - Inserts processed EHRP data into the database
	 */
	public void insertDataIntoDb(List <RequisitionDetail> reqDetailList, 
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
		
		if (!reqDetailList.isEmpty()) {
			insertReqDetail(reqDetailList);
		}
		if (!jobCodeList.isEmpty()) {
			insertJobCodes(jobCodeList);
		}
		if (!jobcodeDtlList.isEmpty()) {
			insertJobCodeDtl(jobcodeDtlList);
		}
		if (!positionsList.isEmpty()) {
			insertPositions(positionsList);
		}
		if (!positionDtlList.isEmpty()) {
			insertPositionDetail(positionDtlList);
		}
		if (!positionDeptList.isEmpty()) {
			insertPositionDept(positionDeptList);
		}
		if (!salaryDtlList.isEmpty()) {
			insertSalaryDtl(salaryDtlList);
		}
		if (!openingsList.isEmpty()) {
			insertOpenings(openingsList);
		}
		if (!candidatesList.isEmpty()) {
			insertCandidates(candidatesList);
		}
		if (!deptList.isEmpty()) {
			insertDept(deptList);
		}
		if (!approvalsList.isEmpty()) {
			insertApprovals(approvalsList);
		}
		if (!empRplList.isEmpty()) {
			insertEmployeeReplacement(empRplList);
		}
		if (!ewitsDtlList.isEmpty()) {
			insertEwitsDtl(ewitsDtlList);
		}
	}

	/*
	 * insertReqDetail - Inserts Requisition Detail data into the database
	 */
	public void insertReqDetail(final List<RequisitionDetail> reqDetailList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertReqDetail(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return reqDetailList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				RequisitionDetail reqDetail = reqDetailList.get(i);
				ps.setInt(1, Integer.parseInt(reqDetail.getJobReqNbr()));
				ps.setString(2, reqDetail.getOriginatorId());
				if(!EHRPFileUtil.isNull(reqDetail.getOpenDt())) {
					ps.setDate(3, java.sql.Date.valueOf(reqDetail.getOpenDt()));
				}else {
					ps.setNull(3, Types.DATE);
				}
				ps.setString(4, reqDetail.getJobReqStatus());
				ps.setString(5, reqDetail.getBusinessUnit());
				ps.setString(6, reqDetail.getDeptId());
				ps.setString(7, reqDetail.getGvtRecrOffice());
				ps.setString(8, reqDetail.getHeApprovalOprid());
				ps.setString(9, reqDetail.getGvtSelOfficial());
				if(!EHRPFileUtil.isNull(reqDetail.getStatusDt())) {
					ps.setDate(10, java.sql.Date.valueOf(reqDetail.getStatusDt()));
				}else {
					ps.setNull(10, Types.DATE);
				}
				ps.setInt(11, Integer.parseInt(reqDetail.getOpeningsTarget()));
				ps.setString(12, reqDetail.getSetIdDept());
				ps.setString(13, reqDetail.getCompany());
				ps.setString(14, reqDetail.getJobcode());
				ps.setString(15, reqDetail.getPositionNbr());
				ps.setString(16, reqDetail.getLocation());
				ps.setString(17, reqDetail.getPostingTitle());
				if(!EHRPFileUtil.isNull(reqDetail.getDesiredStartDt())) {
					ps.setDate(18, java.sql.Date.valueOf(reqDetail.getDesiredStartDt()));
				}else {
					ps.setNull(18, Types.DATE);
				}
				if(!EHRPFileUtil.isNull(reqDetail.getAuthorizationDt())) {
					ps.setDate(19, java.sql.Date.valueOf(reqDetail.getAuthorizationDt()));
				}else {
					ps.setNull(19, Types.DATE);
				}
				ps.setString(20, reqDetail.getCountry());
				ps.setString(21, reqDetail.getGvtStaffSpclst());
				ps.setString(22, reqDetail.getGvtConsiderArea());
				ps.setString(23, reqDetail.getGvtRqsnType());
				ps.setString(24, reqDetail.getInitiatorOprid());
				ps.setClob(25, new InputStreamReader(new ByteArrayInputStream(reqDetail.getComments().getBytes())));				
			}
		});
	}
	
	/*
	 * insertJobCodes - Inserts Job Code data into the database
	 */
	public void insertJobCodes(final List<JobCodes> jobCodeList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertJobcodes(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return jobCodeList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				JobCodes jobCode = jobCodeList.get(i);
					ps.setInt(1, Integer.parseInt(jobCode.getJobReqNbr()));
					ps.setString(2, jobCode.getJobCode());
					ps.setString(3, jobCode.getPrimaryJobCode());
					ps.setString(4, jobCode.getRegRegion());
					ps.setString(5, jobCode.getDesiredFullPart());
					ps.setString(6, jobCode.getDesiredRegTemp());
					ps.setInt(7, Integer.parseInt(jobCode.getStdHrs()));
					ps.setString(8, jobCode.getStdHrsFreq());
					ps.setString(9, jobCode.getDesiredShift());
					ps.setInt(10, Integer.parseInt(jobCode.getGvtRqsnSalFrom()));
					ps.setInt(11, Integer.parseInt(jobCode.getGvtRqsnSalTo()));
					ps.setString(12, jobCode.getPayFreqAbbrev());
					ps.setString(13, jobCode.getCurrencyCd());
					ps.setString(14, jobCode.getSalAdminPlan());
					ps.setString(15, jobCode.getGrade());
					ps.setString(16, jobCode.getTravelPct());
					ps.setString(17, jobCode.getManagerLvl());
					ps.setString(18, jobCode.getFlsaStatus());
					ps.setString(19, jobCode.getSummerAppt());
					if(!EHRPFileUtil.isNull(jobCode.getNteDate())) {
						ps.setDate(20, java.sql.Date.valueOf(jobCode.getNteDate()));
					}else {
						ps.setNull(20, Types.DATE);
					}
					ps.setString(21, jobCode.getNteDays());
					ps.setString(22, jobCode.getLeoPosition());
					ps.setString(23, jobCode.getPosnSensCd());
					ps.setString(24, jobCode.getTypeOfAppt());	
				}
		});
	}
	
	/*
	 * insertPositions - Inserts Position data into the database
	 */
	public void insertPositions(final List<Positions> positionsList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertPositions(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return positionsList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Positions positions = positionsList.get(i);
					ps.setInt(1, Integer.parseInt(positions.getJobReqNbr()));
					ps.setString(2, positions.getPositionNbr());
					ps.setString(3, positions.getPrimaryPositionFlag());	
				}
		});
	}
	
	/*
	 * insertOpenings - Inserts Opening (Location) data into the database
	 */
	public void insertOpenings(final List<Openings> openingsList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertOpenings(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return openingsList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Openings openings = openingsList.get(i);
					ps.setInt(1, Integer.parseInt(openings.getJobReqNbr()));
					ps.setString(2, openings.getLocation());
					ps.setString(3, openings.getPrimaryLocationFlag());
					ps.setString(4, openings.getDescr());	
				}
		});
	}
	
	/*
	 * insertCandidates - Inserts Candidate data into the database
	 */
	public void insertCandidates(final List<Candidates> candidatesList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertCandidates(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return candidatesList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Candidates candidate = candidatesList.get(i);
					ps.setInt(1, Integer.parseInt(candidate.getJobReqNbr()));
					ps.setInt(2, Integer.parseInt(candidate.getSequenceNbr()));
					ps.setString(3, candidate.getName());	
				}
		});
	}
	
	/*
	 * insertDept - Inserts Department Hierarchy data into the database
	 */
	public void insertDept(final List<DepartmentHierarchy> deptList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertDept(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return deptList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DepartmentHierarchy dept = deptList.get(i);
				ps.setInt(1, Integer.parseInt(dept.getJobReqNbr()));
				ps.setString(2, dept.getSetId());
				ps.setString(3, dept.getDeptId());
				ps.setString(4, dept.getDescr());
				ps.setString(5, dept.getParLine2());
				ps.setString(6, dept.getParDescr2());
				ps.setString(7, dept.getParLine3());
				ps.setString(8, dept.getParDescr3());
				ps.setString(9, dept.getParLine4());
				ps.setString(10, dept.getParDescr4());
				ps.setString(11, dept.getParLine5());
				ps.setString(12, dept.getParDescr5());
			}
		});
	}
	
	/*
	 * insertApprovals - Inserts Approval Comments data into the database
	 */
	public void insertApprovals(final List<Approvals> approvalsList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertApprovals(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return approvalsList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Approvals approval = approvalsList.get(i);
				ps.setInt(1, Integer.parseInt(approval.getJobReqNbr()));
				ps.setDouble(2, Double.parseDouble(approval.getStep()));
				ps.setString(3, approval.getStatus());
				if(!EHRPFileUtil.isNull(approval.getStatusDt())) {
					ps.setDate(4, java.sql.Date.valueOf(approval.getStatusDt()));
				}else {
					ps.setNull(4, Types.DATE);
				}
				ps.setString(5, approval.getOprid());
				ps.setString(6, approval.getEmplid());
				ps.setClob(7, new InputStreamReader(new ByteArrayInputStream(approval.getComments().getBytes())));	
			}
		});
	}
	
	/*
	 * insertEwitsDtl - Inserts EWiTS Detail data into the database
	 */
	public void insertEwitsDtl(final List<EwitsDetails> ewitsDtlList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertEwits(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return ewitsDtlList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				EwitsDetails ewits = ewitsDtlList.get(i);
				ps.setInt(1, Integer.parseInt(ewits.getJobReqNbr()));
				ps.setString(2, ewits.getPhysCompAllowance());
				ps.setString(3, ewits.getPhysDentistPay());
				ps.setString(4, ewits.getNonStandardPay());
				ps.setString(5, ewits.getPositionDescr());
				ps.setString(6, ewits.getRecruitmentIncentive());
				ps.setString(7, ewits.getRelocationIncentive());
				ps.setString(8, ewits.getCan());
			}
		});
	}
	
	/*
	 * insertEmployeeReplacement - Inserts Employee Replacement data into the database
	 */
	public void insertEmployeeReplacement(final List<EmployeeReplacement> empRplList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertEmplRpl(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return empRplList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				EmployeeReplacement empRpl = empRplList.get(i);
					ps.setInt(1, Integer.parseInt(empRpl.getJobReqNbr()));
					ps.setString(2, empRpl.getViceEmplid());
					if(!EHRPFileUtil.isNull(empRpl.getDateVacated())) {
						ps.setDate(3, java.sql.Date.valueOf(empRpl.getDateVacated()));
					}else {
						ps.setNull(3, Types.DATE);
					}
					ps.setString(4, empRpl.getViceName());
				}
		});
	}
	
	/*
	 * insertPositionDetail - Inserts Position Detail data into the database
	 */
	public void insertPositionDetail(final List<PositionDetail> positionDtlList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertPositionDtl(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return positionDtlList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				PositionDetail positionDtl = positionDtlList.get(i);
				ps.setInt(1, Integer.parseInt(positionDtl.getJobReqNbr()));
				ps.setString(2, positionDtl.getPositionNbr());
				ps.setString(3, positionDtl.getReportsTo());
				ps.setString(4, positionDtl.getLocation());
				ps.setDouble(5, Double.parseDouble(positionDtl.getStdHrsDflt()));
				ps.setString(6, positionDtl.getBargUnit());
				ps.setString(7, positionDtl.getPayPlan());
				ps.setString(8, positionDtl.getWorkSched());
				ps.setString(9, positionDtl.getOrgTtlDescr());
				ps.setString(10, positionDtl.getDrugTestReq());
				ps.setString(11, positionDtl.getSeries());
				ps.setString(12, positionDtl.getPosnSensCd());
				ps.setString(13, positionDtl.getSecurityClearance());
				ps.setString(14, positionDtl.getEmpFinInt());
				ps.setString(15, positionDtl.getGradeDflt());
			}
		});
	}
	
	/*
	 * insertJobCodeDtl - Inserts Job Code Detail data into the database
	 */
	public void insertJobCodeDtl(final List<JobCodeDetail> jobCodeDtlList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertJobcodeDtl(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return jobCodeDtlList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				JobCodeDetail jobCodeDtl = jobCodeDtlList.get(i);
				ps.setInt(1, Integer.parseInt(jobCodeDtl.getJobReqNbr()));
				ps.setString(2, jobCodeDtl.getJobCode());
				ps.setString(3, jobCodeDtl.getSalAdminPlan());
				ps.setString(4, jobCodeDtl.getGrade());
				ps.setString(5, jobCodeDtl.getPayPlan());
				ps.setString(6, jobCodeDtl.getSeries());
				ps.setString(7, jobCodeDtl.getOfficialDescr());
				ps.setString(8, jobCodeDtl.getExecFinDiscl());
				ps.setString(9, jobCodeDtl.getTargetGrade());
			}
		});
	}
	
	/*
	 * insertSalaryDtl - Inserts Salary Detail data into the database
	 */
	public void insertSalaryDtl(final List<SalaryDetail> salaryDtlList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertSalaryDtl(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return salaryDtlList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				SalaryDetail salaryDtl = salaryDtlList.get(i);
				ps.setInt(1, Integer.parseInt(salaryDtl.getJobReqNbr()));
				ps.setString(2, salaryDtl.getJobCode());
				ps.setDouble(3, Double.parseDouble(salaryDtl.getMinSalary()));
				ps.setDouble(4, Double.parseDouble(salaryDtl.getMaxSalary()));
			}
		});
	}
	
	/*
	 * insertPositionDept - Inserts Position Department Hierarchy data into the database
	 */
	public void insertPositionDept(final List<PositionDeptHierarchy> positionDeptList) {
		new JdbcTemplate(hhsDataSource).batchUpdate(properties.getSqlInsertPositionDept(), new BatchPreparedStatementSetter() {
			@Override
			public int getBatchSize() {
				return positionDeptList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				PositionDeptHierarchy positionDept = positionDeptList.get(i);
				ps.setInt(1, Integer.parseInt(positionDept.getJobReqNbr()));
				ps.setString(2, positionDept.getPositionNbr());
				ps.setString(3, positionDept.getSetId());
				ps.setString(4, positionDept.getDeptId());
				ps.setString(5, positionDept.getDescr());
				ps.setString(6, positionDept.getParLine2());
				ps.setString(7, positionDept.getParDescr2());
				ps.setString(8, positionDept.getParLine3());
				ps.setString(9, positionDept.getParDescr3());
				ps.setString(10, positionDept.getParLine4());
				ps.setString(11, positionDept.getParDescr4());
				ps.setString(12, positionDept.getParLine5());
				ps.setString(13, positionDept.getParDescr5());
			}
		});
	}
}

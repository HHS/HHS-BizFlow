package gov.hhs.usas.rest.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.report.model.CdcRecruitment.ApplicantDates;
import gov.hhs.usas.rest.report.model.CdcRecruitment.ApplicantInfoResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.ApplicantTotal;
import gov.hhs.usas.rest.report.model.CdcRecruitment.Applicants;
import gov.hhs.usas.rest.report.model.CdcRecruitment.ApplicantsResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CdcRecruitmentResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CertificateInfo;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CertificateInfoResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.CertificateNumberResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.VacancyInfoResult;
import gov.hhs.usas.rest.report.model.CdcRecruitment.VacancyResult;

@Component
public class CdcRecruitmentReportParser {

	public List<VacancyInfoResult> generateVacancyInfo(List<CertificateInfo> certificateInfoList, List<ApplicantTotal> applicantTotalList, List<ApplicantDates> applicantDatesList) {
		
		List<VacancyInfoResult> vacancyList = new ArrayList<VacancyInfoResult>();
		VacancyInfoResult newVacancy;
		CertificateNumberResult certNumber = null;
		
		List<String> uniqueVacancyIdentificationNumbers = new ArrayList<String>();
		for(CertificateInfo vacancyInfo : certificateInfoList) {
			if(!uniqueVacancyIdentificationNumbers.contains(vacancyInfo.getVacancyNumber())) {
				uniqueVacancyIdentificationNumbers.add(vacancyInfo.getVacancyNumber());
			}
		}
		for(String vacancyIdentificationNumber : uniqueVacancyIdentificationNumbers) {
			newVacancy = new VacancyInfoResult();
			
			for(CertificateInfo certInfo : certificateInfoList) {
				if(certInfo.getVacancyNumber().equals(vacancyIdentificationNumber)) {
					certNumber = new CertificateNumberResult();	
					newVacancy.setVacancyNumber(certInfo.getVacancyNumber());
					newVacancy.setAnnouncementNumber(certInfo.getAnnouncementNumber());
					newVacancy.setAnnouncementType(certInfo.getAnnouncementType());
					newVacancy.setVacancyStatus(certInfo.getVacancyStatus());
					
					certNumber.setCertificateNumber(certInfo.getCertificateNumber());
				}
				newVacancy.addCertificate(certNumber);
			}
			
			for(ApplicantTotal appTotal : applicantTotalList) {
				if(appTotal.getVacancyNumber().equals(vacancyIdentificationNumber)) {
					newVacancy.setVacancyTotalApplicants(appTotal.getVacancyTotalApplicants());
					newVacancy.setVacancyTotalEligibleApplicants(appTotal.getVacancyTotalEligibleApplicants());
					newVacancy.setVacancyTotalReferredApplicants(appTotal.getVacancyTotalReferredApplicants());					
				}
			}
			
			for(ApplicantDates appDates : applicantDatesList) {
				if(appDates.getVacancyNumber().equals(vacancyIdentificationNumber)) {
					newVacancy.setDateApplicantsNotifiedOfReferredStatus(appDates.getDateApplicantNotifiedReferredStatus());		
				}
			}
			
			vacancyList.add(newVacancy);
			certNumber = null;
		}
			
		return vacancyList;	
	}
	
	public Map<String, ArrayList<CertificateInfoResult>> generateCertificateInfo(List<CertificateInfo> certificateInfoList) {
		
		Map<String, ArrayList<CertificateInfoResult>> certificateMap = new HashMap<String, ArrayList<CertificateInfoResult>>();
		
		ArrayList<CertificateInfoResult> newCertificateList;
		
		List<String> uniqueVacancyIdentificationNumbers = new ArrayList<String>();
		for(CertificateInfo certInfo : certificateInfoList) {
			if(!uniqueVacancyIdentificationNumbers.contains(certInfo.getVacancyNumber())) {
				uniqueVacancyIdentificationNumbers.add(certInfo.getVacancyNumber());
			}
		}
		
		for(String vacancyIdentificationNumber : uniqueVacancyIdentificationNumbers ) {
			newCertificateList = new ArrayList<CertificateInfoResult>();
			
			List<String> uniqueCertificateNumbers = new ArrayList<String>();
			for(CertificateInfo certInfo : certificateInfoList) {
				if(vacancyIdentificationNumber.equals(certInfo.getVacancyNumber()) && !uniqueCertificateNumbers.contains(certInfo.getCertificateNumber())) {
					uniqueCertificateNumbers.add(certInfo.getCertificateNumber());
				}
			}
			for(String certificateNumber : uniqueCertificateNumbers) {
				CertificateInfoResult newCertificate = new CertificateInfoResult();
				for(CertificateInfo certInfo : certificateInfoList) {
					if(vacancyIdentificationNumber.equals(certInfo.getVacancyNumber()) && certInfo.getCertificateNumber().equals(certificateNumber)) {
						newCertificate.setVacancyNumber(certInfo.getVacancyNumber());
						newCertificate.setAnnouncementNumber(certInfo.getAnnouncementNumber());
						newCertificate.setCertificateNumber(certInfo.getCertificateNumber());
						newCertificate.setCertificateType(certInfo.getCertificateType());
						newCertificate.setCertificateAuditComplete(certInfo.getCertificateAuditCompleteDate());						
						newCertificate.setDateCertificateIssued(certInfo.getDateCertificateIssued());
						newCertificate.setDateCertificateSentToSO(certInfo.getDateCertificateSentToSO());
						newCertificate.setDateCertificateDue(certInfo.getDateCertificateDue());						
						newCertificate.setPositionTitle(certInfo.getPositionTitle());
						newCertificate.setPayPlanSeriesGrade(certInfo.getPayPlanSeriesGrade());

					}
				}
				newCertificateList.add(newCertificate);
			}
			certificateMap.put(vacancyIdentificationNumber, newCertificateList);
		}	
		return certificateMap;
	}
	
	public Map<String, ArrayList<ApplicantInfoResult>> generateApplicantInfo(List<Applicants> applicantList) {
		
		Map<String, ArrayList<ApplicantInfoResult>> applicantInfoMap = new HashMap<String, ArrayList<ApplicantInfoResult>>();
		ArrayList<ApplicantInfoResult> newApplicantInfoList;
		ApplicantsResult newApplicant = null;
		
		//ApplicantInfoResult newApplicantInfo;
		
		List<String> uniqueVacancyIdentificationNumbers = new ArrayList<String>();
		for(Applicants app : applicantList) {
			if(!uniqueVacancyIdentificationNumbers.contains(app.getVacancyNumber())) {
				uniqueVacancyIdentificationNumbers.add(app.getVacancyNumber());
			}
		}
		
		for(String vacancyIdentificationNumber : uniqueVacancyIdentificationNumbers ) {
			newApplicantInfoList = new ArrayList<ApplicantInfoResult>();
			
			List<String> uniqueCertificateNumbers = new ArrayList<String>();
			for(Applicants appInfo : applicantList) {
				if(vacancyIdentificationNumber.equals(appInfo.getVacancyNumber()) && !uniqueCertificateNumbers.contains(appInfo.getCertificateNumber())) {
					uniqueCertificateNumbers.add(appInfo.getCertificateNumber());
				}
			}
			for(String certificateNumber : uniqueCertificateNumbers) {
				ApplicantInfoResult newApplicantSet = new ApplicantInfoResult();
				for(Applicants app : applicantList) {
					if(vacancyIdentificationNumber.equals(app.getVacancyNumber()) && app.getCertificateNumber().equals(certificateNumber)) {
						newApplicant = new ApplicantsResult();
						newApplicantSet.setVacancyNumber(app.getVacancyNumber());
						newApplicantSet.setAnnouncementNumber(app.getAnnouncementNumber());
						newApplicantSet.setCertificateNumber(app.getCertificateNumber());
						
						newApplicant.setApplicantName(app.getApplicantName());
						newApplicant.setApplicantFirstName(app.getApplicantFirstName());
						newApplicant.setApplicantMiddleName(app.getApplicantMiddleName());
						newApplicant.setApplicantLastName(app.getApplicantLastName());
						newApplicant.setAuditCode(app.getAuditCode());
						newApplicant.setSelecteeRequestNumber(app.getSelecteeRequestNumber());
					}
					newApplicantSet.addApplicant(newApplicant);
				}
				newApplicantInfoList.add(newApplicantSet);
				newApplicant = null;
			}
			applicantInfoMap.put(vacancyIdentificationNumber, newApplicantInfoList);

		}
		return applicantInfoMap;
	}
	
	public List<VacancyResult> generateVacancy (List<VacancyInfoResult> vacancyInfo, Map<String, ArrayList<CertificateInfoResult>> certificateMap, Map<String, ArrayList<ApplicantInfoResult>> applicantInfoMap) {
		
		List<VacancyResult> vacancyList = new ArrayList<VacancyResult>();
		VacancyResult newVacancy;
		
		List<String> uniqueVacancyAnnouncementNumbers = new ArrayList<String>();
		for (VacancyInfoResult vacancyAnnouncement : vacancyInfo) {
			if (!uniqueVacancyAnnouncementNumbers.contains(vacancyAnnouncement.getAnnouncementNumber())) {
				uniqueVacancyAnnouncementNumbers.add(vacancyAnnouncement.getAnnouncementNumber());
			}
		}
		
		for (String vacancyAnnouncement : uniqueVacancyAnnouncementNumbers) {
			
			newVacancy = new VacancyResult();
			
			for(VacancyInfoResult vacancy : vacancyInfo) {
				if(vacancy.getAnnouncementNumber().equals(vacancyAnnouncement)) {
					newVacancy.setVacancyInfo(vacancy);
				}
			}
			
			if(applicantInfoMap.get(newVacancy.getVacancyInfo().getVacancyNumber()) != null) {
				newVacancy.setApplicants(applicantInfoMap.get(newVacancy.getVacancyInfo().getVacancyNumber()));
			}
			
			if(certificateMap.get(newVacancy.getVacancyInfo().getVacancyNumber()) != null) {
				newVacancy.setCertificateList(certificateMap.get(newVacancy.getVacancyInfo().getVacancyNumber()));
			}
			vacancyList.add(newVacancy);
		}		
		
		return vacancyList;	
	}
	
	public CdcRecruitmentResult generateCdcRecruitment(String requestNumber, List<VacancyResult> vacancyList) {
		CdcRecruitmentResult cdcRecruitment = new CdcRecruitmentResult(requestNumber, vacancyList.size(), vacancyList);
		return cdcRecruitment;
	}
}

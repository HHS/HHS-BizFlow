package gov.hhs.usas.rest.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.report.model.Recruitment.ApplicantRating;
import gov.hhs.usas.rest.report.model.Recruitment.ApplicantRatingDates;
import gov.hhs.usas.rest.report.model.Recruitment.ApplicantRatingResult;
import gov.hhs.usas.rest.report.model.Recruitment.CertificateInformation;
import gov.hhs.usas.rest.report.model.Recruitment.CertificateResult;
import gov.hhs.usas.rest.report.model.Recruitment.PositionResult;
import gov.hhs.usas.rest.report.model.Recruitment.PositionsResult;
import gov.hhs.usas.rest.report.model.Recruitment.PreRecruitment;
import gov.hhs.usas.rest.report.model.Recruitment.USAStaffingRecruitmentResult;
import gov.hhs.usas.rest.report.model.Recruitment.VacancyAnnouncement;
import gov.hhs.usas.rest.report.model.Recruitment.VacancyAnnouncementResult;

@Component
public class RecruitmentReportParser
{
	public PositionsResult createPositionsForUSAStaffingRecruitment(List<PreRecruitment> preRecruitmentPositions)
	{
		PositionsResult positions = new PositionsResult();

		List<String> uniquePositionTitles = new ArrayList<String>();
		for (PreRecruitment preRecPosition : preRecruitmentPositions) {
			if (!uniquePositionTitles.contains(preRecPosition.getPositionTitle())) {
				uniquePositionTitles.add(preRecPosition.getPositionTitle());
			}
		}
		for (String positionTitle : uniquePositionTitles)
		{
			PositionResult newPosition = new PositionResult();
			for (PreRecruitment preRecPosition : preRecruitmentPositions)
			{
				positions.setClearanceLevelRequiredForPosition(preRecPosition.getClearanceLevelRequiredForPosition());
				positions.setNumberOfPositionsToBeAdvertised(preRecPosition.getNumberOfPositionsToBeAdvertised());
				newPosition.setTitle(positionTitle);
				newPosition.addPayPlan(preRecPosition.getPayPlan());
				newPosition.addSeries(preRecPosition.getSeries());
				newPosition.setFullPerformanceLevel(preRecPosition.getFullPerformanceLevel());
				if (preRecPosition.getPositionTitle().equals(positionTitle))
				{
					newPosition.addGrade(preRecPosition.getGrade());
					newPosition.addDutyLocation(preRecPosition.getDutyLocation());
				}
			}
			positions.addPosition(newPosition);
		}
		return positions;
	}

	public Map<String, ArrayList<CertificateResult>> createCertificateListForVacancyAnnouncement(List<CertificateInformation> certificateInfoList)
	{
		Map<String, ArrayList<CertificateResult>> certificateMap = new HashMap<String, ArrayList<CertificateResult>>();

		ArrayList<CertificateResult> newCertificateList;

		List<String> uniqueVacancyIdentificationNumbers = new ArrayList<String>();
		for(CertificateInformation certInfo : certificateInfoList){
			if (!uniqueVacancyIdentificationNumbers.contains(certInfo.getVacancyIdentificationNumber())) {
				uniqueVacancyIdentificationNumbers.add(certInfo.getVacancyIdentificationNumber());
			}
		}

		for(String vacancyIdentificationNumber : uniqueVacancyIdentificationNumbers){
			newCertificateList = new ArrayList<CertificateResult>();//for each vin, there can be a list of certificates
			//find list of unique certificate numbers
			List<String> uniqueCertificateNumbers = new ArrayList<String>();
			for (CertificateInformation certInfo : certificateInfoList) {
				if (vacancyIdentificationNumber.equals(certInfo.getVacancyIdentificationNumber()) && !uniqueCertificateNumbers.contains(certInfo.getCertificateNumber())) {
					uniqueCertificateNumbers.add(certInfo.getCertificateNumber());
				}
			}
			for (String certificateNumber : uniqueCertificateNumbers)
			{
				CertificateResult newCertificate = new CertificateResult();
				for (CertificateInformation certInfo : certificateInfoList)
				{
					if(vacancyIdentificationNumber.equals(certInfo.getVacancyIdentificationNumber()) && certInfo.getCertificateNumber().equals(certificateNumber)){
						newCertificate.setActionTaken(certInfo.getActionTaken());
						newCertificate.setAnnouncementNumber(certInfo.getAnnouncementNumber());
						newCertificate.setCertificateNumber(certInfo.getCertificateNumber());
						newCertificate.setCertificateType(certInfo.getCertificateType());
						newCertificate.setDateAuditCompleted(certInfo.getDateAuditCompleted());
						newCertificate.setDateCertificateIssued(certInfo.getDateCertificateIssued());
						newCertificate.setDateCertificateSentToSO(certInfo.getDateCertificateSentToSO());
						newCertificate.setDateFinalApplcantStatusesSet(certInfo.getDateFinalApplcantStatusesSet());
						newCertificate.setDateHiringDecisionRecievedInHR(certInfo.getDateHiringDecisionRecievedInHR());
						newCertificate.setPositionTitle(certInfo.getPositionTitle());
						newCertificate.setSelectionMade(certInfo.getSelectionMade());
						newCertificate.addSeries(certInfo.getSeries());
						newCertificate.addGrade(certInfo.getGrade());
						newCertificate.addDutyLocation(certInfo.getDutyLocation());
					}
				}
				newCertificateList.add(newCertificate);
			}
			certificateMap.put(vacancyIdentificationNumber, newCertificateList);
		}
		return certificateMap;
	}

	public List<ApplicantRatingResult> createApplicantRatingForVacancyAnnouncement(List<ApplicantRating> applicantRatingList, List<ApplicantRatingDates> applicantRatingDatesList)
	{
		List<ApplicantRatingResult> applicantRatingResultList = new ArrayList<ApplicantRatingResult>();
		ApplicantRatingResult newApplicantRating;

		List<String> uniqueVacancyIdentificationNumbers = new ArrayList<String>();
		for(ApplicantRating appRating : applicantRatingList){
			if (!uniqueVacancyIdentificationNumbers.contains(appRating.getVacancyIdentificationNumber())) {
				uniqueVacancyIdentificationNumbers.add(appRating.getVacancyIdentificationNumber());
			}
		}

		for(String vacancyIdentificationNumber : uniqueVacancyIdentificationNumbers){
			newApplicantRating = new ApplicantRatingResult();
			for(ApplicantRating appRating : applicantRatingList){
				if(appRating.getVacancyIdentificationNumber().equals(vacancyIdentificationNumber)){
					newApplicantRating.setVacancyIdentificationNumber(appRating.getVacancyIdentificationNumber());
					newApplicantRating.setAnnouncementNumber(appRating.getAnnouncementNumber());
					newApplicantRating.setTotalNumberOfApplicants(appRating.getTotalNumberOfApplicants());
					newApplicantRating.setTotalNumberOfEligibleApplicants(appRating.getTotalNumberOfEligibleApplicants());
					newApplicantRating.setTotalNumberOfUniqueReferredApplicants(appRating.getTotalNumberOfUniqueReferredApplicants());
				}
			}
			for(ApplicantRatingDates appRatingDates : applicantRatingDatesList){
				if(appRatingDates.getVacancyIdentificationNumber().equals(vacancyIdentificationNumber)){
					newApplicantRating.setDateApplicantsNotifiedEligibilityStatus(appRatingDates.getDateApplicantsNotifiedEligibilityStatus());
					newApplicantRating.setDateApplicantsNotifiedReferralStatus(appRatingDates.getDateApplicantsNotifiedReferralStatus());
				}
			}
			applicantRatingResultList.add(newApplicantRating);
		}

		return applicantRatingResultList;
	}

	public List<VacancyAnnouncementResult> createVacancyAnnouncementListForUSAStaffingRecruitment(Map<String, ArrayList<CertificateResult>> certificateMap, List<ApplicantRatingResult> applicantRatings, List<VacancyAnnouncement> vacancyAnnouncements)
	{
		List<VacancyAnnouncementResult> vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
		VacancyAnnouncementResult newVacancyAnnouncement;

		List<String> uniqueVacancyAnnouncementNumbers = new ArrayList<String>();
		for (VacancyAnnouncement vacancyAnnouncement : vacancyAnnouncements)
		{
			if (!uniqueVacancyAnnouncementNumbers.contains(vacancyAnnouncement.getVacancyAnnouncementNumber())) {
				uniqueVacancyAnnouncementNumbers.add(vacancyAnnouncement.getVacancyAnnouncementNumber());
			}
		}

		for (String vacancyAnnouncementNumber : uniqueVacancyAnnouncementNumbers)
		{
			List<String> uniquePositionTitles = new ArrayList<String>();
			for (VacancyAnnouncement vacancyAnnouncement : vacancyAnnouncements) {
				if (vacancyAnnouncementNumber.equals(vacancyAnnouncement.getVacancyAnnouncementNumber()) && !uniquePositionTitles.contains(vacancyAnnouncement.getPositionTitle())) {
					uniquePositionTitles.add(vacancyAnnouncement.getPositionTitle());
				}
			}
			newVacancyAnnouncement = new VacancyAnnouncementResult();
			for (String positionTitle : uniquePositionTitles)
			{
				PositionResult newPosition = new PositionResult();
				for (VacancyAnnouncement vacancyAnnouncement : vacancyAnnouncements) {
					if (vacancyAnnouncement.getVacancyAnnouncementNumber().equals(vacancyAnnouncementNumber))
					{
						newVacancyAnnouncement.setAnnouncementType(vacancyAnnouncement.getAnnouncementType());
						newVacancyAnnouncement.addAreaOfConsideration(vacancyAnnouncement.getAreaOfConsideration());
						newVacancyAnnouncement.setDateAnnouncementCancelled(vacancyAnnouncement.getDateAnnouncementCancelled());
						newVacancyAnnouncement.setDateAnnouncementClosed(vacancyAnnouncement.getDateAnnouncementClosed());
						newVacancyAnnouncement.setDateAnnouncementOpened(vacancyAnnouncement.getDateAnnouncementOpened());
						newVacancyAnnouncement.setDateAnnouncementPosted(vacancyAnnouncement.getDateAnnouncementPosted());
						newVacancyAnnouncement.setInterdisciplinaryPosition(vacancyAnnouncement.getInterdisciplinaryPosition());
						if(vacancyAnnouncement.getNumberOfPositionsAdvertised().trim().length() == 0)//if the value is blank, add a dash (-)
							newVacancyAnnouncement.setNumberOfPositionsAdvertised("-");
						else
							newVacancyAnnouncement.setNumberOfPositionsAdvertised(vacancyAnnouncement.getNumberOfPositionsAdvertised());
						newVacancyAnnouncement.setVacancyAnnouncementNumber(vacancyAnnouncement.getVacancyAnnouncementNumber());
						newVacancyAnnouncement.setVacancyIdentificationNumber(vacancyAnnouncement.getVacancyIdentificationNumber());

						newPosition.setTitle(vacancyAnnouncement.getPositionTitle());
						newPosition.addPayPlan(vacancyAnnouncement.getPayPlan());
						newPosition.addSeries(vacancyAnnouncement.getSeries());
						newPosition.setFullPerformanceLevel(vacancyAnnouncement.getFullPerformanceLevel());
						if (vacancyAnnouncement.getPositionTitle().equals(positionTitle))
						{
							newPosition.addGrade(vacancyAnnouncement.getGrade());
							newPosition.addDutyLocation(vacancyAnnouncement.getDutyLocation());
						}
					}
				}
				if(newPosition.getTitle().trim().length()>0)//if there's no Position Title, don't add this position
					newVacancyAnnouncement.addPosition(newPosition);
			}
			for (ApplicantRatingResult applicantRating : applicantRatings) {
				if (applicantRating.getAnnouncementNumber().equals(vacancyAnnouncementNumber) && applicantRating.getAnnouncementNumber().equals(newVacancyAnnouncement.getVacancyAnnouncementNumber())) {
					newVacancyAnnouncement.setApplicants(applicantRating);
				}
			}

			if(certificateMap.get(newVacancyAnnouncement.getVacancyIdentificationNumber()) != null)
				newVacancyAnnouncement.setCertificateList(certificateMap.get(newVacancyAnnouncement.getVacancyIdentificationNumber()));
			vacancyAnnouncementList.add(newVacancyAnnouncement);
		}
		return vacancyAnnouncementList;
	}

	public USAStaffingRecruitmentResult createUSAStaffingRecruitment(String requestNumber, List<VacancyAnnouncementResult> vacancyAnnouncementList, PositionsResult positions)
	{
		USAStaffingRecruitmentResult usasRecruitment = new USAStaffingRecruitmentResult(requestNumber, vacancyAnnouncementList.size(), positions.getPositionList().size(), vacancyAnnouncementList, positions);

		return usasRecruitment;
	}
}

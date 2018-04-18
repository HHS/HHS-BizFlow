package gov.hhs.usas.rest.report.service;

import java.util.ArrayList;
import java.util.List;

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
  
  public List<CertificateResult> createCertificateListForVacancyAnnouncement(List<CertificateInformation> certificateInfoList)
  {
    List<CertificateResult> certificateList = new ArrayList<CertificateResult>();
    
    List<String> uniqueCertificateNumbers = new ArrayList<String>();
    for (CertificateInformation certInfo : certificateInfoList) {
      if (!uniqueCertificateNumbers.contains(certInfo.getCertificateNumber())) {
        uniqueCertificateNumbers.add(certInfo.getCertificateNumber());
      }
    }
    for (String certificateNumber : uniqueCertificateNumbers)
    {
      CertificateResult newCertificate = new CertificateResult();
      for (CertificateInformation certInfo : certificateInfoList)
      {
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
        if (certInfo.getCertificateNumber().equals(certificateNumber))
        {
          newCertificate.addGrade(certInfo.getGrade());
          newCertificate.addDutyLocation(certInfo.getDutyLocation());
        }
      }
      certificateList.add(newCertificate);
    }
    return certificateList;
  }
  
  public ApplicantRatingResult createApplicantRatingForVacancyAnnouncement(ApplicantRating appRating, ApplicantRatingDates appRatingDates)
  {
    ApplicantRatingResult applicantRating = new ApplicantRatingResult();
    
    applicantRating.setVacancyIdentificationNumber(appRating.getVacancyIdentificationNumber());
    applicantRating.setAnnouncementNumber(appRating.getAnnouncementNumber());
    applicantRating.setTotalNumberOfApplicants(appRating.getTotalNumberOfApplicants());
    applicantRating.setTotalNumberOfEligibleApplicants(appRating.getTotalNumberOfEligibleApplicants());
    applicantRating.setTotalNumberOfUniqueReferredApplicants(appRating.getTotalNumberOfUniqueReferredApplicants());
    applicantRating.setDateApplicantsNotifiedEligibilityStatus(appRatingDates.getDateApplicantsNotifiedEligibilityStatus());
    applicantRating.setDateApplicantsNotifiedReferralStatus(appRatingDates.getDateApplicantsNotifiedReferralStatus());
    
    return applicantRating;
  }
  
  public List<VacancyAnnouncementResult> createVacancyAnnouncementListForUSAStaffingRecruitment(List<CertificateResult> certificates, List<ApplicantRatingResult> applicantRatings, List<VacancyAnnouncement> vacancyAnnouncements)
  {
    List<VacancyAnnouncementResult> vacancyAnnouncementList = new ArrayList<VacancyAnnouncementResult>();
    VacancyAnnouncementResult newVacancyAnnouncement = new VacancyAnnouncementResult();
    
    List<String> uniqueVacancyAnnouncementNumbers = new ArrayList<String>();
    for (VacancyAnnouncement vacancyAnnouncement : vacancyAnnouncements)
    {
       if (!uniqueVacancyAnnouncementNumbers.contains(vacancyAnnouncement.getVacancyAnnouncementNumber())) {
        uniqueVacancyAnnouncementNumbers.add(vacancyAnnouncement.getVacancyAnnouncementNumber());
      }
    }
    
    List<String> uniquePositionTitles = new ArrayList<String>();
    for (VacancyAnnouncement vacancyAnnouncement : vacancyAnnouncements) {
      if (!uniquePositionTitles.contains(vacancyAnnouncement.getPositionTitle())) {
        uniquePositionTitles.add(vacancyAnnouncement.getPositionTitle());
      }
    }
    for (String vacancyAnnouncementNumber : uniqueVacancyAnnouncementNumbers)
    {
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
        newVacancyAnnouncement.addPosition(newPosition);
      }
      for (ApplicantRatingResult applicantRating : applicantRatings) {
        if (newVacancyAnnouncement.getVacancyIdentificationNumber().equals(applicantRating.getVacancyIdentificationNumber())) {
          newVacancyAnnouncement.setApplicants(applicantRating);
        }
      }
      for (CertificateResult certificate : certificates) {
        if (newVacancyAnnouncement.getVacancyAnnouncementNumber().equals(certificate.getAnnouncementNumber())) {
          newVacancyAnnouncement.addCertificate(certificate);
        }
      }
      vacancyAnnouncementList.add(newVacancyAnnouncement);
    }
    return vacancyAnnouncementList;
  }
  
  public USAStaffingRecruitmentResult createUSAStaffingRecruitment(String requestNumber, List<gov.hhs.usas.rest.report.model.Recruitment.VacancyAnnouncementResult> vacancyAnnouncementList, PositionsResult positions)
  {
    USAStaffingRecruitmentResult usasRecruitment = new USAStaffingRecruitmentResult(requestNumber, vacancyAnnouncementList.size(), positions.getPositionList().size(), vacancyAnnouncementList, positions);

    return usasRecruitment;
  }
}

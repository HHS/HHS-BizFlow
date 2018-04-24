package gov.hhs.usas.rest.report.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import gov.hhs.usas.rest.report.model.Appointment.ApptInfoCert;
import gov.hhs.usas.rest.report.model.Appointment.ApptInfoNewHire;
import gov.hhs.usas.rest.report.model.Appointment.CertificateResult;
import gov.hhs.usas.rest.report.model.Appointment.Orientation;
import gov.hhs.usas.rest.report.model.Appointment.Position;
import gov.hhs.usas.rest.report.model.Appointment.USAStaffingAppointmentResult;
import gov.hhs.usas.rest.report.model.Appointment.VacancyAnnouncementResult;

@Component
public class AppointmentReportParser {

	public List<VacancyAnnouncementResult> createVacancyAnnouncementListForUSAStaffingAppointment(
			List<ApptInfoCert> apptInfoCertList, List<ApptInfoNewHire> apptInfoNewHireList,
			List<Orientation> orientationList, List<Position> positionList) {

		List<VacancyAnnouncementResult> vacancyAnnouncementList = new ArrayList<>();
		VacancyAnnouncementResult newVacancyAnnouncement;
		CertificateResult newCertificate;

		List<String> uniqueVacancyIdentificationNumbers = new ArrayList<>();
		for (ApptInfoCert apptInfoCert : apptInfoCertList)
		{
			if (!uniqueVacancyIdentificationNumbers.contains(apptInfoCert.getAnnouncementNumber())) {
				uniqueVacancyIdentificationNumbers.add(apptInfoCert.getAnnouncementNumber());
			}
		}

		for(String vacancyIdentificationNumber : uniqueVacancyIdentificationNumbers){
			newVacancyAnnouncement = new VacancyAnnouncementResult();
			newCertificate = new CertificateResult();

			for(ApptInfoCert apptInfoCert: apptInfoCertList){

				if(apptInfoCert.getAnnouncementNumber().equals(vacancyIdentificationNumber)){
					newVacancyAnnouncement.setVacancyIdentificationNumber(vacancyIdentificationNumber);
					newVacancyAnnouncement.setVacancyAnnouncementNumber(apptInfoCert.getAnnouncementNumber());
					newVacancyAnnouncement.setSupervisoryStatus(apptInfoCert.getSupervisoryPosition());
					newVacancyAnnouncement.setRelationshipToRecruitmentAction(apptInfoCert.getRelationshipToRecruitmentAction());
					newVacancyAnnouncement.setClearanceLevelRequiredForPosition(apptInfoCert.getClearanceLevelRequiredForPosition());
					newVacancyAnnouncement.setTypeOfSelection(apptInfoCert.getTypeOfSelection());
					newCertificate.setCertificateNumber(apptInfoCert.getCertificateNumber());
					newCertificate.setCertificateType(apptInfoCert.getCertificateType());
					newCertificate.setDateCertificateSentToSO(apptInfoCert.getDateCertSentToSelectingOfficial());
					newCertificate.setDateHiringDecisionReceivedInHR(apptInfoCert.getDateOfHiringDecisionInHR());
					newCertificate.setDateOfTentativeJobOffer(apptInfoCert.getDateOfTentativeJobOffer());
					newCertificate.setDateOfOfficialJobOffer(apptInfoCert.getDateOfOfficialJobOffer());

				}
			}

			for(ApptInfoNewHire apptInfoNewHire: apptInfoNewHireList){

				if(apptInfoNewHire.getVacancyIdentificationNumber().equals(vacancyIdentificationNumber)){
					newVacancyAnnouncement.setJobCode(apptInfoNewHire.getJobCode());
					newVacancyAnnouncement.setOf306AssignedInOnboardingManager(apptInfoNewHire.getOf306AssignedInOnboardingManager());
					newVacancyAnnouncement.setEod(apptInfoNewHire.getEod());

				}
			}


			for(Orientation orientation: orientationList){
				if(orientation.getVacancyIdentificationNumber().equals(vacancyIdentificationNumber)){
					newCertificate.setAppointeesEmailAddressForOrientationContact(orientation.getAppointeesEmailAddressForOrientationContact());
					newCertificate.setDateOfficialOfferSent(orientation.getDateOfficialOfferLetterSent());
				}
			}

			for(Position position: positionList){
				if(position.getVacancyIdentificationNumber().equals(vacancyIdentificationNumber)){
					newCertificate.setPositionTitle(position.getPositionTitle());
					newCertificate.setPayPlan(position.getPayPlan());
					newCertificate.setSeries(position.getSeries());
					newCertificate.setGrade(position.getGrade());
					newCertificate.setFullPerformanceLevel(position.getFullPerformanceLevel());
					newCertificate.setDutyStation(position.getDutyStation());
					newCertificate.setDutyStationCode(position.getDutyStationCode());
				}
			}

			newVacancyAnnouncement.setCertificate(newCertificate);
			vacancyAnnouncementList.add(newVacancyAnnouncement);

		}

		return vacancyAnnouncementList;
	}

	public USAStaffingAppointmentResult createUSAStaffingRecruitment(String requestNumber,
			List<VacancyAnnouncementResult> vacancyAnnouncementList) {
		USAStaffingAppointmentResult usasAppointment = new USAStaffingAppointmentResult(requestNumber, vacancyAnnouncementList.size(), vacancyAnnouncementList);

	    return usasAppointment;
	}

}

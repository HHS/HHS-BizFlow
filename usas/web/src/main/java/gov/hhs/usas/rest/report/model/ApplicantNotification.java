package gov.hhs.usas.rest.report.model;

public class ApplicantNotification {
	
	String vacancyNumber;
	String htmlResponse;
	
	public String getVacancyNumber() {
		return vacancyNumber;
	}
	public void setVacancyNumber(String vacancyNumber) {
		this.vacancyNumber = vacancyNumber;
	}
	public String getHtmlResponse() {
		return htmlResponse;
	}
	public void setHtmlResponse(String htmlResponse) {
		this.htmlResponse = htmlResponse;
	}
	
	@Override
	public String toString()
	{
		return "ApplicantNotification [vacancyNumber: " + this.getVacancyNumber() + "| htmlResponse: " + this.getHtmlResponse() + "]";
	}

}

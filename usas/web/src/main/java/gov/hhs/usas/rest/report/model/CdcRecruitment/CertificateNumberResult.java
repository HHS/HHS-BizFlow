package gov.hhs.usas.rest.report.model.CdcRecruitment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CertificateNumberResult", propOrder={})
public class CertificateNumberResult {

	@XmlElement(name="Certificate_Number")
	private String certificateNumber;
	
	public CertificateNumberResult() {
		this.certificateNumber = "";
	}

	public CertificateNumberResult(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	@Override
	public String toString() {
		return "CertificateNumberResult [certificateNumber=" + certificateNumber + "]";
	}
	
}

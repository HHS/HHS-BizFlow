package com.hhs.persondirectory;

public class HHSEmployee {
	
	private String HHSID;
	private String Name;
	private String EmailAddress;
	private String Organization;
	private String ActiveIndicator;
	
	public HHSEmployee(String hHSID, String name, String emailAddress, String organization, String activeIndicator) {
		this.HHSID = hHSID;
		this.Name = name;
		this.EmailAddress = emailAddress;
		this.Organization = organization;
		this.ActiveIndicator = activeIndicator;
	}
	public HHSEmployee(){
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getHHSID() {
		return HHSID;
	}
	public void setHHSID(String hHSID) {
		HHSID = hHSID;
	}
	public String getOrganization() {
		return Organization;
	}
	public void setOrganization(String organization) {
		Organization = organization;
	}
	
	public String getActiveIndicator() {
		return ActiveIndicator;
	}
	public void setActiveIndicator(String activeIndicator) {
		ActiveIndicator = activeIndicator;
	}
	@Override
    public String toString() {
        return "[ "+HHSID+". "+ Name +"->"+ EmailAddress +"->" + Organization + "->" +ActiveIndicator +" ]";
    }

	
	
}

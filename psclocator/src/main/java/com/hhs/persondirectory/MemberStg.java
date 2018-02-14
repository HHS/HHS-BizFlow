package com.hhs.persondirectory;

public class MemberStg {
	
	private String HHSID;
	private String Name;
	private String Email;
	private String DeptName;
	private String ActiveIndicator;
	
	public MemberStg(String hHSID, String name, String email, String deptName, String activeIndicator) {
		this.HHSID = hHSID;
		this.Name = name;
		this.Email = email;
		this.DeptName = deptName;
		this.ActiveIndicator = activeIndicator;
	}
	public MemberStg(){
		
	}

	
	public String getHHSID() {
		return HHSID;
	}
	public void setHHSID(String hHSID) {
		HHSID = hHSID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getActiveIndicator() {
		return ActiveIndicator;
	}
	public void setActiveIndicator(String activeIndicator) {
		ActiveIndicator = activeIndicator;
	}
	@Override
    public String toString() {
        return "[ "+HHSID+". "+ Name +"->"+ Email +"->" + DeptName + "->" + ActiveIndicator + " ]";
    }

}

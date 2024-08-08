package com.etel.group.forms;

import java.util.Date;

public class GroupForm {
	private String companycode;
    private String branchcode;
    private String groupcode;
	private String groupname;
    private Boolean isapprovingcommittee;
    private Date datecreated;
    private String createdby;
    private Date dateupdated;
    private String updatedby;
    private String coopcode;
    
	public String getCompanycode() {
		return companycode;
	}
	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	public String getGroupcode() {
		return groupcode;
	}
	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public Boolean getIsapprovingcommittee() {
		return isapprovingcommittee;
	}
	public void setIsapprovingcommittee(Boolean isapprovingcommittee) {
		this.isapprovingcommittee = isapprovingcommittee;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getDateupdated() {
		return dateupdated;
	}
	public void setDateupdated(Date dateupdated) {
		this.dateupdated = dateupdated;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public String getCoopcode() {
		return coopcode;
	}
	public void setCoopcode(String coopcode) {
		this.coopcode = coopcode;
	}
    
}

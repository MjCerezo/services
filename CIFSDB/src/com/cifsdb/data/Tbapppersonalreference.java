
package com.cifsdb.data;



/**
 *  CIFSDB.Tbapppersonalreference
 *  09/26/2023 10:13:06
 * 
 */
public class Tbapppersonalreference {

    private Integer id;
    private String membershipappid;
    private String fullname;
    private String fulladdress;
    private String relationship;
    private String contactno;
    private String personalrefmemberid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMembershipappid() {
        return membershipappid;
    }

    public void setMembershipappid(String membershipappid) {
        this.membershipappid = membershipappid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFulladdress() {
        return fulladdress;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getPersonalrefmemberid() {
        return personalrefmemberid;
    }

    public void setPersonalrefmemberid(String personalrefmemberid) {
        this.personalrefmemberid = personalrefmemberid;
    }

}

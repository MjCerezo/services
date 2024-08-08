
package com.cifsdb.data;

import java.util.Date;


/**
 *  CIFSDB.Tbcustomerrelationship
 *  08/06/2024 19:26:36
 * 
 */
public class Tbcustomerrelationship {

    private Integer relid;
    private String maincifno;
    private String maincifname;
    private String relatedcifno;
    private String relationshipcode;
    private String relatedcifname;
    private Boolean status;
    private Date dateadded;
    private String addedby;
    private Date dateupdated;
    private String updatedby;
    private Boolean isautogenerated;
    private String relationshipdesc;
    private String mngempid;

    public Integer getRelid() {
        return relid;
    }

    public void setRelid(Integer relid) {
        this.relid = relid;
    }

    public String getMaincifno() {
        return maincifno;
    }

    public void setMaincifno(String maincifno) {
        this.maincifno = maincifno;
    }

    public String getMaincifname() {
        return maincifname;
    }

    public void setMaincifname(String maincifname) {
        this.maincifname = maincifname;
    }

    public String getRelatedcifno() {
        return relatedcifno;
    }

    public void setRelatedcifno(String relatedcifno) {
        this.relatedcifno = relatedcifno;
    }

    public String getRelationshipcode() {
        return relationshipcode;
    }

    public void setRelationshipcode(String relationshipcode) {
        this.relationshipcode = relationshipcode;
    }

    public String getRelatedcifname() {
        return relatedcifname;
    }

    public void setRelatedcifname(String relatedcifname) {
        this.relatedcifname = relatedcifname;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public String getAddedby() {
        return addedby;
    }

    public void setAddedby(String addedby) {
        this.addedby = addedby;
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

    public Boolean getIsautogenerated() {
        return isautogenerated;
    }

    public void setIsautogenerated(Boolean isautogenerated) {
        this.isautogenerated = isautogenerated;
    }

    public String getRelationshipdesc() {
        return relationshipdesc;
    }

    public void setRelationshipdesc(String relationshipdesc) {
        this.relationshipdesc = relationshipdesc;
    }

    public String getMngempid() {
        return mngempid;
    }

    public void setMngempid(String mngempid) {
        this.mngempid = mngempid;
    }

}


package com.cifsdb.data;

import java.util.Date;


/**
 *  CIFSDB.Tbevalbi
 *  09/26/2023 10:13:05
 * 
 */
public class Tbevalbi {

    private TbevalbiId id;
    private String appno;
    private String subjectname;
    private String bapbireportid;
    private String bapnfis;
    private String cmapbireportid;
    private String cmap;
    private String cicbireportid;
    private String cic;
    private String blacklistreportid;
    private String internalblacklist;
    private String externalblacklist;
    private String amlareportid;
    private String amlawatchlistedinternal;
    private String amlawatchlistedexternal;
    private Date datecreated;

    public TbevalbiId getId() {
        return id;
    }

    public void setId(TbevalbiId id) {
        this.id = id;
    }

    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getBapbireportid() {
        return bapbireportid;
    }

    public void setBapbireportid(String bapbireportid) {
        this.bapbireportid = bapbireportid;
    }

    public String getBapnfis() {
        return bapnfis;
    }

    public void setBapnfis(String bapnfis) {
        this.bapnfis = bapnfis;
    }

    public String getCmapbireportid() {
        return cmapbireportid;
    }

    public void setCmapbireportid(String cmapbireportid) {
        this.cmapbireportid = cmapbireportid;
    }

    public String getCmap() {
        return cmap;
    }

    public void setCmap(String cmap) {
        this.cmap = cmap;
    }

    public String getCicbireportid() {
        return cicbireportid;
    }

    public void setCicbireportid(String cicbireportid) {
        this.cicbireportid = cicbireportid;
    }

    public String getCic() {
        return cic;
    }

    public void setCic(String cic) {
        this.cic = cic;
    }

    public String getBlacklistreportid() {
        return blacklistreportid;
    }

    public void setBlacklistreportid(String blacklistreportid) {
        this.blacklistreportid = blacklistreportid;
    }

    public String getInternalblacklist() {
        return internalblacklist;
    }

    public void setInternalblacklist(String internalblacklist) {
        this.internalblacklist = internalblacklist;
    }

    public String getExternalblacklist() {
        return externalblacklist;
    }

    public void setExternalblacklist(String externalblacklist) {
        this.externalblacklist = externalblacklist;
    }

    public String getAmlareportid() {
        return amlareportid;
    }

    public void setAmlareportid(String amlareportid) {
        this.amlareportid = amlareportid;
    }

    public String getAmlawatchlistedinternal() {
        return amlawatchlistedinternal;
    }

    public void setAmlawatchlistedinternal(String amlawatchlistedinternal) {
        this.amlawatchlistedinternal = amlawatchlistedinternal;
    }

    public String getAmlawatchlistedexternal() {
        return amlawatchlistedexternal;
    }

    public void setAmlawatchlistedexternal(String amlawatchlistedexternal) {
        this.amlawatchlistedexternal = amlawatchlistedexternal;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

}

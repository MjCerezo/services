
package com.loansdb.data;

import java.math.BigDecimal;
import java.util.Date;


/**
 *  LOANSDB.Tblamloandetails
 *  10/13/2020 10:21:35
 * 
 */
public class Tblamloandetails {

    private Integer id;
    private Integer evalreportid;
    private String cfrefnoconcat;
    private String cfappno;
    private String cfrefno;
    private Integer cflevel;
    private String cfseqno;
    private String cfsubseqno;
    private String cftype;
    private String cfcode;
    private String cfcurrency;
    private BigDecimal cfproposedamt;
    private BigDecimal cfapprovedamt;
    private BigDecimal cfamount;
    private Date cfexpdt;
    private Date cfdtopen;
    private Boolean cfrevolving;
    private Boolean cfshared;
    private String cfsharedtype;
    private String cfstatus;
    private BigDecimal cfavailed;
    private BigDecimal cfearmarked;
    private BigDecimal cfbalance;
    private Integer cfterm;
    private String cftermperiod;
    private String cfraterule;
    private BigDecimal cfminrate;
    private BigDecimal cfmaxrate;
    private BigDecimal cfintrate;
    private String cfintrateperiod;
    private String cfrepaymenttype;
    private String remarks;
    private String cfmaker;
    private Date cfupdate;
    private String covenants;
    private String cifno;
    private Integer subfacilityseqno;
    private String cifname;
    private Integer cfupdatecount;
    private Date cfrequestedvalidity;
    private String prevcfappno;
    private String createdby;
    private Date datecreated;
    private String updatedby;
    private Date lastupdated;
    private BigDecimal cflpcrate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvalreportid() {
        return evalreportid;
    }

    public void setEvalreportid(Integer evalreportid) {
        this.evalreportid = evalreportid;
    }

    public String getCfrefnoconcat() {
        return cfrefnoconcat;
    }

    public void setCfrefnoconcat(String cfrefnoconcat) {
        this.cfrefnoconcat = cfrefnoconcat;
    }

    public String getCfappno() {
        return cfappno;
    }

    public void setCfappno(String cfappno) {
        this.cfappno = cfappno;
    }

    public String getCfrefno() {
        return cfrefno;
    }

    public void setCfrefno(String cfrefno) {
        this.cfrefno = cfrefno;
    }

    public Integer getCflevel() {
        return cflevel;
    }

    public void setCflevel(Integer cflevel) {
        this.cflevel = cflevel;
    }

    public String getCfseqno() {
        return cfseqno;
    }

    public void setCfseqno(String cfseqno) {
        this.cfseqno = cfseqno;
    }

    public String getCfsubseqno() {
        return cfsubseqno;
    }

    public void setCfsubseqno(String cfsubseqno) {
        this.cfsubseqno = cfsubseqno;
    }

    public String getCftype() {
        return cftype;
    }

    public void setCftype(String cftype) {
        this.cftype = cftype;
    }

    public String getCfcode() {
        return cfcode;
    }

    public void setCfcode(String cfcode) {
        this.cfcode = cfcode;
    }

    public String getCfcurrency() {
        return cfcurrency;
    }

    public void setCfcurrency(String cfcurrency) {
        this.cfcurrency = cfcurrency;
    }

    public BigDecimal getCfproposedamt() {
        return cfproposedamt;
    }

    public void setCfproposedamt(BigDecimal cfproposedamt) {
        this.cfproposedamt = cfproposedamt;
    }

    public BigDecimal getCfapprovedamt() {
        return cfapprovedamt;
    }

    public void setCfapprovedamt(BigDecimal cfapprovedamt) {
        this.cfapprovedamt = cfapprovedamt;
    }

    public BigDecimal getCfamount() {
        return cfamount;
    }

    public void setCfamount(BigDecimal cfamount) {
        this.cfamount = cfamount;
    }

    public Date getCfexpdt() {
        return cfexpdt;
    }

    public void setCfexpdt(Date cfexpdt) {
        this.cfexpdt = cfexpdt;
    }

    public Date getCfdtopen() {
        return cfdtopen;
    }

    public void setCfdtopen(Date cfdtopen) {
        this.cfdtopen = cfdtopen;
    }

    public Boolean getCfrevolving() {
        return cfrevolving;
    }

    public void setCfrevolving(Boolean cfrevolving) {
        this.cfrevolving = cfrevolving;
    }

    public Boolean getCfshared() {
        return cfshared;
    }

    public void setCfshared(Boolean cfshared) {
        this.cfshared = cfshared;
    }

    public String getCfsharedtype() {
        return cfsharedtype;
    }

    public void setCfsharedtype(String cfsharedtype) {
        this.cfsharedtype = cfsharedtype;
    }

    public String getCfstatus() {
        return cfstatus;
    }

    public void setCfstatus(String cfstatus) {
        this.cfstatus = cfstatus;
    }

    public BigDecimal getCfavailed() {
        return cfavailed;
    }

    public void setCfavailed(BigDecimal cfavailed) {
        this.cfavailed = cfavailed;
    }

    public BigDecimal getCfearmarked() {
        return cfearmarked;
    }

    public void setCfearmarked(BigDecimal cfearmarked) {
        this.cfearmarked = cfearmarked;
    }

    public BigDecimal getCfbalance() {
        return cfbalance;
    }

    public void setCfbalance(BigDecimal cfbalance) {
        this.cfbalance = cfbalance;
    }

    public Integer getCfterm() {
        return cfterm;
    }

    public void setCfterm(Integer cfterm) {
        this.cfterm = cfterm;
    }

    public String getCftermperiod() {
        return cftermperiod;
    }

    public void setCftermperiod(String cftermperiod) {
        this.cftermperiod = cftermperiod;
    }

    public String getCfraterule() {
        return cfraterule;
    }

    public void setCfraterule(String cfraterule) {
        this.cfraterule = cfraterule;
    }

    public BigDecimal getCfminrate() {
        return cfminrate;
    }

    public void setCfminrate(BigDecimal cfminrate) {
        this.cfminrate = cfminrate;
    }

    public BigDecimal getCfmaxrate() {
        return cfmaxrate;
    }

    public void setCfmaxrate(BigDecimal cfmaxrate) {
        this.cfmaxrate = cfmaxrate;
    }

    public BigDecimal getCfintrate() {
        return cfintrate;
    }

    public void setCfintrate(BigDecimal cfintrate) {
        this.cfintrate = cfintrate;
    }

    public String getCfintrateperiod() {
        return cfintrateperiod;
    }

    public void setCfintrateperiod(String cfintrateperiod) {
        this.cfintrateperiod = cfintrateperiod;
    }

    public String getCfrepaymenttype() {
        return cfrepaymenttype;
    }

    public void setCfrepaymenttype(String cfrepaymenttype) {
        this.cfrepaymenttype = cfrepaymenttype;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCfmaker() {
        return cfmaker;
    }

    public void setCfmaker(String cfmaker) {
        this.cfmaker = cfmaker;
    }

    public Date getCfupdate() {
        return cfupdate;
    }

    public void setCfupdate(Date cfupdate) {
        this.cfupdate = cfupdate;
    }

    public String getCovenants() {
        return covenants;
    }

    public void setCovenants(String covenants) {
        this.covenants = covenants;
    }

    public String getCifno() {
        return cifno;
    }

    public void setCifno(String cifno) {
        this.cifno = cifno;
    }

    public Integer getSubfacilityseqno() {
        return subfacilityseqno;
    }

    public void setSubfacilityseqno(Integer subfacilityseqno) {
        this.subfacilityseqno = subfacilityseqno;
    }

    public String getCifname() {
        return cifname;
    }

    public void setCifname(String cifname) {
        this.cifname = cifname;
    }

    public Integer getCfupdatecount() {
        return cfupdatecount;
    }

    public void setCfupdatecount(Integer cfupdatecount) {
        this.cfupdatecount = cfupdatecount;
    }

    public Date getCfrequestedvalidity() {
        return cfrequestedvalidity;
    }

    public void setCfrequestedvalidity(Date cfrequestedvalidity) {
        this.cfrequestedvalidity = cfrequestedvalidity;
    }

    public String getPrevcfappno() {
        return prevcfappno;
    }

    public void setPrevcfappno(String prevcfappno) {
        this.prevcfappno = prevcfappno;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    public BigDecimal getCflpcrate() {
        return cflpcrate;
    }

    public void setCflpcrate(BigDecimal cflpcrate) {
        this.cflpcrate = cflpcrate;
    }

}


package com.cifsdb.data;

import java.util.Date;


/**
 *  CIFSDB.Tbbatchfile
 *  09/26/2023 10:13:05
 * 
 */
public class Tbbatchfile {

    private Integer id;
    private String batchfilename;
    private Integer batchstatus;
    private Date batchdate;
    private String companycode;
    private String originatingbr;
    private String processedby;
    private String uploadedby;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchfilename() {
        return batchfilename;
    }

    public void setBatchfilename(String batchfilename) {
        this.batchfilename = batchfilename;
    }

    public Integer getBatchstatus() {
        return batchstatus;
    }

    public void setBatchstatus(Integer batchstatus) {
        this.batchstatus = batchstatus;
    }

    public Date getBatchdate() {
        return batchdate;
    }

    public void setBatchdate(Date batchdate) {
        this.batchdate = batchdate;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getOriginatingbr() {
        return originatingbr;
    }

    public void setOriginatingbr(String originatingbr) {
        this.originatingbr = originatingbr;
    }

    public String getProcessedby() {
        return processedby;
    }

    public void setProcessedby(String processedby) {
        this.processedby = processedby;
    }

    public String getUploadedby() {
        return uploadedby;
    }

    public void setUploadedby(String uploadedby) {
        this.uploadedby = uploadedby;
    }

}

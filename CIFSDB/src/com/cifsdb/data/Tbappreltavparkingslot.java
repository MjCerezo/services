
package com.cifsdb.data;

import java.math.BigDecimal;


/**
 *  CIFSDB.Tbappreltavparkingslot
 *  09/26/2023 10:13:05
 * 
 */
public class Tbappreltavparkingslot {

    private Integer id;
    private String appraisalreportid;
    private String appno;
    private String parkingslot;
    private BigDecimal appraisedvalue;
    private BigDecimal totalappval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppraisalreportid() {
        return appraisalreportid;
    }

    public void setAppraisalreportid(String appraisalreportid) {
        this.appraisalreportid = appraisalreportid;
    }

    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public String getParkingslot() {
        return parkingslot;
    }

    public void setParkingslot(String parkingslot) {
        this.parkingslot = parkingslot;
    }

    public BigDecimal getAppraisedvalue() {
        return appraisedvalue;
    }

    public void setAppraisedvalue(BigDecimal appraisedvalue) {
        this.appraisedvalue = appraisedvalue;
    }

    public BigDecimal getTotalappval() {
        return totalappval;
    }

    public void setTotalappval(BigDecimal totalappval) {
        this.totalappval = totalappval;
    }

}

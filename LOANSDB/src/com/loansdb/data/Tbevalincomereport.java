
package com.loansdb.data;

import java.math.BigDecimal;


/**
 *  LOANSDB.Tbevalincomereport
 *  10/13/2020 10:21:35
 * 
 */
public class Tbevalincomereport {

    private Integer evalreportid;
    private BigDecimal totalincome;
    private BigDecimal totalexpense;
    private BigDecimal netpay1;
    private BigDecimal monthlyamort;
    private BigDecimal netpay2;

    public Integer getEvalreportid() {
        return evalreportid;
    }

    public void setEvalreportid(Integer evalreportid) {
        this.evalreportid = evalreportid;
    }

    public BigDecimal getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(BigDecimal totalincome) {
        this.totalincome = totalincome;
    }

    public BigDecimal getTotalexpense() {
        return totalexpense;
    }

    public void setTotalexpense(BigDecimal totalexpense) {
        this.totalexpense = totalexpense;
    }

    public BigDecimal getNetpay1() {
        return netpay1;
    }

    public void setNetpay1(BigDecimal netpay1) {
        this.netpay1 = netpay1;
    }

    public BigDecimal getMonthlyamort() {
        return monthlyamort;
    }

    public void setMonthlyamort(BigDecimal monthlyamort) {
        this.monthlyamort = monthlyamort;
    }

    public BigDecimal getNetpay2() {
        return netpay2;
    }

    public void setNetpay2(BigDecimal netpay2) {
        this.netpay2 = netpay2;
    }

}

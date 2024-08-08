
package com.cifsdb.data;

import java.math.BigDecimal;


/**
 *  CIFSDB.Tbinterestrate
 *  09/26/2023 10:13:06
 * 
 */
public class Tbinterestrate {

    private Integer id;
    private BigDecimal interestrate;
    private BigDecimal minamount;
    private BigDecimal maxamount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(BigDecimal interestrate) {
        this.interestrate = interestrate;
    }

    public BigDecimal getMinamount() {
        return minamount;
    }

    public void setMinamount(BigDecimal minamount) {
        this.minamount = minamount;
    }

    public BigDecimal getMaxamount() {
        return maxamount;
    }

    public void setMaxamount(BigDecimal maxamount) {
        this.maxamount = maxamount;
    }

}

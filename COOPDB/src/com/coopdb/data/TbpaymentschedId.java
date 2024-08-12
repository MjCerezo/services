
package com.coopdb.data;

import java.io.Serializable;


/**
 *  COOPDB.TbpaymentschedId
 *  08/10/2024 21:24:57
 * 
 */
public class TbpaymentschedId
    implements Serializable
{

    private Integer amortid;
    private String accountno;

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TbpaymentschedId)) {
            return false;
        }
        TbpaymentschedId other = ((TbpaymentschedId) o);
        if (this.amortid == null) {
            if (other.amortid!= null) {
                return false;
            }
        } else {
            if (!this.amortid.equals(other.amortid)) {
                return false;
            }
        }
        if (this.accountno == null) {
            if (other.accountno!= null) {
                return false;
            }
        } else {
            if (!this.accountno.equals(other.accountno)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int rtn = 17;
        rtn = (rtn* 37);
        if (this.amortid!= null) {
            rtn = (rtn + this.amortid.hashCode());
        }
        rtn = (rtn* 37);
        if (this.accountno!= null) {
            rtn = (rtn + this.accountno.hashCode());
        }
        return rtn;
    }

    public Integer getAmortid() {
        return amortid;
    }

    public void setAmortid(Integer amortid) {
        this.amortid = amortid;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

}

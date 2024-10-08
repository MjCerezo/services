
package com.coopdb.data;

import java.io.Serializable;


/**
 *  COOPDB.TbglmatrixperprodId
 *  08/04/2024 12:54:43
 * 
 */
public class TbglmatrixperprodId
    implements Serializable
{

    private String gllineno;
    private String productcode;

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TbglmatrixperprodId)) {
            return false;
        }
        TbglmatrixperprodId other = ((TbglmatrixperprodId) o);
        if (this.gllineno == null) {
            if (other.gllineno!= null) {
                return false;
            }
        } else {
            if (!this.gllineno.equals(other.gllineno)) {
                return false;
            }
        }
        if (this.productcode == null) {
            if (other.productcode!= null) {
                return false;
            }
        } else {
            if (!this.productcode.equals(other.productcode)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int rtn = 17;
        rtn = (rtn* 37);
        if (this.gllineno!= null) {
            rtn = (rtn + this.gllineno.hashCode());
        }
        rtn = (rtn* 37);
        if (this.productcode!= null) {
            rtn = (rtn + this.productcode.hashCode());
        }
        return rtn;
    }

    public String getGllineno() {
        return gllineno;
    }

    public void setGllineno(String gllineno) {
        this.gllineno = gllineno;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

}

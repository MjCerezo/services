
package com.cifsdb.data;

import java.io.Serializable;


/**
 *  CIFSDB.TbroleaccessId
 *  08/06/2024 19:26:36
 * 
 */
public class TbroleaccessId
    implements Serializable
{

    private String roleid;
    private String accessname;

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TbroleaccessId)) {
            return false;
        }
        TbroleaccessId other = ((TbroleaccessId) o);
        if (this.roleid == null) {
            if (other.roleid!= null) {
                return false;
            }
        } else {
            if (!this.roleid.equals(other.roleid)) {
                return false;
            }
        }
        if (this.accessname == null) {
            if (other.accessname!= null) {
                return false;
            }
        } else {
            if (!this.accessname.equals(other.accessname)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int rtn = 17;
        rtn = (rtn* 37);
        if (this.roleid!= null) {
            rtn = (rtn + this.roleid.hashCode());
        }
        rtn = (rtn* 37);
        if (this.accessname!= null) {
            rtn = (rtn + this.accessname.hashCode());
        }
        return rtn;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getAccessname() {
        return accessname;
    }

    public void setAccessname(String accessname) {
        this.accessname = accessname;
    }

}

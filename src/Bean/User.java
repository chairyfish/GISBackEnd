package Bean;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 * Created by chairyfish on 2017/6/26.
 */
public class User implements Serializable{
    private int uid=0;
    private String unumber="";
    private String uname="";
    private String upassword="";
    private String utype="";

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUnumber() {
        return unumber;
    }

    public void setUnumber(String unumber) {
        this.unumber = unumber;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

}

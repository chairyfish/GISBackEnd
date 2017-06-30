package Bean;

import java.io.Serializable;

/**
 * Created by chairyfish on 2017/6/29.
 */
public class Classroom implements Serializable{
    private int cid=0;
    private String cnumber="";
    private String bname="";
    private String cstate="";

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }
}

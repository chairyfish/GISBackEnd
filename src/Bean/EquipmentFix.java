package Bean;

import javafx.util.converter.TimeStringConverter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by chairyfish on 2017/6/28.
 */
public class EquipmentFix implements Serializable{

    private int fid = 0;
    private Date fdate;
    private String ename="";
    private String bname="";
    private String fhousenumber="";
    private int uid=0;
    private String uname="";
    private String ftel="";
    private Boolean fstate=false;
    private String fremark="";

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getFhousenumber() {
        return fhousenumber;
    }

    public void setFhousenumber(String fhousenumber) {
        this.fhousenumber = fhousenumber;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFtel() {
        return ftel;
    }

    public void setFtel(String ftel) {
        this.ftel = ftel;
    }

    public Boolean getFstate() {
        return fstate;
    }

    public void setFstate(Boolean fstate) {
        this.fstate = fstate;
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark;
    }
}

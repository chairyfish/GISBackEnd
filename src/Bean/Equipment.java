package Bean;

import com.sun.org.glassfish.external.statistics.TimeStatistic;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by chairyfish on 2017/6/28.
 */
public class Equipment implements Serializable{

    private int eid=0;
    private int bid=0;
    private String ename="";
    private int enumber=0;
    private String eunit="";
    private double etotalprice=0;
    private double eunitprice=0;
    private Timestamp epurchasetime;
    private String eremark="";

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEnumber() {
        return enumber;
    }

    public void setEnumber(int enumber) {
        this.enumber = enumber;
    }

    public String getEunit() {
        return eunit;
    }

    public void setEunit(String eunit) {
        this.eunit = eunit;
    }

    public double getEtotalprice() {
        return etotalprice;
    }

    public void setEtotalprice(double etotalprice) {
        this.etotalprice = etotalprice;
    }

    public double getEunitprice() {
        return eunitprice;
    }

    public void setEunitprice(double eunitprice) {
        this.eunitprice = eunitprice;
    }

    public Timestamp getEpurchasetime() {
        return epurchasetime;
    }

    public void setEpurchasetime(Timestamp epurchasetime) {
        this.epurchasetime = epurchasetime;
    }

    public String getEremark() {
        return eremark;
    }

    public void setEremark(String eremark) {
        this.eremark = eremark;
    }
}

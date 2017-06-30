package Bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by chairyfish on 2017/6/28.
 */
public class Activity implements Serializable{
    private int aid=0;
    private String aname="";
    private Timestamp astarttime;
    private Timestamp aendtime;
    private String aplace="";
    private String asponser="";
    private String aintroduction="";
    private int bid=0;
    private boolean astate=false;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Timestamp getAstarttime() {
        return astarttime;
    }

    public void setAstarttime(Timestamp astarttime) {
        this.astarttime = astarttime;
    }

    public Timestamp getAendtime() {
        return aendtime;
    }

    public void setAendtime(Timestamp aendtime) {
        this.aendtime = aendtime;
    }

    public String getAplace() {
        return aplace;
    }

    public void setAplace(String aplace) {
        this.aplace = aplace;
    }

    public String getAsponser() {
        return asponser;
    }

    public void setAsponser(String asponser) {
        this.asponser = asponser;
    }

    public String getAintroduction() {
        return aintroduction;
    }

    public void setAintroduction(String aintroduction) {
        this.aintroduction = aintroduction;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public boolean isAstate() {
        return astate;
    }

    public void setAstate(boolean astate) {
        this.astate = astate;
    }
}

package Bean;

import java.io.Serializable;

/**
 * Created by chairyfish on 2017/6/27.
 */
public class Building implements Serializable {
    private int bid=0;
    private String bname="";
    private String btype="";
    private String bdescription="";
    private int bfloor=0;
    private String bimage="";
    private String bfunction="";
    private String bcampus="";

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getBdescription() {
        return bdescription;
    }

    public void setBdescription(String bdescription) {
        this.bdescription = bdescription;
    }

    public int getBfloor() {
        return bfloor;
    }

    public void setBfloor(int bfloor) {
        this.bfloor = bfloor;
    }

    public String getBimage() {
        return bimage;
    }

    public void setBimage(String bimage) {
        this.bimage = bimage;
    }

    public String getBfunction() {
        return bfunction;
    }

    public void setBfunction(String bfunction) {
        this.bfunction = bfunction;
    }

    public String getBcampus() {
        return bcampus;
    }

    public void setBcampus(String bcampus) {
        this.bcampus = bcampus;
    }
}

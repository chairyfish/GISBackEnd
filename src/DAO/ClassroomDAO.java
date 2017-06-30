package DAO;

import Bean.ClassInfoToday;
import Util.ConnectionPoolUtil;
import com.mchange.v2.codegen.bean.ClassInfo;
import com.mysql.fabric.xmlrpc.base.Array;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by chairyfish on 2017/6/29.
 */
public class ClassroomDAO {
    Connection conn=null;
    PreparedStatement psmt=null;

    public String queryClassState(String bname,String cnumber)throws SQLException{
        String roomstate="";
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from GISProject.classroom where bname=? and cnumber=?;";
        psmt=conn.prepareStatement(sql);
        psmt.setString(1,bname);
        psmt.setString(2,cnumber);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            roomstate=rs.getString("cstate");
        }
        conn.close();
        psmt.close();
        rs.close();
        return roomstate;
    }

    public ArrayList<String> getRoomByBid(String bid)throws SQLException{
        ArrayList<String> roomstates=new ArrayList<String>();
        ClassInfoToday.bname.clear();
        ClassInfoToday.cnumbers.clear();
        String roomstate="";
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from GISProject.classroom where bname=?;";
        psmt=conn.prepareStatement(sql);
        psmt.setString(1,bid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            roomstates.add(roomstate=rs.getString("cstate"));
            ClassInfoToday.bname.add(rs.getString("bname"));
            ClassInfoToday.cnumbers.add(rs.getString("cnumber"));
        }
        conn.close();
        psmt.close();
        rs.close();
        return roomstates;
    }

}

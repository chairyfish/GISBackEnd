package DAO;

import Bean.EquipmentFix;
import Util.ConnectionPoolUtil;


import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Created by chairyfish on 2017/6/28.
 */
public class EquipmentFixDAO {
    Connection conn = null;
    PreparedStatement psmt = null;

    public boolean addEquipmentFix(String ename, String bname, String fhousenumber, int uid,
                                   String ftel, String fremark) throws SQLException {
        if (ename.equals("") || bname.equals("") || uid == 0) {
            return false;
        } else {
            UserDAO userDAO = new UserDAO();
            String uname = userDAO.UnameById(uid);
            if (uname.equals("")) {
                return false;
            } else {
                System.out.println("uname:" + uname);
                conn = ConnectionPoolUtil.getInstance().getConnection();
                String sql = "insert into GISProject.equipmentfix values(null,date_format(Now(),'%Y%m%d'),?,?,?,?,?,?,?,?);";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, ename);
                psmt.setString(2, bname);
                psmt.setString(3, fhousenumber);
                psmt.setInt(4, uid);
                psmt.setString(5, uname);
                psmt.setString(6, ftel);
                psmt.setBoolean(7, false);
                psmt.setString(8, fremark);
                int result = psmt.executeUpdate();
                conn.close();
                psmt.close();
                if (result > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


    public ArrayList<EquipmentFix> queryEquipmentByUid(int uid) throws SQLException {
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        conn = ConnectionPoolUtil.getInstance().getConnection();
        String sql = "select * from GISProject.equipmentfix where uid=? order by fdate desc;";
        psmt = conn.prepareStatement(sql);
        psmt.setInt(1, uid);
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            EquipmentFix equipmentFix = new EquipmentFix();
            equipmentFix.setFid(rs.getInt("fid"));
            equipmentFix.setEname(rs.getString("ename"));
            equipmentFix.setBname(rs.getString("bname"));
            equipmentFix.setFhousenumber(rs.getString("fhousenumber"));
            equipmentFix.setFdate(rs.getDate("fdate"));
            equipmentFix.setFstate(rs.getInt("fstate") == 1 ? true : false);
            equipmentFix.setFtel(rs.getString("ftel"));
            equipmentFix.setUid(rs.getInt("uid"));
            equipmentFix.setUname(rs.getString("uname"));
            equipmentFix.setFremark(rs.getString("fremark"));
            equipmentFixes.add(equipmentFix);
        }
        conn.close();
        psmt.close();
        rs.close();
        System.out.println("equipmentfix:"+equipmentFixes.size());
        return equipmentFixes;
    }

    public ArrayList<EquipmentFix> queryEquipmentAll() throws SQLException {
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        conn = ConnectionPoolUtil.getInstance().getConnection();
        String sql = "select * from GISProject.equipmentfix order by fdate desc,uname asc;";
        psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            EquipmentFix equipmentFix = new EquipmentFix();
            equipmentFix.setFid(rs.getInt("fid"));
            equipmentFix.setEname(rs.getString("ename"));
            equipmentFix.setBname(rs.getString("bname"));
            equipmentFix.setFhousenumber(rs.getString("fhousenumber"));
            equipmentFix.setFdate(rs.getDate("fdate"));
            equipmentFix.setFstate(rs.getInt("fstate") == 1 ? true : false);
            equipmentFix.setFtel(rs.getString("ftel"));
            equipmentFix.setUid(rs.getInt("uid"));
            equipmentFix.setUname(rs.getString("uname"));
            equipmentFix.setFremark(rs.getString("fremark"));
            equipmentFixes.add(equipmentFix);
        }
        conn.close();
        psmt.close();
        rs.close();
        System.out.println("equipmentfix:"+equipmentFixes.size());
        return equipmentFixes;
    }


    public ArrayList<EquipmentFix> queryEquipmentPage(int page) throws SQLException {
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        conn = ConnectionPoolUtil.getInstance().getConnection();
        String sql = "select * from GISProject.equipmentfix order by fdate desc,uname asc limit ?,? ;";
        psmt = conn.prepareStatement(sql);
        psmt.setInt(1, (page-1)*10);
        psmt.setInt(2,10);
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            EquipmentFix equipmentFix = new EquipmentFix();
            equipmentFix.setFid(rs.getInt("fid"));
            equipmentFix.setEname(rs.getString("ename"));
            equipmentFix.setBname(rs.getString("bname"));
            equipmentFix.setFhousenumber(rs.getString("fhousenumber"));
            equipmentFix.setFdate(rs.getDate("fdate"));
            equipmentFix.setFstate(rs.getInt("fstate") == 1 ? true : false);
            equipmentFix.setFtel(rs.getString("ftel"));
            equipmentFix.setUid(rs.getInt("uid"));
            equipmentFix.setUname(rs.getString("uname"));
            equipmentFix.setFremark(rs.getString("fremark"));
            equipmentFixes.add(equipmentFix);
        }
        conn.close();
        psmt.close();
        rs.close();
        System.out.println("equipmentfix:"+equipmentFixes.size());
        return equipmentFixes;
    }

    public ArrayList<EquipmentFix> queryEquipmentByTime(String starttime,String endtime,int page) throws SQLException {
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        conn = ConnectionPoolUtil.getInstance().getConnection();
        String sql = "select * from GISProject.equipmentfix where fdate between ? and ? order by fdate desc,uname asc limit ?,?;";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,starttime);
        psmt.setString(2,endtime);
        psmt.setInt(3, (page-1)*10);
        psmt.setInt(4,10);
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            EquipmentFix equipmentFix = new EquipmentFix();
            equipmentFix.setFid(rs.getInt("fid"));
            equipmentFix.setEname(rs.getString("ename"));
            equipmentFix.setBname(rs.getString("bname"));
            equipmentFix.setFhousenumber(rs.getString("fhousenumber"));
            equipmentFix.setFdate(rs.getDate("fdate"));
            equipmentFix.setFstate(rs.getInt("fstate") == 1 ? true : false);
            equipmentFix.setFtel(rs.getString("ftel"));
            equipmentFix.setUid(rs.getInt("uid"));
            equipmentFix.setUname(rs.getString("uname"));
            equipmentFix.setFremark(rs.getString("fremark"));
            equipmentFixes.add(equipmentFix);
        }
        conn.close();
        psmt.close();
        rs.close();
        System.out.println("equipmentfix:"+equipmentFixes.size());
        return equipmentFixes;
    }
}

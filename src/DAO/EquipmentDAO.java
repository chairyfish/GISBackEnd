package DAO;

import Bean.Equipment;
import Util.ConnectionPoolUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chairyfish on 2017/6/28.
 */
public class EquipmentDAO
{
    Connection conn=null;
    PreparedStatement psmt=null;

    public List<Equipment> queryEquipmentByBid(int bid) throws SQLException{
        List<Equipment> equipments=new ArrayList<Equipment>();
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from GISProject.equipment where bid=?;";
        psmt=conn.prepareStatement(sql);
        psmt.setInt(1,bid);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            Equipment equipment=new Equipment();
            equipment.setBid(rs.getInt("bid"));
            equipment.setEid(rs.getInt("eid"));
            equipment.setEname(rs.getString("ename"));
            equipment.setEnumber(rs.getInt("enumber"));
            equipment.setEunit(rs.getString("eunit"));
            equipment.setEunitprice(rs.getDouble("eunitprice"));
            equipment.setEtotalprice(rs.getDouble("etotalprice"));
            equipment.setEpurchasetime(rs.getTimestamp("epurchasetime"));
            equipment.setEremark(rs.getString("eremark"));
            equipments.add(equipment);
        }
        System.out.println("equipments:"+equipments.size());
        conn.close();
        psmt.close();
        rs.close();
        return equipments;
    }
}

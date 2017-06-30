package DAO;

import Bean.Building;
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
public class BuildingDAO {
    Connection conn=null;
    PreparedStatement psmt=null;

    public ArrayList<Building> queryBuildingByName(String buildingname) throws SQLException{
        ArrayList<Building> buildings=new ArrayList<Building>();
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from GISProject.building where bname=?;";
        psmt=conn.prepareStatement(sql);
        psmt.setString(1,buildingname);
        System.out.println(buildingname);
        ResultSet rs= psmt.executeQuery();
        while(rs.next()){
            Building building=new Building();
            building.setBid(rs.getInt("bid"));
            System.out.println(building.getBid());
            building.setBname(rs.getString("bname"));
            building.setBtype(rs.getString("btype"));
            building.setBdescription(rs.getString("bdescription"));
            building.setBfloor(rs.getInt("bfloor"));
            building.setBimage(rs.getString("bimage"));
            building.setBfunction(rs.getString("bfunction"));
            building.setBcampus(rs.getString("bcampus"));
            buildings.add(building);
        }
        System.out.println("buildings:"+buildings.size());
        conn.close();
        psmt.close();
        rs.close();
        return buildings;
    }

    public Building queryBuildingById(int buildingid) throws SQLException{
        Building building=new Building();
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from GISProject.building where bid=?;";
        psmt=conn.prepareStatement(sql);
        psmt.setInt(1,buildingid);
        ResultSet rs= psmt.executeQuery();
        while(rs.next()){
            building.setBid(rs.getInt("bid"));
            System.out.println(building.getBid());
            building.setBname(rs.getString("bname"));
            building.setBtype(rs.getString("btype"));
            building.setBdescription(rs.getString("bdescription"));
            building.setBfloor(rs.getInt("bfloor"));
            building.setBimage(rs.getString("bimage"));
            building.setBfunction(rs.getString("bfunction"));
            building.setBcampus(rs.getString("bcampus"));
        }
        conn.close();
        psmt.close();
        rs.close();
        return building;
    }

    public ArrayList<Building> queryBuildingByFunc(String function) throws SQLException{
        ArrayList<Building> buildings=new ArrayList<Building>();
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from GISProject.building where bfunction->'$' like '%"+function+"%';";
        System.out.println(sql);
        psmt=conn.prepareStatement(sql);
        ResultSet rs= psmt.executeQuery();
        while(rs.next()){
            Building building=new Building();
            building.setBid(rs.getInt("bid"));
            building.setBname(rs.getString("bname"));
            building.setBtype(rs.getString("btype"));
            building.setBdescription(rs.getString("bdescription"));
            building.setBfloor(rs.getInt("bfloor"));
            building.setBimage(rs.getString("bimage"));
            building.setBfunction(rs.getString("bfunction"));
            building.setBcampus(rs.getString("bcampus"));
            buildings.add(building);
        }
        System.out.println("buildings:"+buildings.size());
        conn.close();
        psmt.close();
        rs.close();
        return buildings;
    }

    public List<Building> queryBuildingByType(String type) throws SQLException{
        List<Building> buildings=new ArrayList<Building>();
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from GISProject.building where btype=?";
        psmt=conn.prepareStatement(sql);
        psmt.setString(1,type);
        ResultSet rs= psmt.executeQuery();
        while(rs.next()){
            Building building=new Building();
            building.setBid(rs.getInt("bid"));
            building.setBname(rs.getString("bname"));
            buildings.add(building);
        }
        System.out.println("buildings:"+buildings.size());
        conn.close();
        psmt.close();
        rs.close();
        return buildings;
    }

  //  public boolean insertBuilding(String bname,String btype,String bdescription )

}

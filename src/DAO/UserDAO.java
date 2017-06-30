package DAO;

import Bean.User;
import Util.ConnectionPoolUtil;
import Util.JSONUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chairyfish on 2017/6/26.
 */
public class UserDAO {

    Connection conn=null;
    PreparedStatement psmt=null;

    public User isLogin(String unumber,String upassword) throws SQLException {
        User user=new User();
        conn= ConnectionPoolUtil.getInstance().getConnection();
        String sql="select * from user where unumber=? and upassword=?;";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1,unumber);
        psmt.setString(2,upassword);
        ResultSet rs = psmt.executeQuery();
        System.out.println("/****************用户登录信息****************/");
        while (rs.next()){
            user.setUid(rs.getInt("uid"));
            user.setUnumber(rs.getString("unumber"));
            user.setUname(rs.getString("uname"));
            user.setUpassword(rs.getString("upassword"));
            user.setUtype(rs.getString("utype"));
        }
        conn.close();
        psmt.close();
        rs.close();
        System.out.print("用户登录查询结束!"+"\n");
        return user;
    }


    public Boolean isRegist(String unumber,String uname,String upassword) throws SQLException {
        if (unumber.equals("") || uname.equals("") || upassword.equals("")) {
            return false;
        } else {
            conn = ConnectionPoolUtil.getInstance().getConnection();
            String sql = "insert into GISProject.user values(null,?,?,?,?);";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, unumber);
            psmt.setString(2, uname);
            psmt.setString(3, upassword);
            psmt.setString(4, "normal");
            int result = psmt.executeUpdate();
            conn.close();
            System.out.println("/****************查询结果****************/");
            if (result > 0)
                return true;
            else
                return false;
        }
    }

    public String UnameById(int uid)throws SQLException{
        if(uid==0){
            return "";
        }else {
            String uname="";
            conn=ConnectionPoolUtil.getInstance().getConnection();
            String sql="select * from user where uid=?;";
            psmt=conn.prepareStatement(sql);
            psmt.setInt(1,uid);
            ResultSet rs=psmt.executeQuery();
            while(rs.next()){
                uname=rs.getString("uname");
            }
            conn.close();
            psmt.close();
            rs.close();
            return uname;
        }
    }
}

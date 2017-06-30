package DAO;

import Bean.Activity;
import Util.ConnectionPoolUtil;
import Util.TimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by chairyfish on 2017/6/29.
 */
public class ActivityDAO
{
    Connection conn=null;
    PreparedStatement psmt=null;

    public ArrayList<Activity> queryActivity(int bid)throws SQLException {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        conn = ConnectionPoolUtil.getInstance().getConnection();
        String sql = "select * from GISProject.activity where bid=? order by astarttime DESC;";
        psmt = conn.prepareStatement(sql);
        psmt.setInt(1, bid);
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            Activity activity = new Activity();
            activity.setAid(rs.getInt("aid"));
            activity.setAname(rs.getString("aname"));
            activity.setAstarttime(rs.getTimestamp("astarttime"));
            activity.setAendtime(rs.getTimestamp("aendtime"));
            activity.setAplace(rs.getString("aplace"));
            activity.setAsponser(rs.getString("asponser"));
            activity.setAintroduction(rs.getString("aintroduction"));
            int state=rs.getTimestamp("astarttime").compareTo(TimeUtil.getTimeStamp());
            activity.setAstate(state > 0 ? true : false);
            activities.add(activity);
        }
        conn.close();
        psmt.close();
        rs.close();
        System.out.println("activities:" + activities.size());
        return activities;
    }

}

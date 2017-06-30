package Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.xmlrpc.base.Array;
import jdk.nashorn.internal.runtime.JSONListAdapter;

import java.io.IOException;
import java.util.*;

/**
 * Created by chairyfish on 2017/6/29.
 */
public class ClassroomUtil {

    /*周信息转记录状态的数组*/
    public static String[] ClassroomWeekInfo(String roomstate) throws IOException {
        String[] states = new String[7];
        states[0] = "000000";
        states[1] = roomstate.substring(1, 7);
        states[2] = roomstate.substring(8, 14);
        states[3] = roomstate.substring(15, 21);
        states[4] = roomstate.substring(22, 28);
        states[5] = roomstate.substring(29, 35);
        states[6] = "000000";
        return states;
    }
    /* * * *
     * 获取今天的状态
     * */
    public static String ClassroomToday(String roomstate) throws IOException {
        String[] roomWeekInfo=ClassroomUtil.ClassroomWeekInfo(roomstate);
        Date date = new Date();
        return roomWeekInfo[TimeUtil.getWeekOfDateNum(date)];
    }

    /* *
     * 根据今天的信息返回json
     */
    public static String getClassroomToday(String todayInfo) {
        Map map=new HashMap<>();
        map.put("1",todayInfo.substring(0,1).equals("0")?false:true);
        map.put("2",todayInfo.substring(1,2).equals("0")?false:true);
        map.put("3",todayInfo.substring(2,3).equals("0")?false:true);
        map.put("4",todayInfo.substring(3,4).equals("0")?false:true);
        map.put("5",todayInfo.substring(4,5).equals("0")?false:true);
        map.put("6",todayInfo.substring(5).equals("0")?false:true);
        return JSONUtil.Map2JSONString(map);
    }

    public static String[] getClassToday(String todayInfo){
        String[] states=new String[6];
        states[0]=todayInfo.substring(0,1);
        states[1]=todayInfo.substring(1,2);
        states[2]=todayInfo.substring(2,3);
        states[3]=todayInfo.substring(3,4);
        states[4]=todayInfo.substring(4,5);
        states[5]=todayInfo.substring(5);
        return states;
    }


}

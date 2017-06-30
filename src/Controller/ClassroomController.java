package Controller;

import Bean.ClassInfoToday;
import Bean.Classroom;
import Bean.Equipment;
import DAO.ClassroomDAO;
import DAO.EquipmentDAO;
import Util.ClassroomUtil;
import Util.EncodingUtil;
import Util.JSONUtil;
import com.mchange.v2.codegen.bean.ClassInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chairyfish on 2017/6/29.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class ClassroomController {

    @RequestMapping(value = "/roomstate", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ClassRoomState(@RequestParam(required = false) String bname, String cnumber) {
        ClassroomDAO classroomDAO = new ClassroomDAO();
        String roomstate = "";
        Map map = new HashMap<>();
        if (bname != null && cnumber != null) {
            try {
                //bname= EncodingUtil.getUTF8(bname);
                roomstate = classroomDAO.queryClassState(bname, cnumber);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (roomstate.equals("")) {
            map.put("result", "fail");
            return JSONUtil.Map2JSONString(map);
        } else {
            String[] todayInfo = new String[6];
            try {
                String todayInfoRaw = ClassroomUtil.ClassroomToday(roomstate);
                todayInfo = ClassroomUtil.getClassToday(todayInfoRaw);
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put("result", "success");
            map.put("roomInfo", todayInfo);
            return JSONUtil.Map2JSONString(map);
        }
    }

    @RequestMapping(value = "/emptyclass", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String AccessEmptyRoom(@RequestParam(required = false) String bname, String classnum) {
        ClassroomDAO classroomDAO = new ClassroomDAO();
        ArrayList<String> roomstates = new ArrayList<String>();
        Map map = new HashMap<>();
        if (bname != null && classnum != null) {
            try {
                //bname = EncodingUtil.getUTF8(bname);
                roomstates = classroomDAO.getRoomByBid(bname);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (roomstates.size() == 0) {
                map.put("result", "fail");
                return JSONUtil.Map2JSONString(map);
            } else {
                ArrayList<String> classrooms = new ArrayList<String>();
                for (int i = 0; i < roomstates.size(); i++) {
                    String todayInfoRaw = "";
                    int classnumber = Integer.valueOf(classnum);
                    if (classnumber < 1 || classnumber > 6) {
                        map.put("result", "fail");
                        return JSONUtil.Map2JSONString(map);
                    } else {
                        try {
                            todayInfoRaw = ClassroomUtil.ClassroomToday(roomstates.get(i));
                            String[] todayInfo = ClassroomUtil.getClassToday(todayInfoRaw);
                            if (todayInfo[classnumber - 1].equals("0")) {
                                classrooms.add(ClassInfoToday.bname.get(i) + ClassInfoToday.cnumbers.get(i));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("Room:" + classrooms.size());
                map.put("result", "success");
                map.put("roomInfo", classrooms);
                return JSONUtil.Map2JSONString(map);
            }

        }
        map.put("result", "fail");
        return JSONUtil.Map2JSONString(map);
    }
}




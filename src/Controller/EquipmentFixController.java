package Controller;

import Bean.EquipmentFix;
import DAO.EquipmentFixDAO;
import Util.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chairyfish on 2017/6/28.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class EquipmentFixController {

    @RequestMapping(value = "/addfix", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addEquipmentFix(@RequestParam(required = false) String ename, String bname, String fhousenumber, String uid, String ftel, String fremark) {
        EquipmentFixDAO equipmentFixDAO = new EquipmentFixDAO();
        Map map = new HashMap<>();
        Boolean addFix = false;
        if (ename != null && bname != null && fhousenumber != null && uid != null && ftel != null) {
            int id = Integer.valueOf(uid);
            try {
                addFix = equipmentFixDAO.addEquipmentFix(ename, bname, fhousenumber, id, ftel, fremark);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (addFix == true) {
            map.put("result", "success");
            return JSONUtil.Map2JSONString(map);
        } else {
            map.put("result", "fail");
            return JSONUtil.Map2JSONString(map);
        }
    }

    @RequestMapping(value = "/fixbyuid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String EquipmentFixByUid(@RequestParam(required = false) String uid) {
        EquipmentFixDAO equipmentFixDAO = new EquipmentFixDAO();
        Map map = new HashMap<>();
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        if (uid != null) {
            int id = Integer.valueOf(uid);
            try {
                equipmentFixes = equipmentFixDAO.queryEquipmentByUid(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (equipmentFixes.size() != 0) {
            map.put("result", equipmentFixes.size());
            map.put("fixInfo", equipmentFixes);
            return JSONUtil.Map2JSONString(map);
        } else {
            map.put("result", 0);
            return JSONUtil.Map2JSONString(map);
        }
    }

    @RequestMapping(value = "/fixall", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String EquipmentFixAll() {
        EquipmentFixDAO equipmentFixDAO = new EquipmentFixDAO();
        Map map = new HashMap<>();
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        try {
            equipmentFixes = equipmentFixDAO.queryEquipmentAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (equipmentFixes.size() != 0) {
            map.put("result", equipmentFixes.size());
            map.put("fixInfo", equipmentFixes);
            return JSONUtil.Map2JSONString(map);
        } else {
            map.put("result", 0);
            return JSONUtil.Map2JSONString(map);
        }
    }

    @RequestMapping(value = "/fixpage", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String EquipmentFixByPage(@RequestParam(required = false) String p) {
        EquipmentFixDAO equipmentFixDAO = new EquipmentFixDAO();
        Map map = new HashMap<>();
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        if (p != null) {
            int page = Integer.valueOf(p);
            try {
                equipmentFixes = equipmentFixDAO.queryEquipmentPage(page);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (equipmentFixes.size() != 0) {
            map.put("result", equipmentFixes.size());
            map.put("fixInfo", equipmentFixes);
            return JSONUtil.Map2JSONString(map);
        } else {
            map.put("result", 0);
            return JSONUtil.Map2JSONString(map);
        }
    }


    @RequestMapping(value = "/fixbytime", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String EquipmentFixByTime(@RequestParam(required = false) String starttime, String endtime, String p) {
        EquipmentFixDAO equipmentFixDAO = new EquipmentFixDAO();
        Map map = new HashMap<>();
        ArrayList<EquipmentFix> equipmentFixes = new ArrayList<EquipmentFix>();
        if (p != null) {
            int page = Integer.valueOf(p);
            try {
                equipmentFixes = equipmentFixDAO.queryEquipmentByTime(starttime, endtime, page);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (equipmentFixes.size() != 0) {
            map.put("result", equipmentFixes.size());
            map.put("fixInfo", equipmentFixes);
            return JSONUtil.Map2JSONString(map);
        } else {
            map.put("result", 0);
            return JSONUtil.Map2JSONString(map);
        }
    }
}

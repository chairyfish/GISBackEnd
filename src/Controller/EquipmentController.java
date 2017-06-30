package Controller;

import Bean.Equipment;
import DAO.EquipmentDAO;
import Util.EncodingUtil;
import Util.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chairyfish on 2017/6/28.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class EquipmentController {

    @RequestMapping(value = "/equipmentbybid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String EquipmentByBid(@RequestParam(required = false)String bid){
        EquipmentDAO equipmentDAO=new EquipmentDAO();
        List<Equipment> equipments=new ArrayList<Equipment>();
        Map map=new HashMap<>();
        if(bid!=null){
            int id= Integer.valueOf(bid);
            try{
                equipments=equipmentDAO.queryEquipmentByBid(id);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(equipments.size()!=0){
            map.put("result",equipments.size());
            map.put("equipmentInfo",equipments);
            return JSONUtil.Map2JSONString(map);
        }else {
            map.put("result",0);
            return JSONUtil.Map2JSONString(map);
        }
    }

}

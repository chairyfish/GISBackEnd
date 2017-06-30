package Controller;

import Bean.Activity;
import DAO.ActivityDAO;
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
 * Created by chairyfish on 2017/6/29.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class ActivityController {

    @RequestMapping(value = "/activitybybid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ActivityByBid(@RequestParam(required = false)String bid){
        ActivityDAO activityDAO=new ActivityDAO();
        List<Activity> activities=new ArrayList<Activity>();
        Map map=new HashMap<>();
        if(bid!=null){
            int id= Integer.valueOf(bid);
            try{
                activities=activityDAO.queryActivity(id);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(activities.size()!=0){
            map.put("result",activities.size());
            map.put("activityInfo",activities);
            return JSONUtil.Map2JSONString(map);
        }else {
            map.put("result",0);
            return JSONUtil.Map2JSONString(map);
        }
    }
}

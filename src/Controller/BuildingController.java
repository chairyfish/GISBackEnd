package Controller;

import Bean.Building;
import DAO.BuildingDAO;
import Util.EncodingUtil;
import Util.JSONUtil;
import com.mysql.fabric.xmlrpc.base.Array;
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
public class BuildingController
{

    @RequestMapping(value = "/buildingbyname", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String BuildingByName(@RequestParam (required=false) String bname ){
        BuildingDAO buildingDAO=new BuildingDAO();
        ArrayList<Building> buildings=new ArrayList<Building>();
        Map map=new HashMap<>();
        if(bname!=null){
            try{
      //          bname= EncodingUtil.getUTF8(bname);
                buildings=buildingDAO.queryBuildingByName(bname);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(buildings.size()!=0){
            map.put("result",buildings.size());
            map.put("buildingInfo",buildings);
            return JSONUtil.Map2JSONString(map);
        }else {
            map.put("result",0);
            return JSONUtil.Map2JSONString(map);
        }
    }

    @RequestMapping(value = "/buildingbyid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String BuildingById(@RequestParam (required=false) String bid ){
        BuildingDAO buildingDAO=new BuildingDAO();
        Building building=new Building();
        Map map=new HashMap<>();
        if(bid!=null){
            int id=Integer.valueOf(bid);
            try{
                //bname= EncodingUtil.getUTF8(bname);
                building=buildingDAO.queryBuildingById(id);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(building.getBid()!=0){
            map.put("result","success");
            map.put("buildingInfo",building);
            return JSONUtil.Map2JSONString(map);
        }else {
            map.put("result","fail");
            return JSONUtil.Map2JSONString(map);
        }
    }


    @RequestMapping(value = "/buildingbyfunc", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String BuildingByFunc(@RequestParam (required=false) String bfunction ){
        BuildingDAO buildingDAO=new BuildingDAO();
        ArrayList<Building> buildings=new ArrayList<Building>();
        Map map=new HashMap<>();
        if(bfunction!=null){
            try{
                //bfunction= EncodingUtil.getUTF8(bfunction);
                buildings=buildingDAO.queryBuildingByFunc(bfunction);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(buildings.size()!=0){
            map.put("result",buildings.size());
            map.put("buildingInfo",buildings);
            return JSONUtil.Map2JSONString(map);
        }else {
            map.put("result",0);
            return JSONUtil.Map2JSONString(map);
        }
    }

    @RequestMapping(value = "/buildingbytype", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String BuildingByType(@RequestParam (required=false) String btype ){
        BuildingDAO buildingDAO=new BuildingDAO();
        List<Building> buildings=new ArrayList<Building>();
        Map map=new HashMap<>();
        if(btype!=null){
            try{
                //btype= EncodingUtil.getUTF8(btype);
                buildings=buildingDAO.queryBuildingByType(btype);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(buildings.size()!=0){
            map.put("result",buildings.size());
            map.put("buildingInfo",buildings);
            return JSONUtil.Map2JSONString(map);
        }else {
            map.put("result",0);
            return JSONUtil.Map2JSONString(map);
        }
    }

}

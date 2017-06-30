package Controller;

import Bean.User;
import DAO.UserDAO;
import Util.JSONUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chairyfish on 2017/6/26.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class UserController {

    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String UserLogin(@RequestParam (required=false)String number, String password) {
        UserDAO userDAO = new UserDAO();
        Map map = new HashMap();
        User user = new User();
        if (number!=null && password!=null) {
            try {
                user = userDAO.isLogin(number, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (!user.getUname().equals("")) {
            map.put("login", "success");
            map.put("userInfo", user);

        } else {
            map.put("login", "fail");
        }
        return JSONUtil.Map2JSONString(map);
    }

    @RequestMapping(value = "/regist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String UserRegist(@RequestParam (required=false)String number, String name,String password) {
        UserDAO userDAO = new UserDAO();
        Map map = new HashMap();
        Boolean result=false;
        if (number!=null&&name!=null&&password!=null) {
            try {
                result = userDAO.isRegist(number,name,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (result==true) {
            map.put("regist", "success");
        } else {
            map.put("regist", "fail");
        }
        return JSONUtil.Map2JSONString(map);
    }
}

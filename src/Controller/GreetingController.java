package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chairyfish on 2017/6/24.
 */

@Controller
public class GreetingController {
    @RequestMapping(value = "/test",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String GreetingController(){
        return "{\"result\":\"fail\"}";
    }
}

package Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by chairyfish on 2017/6/26.
 */
public class JSONUtil {


    /*
     * 类对象转json字符串
     */
    public static String Object2JSONString(Object object){
        ObjectMapper mapper=new ObjectMapper();
        String json=null;
        try{
            json=mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println(json);
        return json;

    }


    public static String Map2JSONString(Map map){
        ObjectMapper mapper = new ObjectMapper(); //转换器
        String json= null; //将对象转换成json
        try {
            json = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }



}

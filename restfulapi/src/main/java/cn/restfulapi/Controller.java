package cn.restfulapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
public class Controller {
    String  JSON_ARRAY_STR =  " [{\"id\":1,\"content\":\"study\"}," +
            "{\"id\":2,\"content\":\"eat\"}]";
    JSONArray AffairJsonArray = JSON.parseArray(JSON_ARRAY_STR);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getAll() throws IOException {
       return AffairJsonArray.toString();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getOne(@PathVariable int id){
        //JSONObject getObj=AffairJsonArray.getJSONObject(i).get(id);
        for (int i = 0; i< AffairJsonArray.size(); i++){
            if (AffairJsonArray.getJSONObject(i).containsValue(id))
            {
                return AffairJsonArray.get(i).toString();
            }
        }
        return "Not Found";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        for (int i = 0; i< AffairJsonArray.size(); i++){
            if (AffairJsonArray.getJSONObject(i).containsValue(id))
            {
                 AffairJsonArray.remove(i);
                 return "Delete Success";
            }
        }
        return "Delete Success";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String add(@RequestParam int id,@RequestParam String content){
        JSONObject affairJsonObject=new JSONObject();
        affairJsonObject.put("id",id);
        affairJsonObject.put("content",content);
        AffairJsonArray.add(affairJsonObject);
        return "insert "+content+" success.";

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
/**
 *
 * @author yiwenren
 */
public class register {
    Gson gson = new Gson();
    
    public void registert(){
        setRegister();
    }
    
    private void setRegister(){
        get("/register",(request, response) ->{
            Map<String, Object> data = new HashMap();
            data.put("register","goodluck");
            return data;
       },gson::toJson);
        
        get("/index",(request, response) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("title1", "welcome");
            return data;
        },gson::toJson);
        
        get("/index",(request, response) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("title2", "title2");
            return new ModelAndView(data, "index.ftl"); 
        },gson::toJson);
        
        
    }
    
}

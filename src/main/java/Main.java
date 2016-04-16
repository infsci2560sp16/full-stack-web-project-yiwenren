// import static javax.measure.unit.SI.KILOGRAM;
// import javax.measure.quantity.Mass;
// import org.jscience.physics.model.RelativisticModel;
// import org.jscience.physics.amount.Amount;
//
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.text.SimpleDateFormat;

import java.net.URI;
import java.net.URISyntaxException;
import com.google.gson.Gson;
import org.json.JSONObject;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    Object register = new register();
 

    // get("/hello", (req, res) -> {
    //   RelativisticModel.select();
    //
    //   String energy = System.getenv().get("ENERGY");
    //
    //   Amount<Mass> m = Amount.valueOf(energy).to(KILOGRAM);
    //   return "E=mc^2: " + energy + " = " + m.toString();
    // });

    get("/", (request, response) -> {
          Map<String, Object> attributes = new HashMap<>();
          //attributes.put("title1", "title1");
          attributes.put("title2", "title3");
          attributes.put("title1", "title1");
          attributes.put("title", "title2");
          attributes.put("dayOfWeek", "Monday");
        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());
    
    get("/index", (request, response) -> {
          Map<String, Object> attributes = new HashMap<>();
          //attributes.put("title1", "title1");
          attributes.put("title2", "title3");
          attributes.put("title1", "title1");
          attributes.put("title", "title2");
          attributes.put("dayOfWeek", "Monday");
        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());
    
    /*get("/like", (request, response) -> {
        String words = "sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia";
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("title","helloTitle");
        attributes.put("words",words); 
               
        
        for(int i = 4; i<=11; i++){
            String img1 = "img"+(i+1);
            String img2 = " <img src= \"image/c-"+(i+1)+".jpg\" alt=\"content"+i+"\">";
            attributes.put(img1,img2);
        }
       return new ModelAndView(attributes, "like.ftl");
    }, new FreeMarkerEngine());*/
        
   
    
    
    
    
    

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());
    
    
    //response to post json
    post("/postMessage",(req, res) ->{
        Connection connection = null;
        System.out.println(req.body());
        try{
            connection = DatabaseUrl.extract().getConnection();
            JSONObject obj = new JSONObject(req.body());
            String username = obj.getString("username");
            String email = obj.getString("email");
            String password = obj.getString("password");
            
            String sql = "INSERT INTO student(username, email, password) VALUES ('" + username + "','" + email +"','" + password + "')";
            
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);

           //**Testing**
         System.out.println(username);
         System.out.println(email);
         System.out.println(password);

         return req.body();
        } catch (Exception e){
            return e.getMessage();
        } finally{
            
        }
    });
    

  }

}
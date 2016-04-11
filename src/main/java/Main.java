// import static javax.measure.unit.SI.KILOGRAM;
// import javax.measure.quantity.Mass;
// import org.jscience.physics.model.RelativisticModel;
// import org.jscience.physics.amount.Amount;
//
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

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
        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());
    
    get("/index", (request, response) -> {
          Map<String, Object> attributes = new HashMap<>();
          attributes.put("title1", "Hello World!");

        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());
    
    
    
    

    /*get("/db", (req, res) -> {
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
    }, new FreeMarkerEngine());*/

  }

}
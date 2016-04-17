/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yiwenren
 */

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;


import org.json.JSONObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static spark.Spark.get;
import static spark.Spark.*;
import java.sql.*;
import java.util.ArrayList;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import com.heroku.sdk.jdbc.DatabaseUrl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerRoute {
    Gson gson = new Gson();

  /*public ServerRoute() {
    setupRoutes();
  }

   private void setupRoutes() {
        //get JSON through API
    get("api/userDetail",(req, res) -> {
        Map<String, Object> data = new HashMap<>();
        data.put("username","Emma");
        data.put("introduction", "Hello everyone, what's up?");
        return data;
    },gson::toJson);
   }*/
    
}

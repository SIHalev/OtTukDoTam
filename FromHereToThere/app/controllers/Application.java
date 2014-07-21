package controllers;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.User;
import play.*;
import play.data.DynamicForm;
import play.data.DynamicForm.Dynamic;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.twirl.api.Content;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	//return redirect("/login"); // Testing redirecting.
        return ok(index.render("in index"));
    }
    
    public static Result login() {
    	
    	//String user = session("connected");
    	String req = request().toString();
       // if(user != null) {     
       // 	return ok(login.render(session("email") + "|" + session("password") + "---" + req));
       // } else {
        	return ok(login.render("no input data " + req));
        //}
  	
    }
    
    public static Result afterPost() {
    	//Form<User> userForm = Form.form(User.class);
    	//User user = userForm.bindFromRequest().get();
    	////userForm = userForm.fill(new User("bob@gmail.com", "secret"));
    	  	
    	//User user = Form.form(User.class).bindFromRequest().get(); // returning nulls
    	
    	// Working
    	DynamicForm dynamicForm = Form.form().bindFromRequest();       	
    	Dynamic user = dynamicForm.bindFromRequest().get();  
    	
    	Map dataMap = user.getData();
    	
    	
    	//validation pattern
    	//Pattern p = Pattern.compile("[0-9]");
    	//Matcher m = p.matcher(str); //str is the String that needs validating
    	//
    	
    	
    	//session("connected", "true");
    	//TODO: make it a loop + remove password.
    	//session("email", dataMap.get("email").toString());
    	//session("password", dataMap.get("password").toString()); // For test...
    		
    	
    	// session().clear(); // For log out button
    	
    	return ok(Json.toJson(user));
    	
    	  	
    	//Map<String,String> anyData = new HashMap();
    	//anyData.put("email", "bob@gmail.com");
    	//anyData.put("password", "secret");
    	//User user = userForm.bind(anyData).get();
    	    	
    	//return ok(user.getData().get("email").toString()); // Getting smt from form.
    	//return ok(Json.toJson(user.getData())); // Testing to json method.
    	
    	//return ok("Username is: " + dynamicForm.get("email"));
        /*
    	String req = request();
    	
    	return ok(login.render("trying to login " + req));*/
    }
    
  
}

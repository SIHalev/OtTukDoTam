package controllers;

import java.sql.*;

import com.fasterxml.jackson.databind.JsonNode;
//import com.mysql.jdbc.Connection;





import models.DBConnection;
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

/*	public static Connection connect(String url, String user, String password) {
		Connection result = null;
		try {
			return result = DriverManager.getConnection(url, user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}*/

	private static int enterCity(String city)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		
		Connection connection = DBConnection.getConnection();
		//Class.forName(driver).newInstance();
		String query = "INSERT INTO city(name)VALUES('" + city + "');";
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		return result;
	}

	public static Result index() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// return redirect("/login"); // Testing redirecting.
		
		
		int x;
		String str = "burgas";
		x = enterCity(str);
		return ok(index.render("in index "+ x));

	}

	public static Result login() {

		// String user = session("connected");
		String req = request().toString();
		// if(user != null) {
		// return ok(login.render(session("email") + "|" + session("password") +
		// "---" + req));
		// } else {
		return ok(login.render("no input data " + req));
		// }

	}

	public static Result afterPost() {
		// Form<User> userForm = Form.form(User.class);
		// User user = userForm.bindFromRequest().get();
		// //userForm = userForm.fill(new User("bob@gmail.com", "secret"));

		// User user = Form.form(User.class).bindFromRequest().get(); //
		// returning nulls

		// Working
		DynamicForm dynamicForm = Form.form().bindFromRequest();
		Dynamic user = dynamicForm.bindFromRequest().get();

//		Map dataMap = user.getData();

		// validation pattern
		// Pattern p = Pattern.compile("[0-9]");
		// Matcher m = p.matcher(str); //str is the String that needs validating
		//

		// session("connected", "true");
		// TODO: make it a loop + remove password.
		// session("email", dataMap.get("email").toString());
		// session("password", dataMap.get("password").toString()); // For
		// test...

		// session().clear(); // For log out button

		return ok(Json.toJson(user));

		// Map<String,String> anyData = new HashMap();
		// anyData.put("email", "bob@gmail.com");
		// anyData.put("password", "secret");
		// User user = userForm.bind(anyData).get();

		// return ok(user.getData().get("email").toString()); // Getting smt
		// from form.
		// return ok(Json.toJson(user.getData())); // Testing to json method.

		// return ok("Username is: " + dynamicForm.get("email"));
		/*
		 * String req = request();
		 * 
		 * return ok(login.render("trying to login " + req));
		 */
	}
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		int x;
		x=enterCity("varna");
	}
}

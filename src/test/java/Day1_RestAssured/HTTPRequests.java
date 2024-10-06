package Day1_RestAssured;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {
	@Test
	void getuser()
	{
		given()
		
		.when ()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		   .statusCode(200)
		   .body("page",equalTo(2))
		   .log().all();
	}
	@Test(priority=2)
	void createuser()
	{
		HashMap data = new HashMap();
		data.put("name", "jaya");
		data.put("job", "QA engineer");
		
		given()
		 .contentType("application/json")
		 .body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		  
		  .then()
		    .statusCode(201)
		    .body("name",equalTo("jaya"))
		    .body("job",equalTo("QA engineer"))
		    .log().all();				
	}

}

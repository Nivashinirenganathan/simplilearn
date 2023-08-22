package in.amazon.RestAssuredDemo;

import java.util.UUID;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;
import static org.hamcrest.Matchers.is;

public class ReqResProject extends TestBase {

	HashMap<String, String> map = new HashMap<String, String>();

	UUID uuid = UUID.randomUUID();

	Response response;
	JsonPath jsonPath;

	@Test(priority=0)
	public void createPayload() {
		map.put("name","morpheus");
		map.put("job","leader");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
		logger.info("Payload created");
	}

	@Test(priority=1)

	public void createResource() {
		response = RestAssured
				.given()
				.contentType("application/json")
				.body(map)

				.when()
				.post()
				.then()

				.extract().response();
		logger.info("Resource created successfully");
		jsonPath = response.jsonPath();


	}

	@Test(priority=2)
	public void verifyResource() {

		RestAssured
		.given()
		.contentType("application/json")

		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200);

		logger.info("Resource verified");

		Assert.assertTrue(jsonPath.get("name").equals("morpheus"));

	}
	@Test(priority=3)
	public void updateResource() {
		map.put("name", "john");
		map.put("job", "programmer");
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/686";
        RestAssured
		.given()
		.contentType("application/json")
		.body(map)

		.put()
		.then()
		.statusCode(200)
  
		.assertThat()	
		.body("name",is("john"));
		logger.info("Resouce updated");
	}
	@Test(priority=4)
	public void deleteResource() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/686";
		RestAssured
		.given()
		.contentType("application/json")

		.when() 
		.delete()
		.then()
		.statusCode(204);
		logger.info("Resource deleted");
	}
}

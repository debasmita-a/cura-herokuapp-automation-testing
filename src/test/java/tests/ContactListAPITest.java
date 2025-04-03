package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ContactListAPITest {

	private static final String BASE_URL = "https://thinking-tester-contact-list.herokuapp.com/users";
	private static final String LOGIN_URL = "https://thinking-tester-contact-list.herokuapp.com/users/login";
	private static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2VlNGJjMzRhMDAwNDAwMTM5ZGI3OWUiLCJpYXQiOjE3NDM2NzQyNzh9.DGrruxR9PBg9xK8f9h5rFnEtjpJFcq5OZU3bcuakfeE";
	
	@Test
	public void addUserTest() {
		String data = "{\r\n"
				+ "    \"firstName\": \"Test\",\r\n"
				+ "    \"lastName\": \"User\",\r\n"
				+ "    \"email\": \"test@fake4405.com\",\r\n"
				+ "    \"password\": \"myPassword\"\r\n"
				+ "}";
		
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer" + " " + TOKEN)
		.log().all()
		.body(data)
		.post(BASE_URL);
		
		response.prettyPrint();
		
		System.out.println(response.getStatusCode());
	}
	
	@Test
	public void loginTest() {
		String loginData = "{\r\n"
				+ "    \"email\": \"debasmitaadhikari26@gmail.com\",\r\n"
				+ "    \"password\": \"testSwiggy@1!\"\r\n"
				+ "}";
		
		Response response = RestAssured.given().contentType(ContentType.JSON)
		.log().all()
		.body(loginData)
		.post(LOGIN_URL);
		
		response.prettyPrint();
		TOKEN = response.jsonPath().getString("token");
		System.out.println(response.getStatusCode());
	}
}

# Data-Driven POM Test Framework with Selenium & TestNG 
The Herokuapp is a simple app with 3 pages, the Login, Appointment and Confirmation pages. The Appointment page has select dropdowns, radio buttons, text fields and checkbox fields.
The Header and Footer componenets are static. 
The goal is to provide test data using Data Providers using TestNG library and verify different combinations of the data.

## Tools and Libraris used :
1. [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.30.0)
2. [TestNG](https://mvnrepository.com/artifact/org.testng/testng) 
3. [Project Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok) : To be used to reduce boilerplate code in Java POJO classes.
4. [Owner](https://mvnrepository.com/artifact/org.aeonbits.owner/owner/1.0.12) : To read properties files.
5. [Fixture factory](https://mvnrepository.com/artifact/br.com.six2six/fixture-factory/3.1.0) : To generate testdata rules, to pass to the data provider methods. 
6. [Extent Reports](https://mvnrepository.com/artifact/com.aventstack/extentreports/5.1.2) : To generate test reports.

## Test cases :
1. Login with correct username and password
2. Login with incorrect username and passowrd (or any combinations of it)
3. Make An Appointment by filling appointment form - provide testdata with different combinations of testdata choices using Fixture factory library
4. Confirm Appointment details
5. Go to homepage and Logout

## Testcase : Login with different combinations of username and password :
```
@Test(dataProvider = "getData")
  public void userLoginTest(String username, String password, boolean flag) {
		loginPage = headerComponent.navigateToLoginPage();
		appointmentPage = loginPage.doLogin(username, password);
		if (flag) {
			Assert.assertTrue(appointmentPage.getAppointmentPageUrl());
		} else {
			String error_msg = loginPage.getErrorMessage();
			Assert.assertTrue(error_msg.equals(FrameworkConstants.ERROR_MSG));
		}
	}
```
## Testcase : Fill appointment details : 
```
	@Test(dataProvider="getAppointmentData", dataProviderClass= DataProviderClass.class)
	public void fillAppointmentDetailsTest(AppointmentData data) {
		appointmentPage = headerComponent.navigateToLoginPage().doLogin(getConfig().username(), getConfig().password());
		appointmentPage.fillAppointmentDetails(data);
	}
```
## Data Provider class :
```
	@DataProvider
	public static Object[][] getAppointmentData() {
		AppointmentData data1 = Fixture.from(AppointmentData.class).gimme("valid");
		AppointmentData data2 = Fixture.from(AppointmentData.class).gimme("valid");
		return new Object[][] { {data1}, {data2} };
	}
	
	@DataProvider
	public static Object[][] getAppointmentDataValid() {
		AppointmentData data = Fixture.from(AppointmentData.class).gimme("valid");
		return new Object[][] { {data} };
	}
	
	@DataProvider(parallel = true)
	public static Object[][] getData() {
		return new Object[][] { 
			{ "John Doe", "ThisIsNotAPassword", true },
			{ "John Doe1", "ThisIsNotAPassword1", false }, 
			{ "", "ThisIsNotAPassword", false },
			{ "John Doe", "", false } };
	}
```
## LambdaTest run screenshots :

![alt text][Screenshot 01]

[Screenshot 01]: https://github.com/debasmita-a/cura-herokuapp-automation-testing/blob/master/screenshots/lambdatest_01.jpeg "LambdaTest 01"

![alt text][Screenshot 02]

[Screenshot 02]: https://github.com/debasmita-a/cura-herokuapp-automation-testing/blob/master/screenshots/lambdatest_02.jpeg "LambdaTest 02"

![alt text][Screenshot 03]

[Screenshot 03]: https://github.com/debasmita-a/cura-herokuapp-automation-testing/blob/master/screenshots/ExtentReportFinal.jpeg "Extent Report 01"

![alt text][Screenshot 04]

[Screenshot 04]: https://github.com/debasmita-a/cura-herokuapp-automation-testing/blob/master/screenshots/ExtentReportFinal_Stats.jpeg "Extent Report 02"

![alt text][Screenshot 05]

[Screenshot 05]: https://github.com/debasmita-a/cura-herokuapp-automation-testing/blob/master/screenshots/TestNGSummary.jpeg "TestNG Summary"

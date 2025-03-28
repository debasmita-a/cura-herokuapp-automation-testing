package frameworkConstants;

public class FrameworkConstants {
	
	private FrameworkConstants() {}
	
	private static final String CONFIF_FILE_PATH = ".src/test/resources/config/config.properties";
	private static final String EXCEL_FILE_PATH = ".src/test/resources/testdata/testdata.xlsx";

	public static String getConfifFilePath() {
		return CONFIF_FILE_PATH;
	}
	public static String getExcelFilePath() {
		return EXCEL_FILE_PATH;
	}
	
	public static final String HEADER_TEXT = "CURA Healthcare Service";
	public static final String APPOINTMENT_PAGE_URL = "#appointment";
	public static final String LOGIN_PAGE_URL = "#login";
	public static final String CONFIRMATION_PAGE_URL = "#summary";
	public static final String CONFIRMATION = "Appointment Confirmation";
	public static final String ERROR_MSG = "Login failed! Please ensure the username and password are valid.";
	public static final String LOGIN_LEAD_TEXT = "Please login to make appointment.";
}

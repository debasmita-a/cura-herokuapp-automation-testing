package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> tl_extent = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return tl_extent.get();
	}

	static void setExtentTest(ExtentTest test) {
		tl_extent.set(test);
	}

	static void unload() {
		tl_extent.remove();
	}
}

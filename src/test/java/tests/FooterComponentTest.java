package tests;

import org.testng.annotations.Test;

import basetest.BaseTest;

public final class FooterComponentTest extends BaseTest{

	private FooterComponentTest() {}
	
	@Test
	public void getFooterHeaderTextTest() {
		String text = footerComponent.getFooterHeaderText();
		System.out.println(text);
	}
	
	@Test
	public void getFooterAddressTextTest() {
		String text = footerComponent.getFooterAddressText();
		System.out.println(text);
	}
	
	@Test
	public void getFooterContactTextTest() {
		String text = footerComponent.getFooterContactText();
		System.out.println(text);
	}
	
	@Test
	public void getFooterMediaLinksTextTest() {
		String text = footerComponent.getFooterMediaLinksText();
		System.out.println(text);
	}
	
	@Test
	public void getFooterCopyrightTextTest() {
		String text = footerComponent.getFooterCopyrightText();
		System.out.println(text);
	}
	
}

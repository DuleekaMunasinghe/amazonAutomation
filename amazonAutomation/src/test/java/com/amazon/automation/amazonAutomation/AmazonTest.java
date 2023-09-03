package com.amazon.automation.amazonAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.automation.helpers.BaseTest;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.pages.ProductPage;

public class AmazonTest extends BaseTest {

	@Test
	public void testSearchResultsDisplayed() {
		AmazonHomePage homePage = new AmazonHomePage(driver); // page object for AmazonHomePage
		homePage.searchForProduct("hp laptop");
		ProductPage productPage = new ProductPage(driver);    // page object for ProductPage
		int numberOfResults = productPage.getNumberOfSearchResults();

		Assert.assertTrue(numberOfResults > 0, "No search results found.");  
		//TestNG Assert: as the number of items vary all the time, just checking any search result by this condition 
	}
}

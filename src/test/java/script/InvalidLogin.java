package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;

public class InvalidLogin extends BaseTest 
{
	@Test(priority=2)
	public void testInvalidLogin()
	{
		String un=Utility.getXLCellData(XL_PATH, "InvalidLogin", 1, 0);
		String pw=Utility.getXLCellData(XL_PATH, "InvalidLogin", 1, 1);
//		1. enter invalid UserName
		LoginPage loginpage=new LoginPage(driver);
		test.info("enter invalid UserName:"+un);
		loginpage.setUserName(un);
//		2. enter invalid Password
		test.info("enter invalid Password:"+pw);
		loginpage.setPassword(pw);
//		3. click on go button
		test.info("Click on Go Button");
		loginpage.clickGoButton();
//		4. should display error message
		test.info(" should display error message");
		boolean result=loginpage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result);
	}
}

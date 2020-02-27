package com.eapplycalculators.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.eapplycalculators.pageObject.eApplyCalculatorPage;

public class TC_PremimCalculator extends BaseClass{
	@Test
	public void PremiumCaculator() throws IOException {
		driver.get(BaseURL);
		logger.info("URL is Opened");
	eApplyCalculatorPage calPage=new eApplyCalculatorPage(driver);
	
	//Personal Details Section
	calPage.enterDateofBirth("01/01/1988");
	logger.info("Enetred Date of Birth");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	calPage.clickGenderMale();
	calPage.click15hrYes();
	calPage.clickSelfEmpNo();
	calPage.selectIndustry("Aviation");
	calPage.selectOccupation("Cabin Crew");
    calPage.enterAnnualSalary("100000.0");
    calPage.selectPaymentFreq("Weekly");
   
    //Cost Calculator Section
    calPage.clickDeathCatFixed();
    calPage.enterDeathFixedCoverAmount("200000");
    
    //calPage.clickTPDCatFixed();
    calPage.enterTPDFixedCoverAmount("200000");
    
    calPage.selectWaitPeriod("90 Days");
    calPage.selectBenefitPeriod("2 Years");
    calPage.enterIPUnits("2");
    calPage.clickDisclaimer();
    calPage.clickCalculate();
    calPage.valDeathCoverAmt("$200,000.00");
    calPage.valTPDCoverAmt("$200,000.00");
    calPage.valIPCoverAmt("$867.00");
    calPage.valDeathCost("$1.69");
    calPage.valTPDCost("$1.50");
    calPage.valIPCost("$0.31");
    calPage.valTotalCost("$3.50");
	captureScreen(driver,"loginTest");
	}

}

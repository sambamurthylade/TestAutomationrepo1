package com.eapplycalculators.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eapplycalculators.pageObject.eApplyCalculatorPage;
import com.eapplycalculators.utilities.XLUtils;

public class TC_eApplyCalDDT extends BaseClass {

	@Test(dataProvider="eApplyCalclatorData")
	public void eApplyCalculator(String str1, String str2,String str3,String str4,String str5,String str6,String str7,
			String str8,String str9,String str10,String str11,String str12,String str13,String str14,
			String str15,String str16,String str17) throws IOException {
		
		driver.get(BaseURL);
		logger.info("URL is Opened");
	eApplyCalculatorPage calPage=new eApplyCalculatorPage(driver);
	
	//Personal Details Section
	calPage.enterDateofBirth(str1);
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
	calPage.selectIndustry(str2);
	calPage.selectOccupation(str3);
    calPage.enterAnnualSalary(str4);
    calPage.selectPaymentFreq(str5);
   
    //Cost Calculator Section
    calPage.clickDeathCatFixed();
    calPage.enterDeathFixedCoverAmount(str6);
    
    //calPage.clickTPDCatFixed();
    calPage.enterTPDFixedCoverAmount(str7);
    
    calPage.selectWaitPeriod(str8);
    calPage.selectBenefitPeriod(str9);
    calPage.enterIPUnits(str10);
    calPage.clickDisclaimer();
    calPage.clickCalculate();
    calPage.valDeathCoverAmt(str11);
    calPage.valTPDCoverAmt(str12);
    calPage.valIPCoverAmt(str13);
    calPage.valDeathCost(str14);
    calPage.valTPDCost(str15);
    calPage.valIPCost(str16);
    calPage.valTotalCost(str17);
	captureScreen(driver,"loginTest");
		
	}
	
	@DataProvider(name="eApplyCalclatorData")
	String[][] getData() throws IOException{
	String path=System.getProperty("user.dir")+"/src/test/java/com/eapplycalculators/testData/TestData.xlsx";
	
	int rownum=XLUtils.getRowCount(path, "sheet1");
	int colcount=XLUtils.getCellCount(path, "sheet1", 1);
	String EapplyCalData[][]=new String[rownum][colcount];
	for(int i=1;i<=rownum;i++) {
		for(int j=0;j<colcount;j++) {
			EapplyCalData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			System.out.println(EapplyCalData[i-1][j]);
		}
	 }
	
	return EapplyCalData;
	}
	
}

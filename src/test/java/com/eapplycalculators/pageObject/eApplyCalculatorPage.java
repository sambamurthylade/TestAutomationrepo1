package com.eapplycalculators.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class eApplyCalculatorPage {
	
	WebDriver ldriver;
	
	public eApplyCalculatorPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Personal Details 
	
	@FindBy(name="dob")
	WebElement txtdateofbirth;
	
	@FindBy(xpath="//input[@name='gender'][@value='Male']/parent::label")
	WebElement btngenderMale;
	
	@FindBy(xpath="//input[@name='workHours'][@value='Yes']/parent::label")
	WebElement btnworkhoursYes;
	
	@FindBy(xpath="//input[@name='employedques'][@value='No']/parent::label")
	WebElement btnselfEmployNo;
	
	@FindBy(xpath="//select[@name='industry']")
	WebElement selIndustry;
	
	@FindBy(xpath="//select[@name='occupation']")
	WebElement selOccupation;
	
	@FindBy(name="annualSalary")
	WebElement txtAnnualSalary;	

	@FindBy(xpath="//select[@name='premFreq']")
	WebElement selPaymentFreq;
	
	// Cost Details
	
	@FindBy(xpath="//input[@name='deathcoverCategory'][@value='DcFixed']/parent::label")
	WebElement btnDeathCatFixed;
	
	@FindBy(xpath="//input[@name='deathCoverAmount']")
	WebElement txtDeathFixedCoverAmount;
	
	
	@FindBy(xpath="//input[@name='tpdcoverCategory'][@value='TPDFixed']/parent::label")
	WebElement btnTPDCatFixed;
	
	@FindBy(xpath="//input[@name='tpdCoverAmount']")
	WebElement txtTPDFixedCoverAmount;
		
	@FindBy(xpath="//select[@name='ipWaitingPeriod']")
	WebElement selWaitPeriod;
	
	@FindBy(xpath="//select[@name='ipBenefitPeriod']")
	WebElement selBenefitPeriod;
	
	@FindBy(xpath="//input[@name='ipCoverUnit']")
	WebElement txtIPCoverUnits;
	
	@FindBy(xpath="//input[@name='disclaimer'][@type='checkbox']/parent::label")
	WebElement chkDisclaimer;
	
	@FindBy(xpath="//button[contains(text(),'Calculate')]")
	WebElement btnCalculate;
	
	@FindBy(xpath="(//label[contains(text(),'Cover Amount')]/parent::div/following-sibling::div/h5)[1]")
	WebElement gettxtDeathCoverAmount;
	
	@FindBy(xpath="(//label[contains(text(),'Cover Amount')]/parent::div/following-sibling::div/h5)[2]")
	WebElement gettxtTPDCoverAmount;
	
	@FindBy(xpath="(//label[contains(text(),'Cover Amount')]/parent::div/following-sibling::div/h5)[3]")
	WebElement gettxtIPCoverAmount;
	
	@FindBy(xpath="(//label[contains(text(),'Cover Amount')]/parent::div/../following-sibling::div/div[2]/h5)[1]")
	WebElement gettxtDeathCost;
	
	@FindBy(xpath="(//label[contains(text(),'Cover Amount')]/parent::div/../following-sibling::div/div[2]/h5)[2]")
	WebElement gettxtTPDCost;
	
	@FindBy(xpath="(//label[contains(text(),'Cover Amount')]/parent::div/../following-sibling::div/div[2]/h5)[3]")
	WebElement gettxtIPCost;
	
	@FindBy(xpath="//h5[starts-with(@class,'total-cost-value')]")
	WebElement gettxtTotalcost;
	
	//Methods for Personal Details Filling
	
	public void enterDateofBirth(String dob) {
		txtdateofbirth.sendKeys(dob);
		txtdateofbirth.sendKeys(Keys.TAB);
	}
	
	public void clickGenderMale() {
		btngenderMale.click();
	}
	
	public void click15hrYes() {
		btnworkhoursYes.click();
	}
	public void clickSelfEmpNo() {
		btnselfEmployNo.click();
	}
	public void selectIndustry(String Industrytext) {
		Select Industry=new Select(selIndustry);
		Industry.selectByVisibleText(Industrytext);
	}
	public void selectOccupation(String OccupationText) {
		Select Occupation=new Select(selOccupation);
		Occupation.selectByVisibleText(OccupationText);
	}
	
	public void enterAnnualSalary(String Salary) {
		txtAnnualSalary.sendKeys(Salary);
		txtAnnualSalary.sendKeys(Keys.TAB);
	}
	
	public void selectPaymentFreq(String PaymenentFreqText) {
		Select PaymentFreq=new Select(selPaymentFreq);
		PaymentFreq.selectByVisibleText(PaymenentFreqText);
	}
	
	//Methods for Cost Details Filling
	
	public void clickDeathCatFixed() {
		btnDeathCatFixed.click();
	}
	
	public void enterDeathFixedCoverAmount(String DeathFixedCoverAmount) {
		txtDeathFixedCoverAmount.sendKeys(DeathFixedCoverAmount);
		txtDeathFixedCoverAmount.sendKeys(Keys.TAB);
	}

	public void clickTPDCatFixed() {
		btnTPDCatFixed.click();
	}
	
	public void enterTPDFixedCoverAmount(String TPDFixedCoverAmount) {
		txtTPDFixedCoverAmount.sendKeys(TPDFixedCoverAmount);
		txtTPDFixedCoverAmount.sendKeys(Keys.TAB);
	}
	
	public void selectWaitPeriod(String WaitPeriod) {
		Select WP=new Select(selWaitPeriod);
		WP.selectByVisibleText(WaitPeriod);
	}
	
	public void selectBenefitPeriod(String BenefitPeriod) {
		Select BP=new Select(selBenefitPeriod);
		BP.selectByVisibleText(BenefitPeriod);
	}
	
	public void enterIPUnits(String IPUnits) {
		txtIPCoverUnits.sendKeys(IPUnits);
		txtIPCoverUnits.sendKeys(Keys.TAB);
	}
	
	public void clickDisclaimer() {
		chkDisclaimer.click();
	}
	
	public void clickCalculate() {
		btnCalculate.click();
	}
	
	public void valDeathCoverAmt(String ExpectedDeathCoverAmt) {
		
		String ActualDeathCoverAmount=gettxtDeathCoverAmount.getText();
		Assert.assertEquals(ActualDeathCoverAmount, ExpectedDeathCoverAmt);		
	}
	public void valTPDCoverAmt(String ExpectedTPDCoverAmt) {
		
		String ActualTPDCoverAmount=gettxtTPDCoverAmount.getText();
		Assert.assertEquals(ActualTPDCoverAmount, ExpectedTPDCoverAmt);
	}
	public void valIPCoverAmt(String ExpectedIPCoverAmt) {
	
	String ActualIPCoverAmount=gettxtIPCoverAmount.getText();
	Assert.assertEquals(ActualIPCoverAmount, ExpectedIPCoverAmt);
	}
	
	public void valDeathCost(String ExpectedDeathCost) {
		
		String ActualDeathCost=gettxtDeathCost.getText();
		Assert.assertEquals(ActualDeathCost, ExpectedDeathCost);		
	
	}
	public void valTPDCost(String ExpectedTPDCost) {
		
		String ActualTPDCost=gettxtTPDCost.getText();
		Assert.assertEquals(ActualTPDCost, ExpectedTPDCost);
	}
	public void valIPCost(String ExpectedIPCost) {
	
	String ActualIPCost=gettxtIPCost.getText();
	Assert.assertEquals(ActualIPCost, ExpectedIPCost);
	}
	public void valTotalCost(String ExpectedTotalCost) {
		
		String ActualTotalCost=gettxtTotalcost.getText();
		Assert.assertEquals(ActualTotalCost, ExpectedTotalCost);
		}
	
}

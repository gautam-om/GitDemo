package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="uid")
	private WebElement hpusername;
	
	@FindBy(name="password")
	private WebElement hppassword;
	
	@FindBy(name="btnLogin")
	private WebElement loginBtn;
	
	public WebElement getHpusername() {
		return hpusername;
	}

	public WebElement getHppassword() {
		return hppassword;
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void usser(String uname ) {
		
		hpusername.sendKeys(uname);	
	}
	
	public void upass(String upassword) {
		
		hppassword.sendKeys(upassword);
	}
	
	public void Ulogin() {
		
		loginBtn.click();
	}
}

package com.fannie.login_step_definition;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.fannie.base.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Login_step_definition_Test  {
	
	WebDriver driver = null;
	String baseURL = "http://sdettraining.com/trguitransactions/default.aspx?id=new";
	
	@Given("^user is on sdettraining homepage$")
	public void user_is_on_sdettraining_homepage() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\071717\\ALLJARS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(baseURL);
		
		System.out.println("Browser opened and successfully navigated to SDETTraining.com website");
	  
	}

	@When("^user clicks on top right hand Log in button$")
	public void user_clicks_on_top_right_hand_Log_in_button() throws Throwable {
		// Click on login Button on the top Right hand side
		 driver.findElement(By.id("HeadLoginView_lblLoginStatus")).click();
		 System.out.println("Clicked on login Button on the top Right hand side");
	}

	@When("^user enters \"([^\"]*)\" in email field$")
	public void user_enters_in_email_field(String arg1) throws Throwable {
		//Type Email Address
		String username = arg1;
		 driver.findElement(By.xpath("//*[@id='MainContent_txtUserName']")).sendKeys(username);
		System.out.println("Type Email Address as: " + username);
	}

	
	//@When("^user enters \"([a-zA-Z]{1,})\" in password field$")
	@When("^user enters \"([^\"]*)\" in password field$")
	public void user_enters_in_password_field(String arg1) throws Throwable {
		//Type Password
		 String Password = arg1;
		 driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(Password);
		 System.out.println("Type Password as: " + Password);
	}

	@When("^user clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
		//Click on Login (bottom one)
		 
	     driver.findElement(By.xpath("//*[@id='MainContent_btnLogin']")).click();
	     System.out.println("Click on Login (bottom one)");
	}

	@Then("^user is displayed \"([^\"]*)\" message$")
	public void user_is_displayed_message(String arg1) throws Throwable {
		
		String vExpected=arg1;
	    String vActual;
	 
	    if (arg1.equals("Welcome back!")){
		     vActual = driver.findElement(By.id("MainContent_lblid")).getText();
		     String url = driver.getCurrentUrl();
		     System.out.println("Value we are reading is: " + vActual + " from this page: " + url);
		     Assert.assertEquals(vExpected, vActual);
		     if (vExpected.equals(vActual)){
		    	 
		    	 System.out.println("ALL Good....TEST PASSED!!!!");
		    	 driver.quit();
		     }
		     else
		     {
		    	 System.out.println("Something happened.....TEST FAILED!!!!");
		     }
	    }
	    
	    
	    if (arg1.equals("Create New Account"))
	    {
	    	Thread.sleep(2000);
	    	String vIncorrectLoginMsg = driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[1]/h1")).getText();
	    	System.out.println("Routed to: " + vIncorrectLoginMsg);
	    }
	     
	     
	     
	}

	@Then("^the url must contain \"([^\"]*)\"$")
	public void the_url_must_contain(String arg1) throws Throwable {
		
		String vIncorrectLoginMsg = driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[1]/h1")).getText();
		System.out.println("Routed to: " + vIncorrectLoginMsg);
		
		Thread.sleep(2000);
		
	     String url = driver.getCurrentUrl(); 
	     
	    System.out.println("URL contains: " + url);
	    
	    driver.quit();
	     
	}

}

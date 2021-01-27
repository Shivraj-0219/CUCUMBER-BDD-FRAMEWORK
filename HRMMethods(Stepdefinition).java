package step_definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HRMMethods {
	WebDriver driver;
	HRMPageFactory HRM;
	@Before
	public void openBrowsser() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HRM = new HRMPageFactory (driver);
		HRM = PageFactory.initElements(driver,HRMPageFactory.class );		
	}

	@Given("Admin is on Home Page")
	public void admin_is_on_Home_Page() {

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}


	@When("Admin enters all login credentials")
	public void admin_enters_all_login_credentials() throws Exception {
		//AdminLogin
		System.out.println("===================Admin enters all login credentials===========================");
		HRM.username.sendKeys("Admin");
		HRM.password.sendKeys("admin123");
		HRM.login.click();
		Thread.sleep(2000);
		Thread.sleep(2000);

	}

	@Then("Admin Logins Successfully")
	public void admin_Logins_Successfully() {
		String message=HRM.getWelocomeMessage();
		System.out.println("Welcome Message :" + message);
		System.out.println("Admin Logins Successfully");
	}

	@Given("Admin adds search details")
	public void admin_adds_search_details() throws Exception {
		HRM.clickPim();
		HRM.clickEmpList();
		HRM.empIdSearch("3411");
		Thread.sleep(2000);
		System.out.println("Admin adds search details");
	}

	@When("Admin search for Employee")
	public void admin_search_for_Employee() throws Exception {
		HRM.clickSeach();
		System.out.println("Admin search for Employee");
	}

	@Then("Admin checks Employee in Employee List")
	public void admin_checks_Employee_in_Employee_List() {
		String recordData=HRM.getemprecord();
		if(recordData.equalsIgnoreCase("No Records Found")) {
			System.out.println("Employee is not found in Employee List");
		}else 
		{
			System.out.println("Employee is found in Employee List");	
		}
	}

	@Given("Admin adds Employee details")
	public void admin_collects_Employee_details() throws Exception {
		HRM.clickadd();
		Thread.sleep(2000);
		HRM.addEmployee("Swathi","Marena","3411","Swathimarena11","Bentley02");
		Thread.sleep(2000);
		System.out.println("Admin collects Employee details");
	}

	@When("Admin saves Employee details")
	public void admin_adds_Employee_details() throws Exception {
		HRM.clickSave();
		Thread.sleep(2000);
		System.out.println("Admin adds Employee details");
	}

	@Then("Admin validates Employee details")
	public void admin_saves_Employee_details() throws Exception {
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String expurl="https://opensource-demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/";
		//If navigates to next page
		if(url.startsWith(expurl)){
			System.out.println("Employee Validation Successfull");
		    }
			else {
				System.out.println("Adding Employee Unsuccessfull!!");	
			}
		HRM.clicklogout();
		}

		@Given("Admin Navigates to Employee Profile Edit details Page")
		public void admin_adds_More_Employee_details() {
			HRM.clickpim();
			HRM.enter_emp_id("3411");
			HRM.clicksearch();
			HRM.clickaftersearch();
			System.out.println("Admin adds More Employee details");
		}

		@Then("Admin updates Employee details")
		public void admin_updates_Employee_details() throws Exception {
			HRM.clickedit();
			HRM.editid("12345678");
			HRM.Add_Driver_License("1234");
			HRM.LICclick();
			HRM.ExpLicensedate("2022-05-01");
			HRM.Calendardriverlic();
			HRM.Add_ssn_number("1234");
			HRM.Add_sin_number("2345");
			HRM.check_gender();
			HRM.Select_MaritalStatus();
			HRM.MaritalStatus_option();
			HRM.Select_Nationality();
			HRM.Nation_option();
			HRM.DOBclick();
			HRM.DOBdate("1996-09-01");
			HRM.Calendardob();
			HRM.Add_nickname("Anu");
			Thread.sleep(3000);
            HRM.clickSaveButton();
            Thread.sleep(2000);
            HRM.clicklogout();
			System.out.println("Admin updates Employee details");
		}
		
		@Given("Employee is on Home Page")
		public void employee_is_on_Home_Page() {
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			System.out.println("Employee is on Home Page");
		}

		@When("Employee enters all login credentials")
		public void employee_enters_all_login_credentials() throws Exception {
			HRM.loginToOrangehrm("Swathimarena11","Bentley02");
			Thread.sleep(2000);
			System.out.println("Employee enters all login credentials");
		}

		@Then("Employee Logins Successfully")
		public void employee_Logins_Successfully() {
			String s= HRM.validate_welcome();   //Welcome message validation
			System.out.println("Actual welcome message:" +s);
			String check_msg= "Welcome Swathi";

			if(s.equals(check_msg)){
				System.out.println("validation for welcome message passed");
			}else
				System.out.println("validation for welcome message failed");
			System.out.println("Employee Logins Successfully");
		}

		

		@Given("Employee is on Info Page")
		public void employee_is_on_Info_Page() {
			HRM.infoclick();
			System.out.println("Employee is on Info Page");
		}

		@When("Employee Validates his Details")
		public void employee_Validates_his_Details() throws Exception {
			
			String s1= HRM.validate_fullname();   //full name validation
			Thread.sleep(2000);
			System.out.println("Actual Full name is:" +s1);
		    String check_fullname="Swathi";
		    
		    if(s1.equals(check_fullname)){
		    	System.out.println("validation for full name passed");
		    }else
		    	System.out.println("validation for full name failed");
		    
	        String s2= HRM.validate_lastname();    //last name validation
	        Thread.sleep(2000);
	        System.out.println("Actual value for last name is:" +s2);
	        String check_lastname="Marena";
		    
		    if(s2.equals(check_lastname)){
		    	System.out.println("validation for last name passed");
		    }else
		    	System.out.println("validation for last name failed");
		    
		    String s3= HRM.validate_empid();   //emp id validation
		    Thread.sleep(2000);
		    System.out.println("Actual emp id is:" +s3);
	        String check_empid="3411";
		    
		    if(s3.equals(check_empid)){
		    	System.out.println("validation for emp id passed");
		    }else
		    	System.out.println("validation for emp id failed");
		    
		    String s4= HRM.validate_otherid(); //other id validation
		    Thread.sleep(2000);
		    System.out.println("Actual other id is:" +s4);
	        String check_otherid="12345678";
		    
		    if(s4.equals(check_otherid)){
		    	System.out.println("validation for other id passed");
		    }else
		    	System.out.println("validation for other id failed");
		    
		    String s5= HRM.validate_drivinglc(); 
		    Thread.sleep(2000);                          //driving license validation
		    System.out.println("Actual driving license is:" +s5);
	        String check_drivinglc="1234";
		    
		    if(s5.equals(check_drivinglc)){
		    	System.out.println("validation for driving license passed");
		    }else
		    	System.out.println("validation for driving licensee failed");
		    
		    String s6= HRM.validate_licenseexp(); //License expiry date validation
		    Thread.sleep(2000);
		    System.out.println("Actual License expiry date is:" +s6);
	        String check_licenseexp="2022-05-01";
		    
		    if(s6.equals(check_licenseexp)){
		    	System.out.println("validation for license expiry date passed");
		    }else
		    	System.out.println("validation for license expiry date  is failed");
		   
		    String s7= HRM.validate_ssn_number(); //SSN number validation
		    Thread.sleep(2000);
		    System.out.println("Actual SSN Number is :" +s7);
	        String check_ssn_number="1234";
		    
		    if(s7.equals(check_ssn_number)){
		    	System.out.println("validation for SSN number passed");
		    }else
		    	System.out.println("validation for SSN number failed");
		    
		    String s8= HRM.validate_sin_number(); //SIN Number validation
		    Thread.sleep(2000);
		    System.out.println("Actual SIN number is :" +s8);
	        String check_sin_number="2345";
		    
		    if(s8.equals(check_sin_number)){
		    	System.out.println("validation for SIN Number passed");
		    }else
		    	System.out.println("validation for SIN Number failed");
		    
		    String s9= HRM.validate_gender();  //Gender Validation
		    Thread.sleep(2000);
		    System.out.println("Check status for female gender:" +s9);
	        if(s9.equals("true")){
		    	System.out.println("validation for Female gender passed");
		    }else
		    	System.out.println("validation for Female gender failed");
	        
		    String s10= HRM.validate_martial_status(); //Martial_status validation
		    Thread.sleep(2000);
		    System.out.println("Actual martial status is:" +s10);
	        String check_martial_status="Single";
		    
		    if(s10.equals(check_martial_status)){
		    	System.out.println("validation for Martial_status passed");
		    }else
		    	System.out.println("validation for Martial_status failed");
		    
		    String s11= HRM.validate_nationality();  //Nationality Validation
		    Thread.sleep(2000);
		    System.out.println("Actual Nationality is :" +s11);
	        String check_nationality="Indian";
		    
		    if(s11.equals(check_nationality)){
		    	System.out.println("validation for Nationality passed");
		    }else
		    	System.out.println("validation for Nationality failed");
		    String s111= HRM.validate_dateofbirth();  //Nationality Validation
		    Thread.sleep(2000);
		    System.out.println("Actual Date  is :" +s111);
	        String check_dateofbirth="1996-09-01";
		    
		    if(s111.equals(check_dateofbirth)){
		    	System.out.println("validation for date of birth passed");
		    }else
		    	System.out.println("validation for date of birth failed");
		    
		    
		    String s12= HRM.validate_nickname();  //Nickname Validation
		    Thread.sleep(2000);
		    System.out.println("Actual nickname is :" +s12);
	        String check_nickname="Anu";
		    
		    if(s12.equals(check_nickname)){
		    	System.out.println("validation forNickname passed");
		    }else {
		    	System.out.println("validation for Nickname failed");
	        }
			System.out.println("Employee Validates his Details");
		}
		@Then("Employee Logout from Account")
		public void employee_is_logout_Info_Page() throws Exception {
			HRM.clicklogout();
		}

	}

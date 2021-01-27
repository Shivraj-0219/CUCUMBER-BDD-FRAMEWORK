package step_definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HRMPageFactory {
	WebDriver driver;
	@FindBy(id="txtUsername")
    WebElement username;
    @FindBy(id="txtPassword")
    WebElement password;
    @FindBy(id="btnLogin")
    WebElement login;
	@FindBy(id="welcome")
	WebElement welcomemessage;
	@FindBy(id="spanMessage")
	WebElement errmessage;
	@FindBy(id="empsearch_id")
	WebElement EmployeeId;
	@FindBy(id="searchBtn")
	WebElement Search;
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr")
	WebElement record;
	@FindBy(id="btnAdd")
	WebElement add;
	@FindBy(id="firstName")
	WebElement fname;
	@FindBy(id="lastName")
	WebElement lname;
	@FindBy(id="employeeId")
	WebElement empid;
	@FindBy(id="chkLogin")
	WebElement chklogin;
	@FindBy(id="user_name")
	WebElement uname;
	@FindBy(id="user_password")
	WebElement upwd;
	@FindBy(id="re_password")
	WebElement repwd;
	@FindBy(xpath="//*[@id=\"btnSave\"]")
	WebElement save;
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pim;
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement emplist;
	@FindBy(css="//*[@id='profile-pic']/h1")
	WebElement empprofile;
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr/td[3]/a")
	WebElement Employeeprofilelink; 
    @FindBy(id="empsearch_id")
    WebElement empsearch_by_id;
    @FindBy(xpath="//*[@id='menu_pim_addEmployee']")
    WebElement addemp;
    @FindBy(xpath="//*[@id='menu_pim_viewMyDetails']/b")
    WebElement myinfo;
    @FindBy(id="searchBtn")
    WebElement search;
    @FindBy(xpath="//*[@id='btnSave']")
    WebElement edit;
    @FindBy(name="personal[txtOtherID]")
    WebElement newid;
    @FindBy(id="btnSave")
    WebElement Savebtn;
    @FindBy(xpath="//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[2]/li[4]/img")
    WebElement Calendar1;
    @FindBy(xpath="//*[@id=\"frmEmpPersonalDetails\"]/fieldset/ol[3]/li[4]/img")
    WebElement Calendar2;
    @FindBy(id="personal_cmbNation")
    WebElement selectNationality;
    @FindBy(xpath="//*[@id=\"personal_cmbNation\"]/option[83]")
    WebElement Nationalityoption;
    @FindBy(id="personal_cmbMarital")
    WebElement MaritalSelect;
    @FindBy(xpath="//*[@id=\"personal_cmbMarital\"]/option[2]")
    WebElement Maritaloption;
    @FindBy(name="Submit") 
    WebElement loginButton ;
    @FindBy(id="welcome")
    WebElement logoutmenu;
    //@FindBy(xpath="//*[@id='welcome-menu']/ul/li[2]/a")
    //WebElement logoutmenu;
    @FindBy(linkText="Logout")
    WebElement logout;
    			
    @FindBy(xpath="//*[@id='menu_pim_viewMyDetails']/b") 
    WebElement info_button;
    @FindBy(name="personal[txtEmpFirstName]") 
    WebElement Fullname;
    @FindBy(name="personal[txtEmpLastName]") 
    WebElement Lastname;
    @FindBy(name="personal[txtEmployeeId]") 
    WebElement empid001;
    @FindBy(name="personal[txtOtherID]") 
    WebElement otherid;
    @FindBy(name="personal[txtLicenNo]") 
    WebElement drivinglc;
    @FindBy(name="personal[txtLicExpDate]") 
    WebElement licenseexp;
    @FindBy(name="personal[txtNICNo]") 
    WebElement ssn_number;
    @FindBy(name="personal[txtSINNo]") 
    WebElement sin_number;
    @FindBy(xpath="//*[@id='personal_optGender_2']") 
    WebElement gender;
    @FindBy(name="personal[cmbMarital]") 
    WebElement martial_status;
    @FindBy(css="select#personal_cmbNation>option[selected=selected]") 
    WebElement nationality;
    @FindBy(name="personal[txtEmpNickName]")
    WebElement nickname;
    @FindBy(xpath="//*[@id='welcome']") 
    WebElement welcome_message;
    @FindBy(name="personal[DOB]")
    WebElement dob;
    
    
    
	public HRMPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setusername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void loginbtnclick() {
		login.click();
	}
	public void clickPim() {
		pim.click();
	}
	public void clickEmpList() {
		emplist.click();
	}
	public void clickadd() {
		add.click();
	}
	public void empIdSearch(String id) {
		EmployeeId.sendKeys(id);
	}
	
	public void clickSeach() {
		Search.click();
	}
	
	public void clickSave() {
		save.click();
	}
	
	public void addEmployee(String empfname, String emplname, String empId,String luname,String lpwd) throws InterruptedException {
		fname.sendKeys(empfname);
		lname.sendKeys(emplname);
		empid.clear();
		empid.sendKeys(empId);
		chklogin.click();
		Thread.sleep(2000);
		uname.sendKeys(luname);
		upwd.sendKeys(lpwd);
		repwd.sendKeys(lpwd);
	}
    public void clickpim() {
    	pim.click();
	}

    public void enter_emp_id(String empid) {
    	empsearch_by_id.sendKeys(empid);
	}
    
    public void clicksearch() {
    	search.click();
	}
    
    public void clickaftersearch() {
    	Employeeprofilelink.click();
	}

    public void clickmyinfo() {
    	myinfo.click();
	}

	public void clickedit() {
    	edit.click();
	}
    public void editid(String newi) {
    	newid.sendKeys(newi);
	}
    public void clickSaveButton() {
    	Savebtn.click();
	}
    public void clicklogout() throws Exception {
    	Thread.sleep(2000);
    	logoutmenu.click();
    	Thread.sleep(4000);
    	logout.click();
    }
	public String getemprecord() {
		return record.getText();
	}
	
	public String getWelocomeMessage() {
		return welcomemessage.getText();
	}
		
	//Error Message
	public String geterrmessage() {
		return errmessage.getText();
	}
	
	public String getprofile() {
		return empprofile.getText();
	}
	public String validate_welcome(){
		 return welcome_message.getText();
		}
	public void infoclick(){
		info_button.click();		
		}
	//Login with employee details
    public void setUserName(String strUserName){
		username.sendKeys(strUserName);
	}
	public void setPassword(String strPassword){
	password.sendKeys(strPassword);
	}
	public void clickLogin(){
	loginButton.click();		
	}
	public void Add_Driver_License(String Licno){
		drivinglc.sendKeys(Licno);
	}
	public void ExpLicensedate(String expdate){
		licenseexp.sendKeys(expdate);
	}
	public void LICclick(){
		licenseexp.click();		
		}
	
	public void DOBclick(){
		dob.click();		
		}
	public void DOBdate(String date) {
		dob.sendKeys(date);
	}
	public void Add_ssn_number(String ssnno){
		ssn_number.sendKeys(ssnno);
	}
	public void Add_sin_number(String sinno){
		sin_number.sendKeys(sinno);
	}
	public void check_gender(){
		gender.click(); 
	}
	public void Calendardriverlic(){
		Calendar1.click(); 
	}
	public void Calendardob(){
		Calendar2.click(); 
	}
	public void Select_Nationality(){
		selectNationality.click(); 
	}
	public void Nation_option(){
		Nationalityoption.click(); 
	}
	public void Select_MaritalStatus(){
		MaritalSelect.click(); 
	}
	public void MaritalStatus_option(){
		Maritaloption.click(); 
	}
	public void Add_nickname(String nick){
		nickname.sendKeys(nick);
	}
	public String validate_fullname(){
		return Fullname.getAttribute("value");
	}
	public String validate_lastname(){
		return Lastname.getAttribute("value");
	}
	public String validate_empid(){
		return empid001.getAttribute("value");
	}
	public String validate_otherid(){
		return otherid.getAttribute("value");
	}
	public String validate_drivinglc(){
		return drivinglc.getAttribute("value");
	}
	public String validate_licenseexp(){
		return licenseexp.getAttribute("value");
	}
	public String validate_ssn_number(){
		return ssn_number.getAttribute("value");
	}
	public String validate_sin_number(){
		return sin_number.getAttribute("value");
	}
	public String validate_gender(){
		return gender.getAttribute("checked");
	}
	public String validate_martial_status(){
		return martial_status.getAttribute("value");
	}
	public String validate_nationality(){
	 	return nationality.getText();
	}
	public String validate_nickname(){
		return nickname.getAttribute("value");
	}
	public String validate_dateofbirth(){
		return dob.getAttribute("value");
	}
public void loginToOrangehrm(String strUserName,String strPasword) throws InterruptedException{
		
		Thread.sleep(2000);
		//Fill user name
		this.setUserName(strUserName);
		Thread.sleep(2000);
		//Fill password
		this.setPassword(strPasword);
		Thread.sleep(2000);
		//Click Login button
		this.clickLogin();
		this.validate_welcome();
		this.infoclick();	
		this.validate_fullname();
		this.validate_lastname();
		this.validate_empid();
		this.validate_otherid();
		this.validate_drivinglc();
		this.validate_licenseexp();
		this.validate_ssn_number();
		this.validate_ssn_number();
		this.validate_gender();
		this.validate_martial_status();
		this.validate_nationality();
		this.validate_nickname();
	}
}

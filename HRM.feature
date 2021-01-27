@OrangeHRMWebsite
Feature: OrangeHRM
@AddNewEmployeeUsingAdminAccount
Scenario: Admin Successfully adds Employee In Employee List
Given Admin is on Home Page
When Admin enters all login credentials 
Then Admin Logins Successfully
Given Admin adds search details 
When Admin search for Employee 
Then Admin checks Employee in Employee List
Given Admin adds Employee details
When Admin saves Employee details
Then Admin validates Employee details

@AdminUpdateEmployeedetails
Scenario: Admin Successfully Updates Employee Profile details
Given Admin is on Home Page
When Admin enters all login credentials 
Then Admin Logins Successfully
Given Admin Navigates to Employee Profile Edit details Page
Then Admin updates Employee details

@ValidateEmployeeProfiledetails
Scenario: Employee Verify all Profile Details using Employee login credentials
Given Employee is on Home Page
When Employee enters all login credentials 
Then Employee Logins Successfully
Given Employee is on Info Page
When Employee Validates his Details
Then Employee Logout from Account
 


















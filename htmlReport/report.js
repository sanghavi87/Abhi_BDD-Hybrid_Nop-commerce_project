$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/abhis/IdeaProjects/Abhi_BDD-Hybrid_NopCommerce_Project/src/test/resources/Features/Register.feature");
formatter.feature({
  "line": 1,
  "name": "NopCommerce Register",
  "description": "",
  "id": "nopcommerce-register",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1595248600,
  "status": "passed"
});
formatter.background({
  "line": 2,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 3,
  "name": "User able to open Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "Enter an Url",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_able_to_open_Browser()"
});
formatter.result({
  "duration": 9065031800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.enter_an_Url()"
});
formatter.result({
  "duration": 1677575100,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "NopCommerce Registration with valid details",
  "description": "",
  "id": "nopcommerce-register;nopcommerce-registration-with-valid-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User Click on Register btn on homePage",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User able to enter personal details",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "click on Register btn submit",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "User able to see confirmation message",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_Click_on_Register_btn_on_homePage()"
});
formatter.result({
  "duration": 1391678400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_able_to_enter_personal_details()"
});
formatter.result({
  "duration": 2268165400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Register_btn_submit()"
});
formatter.result({
  "duration": 1037475500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_able_to_validate_MyAccountPage()"
});
formatter.result({
  "duration": 103899900,
  "status": "passed"
});
formatter.after({
  "duration": 898589400,
  "status": "passed"
});
});
package StepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.B_HomePage;
import pageObjects.C_AccountRegistrationPage;
import pageObjects.D_LoginPage;
import pageObjects.E_MyAccountPage;



import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Steps
{
    //we need to call here all our pageObject class:-
    //-------------------------------------------------

    WebDriver driver;
    B_HomePage hp;
    C_AccountRegistrationPage arp;
    D_LoginPage lp;
    E_MyAccountPage map;


    //for logging:-
    //**************
    Logger logger;

   //for reading properties from config.properties file:-
   //*****************************************************
   ResourceBundle rb;

   //To store the value from the config.properties file into variable:-
   //********************************************************************
   String br;  //br= browser
   String url; //url= url
   String email;
   String password;
   String firstname;
   String lastname;
   String dob;
   String dom;
   String doy;
   String CompanyName;

  //DataDriven:-
  //************
  List<HashMap<String, String>> datamap;





    @Before
    public void setup()    //Junit hook - executes once before starting
    {
        System.out.println("print in setup method");
        //for logging:-
       //****************
        logger= LogManager.getLogger(this.getClass());

        //Reading config.properties :-
        //****************************
        rb=ResourceBundle.getBundle("config");

        br=rb.getString("browser");   //for browser
        url=rb.getString("url");  //for url
        email=rb.getString("email"); // for email id
        password=rb.getString("password");  //for password
        firstname=rb.getString("firstName");  //for firstname
        lastname=rb.getString("lastName"); //for lastname
        dob=rb.getString("dob");  //for date of birth
        dom=rb.getString("dom"); //for date of month
        doy=rb.getString("doy");  //for date of year
        CompanyName= rb.getString("companyName");  //companyName

    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException
    {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed())
        {

            TakesScreenshot ts=(TakesScreenshot) driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
         //   scenario.attach(screenshot, "image/png",scenario.getName());

        }
        driver.quit();
    }


//######################################### Login Steps ###########################################
//                                     *************************

    @Given("^User able to open Browser$")
    public void user_able_to_open_Browser()
    {
        if (br.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (br.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else if (br.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();




    }

    @Given("^Enter an Url$")
    public void enter_an_Url() //we need to declare here in parameter string url
    {
        driver.get(url);    //we call url from config.properties file
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @When("^User click on Login Link$")
    public void user_click_on_Login_Link()
    {
        hp=new B_HomePage(driver);  //we need to call methods from homepage loginPage
        hp.setClickOnLogin(); //we click on login button
        logger.info("*** Clicked on Login *** ");
    }

    @When("^User on Login Page and Verify Login page Title$")
    public void user_on_Login_Page_and_Verify_Login_page_Title()
    {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("nopCommerce demo store. Login",title);
        logger.info("*** validate the login page *** ");

    }

    @Then("^User enter Username and Password and Click on login button$")
    public void user_enter_and_and_Click_on_login_button()  //we need to pass the parameter here
    {
        lp=new D_LoginPage(driver);                                       //We need to call method from login page

        lp.setEnterEmail(email);                           //then enter email address
        lp.setEnterPassword(password);                     //then enter password
        lp.setClickOnLoginBtn();                                         //then click on login submit button
        logger.info("*** Clicked on Login submit button *** ");

    }

    @Then("^User navigates to my account page$")
    public void user_navigates_to_my_account_page()     //we are validating after successful login
    {
       map=new E_MyAccountPage(driver);                 //we need to call the method from MyAccountPage

       boolean targetpage=map.isMyAccountPageExist();
       if (targetpage)
       {
           Assert.assertTrue(true);
           logger.info("*** Login Successful ***");
       }
       else
       {
           Assert.assertFalse(false);
           logger.info("*** Login Failed ***");
       }
    }





//######################################### Registration Steps ###########################################
//                                 *****************************************

    @When("^User Click on Register btn on homePage$")
    public void user_Click_on_Register_btn_on_homePage()
    {
        hp=new B_HomePage(driver);
        hp.clickRegister();
        logger.info("Clicked on register link");
    }

    @Then("^User able to enter personal details$")
    public void user_able_to_enter_personal_details()
    {
        logger.info("***** AccountRegistrationTest *****");

        arp=new C_AccountRegistrationPage(driver);  //Call all the methods from this account registration class
        logger.info("Providing customer data");

        arp.setSelectGender();
        arp.setFirstName(firstname);
        arp.setLastName(lastname);
        arp.setDateOfBirthday(dob);
        arp.setDateOfBirthMonth(dom);
        arp.setDateOfBirthYear(doy);
        arp.setEnterEmail(email);
        arp.setEnterCompanyName(CompanyName);
        arp.setClickOnNewsletter();
        arp.setEnterPassword(password);
        arp.setConfirmPassword(password);


    }

    @Then("^click on Register btn submit$")
    public void click_on_Register_btn_submit()
    {
        arp=new C_AccountRegistrationPage(driver);

        arp.setClickOnRegister_Btn();       // we are clicking on register submit button
        logger.info("Clicked on Register button");
    }

    @Then("^User able to see confirmation message$")
    public void user_able_to_validate_MyAccountPage()  //we are validating register confirmation message
    {
        arp=new C_AccountRegistrationPage(driver);

        logger.info("Validating expected message");
       String confirmMessage= arp.getConfirmationMsg();
       Assert.assertEquals(confirmMessage, "Your registration completed");

        logger.info("***  Finished AccountRegistrationTest ***");


    }
















}

package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions        (

// 1) feature:- Path of the feature file , where feature file is available:-
//-------------------
//            features ="C:\\Users\\abhis\\IdeaProjects\\Abhi_BDD-Hybrid_NopCommerce_Project\\src\\test\\resources\\Features",  // when you want to run all the functionality
//            features="C:\\Users\\abhis\\IdeaProjects\\Abhi_BDD-Hybrid_NopCommerce_Project\\src\\test\\resources\\Features\\Login.feature",
            features="C:\\Users\\abhis\\IdeaProjects\\Abhi_BDD-Hybrid_NopCommerce_Project\\src\\test\\resources\\Features\\Register.feature",




//        features = ".",tags = "@Login",                       //Specific Scenario
//        features = ".",tags = {"@Regression,@Sanity"},        // OR
//        features = ".",tags = {"@Regression","@Sanity"},      //And
//        features = ".",tags = "~@Smoke",                       //Ignore


// 2) glue:- Path of the step definitions
//----------------
        glue = {"StepDefinitions"},


// 3) format:- We can create different type of report and pretty output.
//-----------------
        format = {"pretty","html:htmlReport","json:json/cucumber.json","junit:junit/cucumber.xml"},


// 4) dryRun:-  Will help to do one to one mapping between feature file and step definitions
//-------------------
        dryRun = false


// 5) monochrome:- Display the console output in proper readable format
//------------------------------
//        monochrome = true,


// 6) strict:-  It will fail the execution if there are pending step or undefine step. It will check if any step is not defined in step definitions.
//-------------------------
//        strict = true


)

public class TestRunner
{


}

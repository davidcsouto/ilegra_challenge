package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import lombok.extern.java.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import support.Context;
import support.Utils;

import java.io.File;

import static support.Context.driver;

@Log
public class RunnerWeb extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void beforeClassMethod(){
        Utils.deleteFolder(new File(Utils.getRootPath() + "\\allure-results"));
        Context.setup();
    }

    @AfterTest
    public static void afterClassMethod(){
        Context.closeWebDriver();
    }
}

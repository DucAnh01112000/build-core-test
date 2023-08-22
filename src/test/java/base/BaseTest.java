package base;

import core.BaseApi;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest{
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception{
        BaseApi.initReqSpec();
        BaseApi.setBaseUrl("http://10.4.10.231:8033/api/v1/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        RestAssured.reset();
    }
}

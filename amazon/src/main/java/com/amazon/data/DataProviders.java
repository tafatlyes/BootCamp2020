package com.amazon.data;

import org.testng.annotations.DataProvider;


public class DataProviders {


    @DataProvider(name = "TestData")
    public Object [] getSearchData(){
      Object[] data = {"Hello","HELLO TD","USA"};
        return data;
    }

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        return new Object[][]{{"testuser001", "testpass001"}, {"testuser002", "testpass002"}, {"testuser003", "testpass003"}};
    }

    @DataProvider(name = "New Data") //not used yet !!!! I can use when i need it okay
    public Object [] [] getNewData(){
        Object [][] data = {{"Tester1", "111111"},{"Tester2","222222"},{"Tester3","333333"}};
        return data;
    }

    @DataProvider(name = "Test2") //not used yet !!!! I can use when i need it okay
    public Object [][] getDataTest2(){
        Object [][] data = {{"user1","12345"},{"user2","56789"},{"user3","00000"}};
        return data;
    }
}

//    WebDriver webDriver = new WebDriver();
//webDriver.set(new RemoteWebDriver(
//        new URL("https://tafatlyes:81b590a4-d403-43f3-a79d-84fe1d009331@ondemand.us-west-1.saucelabs.com:443/wd/hub")
//        ))

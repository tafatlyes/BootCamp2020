package com.cigna.data;

import org.testng.annotations.DataProvider;


public class DataProviders {


    @DataProvider(name = "credentials")
    public Object[][] getNewData() {
        Object[][] data = {{"Tester1", "111111"}, {"Tester2", "222222"}, {"Tester3", "333333"}};
        return data;
    }


    @DataProvider(name = "Negative Test")
    public Object[][] getTestData() {
        Object[][] data = {{"Tester1", "111111"}};
        return data;
    }

}

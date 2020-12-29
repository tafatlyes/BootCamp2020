package com.amazon.data;

import org.testng.annotations.DataProvider;


public class DataProviders {


    @DataProvider(name = "TestData")
    public Object[] getSearchData() {
        Object[] data = {"Books", "TV", "Java Books"};
        return data;
    }


}

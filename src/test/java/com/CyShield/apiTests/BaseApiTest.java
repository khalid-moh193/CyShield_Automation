package com.CyShield.apiTests;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseApiTest {

    private ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    @BeforeMethod
    public void setUpMethods() {
        softAssert.set(new SoftAssert());
    }

    protected SoftAssert softAssert() {
        return softAssert.get();
    }

}

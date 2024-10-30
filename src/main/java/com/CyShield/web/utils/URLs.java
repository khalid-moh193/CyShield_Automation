package com.CyShield.web.utils;


public class URLs {

    public static String basicURL = "https://testing.todorvachev.com/";

    public enum Page {
        HOME(basicURL),
        TEST_SCENARIO("category/test-scenarios/"),
        REGISTER(basicURL + "register-form/");

        private String value;

        Page(String value) {
            this.setValue(value);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

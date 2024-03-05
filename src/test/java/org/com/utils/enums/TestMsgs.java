package org.com.utils.enums;

public enum TestMsgs {
    OPTIONS_MSG("Current page and selected aren't same"),
    SIGN_IN_MSG("Error in sign up."),
    LOGIN_MSG ("Login failed."),
    ORDER_MESSAGE("Thank you for your order!"),
    ELEMENT_MSG("Error, element is not displayed"),
    LAST_CARD_MSG("Error, there are more than one card!");


    private String value;
    TestMsgs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

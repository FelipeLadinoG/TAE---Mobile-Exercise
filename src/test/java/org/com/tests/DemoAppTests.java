package org.com.tests;

import org.com.screens.MenuBar;
import org.com.utils.tests.BaseTest;
import org.testng.annotations.Test;

public class DemoAppTests extends BaseTest {

    @Test
    public void optionsNavigation (){
        MenuBar menuBar = returnMenu();
        menuBar.tapWebView();
        menuBar.tapLogin();
        menuBar.tapForms();
        menuBar.tapSwipe();
        menuBar.tapDrag();
    }
}

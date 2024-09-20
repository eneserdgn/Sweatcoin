package utils;

import io.cucumber.java.*;

public class Hooks {
    @Before
    public void BeforeScenario(Scenario scenario) {
        //  System.out.println("\u001B[32m" + "Scenario: " + scenario.getName() + "\u001B[0m");
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        // System.out.println("\u001B[32m" + "    *" + scenario.getName() + "\u001B[0m");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

    }

    @After
    public void after() {
        DriverFactory.quitDriver();
    }

}

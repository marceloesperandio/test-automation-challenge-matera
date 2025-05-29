package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static utils.Log.*;

public class Hooks {

    @Before()
    public void afterScenario(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            ERROR("Scenario: " + scenario.getName() + " failed");
        } else {
            INFO("Scenario: " + scenario.getName() + " passed");
        }
    }

    @After()
    public void beforeScenario(Scenario scenario) throws IOException {
        INFO("Scenario: " + scenario.getName() + " started");
    }

    @BeforeAll
    public static void prepareAllureReport() {
        System.out.println("<=========================Generate Report=========================>");

    }
}
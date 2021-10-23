package com.artium.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"pretty"},
				features="src/test/resources/features/Login.feature",
				glue="com.artium.testscripts")
public class TestRunner {

}

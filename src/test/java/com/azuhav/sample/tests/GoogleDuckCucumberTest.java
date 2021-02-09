package com.azuhav.sample.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:bdd", plugin = {"pretty"})
public class GoogleDuckCucumberTest extends AbstractTestNGCucumberTests {
}
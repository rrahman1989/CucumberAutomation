package com.cucumber.cucumber.zephyr.project.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

//This class is an implementation of InjectorSource, a part of Cucumber Guice integration
public class GuiceInjectorSource implements InjectorSource {
    @Override
    public Injector getInjector() {
        return Guice.createInjector(CucumberModules.SCENARIO, new ProjectModule());
    }
}
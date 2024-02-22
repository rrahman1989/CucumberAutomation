package com.cucumber.cucumber.zephyr.project.guice;

import com.cucumber.cucumber.zephyr.project.guice.provider.WebDriverProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;


//bind between interface and there implementation
public final class ProjectModule extends AbstractModule {		
	
	//This method is overridden to define bindings. 
	//In this case, it binds the WebDriver interface to the WebDriverProvider class,
    @Override
    public void configure() {
        bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Singleton.class);
    }
}

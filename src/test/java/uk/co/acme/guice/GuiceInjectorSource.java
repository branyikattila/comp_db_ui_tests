package uk.co.acme.guice;

import io.magentys.cinnamon.guice.CinnamonModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

public class GuiceInjectorSource implements InjectorSource {

    @Override
    public Injector getInjector() {
        return Guice.createInjector(CucumberModules.createScenarioModule(), new CinnamonModule(), new ProjectModule());
    }
}
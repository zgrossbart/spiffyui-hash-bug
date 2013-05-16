package com.github.mbsimonovic.spiffy.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class SpringDBModule extends AbstractGinModule {
    @Override
    protected void configure() {
        install(new ViewModule());
        install(new MvpModule());
    }


}

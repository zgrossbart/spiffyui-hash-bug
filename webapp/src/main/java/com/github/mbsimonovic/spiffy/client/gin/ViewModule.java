package com.github.mbsimonovic.spiffy.client.gin;

import com.github.mbsimonovic.spiffy.client.contact.ContactView;
import com.github.mbsimonovic.spiffy.client.home.HomePagePresenter;
import com.github.mbsimonovic.spiffy.client.home.HomePageView;
import com.github.mbsimonovic.spiffy.client.home.HomePageViewImpl;
import com.github.mbsimonovic.spiffy.client.license.LicenseView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class ViewModule extends AbstractGinModule {

    @Provides
    @Singleton
    @Named("contactView")
    public ContactView contactView() {
        return GWT.create(ContactView.class);
    }

    @Provides
    @Singleton
    public LicenseView downloadView() {
        return GWT.create(LicenseView.class);
    }

    @Override
    protected void configure() {
        bind(HomePageView.Presenter.class).to(HomePagePresenter.class);
        bind(HomePageView.class).to(HomePageViewImpl.class).in(Singleton.class);
    }


}

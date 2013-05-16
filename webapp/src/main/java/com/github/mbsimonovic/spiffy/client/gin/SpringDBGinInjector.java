package com.github.mbsimonovic.spiffy.client.gin;

import com.github.mbsimonovic.spiffy.client.contact.ContactPlace;
import com.github.mbsimonovic.spiffy.client.home.HomePlace;
import com.github.mbsimonovic.spiffy.client.license.LicensePlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

@GinModules(SpringDBModule.class)
public interface SpringDBGinInjector extends Ginjector {

    PlaceHistoryHandler getHistoryHandler();

    ActivityManager getActivityManager();

    PlaceController getPlaceController();

    HomePlace getHomePlace();

    HomePlace.Tokenizer getHomePlaceTokenizer();

    ContactPlace.Tokenizer getContactPlaceTokenizer();

    LicensePlace.Tokenizer getLicensePlaceTokenizer();

}

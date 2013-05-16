package com.github.mbsimonovic.spiffy.client.home;

import com.github.mbsimonovic.spiffy.client.gin.ActivityPlace;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class HomePlace extends ActivityPlace<HomePagePresenter> {

    @Prefix("!home")
    public static class Tokenizer extends ActivityPlace.Tokenizer<HomePlace> implements PlaceTokenizer<HomePlace> {

    }

    @Override
    public String toString() {
        return "the only home";
    }


}

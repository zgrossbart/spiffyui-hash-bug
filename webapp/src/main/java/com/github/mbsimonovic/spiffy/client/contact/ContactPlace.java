package com.github.mbsimonovic.spiffy.client.contact;

import com.github.mbsimonovic.spiffy.client.gin.ActivityPlace;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class ContactPlace extends ActivityPlace<ContactPageActivity> {

    @Prefix("!contact")
    public static class Tokenizer extends ActivityPlace.Tokenizer<ContactPlace> implements PlaceTokenizer<ContactPlace> {
    }

    @Override
    public String toString() {
        return "contact place";
    }

}

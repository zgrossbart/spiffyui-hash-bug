package com.github.mbsimonovic.spiffy.client.license;

import com.github.mbsimonovic.spiffy.client.gin.ActivityPlace;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class LicensePlace extends ActivityPlace<LicensePageActivity> {

    @Prefix("!license")
    public static class Tokenizer extends ActivityPlace.Tokenizer<LicensePlace> implements PlaceTokenizer<LicensePlace> {

    }

    @Override
    public String toString() {
        return "license place";
    }


}

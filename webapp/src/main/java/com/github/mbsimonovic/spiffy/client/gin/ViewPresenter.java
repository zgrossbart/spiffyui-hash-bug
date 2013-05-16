package com.github.mbsimonovic.spiffy.client.gin;

import com.google.gwt.place.shared.Place;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public interface ViewPresenter<T> {
    void goTo(Place place);
}

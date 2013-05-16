package com.github.mbsimonovic.spiffy.client.gin;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public abstract class BaseActivity extends AbstractActivity {
    protected PlaceController ctrl;
    protected Place place;

    public BaseActivity(PlaceController ctrl) {
        this.ctrl = ctrl;
    }

    public void setPlace(Place place) {
        this.place = place;

    }

    public void goTo(Place place) {
        ctrl.goTo(place);
    }
}

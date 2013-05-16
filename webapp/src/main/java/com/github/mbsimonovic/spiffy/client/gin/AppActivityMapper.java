package com.github.mbsimonovic.spiffy.client.gin;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

import java.util.logging.Logger;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class AppActivityMapper implements ActivityMapper {

    private static Logger logger = Logger.getLogger("");

    private PlaceController ctrl;

    @Inject
    public AppActivityMapper(PlaceController ctrl) {
        GWT.log("AppActivityMapper(cf)");
        this.ctrl = ctrl;
    }

    /**
     * Map each Place to its corresponding Activity.
     * <p/>
     * todo use GIN.
     */
    @Override
    public Activity getActivity(Place place) {
        if (place instanceof ActivityPlace<?>) {
            return ((ActivityPlace<?>) place).getActivity();
        }
        logger.warning(place + " cant be mapped to Activity");
        return null;
    }

}

package com.github.mbsimonovic.spiffy.client.gin;

import com.github.mbsimonovic.spiffy.client.SpringDbShell;
import com.github.mbsimonovic.spiffy.client.home.HomePlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class MvpModule extends AbstractGinModule {
    private static Logger logger = Logger.getLogger("Gin");
    protected final String OTU_OF_THE_DAY = "otu_b145209-0.95";

    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    public EventBus eventBus() {
        logger.log(Level.INFO, "creating EventBus");
        return new SimpleEventBus();
    }

    @Provides
    @Singleton
    @Named("shell")
    public SpringDbShell contentsPanel() {
        logger.log(Level.INFO, "creating the main shell");
        return GWT.create(SpringDbShell.class);
    }


    @Provides
    @Singleton
    public PlaceController placeController(EventBus eventBus) {
        logger.log(Level.INFO, "creating PlaceControler");
        return new PlaceController(eventBus);
    }


    @Provides
    @Singleton
    public ActivityMapper activityMapper(PlaceController ctrl) {
        logger.log(Level.INFO, "creating ActivityMapper");
        return new AppActivityMapper(ctrl);
    }


    @Provides
    @Singleton
    public ActivityManager activityManager(ActivityMapper mapper,
                                           EventBus eventBus, @Named("shell") SpringDbShell shell) {
        logger.log(Level.INFO, "creating ActivityManager");

        ActivityManager activityManager = new ActivityManager(mapper, eventBus);
        activityManager.setDisplay(shell.getMainStage());
        RootPanel.get("content").add(shell);
//        RootLayoutPanel.get().add(shell);
        return activityManager;
    }

    @Provides
    @Singleton
    public PlaceHistoryHandler placeHistoryHandler(
            AppPlaceHistoryMapper mapper, PlaceController placeController,
            EventBus eventBus, SpringDBGinInjector injector, HomePlace home) {
        logger.log(Level.INFO, "creating placeHistoryHandler");
        mapper.setFactory(injector);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(mapper);
        historyHandler.register(placeController, eventBus, home);
        return historyHandler;
    }


}

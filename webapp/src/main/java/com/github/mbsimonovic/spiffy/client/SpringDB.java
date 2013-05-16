package com.github.mbsimonovic.spiffy.client;

import com.github.mbsimonovic.spiffy.client.gin.SpringDBGinInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point class.
 */
public class SpringDB implements EntryPoint {
    private static Logger logger = Logger.getLogger("");

    private static HTML convertMe = new HTML();
    private static final String LOADING_DIV_ID = "loading";

    public static String escapeText(String escapeMe) {
        convertMe.setText(escapeMe);
        return convertMe.getHTML();
    }

    @Override
    public void onModuleLoad() {
        logger.log(Level.INFO, "onModuleLoad() started");

        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
            public void onUncaughtException(Throwable e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        });

        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                DOM.getElementById(LOADING_DIV_ID).setInnerText("loading failed: " + reason.getMessage());
            }

            @Override
            public void onSuccess() {
                SpringDBGinInjector gin = GWT.create(SpringDBGinInjector.class);
                DOM.getElementById(LOADING_DIV_ID).removeFromParent();
                gin.getActivityManager();
                // Goes to place represented on URL or default place
                gin.getHistoryHandler().handleCurrentHistory();
                logger.log(Level.INFO, "onModuleLoad() finished");
            }
        });


    }
}

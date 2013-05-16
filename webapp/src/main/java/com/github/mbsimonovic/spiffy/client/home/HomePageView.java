package com.github.mbsimonovic.spiffy.client.home;

import com.github.mbsimonovic.spiffy.client.gin.ViewPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public interface HomePageView extends IsWidget {
    void setPresenter(Presenter p);

    public interface Presenter extends ViewPresenter<HomePageView> {
    }
}

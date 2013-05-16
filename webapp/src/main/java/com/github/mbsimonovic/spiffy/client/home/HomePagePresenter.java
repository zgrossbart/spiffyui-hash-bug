package com.github.mbsimonovic.spiffy.client.home;

import com.github.mbsimonovic.spiffy.client.gin.BaseActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class HomePagePresenter extends BaseActivity implements HomePageViewImpl.Presenter {

    private final Provider<HomePageView> viewProvider;
    private Provider<HomePlace> homePlaceProvider;
    private HomePageView view;


    @Inject
    public HomePagePresenter(PlaceController ctrl, Provider<HomePageView> viewProvider,
                             Provider<HomePlace> homePlaceProvider) {
        super(ctrl);
        this.viewProvider = viewProvider;
        this.homePlaceProvider = homePlaceProvider;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        this.view = viewProvider.get();
//        this.view.setPresenter(this);
        panel.setWidget(this.view);
    }
}

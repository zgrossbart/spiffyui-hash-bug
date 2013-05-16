package com.github.mbsimonovic.spiffy.client.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
@Singleton
public class HomePageViewImpl extends Composite implements HomePageView {

    private static HomePageViewUiBinder uiBinder = GWT.create(HomePageViewUiBinder.class);

    interface HomePageViewUiBinder extends UiBinder<Widget, HomePageViewImpl> {
    }

    Presenter presenter;

    public HomePageViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Inject
    @Override
    public void setPresenter(Presenter listener) {
        this.presenter = listener;
//        this.presenter.setView(this);
    }

    @Override
    public Widget asWidget() {
        return this;
    }

}

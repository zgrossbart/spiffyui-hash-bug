package com.github.mbsimonovic.spiffy.client.license;

import com.github.mbsimonovic.spiffy.client.gin.BaseActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class LicensePageActivity extends BaseActivity {

    private Provider<LicenseView> viewProvider;

    @Inject
    public LicensePageActivity(PlaceController ctrl, Provider<LicenseView> licenseViewProvider) {
        super(ctrl);
        this.viewProvider = licenseViewProvider;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(viewProvider.get());
    }
}

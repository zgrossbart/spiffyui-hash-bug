package com.github.mbsimonovic.spiffy.client.contact;

import com.github.mbsimonovic.spiffy.client.gin.BaseActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class ContactPageActivity extends BaseActivity {

    private Provider<ContactView> viewProvider;

    @Inject
    public ContactPageActivity(PlaceController ctrl, Provider<ContactView> contactViewProvider) {
        super(ctrl);
        this.viewProvider = contactViewProvider;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(viewProvider.get());
    }
}

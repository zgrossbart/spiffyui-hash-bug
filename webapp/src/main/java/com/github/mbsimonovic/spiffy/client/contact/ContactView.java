package com.github.mbsimonovic.spiffy.client.contact;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class ContactView extends Composite {

    interface Binder extends UiBinder<Panel, ContactView> {
    }

    private static final Binder binder = GWT.create(Binder.class);

    public ContactView() {
        initWidget(binder.createAndBindUi(this));
        GWT.log("ContactView created");
    }
}

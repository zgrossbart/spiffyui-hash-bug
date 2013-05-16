package com.github.mbsimonovic.spiffy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Milan Simonovic <milan.simonovic@imls.uzh.ch>
 */
public class SpringDbShell extends Composite {

    interface ShellUiBinder extends UiBinder<Widget, SpringDbShell> {
    }

    private static ShellUiBinder uiBinder = GWT.create(ShellUiBinder.class);
    @UiField
    SimplePanel mainStage;

    public SpringDbShell() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public SimplePanel getMainStage() {
        return mainStage;
    }
}

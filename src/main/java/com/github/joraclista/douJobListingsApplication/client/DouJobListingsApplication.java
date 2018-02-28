package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class DouJobListingsApplication implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                DouJobListingsApplicationService.App.getInstance().getJobs("Hello", "World!", new AsyncCallback<List<JobVacancy>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        System.out.println("failure");
                    }

                    @Override
                    public void onSuccess(List<JobVacancy> result) {
                        System.out.println("onSuccess");
                        label.setText(result.get(0).getPosition());
                    }
                });
            }
        });

        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }


}

package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.client.ui.HorizontalDropDown;
import com.github.joraclista.douJobListingsApplication.client.ui.JobResultsPanel;
import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.Arrays;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class DouJobListingsApplication implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        JobResultsPanel jobResultsPanel = new JobResultsPanel();
        RootPanel.get("slot1").add(new HorizontalDropDown<String>(Arrays.asList("Киев", "Харьков", "Днепр", "Львов"), "Киев", "City") {
            @Override
            protected String getLabel(String item) {
                return item;
            }
        });
        RootPanel.get("slot1").add(new HorizontalDropDown<String>(Arrays.asList("Java", "Javascript", ".Net", "Scala", "Node.js", "Python"), "Scala", "Category") {
            @Override
            protected String getLabel(String item) {
                return item;
            }
        });
        RootPanel.get("slot1").add(jobResultsPanel);

//        RootPanel.get("slot1").add(button);
//        RootPanel.get("slot2").add(label);

        DouJobListingsApplicationService.App.getInstance().getJobs("Hello", "World!", new AsyncCallback<List<JobVacancy>>() {
            @Override
            public void onFailure(Throwable caught) {
                System.out.println("failure");
            }

            @Override
            public void onSuccess(List<JobVacancy> result) {
                System.out.println("onSuccess");
                jobResultsPanel.setResults(result);
            }
        });
    }


}

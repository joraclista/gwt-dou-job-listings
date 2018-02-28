package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.client.ui.JobResultsPanel;
import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
        JobResultsPanel jobResultsPanel = new JobResultsPanel();
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

package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.client.ui.HorizontalSelector;
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

    private DouJobListingsApplicationServiceAsync service = DouJobListingsApplicationService.App.getInstance();

    private HorizontalSelector<String> citySelector;
    private HorizontalSelector<String> categorySelector;
    private JobResultsPanel jobResultsPanel;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        jobResultsPanel = new JobResultsPanel();

        citySelector = new HorizontalSelector<String>("City") {
            @Override
            protected String getLabel(String item) {
                return item;
            }
        };

        categorySelector = new HorizontalSelector<String>("Category") {
            @Override
            protected String getLabel(String item) {
                return item;
            }
        };

        categorySelector.setModel(Arrays.asList("Java", "Javascript", ".Net", "Scala", "Node.js", "Python"));

        RootPanel.get("slot1").add(citySelector);
        RootPanel.get("slot1").add(categorySelector);
        RootPanel.get("slot1").add(jobResultsPanel);

        citySelector.addValueChangeHandler(event -> updateResults(citySelector.getSelectedItem(), categorySelector.getSelectedItem()));
        categorySelector.addValueChangeHandler(event -> updateResults(citySelector.getSelectedItem(), categorySelector.getSelectedItem()));

        getCities();
    }

    private void updateResults(String city, String category) {
        service.getJobs(city, category, new AsyncCallback<List<JobVacancy>>() {
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

    private void getCities() {

        service.getCities(new AsyncCallback<List<String>>() {
            @Override
            public void onFailure(Throwable caught) {
                System.out.println("failure");
            }

            @Override
            public void onSuccess(List<String> cities) {
                System.out.println("onSuccess");
                citySelector.setModel(cities);

                updateResults(citySelector.getSelectedItem(), categorySelector.getSelectedItem());
            }
        });
    }

}

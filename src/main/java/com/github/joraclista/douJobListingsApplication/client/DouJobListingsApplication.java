package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.client.ui.HorizontalSelector;
import com.github.joraclista.douJobListingsApplication.client.ui.JobResultsPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class DouJobListingsApplication implements EntryPoint {

    private final String ROOT_PANEL_SLOT_ID = "slot";

    private ListsService listsService = new ListsService();
    private JobsService jobsService = new JobsService();

    private HorizontalSelector<String> citySelector;
    private HorizontalSelector<String> categorySelector;
    private JobResultsPanel jobResultsPanel;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        createUI();

        getLists();
    }

    private void createUI() {
        jobResultsPanel = new JobResultsPanel();

        citySelector = new HorizontalSelector<String>()
                .withHeading("City")
                .withLabelFunction(item -> item);

        categorySelector = new HorizontalSelector<String>()
                .withHeading("Category")
                .withLabelFunction(item -> item);

        addToRoot(citySelector);
        addToRoot(categorySelector);
        addToRoot(jobResultsPanel);

        citySelector.addValueChangeHandler(getUiModelChangeHandler());
        categorySelector.addValueChangeHandler(getUiModelChangeHandler());

    }

    private ValueChangeHandler<String> getUiModelChangeHandler() {
        return event -> updateUI(citySelector.getSelectedItem(), categorySelector.getSelectedItem());
    }

    private void addToRoot(IsWidget widget) {
        RootPanel.get(ROOT_PANEL_SLOT_ID).add(widget);
    }

    private void updateUI(String city, String category) {
        jobsService.getJobs(city, category, new BaseCallback<>(caught -> {}, result -> jobResultsPanel.setResults(result)));
    }

    private void getLists() {
        listsService.getCities(new BaseCallback<>(caught -> {}, result -> {
                citySelector.setModel(result);
                listsService.getCategories(new BaseCallback<>(caught -> {}, _result -> {
                    categorySelector.setModel(_result);
                    updateUI(citySelector.getSelectedItem(), categorySelector.getSelectedItem());
                }));
        }));
    }

}

package com.github.joraclista.douJobListingsApplication.client.ui;

import com.github.joraclista.douJobListingsApplication.shared.model.JobVacancy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import java.util.List;

/**
 * Created by Alisa
 * version 1.0.
 */
public class JobResultsPanel extends Composite {
    interface JobResultsPanelUiBinder extends UiBinder<FlowPanel, JobResultsPanel> {
    }

    private static JobResultsPanelUiBinder ourUiBinder = GWT.create(JobResultsPanelUiBinder.class);
    @UiField
    FlowPanel container;

    public JobResultsPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void setResults(List<JobVacancy> results) {
        container.clear();
        results.stream()
                .map(vacancy -> new VacancyBlock(vacancy))
                .forEach(vacancyBlock -> container.add(vacancyBlock));
    }
}
package com.github.joraclista.douJobListingsApplication.client.ui;

import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Created by Alisa
 * version 1.0.
 */
public class VacancyBlock extends Composite {
    interface VacancyBlockUiBinder extends UiBinder<FlowPanel, VacancyBlock> {
    }

    private static VacancyBlockUiBinder ourUiBinder = GWT.create(VacancyBlockUiBinder.class);
    @UiField
    Label title;
    @UiField
    Label company;
    @UiField
    Label cities;
    @UiField
    Label info;

    public VacancyBlock(JobVacancy vacancy) {
        initWidget(ourUiBinder.createAndBindUi(this));
        title.setText(vacancy.getPosition());
        company.setText(vacancy.getCompany());
        cities.setText(vacancy.getCities());
        info.setText(vacancy.getInfo());
    }
}
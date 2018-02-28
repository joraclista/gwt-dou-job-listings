package com.github.joraclista.douJobListingsApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import java.util.List;

/**
 * Created by Alisa
 * version 1.0.
 */
public abstract class HorizontalDropDown<T> extends Composite {
    interface HorizontalDropDownUiBinder extends UiBinder<FlowPanel, HorizontalDropDown> {
    }

    private static HorizontalDropDownUiBinder ourUiBinder = GWT.create(HorizontalDropDownUiBinder.class);

    private T selectedItem;
    private List<T> items;
    @UiField
    FlowPanel values;
    @UiField
    Label selected;
    @UiField
    Label heading;

    public HorizontalDropDown(List<T> items, T selectedItem, String heading) {
        initWidget(ourUiBinder.createAndBindUi(this));
        this.items = items;
        this.selectedItem = selectedItem;
        this.heading.setText(heading);

        this.values.clear();

        items.stream()
                .map(item -> {
                    Label label = new Label(getLabel(item));
                    label.addClickHandler(event -> {
                        values.setVisible(false);
                        this.selected.setText(getLabel(item));
                        this.selectedItem = item;

                    });
                    return label;

                })
                .forEach(label -> values.add(label));

        this.selected.setText(getLabel(selectedItem));
        this.selected.addClickHandler(event -> values.setVisible(true));
    }

    protected abstract String getLabel(T item);

    public T getSelectedItem() {
        return selectedItem;
    }

}
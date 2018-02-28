package com.github.joraclista.douJobListingsApplication.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
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
public abstract class HorizontalSelector<T> extends Composite implements HasValueChangeHandlers<T> {

    interface HorizontalDropDownUiBinder extends UiBinder<FlowPanel, HorizontalSelector> {
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

    public HorizontalSelector(String heading) {
        initWidget(ourUiBinder.createAndBindUi(this));
        this.heading.setText(heading);
        this.selected.addClickHandler(event -> values.setVisible(true));
    }

    public void setModel(List<T> items) {
        if (items.isEmpty())
            return;

        this.items = items;
        this.values.clear();
        this.selectedItem = items.get(0);
        this.selected.setText(getLabel(selectedItem));
        items.stream()
                .map(item -> {
                    Label label = new Label(getLabel(item));
                    label.addClickHandler(event -> {
                        values.setVisible(false);
                        this.selected.setText(getLabel(item));
                        this.selectedItem = item;
                        ValueChangeEvent.fire(HorizontalSelector.this, item);

                    });
                    return label;

                })
                .forEach(label -> values.add(label));

    }

    protected abstract String getLabel(T item);

    public T getSelectedItem() {
        return selectedItem;
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> handler) {
        return super.addHandler(handler, ValueChangeEvent.getType());
    }

}
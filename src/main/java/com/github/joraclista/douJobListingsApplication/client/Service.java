package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.shared.DouJobsService;
import com.github.joraclista.douJobListingsApplication.shared.DouJobsServiceAsync;
import com.google.gwt.core.client.GWT;

/**
 * Created by Alisa
 * version 1.0.
 */
public class Service {
    private static DouJobsServiceAsync ourInstance = GWT.create(DouJobsService.class);

    public static synchronized DouJobsServiceAsync getInstance() {
        return ourInstance;
    }
}

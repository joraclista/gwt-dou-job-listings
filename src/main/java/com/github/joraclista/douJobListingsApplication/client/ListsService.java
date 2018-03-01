package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.shared.DouJobsServiceAsync;

import java.util.List;

/**
 * Created by Alisa
 * version 1.0.
 */
public class ListsService {

    private DouJobsServiceAsync service = Service.getInstance();

    public void getCategories(BaseCallback<List<String>> baseCallback) {
        service.getCategories(baseCallback);
    }

    public void getCities(BaseCallback<List<String>> baseCallback) {
        service.getCities(baseCallback);
    }
}

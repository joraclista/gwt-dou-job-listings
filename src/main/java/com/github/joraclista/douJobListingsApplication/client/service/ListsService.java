package com.github.joraclista.douJobListingsApplication.client.service;

import com.github.joraclista.douJobListingsApplication.client.BaseCallback;
import com.github.joraclista.douJobListingsApplication.shared.service.DouJobsServiceAsync;

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

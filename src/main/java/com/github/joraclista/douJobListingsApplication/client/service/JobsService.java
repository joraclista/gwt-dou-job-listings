package com.github.joraclista.douJobListingsApplication.client.service;

import com.github.joraclista.douJobListingsApplication.client.BaseCallback;
import com.github.joraclista.douJobListingsApplication.shared.service.DouJobsServiceAsync;
import com.github.joraclista.douJobListingsApplication.shared.model.JobVacancy;

import java.util.List;

/**
 * Created by Alisa
 * version 1.0.
 */
public class JobsService {

    private DouJobsServiceAsync service = Service.getInstance();

    public void getJobs(String city, String category, BaseCallback<List<JobVacancy>> baseCallback) {
        service.getJobs(city, category, baseCallback);
    }
}

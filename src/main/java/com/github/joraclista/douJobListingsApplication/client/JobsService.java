package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.shared.DouJobsServiceAsync;
import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;

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

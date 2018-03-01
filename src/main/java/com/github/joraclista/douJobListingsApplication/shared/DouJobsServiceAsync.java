package com.github.joraclista.douJobListingsApplication.shared;

import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface DouJobsServiceAsync {

    void getJobs(String city, String category, AsyncCallback<List<JobVacancy>> async);

    void getCities(AsyncCallback<List<String>> async);

    void getCategories(AsyncCallback<List<String>> async);
}

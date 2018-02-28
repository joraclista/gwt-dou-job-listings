package com.github.joraclista.douJobListingsApplication.client;

import com.github.joraclista.douJobListingsApplication.shared.JobVacancy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("DouJobListingsApplicationService")
public interface DouJobListingsApplicationService extends RemoteService {

    List<JobVacancy> getJobs(String city, String category);

    List<String> getCities();

    class App {
        private static DouJobListingsApplicationServiceAsync ourInstance = GWT.create(DouJobListingsApplicationService.class);

        public static synchronized DouJobListingsApplicationServiceAsync getInstance() {
            return ourInstance;
        }
    }
}

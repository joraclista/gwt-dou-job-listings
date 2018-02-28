package com.github.joraclista.douJobListingsApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("DouJobListingsApplicationService")
public interface DouJobListingsApplicationService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use DouJobListingsApplicationService.App.getInstance() to access static instance of DouJobListingsApplicationServiceAsync
     */
    public static class App {
        private static DouJobListingsApplicationServiceAsync ourInstance = GWT.create(DouJobListingsApplicationService.class);

        public static synchronized DouJobListingsApplicationServiceAsync getInstance() {
            return ourInstance;
        }
    }
}

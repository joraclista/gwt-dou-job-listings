package com.github.joraclista.douJobListingsApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.github.joraclista.douJobListingsApplication.client.DouJobListingsApplicationService;

public class DouJobListingsApplicationServiceImpl extends RemoteServiceServlet implements DouJobListingsApplicationService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}
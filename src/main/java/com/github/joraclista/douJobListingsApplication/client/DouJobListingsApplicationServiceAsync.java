package com.github.joraclista.douJobListingsApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DouJobListingsApplicationServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}

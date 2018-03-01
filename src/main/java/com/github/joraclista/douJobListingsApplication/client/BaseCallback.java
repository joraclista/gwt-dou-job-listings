package com.github.joraclista.douJobListingsApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.function.Consumer;
import java.util.logging.Logger;

import static java.util.Optional.ofNullable;

/**
 * Created by Alisa
 * version 1.0.
 */
public class BaseCallback<T> implements AsyncCallback<T> {

    private static Logger LOGGER = Logger.getLogger(BaseCallback.class.getName());

    private Consumer<Throwable> onFailure;
    private Consumer<T> onSuccess;

    public BaseCallback(Consumer<Throwable> onFailure, Consumer<T> onSuccess) {
        this.onFailure = onFailure;
        this.onSuccess = onSuccess;
    }


    @Override
    public void onFailure(Throwable caught) {
        LOGGER.severe(() -> "onFailure: e.msg = " + caught.getMessage());
        ofNullable(onFailure).ifPresent(consumer -> consumer.accept(caught));
    }

    @Override
    public void onSuccess(T result) {
        LOGGER.severe(() -> "onSuccess: result = " + result);
        ofNullable(onSuccess).ifPresent(consumer -> consumer.accept(result));
    }
}

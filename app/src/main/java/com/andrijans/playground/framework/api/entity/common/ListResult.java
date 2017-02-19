package com.andrijans.playground.framework.api.entity.common;

/**
 * Created by andrijanstankovic on 19/02/2017.
 */

public abstract class ListResult<T> {
    public abstract T getResults();
    public abstract void setResults(T results);
}

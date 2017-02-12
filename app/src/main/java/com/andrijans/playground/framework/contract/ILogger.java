package com.andrijans.playground.framework.contract;

public interface ILogger {
    public void d(String message);
    public void d(Throwable t);
    public void e(String message);
    public void e(Throwable t);
}
package ginie.service;

import ginie.GinieException;

/**
 * Created by dhruvr
 */
public interface ServiceCycle<T> {

    Lifecycle.State lifecycleState();

    void addLifeCycleListener(LifeCycleListener lifeCycleListener);

    void removeLifeCycleListener(LifeCycleListener lifeCycleListener);

    T start() throws GinieException;

    T stop() throws GinieException;

    void close() throws GinieException;

}

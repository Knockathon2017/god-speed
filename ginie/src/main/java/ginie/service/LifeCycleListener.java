package ginie.service;

/**
 * Created by dhruvr
 */
public interface LifeCycleListener {
    void beforeStart();

    void afterStart();

    void beforeStop();

    void afterStop();

    void beforeClose();

    void afterClose();
}

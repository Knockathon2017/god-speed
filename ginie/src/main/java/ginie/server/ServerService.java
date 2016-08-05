package ginie.server;

import ginie.service.ServiceCycle;

/**
 * Created by dhruvr
 */
public interface ServerService extends ServiceCycle<ServerService> {
    void startServer();

    void serverGracefulStop();

    void stopServer();
}

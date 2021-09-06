package com.yas.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class SessionFactory {
    private Session session;
    private final String address;
    private final int port;
    private final String keySpace;

    public SessionFactory(String address, int port, String keySpace) {
        this.address = address;
        this.port = port;
        this.keySpace = keySpace;
    }

    public Session getSession() {
        if (session == null) {
            Cluster cluster = Cluster.builder().addContactPoint(address).withPort(port).build();
            session = cluster.connect(keySpace);
        }
        return session;
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }
}

package com.yas.dao;

import com.datastax.driver.core.Session;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SessionFactoryTest {
    private static final String CREATE_KEYSPACE_QUERY = "CREATE KEYSPACE IF NOT EXISTS testKeyspace " +
            "WITH replication = {'class':'SimpleStrategy', 'replication_factor':3}";
    private static final int PORT = 9042;
    private static final String KEY_SPACE = "testKeyspace";

    Session session;

    @BeforeAll
    static void setUp() throws IOException, InterruptedException, TTransportException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        EmbeddedCassandraServerHelper.getSession().execute(CREATE_KEYSPACE_QUERY);
    }

    @Test
    void shouldReturnNotNullSession_whenGetSession() {
        SessionFactory sessionFactory = new SessionFactory(EmbeddedCassandraServerHelper.getHost(), PORT, KEY_SPACE);
        session = sessionFactory.getSession();
        assertNotNull(session);
        session.close();
    }

    @Test
    void ShouldCloseSession_whenCloseSession() {
        SessionFactory sessionFactory = new SessionFactory(EmbeddedCassandraServerHelper.getHost(), PORT, KEY_SPACE);
        session = sessionFactory.getSession();
        sessionFactory.closeSession();
        assertTrue(session.isClosed());
    }
}
package com.yas.dao;

import com.datastax.driver.core.Session;
import com.savoirtech.hecate.pojo.dao.PojoDaoFactory;
import com.yas.entity.Weather;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherDaoCassandraTest {
    public static Weather TEST_WEATHER = new Weather("12345678", "testCityName", 100, 101, 102, 103, 104, 105);

    WeatherDao weatherDao;
    Session session;

    @Mock
    SessionFactory sessionFactory;

    @BeforeEach
    void setUp() throws IOException, InterruptedException, TTransportException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        session = EmbeddedCassandraServerHelper.getSession();
        new CQLDataLoader(session).load(new ClassPathCQLDataSet("dataset.cql", "testKeyspace"));
    }

    @Test
    void shouldInsertWeatherDataIntoDB_whenAddCall() {
        when(sessionFactory.getSession()).thenReturn(session);
        PojoDaoFactory pojoDaoFactory = PojoDaoFactoryFactory.createFactory(sessionFactory);
        weatherDao = new WeatherDaoCassandra(pojoDaoFactory);
        weatherDao.add(TEST_WEATHER);

        assertEquals(weatherDao.getById("12345678"), TEST_WEATHER);
    }
}
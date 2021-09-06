package com.yas.dao;

import com.datastax.driver.core.Session;
import com.savoirtech.hecate.pojo.dao.PojoDaoFactory;
import com.savoirtech.hecate.pojo.dao.def.DefaultPojoDaoFactoryBuilder;
import com.savoirtech.hecate.pojo.dao.listener.CreateSchemaListener;

public class PojoDaoFactoryFactory {
    public static PojoDaoFactory createFactory(SessionFactory sessionFactory) {
        Session session = sessionFactory.getSession();
        return new DefaultPojoDaoFactoryBuilder(session)
                .withListener(new CreateSchemaListener(session))
                .build();
    }
}
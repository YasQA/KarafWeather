package com.yas.dao;

import com.savoirtech.hecate.pojo.dao.PojoDao;
import com.savoirtech.hecate.pojo.dao.PojoDaoFactory;
import com.yas.entity.Weather;

public class WeatherDaoCassandra implements WeatherDao {
    private final PojoDao<Weather> dao;

    public WeatherDaoCassandra(PojoDaoFactory pojoDaoFactory) {
        this.dao = pojoDaoFactory.createPojoDao(Weather.class);
    }

    @Override
    public void add(Weather weather) {
        dao.save(weather);
    }

}


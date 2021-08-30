package com.yas.controller;

import com.yas.dto.WeatherDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public interface WeatherRestService {
    @Path("/{city}")
    @Produces("application/json")
    @GET
    WeatherDto getByCity(@PathParam("city") String city);

    @Path("/{code}/{zip}")
    @Produces("application/json")
    @GET
    WeatherDto getByZipAndCountryCode(@PathParam("zip") String zip, @PathParam("code") String countryCode);
}

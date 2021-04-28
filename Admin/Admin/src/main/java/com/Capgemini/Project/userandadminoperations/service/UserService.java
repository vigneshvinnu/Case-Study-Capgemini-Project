package com.Capgemini.Project.userandadminoperations.service;


import com.Capgemini.Project.userandadminoperations.Repository.FlightsRepository;
import com.Capgemini.Project.userandadminoperations.exception.NotFoundException;
import com.Capgemini.Project.userandadminoperations.model.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService{

    @Autowired
    FlightsRepository flightsRepository;

    public List<Flights> getFlightsList()
    {
        List<Flights> flightsList = new ArrayList<Flights>();
        flightsRepository.findAll().forEach(flightsList1 -> flightsList.add(flightsList1));
        if(flightsList.isEmpty()) {
            throw new NotFoundException("No Flights Available");
        }
        return flightsList;
    }

    public List<Flights> getFlightlandingstation(String flightLandingStation)
    {
        List<Flights> flights=  flightsRepository.findByFlightLandingStation(flightLandingStation);

        if(flights.isEmpty())
            throw new NotFoundException("Flight with landing"+flightLandingStation+" doesnot exist.");
        return flights;
    }

    public List<Flights> getFlighttakeoffstation(@PathVariable String flightTakeOffStation)
    {
        List<Flights> flights= flightsRepository.findByFlightTakeOffStation(flightTakeOffStation);
        if(flights.isEmpty())
            throw new NotFoundException("Flight with takeoff"+flightTakeOffStation+" doesn't exist.");
       return flights;
    }



    public List<Flights> getFLighttakeoffandlandingStation(@PathVariable String flightTakeOffStation,
                                                           @PathVariable String flightLandingStation,
                                                           @PathVariable String departureDate)
    {
        List<Flights> flights=
                 flightsRepository.findByFlightTakeOffStationAndFlightLandingStationAndDepartureDate
                         (flightTakeOffStation,flightLandingStation,departureDate);
        if(flights.isEmpty())
            throw new NotFoundException("Flight with takeoff "+flightTakeOffStation+"and landing "+flightLandingStation+"and date"+departureDate+" doesnot exist.");
        return flights;
    }


}

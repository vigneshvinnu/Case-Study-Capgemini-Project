package com.Capgemini.Project.userandadminoperations.service;

import com.Capgemini.Project.userandadminoperations.Repository.FlightsRepository;
import com.Capgemini.Project.userandadminoperations.exception.NotFoundException;
import com.Capgemini.Project.userandadminoperations.model.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {
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


    public Flights getFlightById(@PathVariable String flightId) {
        Optional<Flights> flights =flightsRepository.findById(flightId);
        if(!flights.isPresent())
            throw new NotFoundException("No flight available with flightId : " + flightId);
        return flights.get();
    }


    public ResponseEntity<String> saveOrUpdate(Flights flights)
    {
        flightsRepository.save(flights);
        return null;
    }

    public void delete(String flightId)
    {
        Optional<Flights> flights=flightsRepository.findById(flightId);
          if(!flights.isPresent())
              throw new NotFoundException("FlightId doesn't exist with"+flightId);
        flightsRepository.deleteById(flightId);
    }


   public Flights update(String flightId, Flights flights) throws NotFoundException
    {

            Flights flights1 = flightsRepository.findByFlightId(flightId);
            flights1.setArrivalDate(flights.getArrivalDate());
            flights1.setDepartureDate(flights.getDepartureDate());
            flights1.setDepartureTime(flights.getDepartureTime());
            flights1.setArrivalTime(flights.getArrivalTime());
            flights1.setFlightLandingStation(flights.getFlightLandingStation());
            flights1.setFlightTakeOffStation(flights.getFlightTakeOffStation());
            flights1.setPrice(flights.getPrice());
            flightsRepository.save(flights1);
            return flights1;

    }


}

package com.capgemini.project.farecalculator.controller;

import com.capgemini.project.farecalculator.service.Fareservice;
import com.capgemini.project.farecalculator.model.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fare")
public class farecontroller {
    @Autowired
    Fareservice fareService;

    @GetMapping("/fare")
    public Object getFareEstimator(Fare fare)
    {
        return fareService.saveOrUpdate(fare);
    }

    @GetMapping("/fares")
    public ResponseEntity<?> getAllFares()
    {
        return ResponseEntity.ok(fareService.getAll());
    }

    @GetMapping("/fare/{farenum}")
    public ResponseEntity<Optional<Fare>> getFare(@PathVariable int farenum)
    {
        return ResponseEntity.ok(fareService.getByFarenum(farenum));
    }

    /*public Object getFareEstimator(@RequestBody transactionRequest request)
    {
        return fareService.saveOrUpdate(request);
    }*/

    /*@PostMapping("/flights/addFare")
    public ResponseEntity<?> saveFlightDetails(@RequestBody Fare fare) {
        fareService.saveFare(fare);
        return new ResponseEntity<>("Added fare with number: "+fare.getFarenum(), HttpStatus.OK);
    }*/


}
package com.capgemini.project.farecalculator;

import com.capgemini.project.farecalculator.model.Fare;
import com.capgemini.project.farecalculator.service.Fareservice;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FarecalculatorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	Fareservice fareservice;


	@Test
	public void fareEstimation()
	{
		Fare fare=new Fare(10,23,1000);
		fareservice.saveOrUpdate(fare);
		System.out.println(fare);
		assertNotNull(fare,"successfull");
	}

	@Test
	@AfterEach
	public void Successful()
	{
		System.out.println("Successfully tested");
	}


	@Test
	public void getAll()
	{

		List<Fare> fare=  fareservice.getAll();
		System.out.println(fare);
		assertNotNull(fare);

	}

}

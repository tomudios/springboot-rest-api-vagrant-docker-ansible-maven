package ld.toli.virtustream.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ld.toli.virtustream.restful.service.FibonacciService;

@RestController
public class FibonacciServiceController {
	@Autowired
	FibonacciService carService;
	
	@RequestMapping(value="/fibonacci/getFirst/{n}")
	public ResponseEntity<Object> getFibonacci(@PathVariable("n") Long n) {
		return new ResponseEntity<Object>(carService.getFibonacci(n), HttpStatus.OK);
	}
}

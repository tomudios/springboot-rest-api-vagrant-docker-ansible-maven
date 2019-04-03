package ld.toli.virtustream.restful.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RestController;

import ld.toli.virtustream.restful.AbstractTest;

@RestController
public class FibonacciServiceControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getFibonacci1() throws Exception {
		String uri = "/fibonacci/getFirst/2";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
	    Long[] fibonacciNumber = super.mapFromJson(content, Long[].class);
	    Long[] result2 = new Long[]{(long) 0, (long) 1};
	    
	    assertTrue(fibonacciNumber.length == 2);
	    assertEquals(content, super.mapToJson(result2));
	}
	
	@Test
	public void getFibonacci5() throws Exception {
		String uri = "/fibonacci/getFirst/5";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
	    Long[] fibonacciNumber = super.mapFromJson(content, Long[].class);
	    Long[] result5 = new Long[]{(long) 0, (long) 1, (long) 1, (long) 2, (long) 3};
	    
	    assertTrue(fibonacciNumber.length == 5);
	    assertEquals(content, super.mapToJson(result5));
	}
	
	@Test
	public void getFibonacciMin() throws Exception {
		String uri = "/fibonacci/getFirst/-1";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(412, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Value must be greater than 0", content);
	}
	
	@Test
	public void getFibonacciMax() throws Exception {
		String uri = "/fibonacci/getFirst/94";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(412, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Value must be less than or equal to 93", content);
	}
}

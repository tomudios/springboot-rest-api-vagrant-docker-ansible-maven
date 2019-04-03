package ld.toli.virtustream.restful.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import ld.toli.virtustream.restful.exception.MaxValueExceededException;
import ld.toli.virtustream.restful.exception.MinValueExceededException;

@Service
public class FibonacciServiceImpl implements FibonacciService {

	@Override
	public Collection<Long> getFibonacci(Long n) {
		if (n <= 0) throw new MinValueExceededException();
		if (n > 93) throw new MaxValueExceededException();
		
		ArrayList<Long> result = new ArrayList<Long>();
		Long i = (long) 1;
		result.add((long) 0);
		
		while (i < n)
	    {
			if (i==1)
				result.add((long) 1);
			else
				result.add(result.get(result.size()-1) + result.get(result.size() - 2));

	        i++;
	    }
	    
		return result;
	}

}

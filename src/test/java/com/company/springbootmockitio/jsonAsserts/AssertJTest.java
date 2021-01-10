package com.company.springbootmockitio.jsonAsserts;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
public class AssertJTest {
	
	@Test
	public void assertJMethods() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		
		assertThat(numbers).hasSize(3).contains(12,15).allMatch(e -> e>10)
													   .allMatch(e -> e <80)
													   .allMatch(e -> e > 0)
													   .noneMatch(e -> e < 0)
													   ;
		
		assertThat("").isEmpty();
		assertThat("ABCD").startsWith("AB").contains("BC").endsWith("CD");
		
		
	}

	

}

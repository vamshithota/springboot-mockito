package com.company.springbootmockitio.jsonAsserts;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void jsonPathTests() {
		String responseFromService = "[" + 
				"{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5}," + 
				"{\"id\":10001, \"name\":\"Pen\", \"quantity\":15}," + 
				"{\"id\":10002, \"name\":\"Eraser\", \"quantity\":10}" + 
				"]";
		
		DocumentContext context  = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		System.out.println(length);
		assertThat(length).isEqualTo(3);
		
		List<Integer> ls = context.read("$..id");
		System.out.println(ls.toString());
		assertThat(ls.size()).isEqualTo(3);
		assertThat(ls).containsExactly(10000,10001,10002);
		System.out.println( context.read("$.[1]").toString());
		System.out.println("** " +context.read("$.[1:3]").toString());
		System.out.println(context.read("$.[?(@.name=='Pen')]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
	}
	
}

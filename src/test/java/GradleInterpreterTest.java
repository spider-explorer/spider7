import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import groovy.util.Eval;

class GradleInterpreterTest {

	@Test
	void test() {
		//Integrating Groovy in a Java application
		//https://docs.groovy-lang.org/latest/html/documentation/guide-integrating.html
		System.out.println(Eval.me("33*3"));
		System.out.println(Eval.me("'foo'.toUpperCase()"));
	}

}

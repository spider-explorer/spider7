package global;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import groovy.lang.GroovyShell;
import groovy.util.Eval;

class DummyTest {

	@Test
	void test() {
		// https://docs.groovy-lang.org/latest/html/documentation/guide-integrating.html
		System.out.println(Eval.me("33*3"));
		System.out.println(Eval.me("'foo'.toUpperCase()"));
		var shell = new GroovyShell();
		System.out.println(shell.evaluate("3*5"));    
	}

}

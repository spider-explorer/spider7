import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import groovy.lang.GroovyShell;
import groovy.util.Eval;

class GradleInterpreterTest {

	@Test
	void test() {
		//Integrating Groovy in a Java application
		//https://docs.groovy-lang.org/latest/html/documentation/guide-integrating.html
		System.out.println(Eval.me("33*3"));
		System.out.println(Eval.me("'foo'.toUpperCase()"));
		
		var shell = new GroovyShell(GradleInterpreterTest.class.getClassLoader());
		shell.evaluate("""
				def vm = new global.VM8()
				vm.print(123.45D)
				""");
	}

}

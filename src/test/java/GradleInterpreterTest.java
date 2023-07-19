import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.Eval;

class GradleInterpreterTest {

	@Test
	void test() {
		//Integrating Groovy in a Java application
		//https://docs.groovy-lang.org/latest/html/documentation/guide-integrating.html
		System.out.println(Eval.me("33*3"));
		System.out.println(Eval.me("'foo'.toUpperCase()"));
		
		var sharedData = new Binding();
		sharedData.setProperty("vm", new global.VM8());
		var shell = new GroovyShell(GradleInterpreterTest.class.getClassLoader(), sharedData);
		shell.evaluate("""
				def vm2 = new global.VM8()
				vm2.print(123.45D)
				vm.print(777D)
				""");
	}

}

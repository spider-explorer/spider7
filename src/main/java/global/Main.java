package global;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		System.out.println(Adder.Add2(11, 22));
		Pattern pattern;
		//pattern = Pattern.compile(".*");
		//pattern = Pattern.compile("org/.*");
		pattern = Pattern.compile(".*\\.txt");
		final Collection<String> list = ResourceList.getResources(pattern);
		for (final String name : list) {
			System.out.println(name);
		}
		System.out.println(ResourceUtil.GetString("dummy.txt").toString());
		VM8 vm = new VM8();
		vm.print(args, "args");
		var ary = vm.newArray("x", -1, null);
		ary.add("a");
		ary.add(123);
		vm.print(ary, "ary");
		var obj = vm.newObject("x", -1, "y", null);
		obj.put("a", 123);
		obj.put("b", "bbb");
		vm.print(obj);
		vm.load(":/json.js");
		//vm.loadFile("json.js");
		// vm.loadFile(":/json.js");
		// vm.loadFile("https://raw.githubusercontent.com/up-language/up-language/main/om-java/json.js");
		vm.js("print(JSON.stringify(json, null, 2))");
		var json = vm.js("json");
		assertEquals("{\"a\":\"abc\",\"b\":123,\"c\":[11,22,33]}", vm.jsToJson("json").toString());
		vm.print(vm.asObject(json).get("c"));
		vm.print(vm.js("$0.c[$1]", json, 1));
	}
}

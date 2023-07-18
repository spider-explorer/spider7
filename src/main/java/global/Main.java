package global;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

	class ClassLoaderUtil {
		public static URLClassLoader newClassLoader(Set<File> files) {
			URL[] urls = files.stream().map(file -> getURL(file)).collect(Collectors.toList()).toArray(new URL[0]);
			return new URLClassLoader(urls, null);
		}

		private static URL getURL(File file) {
			try {
				return file.toURI().toURL();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		System.out.println(Adder.Add2(11, 22));

		/*
		String appPath = System.getProperty("java.application.path");
		String appName = System.getProperty("java.application.name");

		System.clearProperty("java.application.path");
		System.clearProperty("java.application.name");

		System.out.printf("appPath=%s\n", appPath);
		System.out.printf("appName=%s\n", appName);

		if (appPath != null) {
			String jarPath = appPath + "/noname-all.jar";
			File file = new File(jarPath);
			//var fileList = new ArrayList<File>();
			//fileList.add(file);
			URLClassLoader load = URLClassLoader.newInstance(new URL[] { file.toURI().toURL() });
			Class<?> cl = load.loadClass("global.Main");
			Method mt = cl.getMethod("main", new Class[] { String[].class });
			// String[] args = {"arg1", "arg2", "arg3"};
			mt.invoke(null, (Object) args);
			return;
		}
		*/

		// Pattern pattern;
		// pattern = Pattern.compile(".*");
		// pattern = Pattern.compile("org/.*");
		/*
		 * pattern = Pattern.compile(".*\\.txt"); final Collection<String> list =
		 * ResourceList.getResources(pattern); for (final String name : list) {
		 * System.out.println(name); }
		 * System.out.println(ResourceUtil.GetString("dummy.txt").toString());
		 */
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
		// vm.loadFile("json.js");
		// vm.loadFile(":/json.js");
		// vm.loadFile("https://raw.githubusercontent.com/up-language/up-language/main/om-java/json.js");
		vm.js("print(JSON.stringify(json, null, 2))");
		var json = vm.js("json");
		assertEquals("{\"a\":\"abc\",\"b\":123,\"c\":[11,22,33]}", vm.jsToJson("json").toString());
		vm.print(vm.asObject(json).get("c"));
		vm.print(vm.js("$0.c[$1]", json, 1));
	}
}

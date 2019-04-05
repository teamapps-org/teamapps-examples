package org.teamapps.examples;


import java.util.Arrays;
import java.util.Map;

public class RunExample extends AbstractRunExample {

	public RunExample(int port) {
		super(port);
	}

	public static int getPort() {
		Map<String, String> env = System.getenv();
		int defaultPort = 8080;
		String port = env.get("TEAMAPPS_EXAMPLES_PORT");
		if (port == null) {
			return defaultPort;
		}

		try {
			return Integer.parseInt(port);
		} catch (NumberFormatException e) {
			System.err.println("Invalid port in TEAMAPPS_EXAMPLE_PORT env!");
			return defaultPort;
		}
	}

	public static void main(String[] args) {
		RunExample run = new RunExample(getPort());
		if (args.length > 0) {
			Object[] examples = Arrays.stream(args)
					.map(className -> {
						try {
							Class<?> clazz = Class.forName(className);
							return clazz.getConstructor().newInstance();
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					})
					.toArray();
			run.runServerWithExamples(examples);
		} else {
			run.runServerWithExamples(/* insert your example instances here */);
		}
	}

}

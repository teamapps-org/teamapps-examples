package org.teamapps.examples;


import java.util.Arrays;

public class RunExample extends AbstractRunExample {
	public static void main(String[] args) {
		RunExample run = new RunExample();
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

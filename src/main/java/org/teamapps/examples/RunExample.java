package org.teamapps.examples;

import org.teamapps.examples.components.containers.PanelExample;

public class RunExample extends AbstractRunExample {

	public static void main(String[] args) {
		RunExample run = new RunExample();

		run.runServerWithExamples(new PanelExample());
	}
}

/*-
 * ========================LICENSE_START=================================
 * TeamApps
 * ---
 * Copyright (C) 2014 - 2019 TeamApps.org
 * ---
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package org.teamapps.examples;

import com.google.common.io.Files;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.server.jetty.embedded.TeamAppsJettyEmbeddedServer;
import org.teamapps.util.ReflectionUtil;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.flexcontainer.FlexSizeUnit;
import org.teamapps.ux.component.flexcontainer.FlexSizingPolicy;
import org.teamapps.ux.component.flexcontainer.VerticalLayout;
import org.teamapps.webcontroller.SimpleWebController;
import org.teamapps.webcontroller.WebController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AbstractExample implements Example {

	private List<ExampleComponent> exampleComponents = new ArrayList<>();

	public AbstractExample() {
		try {
			List<Method> componentProducerMethods = ReflectionUtil.findMethods(getClass(),
					method -> method.getAnnotation(TeamAppsDocMethod.class) != null
							&& Component.class.isAssignableFrom(method.getReturnType())
							&& method.getParameterTypes().length == 0);
			for (Method componentProducerMethod : componentProducerMethods) {
				addExampleComponent((Component) componentProducerMethod.invoke(this));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void addExampleComponent(Component component) {
		addExampleComponent(component, 0, 0);
	}

	public void addExampleComponent(Component component, int height) {
		addExampleComponent(component, 0, height);
	}

	public void addExampleComponent(Component component, int width, int height) {
		if (height == 0) {
			height = 700;
		}
		exampleComponents.add(new ExampleComponent(width, height, component));
	}

	public void runExample(final Component component) {
		try {
			WebController controller = new SimpleWebController(context -> component);
			new TeamAppsJettyEmbeddedServer(controller, Files.createTempDir()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void runExamples() {
		try {
			WebController controller = new SimpleWebController(context -> {
				VerticalLayout verticalLayout = new VerticalLayout();
				for (ExampleComponent exampleComponent : exampleComponents) {
					if (exampleComponent.getHeight() == 0) {
						verticalLayout.addComponent(exampleComponent.getComponent());
					} else {
						verticalLayout.addComponent(exampleComponent.getComponent(), new FlexSizingPolicy(exampleComponent.getHeight(), FlexSizeUnit.PIXEL, 0, 0));
					}
				}
				return verticalLayout;
			});
			new TeamAppsJettyEmbeddedServer(controller, Files.createTempDir()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ExampleComponent> getExampleComponents() {
		return exampleComponents;
	}

}

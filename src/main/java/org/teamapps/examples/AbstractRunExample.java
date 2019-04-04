package org.teamapps.examples;

import com.google.common.io.Files;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.server.jetty.embedded.TeamAppsJettyEmbeddedServer;
import org.teamapps.util.ReflectionUtil;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.absolutelayout.AbsoluteLayout;
import org.teamapps.ux.component.absolutelayout.AbsolutePosition;
import org.teamapps.ux.component.absolutelayout.Length;
import org.teamapps.webcontroller.SimpleWebController;
import org.teamapps.webcontroller.WebController;

import java.lang.reflect.Method;
import java.util.List;


public abstract class AbstractRunExample {


	public void runServerWithExamples(Object example) {
		runServerWithExamples(new Object[] {example});
	}

	public void runServerWithExamples(Object ... examples) {
		try {
			WebController controller = new SimpleWebController(context -> {
				final AbsoluteLayout absoluteLayout = new AbsoluteLayout();
				for (Object example : examples) {
					List<Method> methods = ReflectionUtil.findMethods(example.getClass(), method -> true);
					int top = 10;
					for (Method method : methods) {
						try {
							if (method.getAnnotation(TeamAppsDocMethod.class) != null && method.getParameterTypes().length == 0) {
								if (ExampleComponent.class.isAssignableFrom(method.getReturnType())) {
									ExampleComponent exampleComponent = (ExampleComponent) method.invoke(example);
									Length width = exampleComponent.getWidth() == 0 ? null : new Length(exampleComponent.getWidth());
									Length height = exampleComponent.getHeight() == 0 ? null : new Length(exampleComponent.getHeight());
									absoluteLayout.putComponent(exampleComponent.getComponent(), new AbsolutePosition(new Length(top), new Length(30), null, new Length(30), width,  height, 1));
								} else if (Component.class.isAssignableFrom(method.getReturnType())) {
									Component component = (Component) method.invoke(example);
									absoluteLayout.putComponent(component, new AbsolutePosition(new Length(top), new Length(30), null, new Length(30), null,  null, 1));
									top += 100;
								}
							}
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}
				return absoluteLayout;
			});
			new TeamAppsJettyEmbeddedServer(controller, Files.createTempDir()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

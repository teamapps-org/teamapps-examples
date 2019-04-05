package org.teamapps.examples;

import com.google.common.io.Files;
import org.teamapps.common.format.Color;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.server.jetty.embedded.TeamAppsJettyEmbeddedServer;
import org.teamapps.util.ReflectionUtil;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.absolutelayout.Length;
import org.teamapps.ux.component.flexcontainer.VerticalLayout;
import org.teamapps.ux.component.format.Spacing;
import org.teamapps.ux.component.toolbar.Toolbar;
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
			WebController controller = SimpleWebController.createDefaultController(context -> {
				final VerticalLayout verticalLayout = new VerticalLayout();
				for (Object example : examples) {
					List<Method> methods = ReflectionUtil.findMethods(example.getClass(), method -> true);
					int top = 10;
					for (Method method : methods) {
						try {
							if (method.getAnnotation(TeamAppsDocMethod.class) != null && method.getParameterTypes().length == 0) {
								if (Component.class.isAssignableFrom(method.getReturnType())) {
									Component component = (Component) method.invoke(example);
									if (!(component instanceof Toolbar)) {
										component.setMinHeight(new Length(500));
									}
									component.setMargin(new Spacing(15, 30));
									verticalLayout.addComponent(component);
								}
							}
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}
				return verticalLayout;
			}, Color.WHITE);
			new TeamAppsJettyEmbeddedServer(controller, Files.createTempDir()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

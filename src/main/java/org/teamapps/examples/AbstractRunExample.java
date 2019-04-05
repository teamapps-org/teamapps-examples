package org.teamapps.examples;

import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.teamapps.common.format.Color;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.server.jetty.embedded.TeamAppsJettyEmbeddedServer;
import org.teamapps.util.ReflectionUtil;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.absolutelayout.Length;
import org.teamapps.ux.component.flexcontainer.VerticalLayout;
import org.teamapps.ux.component.format.Spacing;
import org.teamapps.ux.component.panel.Panel;
import org.teamapps.ux.component.table.Table;
import org.teamapps.webcontroller.SimpleWebController;
import org.teamapps.webcontroller.WebController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractRunExample {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRunExample.class);
	private static final Map<Class<? extends Component>, Integer> DEFAULT_MIN_HEIGHTS = new HashMap<>() {{
		put(Panel.class, 500);
		put(Table.class, 500);
	}};

	int port;

	AbstractRunExample(int port) {
		this.port = port;
	}

	public void runServerWithExamples(Object example) {
		runServerWithExamples(new Object[]{example});
	}

	public void runServerWithExamples(Object... examples) {
		try {
			WebController controller = SimpleWebController.createDefaultController(context -> {
				final VerticalLayout verticalLayout = new VerticalLayout();
				for (Object example : examples) {
					List<Method> methods = ReflectionUtil.findMethods(example.getClass(), method -> true);
					int top = 10;
					for (Method method : methods) {
						try {
							TeamAppsDocMethod docAnnotation = method.getAnnotation(TeamAppsDocMethod.class);
							if (docAnnotation != null && method.getParameterTypes().length == 0) {
								if (Component.class.isAssignableFrom(method.getReturnType())) {
									Component component = (Component) method.invoke(example);
									if (docAnnotation.height() > 0) {
										component.setMinHeight(new Length(docAnnotation.height()));
									} else if (DEFAULT_MIN_HEIGHTS.containsKey(component.getClass())) {
										component.setMinHeight(new Length(DEFAULT_MIN_HEIGHTS.get(component.getClass())));
									}
									component.setMargin(new Spacing(15, 30));
									verticalLayout.addComponent(component);
								} else {
									LOGGER.info("Method {} is annotated with @{} but does not return a Component. This might be intentional.", method.getName(),
											TeamAppsDocMethod.class.getSimpleName());
								}
							}
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}
				return verticalLayout;
			}, Color.WHITE);
			new TeamAppsJettyEmbeddedServer(controller, Files.createTempDir(), port).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

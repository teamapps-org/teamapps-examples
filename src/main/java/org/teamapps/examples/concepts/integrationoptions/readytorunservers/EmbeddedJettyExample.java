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
package org.teamapps.examples.concepts.integrationoptions.readytorunservers;


import org.teamapps.documentation.generator.annotation.TeamAppsDocClass;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.icon.material.MaterialIcon;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.panel.Panel;

@TeamAppsDocClass(title = "Embedded Jetty")
public class EmbeddedJettyExample {

	/**
	 * TODO Add documentation.
	 */
	@TeamAppsDocMethod(title = "Example 1")
	public Component createExampleComponent() {
		// TODO Write example code.
		Panel panel = new Panel(MaterialIcon.FOLDER, "Example panel");
		panel.setStretchContent(false);
		panel.setPadding(10);
		return panel;
	}
}

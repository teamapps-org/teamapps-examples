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
package org.teamapps.examples.components.containers;


import org.teamapps.documentation.generator.annotation.TeamAppsDocClass;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.icon.material.MaterialIcon;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.panel.Panel;

@TeamAppsDocClass(title = "Panel")
public class PanelExample {
    
    /**
     *  <p>
     *      <code>Panel</code> is the simplest container entity.
     *      Its default state is a box with a border, a title and an icon.
     *  </p>
     */
    @TeamAppsDocMethod(title = "Simple Panel", images = "Panel-simplePanel.png")
    public Component simplePanel() {
        Panel panel = new Panel(MaterialIcon.FOLDER, "Simple Panel");
        panel.setStretchContent(false);
        panel.setPadding(10);
        return panel;
    }
    
    
}

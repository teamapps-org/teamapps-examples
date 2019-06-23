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
import org.teamapps.ux.component.absolutelayout.Length;
import org.teamapps.ux.component.absolutelayout.SizeUnit;
import org.teamapps.ux.component.field.Label;
import org.teamapps.ux.component.flexcontainer.VerticalLayout;
import org.teamapps.ux.component.panel.Panel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: Replace Screenshots when maxHeight=100px and maxWidth=300px works correctly
 * => Because the images do fit better into the documentation with height 100px than height over 400px
 */
@TeamAppsDocClass(title = "Panel")
public class PanelExample {
    
    private int MAX_WIDTH_INT = 400;
    private int MAX_HEIGHT_INT = 200;
    
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
        panel.setMaxWidth(new Length(MAX_WIDTH_INT, SizeUnit.PIXEL));
        panel.setMaxHeight(new Length(MAX_HEIGHT_INT, SizeUnit.PIXEL));
        return panel;
    }
    
    /**
     *  <p>
     *      A <code>Panel</code> can have exactly one child <code>Component</code>.
     *      The child can be added by calling <code>panel.setContent()</code>.
     *  </p>
     *
     */
    @TeamAppsDocMethod(title = "Panel with Child", images = "Panel-withChild.png")
    public Component panelWithChild() {
        Panel panel = new Panel(MaterialIcon.FOLDER, "Panel with Child");
        panel.setStretchContent(true);
        panel.setPadding(10);
        panel.setMaxWidth(new Length(MAX_WIDTH_INT, SizeUnit.PIXEL));
        panel.setMaxHeight(new Length(MAX_HEIGHT_INT, SizeUnit.PIXEL));
        panel.setContent(new Label("This is some example content with an icon.", MaterialIcon.WALLPAPER));
        return panel;
    }
    
    /**
     *  <p>
     *      If you want to have multiple children inside a <code>Panel</code>,
     *      you need some kind of layout component as the Panel-child,
     *      for example <code>VerticalLayout</code> or <code>HorizontalLayout</code>.
     *      Please see the section about layout components for more in-depth information
     *  </p>
     *
     */
    @TeamAppsDocMethod(title = "Panel with Children", images = "Panel-withChildren.png")
    public Component panelWithChildren() {
        VerticalLayout layout = new VerticalLayout();
        
        // This makes the vertical layout scrollable
        layout.setCssStyle("overflow-y", "auto");
        
        Panel iconPanel = new Panel(MaterialIcon.TRAFFIC, "Icon List");
        iconPanel.setContent(layout);
        iconPanel.setPadding(10);
        iconPanel.setMaxWidth(new Length(MAX_WIDTH_INT, SizeUnit.PIXEL));
        iconPanel.setMaxHeight(new Length(MAX_HEIGHT_INT, SizeUnit.PIXEL));
        
        List<MaterialIcon> iconList = new ArrayList<>(Arrays.asList(MaterialIcon.values())).subList(0, 100);
        
        for (MaterialIcon icon : iconList) {
            layout.addComponent(new Label(icon.getIconName(), icon));
        }
        
        return iconPanel;
    }
    
}

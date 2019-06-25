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
package org.teamapps.examples.components.layouts;


import org.teamapps.documentation.generator.annotation.TeamAppsDocClass;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.examples.util.ExampleUtil;
import org.teamapps.icon.material.MaterialIcon;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.field.Label;
import org.teamapps.ux.component.flexcontainer.HorizontalLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TeamAppsDocClass(title = "Horizontal Layout")
public class HorizontalLayoutExample {
    
    /**
     * <code>HorizontalLayout</code> allows multiple children to be positioned next to each other on the same row.
     * Note, that this layout is not scrollable per default.
     * It can be made scrollable by using css, as shown below.
     */
    @TeamAppsDocMethod(title = "Simple Horizontal Layout", images = "HorizontalLayout-simple.png")
    public Component simpleHorizontalLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        
        // This makes the horizontal layout scrollable
        layout.setCssStyle("overflow-x", "auto");
        
        List<MaterialIcon> iconList = new ArrayList<>(Arrays.asList(MaterialIcon.values())).subList(0, 20);
        
        for (MaterialIcon icon : iconList) {
            Label label = new Label(icon.getIconName(), icon);
            label.setCssStyle("padding", "10px 20px");
            layout.addComponent(label);
        }
        
        // This panel is used to contain the vertical layout in a small box.
        var containerPanel = ExampleUtil.generateContainerPanel(
                "Simple Horizontal Layout",
                800, 200);
        containerPanel.setContent(layout);
        
        return containerPanel;
    }
}

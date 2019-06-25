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
import org.teamapps.icon.material.MaterialIcon;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.field.Label;
import org.teamapps.ux.component.flexcontainer.VerticalLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TeamAppsDocClass(title = "Vertical Layout")
public class VerticalLayoutExample {
    
    /**
     * <code>VerticalLayout</code> allows multiple children to be stacked vertically.
     * Note, that this layout is not scrollable per default.
     * It can be made scrollable by using css, as shown below.
     */
    @TeamAppsDocMethod(title = "Simple Vertical Layout", images = "VerticalLayout-simple.png")
    public Component simpleVerticalLayout() {
        VerticalLayout layout = new VerticalLayout();

        // This makes the vertical layout scrollable
        layout.setCssStyle("overflow-y", "auto");
        
        List<MaterialIcon> iconList = new ArrayList<>(Arrays.asList(MaterialIcon.values())).subList(0, 100);
        
        for (MaterialIcon icon : iconList) {
            layout.addComponent(new Label(icon.getIconName(), icon));
        }
        
        return layout;
    }
}

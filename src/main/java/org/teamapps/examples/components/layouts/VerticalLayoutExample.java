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
import org.teamapps.ux.component.flexcontainer.FlexSizeUnit;
import org.teamapps.ux.component.flexcontainer.FlexSizingPolicy;
import org.teamapps.ux.component.flexcontainer.VerticalLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        
        // This panel is used to contain the vertical layout in a small box.
        var containerPanel = ExampleUtil.generateContainerPanel("Simple Vertical Layout");
        containerPanel.setContent(layout);
        
        return containerPanel;
    }
    
    
    /**
     * Since <code>VerticalLayout</code> is based on CSS FlexBox, each item can be sized with FlexSizingProperties.
     */
    @TeamAppsDocMethod(title = "Vertical Layout with FlexSizingProperties", images = "VerticalLayout-flexProperties.png")
    public Component flexSizingProperties() {
        VerticalLayout layout = new VerticalLayout();
        
        // This makes the vertical layout scrollable
        layout.setCssStyle("overflow-y", "auto");
        
        List<MaterialIcon> iconList = new ArrayList<>(Arrays.asList(MaterialIcon.values())).subList(0, 100);
        
        Random random = new Random();
        
        for (MaterialIcon icon : iconList) {
            Label label = new Label(icon.getIconName(), icon);
            float baseSize = 20 + random.nextInt(50);
            layout.addComponent(label, new FlexSizingPolicy(baseSize, FlexSizeUnit.PIXEL, 1, 1)
            );
        }
        
        // This panel is used to contain the vertical layout in a small box.
        var containerPanel = ExampleUtil.generateContainerPanel("Vertical Layout with FlexSizingProperties");
        containerPanel.setContent(layout);
        
        return containerPanel;
    }
    
    
    /**
     *
     */
    @TeamAppsDocMethod(title = "Add Components with auto size", images = "")
    public Component addComponentAutoSize() {
        // TODO!
        return new VerticalLayout();
    }
    
    /**
     *
     */
    @TeamAppsDocMethod(title = "Add Components with fill remaining", images = "")
    public Component addComponentFillRemaining() {
        // TODO!
        return new VerticalLayout();
    }
    
}

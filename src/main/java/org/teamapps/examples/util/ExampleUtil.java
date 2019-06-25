package org.teamapps.examples.util;

import org.teamapps.icon.material.MaterialIcon;
import org.teamapps.ux.component.absolutelayout.Length;
import org.teamapps.ux.component.absolutelayout.SizeUnit;
import org.teamapps.ux.component.panel.Panel;

public class ExampleUtil {
    
    public static Panel generateContainerPanel(String title) {
        return generateContainerPanel(title, 400, 200);
    }
    
    public static Panel generateContainerPanel(String title, int maxWidth, int maxHeight) {
        Panel containerPanel = new Panel(MaterialIcon.LAYERS, title);
        containerPanel.setStretchContent(false);
        containerPanel.setPadding(10);
        containerPanel.setMaxWidth(new Length(maxWidth, SizeUnit.PIXEL));
        containerPanel.setMaxHeight(new Length(maxHeight, SizeUnit.PIXEL));
        
        return containerPanel;
    }
}

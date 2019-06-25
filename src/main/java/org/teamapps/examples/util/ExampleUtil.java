package org.teamapps.examples.util;

import org.teamapps.icon.material.MaterialIcon;
import org.teamapps.ux.component.absolutelayout.Length;
import org.teamapps.ux.component.absolutelayout.SizeUnit;
import org.teamapps.ux.component.panel.Panel;

public class ExampleUtil {
    
    private static int MAX_WIDTH_INT = 400;
    private static int MAX_HEIGHT_INT = 200;
    
    public static Panel generateContainerPanel(String title) {
        Panel containerPanel = new Panel(MaterialIcon.LAYERS, title);
        containerPanel.setStretchContent(false);
        containerPanel.setPadding(10);
        containerPanel.setMaxWidth(new Length(MAX_WIDTH_INT, SizeUnit.PIXEL));
        containerPanel.setMaxHeight(new Length(MAX_HEIGHT_INT, SizeUnit.PIXEL));
        
        return containerPanel;
    }
}

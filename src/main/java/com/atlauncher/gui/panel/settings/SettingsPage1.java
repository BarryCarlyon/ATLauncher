package com.atlauncher.gui.panel.settings;

import com.atlauncher.gui.comp.AlignedOptionsPanel;
import com.atlauncher.gui.comp.ITitled;

import javax.swing.*;
import java.awt.*;

public final class SettingsPage1 extends AlignedOptionsPanel implements ITitled {
    private static final JTextField JAVA_PARAMS = new JTextField(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JTextField JAVA_PERMGEN = new JTextField(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JTextField JAVA_PATH = new JTextField(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JComboBox<Integer> JAVA_MEMORY = new JComboBox<Integer>(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };

    private static final JComponent[] COMPS = new JComponent[]{
            JAVA_PARAMS, JAVA_MEMORY, JAVA_PATH, JAVA_PERMGEN
    };

    private static final String[] NAMES = new String[]{
            "Java Parameters: ", "Java Memory: ", "Java Path: ", "Java Permagen: "
    };

    public SettingsPage1(){
        super(COMPS, NAMES);
    }

    @Override
    public String getTitle(){
        return "Java Settings";
    }
}
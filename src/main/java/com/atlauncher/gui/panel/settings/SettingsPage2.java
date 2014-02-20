package com.atlauncher.gui.panel.settings;

import com.atlauncher.gui.comp.AlignedOptionsPanel;
import com.atlauncher.gui.comp.ITitled;

import javax.swing.*;
import java.awt.*;

public final class SettingsPage2 extends AlignedOptionsPanel implements ITitled {
    private static final JComboBox<String> LAUNCHER_LANGUAGE = new JComboBox<String>(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JComboBox<String> LAUNCHER_LOGGINGLEVEL = new JComboBox<String>(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JComboBox<String> LAUNCHER_SERVER = new JComboBox<String>(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JCheckBox LAUNCHER_ADVBACKUP = new JCheckBox(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JCheckBox LAUNCHER_SORTPACKSALPHABETICALLY = new JCheckBox(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JCheckBox LAUNCHER_KEEPOPEN = new JCheckBox(){
        {
            this.setPreferredSize(new Dimension(125, 25));
        }
    };
    private static final JComponent[] COMPS = new JComponent[]{
            LAUNCHER_LANGUAGE, LAUNCHER_LOGGINGLEVEL, LAUNCHER_SERVER,
            LAUNCHER_ADVBACKUP, LAUNCHER_SORTPACKSALPHABETICALLY, LAUNCHER_KEEPOPEN
    };
    private static String[] NAMES = new String[]{
            "Language: ", "Logging Level: ", "Server: ",
            "Advanced Backup: ", "Sort Packs Alphabetically: ", "Keep Open: "
    };

    public SettingsPage2(){
        super(COMPS, NAMES);
    }

    @Override
    public String getTitle(){
        return "Launcher Settings";
    }
}
package com.atlauncher.gui.panel.settings;

import com.atlauncher.gui.comp.ITitled;

import javax.swing.*;
import java.awt.*;

public final class SettingsPage3 extends JPanel implements ITitled {
    public SettingsPage3(){
        super(new FlowLayout());
    }

    @Override
    public String getTitle(){
        return "Minecraft & Forge Settings";
    }
}

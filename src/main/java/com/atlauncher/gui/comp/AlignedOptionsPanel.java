package com.atlauncher.gui.comp;

import javax.swing.*;
import java.awt.*;

public class AlignedOptionsPanel extends JPanel {
    private final JComponent[] COMPS;
    private final GridBagConstraints gbc = new GridBagConstraints();

    public AlignedOptionsPanel(JComponent[] comps){
        super(new GridBagLayout());
        this.COMPS = comps;
        this.addComponents(null);
    }

    public AlignedOptionsPanel(JComponent[] comps, String[] labels){
        super(new GridBagLayout());
        this.COMPS = comps;
        this.addComponents(labels);
    }

    private void addComponents(String[] labels){
        if(labels != null && !(labels.length >= this.COMPS.length)){
            throw new RuntimeException("Labels array cannot be smaller than the component array");
        }

        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.insets.set(2, 2, 2, 2);
        this.gbc.fill = GridBagConstraints.WEST;
        for(int i = 0; i < this.COMPS.length; i++){
            if(!(labels == null) || labels.length > 0){
                this.add(new JLabel(labels[i]), this.gbc);
            }

            this.gbc.gridx++;
            this.add(this.COMPS[i], this.gbc);
            this.gbc.gridx--;

            this.gbc.gridy++;
        }
    }
}
package com.atlauncher.gui.panel;

import com.atlauncher.acc.Account;

import javax.swing.*;
import java.awt.*;

public final class MainAccountPanel extends JPanel{
	private static final long serialVersionUID = -5156406510937026294L;
	

	private final JLabel SKIN_LABEL = new JLabel(new Account("Asyncronos").getMinecraftSkin()){
		private static final long serialVersionUID = 968714502738396783L;

		{
			this.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
		}
	};
	
	public MainAccountPanel(){
		super(new BorderLayout());

        this.add(this.SKIN_LABEL, BorderLayout.CENTER);
	}
}
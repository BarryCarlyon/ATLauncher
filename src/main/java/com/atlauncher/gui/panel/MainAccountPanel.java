package com.atlauncher.gui.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public final class MainAccountPanel extends JPanel{
	private static final long serialVersionUID = -5156406510937026294L;
	
	/*
	private final JLabel SKIN_LABEL = new JLabel(new Account("Asyncronos").getMinecraftSkin()){
		private static final long serialVersionUID = 968714502738396783L;

		{
			this.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
		}
	};*/
	
	public MainAccountPanel(){
		super(new BorderLayout());
	}
}
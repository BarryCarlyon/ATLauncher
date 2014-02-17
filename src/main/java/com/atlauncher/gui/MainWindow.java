package com.atlauncher.gui;

import com.atlauncher.ATLauncher;
import com.atlauncher.gui.panel.*;

import javax.swing.*;
import java.awt.*;

public final class MainWindow extends JFrame{
	private static final long serialVersionUID = 2028814758202459002L;
	
	private final JTabbedPane TABS = new JTabbedPane(JTabbedPane.RIGHT){
		private static final long serialVersionUID = 1L;
		
		{
			this.setFont(ATLauncher.loadFont("Oswald-Regular").deriveFont(34.0F));
			this.addTab("News", new MainNewsPanel());
			this.addTab("Packs", new MainPacksPanel());
			this.addTab("Instances", new MainInstancesPanel());
			this.addTab("Account", new MainAccountPanel());
			this.addTab("Settings", new MainSettingsPanel());
			this.setBackground(ATLauncher.BASE_COLOR.brighter());
			this.setOpaque(true);
		}
	};
    private final MainBottomPanel BOTTOM_PANEL = new MainBottomPanel();

	public MainWindow(){
		super("ATLauncher");
		this.setMinimumSize(new Dimension(1000, 575));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.TABS, BorderLayout.CENTER);
		this.add(this.BOTTOM_PANEL, BorderLayout.SOUTH);
		this.setIconImage(ATLauncher.loadIcon("main").getImage());
	}
}
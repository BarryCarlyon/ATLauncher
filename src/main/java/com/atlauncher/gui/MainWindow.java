package com.atlauncher.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.atlauncher.ATLauncher;
import com.atlauncher.gui.panel.MainAccountPanel;
import com.atlauncher.gui.panel.MainBottomPanel;
import com.atlauncher.gui.panel.MainInstancesPanel;
import com.atlauncher.gui.panel.MainNewsPanel;
import com.atlauncher.gui.panel.MainPacksPanel;
import com.atlauncher.gui.panel.MainSettingsPanel;

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

	public MainWindow(){
		super("ATLauncher");
		this.setMinimumSize(new Dimension(1000, 575));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.TABS, BorderLayout.CENTER);
		this.add(new MainBottomPanel(), BorderLayout.SOUTH);
	}
}
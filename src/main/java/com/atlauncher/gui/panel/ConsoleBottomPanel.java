package com.atlauncher.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.atlauncher.ATLauncher;

public final class ConsoleBottomPanel extends JPanel{
	private final class ActionsPanel extends JPanel{
		private static final long serialVersionUID = -6082512531655983226L;
		
		private final JButton CLEAR_BUTTON = new JButton("Clear"){
			private static final long serialVersionUID = 2602438939768462715L;
			
			{
				this.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent event){
						ATLauncher.CONSOLE.clear();
						ATLauncher.LOGGER.info("Console Cleared");
					}
				});
			}
		};
		private final JButton COPYLOG_BUTTON = new JButton("Copy Log"){
			private static final long serialVersionUID = -9032881226876225310L;
			
		};
		private final JButton UPLOADLOG_BUTTON = new JButton("Upload Log"){
			private static final long serialVersionUID = 3738666791738708847L;
		};
		private final JButton KILLMC_BUTTON = new JButton("Kill Minecraft"){
			private static final long serialVersionUID = -2014863685405801014L;
			
			{
				this.setVisible(false);
			}
		};
		private final JButton[] BUTTONS = new JButton[]{
			this.CLEAR_BUTTON, this.COPYLOG_BUTTON, this.UPLOADLOG_BUTTON,
			this.KILLMC_BUTTON
		};
		
		protected ActionsPanel(){
			super(new GridBagLayout());
			this.setMinimumSize(new Dimension(0, 50));
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.insets.set(0, 5, 0, 0);
			
			for(int i = 0; i < this.BUTTONS.length; i++){
				this.add(this.BUTTONS[i], gbc);
				gbc.gridx++;
			}
		}
	}
	
	private static final long serialVersionUID = 1470596896288846996L;
	
	private final SocialButtonsPanel SOCIAL_PANEL = new SocialButtonsPanel();
	private final ActionsPanel ACTIONS_PANEL = new ActionsPanel();
	
	public ConsoleBottomPanel(){
		super(new BorderLayout());
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setMinimumSize(new Dimension(0, 50));
		this.add(this.ACTIONS_PANEL, BorderLayout.WEST);
		this.add(this.SOCIAL_PANEL, BorderLayout.EAST);
	}
}
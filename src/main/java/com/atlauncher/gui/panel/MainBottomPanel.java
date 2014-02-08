package com.atlauncher.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.atlauncher.ATLauncher;
import com.atlauncher.gui.comp.AccountComboBox;

public final class MainBottomPanel extends JPanel{
	private static final long serialVersionUID = 7272200927419278735L;
	
	private final class ActionsPanel extends JPanel{
		private static final long serialVersionUID = -9134018565955990090L;
		
		private final JButton TC_BUTTON = new JButton(String.format("%s Console", (ATLauncher.CONSOLE.isVisible() ? "Hide" : "Show"))){
			private static final long serialVersionUID = 3695287462704228197L;
			
		};
		private final JButton OF_BUTTON = new JButton("Open Folder"){
			private static final long serialVersionUID = 2497003804235539535L;
			
		};
		private final JButton UPDATE_BUTTON = new JButton("Update Launcher"){
			private static final long serialVersionUID = -1382867013579028964L;
			
		};
		
		private final JButton[] BUTTONS = new JButton[]{
				this.TC_BUTTON, this.OF_BUTTON, this.UPDATE_BUTTON
		};
		
		protected ActionsPanel(){
			super(new GridBagLayout());
			this.setMinimumSize(new Dimension(0, 50));
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.insets.set(0, 0, 0, 5);
			for(int i = 0; i < this.BUTTONS.length; i++){
				this.add(this.BUTTONS[i], gbc);
				gbc.gridx++;
			}
		}
	}
	
	private final class AccountPanel extends JPanel{
		private static final long serialVersionUID = 9098631548658827529L;
		
		private final AccountComboBox ACCOUNTS = new AccountComboBox();
		
		protected AccountPanel(){
			super(new GridBagLayout());
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.insets.set(0, 0, 0, 5);
			this.add(this.ACCOUNTS, gbc);
			gbc.gridx++;
		}
	}
	
	private final ActionsPanel ACTIONS_PANEL = new ActionsPanel();
	private final AccountPanel ACCOUNT_PANEL = new AccountPanel();
	private final SocialButtonsPanel SOCIAL_PANEL = new SocialButtonsPanel();
	
	public MainBottomPanel(){
		super(new BorderLayout());
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setMinimumSize(new Dimension(0, 50));
		this.add(this.ACTIONS_PANEL, BorderLayout.WEST);
		this.add(this.ACCOUNT_PANEL, BorderLayout.CENTER);
		this.add(this.SOCIAL_PANEL, BorderLayout.EAST);
	}
}
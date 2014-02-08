package com.atlauncher.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public final class MainBottomPanel extends JPanel{
	private static final long serialVersionUID = 7272200927419278735L;
	
	private final class ActionsPanel extends JPanel{
		private static final long serialVersionUID = -9134018565955990090L;
		
	}
	
	private final class AccountPanel extends JPanel{
		private static final long serialVersionUID = 9098631548658827529L;
		
	}
	
	private final ActionsPanel ACTIONS_PANEL = new ActionsPanel();
	private final AccountPanel ACCOUNT_PANEL = new AccountPanel();
	private final SocialButtonsPanel SOCIAL_PANEL = new SocialButtonsPanel();
	
	public MainBottomPanel(){
		super();
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setMinimumSize(new Dimension(0, 50));
		this.add(this.ACTIONS_PANEL, BorderLayout.WEST);
		this.add(this.ACCOUNT_PANEL, BorderLayout.CENTER);
		this.add(this.SOCIAL_PANEL, BorderLayout.EAST);
	}
}
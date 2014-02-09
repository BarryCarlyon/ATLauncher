package com.atlauncher.gui.comp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.atlauncher.ATLauncher;

public final class SocialButton extends JButton{
	private static final long serialVersionUID = 4813887195241738519L;
	
	public SocialButton(String icon){
		super(ATLauncher.loadIcon("social/" + icon));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setCursor(ATLauncher.HAND);
	}
	
	public SocialButton(String icon, String tooltip, String url){
		this(icon);
		this.setToolTipText(tooltip);
		this.setActionCommand(url);
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				ATLauncher.openWebsite(event.getActionCommand());
			}
		});
	}
}
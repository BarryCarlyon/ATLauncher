package com.atlauncher.gui.comp;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.atlauncher.ATLauncher;

public class IconLabel extends JLabel{
	private static final long serialVersionUID = -3778640459539396887L;
	
	public IconLabel(String ico){
		super(ATLauncher.loadIcon(ico));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
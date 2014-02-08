package com.atlauncher.gui.comp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;

import javax.swing.border.LineBorder;

public final class CustomLineBorder extends LineBorder{
	private static final long serialVersionUID = 3709030002964072930L;
	
	private final int insets;
	
	public CustomLineBorder(int insets, Color c){
		super(c);
		this.insets = insets;
	}
	
	public CustomLineBorder(int insets, Color c, int thick){
		super(c, thick);
		this.insets = insets;
	}
	
	public CustomLineBorder(int insets, Color c, int thick, boolean round){
		super(c, thick, round);
		this.insets = insets;
	}
	
	@Override
	public Insets getBorderInsets(Component c, Insets insets){
		return new Insets(this.insets, this.insets, this.insets, this.insets);
	}
}
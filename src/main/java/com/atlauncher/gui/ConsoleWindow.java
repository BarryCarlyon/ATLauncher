package com.atlauncher.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import org.apache.log4j.Level;

import com.atlauncher.gui.panel.ConsoleBottomPanel;
import com.atlauncher.gui.panel.ConsoleOutputPanel;

public final class ConsoleWindow extends JFrame{
	private static final long serialVersionUID = -9121377368514427025L;
	
	private final ConsoleOutputPanel CONSOLE = new ConsoleOutputPanel();
	private final ConsoleBottomPanel BOTTOM = new ConsoleBottomPanel();
	
	public ConsoleWindow(){
		super("ATLauncher Console");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setMinimumSize(new Dimension(600, 400));
		this.setLayout(new BorderLayout());
		this.add(this.CONSOLE, BorderLayout.CENTER);
		this.add(this.BOTTOM, BorderLayout.SOUTH);
	}
	
	public void log(String message, Level level){
		this.CONSOLE.log(message, level);
	}
	
	public void clear(){
		this.CONSOLE.clear();
	}
}
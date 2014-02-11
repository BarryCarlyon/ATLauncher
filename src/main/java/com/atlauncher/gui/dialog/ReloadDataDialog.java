package com.atlauncher.gui.dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class ReloadDataDialog extends JDialog{
	private static final long serialVersionUID = -1913066908452462934L;
	
	public ReloadDataDialog(JFrame parent){
		super(parent, ModalityType.APPLICATION_MODAL);
		this.setSize(new Dimension(300, 100));
		this.setTitle("Updating Launcher");
		this.setLocationRelativeTo(parent);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.add(new JLabel("Please Wait"));
		this.setVisible(true);
	}
}
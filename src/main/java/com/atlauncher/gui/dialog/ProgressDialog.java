package com.atlauncher.gui.dialog;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.atlauncher.ATLauncher;

public final class ProgressDialog extends JDialog{
	private static final long serialVersionUID = -1761192755686461909L;

	private final JLabel label;
	private final JProgressBar PROGRESS_BAR = new JProgressBar();
	
	public ProgressDialog(JFrame parent, String title, int max, String label, final String cLogMessage){
		super(parent, ModalityType.APPLICATION_MODAL);
		this.setIconImage(ATLauncher.loadIcon("main").getImage());
		this.setTitle(title);
		this.setLocationRelativeTo(parent);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		this.label = new JLabel(label, JLabel.CENTER);
		
		if(max <= 0){
			this.PROGRESS_BAR.setIndeterminate(true);
		}
		
		this.add(this.label, BorderLayout.CENTER);
		this.add(this.PROGRESS_BAR, BorderLayout.SOUTH);
		
		if(cLogMessage != null){
			this.addWindowListener(new WindowAdapter(){
				@Override
				public void windowClosing(WindowEvent event){
					ATLauncher.LOGGER.error(cLogMessage);
					
					ProgressDialog.this.dispose();
				}
			});
		}
		
		this.pack();
	}
}
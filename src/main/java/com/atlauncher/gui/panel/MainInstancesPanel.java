package com.atlauncher.gui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public final class MainInstancesPanel extends JPanel{
	private static final long serialVersionUID = 3195242689294165816L;
	
	private final class ActionsPanel extends JPanel{
		private static final long serialVersionUID = 6695118359023818039L;
		
		private final JButton CLEAR_BUTTON = new JButton("Clear"){
			private static final long serialVersionUID = 1264877429041019367L;

			{
				this.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent event){
						ActionsPanel.this.SEARCH_FIELD.setText("");
					}
				});
			}
		};
		private final JButton SEARCH_BUTTON = new JButton("Search"){
			private static final long serialVersionUID = -6098003733882544183L;

			{
				this.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent event){
						
					}
				});
			}
		};
		private final JTextField SEARCH_FIELD = new JTextField(16){
			private static final long serialVersionUID = 1804091870843623343L;
			
			{
				
			}
		};
		private final JCheckBox HAS_UPDATE = new JCheckBox(){
			private static final long serialVersionUID = 5348195721979242162L;

			{
				this.setSelected(false);
				this.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent event){
						
					}
				});
			}
		};
		
		protected ActionsPanel(){
			super(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder());
			this.add(this.CLEAR_BUTTON);
			this.add(this.SEARCH_FIELD);
			this.add(this.SEARCH_BUTTON);
			this.add(new JLabel("Has Update: "));
			this.add(this.HAS_UPDATE);
		}
	}
	
	private final class CenterPanel extends JPanel{
		private static final long serialVersionUID = -7514371970095434934L;

		public CenterPanel(){
			super(new GridBagLayout());
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
		}
	}
	
	private final ActionsPanel ACTIONS_PANEL = new ActionsPanel();
	private final CenterPanel CENTER_PANEL = new CenterPanel();
	
	public MainInstancesPanel(){
		super(new BorderLayout());
		this.add(this.ACTIONS_PANEL, BorderLayout.NORTH);
		this.add(new JScrollPane(this.CENTER_PANEL, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
	}
}

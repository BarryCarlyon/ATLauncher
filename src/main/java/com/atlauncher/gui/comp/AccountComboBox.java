package com.atlauncher.gui.comp;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.atlauncher.acc.Account;

public class AccountComboBox extends JComboBox<Account>{
	private static final long serialVersionUID = 7130333592637120035L;
	
	private final class DropdownRenderer extends JLabel implements ListCellRenderer<Account>{
		private static final long serialVersionUID = 6995592263256411142L;

		protected DropdownRenderer(){
			this.setOpaque(true);
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setVerticalAlignment(JLabel.CENTER);
			this.setMinimumSize(new Dimension(200, 40));
			this.setIconTextGap(10);
		}
		
		@Override
		public Component getListCellRendererComponent(JList<? extends Account> accounts, Account acc, int index, boolean isSelected, boolean hasFocus){
			if(acc != null){
				if(isSelected){
					this.setBackground(accounts.getSelectionBackground());
					this.setForeground(accounts.getSelectionForeground());
				} else{
					this.setBackground(accounts.getBackground());
					this.setForeground(accounts.getForeground());
				}
				
				this.setText(acc.getName());
				this.setFont(accounts.getFont());
			}
			
			return this;
		}
	}
	
	public AccountComboBox(){
		super();
		this.setRenderer(new DropdownRenderer());
		this.addItem(Account.getFiller());
	}
}
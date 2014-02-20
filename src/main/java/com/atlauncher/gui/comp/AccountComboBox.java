package com.atlauncher.gui.comp;

import com.atlauncher.acc.Account;
import com.atlauncher.acc.Accounts;

import javax.swing.*;
import java.awt.*;

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

                ImageIcon ico = acc.getMinecraftHead();
				this.setText(acc.getName());
				this.setFont(accounts.getFont());

                if(ico == null){
                    return this;
                }
			}
			
			return this;
		}
	}
	
	public AccountComboBox(){
		super();
		this.setRenderer(new DropdownRenderer());
		this.addItem(Account.getFiller());

        for(Account acc : Accounts.getInstance().getAccounts()){
            this.addItem(acc);
        }
	}
}
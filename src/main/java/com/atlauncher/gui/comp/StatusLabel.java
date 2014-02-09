package com.atlauncher.gui.comp;

import java.awt.Color;

import javax.swing.JToolTip;

import com.atlauncher.ATLauncher;

public final class StatusLabel extends IconLabel{
	private static final long serialVersionUID = 6311078928948035482L;

	public static final int STATUS_CHECKING = 0x0;
	public static final int STATUS_ONLINE = 0x1;
	public static final int STATUS_OFFLINE = 0x2;
	public static final int STATUS_PARTIAL = 0x3;
	public static final int STATUS_UNKOWN = StatusLabel.STATUS_CHECKING;
	
	public StatusLabel(int status){
		super("status/" + getIcon(status));
	}
	
	public StatusLabel(){
		this(STATUS_CHECKING);
	}
	
	@Override
	public JToolTip createToolTip(){
		JToolTip tip = super.createToolTip();
		tip.setBorder(new CustomLineBorder(5, new Color(80, 170, 107), 2));
		return tip;
	}
	
	private static String getIcon(int status){
		switch(status)
		{
			case STATUS_CHECKING:{
				return "white";
			}
			case STATUS_ONLINE:{
				return "green";
			}
			case STATUS_OFFLINE:{
				return "red";
			}
			case STATUS_PARTIAL:{
				return "yellow";
			}
			default:{
				throw new IllegalStateException("Unkown Status State: " + status);
			}
		}
	}
	
	private static String getStatus(int status){
		switch(status)
		{
			case STATUS_CHECKING:{
				return "Checking";
			}
			case STATUS_ONLINE:{
				return "Online";
			}
			case STATUS_OFFLINE:{
				return "Offline";
			}
			case STATUS_PARTIAL:{
				return "Partially Online";
			}
			default:{
				throw new IllegalStateException("Unkown Status State: " + status);
			}
		}
	}
	
	public static void updateStatus(StatusLabel label, int status){
		label.setToolTipText("Status: " + StatusLabel.getStatus(status));
		label.setIcon(ATLauncher.loadIcon("status/" + StatusLabel.getIcon(status)));
	}
}
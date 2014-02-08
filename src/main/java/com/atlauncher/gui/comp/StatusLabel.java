package com.atlauncher.gui.comp;

public class StatusLabel extends IconLabel{
	private static final long serialVersionUID = 6311078928948035482L;

	public static final int STATUS_CHECKING = 0x0;
	public static final int STATUS_ONLINE = 0x1;
	public static final int STATUS_OFFLINE = 0x2;
	public static final int STATUS_PARTIAL = 0x3;
	public static final int STATUS_UNKOWN = StatusLabel.STATUS_CHECKING;
	
	public StatusLabel(int status){
		super("/status/" + getIcon(status));
	}
	public StatusLabel(){
		this(STATUS_CHECKING);
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
}
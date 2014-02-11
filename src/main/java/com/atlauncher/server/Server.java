package com.atlauncher.server;

public final class Server{
	private final String name;
	private final String url;
	private final boolean userSelect;
	private boolean enabled = false;
	
	public Server(String name, String url, boolean userSelect){
		this.name = name;
		this.url = url;
		this.userSelect = userSelect;
	}
	
	public Server enable(){
		this.enabled = true;
		return this;
	}
	
	public Server disable(){
		this.enabled = false;
		return this;
	}
	
	public boolean isUserSelectable(){
		return this.userSelect;
	}
	
	public boolean isDisabled(){
		return !this.enabled;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getFileURL(String fileName){
		return String.format("http://%s/%s", this.url, fileName);
	}
	
	@Override
	public String toString(){
		return (!(this.enabled) ? "(X)" : "") + this.name;  
	}
}
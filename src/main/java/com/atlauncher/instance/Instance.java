package com.atlauncher.instance;

import java.io.Serializable;

public final class Instance implements Serializable{
	private static final long serialVersionUID = 9128044339829476613L;
	
	private final String name;
	private final String version;
	private final String mcVersion;
	
	public Instance(String name, String mcVersion, String version){
		this.name = name;
		this.mcVersion = mcVersion;
		this.version = version;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getVersion(){
		return this.version;
	}
	
	public String getMCVersion(){
		return this.mcVersion;
	}
}
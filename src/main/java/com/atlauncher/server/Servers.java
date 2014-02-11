package com.atlauncher.server;

import java.util.LinkedList;
import java.util.List;

public final class Servers{
	private static Servers instance;
	
	private final List<Server> servers = new LinkedList<>();
	
	private Server CURRENT_SERVER;
	
	private Servers(){}
	
	public static Servers getInstance(){
		if(instance == null){
			instance = new Servers();
		}
		
		return instance;
	}
	
	public static Server getCurrentWorkingServer(){
		if(getInstance().CURRENT_SERVER != null){
			return getInstance().CURRENT_SERVER;
		} else{
			throw new IllegalStateException("A working server cannot be found");
		}
	}

	public static List<Server> getServers() {
		return getInstance().servers;
	}
}
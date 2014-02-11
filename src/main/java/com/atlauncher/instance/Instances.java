package com.atlauncher.instance;

import java.util.LinkedList;
import java.util.List;

public final class Instances{
	private final List<Instance> instances = new LinkedList<>();
	
	private static Instances instance;
	
	public static Instances getInstance(){
		if(instance == null){
			instance = new Instances();
		}
		
		return instance;
	}
}
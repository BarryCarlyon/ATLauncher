package com.atlauncher.news;

import com.atlauncher.ATLauncher;

public final class News{
	private News(){}
	
	public static void getAll(){
		try{
			
		} catch(Exception ex){
			ATLauncher.LOGGER.error("Cannot load news", ex);
		}
	}
	
	private static void loadFromServer(){
		
	}
	
	private static void loadFromCache(){
		
	}
}
package com.atlauncher.dl;

import java.net.HttpURLConnection;
import java.net.URL;

import com.atlauncher.ATLauncher;

public final class Downloadable{
	private final String url;
	private HttpURLConnection connection;
	
	public Downloadable(){
		this.url = null;
	}
	
	private HttpURLConnection getConnection(){
		if(this.connection != null){
			return this.connection;
		} else{
			try{
				this.connection = (HttpURLConnection) new URL(this.url).openConnection();
				this.connection.setUseCaches(false);
				this.connection.setDefaultUseCaches(false);
				this.connection.setConnectTimeout(5000);
				this.connection.setRequestProperty("Accept-Encoding", "gzip");
			} catch(Exception ex){
				ATLauncher.LOGGER.error("Cannot get file connection", ex);
				throw new RuntimeException(ex);
			}
		}
		
		return this.connection;
	}
}
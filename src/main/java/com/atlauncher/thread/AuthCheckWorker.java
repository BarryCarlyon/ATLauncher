package com.atlauncher.thread;

import java.net.HttpURLConnection;

import javax.swing.SwingWorker;

import com.atlauncher.ATLauncher;

public class AuthCheckWorker extends SwingWorker<Boolean, Void>{
	@Override
	protected Boolean doInBackground() throws Exception {
		boolean valid = true;
		
		ATLauncher.LOGGER.info("Checking AuthKey");
		if(ATLauncher.AUTH_KEY == null || ATLauncher.AUTH_KEY.isEmpty()){
			ATLauncher.LOGGER.error("Empty AuthKey");
			return false;
		} else{
			HttpURLConnection connection = ATLauncher.encodeBasicConnection();
			connection.setRequestProperty("Auth-Key", ATLauncher.AUTH_KEY);
			connection.setRequestProperty("Cache-Control", "no-store,max-age=0,no-cache");
			connection.setRequestProperty("Expires", "0");
			connection.setRequestProperty("Pragma", "no-cache");
			connection.connect();
			
			if(connection.getResponseCode() == 401){
				ATLauncher.LOGGER.error("Invalid AuthKey");
				return false;
			}
		}
		
		return valid;
	}
}
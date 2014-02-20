package com.atlauncher.thread;

import com.atlauncher.ATLauncher;
import com.atlauncher.acc.Account;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public final class SkinCachingThread extends SwingWorker<Void, Void>{
	private final Account acc;
	
	public SkinCachingThread(Account acc){
		this.acc = acc;
	}
	
	@Override
	protected Void doInBackground()
	throws Exception{
        if(this.acc == Account.getFiller()){
            return null;
        }

		File file = new File(ATLauncher.SKINS, this.acc.getName() + ".png");
		
		if(file.exists()){
			file.delete();
		}
		
		ATLauncher.LOGGER.info("Download skin for " + this.acc.getName());
		
		URL skinURL = new URL(String.format("http://s3.amazonaws.com/MinecraftSkins/%s.png", this.acc.getName()));
		
		if(((HttpURLConnection) skinURL.openConnection()).getResponseCode() == 200){
			ReadableByteChannel channel = Channels.newChannel(skinURL.openStream());
			try(FileOutputStream stream = new FileOutputStream(file)){
				stream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
			}
		} else{
            throw new RuntimeException("Unexpected Response Code: " + ((HttpURLConnection) skinURL.openConnection()).getResponseCode());
        }

        return null;
	}
}
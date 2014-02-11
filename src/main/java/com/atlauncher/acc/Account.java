package com.atlauncher.acc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import com.atlauncher.ATLauncher;
import com.atlauncher.thread.SkinCachingThread;

@SuppressWarnings("deprecation")
public final class Account implements Comparable<Account>, Cloneable, Serializable{
	private static final long serialVersionUID = -7495549305510416500L;
	
	private final String name;
	
	public Account(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Account){
			return ((Account) obj).name.equals(this.name);
		} else if(obj instanceof String){
			return ((String) obj).equals(this.name);
		} else{
			return false;
		}
	}
	
	@Deprecated
	public ImageIcon getMinecraftHead(){
		try{
			File file = new File(ATLauncher.SKINS, this.name + ".png");
			
			if(!file.exists()){
				SwingWorker<Boolean, Void> cacher = new SkinCachingThread(this);
				cacher.execute();
				return this.getMinecraftHead();
			}
			
			BufferedImage skin = ImageIO.read(file);
			BufferedImage main = skin.getSubimage(8, 8, 8, 8);
			BufferedImage helm = skin.getSubimage(40, 8, 8, 8);
			BufferedImage head = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);
			
			int raster = 0;
			for(int x = 0; x < 8; x++){
				for(int y = 0; y < 8; y++){
					if(helm.getRGB(x, y) == -1){
						raster++;
					}
				}
			}
			
			Graphics g = head.getGraphics();
			g.drawImage(main, 0, 0, null);
			
			if(raster <= 32){
				g.drawImage(helm, 0, 0, null);
			}
			
			return new ImageIcon(head.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
		} catch(Exception ex){
			ATLauncher.LOGGER.error("Cannot read skin data", ex);
			return null;
		}
	}
	
	@Deprecated
	public ImageIcon getMinecraftSkin(){
		try{
			File file = new File(ATLauncher.SKINS, this.name + ".png");
			
			if(!file.exists()){
				SwingWorker<Boolean, Void> cacher = new SkinCachingThread(this);
				cacher.execute();
				return this.getMinecraftSkin();
			}
			
			BufferedImage skin = ImageIO.read(file);
			BufferedImage head = skin.getSubimage(8, 8, 8, 8);
			BufferedImage helm = skin.getSubimage(40, 8, 8, 8);
			BufferedImage arm = skin.getSubimage(44, 20, 4, 12);
			BufferedImage body = skin.getSubimage(40, 20, 8, 12);
			BufferedImage leg = skin.getSubimage(4, 20, 4, 12);
			BufferedImage stichedSkin = new BufferedImage(16, 32, BufferedImage.TYPE_INT_ARGB);
			
			int c = 0;
			for(int x = 0; x < 8; x++){
				for(int y = 0; y < 8; y++){
					if(helm.getRGB(x, y) == -1){
						c++;
					}
				}
			}
			
			Graphics g = stichedSkin.getGraphics();
			g.drawImage(head, 4, 0, null);
			
			if(c <= 32){
				g.drawImage(helm, 4, 0, null);
			}
			
			g.drawImage(arm, 0, 8, null);
			g.drawImage(arm, 12, 8, null);
			g.drawImage(body, 4, 8, null);
			g.drawImage(leg, 4, 20, null);
			g.drawImage(leg, 8, 20, null);
			
			return new ImageIcon(stichedSkin.getScaledInstance(128, 256, Image.SCALE_SMOOTH));
		} catch(Exception ex){
			ATLauncher.LOGGER.error("Cannot load skin data", ex);
			return null;
		}
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	public static Account getFiller(){
		return new Account("Select an Account");
	}

	@Override
	public int compareTo(Account acc){
		return acc.name.compareTo(this.name);
	}
}
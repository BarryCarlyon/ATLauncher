package com.atlauncher.acc;

import com.atlauncher.ATLauncher;
import com.atlauncher.thread.SkinCachingThread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;

@SuppressWarnings("deprecation")
public final class Account implements Comparable<Account>, Cloneable, Serializable{
	private static final long serialVersionUID = -7495549305510416500L;
	
	private final String name;
	private final transient File SKIN;
    private final boolean isDummy;

	public Account(String name){
		this.name = name;
        this.isDummy = name.equalsIgnoreCase("Select an Account");
        this.SKIN = new File(ATLauncher.SKINS, this.name + ".png");
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
	
	public ImageIcon getMinecraftHead(){
		try{
            if(this.isDummy){
                return null;
            }

            if(!this.SKIN.exists()){
                this.updateData();
            }

			BufferedImage skin = ImageIO.read(this.SKIN);
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
			ATLauncher.LOGGER.error("Cannot read skin data @acc: " + this.getName(), ex);
			throw new RuntimeException(ex);
		}
	}

    private void updateData(){
        ATLauncher.LOGGER.info("Updating Account Data for " + this.getName());

        new SkinCachingThread(this).execute();
    }
	
	public ImageIcon getMinecraftSkin(){
		try{
            if(this.isDummy){
                return null;
            }

            if(!this.SKIN.exists()){
                this.updateData();
            }
			
			BufferedImage skin = ImageIO.read(this.SKIN);
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
			ATLauncher.LOGGER.error("Cannot load skin data @account: " + this.getName(), ex);
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
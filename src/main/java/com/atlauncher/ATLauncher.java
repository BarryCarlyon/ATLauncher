package com.atlauncher;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.atlauncher.gui.ConsoleWindow;
import com.atlauncher.gui.MainWindow;

public final class ATLauncher{	
	public static Color BASE_COLOR = new Color(40, 45, 50);
	public static final Logger LOGGER = LogManager.getLogger(ATLauncher.class);
	
	public static final Cursor HAND = new Cursor(Cursor.HAND_CURSOR);
	
	public static final ConsoleWindow CONSOLE = new ConsoleWindow();
	public static final MainWindow MAIN = new MainWindow();
	
	static
	{
		setLAF();
		modifyLAF();
		updateClient();
	}
	
	public static void main(String... args)
	throws Exception{
		ATLauncher.LOGGER.info("Starting Client");
		startClient();
	}
	
	private static void startClient(){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				ATLauncher.CONSOLE.setVisible(true);
				ATLauncher.MAIN.setVisible(true);
			}
		});
	}
	
	public static void updateClient(){
		ATLauncher.LOGGER.info("Updating Client");
		SwingUtilities.updateComponentTreeUI(ATLauncher.CONSOLE);
		SwingUtilities.updateComponentTreeUI(ATLauncher.MAIN);
	}
	
	public static Font loadFont(String name){
		try{
			Font f = Font.createFont(Font.TRUETYPE_FONT, ATLauncher.class.getResourceAsStream("/fonts/" + name + ".ttf"));
			
			if(f == null){
				throw new NullPointerException("Cannot find font: " + name);
			}
			
			return f;
		} catch(Exception ex){
			ATLauncher.LOGGER.trace(ex.getMessage(), ex);
			ex.printStackTrace(System.out);
			return null;
		}
	}
	
	public static ImageIcon loadIcon(String name){
		try{
			return new ImageIcon(ATLauncher.class.getResource("/icons/" + name + ".png"));
		} catch(Exception ex){
			ATLauncher.LOGGER.trace(ex.getMessage(), ex);
			ex.printStackTrace(System.out);
			return null;
		}
	}
	
	private static void setLAF(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			ATLauncher.LOGGER.info("Setting LookAndFeel to com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception ex){
			ex.printStackTrace(System.out);
			ATLauncher.LOGGER.trace(ex.getMessage(), ex);
		}
	}
	
	private static void modifyLAF(){
		try{
			ATLauncher.LOGGER.info("Modifying the LookAndFeel");
			
			UIManager.put("control", ATLauncher.BASE_COLOR);
			UIManager.put("text", Color.WHITE);
			UIManager.put("nimbusBase", Color.BLACK);
			UIManager.put("nimbusFocus", ATLauncher.BASE_COLOR);
			UIManager.put("nimbusBorder", ATLauncher.BASE_COLOR);
			UIManager.put("nimbusLightBackground", ATLauncher.BASE_COLOR);
			UIManager.put("info", ATLauncher.BASE_COLOR);
			UIManager.put("nimbusSelectionBackground", new Color(100, 100, 200));
			UIManager.put("Table.focusCellHighlightBorder", BorderFactory.createEmptyBorder(2, 5, 2, 5));
		} catch(Exception ex){
			ex.printStackTrace(System.out);
			ATLauncher.LOGGER.trace(ex.getMessage(), ex);
		}
	}
}
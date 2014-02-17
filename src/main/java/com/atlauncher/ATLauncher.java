package com.atlauncher;

import com.atlauncher.gui.ConsoleWindow;
import com.atlauncher.gui.MainWindow;
import com.atlauncher.server.Servers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public final class ATLauncher{
	public static final File HOME = new File(System.getProperty("user.home"));
	public static final File ROOT = new File(HOME, ".atlauncher");
	public static final File INSTANCES = new File(ROOT, "Instances");
	public static final File DOWNLOADS = new File(ROOT, "Downloads");
	public static final File CACHE = new File(ROOT, ".cache");
	public static final File SKINS = new File(CACHE, "skins");
	public static final Color BASE_COLOR = new Color(40, 45, 50);
	public static final Logger LOGGER = LogManager.getLogger(ATLauncher.class);
	public static final Cursor HAND = new Cursor(Cursor.HAND_CURSOR);
	public static final ConsoleWindow CONSOLE = new ConsoleWindow();
	public static final MainWindow MAIN = new MainWindow();
	public static final Properties INTERNAL_SETTINGS = new Properties();
	public static final Properties EXTERNAL_SETTINGS = new Properties();
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	private static final Desktop DESKTOP;

	public static String AUTH_KEY = null;
	
	static
	{
		setLAF();
		modifyLAF();
		updateClient();
		
		if(Desktop.isDesktopSupported()){
			DESKTOP = Desktop.getDesktop();
		} else{
			DESKTOP = null;
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
			@Override
			public void run(){
				File file = new File(ATLauncher.ROOT, "settings.properties");
				
				try {
					ATLauncher.EXTERNAL_SETTINGS.store(new FileOutputStream(file), null);
				} catch (Exception ex){
					throw new RuntimeException(ex);
				}
				
				ATLauncher.LOGGER.info("Shutting Down");
			}
		}));
	}
	
	
	static
	{
		loadSettings_1();
		validateResources();
		loadSettings_2();
	}
	
	public static void main(String... args)
	throws Exception{
		ATLauncher.LOGGER.info("Starting Client");
		startClient();
	}
	
	private static void validateResources(){
		ATLauncher.validateFile(ATLauncher.HOME);
		ATLauncher.validateFile(ATLauncher.ROOT);
		ATLauncher.validateFile(ATLauncher.DOWNLOADS);
		ATLauncher.validateFile(ATLauncher.INSTANCES);
		ATLauncher.validateFile(ATLauncher.CACHE);
		ATLauncher.validateFile(ATLauncher.SKINS);
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
	
	private static void loadSettings_1(){
		try{
			ATLauncher.INTERNAL_SETTINGS.load(ATLauncher.class.getResourceAsStream("/settings/internal.properties"));
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	private static void loadSettings_2(){
		try{
			File settings = new File(ATLauncher.ROOT, "settings.properties");
			
			if(!settings.exists()){
				settings.createNewFile();
			}
			
			ATLauncher.EXTERNAL_SETTINGS.load(new FileInputStream(settings));
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	public static boolean isPortable(){
		return Boolean.valueOf(ATLauncher.INTERNAL_SETTINGS.getProperty("portable"));
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
	
	public static void openWebsite(String url){
		try{
			if(ATLauncher.DESKTOP == null){
				throw new NullPointerException("Cannot open website because desktop bridge cannot be opened");
			}
			
			ATLauncher.DESKTOP.browse(new URL(url).toURI());
		} catch(Exception ex){
			ATLauncher.LOGGER.error(ex.getMessage(), ex);
		}
	}
	
	public static void openFile(File file){
		try{
			if(ATLauncher.DESKTOP == null){
				throw new NullPointerException("Cannot open file because desktop bridge cannot be opened");
			}
			
			ATLauncher.DESKTOP.open(file);
		} catch(Exception ex){
			ATLauncher.LOGGER.error(ex.getMessage(), ex);
		}
	}
	
	public static ImageIcon loadIcon(String name){
		try{
			return new ImageIcon(ATLauncher.class.getResource("/icons/" + name + ".png"));
		} catch(Exception ex){
			ATLauncher.LOGGER.error("Cannot find Icon: /icons/" + name + ".png", ex);
			ex.printStackTrace(System.out);
			return null;
		}
	}
	
	public static void validateFile(File file){
		if(!file.exists()){
			ATLauncher.LOGGER.warn("Cannot find file " + file.getAbsolutePath() + ", creating");
			file.mkdir();
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
	
	public static HttpURLConnection encodeBasicConnection()
	throws Exception{
		HttpURLConnection con = (HttpURLConnection) new URL(Servers.getCurrentWorkingServer().getFileURL("ping")).openConnection();
		con.setUseCaches(false);
		con.setDefaultUseCaches(false);
		con.setConnectTimeout(5000);
		con.setRequestProperty("Accept-Encoding", "gzip");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.72 Safari/537.36");
		return con;
	}
}
package com.atlauncher.appender;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

import com.atlauncher.ATLauncher;

public final class ConsoleAppender extends AppenderSkeleton{
	private final SimpleDateFormat FORMATTER = new SimpleDateFormat("HH:mm:ss");
	
	private final Map<Integer, String> LEVEL_COLOURS = new HashMap<Integer, String>();
	{
		this.addColor("blue", Level.ALL_INT);
		this.addColor("green", Level.OFF_INT);
		this.addColor("purple", Level.TRACE_INT);
		this.addColor("red", Level.ERROR_INT);
		this.addColor("yellow", Level.WARN_INT);
	}
	
	@Override
	public boolean requiresLayout() {
		return true;
	}

	@Override
	protected void append(LoggingEvent event) {
		ATLauncher.CONSOLE.log(String.format("[%s] [%s] %s", this.FORMATTER.format(new Date(event.getTimeStamp())), this.formatColor(event.getLevel().toString(), event.getLevel().toInt()), event.getMessage()), event.getLevel());
	}
	
	private String formatColor(String text, int level){
		return String.format("<font color=%s>%s</font>", (this.LEVEL_COLOURS.containsKey(level) ? this.LEVEL_COLOURS.get(level) : "white"), text);
	}
	
	private void addColor(String color, int level){
		this.LEVEL_COLOURS.put(level, color);
	}
	
	@Override public void close(){}
}
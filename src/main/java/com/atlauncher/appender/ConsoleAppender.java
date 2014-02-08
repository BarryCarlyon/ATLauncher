package com.atlauncher.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import com.atlauncher.ATLauncher;

public final class ConsoleAppender extends AppenderSkeleton{
	@Override
	public boolean requiresLayout() {
		return true;
	}

	@Override
	protected void append(LoggingEvent event) {
		ATLauncher.CONSOLE.log((String) event.getMessage(), event.getLevel());
	}
	
	@Override public void close(){}
}
package com.atlauncher.gui.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import org.apache.log4j.Level;

public final class ConsoleOutputPanel extends JPanel{
	private static final long serialVersionUID = 8898108656471359041L;
	
	private final HTMLDocument HTML_DOC = new HTMLDocument();
	private final HTMLEditorKit HTML_KIT = new HTMLEditorKit();
	private final JEditorPane OUTPUT_PANE = new JEditorPane("text/html", ""){
		private static final long serialVersionUID = 4988159623872469555L;
		
		{
			this.setSelectionColor(Color.GRAY);
			this.setEditorKit(ConsoleOutputPanel.this.HTML_KIT);
			this.setDocument(ConsoleOutputPanel.this.HTML_DOC);
			this.setEditable(false);
		}
		
		@Override
		public boolean getScrollableTracksViewportWidth(){
			return true;
		}
	};
	private final JScrollPane SCROLL_PANE = new JScrollPane(this.OUTPUT_PANE, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public ConsoleOutputPanel(){
		super(new GridLayout(1, 1));
		this.add(this.SCROLL_PANE);
	}
	
	public void log(String message, Level level){
		switch(level.toInt())
		{
			case Level.TRACE_INT:{
				
			}
			case Level.ALL_INT:{
				
			}
			case Level.DEBUG_INT:{
				
			}
			case Level.ERROR_INT:{
				
			}
			case Level.FATAL_INT:{
				
			}
			case Level.INFO_INT:{
				
			}
			case Level.OFF_INT:{
				
			}
			case Level.WARN_INT:{
				
			}
			default:{
				
			}
		}
	}
}
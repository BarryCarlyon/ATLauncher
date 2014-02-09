package com.atlauncher.gui.panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import org.apache.log4j.Level;

import com.atlauncher.ATLauncher;

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
		synchronized(this.HTML_KIT)
		{
			try {
				this.HTML_KIT.insertHTML(this.HTML_DOC, this.HTML_DOC.getLength(), message, 0, 0, null);
				this.OUTPUT_PANE.setCaretPosition(this.HTML_DOC.getLength());
			} catch (Exception ex) {
				ex.printStackTrace(System.out);
				ATLauncher.LOGGER.error(ex.getMessage(), ex);
			}
		}
	}
	
	public void clear(){
		this.OUTPUT_PANE.setText("");
	}
}
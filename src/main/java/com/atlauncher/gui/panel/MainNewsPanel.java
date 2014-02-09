package com.atlauncher.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public final class MainNewsPanel extends JPanel{
	private static final long serialVersionUID = -8090832512239253035L;
	
	private final HTMLEditorKit HTML_KIT = new HTMLEditorKit(){
		private static final long serialVersionUID = -521467502264169864L;

		{
			StyleSheet style = this.getStyleSheet();
			style.addRule("A {color:#0088CC}");
			style.addRule("#newsHeader {font-weight:bold;font-size:14px;color:#339933;}");
			style.addRule("#newsBody {font-size:10px;padding-left:20px;}");
		}
	};
	private final JEditorPane OUTPUT = new JEditorPane("text/html", ""){
		private static final long serialVersionUID = 5775312457730182308L;

		{
			this.setEditable(false);
			this.setSelectionColor(Color.GRAY);
			this.setEditorKit(MainNewsPanel.this.HTML_KIT);
			this.addHyperlinkListener(new HyperlinkListener(){
				@Override
				public void hyperlinkUpdate(HyperlinkEvent event){
					if(event.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)){
						
					}
				}
			});
		}
	};
	private final JScrollPane SCROLL_PANE = new JScrollPane(this.OUTPUT, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public MainNewsPanel(){
		super();
		this.setLayout(new BorderLayout());
		this.add(this.SCROLL_PANE, BorderLayout.CENTER);
	}
}
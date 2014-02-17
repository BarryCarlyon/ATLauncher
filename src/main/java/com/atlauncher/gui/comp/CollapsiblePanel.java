package com.atlauncher.gui.comp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.atlauncher.ATLauncher;

public class CollapsiblePanel extends JPanel{
	private static final long serialVersionUID = -8054639064859852939L;
	
	public static final int COLLAPSED = 0x0;
	public static final int EXPANDED = 0x1;

	private final JPanel DISPLAY;
	private final JButton COLLAPSER = new JButton(){
		private static final long serialVersionUID = 171677201108762157L;
		
		{
			this.setBorder(BorderFactory.createEmptyBorder(0, 1, 5, 1));
			this.setVerticalTextPosition(AbstractButton.CENTER);
			this.setHorizontalTextPosition(AbstractButton.LEFT);
			this.setMargin(new Insets(0, 0, 3, 0));
			this.setFont(new Font("SansSerif", Font.BOLD, 14));
			this.setFocusable(false);
			this.setContentAreaFilled(false);
			this.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event){
					
				}
			});
			this.setCursor(ATLauncher.HAND);
		}
	};
	private final ImageIcon[] ICONS = new ImageIcon[]{
		ATLauncher.loadIcon("collapsed"),
		ATLauncher.loadIcon("expanded")
	};
	
	private Border collapsedBorder = BorderFactory.createTitledBorder("");
	private Border expandedBorder = null;
	private int state = CollapsiblePanel.EXPANDED;
	private Border border;
	
	protected CollapsiblePanel(){
		super(new BorderLayout());
		this.DISPLAY = new JPanel();
	}
	
	public void setCollapsed(boolean coll){
		if(coll){
			this.remove(this.DISPLAY);
			this.state = CollapsiblePanel.COLLAPSED;
		} else{
			this.add(this.DISPLAY, BorderLayout.NORTH);
			this.state = CollapsiblePanel.EXPANDED;
		}
		
		this.COLLAPSER.setIcon(this.ICONS[this.state]);
	}
	
	public JPanel getDisplay(){
		return this.DISPLAY;
	}
	
	public final boolean isCollapsed(){
		return this.state == CollapsiblePanel.COLLAPSED;
	}
	
	private final class CollapsibleTitledBorder extends TitledBorder{
		private final JComponent comp;
		
		public CollapsibleTitledBorder(Border b, JComponent comp){
			this(b, comp, TitledBorder.LEFT, TitledBorder.TOP);
		}
		
		public CollapsibleTitledBorder(Border border, JComponent comp, int justification, int pos){
			super(border, null, justification, pos);
			this.comp = comp;
			
			if(border == null){
				this.border = super.getBorder();
			}
		}
		
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
			Rectangle borderSpace = new Rectangle(x + EDGE_SPACING, y + EDGE_SPACING, (width - (EDGE_SPACING << 1)), (height - (EDGE_SPACING << 1)));
			Insets borderInsets = (this.border != null) ? this.border.getBorderInsets(c) : new Insets(0, 0, 0, 0);
			
			Rectangle rect = new Rectangle(x, y, width, height);
			Insets insets = this.getBorderInsets(c);
			Rectangle compRect = this.getComponentRectangle(rect, insets);
		}
		
		private Rectangle getComponentRectangle(Rectangle rect, Insets insets){
			Dimension compDimension = this.comp.getPreferredSize();
			
			Rectangle compRect = new Rectangle(0, 0, compDimension.width, compDimension.height);
			switch(this.titlePosition)
			{
				case ABOVE_TOP:{
					compRect.y = EDGE_SPACING;
					break;
				}
				case TOP:
				case DEFAULT_POSITION:{
					if(this.comp instanceof JButton){
						compRect.y = EDGE_SPACING + (insets.top - EDGE_SPACING - TEXT_SPACING - compDimension.height) >> 1;
					} else if(this.comp instanceof JRadioButton){
						compRect.y = (insets.top - EDGE_SPACING - TEXT_SPACING - compDimension.height) >> 1;
					}
					
					break;
				}
				case BELOW_TOP:{
					compRect.y = insets.top - compDimension.height - TEXT_SPACING;
					break;
				}
				case ABOVE_BOTTOM:{
					compRect.y = rect.height - insets.bottom + TEXT_SPACING;
					break;
				}
				case BOTTOM:{
					compRect.y = rect.height - insets.bottom + TEXT_SPACING + (insets.bottom - EDGE_SPACING - TEXT_SPACING - compDimension.height) >> 1;
					break;
				}
				case BELOW_BOTTOM:{
					compRect.y = rect.height - compDimension.height - EDGE_SPACING;
					break;
				}
			}
			
			switch(this.titleJustification)
			{
				case LEFT:
				case DEFAULT_JUSTIFICATION:{
					compRect.x = TEXT_INSET_H + insets.left - EDGE_SPACING;
					break;
				}
				case RIGHT:{
					compRect.x = rect.width - insets.right - TEXT_INSET_H - compRect.width;
					break;
				}
				case CENTER:{
					compRect.x = (rect.width - compRect.width) >> 1;
					break;
				}
			}
			
			return compRect;
		}
	}
}
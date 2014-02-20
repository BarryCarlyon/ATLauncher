package com.atlauncher.gui.panel;

import com.atlauncher.ATLauncher;
import com.atlauncher.gui.panel.settings.SettingsPage1;
import com.atlauncher.gui.panel.settings.SettingsPage2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class MainSettingsPanel extends JPanel{
	private static final long serialVersionUID = -6309362351276370276L;

    private final class TopBar extends JPanel{
        private final JLabel TITLE = new JLabel("Settings 1"){
            {
                this.setFont(ATLauncher.loadFont("Oswald-Regular").deriveFont(34.0F));
            }
        };

        private TopBar(){
            super(new FlowLayout());
            this.setBorder(BorderFactory.createEtchedBorder());

            this.add(TITLE);
        }
    }

    private final class SettingsBook extends JPanel{
        private final String[] NAMES = new String[]{
                "Settings 1", "Settings 2"
        };

        private int ptr = 0;

        public SettingsBook(){
            super(new CardLayout());

            this.add(new SettingsPage1(), this.NAMES[0]);
            this.add(new SettingsPage2(), this.NAMES[1]);
        }

        public void cycleForward(){
            this.ptr++;

            if(this.ptr >= this.NAMES.length){
                this.ptr = this.NAMES.length - 1;
            }

            this.show(this.NAMES[this.ptr]);
        }

        public void cycleBackward(){
            this.ptr--;

            if(this.ptr <= 0){
                this.ptr = 0;
            }

            this.show(this.NAMES[this.ptr]);
        }

        public void show(String name){
            CardLayout layout = (CardLayout) this.getLayout();
            layout.show(this, name);
        }
    }

    private final class BottomBar extends JPanel{
        private final class Left extends JPanel{
            private final JButton BACK = new JButton("Back"){
                {
                    this.setFont(ATLauncher.loadFont("Oswald-Regular").deriveFont(24.0F));
                    this.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent event){
                            backward();
                        }
                    });
                }
            };

            private Left(){
                super(new FlowLayout());

                this.add(BACK);
            }
        }

        private final class Right extends JPanel{
            private final JButton NEXT = new JButton("Next"){
                {
                    this.setFont(ATLauncher.loadFont("Oswald-Regular").deriveFont(24.0F));
                    this.addActionListener(new ActionListener(){
                       @Override
                       public void actionPerformed(ActionEvent event){
                           forward();
                       }
                    });
                }
            };

            private Right(){
                super(new FlowLayout());

                this.add(NEXT);
            }
        }

        public final Left LEFT = new Left();
        public final Right RIGHT = new Right();

        private BottomBar(){
            super(new BorderLayout());

            this.setMinimumSize(new Dimension(0, 50));

            this.add(this.RIGHT, BorderLayout.EAST);
            this.add(this.LEFT, BorderLayout.WEST);
        }
    }

    private final TopBar TOP = new TopBar();
    private final SettingsBook BOOK = new SettingsBook();
    private final BottomBar BAR = new BottomBar();

    public MainSettingsPanel(){
        super(new BorderLayout());

        this.add(this.TOP, BorderLayout.NORTH);
        this.add(this.BOOK, BorderLayout.CENTER);
        this.add(this.BAR, BorderLayout.SOUTH);
    }

    public void forward(){
        this.BOOK.cycleForward();
        this.TOP.TITLE.setText(this.BOOK.NAMES[this.BOOK.ptr]);
    }

    public void backward(){
        this.BOOK.cycleBackward();
        this.TOP.TITLE.setText(this.BOOK.NAMES[this.BOOK.ptr]);
    }
}
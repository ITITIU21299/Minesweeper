package minesweeper;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    int diff = 4;
    int row;
    int col;
    int music = 1;
    GameScreen gameScreen;
    String txtDiff;
    CardLayout cl;
    
    
    public Menu() {
        initComponents();
        URL resourceURL = this.getClass().getResource("/iconFrame.png");
        if (resourceURL != null) {
            Image icon = new ImageIcon(resourceURL).getImage();
            this.setIconImage(icon);
        } else {
            System.err.println("Resource not found: img/iconFrame.png");
           }
        
        setLocationRelativeTo(null);
        txtDiff = "Explain difficulty";
        java.awt.event.MouseEvent evt;
        
        cl = (CardLayout) (parent.getLayout());
        parent.removeAll();
        parent.add(menuPanel);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "menuPanel"); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        diffPanel = new javax.swing.JPanel();
        txtRow = new javax.swing.JTextField();
        txtColumn = new javax.swing.JTextField();
        txtDiffExplain = new javax.swing.JLabel();
        rowLabel2 = new javax.swing.JLabel();
        columnLabel2 = new javax.swing.JLabel();
        rowLabel = new javax.swing.JLabel();
        columnLabel = new javax.swing.JLabel();
        titleDiff = new javax.swing.JLabel();
        easyBtn = new javax.swing.JLabel();
        mediumBtn = new javax.swing.JLabel();
        hardBtn = new javax.swing.JLabel();
        confirmBtnDiff = new javax.swing.JLabel();
        backBtnDiff = new javax.swing.JLabel();
        bgDiff = new javax.swing.JLabel();
        settingsPanel = new javax.swing.JPanel();
        titleSettings = new javax.swing.JLabel();
        onBtnSettings = new javax.swing.JLabel();
        offBtnSettings = new javax.swing.JLabel();
        confirmBtnSettings = new javax.swing.JLabel();
        bgSettings = new javax.swing.JLabel();
        pausePanel = new javax.swing.JPanel();
        titlePause = new javax.swing.JLabel();
        titlePause2 = new javax.swing.JLabel();
        confirmBtnPause = new javax.swing.JLabel();
        onBtnPause = new javax.swing.JLabel();
        offBtnPause = new javax.swing.JLabel();
        bgPause = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        startBtn = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JLabel();
        exitBtn = new javax.swing.JLabel();
        bgMenu = new javax.swing.JLabel();
        pauseBtn = new javax.swing.JLabel();
        menuBtn = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setMinimumSize(new java.awt.Dimension(1217, 684));
        setResizable(false);
        setSize(new java.awt.Dimension(1217, 684));
        getContentPane().setLayout(null);

        parent.setLayout(new java.awt.CardLayout());

        diffPanel.setLayout(null);

        txtRow.setFont(new Font("Open Sans", Font.BOLD, 22));
        diffPanel.add(txtRow);
        txtRow.setBounds(183, 70, 100, 40);

        txtColumn.setFont(new Font("Open Sans", Font.BOLD, 22));
        diffPanel.add(txtColumn);
        txtColumn.setBounds(183, 120, 100, 40);

        txtDiffExplain.setFont(new Font("Open Sans", Font.BOLD, 20));
        txtDiffExplain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDiffExplain.setLabelFor(diffPanel);
        txtDiffExplain.setText("Explain difficulty");
        txtDiffExplain.setToolTipText("");
        txtDiffExplain.setAlignmentY(0.0F);
        diffPanel.add(txtDiffExplain);
        txtDiffExplain.setBounds(0, 240, 466, 40);

        rowLabel2.setFont(new Font("Open Sans", Font.BOLD, 20));
        rowLabel2.setText("( 8 - 15 )");
        diffPanel.add(rowLabel2);
        rowLabel2.setBounds(290, 70, 160, 40);

        columnLabel2.setFont(new Font("Open Sans", Font.BOLD, 20));
        columnLabel2.setText("( 8 - 15 )");
        diffPanel.add(columnLabel2);
        columnLabel2.setBounds(290, 120, 160, 40);

        rowLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        rowLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        rowLabel.setLabelFor(diffPanel);
        rowLabel.setText("Rows :");
        rowLabel.setAlignmentY(0.0F);
        diffPanel.add(rowLabel);
        rowLabel.setBounds(46, 70, 120, 40);

        columnLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        columnLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        columnLabel.setLabelFor(diffPanel);
        columnLabel.setText("Columns :");
        columnLabel.setToolTipText("");
        columnLabel.setAlignmentY(0.0F);
        diffPanel.add(columnLabel);
        columnLabel.setBounds(46, 120, 120, 40);

        titleDiff.setFont(new Font("Open Sans", Font.BOLD, 20));
        titleDiff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleDiff.setLabelFor(diffPanel);
        titleDiff.setText("Set rows and columns");
        titleDiff.setAlignmentY(0.0F);
        diffPanel.add(titleDiff);
        titleDiff.setBounds(0, 0, 466, 80);

        easyBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/easyBtn-Idle-new.png"))); // NOI18N
        easyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                easyBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                easyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                easyBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                easyBtnMousePressed(evt);
            }
        });
        diffPanel.add(easyBtn);
        easyBtn.setBounds(17, 185, 133, 46);

        mediumBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mediumBtn-Idle-new.png"))); // NOI18N
        mediumBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mediumBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mediumBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mediumBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mediumBtnMousePressed(evt);
            }
        });
        diffPanel.add(mediumBtn);
        mediumBtn.setBounds(167, 185, 133, 46);

        hardBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hardBtn-Idle-new.png"))); // NOI18N
        hardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hardBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hardBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hardBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hardBtnMousePressed(evt);
            }
        });
        diffPanel.add(hardBtn);
        hardBtn.setBounds(317, 185, 133, 46);

        confirmBtnDiff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Idle-new.png"))); // NOI18N
        confirmBtnDiff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtnDiffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmBtnDiffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmBtnDiffMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmBtnDiffMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmBtnDiffMouseReleased(evt);
            }
        });
        diffPanel.add(confirmBtnDiff);
        confirmBtnDiff.setBounds(267, 295, 133, 46);

        backBtnDiff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backBtn-Idle-new.png"))); // NOI18N
        backBtnDiff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnDiffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnDiffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnDiffMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backBtnDiffMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backBtnDiffMouseReleased(evt);
            }
        });
        diffPanel.add(backBtnDiff);
        backBtnDiff.setBounds(67, 295, 133, 46);

        bgDiff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        bgDiff.setFont(new Font("Open Sans", Font.BOLD, 28));
        bgDiff.setToolTipText("");
        bgDiff.setAlignmentY(0.0F);
        bgDiff.setRequestFocusEnabled(false);
        diffPanel.add(bgDiff);
        bgDiff.setBounds(0, 0, 466, 366);

        parent.add(diffPanel, "card3");
        diffPanel.getAccessibleContext().setAccessibleDescription("");

        settingsPanel.setLayout(null);

        titleSettings.setFont(new Font("Open Sans", Font.BOLD, 28));
        titleSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSettings.setLabelFor(diffPanel);
        titleSettings.setText("Sound");
        titleSettings.setAlignmentY(0.0F);
        settingsPanel.add(titleSettings);
        titleSettings.setBounds(0, 0, 240, 80);

        onBtnSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png"))); // NOI18N
        onBtnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onBtnSettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                onBtnSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                onBtnSettingsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onBtnSettingsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onBtnSettingsMouseReleased(evt);
            }
        });
        settingsPanel.add(onBtnSettings);
        onBtnSettings.setBounds(230, 10, 80, 70);

        offBtnSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png"))); // NOI18N
        offBtnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offBtnSettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                offBtnSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                offBtnSettingsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                offBtnSettingsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                offBtnSettingsMouseReleased(evt);
            }
        });
        settingsPanel.add(offBtnSettings);
        offBtnSettings.setBounds(340, 10, 80, 70);

        confirmBtnSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Idle-new.png"))); // NOI18N
        confirmBtnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtnSettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmBtnSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmBtnSettingsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmBtnSettingsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmBtnSettingsMouseReleased(evt);
            }
        });
        settingsPanel.add(confirmBtnSettings);
        confirmBtnSettings.setBounds(160, 300, 133, 46);

        bgSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        bgSettings.setToolTipText("");
        bgSettings.setAlignmentY(0.0F);
        bgSettings.setRequestFocusEnabled(false);
        settingsPanel.add(bgSettings);
        bgSettings.setBounds(0, 0, 466, 366);

        parent.add(settingsPanel, "card3");

        pausePanel.setLayout(null);

        titlePause.setFont(new Font("Open Sans", Font.BOLD, 28));
        titlePause.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePause.setLabelFor(diffPanel);
        titlePause.setText("PAUSE");
        titlePause.setAlignmentY(0.0F);
        pausePanel.add(titlePause);
        titlePause.setBounds(110, 130, 240, 80);

        titlePause2.setFont(new Font("Open Sans", Font.BOLD, 28));
        titlePause2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePause2.setLabelFor(diffPanel);
        titlePause2.setText("Sound");
        titlePause2.setAlignmentY(0.0F);
        pausePanel.add(titlePause2);
        titlePause2.setBounds(0, 0, 240, 80);

        confirmBtnPause.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Idle-new.png"))); // NOI18N
        confirmBtnPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtnPauseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmBtnPauseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmBtnPauseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmBtnPauseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmBtnPauseMouseReleased(evt);
            }
        });
        pausePanel.add(confirmBtnPause);
        confirmBtnPause.setBounds(160, 300, 133, 46);

        onBtnPause.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png"))); // NOI18N
        onBtnPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onBtnPauseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                onBtnPauseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                onBtnPauseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onBtnPauseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onBtnPauseMouseReleased(evt);
            }
        });
        pausePanel.add(onBtnPause);
        onBtnPause.setBounds(230, 10, 80, 70);

        offBtnPause.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png"))); // NOI18N
        offBtnPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offBtnPauseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                offBtnPauseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                offBtnPauseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                offBtnPauseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                offBtnPauseMouseReleased(evt);
            }
        });
        pausePanel.add(offBtnPause);
        offBtnPause.setBounds(340, 10, 80, 70);

        bgPause.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        bgPause.setToolTipText("");
        bgPause.setAlignmentY(0.0F);
        bgPause.setRequestFocusEnabled(false);
        pausePanel.add(bgPause);
        bgPause.setBounds(0, 0, 466, 366);

        parent.add(pausePanel, "card3");

        menuPanel.setLayout(null);

        startBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/startBtn-Idle.png"))); // NOI18N
        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startBtnMouseReleased(evt);
            }
        });
        menuPanel.add(startBtn);
        startBtn.setBounds(115, 30, 236, 82);

        settingsBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settingsBtn-Idle.png"))); // NOI18N
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingsBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                settingsBtnMouseReleased(evt);
            }
        });
        menuPanel.add(settingsBtn);
        settingsBtn.setBounds(115, 142, 236, 82);

        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exitBtn-Idle.png"))); // NOI18N
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitBtnMouseReleased(evt);
            }
        });
        menuPanel.add(exitBtn);
        exitBtn.setBounds(115, 254, 236, 82);

        bgMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        bgMenu.setToolTipText("");
        bgMenu.setAlignmentY(0.0F);
        bgMenu.setRequestFocusEnabled(false);
        menuPanel.add(bgMenu);
        bgMenu.setBounds(0, 0, 466, 366);

        parent.add(menuPanel, "card4");

        getContentPane().add(parent);
        parent.setBounds(375, 240, 466, 366);

        pauseBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pauseBtn-Idle-new.png"))); // NOI18N
        pauseBtn.setVisible(false);
        pauseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pauseBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pauseBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pauseBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pauseBtnMouseReleased(evt);
            }
        });
        getContentPane().add(pauseBtn);
        pauseBtn.setBounds(60, 480, 133, 46);

        menuBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuBtn-Idle-new.png"))); // NOI18N
        menuBtn.setVisible(false);
        menuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuBtnMouseReleased(evt);
            }
        });
        getContentPane().add(menuBtn);
        menuBtn.setBounds(60, 550, 133, 46);

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuBackground.jpg"))); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 1217, 646);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseClicked
        parent.removeAll();
        parent.setVisible(true);
        parent.add(diffPanel);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "diffPanel");        
    }//GEN-LAST:event_startBtnMouseClicked

    private void startBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseEntered
         startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/startBtn-Hover.png"))); // NOI18N
    }//GEN-LAST:event_startBtnMouseEntered

    private void startBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseExited
         startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/startBtn-Idle.png"))); // NOI18N        
    }//GEN-LAST:event_startBtnMouseExited

    private void startBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMousePressed
         startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/startBtn-Press.png"))); // NOI18N                
    }//GEN-LAST:event_startBtnMousePressed

    private void startBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseReleased
         startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/startBtn-Hover.png"))); // NOI18N                        
    }//GEN-LAST:event_startBtnMouseReleased

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        dispose();
    }//GEN-LAST:event_exitBtnMouseClicked

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exitBtn-Hover.png"))); // NOI18N
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exitBtn-Idle.png"))); // NOI18N
    }//GEN-LAST:event_exitBtnMouseExited

    private void exitBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMousePressed
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exitBtn-Press.png"))); // NOI18N
    }//GEN-LAST:event_exitBtnMousePressed

    private void exitBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseReleased
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exitBtn-Hover.png"))); // NOI18N
    }//GEN-LAST:event_exitBtnMouseReleased

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseClicked
        parent.removeAll();
        parent.setVisible(true);
        parent.add(settingsPanel);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "settingsPanel");    
    }//GEN-LAST:event_settingsBtnMouseClicked

    private void settingsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseEntered
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settingsBtn-Hover.png")));         
    }//GEN-LAST:event_settingsBtnMouseEntered

    private void settingsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseExited
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settingsBtn-Idle.png")));         
    }//GEN-LAST:event_settingsBtnMouseExited

    private void settingsBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMousePressed
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settingsBtn-Press.png")));         
    }//GEN-LAST:event_settingsBtnMousePressed

    private void settingsBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseReleased
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settingsBtn-Hover.png")));         
    }//GEN-LAST:event_settingsBtnMouseReleased

    private void easyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_easyBtnMouseClicked
        if (diff == 0)
            return;        
       diff = 0;
        easyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/easyBtn-Press-new.png")));  
        mediumBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mediumBtn-Idle-new.png")));                 
        hardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hardBtn-Idle-new.png")));                 
        
        txtDiff = "Easy: 10% of tiles are bombs";
        txtDiffExplain.setText(txtDiff);
        
    }//GEN-LAST:event_easyBtnMouseClicked

    private void easyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_easyBtnMouseEntered
        if (diff == 0)
            return;
        easyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/easyBtn-Hover-new.png")));       
        txtDiffExplain.setText("Easy: 10% of tiles are bombs");
    }//GEN-LAST:event_easyBtnMouseEntered

    private void easyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_easyBtnMouseExited
        if (diff == 0)
            return;
        easyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/easyBtn-Idle-new.png")));         
        txtDiffExplain.setText(txtDiff);        
    }//GEN-LAST:event_easyBtnMouseExited

    private void easyBtnMousePressed(java.awt.event.MouseEvent evt) {                                     
        easyBtnMouseClicked(evt);
    }                                                                    

    private void mediumBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mediumBtnMouseClicked
        if (diff == 1)
            return;        
        diff = 1;
        easyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/easyBtn-Idle-new.png")));          
        mediumBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mediumBtn-Press-new.png")));           
        hardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hardBtn-Idle-new.png")));     

        txtDiff = "Medium: 15% of tiles are bombs";
        txtDiffExplain.setText(txtDiff);
    }//GEN-LAST:event_mediumBtnMouseClicked

    private void mediumBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mediumBtnMouseEntered
        if (diff == 1)
            return;             
        mediumBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mediumBtn-Hover-new.png")));         
        
        txtDiffExplain.setText("Medium: 15% of tiles are bombs");        
    }//GEN-LAST:event_mediumBtnMouseEntered

    private void mediumBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mediumBtnMouseExited
        if (diff == 1)
            return;     
        mediumBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mediumBtn-Idle-new.png")));        
        
        txtDiffExplain.setText(txtDiff);                
    }//GEN-LAST:event_mediumBtnMouseExited

    private void mediumBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mediumBtnMousePressed
        mediumBtnMouseClicked(evt);
    }//GEN-LAST:event_mediumBtnMousePressed

    private void hardBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardBtnMouseClicked
        if (diff == 2)
            return;        
        diff = 2;
        easyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/easyBtn-Idle-new.png")));          
        mediumBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mediumBtn-Idle-new.png")));           
        hardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hardBtn-Press-new.png"))); 
        
        txtDiff = "Hard: 25% of tiles are bombs";
        txtDiffExplain.setText(txtDiff);        
    }//GEN-LAST:event_hardBtnMouseClicked

    private void hardBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardBtnMouseEntered
        if (diff == 2)
            return;     
        hardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hardBtn-Hover-new.png")));  
        
        txtDiffExplain.setText("Hard: 25% of tiles are bombs");                
    }//GEN-LAST:event_hardBtnMouseEntered

    private void hardBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardBtnMouseExited
        if (diff == 2)
            return;     
        hardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hardBtn-Idle-new.png")));  
        
        txtDiffExplain.setText(txtDiff);                
    }//GEN-LAST:event_hardBtnMouseExited

    private void hardBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardBtnMousePressed
        hardBtnMouseClicked(evt);
    }//GEN-LAST:event_hardBtnMousePressed

    private void backBtnDiffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnDiffMouseClicked
        parent.removeAll();
        parent.setVisible(true);
        parent.add(menuPanel);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "menuPanel");    
    }//GEN-LAST:event_backBtnDiffMouseClicked

    private void backBtnDiffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnDiffMouseEntered
        backBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backBtn-Hover-new.png")));         
    }//GEN-LAST:event_backBtnDiffMouseEntered

    private void backBtnDiffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnDiffMouseExited
        backBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backBtn-Idle-new.png")));         
    }//GEN-LAST:event_backBtnDiffMouseExited

    private void backBtnDiffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnDiffMousePressed
        backBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backBtn-Press-new.png")));         
    }//GEN-LAST:event_backBtnDiffMousePressed

    private void backBtnDiffMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnDiffMouseReleased
        backBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backBtn-Hover-new.png")));         
    }//GEN-LAST:event_backBtnDiffMouseReleased
/**/
    private void confirmBtnDiffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnDiffMouseClicked
        String r = txtRow.getText();
        String c = txtColumn.getText();
        
        try {
            row = Integer.valueOf(r);
            col = Integer.valueOf(c);
        } catch (NumberFormatException e ) {
            JOptionPane.showMessageDialog(null, "Please enter valid rows and columns", "Warning",JOptionPane.WARNING_MESSAGE);            
            return;
        }
        if (diff == 4) {
            JOptionPane.showMessageDialog(null, "Please select a difficulty", "Warning",JOptionPane.WARNING_MESSAGE);   
            return;
        } 
        if (row < 8 || row > 15 || col < 8 || col > 15) {
            JOptionPane.showMessageDialog(null, "Please enter valid rows and columns", "Warning",JOptionPane.WARNING_MESSAGE);     
            return;
        }
            
        gameScreen = new GameScreen(diff, row, col);
        cl = (CardLayout) (parent.getLayout());
        
        parent.setLocation((int) ((1217 - 40*row) /2) , 2);
        parent.setSize(40*col, 40*row + 40);
        parent.removeAll();
        parent.add(gameScreen);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "gameScreen");   
        
        menuBtn.setVisible(true);
        pauseBtn.setVisible(true);

    }//GEN-LAST:event_confirmBtnDiffMouseClicked

    private void confirmBtnDiffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnDiffMouseEntered
        confirmBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Hover-new.png")));         
    }//GEN-LAST:event_confirmBtnDiffMouseEntered

    private void confirmBtnDiffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnDiffMouseExited
        confirmBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Idle-new.png")));         
    }//GEN-LAST:event_confirmBtnDiffMouseExited

    private void confirmBtnDiffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnDiffMousePressed
        confirmBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Press-new.png")));         
    }//GEN-LAST:event_confirmBtnDiffMousePressed

    private void confirmBtnDiffMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnDiffMouseReleased
        confirmBtnDiff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Hover-new.png")));         
        // confirmBtnDiffMouseClicked(evt);
    }//GEN-LAST:event_confirmBtnDiffMouseReleased

    private void confirmBtnSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnSettingsMouseClicked

        parent.setLocation(375, 240);
        parent.setSize(466, 366);
        parent.removeAll();
        parent.add(menuPanel);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "menuPanel");              
    }//GEN-LAST:event_confirmBtnSettingsMouseClicked

    private void confirmBtnSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnSettingsMouseEntered
        confirmBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Hover-new.png")));         
    }//GEN-LAST:event_confirmBtnSettingsMouseEntered

    private void confirmBtnSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnSettingsMouseExited
        confirmBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Idle-new.png")));         
    }//GEN-LAST:event_confirmBtnSettingsMouseExited

    private void confirmBtnSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnSettingsMousePressed
        confirmBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Press-new.png")));         
    }//GEN-LAST:event_confirmBtnSettingsMousePressed

    private void confirmBtnSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnSettingsMouseReleased
        confirmBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Hover-new.png")));         
    }//GEN-LAST:event_confirmBtnSettingsMouseReleased

    private void onBtnSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnSettingsMouseClicked
        if (music == 1) return;
        music = 1; 
        Minesweeper.PlayMusic();
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png")));   
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png")));   
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png")));     
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png")));             
    }//GEN-LAST:event_onBtnSettingsMouseClicked

    private void onBtnSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnSettingsMouseEntered
        if (music == 1) return;
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Hover.png")));         
    }//GEN-LAST:event_onBtnSettingsMouseEntered

    private void onBtnSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnSettingsMouseExited
        if (music == 1) return;
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Idle.png")));         
    }//GEN-LAST:event_onBtnSettingsMouseExited

    private void onBtnSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnSettingsMousePressed
        if (music == 1) return;
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png")));         
    }//GEN-LAST:event_onBtnSettingsMousePressed

    private void onBtnSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnSettingsMouseReleased
        onBtnSettingsMouseClicked(evt);         
    }//GEN-LAST:event_onBtnSettingsMouseReleased

    private void offBtnSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnSettingsMouseClicked
        if (music == 0) return;
        music = 0;
        Minesweeper.StopMusic();
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Idle.png")));        
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Press.png")));
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Idle.png")));
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Press.png")));        
    }//GEN-LAST:event_offBtnSettingsMouseClicked

    private void offBtnSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnSettingsMouseEntered
        if (music == 0) return;
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Hover.png")));         
    }//GEN-LAST:event_offBtnSettingsMouseEntered

    private void offBtnSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnSettingsMouseExited
        if (music == 0) return;
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png")));      
    }//GEN-LAST:event_offBtnSettingsMouseExited

    private void offBtnSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnSettingsMousePressed
        if (music == 0) return;
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Press.png")));      
    }//GEN-LAST:event_offBtnSettingsMousePressed

    private void offBtnSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnSettingsMouseReleased
        offBtnSettingsMouseClicked(evt);
    }//GEN-LAST:event_offBtnSettingsMouseReleased

    private void menuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMouseClicked
        gameScreen.gameOver = true;
        
        parent.setLocation(375, 240);
        parent.setSize(466, 366);
        parent.removeAll();
        parent.add(menuPanel);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "menuPanel");      
        
        menuBtn.setVisible(false);
        pauseBtn.setVisible(false);       
        
    }//GEN-LAST:event_menuBtnMouseClicked

    private void menuBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMouseEntered
        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuBtn-Hover-new.png")));         
    }//GEN-LAST:event_menuBtnMouseEntered

    private void menuBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMouseExited
        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuBtn-Idle-new.png")));         
    }//GEN-LAST:event_menuBtnMouseExited

    private void menuBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMousePressed
        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuBtn-Press-new.png")));         
    }//GEN-LAST:event_menuBtnMousePressed

    private void menuBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMouseReleased
        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuBtn-Hover-new.png")));
        menuBtnMouseClicked(evt);
    }//GEN-LAST:event_menuBtnMouseReleased

    private void pauseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseClicked
        parent.setLocation(375, 240);
        parent.setSize(466, 366);
        parent.removeAll();
        parent.add(pausePanel);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "pausePanel");
        pauseBtn.setVisible(false);
        GameScreen.gamePaused = true;
    }//GEN-LAST:event_pauseBtnMouseClicked

    private void pauseBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseEntered
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pauseBtn-Hover-new.png")));         
    }//GEN-LAST:event_pauseBtnMouseEntered

    private void pauseBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseExited
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pauseBtn-Idle-new.png")));         
    }//GEN-LAST:event_pauseBtnMouseExited

    private void pauseBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMousePressed
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pauseBtn-Press-new.png")));         
    }//GEN-LAST:event_pauseBtnMousePressed

    private void pauseBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseReleased
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pauseBtn-Hover-new.png")));
        pauseBtnMouseClicked(evt);
    }//GEN-LAST:event_pauseBtnMouseReleased

    private void confirmBtnPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnPauseMouseClicked

        parent.setLocation((int)(1217 - 40 * row) /2 , 2);
        parent.setSize(40*col, 40*row + 40);
        parent.removeAll();
        parent.add(gameScreen);
        parent.repaint();
        parent.revalidate();
        cl.show(parent, "gameScreen");
        GameScreen.gamePaused=false;
        
        pauseBtn.setVisible(true);
    }//GEN-LAST:event_confirmBtnPauseMouseClicked

    private void confirmBtnPauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnPauseMouseEntered
        confirmBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Hover-new.png")));         
    }//GEN-LAST:event_confirmBtnPauseMouseEntered

    private void confirmBtnPauseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnPauseMouseExited
        confirmBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Idle-new.png")));         
    }//GEN-LAST:event_confirmBtnPauseMouseExited

    private void confirmBtnPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnPauseMousePressed
        confirmBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Press-new.png")));         
    }//GEN-LAST:event_confirmBtnPauseMousePressed

    private void confirmBtnPauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnPauseMouseReleased
        confirmBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmBtn-Hover-new.png")));         
    }//GEN-LAST:event_confirmBtnPauseMouseReleased

    private void onBtnPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnPauseMouseClicked
        if (music == 1) return;
        music = 1; 
        Minesweeper.PlayMusic();
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png")));   
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png")));
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png")));
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png")));        
    }//GEN-LAST:event_onBtnPauseMouseClicked

    private void onBtnPauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnPauseMouseEntered
        if (music == 1) return;
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Hover.png")));   
    }//GEN-LAST:event_onBtnPauseMouseEntered

    private void onBtnPauseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnPauseMouseExited
        if (music == 1) return;
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Idle.png")));
    }//GEN-LAST:event_onBtnPauseMouseExited

    private void onBtnPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnPauseMousePressed
        if (music == 1) return;
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Press.png")));
    }//GEN-LAST:event_onBtnPauseMousePressed

    private void onBtnPauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onBtnPauseMouseReleased
        onBtnPauseMouseClicked(evt);
    }//GEN-LAST:event_onBtnPauseMouseReleased

    private void offBtnPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnPauseMouseClicked
        if (music == 0) return;
        music = 0; 
        Minesweeper.StopMusic();
        onBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Idle.png")));   
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Press.png"))); 
        onBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-On-Idle.png")));
        offBtnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Press.png")));        
    }//GEN-LAST:event_offBtnPauseMouseClicked

    private void offBtnPauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnPauseMouseEntered
        if (music == 0) return;
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Hover.png"))); 
    }//GEN-LAST:event_offBtnPauseMouseEntered

    private void offBtnPauseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnPauseMouseExited
        if (music == 0) return;        
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Idle.png"))); 
    }//GEN-LAST:event_offBtnPauseMouseExited

    private void offBtnPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnPauseMousePressed
        if (music == 0) return;        
        offBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundBtn-Off-Press.png"))); 
    }//GEN-LAST:event_offBtnPauseMousePressed

    private void offBtnPauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offBtnPauseMouseReleased
        offBtnPauseMouseClicked(evt);
    }//GEN-LAST:event_offBtnPauseMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtnDiff;
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel bgDiff;
    private javax.swing.JLabel bgMenu;
    private javax.swing.JLabel bgPause;
    private javax.swing.JLabel bgSettings;
    private javax.swing.JLabel columnLabel;
    private javax.swing.JLabel columnLabel2;
    private javax.swing.JLabel confirmBtnDiff;
    private javax.swing.JLabel confirmBtnPause;
    private javax.swing.JLabel confirmBtnSettings;
    private javax.swing.JPanel diffPanel;
    private javax.swing.JLabel easyBtn;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JLabel hardBtn;
    private javax.swing.JLabel mediumBtn;
    private javax.swing.JLabel menuBtn;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel offBtnPause;
    private javax.swing.JLabel offBtnSettings;
    private javax.swing.JLabel onBtnPause;
    private javax.swing.JLabel onBtnSettings;
    private javax.swing.JPanel parent;
    private javax.swing.JLabel pauseBtn;
    private javax.swing.JPanel pausePanel;
    private javax.swing.JLabel rowLabel;
    private javax.swing.JLabel rowLabel2;
    private javax.swing.JLabel settingsBtn;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JLabel startBtn;
    private javax.swing.JLabel titleDiff;
    private javax.swing.JLabel titlePause;
    private javax.swing.JLabel titlePause2;
    private javax.swing.JLabel titleSettings;
    private javax.swing.JTextField txtColumn;
    private javax.swing.JLabel txtDiffExplain;
    private javax.swing.JTextField txtRow;
    // End of variables declaration//GEN-END:variables
}

package pta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class SettingsFrame extends JFrame {

    private RoundedField adminName, adminEmail, collegeName, department, academicYear;
    private RoundedCombo themeCombo, fontCombo, timeoutCombo;

    private JCheckBox paymentNotifications;
    private JCheckBox returnNotifications;
    private JCheckBox pendingAlerts;
    private JCheckBox animations;
    private JCheckBox confirmDelete;
    private JCheckBox confirmReturn;

    public SettingsFrame() {

        setTitle("Settings");
        setSize(650, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        EducationBackground background = new EducationBackground();
        background.setLayout(new BorderLayout());

        // ================= HEADER =================

        JLabel title = new JLabel("⚙  Settings");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setBorder(new EmptyBorder(20, 20, 15, 20));
        header.add(title, BorderLayout.CENTER);

        background.add(header, BorderLayout.NORTH);

        // ================= MAIN CONTENT =================

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(new EmptyBorder(5, 25, 30, 25));

        // ================= ACCOUNT =================

        RoundedPanel accountPanel = createSection("ACCOUNT SETTINGS");

        adminName = new RoundedField("Administrator Name");
        adminEmail = new RoundedField("Administrator Email");

        accountPanel.add(adminName);
        accountPanel.add(Box.createVerticalStrut(12));
        accountPanel.add(adminEmail);

        content.add(accountPanel);
        content.add(Box.createVerticalStrut(18));

        // ================= INSTITUTION =================

        RoundedPanel institutionPanel = createSection("INSTITUTION");

        collegeName = new RoundedField("College Name");
        department = new RoundedField("Department");
        academicYear = new RoundedField("Academic Year");

        institutionPanel.add(collegeName);
        institutionPanel.add(Box.createVerticalStrut(12));
        institutionPanel.add(department);
        institutionPanel.add(Box.createVerticalStrut(12));
        institutionPanel.add(academicYear);

        content.add(institutionPanel);
        content.add(Box.createVerticalStrut(18));

        // ================= APPEARANCE =================

        RoundedPanel appearancePanel = createSection("APPEARANCE");

        themeCombo = new RoundedCombo(
                new String[]{"Dark", "Light", "System Default"}
        );

        fontCombo = new RoundedCombo(
                new String[]{"Segoe UI", "Arial", "Tahoma", "Sans Serif"}
        );

        appearancePanel.add(createLabel("Theme"));
        appearancePanel.add(Box.createVerticalStrut(5));
        appearancePanel.add(themeCombo);

        appearancePanel.add(Box.createVerticalStrut(12));

        appearancePanel.add(createLabel("Font"));
        appearancePanel.add(Box.createVerticalStrut(5));
        appearancePanel.add(fontCombo);

        content.add(appearancePanel);
        content.add(Box.createVerticalStrut(18));

        // ================= NOTIFICATIONS =================

        RoundedPanel notificationPanel = createSection("NOTIFICATIONS");

        paymentNotifications = createCheckBox(
                "Payment Notifications"
        );

        returnNotifications = createCheckBox(
                "Fund Return Notifications"
        );

        pendingAlerts = createCheckBox(
                "Pending Payment Alerts"
        );

        paymentNotifications.setSelected(true);
        returnNotifications.setSelected(true);
        pendingAlerts.setSelected(true);

        notificationPanel.add(paymentNotifications);
        notificationPanel.add(Box.createVerticalStrut(8));
        notificationPanel.add(returnNotifications);
        notificationPanel.add(Box.createVerticalStrut(8));
        notificationPanel.add(pendingAlerts);

        content.add(notificationPanel);
        content.add(Box.createVerticalStrut(18));

        // ================= SECURITY =================

        RoundedPanel securityPanel = createSection("SECURITY");

        timeoutCombo = new RoundedCombo(
                new String[]{
                        "5 Minutes",
                        "10 Minutes",
                        "15 Minutes",
                        "30 Minutes",
                        "Never"
                }
        );

        confirmDelete = createCheckBox(
                "Confirm Before Delete"
        );

        confirmReturn = createCheckBox(
                "Confirm Fund Return"
        );

        confirmDelete.setSelected(true);
        confirmReturn.setSelected(true);

        securityPanel.add(createLabel("Session Timeout"));
        securityPanel.add(Box.createVerticalStrut(5));
        securityPanel.add(timeoutCombo);

        securityPanel.add(Box.createVerticalStrut(12));
        securityPanel.add(confirmDelete);

        securityPanel.add(Box.createVerticalStrut(8));
        securityPanel.add(confirmReturn);

        content.add(securityPanel);
        content.add(Box.createVerticalStrut(18));

        // ================= SYSTEM =================

        RoundedPanel systemPanel = createSection("SYSTEM");

        animations = createCheckBox(
                "Enable Interface Animations"
        );

        animations.setSelected(true);

        systemPanel.add(animations);

        content.add(systemPanel);
        content.add(Box.createVerticalStrut(22));

        // ================= BUTTONS =================

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(
                buttonPanel,
                BoxLayout.Y_AXIS
        ));

        AnimatedButton saveButton =
                new AnimatedButton("SAVE SETTINGS");

        AnimatedButton resetButton =
                new AnimatedButton("RESET");

        AnimatedButton backupButton =
                new AnimatedButton("BACKUP DATA");

        AnimatedButton closeButton =
                new AnimatedButton("CLOSE");

        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(resetButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(backupButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(closeButton);

        content.add(buttonPanel);

        // ================= BUTTON ACTIONS =================

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                        SettingsFrame.this,
                        "Settings saved successfully!",
                        "Settings",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int choice = JOptionPane.showConfirmDialog(
                        SettingsFrame.this,
                        "Reset all settings?",
                        "Reset Settings",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {

                    adminName.setText("");
                    adminEmail.setText("");
                    collegeName.setText("");
                    department.setText("");
                    academicYear.setText("");

                    themeCombo.setSelectedIndex(0);
                    fontCombo.setSelectedIndex(0);
                    timeoutCombo.setSelectedIndex(2);

                    paymentNotifications.setSelected(true);
                    returnNotifications.setSelected(true);
                    pendingAlerts.setSelected(true);
                    animations.setSelected(true);
                    confirmDelete.setSelected(true);
                    confirmReturn.setSelected(true);
                }
            }
        });

        backupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                        SettingsFrame.this,
                        "Backup process started.",
                        "Backup",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // ================= SCROLL =================

        JScrollPane scrollPane = new JScrollPane(content);

        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        background.add(scrollPane, BorderLayout.CENTER);

        add(background);

        setVisible(true);
    }

    // =========================================================
    // SECTION PANEL
    // =========================================================

    private RoundedPanel createSection(String title) {

        RoundedPanel panel = new RoundedPanel();

        panel.setLayout(new BoxLayout(
                panel,
                BoxLayout.Y_AXIS
        ));

        panel.setBorder(new EmptyBorder(
                18, 18, 18, 18
        ));

        JLabel label = new JLabel(title);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        label.setForeground(Color.WHITE);

        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(15));

        return panel;
    }

    // =========================================================
    // LABEL
    // =========================================================

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        label.setForeground(Color.WHITE);

        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        return label;
    }

    // =========================================================
    // CHECKBOX
    // =========================================================

    private JCheckBox createCheckBox(String text) {

        JCheckBox box = new JCheckBox(text);

        box.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        box.setForeground(Color.WHITE);
        box.setOpaque(false);
        box.setFocusPainted(false);

        return box;
    }

    // =========================================================
    // ROUNDED FIELD
    // =========================================================

    class RoundedField extends JTextField {

        private String hint;

        public RoundedField(String hint) {

            this.hint = hint;

            setFont(
                    new Font(
                            "Segoe UI",
                            Font.PLAIN,
                            14
                    )
            );

            setForeground(Color.WHITE);
            setCaretColor(Color.WHITE);

            setOpaque(false);

            setBorder(
                    new EmptyBorder(
                            0, 18, 0, 18
                    )
            );

            setAlignmentX(Component.LEFT_ALIGNMENT);

            setPreferredSize(
                    new Dimension(
                            100,
                            48
                    )
            );

            setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            48
                    )
            );
        }

        protected void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            35
                    )
            );

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    25,
                    25
            );

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            90
                    )
            );

            g2.drawRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    25,
                    25
            );

            g2.dispose();

            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
        }
    }

    // =========================================================
    // ROUNDED COMBO
    // =========================================================

    class RoundedCombo extends JComboBox<String> {

        public RoundedCombo(String[] items) {

            super(items);

            setFont(
                    new Font(
                            "Segoe UI",
                            Font.PLAIN,
                            14
                    )
            );

            setForeground(Color.WHITE);
            setOpaque(false);

            setAlignmentX(Component.LEFT_ALIGNMENT);

            setPreferredSize(
                    new Dimension(
                            100,
                            48
                    )
            );

            setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            48
                    )
            );
        }

        public void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            35
                    )
            );

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    25,
                    25
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =========================================================
    // ROUNDED PANEL
    // =========================================================

    class RoundedPanel extends JPanel {

        public RoundedPanel() {

            setOpaque(false);

            setAlignmentX(
                    Component.LEFT_ALIGNMENT
            );

            setBorder(
                    new EmptyBorder(
                            18,
                            18,
                            18,
                            18
                    )
            );
        }

        protected void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(
                    new Color(
                            20,
                            25,
                            45,
                            190
                    )
            );

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    28,
                    28
            );

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            55
                    )
            );

            g2.drawRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    28,
                    28
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =========================================================
    // ANIMATED BUTTON
    // =========================================================

    class AnimatedButton extends JButton {

        private boolean hover = false;

        public AnimatedButton(String text) {

            super(text);

            setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            14
                    )
            );

            setForeground(Color.WHITE);

            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);

            setAlignmentX(Component.CENTER_ALIGNMENT);

            setPreferredSize(
                    new Dimension(
                            280,
                            50
                    )
            );

            setMaximumSize(
                    new Dimension(
                            320,
                            50
                    )
            );

            addMouseListener(
                    new MouseAdapter() {

                        public void mouseEntered(
                                MouseEvent e) {

                            hover = true;
                            repaint();
                        }

                        public void mouseExited(
                                MouseEvent e) {

                            hover = false;
                            repaint();
                        }
                    }
            );
        }

        protected void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            if (hover) {

                g2.setColor(
                        new Color(
                                70,
                                120,
                                255,
                                230
                        )
                );

            } else {

                g2.setColor(
                        new Color(
                                50,
                                70,
                                120,
                                210
                        )
                );
            }

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    28,
                    28
            );

            g2.setColor(Color.WHITE);

            FontMetrics fm =
                    g2.getFontMetrics();

            int x =
                    (getWidth()
                            - fm.stringWidth(
                            getText()))
                            / 2;

            int y =
                    (getHeight()
                            + fm.getAscent()
                            - fm.getDescent())
                            / 2;

            g2.drawString(
                    getText(),
                    x,
                    y
            );

            g2.dispose();
        }
    }

    // =========================================================
    // ANIMATED BACKGROUND
    // =========================================================

    class EducationBackground extends JPanel {

        Random random = new Random();

        int[] x = new int[35];
        int[] y = new int[35];
        int[] speed = new int[35];

        public EducationBackground() {

            for (int i = 0; i < 35; i++) {

                x[i] = random.nextInt(650);
                y[i] = random.nextInt(900);
                speed[i] = 1 + random.nextInt(2);
            }

            Timer timer = new Timer(
                    40,
                    new ActionListener() {

                        public void actionPerformed(
                                ActionEvent e) {

                            for (int i = 0; i < 35; i++) {

                                y[i] -= speed[i];

                                if (y[i] < -10) {
                                    y[i] = getHeight() + 10;
                                }
                            }

                            repaint();
                        }
                    }
            );

            timer.start();
        }

        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Background

            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            new Color(
                                    8,
                                    12,
                                    30
                            ),
                            getWidth(),
                            getHeight(),
                            new Color(
                                    35,
                                    15,
                                    65
                            )
                    );

            g2.setPaint(gradient);

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );

            // Glowing circles

            g2.setColor(
                    new Color(
                            70,
                            120,
                            255,
                            30
                    )
            );

            g2.fillOval(
                    -100,
                    50,
                    350,
                    350
            );

            g2.setColor(
                    new Color(
                            180,
                            60,
                            255,
                            25
                    )
            );

            g2.fillOval(
                    getWidth() - 250,
                    300,
                    350,
                    350
            );

            // Floating particles

            for (int i = 0; i < 35; i++) {

                int size =
                        3 + random.nextInt(4);

                g2.setColor(
                        new Color(
                                255,
                                255,
                                255,
                                70
                        )
                );

                g2.fillOval(
                        x[i],
                        y[i],
                        size,
                        size
                );
            }

            g2.dispose();
        }
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {

                        new SettingsFrame();
                    }
                }
        );
    }
}
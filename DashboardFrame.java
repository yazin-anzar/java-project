package pta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class DashboardFrame extends JFrame {

    private AnimatedBackground background;

    public DashboardFrame() {

        setTitle("PTA Fund Return Management System");
        setSize(1150, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // =========================
        // ANIMATED BACKGROUND
        // =========================

        background = new AnimatedBackground();
        background.setLayout(new BorderLayout());

        // =========================
        // TOP HEADER
        // =========================

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setBorder(
                new EmptyBorder(18, 28, 12, 28)
        );

        // LEFT - ADMIN PROFILE
        AnimatedHeaderButton profileButton =
                new AnimatedHeaderButton(
                        "●  Admin Profile"
                );

        profileButton.addActionListener(e ->
                showAdminProfile()
        );

        // CENTER - HEADING
        JPanel headingPanel = new JPanel();
        headingPanel.setOpaque(false);
        headingPanel.setLayout(
                new BoxLayout(
                        headingPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel mainHeading =
                new JLabel(
                        "PTA FUND RETURN MANAGEMENT SYSTEM"
                );

        mainHeading.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        24
                )
        );

        mainHeading.setForeground(Color.WHITE);
        mainHeading.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel dashboardHeading =
                new JLabel("ADMIN DASHBOARD");

        dashboardHeading.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        dashboardHeading.setForeground(
                new Color(200, 215, 240)
        );

        dashboardHeading.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        headingPanel.add(mainHeading);
        headingPanel.add(
                Box.createVerticalStrut(4)
        );
        headingPanel.add(dashboardHeading);

        // RIGHT - SETTINGS
        AnimatedHeaderButton settingsButton =
                new AnimatedHeaderButton(
                        "⚙  Settings"
                );

        settingsButton.addActionListener(e ->
                showSettings()
        );

        header.add(
                profileButton,
                BorderLayout.WEST
        );

        header.add(
                headingPanel,
                BorderLayout.CENTER
        );

        header.add(
                settingsButton,
                BorderLayout.EAST
        );

        background.add(
                header,
                BorderLayout.NORTH
        );


        // =========================
        // MAIN AREA
        // =========================

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(20, 20)
                );

        mainPanel.setOpaque(false);

        mainPanel.setBorder(
                new EmptyBorder(
                        5,
                        28,
                        25,
                        28
                )
        );


        // =========================
        // LEFT SIDEBAR
        // =========================

        RoundedPanel sidebar =
                new RoundedPanel(25);

        sidebar.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        235
                )
        );

        sidebar.setPreferredSize(
                new Dimension(220, 580)
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        sidebar.setBorder(
                new EmptyBorder(
                        20,
                        15,
                        20,
                        15
                )
        );


        JLabel menuTitle =
                new JLabel("NAVIGATION");

        menuTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        menuTitle.setForeground(
                new Color(120, 125, 140)
        );

        menuTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        sidebar.add(menuTitle);

        sidebar.add(
                Box.createVerticalStrut(15)
        );


        // Dashboard
        sidebar.add(
                createSideButton(
                        "⌂",
                        "Dashboard",
                        true
                )
        );

        sidebar.add(
                Box.createVerticalStrut(7)
        );


        // Student
        sidebar.add(
                createSideButton(
                        "♙",
                        "Students",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(7)
        );


        // Collection
        sidebar.add(
                createSideButton(
                        "₹",
                        "Fund Collection",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(7)
        );


        // Return
        sidebar.add(
                createSideButton(
                        "↩",
                        "Fund Return",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(7)
        );


        // Transactions
        sidebar.add(
                createSideButton(
                        "▤",
                        "Transactions",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(7)
        );


        // Reports
        sidebar.add(
                createSideButton(
                        "▥",
                        "Reports",
                        false
                )
        );


        sidebar.add(
                Box.createVerticalGlue()
        );


        // Logout
        JButton logout =
                createSideButton(
                        "⇥",
                        "Logout",
                        false
                );

        logout.addActionListener(e -> {

            int result =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to logout?",
                            "Confirm Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (result ==
                    JOptionPane.YES_OPTION) {

                dispose();
                new LoginFrame();
            }
        });

        sidebar.add(logout);


        // =========================
        // RIGHT CONTENT
        // =========================

        JPanel content =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        content.setOpaque(false);


        // =========================
        // WELCOME SECTION
        // =========================

        JPanel welcome =
                new JPanel(
                        new BorderLayout()
                );

        welcome.setOpaque(false);

        JPanel welcomeText =
                new JPanel();

        welcomeText.setOpaque(false);

        welcomeText.setLayout(
                new BoxLayout(
                        welcomeText,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel welcomeTitle =
                new JLabel(
                        "Welcome back, Administrator"
                );

        welcomeTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        welcomeTitle.setForeground(Color.WHITE);


        JLabel welcomeSubtitle =
                new JLabel(
                        "Here's what's happening with your PTA funds today."
                );

        welcomeSubtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        welcomeSubtitle.setForeground(
                new Color(
                        205,
                        215,
                        235
                )
        );


        welcomeText.add(welcomeTitle);

        welcomeText.add(
                Box.createVerticalStrut(4)
        );

        welcomeText.add(welcomeSubtitle);

        welcome.add(
                welcomeText,
                BorderLayout.WEST
        );


        // =========================
        // STATISTICS
        // =========================

        JPanel statistics =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                12,
                                0
                        )
                );

        statistics.setOpaque(false);


        statistics.add(
                createStatCard(
                        "STUDENTS",
                        "248",
                        "Total registered"
                )
        );

        statistics.add(
                createStatCard(
                        "COLLECTED",
                        "₹1,24,500",
                        "Total funds"
                )
        );

        statistics.add(
                createStatCard(
                        "RETURNED",
                        "₹48,750",
                        "Completed"
                )
        );

        statistics.add(
                createStatCard(
                        "PENDING",
                        "17",
                        "Return requests"
                )
        );


        // =========================
        // MANAGEMENT CARDS
        // =========================

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                2,
                                3,
                                14,
                                14
                        )
                );

        cards.setOpaque(false);


        cards.add(
                createManagementCard(
                        "♙",
                        "Student Management",
                        "Add, edit, search and manage student details."
                )
        );


        cards.add(
                createManagementCard(
                        "₹",
                        "Fund Collection",
                        "Record and manage PTA fund collections."
                )
        );


        cards.add(
                createManagementCard(
                        "↩",
                        "Fund Return",
                        "Process and track student fund returns."
                )
        );


        cards.add(
                createManagementCard(
                        "▤",
                        "Transactions",
                        "View complete collection and return history."
                )
        );


        cards.add(
                createManagementCard(
                        "▥",
                        "Reports",
                        "Generate and view PTA financial reports."
                )
        );


        cards.add(
                createManagementCard(
                        "🔎",
                        "Student Records",
                        "Search complete student information."
                )
        );


        // =========================
        // BOTTOM AREA
        // =========================

        JPanel bottom =
                new JPanel(
                        new BorderLayout(
                                12,
                                0
                        )
                );

        bottom.setOpaque(false);


        bottom.add(
                createRecentActivity(),
                BorderLayout.CENTER
        );

        bottom.add(
                createAlertCard(),
                BorderLayout.EAST
        );


        // =========================
        // CONTENT ADD
        // =========================

        JPanel upper =
                new JPanel(
                        new BorderLayout(0, 12)
                );

        upper.setOpaque(false);

        upper.add(
                welcome,
                BorderLayout.NORTH
        );

        upper.add(
                statistics,
                BorderLayout.CENTER
        );


        content.add(
                upper,
                BorderLayout.NORTH
        );

        content.add(
                cards,
                BorderLayout.CENTER
        );

        content.add(
                bottom,
                BorderLayout.SOUTH
        );


        // =========================
        // ADD MAIN CONTENT
        // =========================

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                content,
                BorderLayout.CENTER
        );


        background.add(
                mainPanel,
                BorderLayout.CENTER
        );


        add(background);

        setVisible(true);


        // =========================
        // WELCOME NOTIFICATION
        // =========================

        Timer timer =
                new Timer(
                        700,
                        e -> showNotification(
                                "WELCOME",
                                "Dashboard loaded successfully."
                        )
                );

        timer.setRepeats(false);
        timer.start();
    }


    // =====================================================
    // ADMIN PROFILE
    // =====================================================

    private void showAdminProfile() {

        JPanel panel =
                new JPanel();

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );


        JLabel name =
                new JLabel(
                        "Administrator"
                );

        name.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );


        JLabel role =
                new JLabel(
                        "System Administrator"
                );

        role.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );


        JLabel email =
                new JLabel(
                        "Email: admin@pta-system.com"
                );

        JLabel status =
                new JLabel(
                        "Status: Active"
                );


        panel.add(name);

        panel.add(
                Box.createVerticalStrut(5)
        );

        panel.add(role);

        panel.add(
                Box.createVerticalStrut(15)
        );

        panel.add(email);

        panel.add(
                Box.createVerticalStrut(5)
        );

        panel.add(status);


        JOptionPane.showMessageDialog(
                this,
                panel,
                "Admin Profile",
                JOptionPane.PLAIN_MESSAGE
        );
    }


    // =====================================================
    // SETTINGS
    // =====================================================

    private void showSettings() {

        JCheckBox notifications =
                new JCheckBox(
                        "Enable notifications",
                        true
                );

        JCheckBox animations =
                new JCheckBox(
                        "Enable animations",
                        true
                );

        JCheckBox alerts =
                new JCheckBox(
                        "Show system alerts",
                        true
                );


        JPanel panel =
                new JPanel();

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );


        JLabel title =
                new JLabel(
                        "Dashboard Settings"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16
                )
        );


        panel.add(title);

        panel.add(
                Box.createVerticalStrut(12)
        );

        panel.add(notifications);
        panel.add(animations);
        panel.add(alerts);


        JOptionPane.showMessageDialog(
                this,
                panel,
                "Settings",
                JOptionPane.PLAIN_MESSAGE
        );
    }


    // =====================================================
    // SIDEBAR BUTTON
    // =====================================================

    private JButton createSideButton(
            String icon,
            String text,
            boolean selected) {

        JButton button = new JButton(icon + "    " + text);

        button.setFont(
                new Font("SansSerif", Font.BOLD, 12)
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setMaximumSize(
                new Dimension(190, 46)
        );

        button.setPreferredSize(
                new Dimension(190, 46)
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setOpaque(false);

        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {

                        button.setFont(
                                new Font(
                                        "SansSerif",
                                        Font.BOLD,
                                        13
                                )
                        );

                        button.repaint();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                        button.setFont(
                                new Font(
                                        "SansSerif",
                                        Font.BOLD,
                                        12
                                )
                        );

                        button.repaint();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                        button.setLocation(
                                button.getX() + 2,
                                button.getY()
                        );
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                        button.setLocation(
                                button.getX() - 2,
                                button.getY()
                        );
                    }
                }
        );

        button.addActionListener(e ->
                showNotification(
                        text.toUpperCase(),
                        "Opening " +
                                text.toLowerCase() +
                                "..."
                )
        );

        return button;
    }
    // =====================================================
    // STAT CARD
    // =====================================================

    private JPanel createStatCard(
            String title,
            String value,
            String description) {

        RoundedPanel card =
                new RoundedPanel(20);

        card.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        235
                )
        );

        card.setLayout(
                new BorderLayout()
        );

        card.setBorder(
                new EmptyBorder(
                        12,
                        15,
                        12,
                        15
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        10
                )
        );

        titleLabel.setForeground(
                new Color(
                        110,
                        115,
                        130
                )
        );


        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        valueLabel.setForeground(
                new Color(
                        40,
                        60,
                        110
                )
        );


        JLabel descLabel =
                new JLabel(description);

        descLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10
                )
        );

        descLabel.setForeground(
                new Color(
                        130,
                        135,
                        145
                )
        );


        JPanel text =
                new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS
                )
        );


        text.add(titleLabel);

        text.add(
                Box.createVerticalStrut(3)
        );

        text.add(valueLabel);

        text.add(
                Box.createVerticalStrut(2)
        );

        text.add(descLabel);


        card.add(
                text,
                BorderLayout.CENTER
        );


        addHoverEffect(card);


        return card;
    }


    // =====================================================
    // MANAGEMENT CARD
    // =====================================================

    private JPanel createManagementCard(
            String icon,
            String title,
            String description) {

        RoundedPanel card =
                new RoundedPanel(22);

        card.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        235
                )
        );

        card.setLayout(
                new BorderLayout(
                        12,
                        0
                )
        );

        card.setBorder(
                new EmptyBorder(
                        15,
                        17,
                        15,
                        17
                )
        );


        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        iconLabel.setForeground(
                new Color(
                        55,
                        90,
                        175
                )
        );


        JPanel text =
                new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        titleLabel.setForeground(
                new Color(
                        40,
                        55,
                        85
                )
        );


        JLabel descLabel =
                new JLabel(
                        "<html>" +
                                description +
                                "</html>"
                );

        descLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10
                )
        );

        descLabel.setForeground(
                new Color(
                        115,
                        120,
                        135
                )
        );


        text.add(titleLabel);

        text.add(
                Box.createVerticalStrut(5)
        );

        text.add(descLabel);


        card.add(
                iconLabel,
                BorderLayout.WEST
        );

        card.add(
                text,
                BorderLayout.CENTER
        );


        addHoverEffect(card);


        card.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            MouseEvent e) {

                        showNotification(
                                title.toUpperCase(),
                                "Opening " +
                                        title.toLowerCase() +
                                        "..."
                        );
                    }
                }
        );


        return card;
    }


    // =====================================================
    // RECENT ACTIVITY
    // =====================================================

    private JPanel createRecentActivity() {

        RoundedPanel panel =
                new RoundedPanel(20);

        panel.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        235
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        12,
                        15,
                        12,
                        15
                )
        );


        JLabel title =
                new JLabel(
                        "RECENT ACTIVITY"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        title.setForeground(
                new Color(
                        70,
                        75,
                        95
                )
        );


        JLabel activity =
                new JLabel(
                        "•  Student records updated    •  Fund collection recorded    •  Return request received"
                );

        activity.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10
                )
        );

        activity.setForeground(
                new Color(
                        120,
                        125,
                        140
                )
        );


        panel.setLayout(
                new BorderLayout(
                        0,
                        7
                )
        );

        panel.add(
                title,
                BorderLayout.NORTH
        );

        panel.add(
                activity,
                BorderLayout.CENTER
        );


        return panel;
    }


    // =====================================================
    // ALERT CARD
    // =====================================================

    private JPanel createAlertCard() {

        RoundedPanel panel =
                new RoundedPanel(20);

        panel.setPreferredSize(
                new Dimension(
                        245,
                        75
                )
        );

        panel.setBackground(
                new Color(
                        255,
                        245,
                        235,
                        245
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        12,
                        15,
                        12,
                        15
                )
        );

        panel.setLayout(
                new BorderLayout(
                        10,
                        0
                )
        );


        JLabel icon =
                new JLabel("!");

        icon.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        25
                )
        );

        icon.setForeground(
                new Color(
                        205,
                        100,
                        60
                )
        );


        JLabel text =
                new JLabel(
                        "<html><b>17 Pending Returns</b><br>" +
                                "Requires attention</html>"
                );

        text.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10
                )
        );


        panel.add(
                icon,
                BorderLayout.WEST
        );

        panel.add(
                text,
                BorderLayout.CENTER
        );


        // Pulse animation

        Timer pulse =
                new Timer(
                        600,
                        e -> {

                            if (
                                    icon.getFont()
                                            .getSize()
                                            == 25
                            ) {

                                icon.setFont(
                                        new Font(
                                                "SansSerif",
                                                Font.BOLD,
                                                30
                                        )
                                );

                            } else {

                                icon.setFont(
                                        new Font(
                                                "SansSerif",
                                                Font.BOLD,
                                                25
                                        )
                                );
                            }

                            icon.repaint();
                        }
                );

        pulse.start();


        return panel;
    }


    // =====================================================
    // HOVER EFFECT
    // =====================================================

    private void addHoverEffect(
            JPanel panel) {

        panel.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        panel.setBackground(
                                new Color(
                                        245,
                                        248,
                                        255
                                )
                        );

                        panel.repaint();
                    }


                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        panel.setBackground(
                                new Color(
                                        255,
                                        255,
                                        255,
                                        235
                                )
                        );

                        panel.repaint();
                    }
                }
        );
    }


    // =====================================================
    // NOTIFICATION
    // =====================================================

    private void showNotification(
            String heading,
            String message) {

        JWindow window =
                new JWindow();


        RoundedPanel panel =
                new RoundedPanel(18);

        panel.setBackground(
                new Color(
                        25,
                        35,
                        60,
                        250
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        12,
                        15,
                        12,
                        15
                )
        );

        panel.setLayout(
                new BorderLayout(
                        10,
                        0
                )
        );


        JLabel icon =
                new JLabel("✓");

        icon.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        icon.setForeground(
                new Color(
                        120,
                        255,
                        180
                )
        );


        JPanel text =
                new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel title =
                new JLabel(heading);

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        title.setForeground(Color.WHITE);


        JLabel msg =
                new JLabel(message);

        msg.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10
                )
        );

        msg.setForeground(
                new Color(
                        205,
                        215,
                        230
                )
        );


        text.add(title);

        text.add(
                Box.createVerticalStrut(3)
        );

        text.add(msg);


        panel.add(
                icon,
                BorderLayout.WEST
        );

        panel.add(
                text,
                BorderLayout.CENTER
        );


        window.add(panel);

        window.setSize(
                320,
                70
        );


        Point location =
                getLocationOnScreen();


        window.setLocation(
                location.x +
                        getWidth() -
                        345,

                location.y +
                        85
        );


        window.setOpacity(0f);

        window.setVisible(true);


        Timer fadeIn =
                new Timer(
                        30,
                        null
                );


        fadeIn.addActionListener(
                new ActionListener() {

                    float opacity = 0f;

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        opacity += 0.08f;

                        if (opacity >= 1f) {

                            opacity = 1f;

                            fadeIn.stop();
                        }

                        window.setOpacity(
                                opacity
                        );
                    }
                }
        );


        fadeIn.start();


        Timer close =
                new Timer(
                        2800,
                        e -> {

                            Timer fadeOut =
                                    new Timer(
                                            30,
                                            null
                                    );

                            fadeOut.addActionListener(
                                    new ActionListener() {

                                        float opacity = 1f;

                                        @Override
                                        public void actionPerformed(
                                                ActionEvent e) {

                                            opacity -=
                                                    0.08f;

                                            if (
                                                    opacity <=
                                                            0f
                                            ) {

                                                fadeOut.stop();

                                                window.dispose();

                                            } else {

                                                window.setOpacity(
                                                        opacity
                                                );
                                            }
                                        }
                                    }
                            );

                            fadeOut.start();
                        }
                );


        close.setRepeats(false);

        close.start();
    }


    // =====================================================
    // ROUNDED PANEL
    // =====================================================

    static class RoundedPanel
            extends JPanel {

        private int radius;

        public RoundedPanel(
                int radius) {

            this.radius = radius;

            setOpaque(false);
        }


        @Override
        protected void paintComponent(
                Graphics g) {

            Graphics2D g2 =
                    (Graphics2D)
                            g.create();


            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );


            g2.setColor(
                    getBackground()
            );


            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    radius,
                    radius
            );


            g2.dispose();


            super.paintComponent(g);
        }
    }


    // =====================================================
    // HEADER BUTTON
    // =====================================================
    static class AnimatedHeaderButton
    extends JButton {

private boolean hovering = false;

public AnimatedHeaderButton(String text) {

    super(text);

    setFont(
            new Font(
                    "SansSerif",
                    Font.BOLD,
                    12
            )
    );

    setForeground(Color.WHITE);

    setFocusPainted(false);
    setBorderPainted(false);
    setContentAreaFilled(false);

    setOpaque(false);

    setPreferredSize(
            new Dimension(150, 44)
    );

    setCursor(
            new Cursor(
                    Cursor.HAND_CURSOR
            )
    );

    addMouseListener(
            new MouseAdapter() {

                @Override
                public void mouseEntered(
                        MouseEvent e) {

                    hovering = true;

                    setFont(
                            new Font(
                                    "SansSerif",
                                    Font.BOLD,
                                    13
                            )
                    );

                    repaint();
                }

                @Override
                public void mouseExited(
                        MouseEvent e) {

                    hovering = false;

                    setFont(
                            new Font(
                                    "SansSerif",
                                    Font.BOLD,
                                    12
                            )
                    );

                    repaint();
                }

                @Override
                public void mousePressed(
                        MouseEvent e) {

                    setLocation(
                            getX(),
                            getY() + 2
                    );
                }

                @Override
                public void mouseReleased(
                        MouseEvent e) {

                    setLocation(
                            getX(),
                            getY() - 2
                    );
                }
            }
    );
}

@Override
protected void paintComponent(
        Graphics g) {

    Graphics2D g2 =
            (Graphics2D) g.create();

    g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
    );

    if (hovering) {

        g2.setColor(
                new Color(
                        255,
                        255,
                        255,
                        75
                )
        );

    } else {

        g2.setColor(
                new Color(
                        255,
                        255,
                        255,
                        35
                )
        );
    }

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
 
    // =====================================================
    // ANIMATED BACKGROUND
    // =====================================================

    static class AnimatedBackground
            extends JPanel {

        ArrayList<Particle> particles =
                new ArrayList<>();

        Random random =
                new Random();


        public AnimatedBackground() {

            setBackground(
                    new Color(
                            12,
                            22,
                            50
                    )
            );


            for (
                    int i = 0;
                    i < 75;
                    i++
            ) {

                particles.add(
                        new Particle(
                                random.nextInt(
                                        1150
                                ),

                                random.nextInt(
                                        720
                                ),

                                1 +
                                        random.nextInt(
                                                4
                                        )
                        )
                );
            }


            Timer timer =
                    new Timer(
                            25,
                            e -> {

                                for (
                                        Particle p :
                                        particles
                                ) {

                                    p.x +=
                                            p.dx;

                                    p.y +=
                                            p.dy;


                                    if (
                                            p.x <
                                                    0 ||
                                                    p.x >
                                                            getWidth()
                                    ) {

                                        p.dx =
                                                -p.dx;
                                    }


                                    if (
                                            p.y <
                                                    0 ||
                                                    p.y >
                                                            getHeight()
                                    ) {

                                        p.dy =
                                                -p.dy;
                                    }
                                }


                                repaint();
                            }
                    );


            timer.start();
        }


        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);


            Graphics2D g2 =
                    (Graphics2D)
                            g.create();


            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );


            // Particles

            for (
                    Particle p :
                    particles
            ) {

                g2.setColor(
                        new Color(
                                255,
                                255,
                                255,
                                65
                        )
                );


                g2.fill(
                        new Ellipse2D.Double(
                                p.x,
                                p.y,
                                p.size,
                                p.size
                        )
                );
            }


            // Connecting lines

            for (
                    int i = 0;
                    i < particles.size();
                    i++
            ) {

                for (
                        int j = i + 1;
                        j < particles.size();
                        j++
                ) {

                    Particle p1 =
                            particles.get(i);

                    Particle p2 =
                            particles.get(j);


                    double distance =
                            Math.sqrt(
                                    Math.pow(
                                            p1.x -
                                                    p2.x,
                                            2
                                    )
                                            +
                                            Math.pow(
                                                    p1.y -
                                                            p2.y,
                                                    2
                                            )
                            );


                    if (
                            distance <
                                    105
                    ) {

                        g2.setColor(
                                new Color(
                                        255,
                                        255,
                                        255,
                                        15
                                )
                        );


                        g2.drawLine(
                                (int) p1.x,
                                (int) p1.y,
                                (int) p2.x,
                                (int) p2.y
                        );
                    }
                }
            }


            g2.dispose();
        }
    }


    // =====================================================
    // PARTICLE
    // =====================================================

    static class Particle {

        double x;
        double y;

        double dx;
        double dy;

        double size;


        public Particle(
                double x,
                double y,
                double size) {

            this.x = x;

            this.y = y;

            this.size = size;


            dx =
                    -0.35 +
                            Math.random()
                                    * 0.7;

            dy =
                    -0.35 +
                            Math.random()
                                    * 0.7;
        }
    }


    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                () -> new DashboardFrame()
        );
    }
}
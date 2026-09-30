package pta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class ReportsFrame extends JFrame {

    public ReportsFrame() {

        setTitle("PTA Fund Management - Reports");
        setSize(1250, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        EducationBackground background = new EducationBackground();
        background.setLayout(null);
        setContentPane(background);

        // ================= HEADER =================

        JLabel title = new JLabel("Reports & Analytics");
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setBounds(45, 25, 500, 45);
        background.add(title);

        JLabel subtitle = new JLabel(
                "Monitor PTA funds, payments and student transactions"
        );
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(new Color(230, 240, 255));
        subtitle.setBounds(48, 70, 600, 30);
        background.add(subtitle);

        // ================= MAIN CARD =================

        RoundedPanel mainCard = new RoundedPanel(35);
        mainCard.setLayout(null);
        mainCard.setBackground(new Color(255, 255, 255, 235));
        mainCard.setBounds(35, 115, 1180, 555);
        background.add(mainCard);

        // ================= STAT CARDS =================

        StatCard studentsCard = new StatCard(
                "TOTAL STUDENTS",
                "125",
                "Registered Students"
        );
        studentsCard.setBounds(30, 25, 250, 105);
        mainCard.add(studentsCard);

        StatCard collectedCard = new StatCard(
                "TOTAL COLLECTED",
                "₹62,500",
                "Fund Collected"
        );
        collectedCard.setBounds(295, 25, 250, 105);
        mainCard.add(collectedCard);

        StatCard returnedCard = new StatCard(
                "TOTAL RETURNED",
                "₹8,500",
                "Fund Returned"
        );
        returnedCard.setBounds(560, 25, 250, 105);
        mainCard.add(returnedCard);

        StatCard pendingCard = new StatCard(
                "PENDING AMOUNT",
                "₹14,000",
                "Amount Pending"
        );
        pendingCard.setBounds(825, 25, 300, 105);
        mainCard.add(pendingCard);

        // ================= SUMMARY PANEL =================

        RoundedPanel summary = new RoundedPanel(25);
        summary.setLayout(null);
        summary.setBackground(new Color(247, 249, 253));
        summary.setBounds(30, 150, 550, 275);
        mainCard.add(summary);

        JLabel summaryTitle = new JLabel("Fund Summary");
        summaryTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 21)
        );
        summaryTitle.setForeground(
                new Color(40, 45, 60)
        );
        summaryTitle.setBounds(25, 18, 250, 35);
        summary.add(summaryTitle);

        JLabel totalLabel = new JLabel("Total PTA Fund");
        totalLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );
        totalLabel.setBounds(25, 65, 180, 25);
        summary.add(totalLabel);

        JLabel totalValue = new JLabel("₹85,000");
        totalValue.setFont(
                new Font("Segoe UI", Font.BOLD, 18)
        );
        totalValue.setBounds(400, 65, 120, 25);
        summary.add(totalValue);

        ProgressBar totalBar = new ProgressBar(100);
        totalBar.setBounds(25, 92, 495, 10);
        summary.add(totalBar);

        JLabel collectedLabel = new JLabel("Collected");
        collectedLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );
        collectedLabel.setBounds(25, 125, 180, 25);
        summary.add(collectedLabel);

        JLabel collectedValue = new JLabel("₹62,500");
        collectedValue.setFont(
                new Font("Segoe UI", Font.BOLD, 17)
        );
        collectedValue.setBounds(400, 125, 120, 25);
        summary.add(collectedValue);

        ProgressBar collectedBar = new ProgressBar(73);
        collectedBar.setBounds(25, 152, 495, 10);
        summary.add(collectedBar);

        JLabel returnedLabel = new JLabel("Returned");
        returnedLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );
        returnedLabel.setBounds(25, 185, 180, 25);
        summary.add(returnedLabel);

        JLabel returnedValue = new JLabel("₹8,500");
        returnedValue.setFont(
                new Font("Segoe UI", Font.BOLD, 17)
        );
        returnedValue.setBounds(400, 185, 120, 25);
        summary.add(returnedValue);

        ProgressBar returnedBar = new ProgressBar(10);
        returnedBar.setBounds(25, 212, 495, 10);
        summary.add(returnedBar);

        // ================= STUDENT STATISTICS =================

        RoundedPanel studentStats = new RoundedPanel(25);
        studentStats.setLayout(null);
        studentStats.setBackground(new Color(247, 249, 253));
        studentStats.setBounds(605, 150, 520, 275);
        mainCard.add(studentStats);

        JLabel studentTitle = new JLabel("Student Payment Status");
        studentTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 21)
        );
        studentTitle.setForeground(
                new Color(40, 45, 60)
        );
        studentTitle.setBounds(25, 18, 300, 35);
        studentStats.add(studentTitle);

        JLabel paid = new JLabel("Paid Students");
        paid.setFont(
                new Font("Segoe UI", Font.PLAIN, 15)
        );
        paid.setBounds(30, 70, 200, 30);
        studentStats.add(paid);

        JLabel paidNumber = new JLabel("85");
        paidNumber.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );
        paidNumber.setBounds(425, 70, 60, 30);
        studentStats.add(paidNumber);

        ProgressBar paidBar = new ProgressBar(68);
        paidBar.setBounds(30, 105, 455, 10);
        studentStats.add(paidBar);

        JLabel pending = new JLabel("Pending Students");
        pending.setFont(
                new Font("Segoe UI", Font.PLAIN, 15)
        );
        pending.setBounds(30, 140, 200, 30);
        studentStats.add(pending);

        JLabel pendingNumber = new JLabel("30");
        pendingNumber.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );
        pendingNumber.setBounds(425, 140, 60, 30);
        studentStats.add(pendingNumber);

        ProgressBar pendingBar = new ProgressBar(24);
        pendingBar.setBounds(30, 175, 455, 10);
        studentStats.add(pendingBar);

        JLabel returnedStudents = new JLabel("Returned Fund Students");
        returnedStudents.setFont(
                new Font("Segoe UI", Font.PLAIN, 15)
        );
        returnedStudents.setBounds(30, 210, 220, 30);
        studentStats.add(returnedStudents);

        JLabel returnedNumber = new JLabel("10");
        returnedNumber.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );
        returnedNumber.setBounds(425, 210, 60, 30);
        studentStats.add(returnedNumber);

        ProgressBar returnedStudentBar = new ProgressBar(8);
        returnedStudentBar.setBounds(30, 245, 455, 10);
        studentStats.add(returnedStudentBar);

        // ================= TRANSACTION SUMMARY =================

        RoundedPanel transactionPanel = new RoundedPanel(25);
        transactionPanel.setLayout(null);
        transactionPanel.setBackground(new Color(247, 249, 253));
        transactionPanel.setBounds(30, 440, 550, 75);
        mainCard.add(transactionPanel);

        JLabel transactionTitle = new JLabel(
                "Total Transactions"
        );
        transactionTitle.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );
        transactionTitle.setBounds(25, 15, 200, 25);
        transactionPanel.add(transactionTitle);

        JLabel transactionNumber = new JLabel("158");
        transactionNumber.setFont(
                new Font("Segoe UI", Font.BOLD, 25)
        );
        transactionNumber.setBounds(25, 38, 100, 30);
        transactionPanel.add(transactionNumber);

        JLabel collectionText = new JLabel(
                "Collections: 125"
        );
        collectionText.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );
        collectionText.setBounds(220, 20, 140, 25);
        transactionPanel.add(collectionText);

        JLabel returnText = new JLabel(
                "Returns: 33"
        );
        returnText.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );
        returnText.setBounds(390, 20, 120, 25);
        transactionPanel.add(returnText);

        // ================= GENERATE BUTTON =================

        OvalButton generateButton =
                new OvalButton("GENERATE REPORT");

        generateButton.setBounds(
                620,
                450,
                190,
                45
        );

        mainCard.add(generateButton);

        // ================= CLEAR BUTTON =================

        OvalButton clearButton =
                new OvalButton("CLEAR");

        clearButton.setBounds(
                825,
                450,
                120,
                45
        );

        mainCard.add(clearButton);

        // ================= CLOSE BUTTON =================

        OvalButton closeButton =
                new OvalButton("CLOSE");

        closeButton.setBounds(
                960,
                450,
                120,
                45
        );

        mainCard.add(closeButton);

        // ================= GENERATE ACTION =================

        generateButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JOptionPane.showMessageDialog(
                                ReportsFrame.this,
                                "Report generated successfully!\n\n"
                                + "Total Students: 125\n"
                                + "Total Collected: ₹62,500\n"
                                + "Total Returned: ₹8,500\n"
                                + "Pending Amount: ₹14,000",
                                "Report Generated",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
        );

        // ================= CLEAR ACTION =================

        clearButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JOptionPane.showMessageDialog(
                                ReportsFrame.this,
                                "Report view cleared."
                        );
                    }
                }
        );

        // ================= CLOSE ACTION =================

        closeButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                }
        );

        setVisible(true);
    }

    // =====================================================
    // STAT CARD
    // =====================================================

    static class StatCard extends JPanel {

        private String title;
        private String value;
        private String description;

        public StatCard(
                String title,
                String value,
                String description) {

            this.title = title;
            this.value = value;
            this.description = description;

            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(
                    new Color(247, 249, 253)
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
                    new Color(75, 105, 180)
            );

            g2.fillRoundRect(
                    0,
                    0,
                    6,
                    getHeight(),
                    6,
                    6
            );

            g2.setColor(
                    new Color(100, 105, 120)
            );

            g2.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            11
                    )
            );

            g2.drawString(
                    title,
                    20,
                    25
            );

            g2.setColor(
                    new Color(35, 40, 55)
            );

            g2.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            23
                    )
            );

            g2.drawString(
                    value,
                    20,
                    55
            );

            g2.setColor(
                    new Color(130, 135, 150)
            );

            g2.setFont(
                    new Font(
                            "Segoe UI",
                            Font.PLAIN,
                            11
                    )
            );

            g2.drawString(
                    description,
                    20,
                    80
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =====================================================
    // PROGRESS BAR
    // =====================================================

    static class ProgressBar extends JPanel {

        private int percentage;

        public ProgressBar(int percentage) {

            this.percentage = percentage;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int width = getWidth();
            int height = getHeight();

            g2.setColor(
                    new Color(220, 225, 235)
            );

            g2.fillRoundRect(
                    0,
                    0,
                    width,
                    height,
                    height,
                    height
            );

            int filled =
                    width * percentage / 100;

            g2.setColor(
                    new Color(75, 105, 180)
            );

            g2.fillRoundRect(
                    0,
                    0,
                    filled,
                    height,
                    height,
                    height
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =====================================================
    // OVAL BUTTON
    // =====================================================

    static class OvalButton extends JButton {

        private float scale = 1.0f;
        private boolean hover = false;

        public OvalButton(String text) {

            super(text);

            setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            13
                    )
            );

            setForeground(Color.WHITE);

            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);

            setCursor(
                    new Cursor(Cursor.HAND_CURSOR)
            );

            addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mouseEntered(
                                MouseEvent e) {

                            hover = true;
                            scale = 1.05f;
                            repaint();
                        }

                        @Override
                        public void mouseExited(
                                MouseEvent e) {

                            hover = false;
                            scale = 1.0f;
                            repaint();
                        }

                        @Override
                        public void mousePressed(
                                MouseEvent e) {

                            scale = 0.96f;
                            repaint();
                        }

                        @Override
                        public void mouseReleased(
                                MouseEvent e) {

                            scale =
                                    hover ? 1.05f : 1.0f;

                            repaint();
                        }
                    }
            );
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int w = getWidth();
            int h = getHeight();

            int newW =
                    (int) (w * scale);

            int newH =
                    (int) (h * scale);

            int x =
                    (w - newW) / 2;

            int y =
                    (h - newH) / 2;

            if (hover) {

                g2.setColor(
                        new Color(60, 120, 220)
                );

            } else {

                g2.setColor(
                        new Color(75, 105, 180)
                );
            }

            g2.fillRoundRect(
                    x,
                    y,
                    newW,
                    newH,
                    newH,
                    newH
            );

            FontMetrics fm =
                    g2.getFontMetrics(
                            getFont()
                    );

            int textX =
                    (w - fm.stringWidth(
                            getText()
                    )) / 2;

            int textY =
                    (h - fm.getHeight()) / 2
                            + fm.getAscent();

            g2.setColor(Color.WHITE);

            g2.setFont(getFont());

            g2.drawString(
                    getText(),
                    textX,
                    textY
            );

            g2.dispose();
        }
    }

    // =====================================================
    // ROUNDED PANEL
    // =====================================================

    static class RoundedPanel extends JPanel {

        private int radius;

        public RoundedPanel(int radius) {

            this.radius = radius;
            setOpaque(false);
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

            g2.setColor(getBackground());

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
    // EDUCATION BACKGROUND
    // =====================================================

    static class EducationBackground
            extends JPanel {

        private Random random =
                new Random();

        private int[] x = new int[40];
        private int[] y = new int[40];
        private int[] speed = new int[40];

        public EducationBackground() {

            setOpaque(true);

            for (int i = 0;
                 i < x.length;
                 i++) {

                x[i] =
                        random.nextInt(1250);

                y[i] =
                        random.nextInt(750);

                speed[i] =
                        1 + random.nextInt(2);
            }

            Timer timer =
                    new Timer(
                            35,
                            new ActionListener() {

                                @Override
                                public void actionPerformed(
                                        ActionEvent e) {

                                    for (int i = 0;
                                         i < y.length;
                                         i++) {

                                        y[i] -=
                                                speed[i];

                                        if (y[i] < -10) {

                                            y[i] =
                                                    getHeight()
                                                            + 10;

                                            x[i] =
                                                    random.nextInt(
                                                            Math.max(
                                                                    getWidth(),
                                                                    1
                                                            )
                                                    );
                                        }
                                    }

                                    repaint();
                                }
                            }
                    );

            timer.start();
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int width =
                    getWidth();

            int height =
                    getHeight();

            // Gradient background

            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            new Color(35, 70, 140),
                            width,
                            height,
                            new Color(100, 65, 155)
                    );

            g2.setPaint(gradient);

            g2.fillRect(
                    0,
                    0,
                    width,
                    height
            );

            // Large decorative circles

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            20
                    )
            );

            g2.fillOval(
                    -120,
                    400,
                    380,
                    380
            );

            g2.fillOval(
                    970,
                    -130,
                    380,
                    380
            );

            // Floating particles

            for (int i = 0;
                 i < x.length;
                 i++) {

                g2.setColor(
                        new Color(
                                255,
                                255,
                                255,
                                75
                        )
                );

                int size =
                        3 + random.nextInt(4);

                g2.fillOval(
                        x[i],
                        y[i],
                        size,
                        size
                );
            }

            // Graduation cap

            int capX = 1080;
            int capY = 80;

            Polygon cap =
                    new Polygon();

            cap.addPoint(
                    capX,
                    capY
            );

            cap.addPoint(
                    capX + 90,
                    capY + 25
            );

            cap.addPoint(
                    capX,
                    capY + 50
            );

            cap.addPoint(
                    capX - 90,
                    capY + 25
            );

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            170
                    )
            );

            g2.fillPolygon(cap);

            g2.fillRect(
                    capX - 45,
                    capY + 35,
                    90,
                    15
            );

            // Open book

            int bx = 75;
            int by = 610;

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            130
                    )
            );

            g2.fillRoundRect(
                    bx,
                    by,
                    125,
                    70,
                    15,
                    15
            );

            g2.setColor(
                    new Color(
                            35,
                            70,
                            140
                    )
            );

            g2.drawLine(
                    bx + 62,
                    by + 5,
                    bx + 62,
                    by + 65
            );

            // Decorative lines

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            60
                    )
            );

            g2.drawRoundRect(
                    1020,
                    500,
                    150,
                    80,
                    20,
                    20
            );

            g2.drawRoundRect(
                    1060,
                    530,
                    120,
                    60,
                    20,
                    20
            );

            g2.dispose();
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {
                        new ReportsFrame();
                    }
                }
        );
    }
}
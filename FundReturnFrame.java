package pta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class FundReturnFrame extends JFrame {

    private EducationBackground background;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FundReturnFrame();
            }
        });
    }

    public FundReturnFrame() {

        setTitle("PTA Fund Return");
        setSize(1100, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background = new EducationBackground();
        background.setLayout(new BorderLayout());

        // ==============================
        // HEADER
        // ==============================

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(
                new BoxLayout(header, BoxLayout.Y_AXIS)
        );

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 50, 15, 50
                )
        );

        JLabel title = new JLabel("Fund Return");

        title.setFont(
                new Font("Arial", Font.BOLD, 36)
        );

        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel(
                "PTA Fund Return Management"
        );

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        subtitle.setForeground(
                new Color(230, 235, 245)
        );

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);

        background.add(
                header,
                BorderLayout.NORTH
        );

        // ==============================
        // MAIN CARD
        // ==============================

        RoundedPanel card =
                new RoundedPanel(
                        35,
                        new Color(255, 255, 255, 235)
                );

        card.setLayout(
                new GridLayout(
                        8,
                        2,
                        20,
                        16
                )
        );

        card.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        45,
                        30,
                        45
                )
        );

        // Student ID
        card.add(label("Student ID"));

        RoundedField studentId =
                new RoundedField(
                        "Enter student ID"
                );

        card.add(studentId);

        // Student Name
        card.add(label("Student Name"));

        RoundedField studentName =
                new RoundedField(
                        "Enter student name"
                );

        card.add(studentName);

        // Total Fund
        card.add(label("Total PTA Fund"));

        RoundedField totalFund =
                new RoundedField(
                        "₹ 0.00"
                );

        card.add(totalFund);

        // Amount Paid
        card.add(label("Amount Paid"));

        RoundedField amountPaid =
                new RoundedField(
                        "₹ 0.00"
                );

        card.add(amountPaid);

        // Amount Returned
        card.add(label("Amount Returned"));

        RoundedField amountReturned =
                new RoundedField(
                        "₹ 0.00"
                );

        card.add(amountReturned);

        // Return Date
        card.add(label("Return Date"));

        RoundedField returnDate =
                new RoundedField(
                        "DD / MM / YYYY"
                );

        card.add(returnDate);

        // Transaction ID
        card.add(label("Transaction ID"));

        RoundedField transactionId =
                new RoundedField(
                        "Enter transaction ID"
                );

        card.add(transactionId);

        // Status
        card.add(label("Return Status"));

        RoundedCombo status =
                new RoundedCombo(
                        new String[]{
                                "Pending",
                                "Returned",
                                "Partially Returned"
                        }
                );

        card.add(status);

        // ==============================
        // CENTER
        // ==============================

        JPanel center = new JPanel(
                new GridBagLayout()
        );

        center.setOpaque(false);

        center.add(card);

        background.add(
                center,
                BorderLayout.CENTER
        );

        // ==============================
        // BUTTONS
        // ==============================

        JPanel buttons = new JPanel();

        buttons.setOpaque(false);

        buttons.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        30,
                        30,
                        30
                )
        );

        OvalButton clear =
                new OvalButton("CLEAR");

        OvalButton close =
                new OvalButton("CLOSE");

        OvalButton returnFund =
                new OvalButton("RETURN FUND");

        buttons.add(clear);
        buttons.add(close);
        buttons.add(returnFund);

        background.add(
                buttons,
                BorderLayout.SOUTH
        );

        // ==============================
        // RETURN
        // ==============================

        returnFund.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        if (
                                studentId.getValue().isEmpty()
                                ||
                                studentName.getValue().isEmpty()
                                ||
                                amountReturned.getValue().isEmpty()
                        ) {

                            JOptionPane.showMessageDialog(
                                    FundReturnFrame.this,
                                    "Please enter the required details.",
                                    "Missing Information",
                                    JOptionPane.WARNING_MESSAGE
                            );

                        } else {

                            JOptionPane.showMessageDialog(
                                    FundReturnFrame.this,
                                    "Fund return recorded successfully!",
                                    "Success",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                }
        );

        // ==============================
        // CLEAR
        // ==============================

        clear.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        studentId.clear();
                        studentName.clear();
                        totalFund.clear();
                        amountPaid.clear();
                        amountReturned.clear();
                        returnDate.clear();
                        transactionId.clear();

                        status.setSelectedIndex(0);
                    }
                }
        );

        // ==============================
        // CLOSE
        // ==============================

        close.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        dispose();
                    }
                }
        );

        setContentPane(background);

        setVisible(true);
    }

    // =================================
    // LABEL
    // =================================

    private JLabel label(String text) {

        JLabel label = new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(
                new Color(45, 50, 60)
        );

        return label;
    }

    // =================================
    // OVAL INPUT FIELD
    // =================================

    static class RoundedField extends JTextField {

        private String placeholder;
        private boolean hover = false;

        public RoundedField(
                String placeholder
        ) {

            this.placeholder = placeholder;

            setText(placeholder);

            setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            14
                    )
            );

            setForeground(
                    new Color(
                            135,
                            140,
                            150
                    )
            );

            setOpaque(false);

            setBorder(
                    BorderFactory.createEmptyBorder(
                            10,
                            20,
                            10,
                            20
                    )
            );

            addFocusListener(
                    new FocusAdapter() {

                        public void focusGained(
                                FocusEvent e
                        ) {

                            if (
                                    getText().equals(
                                            placeholder
                                    )
                            ) {

                                setText("");

                                setForeground(
                                        new Color(
                                                40,
                                                45,
                                                55
                                        )
                                );
                            }
                        }

                        public void focusLost(
                                FocusEvent e
                        ) {

                            if (
                                    getText().trim().isEmpty()
                            ) {

                                setText(placeholder);

                                setForeground(
                                        new Color(
                                                135,
                                                140,
                                                150
                                        )
                                );
                            }
                        }
                    }
            );

            addMouseListener(
                    new MouseAdapter() {

                        public void mouseEntered(
                                MouseEvent e
                        ) {

                            hover = true;
                            repaint();
                        }

                        public void mouseExited(
                                MouseEvent e
                        ) {

                            hover = false;
                            repaint();
                        }
                    }
            );
        }

        public String getValue() {

            if (
                    getText().equals(
                            placeholder
                    )
            ) {

                return "";
            }

            return getText().trim();
        }

        public void clear() {

            setText(placeholder);

            setForeground(
                    new Color(
                            135,
                            140,
                            150
                    )
            );
        }

        protected void paintComponent(
                Graphics g
        ) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            if (hover) {

                g2.setColor(
                        new Color(
                                240,
                                247,
                                255
                        )
                );

            } else {

                g2.setColor(
                        new Color(
                                248,
                                249,
                                252
                        )
                );
            }

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    50,
                    50
            );

            g2.setColor(
                    new Color(
                            215,
                            220,
                            230
                    )
            );

            g2.drawRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    50,
                    50
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =================================
    // OVAL COMBO BOX
    // =================================

    static class RoundedCombo
            extends JComboBox<String> {

        public RoundedCombo(
                String[] items
        ) {

            super(items);

            setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            14
                    )
            );

            setForeground(
                    new Color(
                            40,
                            45,
                            55
                    )
            );

            setBackground(
                    new Color(
                            248,
                            249,
                            252
                    )
            );

            setBorder(
                    BorderFactory.createEmptyBorder(
                            8,
                            15,
                            8,
                            15
                    )
            );

            setFocusable(false);
        }
    }

    // =================================
    // OVAL BUTTON
    // =================================

    static class OvalButton
            extends JButton {

        private boolean hover = false;
        private boolean pressed = false;

        public OvalButton(
                String text
        ) {

            super(text);

            setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            13
                    )
            );

            setForeground(Color.WHITE);

            setBackground(
                    new Color(
                            0,
                            122,
                            255
                    )
            );

            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);

            setPreferredSize(
                    new Dimension(
                            150,
                            48
                    )
            );

            setCursor(
                    new Cursor(
                            Cursor.HAND_CURSOR
                    )
            );

            addMouseListener(
                    new MouseAdapter() {

                        public void mouseEntered(
                                MouseEvent e
                        ) {

                            hover = true;

                            repaint();
                        }

                        public void mouseExited(
                                MouseEvent e
                        ) {

                            hover = false;

                            repaint();
                        }

                        public void mousePressed(
                                MouseEvent e
                        ) {

                            pressed = true;

                            repaint();
                        }

                        public void mouseReleased(
                                MouseEvent e
                        ) {

                            pressed = false;

                            repaint();
                        }
                    }
            );
        }

        protected void paintComponent(
                Graphics g
        ) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            Color buttonColor;

            if (pressed) {

                buttonColor =
                        new Color(
                                0,
                                90,
                                200
                        );

            } else if (hover) {

                buttonColor =
                        new Color(
                                40,
                                145,
                                255
                        );

            } else {

                buttonColor =
                        new Color(
                                0,
                                122,
                                255
                        );
            }

            g2.setColor(buttonColor);

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    60,
                    60
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =================================
    // ROUNDED CARD
    // =================================

    static class RoundedPanel
            extends JPanel {

        private int radius;
        private Color color;

        public RoundedPanel(
                int radius,
                Color color
        ) {

            this.radius = radius;
            this.color = color;

            setOpaque(false);
        }

        protected void paintComponent(
                Graphics g
        ) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Shadow
            g2.setColor(
                    new Color(
                            0,
                            0,
                            0,
                            35
                    )
            );

            g2.fillRoundRect(
                    4,
                    6,
                    getWidth() - 8,
                    getHeight() - 8,
                    radius,
                    radius
            );

            // Card
            g2.setColor(color);

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth() - 5,
                    getHeight() - 5,
                    radius,
                    radius
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =================================
    // EDUCATION BACKGROUND
    // =================================

    static class EducationBackground
            extends JPanel {

        private Random random =
                new Random();

        private int[] x =
                new int[25];

        private int[] y =
                new int[25];

        private int[] size =
                new int[25];

        private int[] speed =
                new int[25];

        private Timer animation;

        public EducationBackground() {

            setOpaque(true);

            for (int i = 0; i < 25; i++) {

                x[i] =
                        random.nextInt(1100);

                y[i] =
                        random.nextInt(750);

                size[i] =
                        3 + random.nextInt(7);

                speed[i] =
                        1 + random.nextInt(3);
            }

            animation =
                    new Timer(
                            30,
                            new ActionListener() {

                                public void actionPerformed(
                                        ActionEvent e
                                ) {

                                    for (
                                            int i = 0;
                                            i < y.length;
                                            i++
                                    ) {

                                        y[i] -= speed[i];

                                        if (
                                                y[i] < -20
                                        ) {

                                            y[i] =
                                                    getHeight()
                                                            + 20;

                                            x[i] =
                                                    random.nextInt(
                                                            Math.max(
                                                                    1,
                                                                    getWidth()
                                                            )
                                                    );
                                        }
                                    }

                                    repaint();
                                }
                            }
                    );

            animation.start();
        }

        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int w = getWidth();
            int h = getHeight();

            // =================================
            // GRADIENT BACKGROUND
            // =================================

            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            new Color(
                                    12,
                                    35,
                                    70
                            ),
                            w,
                            h,
                            new Color(
                                    70,
                                    110,
                                    155
                            )
                    );

            g2.setPaint(gradient);

            g2.fillRect(
                    0,
                    0,
                    w,
                    h
            );

            // =================================
            // LARGE SOFT CIRCLES
            // =================================

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            20
                    )
            );

            g2.fillOval(
                    w - 280,
                    40,
                    350,
                    350
            );

            g2.fillOval(
                    -150,
                    h - 300,
                    400,
                    400
            );

            // =================================
            // OPEN BOOK
            // =================================

            int bookX =
                    w - 250;

            int bookY =
                    h - 170;

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            55
                    )
            );

            g2.fill(
                    new RoundRectangle2D.Double(
                            bookX,
                            bookY,
                            105,
                            75,
                            15,
                            15
                    )
            );

            g2.fill(
                    new RoundRectangle2D.Double(
                            bookX + 105,
                            bookY,
                            105,
                            75,
                            15,
                            15
                    )
            );

            // =================================
            // GRADUATION CAP
            // =================================

            int capX =
                    90;

            int capY =
                    100;

            Polygon cap =
                    new Polygon();

            cap.addPoint(
                    capX,
                    capY + 35
            );

            cap.addPoint(
                    capX + 80,
                    capY
            );

            cap.addPoint(
                    capX + 160,
                    capY + 35
            );

            cap.addPoint(
                    capX + 80,
                    capY + 70
            );

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            45
                    )
            );

            g2.fillPolygon(cap);

            // Cap base

            g2.fillRoundRect(
                    capX + 35,
                    capY + 55,
                    90,
                    35,
                    8,
                    8
            );

            // =================================
            // FLOATING PARTICLES
            // =================================

            for (int i = 0; i < x.length; i++) {

                g2.setColor(
                        new Color(
                                255,
                                255,
                                255,
                                100
                        )
                );

                g2.fillOval(
                        x[i],
                        y[i],
                        size[i],
                        size[i]
                );
            }

            g2.dispose();
        }
    }
}
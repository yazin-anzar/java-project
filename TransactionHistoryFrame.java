package pta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class TransactionHistoryFrame extends JFrame {

    private RoundedField searchField;
    private JTable table;
    private DefaultTableModel model;

    public TransactionHistoryFrame() {

        setTitle("PTA Fund Management - Transaction History");
        setSize(1250, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        EducationBackground background = new EducationBackground();
        background.setLayout(null);
        setContentPane(background);

        // ================= HEADER =================

        JLabel title = new JLabel("Transaction History");
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setBounds(45, 25, 500, 45);
        background.add(title);

        JLabel subtitle = new JLabel("View and manage all PTA fund transactions");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(new Color(230, 240, 255));
        subtitle.setBounds(48, 70, 500, 30);
        background.add(subtitle);

        // ================= MAIN CARD =================

        RoundedPanel card = new RoundedPanel(35);
        card.setLayout(null);
        card.setBackground(new Color(255, 255, 255, 235));
        card.setBounds(35, 115, 1180, 555);
        background.add(card);

        // ================= SEARCH =================

        JLabel searchLabel = new JLabel("Search Transaction");
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        searchLabel.setForeground(new Color(45, 50, 65));
        searchLabel.setBounds(35, 25, 220, 30);
        card.add(searchLabel);

        searchField = new RoundedField(20);
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        searchField.setPlaceholder("Student ID / Name / Transaction ID");
        searchField.setBounds(35, 60, 390, 45);
        card.add(searchField);

        OvalButton searchButton = new OvalButton("SEARCH");
        searchButton.setBounds(440, 60, 125, 45);
        card.add(searchButton);

        // ================= BUTTONS =================

        OvalButton viewButton = new OvalButton("VIEW");
        viewButton.setBounds(700, 60, 110, 45);
        card.add(viewButton);

        OvalButton deleteButton = new OvalButton("DELETE");
        deleteButton.setBounds(820, 60, 120, 45);
        card.add(deleteButton);

        OvalButton clearButton = new OvalButton("CLEAR");
        clearButton.setBounds(950, 60, 110, 45);
        card.add(clearButton);

        // ================= TABLE =================

        String[] columns = {
                "Student ID",
                "Student Name",
                "Transaction ID",
                "Type",
                "Amount",
                "Date",
                "Payment Method",
                "Status",
                "Remarks"
        };

        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);

        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(38);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setGridColor(new Color(225, 225, 230));
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);

        table.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 13)
        );

        table.getTableHeader().setBackground(
                new Color(240, 243, 250)
        );

        table.getTableHeader().setForeground(
                new Color(45, 50, 65)
        );

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(35, 125, 1110, 325);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        card.add(scrollPane);

        // ================= SAMPLE DATA =================

        addTransaction(
                "ST001",
                "Arjun",
                "TXN1001",
                "Collection",
                "₹500",
                "28-09-2026",
                "UPI",
                "Paid",
                "PTA Fund"
        );

        addTransaction(
                "ST002",
                "Rahul",
                "TXN1002",
                "Collection",
                "₹750",
                "27-09-2026",
                "Cash",
                "Paid",
                "Annual Fund"
        );

        addTransaction(
                "ST003",
                "Anjali",
                "TXN1003",
                "Return",
                "₹300",
                "26-09-2026",
                "Bank",
                "Completed",
                "Excess Fund"
        );

        addTransaction(
                "ST004",
                "Meera",
                "TXN1004",
                "Collection",
                "₹1000",
                "25-09-2026",
                "UPI",
                "Paid",
                "PTA Contribution"
        );

        addTransaction(
                "ST005",
                "Vishnu",
                "TXN1005",
                "Return",
                "₹250",
                "24-09-2026",
                "Bank",
                "Completed",
                "Fund Return"
        );

        // ================= BOTTOM =================

        OvalButton closeButton = new OvalButton("CLOSE");
        closeButton.setBounds(500, 475, 140, 45);
        card.add(closeButton);

        // ================= SEARCH ACTION =================

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String search = searchField.getText()
                        .trim()
                        .toLowerCase();

                if (search.length() == 0) {
                    JOptionPane.showMessageDialog(
                            TransactionHistoryFrame.this,
                            "Enter Student ID, Name or Transaction ID."
                    );
                    return;
                }

                boolean found = false;

                for (int i = 0; i < table.getRowCount(); i++) {

                    String studentId =
                            table.getValueAt(i, 0).toString().toLowerCase();

                    String studentName =
                            table.getValueAt(i, 1).toString().toLowerCase();

                    String transactionId =
                            table.getValueAt(i, 2).toString().toLowerCase();

                    if (studentId.contains(search)
                            || studentName.contains(search)
                            || transactionId.contains(search)) {

                        table.setRowSelectionInterval(i, i);
                        table.scrollRectToVisible(
                                table.getCellRect(i, 0, true)
                        );

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(
                            TransactionHistoryFrame.this,
                            "Transaction not found."
                    );
                }
            }
        });

        // ================= VIEW =================

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row == -1) {
                    JOptionPane.showMessageDialog(
                            TransactionHistoryFrame.this,
                            "Please select a transaction."
                    );
                    return;
                }

                String details =
                        "Student ID: " + table.getValueAt(row, 0)
                        + "\nStudent Name: " + table.getValueAt(row, 1)
                        + "\nTransaction ID: " + table.getValueAt(row, 2)
                        + "\nTransaction Type: " + table.getValueAt(row, 3)
                        + "\nAmount: " + table.getValueAt(row, 4)
                        + "\nDate: " + table.getValueAt(row, 5)
                        + "\nPayment Method: " + table.getValueAt(row, 6)
                        + "\nStatus: " + table.getValueAt(row, 7)
                        + "\nRemarks: " + table.getValueAt(row, 8);

                JOptionPane.showMessageDialog(
                        TransactionHistoryFrame.this,
                        details,
                        "Transaction Details",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ================= DELETE =================

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row == -1) {
                    JOptionPane.showMessageDialog(
                            TransactionHistoryFrame.this,
                            "Please select a transaction."
                    );
                    return;
                }

                int result = JOptionPane.showConfirmDialog(
                        TransactionHistoryFrame.this,
                        "Delete selected transaction?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    model.removeRow(row);
                }
            }
        });

        // ================= CLEAR =================

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                searchField.setText("");
                table.clearSelection();

                for (int i = 0; i < table.getRowCount(); i++) {
                    table.removeRowSelectionInterval(i, i);
                }
            }
        });

        // ================= CLOSE =================

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // ================= ADD TRANSACTION =================

    private void addTransaction(
            String studentId,
            String name,
            String transactionId,
            String type,
            String amount,
            String date,
            String method,
            String status,
            String remarks) {

        model.addRow(new Object[]{
                studentId,
                name,
                transactionId,
                type,
                amount,
                date,
                method,
                status,
                remarks
        });
    }

    // =====================================================
    // ROUNDED TEXT FIELD
    // =====================================================

    static class RoundedField extends JTextField {

        private int radius;
        private String placeholder = "";

        public RoundedField(int radius) {
            this.radius = radius;
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(5, 18, 5, 18));
        }

        public void setPlaceholder(String text) {
            placeholder = text;
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(new Color(245, 247, 252));

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    radius,
                    radius
            );

            if (getText().length() == 0 && !isFocusOwner()) {

                g2.setColor(new Color(145, 150, 165));

                g2.setFont(
                        new Font("Segoe UI", Font.PLAIN, 14)
                );

                g2.drawString(
                        placeholder,
                        18,
                        getHeight() / 2 + 5
                );
            }

            super.paintComponent(g);

            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(new Color(220, 225, 235));

            g2.drawRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    radius,
                    radius
            );

            g2.dispose();
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
                    new Font("Segoe UI", Font.BOLD, 13)
            );

            setForeground(Color.WHITE);

            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);

            setCursor(
                    new Cursor(Cursor.HAND_CURSOR)
            );

            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    hover = true;
                    scale = 1.05f;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hover = false;
                    scale = 1.0f;
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    scale = 0.96f;
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    scale = hover ? 1.05f : 1.0f;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int w = getWidth();
            int h = getHeight();

            int newW = (int) (w * scale);
            int newH = (int) (h * scale);

            int x = (w - newW) / 2;
            int y = (h - newH) / 2;

            if (hover) {
                g2.setColor(new Color(60, 120, 220));
            } else {
                g2.setColor(new Color(75, 105, 180));
            }

            g2.fillRoundRect(
                    x,
                    y,
                    newW,
                    newH,
                    newH,
                    newH
            );

            FontMetrics fm = g2.getFontMetrics(getFont());

            int textX =
                    (w - fm.stringWidth(getText())) / 2;

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
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

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
    // ANIMATED EDUCATION BACKGROUND
    // =====================================================

    static class EducationBackground extends JPanel {

        private Random random = new Random();

        private int[] x = new int[35];
        private int[] y = new int[35];
        private int[] speed = new int[35];

        private int bookX = 850;
        private int bookY = 45;

        public EducationBackground() {

            setOpaque(true);

            for (int i = 0; i < x.length; i++) {

                x[i] = random.nextInt(1250);
                y[i] = random.nextInt(750);
                speed[i] = 1 + random.nextInt(2);
            }

            Timer timer = new Timer(35, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    for (int i = 0; i < y.length; i++) {

                        y[i] -= speed[i];

                        if (y[i] < -10) {
                            y[i] = getHeight() + 10;
                            x[i] = random.nextInt(
                                    Math.max(getWidth(), 1)
                            );
                        }
                    }

                    repaint();
                }
            });

            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int width = getWidth();
            int height = getHeight();

            // Background gradient

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

            // Glowing circles

            g2.setColor(
                    new Color(255, 255, 255, 25)
            );

            g2.fillOval(
                    -100,
                    420,
                    350,
                    350
            );

            g2.fillOval(
                    950,
                    -150,
                    350,
                    350
            );

            // Floating particles

            for (int i = 0; i < x.length; i++) {

                g2.setColor(
                        new Color(
                                255,
                                255,
                                255,
                                80
                        )
                );

                int size = 3 + random.nextInt(4);

                g2.fillOval(
                        x[i],
                        y[i],
                        size,
                        size
                );
            }

            // Graduation cap

            int capX = 1050;
            int capY = 85;

            Polygon cap = new Polygon();

            cap.addPoint(capX, capY);
            cap.addPoint(capX + 90, capY + 25);
            cap.addPoint(capX, capY + 50);
            cap.addPoint(capX - 90, capY + 25);

            g2.setColor(
                    new Color(255, 255, 255, 180)
            );

            g2.fillPolygon(cap);

            g2.fillRect(
                    capX - 45,
                    capY + 35,
                    90,
                    15
            );

            // Book

            int bx = 80;
            int by = 610;

            g2.setColor(
                    new Color(255, 255, 255, 130)
            );

            g2.fillRoundRect(
                    bx,
                    by,
                    120,
                    70,
                    15,
                    15
            );

            g2.setColor(
                    new Color(35, 70, 140)
            );

            g2.drawLine(
                    bx + 60,
                    by + 5,
                    bx + 60,
                    by + 65
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
                        new TransactionHistoryFrame();
                    }
                }
        );
    }
}
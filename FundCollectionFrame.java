package pta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FundCollectionFrame extends JFrame {

    JTextField studentId, studentName, className;
    JTextField totalFund, paidAmount, remaining;
    JTextField transactionId, paymentDate;

    JComboBox<String> paymentMethod;
    JComboBox<String> paymentStatus;

    JTable table;
    DefaultTableModel model;

    public static void main(String[] args) {
        new FundCollectionFrame();
    }

    public FundCollectionFrame() {

        setTitle("PTA Fund Collection System");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new BackgroundPanel());

        createUI();

        setVisible(true);
    }

    private void createUI() {

        JPanel main = new JPanel(new BorderLayout(15, 15));
        main.setOpaque(false);
        main.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 20, 25
                )
        );

        // ================= HEADER =================

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JButton back = new JButton("← Dashboard");

        styleButton(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                try {
                    new DashboardFrame();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "DashboardFrame could not be opened."
                    );
                }
            }
        });

        header.add(back, BorderLayout.WEST);

        JLabel title =
                new JLabel(
                        "FUND COLLECTION",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(Color.WHITE);

        header.add(title, BorderLayout.CENTER);

        JLabel admin =
                new JLabel("ADMIN");

        admin.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        admin.setForeground(Color.WHITE);

        header.add(admin, BorderLayout.EAST);

        main.add(header, BorderLayout.NORTH);

        // ================= CENTER =================

        JPanel center =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        center.setOpaque(false);

        // ================= FORM =================

        JPanel form =
                new RoundedPanel();

        form.setLayout(
                new GridLayout(
                        4,
                        4,
                        12,
                        12
                )
        );

        studentId =
                createField(
                        form,
                        "Student ID"
                );

        studentName =
                createField(
                        form,
                        "Student Name"
                );

        className =
                createField(
                        form,
                        "Class / Department"
                );

        totalFund =
                createField(
                        form,
                        "Total Fund"
                );

        paidAmount =
                createField(
                        form,
                        "Amount Paid"
                );

        remaining =
                createField(
                        form,
                        "Remaining Amount"
                );

        remaining.setEditable(false);

        transactionId =
                createField(
                        form,
                        "Transaction ID"
                );

        paymentDate =
                createField(
                        form,
                        "Payment Date"
                );

        paymentDate.setText(
                new SimpleDateFormat(
                        "dd-MM-yyyy"
                ).format(new Date())
        );

        paymentMethod =
                createCombo(
                        form,
                        "Payment Method",
                        new String[]{
                                "Cash",
                                "UPI",
                                "Bank Transfer",
                                "Cheque",
                                "Online Payment"
                        }
                );

        paymentStatus =
                createCombo(
                        form,
                        "Payment Status",
                        new String[]{
                                "Paid",
                                "Partially Paid",
                                "Pending"
                        }
                );

        JPanel buttonBox =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                5
                        )
                );

        buttonBox.setOpaque(false);

        JButton collect =
                new JButton("COLLECT");

        JButton update =
                new JButton("UPDATE");

        JButton delete =
                new JButton("DELETE");

        JButton clear =
                new JButton("CLEAR");

        styleButton(collect);
        styleButton(update);
        styleButton(delete);
        styleButton(clear);

        buttonBox.add(collect);
        buttonBox.add(update);
        buttonBox.add(delete);
        buttonBox.add(clear);

        form.add(buttonBox);

        center.add(
                form,
                BorderLayout.NORTH
        );

        // ================= TABLE =================

        JPanel tablePanel =
                new RoundedPanel();

        tablePanel.setLayout(
                new BorderLayout(10, 10)
        );

        JLabel tableTitle =
                new JLabel(
                        "PAYMENT HISTORY"
                );

        tableTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );

        tableTitle.setForeground(
                new Color(30, 60, 120)
        );

        tablePanel.add(
                tableTitle,
                BorderLayout.NORTH
        );

        String[] columns = {
                "Transaction ID",
                "Student ID",
                "Student Name",
                "Amount",
                "Method",
                "Date",
                "Status"
        };

        model =
                new DefaultTableModel(
                        columns,
                        0
                );

        table =
                new JTable(model);

        table.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        table.setRowHeight(35);

        table.getTableHeader()
                .setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                13
                        )
                );

        JScrollPane scroll =
                new JScrollPane(table);

        tablePanel.add(
                scroll,
                BorderLayout.CENTER
        );

        center.add(
                tablePanel,
                BorderLayout.CENTER
        );

        main.add(
                center,
                BorderLayout.CENTER
        );

        getContentPane().add(main);

        // ================= EVENTS =================

        paidAmount.addKeyListener(
                new KeyAdapter() {

                    public void keyReleased(
                            KeyEvent e
                    ) {
                        calculateRemaining();
                    }
                }
        );

        totalFund.addKeyListener(
                new KeyAdapter() {

                    public void keyReleased(
                            KeyEvent e
                    ) {
                        calculateRemaining();
                    }
                }
        );

        collect.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {
                        collectPayment();
                    }
                }
        );

        update.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {
                        updatePayment();
                    }
                }
        );

        delete.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {
                        deletePayment();
                    }
                }
        );

        clear.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {
                        clearFields();
                    }
                }
        );

        table.addMouseListener(
                new MouseAdapter() {

                    public void mouseClicked(
                            MouseEvent e
                    ) {

                        if (
                                e.getClickCount() == 2
                        ) {
                            loadSelectedRow();
                        }
                    }
                }
        );

        transactionId.setText(
                generateTransactionId()
        );
    }

    // ================= FIELD =================

    private JTextField createField(
            JPanel panel,
            String labelText
    ) {

        JPanel box =
                new JPanel(
                        new BorderLayout(0, 5)
                );

        box.setOpaque(false);

        JLabel label =
                new JLabel(
                        labelText
                );

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        label.setForeground(
                new Color(
                        50,
                        70,
                        110
                )
        );

        RoundedTextField field =
                new RoundedTextField();

        box.add(
                label,
                BorderLayout.NORTH
        );

        box.add(
                field,
                BorderLayout.CENTER
        );

        panel.add(box);

        return field;
    }

    // ================= COMBO =================
    private JComboBox<String> createCombo(
            JPanel panel,
            String labelText,
            String[] items
    ) {

        JPanel box = new JPanel(
                new BorderLayout(0, 5)
        );

        box.setOpaque(false);

        JLabel label = new JLabel(labelText);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        label.setForeground(
                new Color(50, 70, 110)
        );

        JComboBox<String> combo =
                new JComboBox<String>(items);

        combo.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        combo.setPreferredSize(
                new Dimension(180, 48)
        );

        combo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(200, 210, 225),
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 12, 5, 12
                        )
                )
        );

        combo.setBackground(Color.WHITE);

        combo.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        box.add(
                label,
                BorderLayout.NORTH
        );

        box.add(
                combo,
                BorderLayout.CENTER
        );

        panel.add(box);

        return combo;
    }
    // ================= CALCULATE =================

    private void calculateRemaining() {

        try {

            double total =
                    Double.parseDouble(
                            totalFund.getText()
                    );

            double paid =
                    Double.parseDouble(
                            paidAmount.getText()
                    );

            double result =
                    total - paid;

            if (result < 0) {
                result = 0;
            }

            remaining.setText(
                    String.format(
                            "%.2f",
                            result
                    )
            );

            if (paid >= total) {

                paymentStatus.setSelectedItem(
                        "Paid"
                );

            } else if (paid > 0) {

                paymentStatus.setSelectedItem(
                        "Partially Paid"
                );

            } else {

                paymentStatus.setSelectedItem(
                        "Pending"
                );
            }

        } catch (Exception e) {

            remaining.setText("");
        }
    }

    // ================= COLLECT =================

    private void collectPayment() {

        if (
                studentId.getText().trim().isEmpty()
                        ||
                studentName.getText().trim().isEmpty()
                        ||
                paidAmount.getText().trim().isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Student ID, Student Name and Amount.",
                    "Missing Details",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            Double.parseDouble(
                    paidAmount.getText()
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid amount.",
                    "Invalid Amount",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        model.addRow(
                new Object[]{
                        transactionId.getText(),
                        studentId.getText(),
                        studentName.getText(),
                        "₹ " + paidAmount.getText(),
                        paymentMethod.getSelectedItem(),
                        paymentDate.getText(),
                        paymentStatus.getSelectedItem()
                }
        );

        JOptionPane.showMessageDialog(
                this,
                "Payment collected successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        transactionId.setText(
                generateTransactionId()
        );
    }

    // ================= UPDATE =================

    private void updatePayment() {

        int row =
                table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a payment record first."
            );

            return;
        }

        model.setValueAt(
                transactionId.getText(),
                row,
                0
        );

        model.setValueAt(
                studentId.getText(),
                row,
                1
        );

        model.setValueAt(
                studentName.getText(),
                row,
                2
        );

        model.setValueAt(
                "₹ " + paidAmount.getText(),
                row,
                3
        );

        model.setValueAt(
                paymentMethod.getSelectedItem(),
                row,
                4
        );

        model.setValueAt(
                paymentDate.getText(),
                row,
                5
        );

        model.setValueAt(
                paymentStatus.getSelectedItem(),
                row,
                6
        );

        JOptionPane.showMessageDialog(
                this,
                "Payment updated successfully!"
        );
    }

    // ================= DELETE =================

    private void deletePayment() {

        int row =
                table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a record first."
            );

            return;
        }

        model.removeRow(row);

        clearFields();
    }

    // ================= LOAD =================

    private void loadSelectedRow() {

        int row =
                table.getSelectedRow();

        if (row == -1) {
            return;
        }

        transactionId.setText(
                model.getValueAt(
                        row,
                        0
                ).toString()
        );

        studentId.setText(
                model.getValueAt(
                        row,
                        1
                ).toString()
        );

        studentName.setText(
                model.getValueAt(
                        row,
                        2
                ).toString()
        );

        paidAmount.setText(
                model.getValueAt(
                        row,
                        3
                ).toString()
                        .replace("₹", "")
                        .trim()
        );

        paymentMethod.setSelectedItem(
                model.getValueAt(
                        row,
                        4
                )
        );

        paymentDate.setText(
                model.getValueAt(
                        row,
                        5
                ).toString()
        );

        paymentStatus.setSelectedItem(
                model.getValueAt(
                        row,
                        6
                )
        );
    }

    // ================= CLEAR =================

    private void clearFields() {

        studentId.setText("");
        studentName.setText("");
        className.setText("");

        totalFund.setText("");
        paidAmount.setText("");
        remaining.setText("");

        transactionId.setText(
                generateTransactionId()
        );

        paymentDate.setText(
                new SimpleDateFormat(
                        "dd-MM-yyyy"
                ).format(new Date())
        );

        paymentMethod.setSelectedIndex(0);
        paymentStatus.setSelectedIndex(0);

        table.clearSelection();
    }

    // ================= TRANSACTION ID =================

    private String generateTransactionId() {

        return "PTA-"
                + System.currentTimeMillis()
                        % 1000000;
    }

    // ================= BUTTON STYLE =================

    private void styleButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                new Color(
                        50,
                        100,
                        200
                )
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        18,
                        10,
                        18
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.addMouseListener(
                new MouseAdapter() {

                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        80,
                                        140,
                                        240
                                )
                        );
                    }

                    public void mouseExited(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        50,
                                        100,
                                        200
                                )
                        );
                    }

                    public void mousePressed(
                            MouseEvent e
                    ) {

                        button.setLocation(
                                button.getX(),
                                button.getY() + 2
                        );
                    }

                    public void mouseReleased(
                            MouseEvent e
                    ) {

                        button.setLocation(
                                button.getX(),
                                button.getY() - 2
                        );
                    }
                }
        );
    }

    // ================= ROUNDED TEXT FIELD =================

    static class RoundedTextField
            extends JTextField {

        public RoundedTextField() {

            setPreferredSize(
                    new Dimension(
                            180,
                            48
                    )
            );

            setFont(
                    new Font(
                            "SansSerif",
                            Font.PLAIN,
                            14
                    )
            );

            setOpaque(false);

            setBorder(
                    BorderFactory.createEmptyBorder(
                            5,
                            16,
                            5,
                            16
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

            g2.setColor(Color.WHITE);

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
                            200,
                            210,
                            225
                    )
            );

            g2.drawRoundRect(
                    1,
                    1,
                    getWidth() - 2,
                    getHeight() - 2,
                    28,
                    28
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // ================= ROUNDED PANEL =================

    static class RoundedPanel
            extends JPanel {

        public RoundedPanel() {

            setOpaque(false);

            setBorder(
                    BorderFactory.createEmptyBorder(
                            15,
                            15,
                            15,
                            15
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

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            245
                    )
            );

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 1,
                    30,
                    30
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // ================= ANIMATED BACKGROUND =================

    static class BackgroundPanel
            extends JPanel {

        private float angle = 0;

        public BackgroundPanel() {

            Timer timer =
                    new Timer(
                            40,
                            new ActionListener() {

                                public void actionPerformed(
                                        ActionEvent e
                                ) {

                                    angle += 0.01f;

                                    repaint();
                                }
                            }
                    );

            timer.start();
        }

        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            int w = getWidth();
            int h = getHeight();

            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            new Color(
                                    10,
                                    25,
                                    70
                            ),
                            w,
                            h,
                            new Color(
                                    90,
                                    25,
                                    110
                            )
                    );

            g2.setPaint(gradient);

            g2.fillRect(
                    0,
                    0,
                    w,
                    h
            );

            int x =
                    (int)
                            (
                                    w / 2
                                            + Math.sin(angle)
                                            * 300
                            );

            int y =
                    (int)
                            (
                                    h / 2
                                            + Math.cos(angle)
                                            * 200
                            );

            g2.setColor(
                    new Color(
                            0,
                            180,
                            255,
                            50
                    )
            );

            g2.fillOval(
                    x - 150,
                    y - 150,
                    300,
                    300
            );

            g2.setColor(
                    new Color(
                            200,
                            50,
                            255,
                            40
                    )
            );

            g2.fillOval(
                    w - 250,
                    50,
                    300,
                    300
            );

            g2.dispose();
        }
    }
}
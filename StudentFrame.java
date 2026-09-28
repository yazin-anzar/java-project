package pta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentFrame extends JFrame {

    // =========================================================
    // COLORS
    // =========================================================

    private final Color TEXT = new Color(25, 35, 55);
    private final Color MUTED = new Color(90, 105, 125);

    // =========================================================
    // INPUT FIELDS
    // =========================================================

    private RoundedTextField idField;
    private RoundedTextField nameField;
    private RoundedTextField rollField;
    private RoundedTextField classField;
    private RoundedTextField phoneField;
    private RoundedTextField emailField;
    private RoundedTextField addressField;
    private RoundedTextField searchField;

    private JTable studentTable;
    private DefaultTableModel tableModel;

    private AnimatedBackground background;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public StudentFrame() {

        setTitle("PTA Fund Return Management System - Student Management");

        setSize(1250, 800);

        setMinimumSize(
                new Dimension(1050, 700)
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        // Better rendering on high-resolution displays
        System.setProperty(
                "sun.java2d.uiScale",
                "1.0"
        );

        background =
                new AnimatedBackground();

        setContentPane(background);

        background.setLayout(
                new BorderLayout()
        );

        createHeader();

        createMainContent();

        setVisible(true);

        background.startAnimation();
    }

    // =========================================================
    // HEADER
    // =========================================================

    private void createHeader() {

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);

        header.setBorder(
                new EmptyBorder(
                        22,
                        30,
                        15,
                        30
                )
        );

        // LEFT

        JPanel left =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                0,
                                0
                        )
                );

        left.setOpaque(false);

        GlassButton backButton =
                new GlassButton(
                        "←  Dashboard"
                );

        backButton.addActionListener(
                e -> {

                    dispose();

                    new DashboardFrame();

                }
        );

        left.add(backButton);

        // CENTER

        JLabel title =
                new JLabel(
                        "STUDENT MANAGEMENT"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(
                Color.WHITE
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        // RIGHT

        JPanel right =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                0,
                                5
                        )
                );

        right.setOpaque(false);

        JLabel admin =
                new JLabel(
                        "●  ADMIN  •  ACTIVE"
                );

        admin.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        admin.setForeground(
                new Color(
                        220,
                        235,
                        255
                )
        );

        right.add(admin);

        header.add(
                left,
                BorderLayout.WEST
        );

        header.add(
                title,
                BorderLayout.CENTER
        );

        header.add(
                right,
                BorderLayout.EAST
        );

        background.add(
                header,
                BorderLayout.NORTH
        );
    }

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private void createMainContent() {

        JPanel main =
                new JPanel(
                        new BorderLayout(
                                18,
                                18
                        )
                );

        main.setOpaque(false);

        main.setBorder(
                new EmptyBorder(
                        5,
                        30,
                        30,
                        30
                )
        );

        // =====================================================
        // STUDENT INFORMATION CARD
        // =====================================================

        RoundedCard formCard =
                new RoundedCard();

        formCard.setLayout(
                new BorderLayout(
                        12,
                        15
                )
        );

        formCard.setBorder(
                new EmptyBorder(
                        22,
                        25,
                        22,
                        25
                )
        );

        JLabel formTitle =
                new JLabel(
                        "Student Information"
                );

        formTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        21
                )
        );

        formTitle.setForeground(
                TEXT
        );

        formCard.add(
                formTitle,
                BorderLayout.NORTH
        );

        // =====================================================
        // FIELDS
        // =====================================================

        JPanel fields =
                new JPanel(
                        new GridLayout(
                                2,
                                4,
                                18,
                                15
                        )
                );

        fields.setOpaque(false);

        idField =
                createInput(
                        "Enter student ID"
                );

        nameField =
                createInput(
                        "Enter full name"
                );

        rollField =
                createInput(
                        "Enter roll number"
                );

        classField =
                createInput(
                        "Enter class / department"
                );

        phoneField =
                createInput(
                        "Enter phone number"
                );

        emailField =
                createInput(
                        "Enter email address"
                );

        addressField =
                createInput(
                        "Enter address"
                );

        fields.add(
                createInputBox(
                        "STUDENT ID",
                        idField
                )
        );

        fields.add(
                createInputBox(
                        "STUDENT NAME",
                        nameField
                )
        );

        fields.add(
                createInputBox(
                        "ROLL NUMBER",
                        rollField
                )
        );

        fields.add(
                createInputBox(
                        "CLASS / DEPARTMENT",
                        classField
                )
        );

        fields.add(
                createInputBox(
                        "PHONE NUMBER",
                        phoneField
                )
        );

        fields.add(
                createInputBox(
                        "EMAIL ADDRESS",
                        emailField
                )
        );

        fields.add(
                createInputBox(
                        "ADDRESS",
                        addressField
                )
        );

        fields.add(
                createStatusBox()
        );

        formCard.add(
                fields,
                BorderLayout.CENTER
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        JPanel actions =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                12,
                                0
                        )
                );

        actions.setOpaque(false);

        AnimatedActionButton addButton =
                new AnimatedActionButton(
                        "＋  ADD STUDENT",
                        new Color(
                                37,
                                99,
                                235
                        )
                );

        AnimatedActionButton updateButton =
                new AnimatedActionButton(
                        "✎  UPDATE",
                        new Color(
                                124,
                                58,
                                237
                        )
                );

        AnimatedActionButton deleteButton =
                new AnimatedActionButton(
                        "✕  DELETE",
                        new Color(
                                220,
                                38,
                                38
                        )
                );

        AnimatedActionButton clearButton =
                new AnimatedActionButton(
                        "↻  CLEAR",
                        new Color(
                                71,
                                85,
                                105
                        )
                );

        actions.add(addButton);
        actions.add(updateButton);
        actions.add(deleteButton);
        actions.add(clearButton);

        formCard.add(
                actions,
                BorderLayout.SOUTH
        );

        main.add(
                formCard,
                BorderLayout.NORTH
        );

        // =====================================================
        // TABLE CARD
        // =====================================================

        RoundedCard tableCard =
                new RoundedCard();

        tableCard.setLayout(
                new BorderLayout(
                        10,
                        15
                )
        );

        tableCard.setBorder(
                new EmptyBorder(
                        20,
                        25,
                        20,
                        25
                )
        );

        JPanel tableHeader =
                new JPanel(
                        new BorderLayout()
                );

        tableHeader.setOpaque(false);

        JLabel tableTitle =
                new JLabel(
                        "Registered Students"
                );

        tableTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        21
                )
        );

        tableTitle.setForeground(
                TEXT
        );

        searchField =
                createInput(
                        "Search students..."
                );

        searchField.setPreferredSize(
                new Dimension(
                        280,
                        46
                )
        );

        tableHeader.add(
                tableTitle,
                BorderLayout.WEST
        );

        tableHeader.add(
                searchField,
                BorderLayout.EAST
        );

        tableCard.add(
                tableHeader,
                BorderLayout.NORTH
        );

        // =====================================================
        // TABLE
        // =====================================================

        String[] columns = {

                "Student ID",
                "Name",
                "Roll No.",
                "Class",
                "Phone",
                "Email",
                "Status"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        studentTable =
                new JTable(
                        tableModel
                );

        studentTable.setRowHeight(
                42
        );

        studentTable.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        studentTable.setForeground(
                TEXT
        );

        studentTable.setSelectionBackground(
                new Color(
                        219,
                        234,
                        254
                )
        );

        studentTable.setSelectionForeground(
                TEXT
        );

        studentTable.setGridColor(
                new Color(
                        226,
                        232,
                        240
                )
        );

        studentTable.setShowVerticalLines(
                false
        );

        studentTable.setShowHorizontalLines(
                true
        );

        studentTable.setIntercellSpacing(
                new Dimension(
                        0,
                        1
                )
        );

        // TABLE HEADER

        studentTable
                .getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                0,
                                45
                        )
                );

        studentTable
                .getTableHeader()
                .setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                13
                        )
                );

        studentTable
                .getTableHeader()
                .setBackground(
                        new Color(
                                30,
                                41,
                                59
                        )
                );

        studentTable
                .getTableHeader()
                .setForeground(
                        Color.WHITE
                );

        // CENTER TABLE TEXT

        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();

        renderer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        renderer.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        studentTable.setDefaultRenderer(
                Object.class,
                renderer
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        studentTable
                );

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder()
        );

        scrollPane.setOpaque(false);

        scrollPane
                .getViewport()
                .setOpaque(false);

        tableCard.add(
                scrollPane,
                BorderLayout.CENTER
        );

        main.add(
                tableCard,
                BorderLayout.CENTER
        );

        background.add(
                main,
                BorderLayout.CENTER
        );

        // =====================================================
        // BUTTON EVENTS
        // =====================================================

        addButton.addActionListener(
                e -> addStudent()
        );

        updateButton.addActionListener(
                e -> updateStudent()
        );

        deleteButton.addActionListener(
                e -> deleteStudent()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );

        // =====================================================
        // TABLE CLICK
        // =====================================================

        studentTable.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            MouseEvent e) {

                        int row =
                                studentTable
                                        .getSelectedRow();

                        if (row >= 0) {

                            idField.setText(
                                    getValue(
                                            row,
                                            0
                                    )
                            );

                            nameField.setText(
                                    getValue(
                                            row,
                                            1
                                    )
                            );

                            rollField.setText(
                                    getValue(
                                            row,
                                            2
                                    )
                            );

                            classField.setText(
                                    getValue(
                                            row,
                                            3
                                    )
                            );

                            phoneField.setText(
                                    getValue(
                                            row,
                                            4
                                    )
                            );

                            emailField.setText(
                                    getValue(
                                            row,
                                            5
                                    )
                            );
                        }
                    }
                }
        );

        // =====================================================
        // SEARCH
        // =====================================================

        searchField.addKeyListener(
                new KeyAdapter() {

                    @Override
                    public void keyReleased(
                            KeyEvent e) {

                        searchStudents(
                                searchField
                                        .getText()
                        );
                    }
                }
        );
    }

    // =========================================================
    // INPUT BOX CONTAINER
    // =========================================================

    private JPanel createInputBox(
            String title,
            JComponent component) {

        JPanel panel =
                new JPanel(
                        new BorderLayout(
                                0,
                                7
                        )
                );

        panel.setOpaque(false);

        JLabel label =
                new JLabel(
                        title
                );

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        label.setForeground(
                MUTED
        );

        panel.add(
                label,
                BorderLayout.NORTH
        );

        panel.add(
                component,
                BorderLayout.CENTER
        );

        return panel;
    }

    // =========================================================
    // STATUS BOX
    // =========================================================

    private JPanel createStatusBox() {

        JPanel panel =
                new JPanel(
                        new BorderLayout(
                                0,
                                7
                        )
                );

        panel.setOpaque(false);

        JLabel label =
                new JLabel(
                        "ACCOUNT STATUS"
                );

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        label.setForeground(
                MUTED
        );

        panel.add(
                label,
                BorderLayout.NORTH
        );

        JPanel status =
                new JPanel(
                        new GridBagLayout()
                );

        status.setOpaque(false);

        status.setPreferredSize(
                new Dimension(
                        220,
                        48
                )
        );

        JLabel active =
                new JLabel(
                        "●  ACTIVE"
                );

        active.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        active.setForeground(
                new Color(
                        22,
                        163,
                        74
                )
        );

        status.add(active);

        RoundedPanelWrapper wrapper =
                new RoundedPanelWrapper(
                        status
                );

        panel.add(
                wrapper,
                BorderLayout.CENTER
        );

        return panel;
    }

    // =========================================================
    // CREATE INPUT
    // =========================================================

    private RoundedTextField createInput(
            String placeholder) {

        return new RoundedTextField(
                placeholder
        );
    }

    // =========================================================
    // ADD STUDENT
    // =========================================================

    private void addStudent() {

        if (
                idField.getText()
                        .trim()
                        .isEmpty()
                        ||
                nameField.getText()
                        .trim()
                        .isEmpty()
                ||
                rollField.getText()
                        .trim()
                        .isEmpty()
        ) {

            showAnimatedMessage(
                    "Missing Information",
                    "Please enter Student ID, Name and Roll Number."
            );

            shakeFrame();

            return;
        }

        tableModel.addRow(
                new Object[]{

                        idField.getText(),
                        nameField.getText(),
                        rollField.getText(),
                        classField.getText(),
                        phoneField.getText(),
                        emailField.getText(),
                        "ACTIVE"
                }
        );

        showAnimatedMessage(
                "✓  Student Added",
                "Student record added successfully."
        );

        clearFields();
    }

    // =========================================================
    // UPDATE STUDENT
    // =========================================================

    private void updateStudent() {

        int row =
                studentTable.getSelectedRow();

        if (row == -1) {

            showAnimatedMessage(
                    "Select Student",
                    "Select a student from the table first."
            );

            return;
        }

        tableModel.setValueAt(
                idField.getText(),
                row,
                0
        );

        tableModel.setValueAt(
                nameField.getText(),
                row,
                1
        );

        tableModel.setValueAt(
                rollField.getText(),
                row,
                2
        );

        tableModel.setValueAt(
                classField.getText(),
                row,
                3
        );

        tableModel.setValueAt(
                phoneField.getText(),
                row,
                4
        );

        tableModel.setValueAt(
                emailField.getText(),
                row,
                5
        );

        showAnimatedMessage(
                "✓  Updated",
                "Student information updated successfully."
        );
    }

    // =========================================================
    // DELETE STUDENT
    // =========================================================

    private void deleteStudent() {

        int row =
                studentTable.getSelectedRow();

        if (row == -1) {

            showAnimatedMessage(
                    "Select Student",
                    "Select a student from the table first."
            );

            return;
        }

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this student?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (
                result ==
                        JOptionPane.YES_OPTION
        ) {

            tableModel.removeRow(row);

            showAnimatedMessage(
                    "✓  Deleted",
                    "Student record removed successfully."
            );

            clearFields();
        }
    }

    // =========================================================
    // CLEAR
    // =========================================================

    private void clearFields() {

        idField.setText("");
        nameField.setText("");
        rollField.setText("");
        classField.setText("");
        phoneField.setText("");
        emailField.setText("");
        addressField.setText("");

        studentTable.clearSelection();

        idField.requestFocus();
    }

    // =========================================================
    // SEARCH
    // =========================================================

    private void searchStudents(
            String text) {

        String search =
                text.toLowerCase()
                        .trim();

        if (search.isEmpty()) {

            studentTable.clearSelection();

            return;
        }

        for (
                int row = 0;
                row < tableModel.getRowCount();
                row++
        ) {

            boolean found = false;

            for (
                    int col = 0;
                    col < tableModel.getColumnCount();
                    col++
            ) {

                Object value =
                        tableModel.getValueAt(
                                row,
                                col
                        );

                if (
                        value != null
                                &&
                        value.toString()
                                .toLowerCase()
                                .contains(search)
                ) {

                    found = true;

                    break;
                }
            }

            if (found) {

                studentTable.setRowSelectionInterval(
                        row,
                        row
                );

                studentTable.scrollRectToVisible(
                        studentTable
                                .getCellRect(
                                        row,
                                        0,
                                        true
                                )
                );

                return;
            }
        }

        studentTable.clearSelection();
    }

    // =========================================================
    // GET VALUE
    // =========================================================

    private String getValue(
            int row,
            int column) {

        Object value =
                tableModel.getValueAt(
                        row,
                        column
                );

        return value == null
                ? ""
                : value.toString();
    }

    // =========================================================
    // ANIMATED MESSAGE
    // =========================================================

    private void showAnimatedMessage(
            String title,
            String message) {

        final JDialog dialog =
                new JDialog(
                        this,
                        false
                );

        dialog.setUndecorated(true);

        RoundedCard card =
                new RoundedCard();

        card.setLayout(
                new BorderLayout(
                        5,
                        5
                )
        );

        card.setBorder(
                new EmptyBorder(
                        18,
                        25,
                        18,
                        25
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15
                )
        );

        titleLabel.setForeground(TEXT);

        JLabel messageLabel =
                new JLabel(message);

        messageLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        messageLabel.setForeground(MUTED);

        card.add(
                titleLabel,
                BorderLayout.NORTH
        );

        card.add(
                messageLabel,
                BorderLayout.CENTER
        );

        dialog.add(card);

        dialog.pack();

        Point location =
                getLocationOnScreen();

        dialog.setLocation(
                location.x
                        + getWidth()
                        - dialog.getWidth()
                        - 35,

                location.y + 80
        );

        dialog.setOpacity(0f);

        dialog.setVisible(true);

        final float[] opacity =
                {0f};

        Timer fadeIn =
                new Timer(
                        20,
                        null
                );

        fadeIn.addActionListener(
                e -> {

                    opacity[0] += 0.08f;

                    if (
                            opacity[0] >= 1f
                    ) {

                        opacity[0] = 1f;

                        fadeIn.stop();

                        Timer wait =
                                new Timer(
                                        1700,
                                        event -> {

                                            Timer fadeOut =
                                                    new Timer(
                                                            20,
                                                            null
                                                    );

                                            fadeOut.addActionListener(
                                                    f -> {

                                                        float value =
                                                                dialog.getOpacity()
                                                                        - 0.08f;

                                                        if (
                                                                value <= 0
                                                        ) {

                                                            dialog.dispose();

                                                            fadeOut.stop();

                                                        } else {

                                                            dialog.setOpacity(
                                                                    value
                                                            );
                                                        }
                                                    }
                                            );

                                            fadeOut.start();
                                        }
                                );

                        wait.setRepeats(false);

                        wait.start();
                    }

                    dialog.setOpacity(
                            opacity[0]
                    );
                }
        );

        fadeIn.start();
    }

    // =========================================================
    // SHAKE ANIMATION
    // =========================================================

    private void shakeFrame() {

        final int originalX =
                getX();

        final int originalY =
                getY();

        final int[] count =
                {0};

        Timer shake =
                new Timer(
                        25,
                        null
                );

        shake.addActionListener(
                e -> {

                    int offset =
                            count[0] % 2 == 0
                                    ? 7
                                    : -7;

                    setLocation(
                            originalX + offset,
                            originalY
                    );

                    count[0]++;

                    if (
                            count[0] >= 10
                    ) {

                        setLocation(
                                originalX,
                                originalY
                        );

                        shake.stop();
                    }
                }
        );

        shake.start();
    }

    // =========================================================
    // ROUNDED CARD
    // =========================================================

    static class RoundedCard
            extends JPanel {

        public RoundedCard() {

            setOpaque(false);
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D)
                            g.create();

            g2.setRenderingHint(
                    RenderingHints
                            .KEY_ANTIALIASING,
                    RenderingHints
                            .VALUE_ANTIALIAS_ON
            );

            // Soft shadow

            g2.setColor(
                    new Color(
                            0,
                            0,
                            0,
                            30
                    )
            );

            g2.fillRoundRect(
                    3,
                    5,
                    getWidth() - 6,
                    getHeight() - 6,
                    32,
                    32
            );

            // Main glass card

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            238
                    )
            );

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 8,
                    32,
                    32
            );

            // Border

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            160
                    )
            );

            g2.drawRoundRect(
                    0,
                    0,
                    getWidth() - 1,
                    getHeight() - 8,
                    32,
                    32
            );

            g2.dispose();
        }
    }

    // =========================================================
    // ROUNDED PANEL WRAPPER
    // =========================================================

    static class RoundedPanelWrapper
            extends JPanel {

        public RoundedPanelWrapper(
                JComponent component) {

            setLayout(
                    new BorderLayout()
            );

            setOpaque(false);

            setBorder(
                    new EmptyBorder(
                            0,
                            15,
                            0,
                            15
                    )
            );

            add(
                    component,
                    BorderLayout.CENTER
            );
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            Graphics2D g2 =
                    (Graphics2D)
                            g.create();

            g2.setRenderingHint(
                    RenderingHints
                            .KEY_ANTIALIASING,
                    RenderingHints
                            .VALUE_ANTIALIAS_ON
            );

            g2.setColor(
                    new Color(
                            248,
                            250,
                            252
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
                            226,
                            232,
                            240
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
    }

    // =========================================================
    // ROUNDED TEXT FIELD
    // =========================================================

    static class RoundedTextField
            extends JTextField {

        private final String placeholder;

        private boolean focused =
                false;

        public RoundedTextField(
                String placeholder) {

            this.placeholder =
                    placeholder;

            setOpaque(false);

            setFont(
                    new Font(
                            "SansSerif",
                            Font.PLAIN,
                            14
                    )
            );

            setForeground(
                    new Color(
                            25,
                            35,
                            55
                    )
            );

            setCaretColor(
                    new Color(
                            37,
                            99,
                            235
                    )
            );

            setBorder(
                    new EmptyBorder(
                            0,
                            20,
                            0,
                            20
                    )
            );

            setPreferredSize(
                    new Dimension(
                            230,
                            50
                    )
            );

            addFocusListener(
                    new FocusAdapter() {

                        @Override
                        public void focusGained(
                                FocusEvent e) {

                            focused = true;

                            repaint();
                        }

                        @Override
                        public void focusLost(
                                FocusEvent e) {

                            focused = false;

                            repaint();
                        }
                    }
            );
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            Graphics2D g2 =
                    (Graphics2D)
                            g.create();

            g2.setRenderingHint(
                    RenderingHints
                            .KEY_ANTIALIASING,
                    RenderingHints
                            .VALUE_ANTIALIAS_ON
            );

            // Background

            if (focused) {

                g2.setColor(
                        new Color(
                                239,
                                246,
                                255
                        )
                );

            } else {

                g2.setColor(
                        new Color(
                                248,
                                250,
                                252
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

            // Border

            if (focused) {

                g2.setColor(
                        new Color(
                                59,
                                130,
                                246
                        )
                );

                g2.setStroke(
                        new BasicStroke(
                                2f
                        )
                );

            } else {

                g2.setColor(
                        new Color(
                                203,
                                213,
                                225
                        )
                );
            }

            g2.drawRoundRect(
                    1,
                    1,
                    getWidth() - 3,
                    getHeight() - 3,
                    28,
                    28
            );

            g2.dispose();

            super.paintComponent(g);

            // Placeholder

            if (
                    getText().isEmpty()
                            &&
                    !focused
            ) {

                Graphics2D p =
                        (Graphics2D)
                                g.create();

                p.setColor(
                        new Color(
                                148,
                                163,
                                184
                        )
                );

                p.setFont(
                        new Font(
                                "SansSerif",
                                Font.PLAIN,
                                13
                        )
                );

                p.drawString(
                        placeholder,
                        20,
                        getHeight() / 2 + 5
                );

                p.dispose();
            }
        }
    }

    // =========================================================
    // GLASS BUTTON
    // =========================================================

    static class GlassButton
            extends JButton {

        private boolean hover =
                false;

        private boolean pressed =
                false;

        public GlassButton(
                String text) {

            super(text);

            setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            13
                    )
            );

            setForeground(
                    Color.WHITE
            );

            setFocusPainted(false);

            setBorderPainted(false);

            setContentAreaFilled(false);

            setOpaque(false);

            setPreferredSize(
                    new Dimension(
                            150,
                            45
                    )
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

                            hover = true;

                            repaint();
                        }

                        @Override
                        public void mouseExited(
                                MouseEvent e) {

                            hover = false;

                            pressed = false;

                            repaint();
                        }

                        @Override
                        public void mousePressed(
                                MouseEvent e) {

                            pressed = true;

                            repaint();
                        }

                        @Override
                        public void mouseReleased(
                                MouseEvent e) {

                            pressed = false;

                            repaint();
                        }
                    }
            );
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            Graphics2D g2 =
                    (Graphics2D)
                            g.create();

            g2.setRenderingHint(
                    RenderingHints
                            .KEY_ANTIALIASING,
                    RenderingHints
                            .VALUE_ANTIALIAS_ON
            );

            g2.setColor(
                    hover
                            ? new Color(
                                    255,
                                    255,
                                    255,
                                    70
                            )
                            : new Color(
                                    255,
                                    255,
                                    255,
                                    30
                            )
            );

            int y =
                    pressed
                            ? 3
                            : 0;

            g2.fillRoundRect(
                    0,
                    y,
                    getWidth(),
                    getHeight() - 3,
                    28,
                    28
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =========================================================
    // ACTION BUTTON
    // =========================================================

    static class AnimatedActionButton
            extends JButton {

        private boolean hover =
                false;

        private boolean pressed =
                false;

        private final Color baseColor;

        public AnimatedActionButton(
                String text,
                Color color) {

            super(text);

            baseColor =
                    color;

            setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            12
                    )
            );

            setForeground(
                    Color.WHITE
            );

            setFocusPainted(false);

            setBorderPainted(false);

            setContentAreaFilled(false);

            setOpaque(false);

            setPreferredSize(
                    new Dimension(
                            155,
                            44
                    )
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

                            hover = true;

                            repaint();
                        }

                        @Override
                        public void mouseExited(
                                MouseEvent e) {

                            hover = false;

                            pressed = false;

                            repaint();
                        }

                        @Override
                        public void mousePressed(
                                MouseEvent e) {

                            pressed = true;

                            repaint();
                        }

                        @Override
                        public void mouseReleased(
                                MouseEvent e) {

                            pressed = false;

                            repaint();
                        }
                    }
            );
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            Graphics2D g2 =
                    (Graphics2D)
                            g.create();

            g2.setRenderingHint(
                    RenderingHints
                            .KEY_ANTIALIASING,
                    RenderingHints
                            .VALUE_ANTIALIAS_ON
            );

            Color color =
                    baseColor;

            if (hover) {

                color =
                        color.brighter();
            }

            if (pressed) {

                color =
                        color.darker();
            }

            int y =
                    pressed
                            ? 3
                            : 0;

            g2.setColor(
                    color
            );

            g2.fillRoundRect(
                    0,
                    y,
                    getWidth(),
                    getHeight() - 3,
                    26,
                    26
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // =========================================================
    // ANIMATED BACKGROUND
    // =========================================================

    static class AnimatedBackground
            extends JPanel {

        private final List<Particle>
                particles =
                new ArrayList<>();

        private final Random random =
                new Random();

        private float hue =
                0f;

        public AnimatedBackground() {

            setOpaque(true);

            for (
                    int i = 0;
                    i < 45;
                    i++
            ) {

                particles.add(
                        new Particle(
                                random.nextInt(
                                        1300
                                ),
                                random.nextInt(
                                        800
                                ),
                                1 + random.nextInt(4),
                                random.nextFloat()
                        )
                );
            }
        }

        public void startAnimation() {

            Timer timer =
                    new Timer(
                            30,
                            e -> {

                                hue +=
                                        0.0015f;

                                if (
                                        hue >= 1f
                                ) {

                                    hue = 0f;
                                }

                                for (
                                        Particle p :
                                        particles
                                ) {

                                    p.y -=
                                            p.speed;

                                    p.x +=
                                            Math.sin(
                                                    p.y
                                                            * 0.01
                                            )
                                                    * 0.3;

                                    if (
                                            p.y
                                                    < -10
                                    ) {

                                        p.y =
                                                getHeight()
                                                        + 10;

                                        p.x =
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
                    RenderingHints
                            .KEY_ANTIALIASING,
                    RenderingHints
                            .VALUE_ANTIALIAS_ON
            );

            // =================================================
            // DARK GRADIENT
            // =================================================

            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            new Color(
                                    9,
                                    18,
                                    38
                            ),
                            getWidth(),
                            getHeight(),
                            new Color(
                                    35,
                                    20,
                                    75
                            )
                    );

            g2.setPaint(
                    gradient
            );

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );

            // =================================================
            // BLUE GLOW
            // =================================================

            drawGlow(
                    g2,
                    getWidth() * 0.12,
                    getHeight() * 0.18,
                    220,
                    new Color(
                            37,
                            99,
                            235,
                            70
                    )
            );

            // =================================================
            // PURPLE GLOW
            // =================================================

            drawGlow(
                    g2,
                    getWidth() * 0.85,
                    getHeight() * 0.20,
                    230,
                    new Color(
                            168,
                            85,
                            247,
                            65
                    )
            );

            // =================================================
            // CYAN GLOW
            // =================================================

            drawGlow(
                    g2,
                    getWidth() * 0.70,
                    getHeight() * 0.88,
                    250,
                    new Color(
                            14,
                            165,
                            233,
                            55
                    )
            );

            // =================================================
            // PINK GLOW
            // =================================================

            drawGlow(
                    g2,
                    getWidth() * 0.30,
                    getHeight() * 0.90,
                    180,
                    new Color(
                            236,
                            72,
                            153,
                            40
                    )
            );

            // =================================================
            // PARTICLES
            // =================================================

            for (
                    Particle p :
                    particles
            ) {

                float alpha =
                        0.3f
                                +
                                0.35f
                                        *
                                        (float)
                                                Math.sin(
                                                        System.currentTimeMillis()
                                                                * 0.002
                                                                + p.twinkle
                                                );

                Color particleColor =
                        Color.getHSBColor(
                                hue
                                        + p.twinkle
                                                * 0.15f,
                                0.55f,
                                1f
                        );

                g2.setColor(
                        new Color(
                                particleColor
                                        .getRed(),
                                particleColor
                                        .getGreen(),
                                particleColor
                                        .getBlue(),
                                Math.max(
                                        30,
                                        Math.min(
                                                160,
                                                (int)
                                                        (
                                                                alpha
                                                                        * 255
                                                        )
                                        )
                                )
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

            // =================================================
            // CONNECTING PARTICLE LINES
            // =================================================

            g2.setStroke(
                    new BasicStroke(
                            1f
                    )
            );

            for (
                    int i = 0;
                    i < particles.size();
                    i++
            ) {

                Particle a =
                        particles.get(i);

                for (
                        int j = i + 1;
                        j < particles.size();
                        j++
                ) {

                    Particle b =
                            particles.get(j);

                    double distance =
                            Math.hypot(
                                    a.x - b.x,
                                    a.y - b.y
                            );

                    if (
                            distance < 120
                    ) {

                        int alpha =
                                (int)
                                        (
                                                40
                                                        *
                                                        (
                                                                1
                                                                        -
                                                                        distance
                                                                                / 120
                                                        )
                                        );

                        g2.setColor(
                                new Color(
                                        100,
                                        160,
                                        255,
                                        alpha
                                )
                        );

                        g2.drawLine(
                                (int) a.x,
                                (int) a.y,
                                (int) b.x,
                                (int) b.y
                        );
                    }
                }
            }

            g2.dispose();
        }

        private void drawGlow(
                Graphics2D g2,
                double x,
                double y,
                int radius,
                Color color) {

            for (
                    int r = radius;
                    r > 10;
                    r -= 10
            ) {

                int alpha =
                        Math.max(
                                1,
                                color.getAlpha()
                                        * r
                                        / radius
                                        / 4
                        );

                g2.setColor(
                        new Color(
                                color.getRed(),
                                color.getGreen(),
                                color.getBlue(),
                                alpha
                        )
                );

                g2.fillOval(
                        (int) x - r,
                        (int) y - r,
                        r * 2,
                        r * 2
                );
            }
        }
    }

    // =========================================================
    // PARTICLE
    // =========================================================

    static class Particle {

        double x;
        double y;

        int size;

        double speed;

        float twinkle;

        public Particle(
                double x,
                double y,
                int size,
                float twinkle) {

            this.x = x;
            this.y = y;

            this.size =
                    size;

            this.twinkle =
                    twinkle;

            this.speed =
                    0.2
                            +
                            Math.random()
                                    * 0.8;
        }
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    new StudentFrame();

                }
        );
    }
}
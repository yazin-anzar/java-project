package pta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class LoginFrame extends JFrame {

    private RoundedPasswordField passwordField;
    private boolean passwordVisible = false;

    public LoginFrame() {

        setTitle("PTA Fund Return Management System");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main background
        AnimatedBackground background = new AnimatedBackground();
        background.setLayout(new BorderLayout());

        // LEFT SIDE
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(450, 550));
        leftPanel.setLayout(new GridBagLayout());

        GridBagConstraints leftGbc = new GridBagConstraints();
        leftGbc.gridx = 0;
        leftGbc.gridy = 0;
        leftGbc.insets = new Insets(10, 30, 10, 30);

        JLabel title = new JLabel("PTA FUND");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 42));

        JLabel subtitle = new JLabel("RETURN MANAGEMENT");
        subtitle.setForeground(new Color(220, 230, 255));
        subtitle.setFont(new Font("SansSerif", Font.BOLD, 21));

        JLabel description = new JLabel(
                "<html><center>Manage PTA funds, collections<br>"
                        + "and returns easily.</center></html>"
        );
        description.setForeground(new Color(210, 220, 240));
        description.setFont(new Font("SansSerif", Font.PLAIN, 16));
        description.setHorizontalAlignment(SwingConstants.CENTER);

        leftPanel.add(title, leftGbc);

        leftGbc.gridy++;
        leftPanel.add(subtitle, leftGbc);

        leftGbc.gridy++;
        leftPanel.add(description, leftGbc);

        // RIGHT SIDE LOGIN CARD
        RoundedPanel loginCard = new RoundedPanel(30);
        loginCard.setBackground(new Color(255, 255, 255, 235));
        loginCard.setPreferredSize(new Dimension(370, 420));
        loginCard.setLayout(new GridBagLayout());
        loginCard.setBorder(new EmptyBorder(25, 30, 25, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(6, 0, 6, 0);

        JLabel loginTitle = new JLabel("Welcome Back");
        loginTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        loginTitle.setForeground(new Color(30, 40, 70));
        loginTitle.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 20, 0);
        loginCard.add(loginTitle, gbc);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        userLabel.setForeground(new Color(60, 70, 90));

        gbc.gridy++;
        gbc.insets = new Insets(5, 0, 5, 0);
        loginCard.add(userLabel, gbc);

        RoundedTextField usernameField = new RoundedTextField(20);
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        usernameField.setPreferredSize(new Dimension(300, 45));

        gbc.gridy++;
        loginCard.add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        passLabel.setForeground(new Color(60, 70, 90));

        gbc.gridy++;
        loginCard.add(passLabel, gbc);

        // PASSWORD FIELD
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.setOpaque(false);

        passwordField = new RoundedPasswordField(20);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        passwordField.setPreferredSize(new Dimension(220, 45));

        JButton showButton = new JButton("SHOW");
        showButton.setFocusPainted(false);
        showButton.setBorderPainted(false);
        showButton.setContentAreaFilled(false);
        showButton.setFont(new Font("SansSerif", Font.BOLD, 11));
        showButton.setForeground(new Color(50, 90, 180));
        showButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        showButton.addActionListener(e -> {
            passwordVisible = !passwordVisible;

            if (passwordVisible) {
                passwordField.setEchoChar((char) 0);
                showButton.setText("HIDE");
            } else {
                passwordField.setEchoChar('•');
                showButton.setText("SHOW");
            }
        });

        passwordPanel.add(passwordField, BorderLayout.CENTER);
        passwordPanel.add(showButton, BorderLayout.EAST);

        gbc.gridy++;
        loginCard.add(passwordPanel, gbc);

        // FORGOT PASSWORD
        JLabel forgotPassword = new JLabel("Forgot Password?");
        forgotPassword.setFont(new Font("SansSerif", Font.PLAIN, 12));
        forgotPassword.setForeground(new Color(50, 90, 180));
        forgotPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));

        forgotPassword.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                forgotPassword.setText("<html><u>Forgot Password?</u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgotPassword.setText("Forgot Password?");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        LoginFrame.this,
                        "Please contact the administrator to reset your password.",
                        "Password Reset",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        gbc.gridy++;
        gbc.insets = new Insets(2, 0, 15, 0);
        loginCard.add(forgotPassword, gbc);

        // LOGIN BUTTON
        AnimatedButton loginButton = new AnimatedButton("LOGIN");
        loginButton.setPreferredSize(new Dimension(300, 48));

        loginButton.addActionListener(e -> {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {

                JOptionPane.showMessageDialog(
                        LoginFrame.this,
                        "Login Successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // Later you can open DashboardFrame here.

            } else {

                JOptionPane.showMessageDialog(
                        LoginFrame.this,
                        "Invalid username or password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        gbc.gridy++;
        gbc.insets = new Insets(5, 0, 10, 0);
        loginCard.add(loginButton, gbc);

        JLabel bottomText = new JLabel("PTA Management System");
        bottomText.setFont(new Font("SansSerif", Font.PLAIN, 11));
        bottomText.setForeground(new Color(120, 125, 140));
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridy++;
        loginCard.add(bottomText, gbc);

        // ADD PANELS
        background.add(leftPanel, BorderLayout.WEST);

        JPanel rightContainer = new JPanel(new GridBagLayout());
        rightContainer.setOpaque(false);
        rightContainer.add(loginCard);

        background.add(rightContainer, BorderLayout.CENTER);

        add(background);

        setVisible(true);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }


    // ==============================
    // ROUNDED PANEL
    // ==============================

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


    // ==============================
    // ROUNDED TEXT FIELD
    // ==============================

    static class RoundedTextField extends JTextField {

        private int radius;

        public RoundedTextField(int radius) {
            this.radius = radius;

            setOpaque(false);
            setBorder(new EmptyBorder(10, 15, 10, 15));
            setBackground(new Color(245, 247, 252));

            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(new Color(235, 240, 252));
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(new Color(245, 247, 252));
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


    // ==============================
    // ROUNDED PASSWORD FIELD
    // ==============================

    static class RoundedPasswordField extends JPasswordField {

        private int radius;

        public RoundedPasswordField(int radius) {

            this.radius = radius;

            setOpaque(false);
            setEchoChar('•');
            setBorder(new EmptyBorder(10, 15, 10, 5));
            setBackground(new Color(245, 247, 252));

            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(new Color(235, 240, 252));
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(new Color(245, 247, 252));
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


    // ==============================
    // ANIMATED BUTTON
    // ==============================

    static class AnimatedButton extends JButton {

        private Color normalColor = new Color(50, 90, 180);
        private Color hoverColor = new Color(70, 110, 210);

        public AnimatedButton(String text) {

            super(text);

            setFont(new Font("SansSerif", Font.BOLD, 15));
            setForeground(Color.WHITE);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));

            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    setForeground(Color.WHITE);
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    setLocation(getX(), getY() + 2);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setLocation(getX(), getY() - 2);
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

            if (getModel().isRollover()) {
                g2.setColor(hoverColor);
            } else {
                g2.setColor(normalColor);
            }

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    20,
                    20
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }


    // ==============================
    // ANIMATED BACKGROUND
    // ==============================

    static class AnimatedBackground extends JPanel {

        private ArrayList<Particle> particles = new ArrayList<>();
        private Random random = new Random();

        public AnimatedBackground() {

            setBackground(new Color(20, 30, 65));

            for (int i = 0; i < 35; i++) {

                particles.add(
                        new Particle(
                                random.nextInt(900),
                                random.nextInt(550),
                                1 + random.nextInt(3)
                        )
                );
            }

            Timer timer = new Timer(30, e -> {

                for (Particle p : particles) {
                    p.y -= p.speed;

                    if (p.y < -10) {
                        p.y = getHeight() + 10;
                        p.x = random.nextInt(Math.max(getWidth(), 1));
                    }
                }

                repaint();
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

            for (Particle p : particles) {

                g2.setColor(new Color(255, 255, 255, 80));

                g2.fill(
                        new Ellipse2D.Double(
                                p.x,
                                p.y,
                                p.size,
                                p.size
                        )
                );
            }

            g2.dispose();
        }
    }


    // ==============================
    // PARTICLE
    // ==============================

    static class Particle {

        double x;
        double y;
        double speed;
        double size;

        public Particle(double x, double y, double size) {

            this.x = x;
            this.y = y;
            this.size = size;
            this.speed = 0.5 + Math.random() * 1.5;
        }
    }
}
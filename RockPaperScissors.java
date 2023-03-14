import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RockPaperScissors extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private JLabel statusLabel;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;

    public RockPaperScissors() {
        super("Rock Paper Scissors");

        // Set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Set up the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Set up the status label
        statusLabel = new JLabel("Choose your move!");

        // Set up the buttons
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        // Add action listeners to the buttons
        rockButton.addActionListener(new ButtonListener());
        paperButton.addActionListener(new ButtonListener());
        scissorsButton.addActionListener(new ButtonListener());

        // Add the buttons to a panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        // Add the components to the main panel
        mainPanel.add(statusLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Set up the window
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Determine which button was pressed
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            // Generate the computer's move
            String[] moves = {"Rock", "Paper", "Scissors"};
            String computerMove = moves[(int) (Math.random() * 3)];

            // Determine the outcome of the game
            String result;
            if (buttonText.equals(computerMove)) {
                result = "It's a tie!";
            } else if ((buttonText.equals("Rock") && computerMove.equals("Scissors")) ||
                    (buttonText.equals("Paper") && computerMove.equals("Rock")) ||
                    (buttonText.equals("Scissors") && computerMove.equals("Paper"))) {
                result = "You win!";
            } else {
                result = "You lose!";
            }

            // Update the status label
            statusLabel.setText("You chose " + buttonText + ". The computer chose " + computerMove + ". " + result);
        }
    }

    public static void main(String[] args) {
        new RockPaperScissors();
    }
}

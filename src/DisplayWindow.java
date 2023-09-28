import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class DisplayWindow {

    final int SQUARE_SIZE = 50;
    JButton[] buttons = new JButton[54];
    JTextField photoStatus = new JTextField(){
        @Override public void setBorder(Border border) {
            //Remove ugly background
        }
    };

    JTextField showSolution = new JTextField(){
        @Override public void setBorder(Border border) {
            // Remove ugly background
        }
    };

    JTextField solutionMoveCount = new JTextField(){
        @Override public void setBorder(Border border){
            //Remove ugly background
        }
    };

    JTextArea  instructions = new JTextArea(){
        @Override public void setBorder(Border border) {
            //Remove ugly background
        }
    };
    String guideLines = " Press \"SPACE\" to take a picture\n Press \"R\" to reset progess\n Press \"X\" to quit application";
    private void layDownButtons(JButton [] allButtons, int column , int startingButton, int endingButton, int yLevel){
        int [] allXCoordinates = {20,80,140,200,260,320,380,440,500,560,620,680};
        int [] allYCoordinates = {50,110,170,230,290,350,410,470,530};
        int currButton = column;
        for(int i = startingButton; i < endingButton;i++){
            allButtons[i].setBounds(allXCoordinates[currButton], allYCoordinates[yLevel], SQUARE_SIZE, SQUARE_SIZE);
            currButton++;
            if(i == startingButton + 2 || i == endingButton - 4){
                yLevel++;
                currButton = column;
            }
        }
    }

    public void allocateButtons(){
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
        }
    }

    public void displayCube(){
        JFrame frame = new JFrame("Cube display frame");
        frame.setTitle("Rubik's cube window");
        frame.setBounds(750,150,950,700);
//        frame.setBackground(Color.decode("#171717"));
        Image icon = Toolkit.getDefaultToolkit().getImage(".\\img\\logo4.png");
        frame.setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setLayout(null);
//        panel.setBackground(Color.decode("#171717"));

        String[] choices = {"Light","Dark"};
        JComboBox<String> jComboBox = new JComboBox<>(choices);
        jComboBox.setBounds(788, 630, 140, 20);
        frame.add(jComboBox);

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(jComboBox.getItemAt(jComboBox.getSelectedIndex()))
                {
                    case "Dark":
                        frame.setBackground(Color.decode("#171717"));
                        panel.setBackground(Color.decode("#171717"));
                        showSolution.setBackground(Color.WHITE);
                        showSolution.setForeground(Color.WHITE);
                        photoStatus.setForeground(Color.WHITE);
                        instructions.setBackground(Color.WHITE);
                        instructions.setForeground(Color.WHITE);
                        solutionMoveCount.setBackground(Color.WHITE);
                        solutionMoveCount.setForeground(Color.WHITE);
                        break;
                    case "Light":
                        frame.setBackground(Color.WHITE);
                        panel.setBackground(Color.WHITE);
                        showSolution.setBackground(Color.BLACK);
                        showSolution.setForeground(Color.BLACK);
                        photoStatus.setForeground(Color.BLACK);
                        instructions.setBackground(Color.BLACK);
                        instructions.setForeground(Color.BLACK);
                        solutionMoveCount.setBackground(Color.BLACK);
                        solutionMoveCount.setForeground(Color.BLACK);
                        break;
                    default:
                        showSolution.setBackground(Color.BLACK);
                        showSolution.setForeground(Color.BLACK);
                        photoStatus.setForeground(Color.BLACK);
                        instructions.setBackground(Color.BLACK);
                        instructions.setForeground(Color.BLACK);
                        solutionMoveCount.setBackground(Color.BLACK);
                        break;

                }
            }
        });

        allocateButtons();

        String[] sideLabels = {"0","1","2","3","4","5"};

        buttons[4].setText(sideLabels[0]);
        buttons[13].setText(sideLabels[1]);
        buttons[22].setText(sideLabels[2]);
        buttons[31].setText(sideLabels[3]);
        buttons[40].setText(sideLabels[4]);
        buttons[49].setText(sideLabels[5]);


        //top
        layDownButtons(buttons,3,0,9,0);
        //left
        layDownButtons(buttons, 0, 9, 18, 3);
        //front
        layDownButtons(buttons, 3, 18, 27, 3);
        //right
        layDownButtons(buttons, 6, 27, 36, 3);
        //back
        layDownButtons(buttons, 9, 36, 45, 3);
        //bottom
        layDownButtons(buttons, 3, 45, 54, 6);

        for(int i = 0; i < buttons.length; i++){
            panel.add(buttons[i]);
        }

//        showSolution.setBackground(Color.BLACK);
//		showSolution.setBackground(Color.WHITE);
        showSolution.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
        showSolution.setText("No solution:");
        showSolution.setEditable(false);
//        showSolution.setForeground(Color.WHITE);
        showSolution.setBounds(50, 630, 750, 20);
        showSolution.setOpaque(false);

        photoStatus.setBackground(Color.GREEN);
        photoStatus.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
        photoStatus.setText("Welcome to the Rubik's Cube Solver! Please start capturing your cube.");
        photoStatus.setEditable(false);
//        photoStatus.setForeground(Color.WHITE);
        photoStatus.setBounds(100, 10, 800, 20);
        photoStatus.setOpaque(false);

//		instructions.setBackground(Color.BLACK);
//        instructions.setBackground(Color.WHITE);
        instructions.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
        instructions.setText(guideLines);
        instructions.setEditable(false);
//        instructions.setForeground(Color.WHITE);
        instructions.setBounds(400, 100, 400, 200);
        instructions.setOpaque(false);




//		solutionMoveCount.setBackground(Color.BLACK);
//        solutionMoveCount.setBackground(Color.WHITE);
        solutionMoveCount.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 16));
        solutionMoveCount.setBounds(50, 600, 400, 20);
        solutionMoveCount.setText("Number of moves: null");
        solutionMoveCount.setEditable(false);
//        solutionMoveCount.setForeground(Color.WHITE);
        solutionMoveCount.setOpaque(false);

        frame.add(solutionMoveCount);
        frame.add(showSolution);
        frame.add(instructions);
        frame.add(photoStatus);

        frame.add(panel);
        frame.setVisible(true);
    }


    public void setColor(Color color, JButton currButton){
        currButton.setBackground(color);
    }
}
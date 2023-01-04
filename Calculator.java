import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Caluclator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberB = new JButton[10];
    JButton[] functionB = new JButton[8];
    JButton addB, subB, mulB, divB;
    JButton decB, eqB, delB, clr;
    JPanel tab;

    Font font = new Font("Ink Free", Font.ITALIC, 35);

    double num1 = 0.0, num2 = 0.0, num3 = 0.0;
    char operator;



    Caluclator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocation(500, 200);


        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setBackground(new Color(255, 102, 204));
        textField.setForeground(new Color(0, 0, 204));

        addB = new JButton("+");
        subB = new JButton("-");
        mulB = new JButton("*");
        divB = new JButton("/");
        decB = new JButton(".");
        eqB = new JButton("=");
        delB = new JButton("DEL..");
        clr = new JButton("CLEAR");


        functionB[0] = addB;
        functionB[1] = subB;
        functionB[2] = mulB;
        functionB[3] = divB;
        functionB[4] = decB;
        functionB[5] = eqB;
        functionB[6] = delB;
        functionB[7] = clr;

        for (int i = 0; i < 8; i++) {
            functionB[i].addActionListener(this);
            functionB[i].setFont(font);
            functionB[i].setFocusable(false);
            functionB[i].setBackground(new Color(51, 153, 255));
            functionB[i].setForeground(Color.black);
        }

        for (int i = 0; i < 10; i++) {
            numberB[i] = new JButton(String.valueOf(i));
            numberB[i].addActionListener(this);
            numberB[i].setFont(font);
            numberB[i].setFocusable(false);
            numberB[i].setBackground(new Color(0, 255, 0));
            numberB[i].setForeground(Color.BLACK);


        }
        delB.setBounds(50, 430, 145, 50);
        clr.setBounds(205, 430, 145, 50);

        tab = new JPanel();

        tab.setBounds(50, 100, 300, 300);
        tab.setLayout(new GridLayout(4, 4, 10, 10));
        tab.setBackground(new Color(255, 153, 153));


        tab.add(numberB[1]);
        tab.add(numberB[2]);
        tab.add(numberB[3]);
        tab.add(addB);

        tab.add(numberB[4]);
        tab.add(numberB[5]);
        tab.add(numberB[6]);
        tab.add(subB);

        tab.add(numberB[7]);
        tab.add(numberB[8]);
        tab.add(numberB[9]);
        tab.add(mulB);
        tab.add(decB);
        tab.add(numberB[0]);
        tab.add(eqB);
        tab.add(divB);


        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
        tabbedPane.add("Calculator", tab);
        frame.add(tab);
        frame.add(delB);
        frame.add(clr);
        frame.add(textField);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);





    }

    public static void main(String[] args) {

        Caluclator calc = new Caluclator();


    }



    boolean isSolved = false;

    @Override
    public void actionPerformed(ActionEvent e) {




        for (int i = 0; i < 10; i++) {
            if (isSolved) {
                textField.setText("");
                isSolved = false;
            }
            if (e.getSource() == numberB[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }}
        if (e.getSource() == decB) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addB) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subB) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }
        if (e.getSource() == mulB) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }
        if (e.getSource() == divB) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }
        if(e.getSource() == eqB){
          if(operator == '/'||operator == '+'||operator == '-'||operator == '*'){

            num2= Double.parseDouble(textField.getText());

                switch (operator) {
                    case '+' -> num3 = num1 + num2;
                    case '-' -> num3 = num1 - num2;
                    case '/' -> num3 = num1 / num2;
                    case '*' -> num3 = num1 * num2;


            }
            textField.setText(String.valueOf(num3));
            operator = ' ';

            }
            else{
                num1 = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(num1));
            }
            isSolved = true;



       }
        if (e.getSource() == clr) {
            textField.setText("");

        }
        if (e.getSource() == delB) {
            String string = textField.getText();
            textField.setText("");
            for(int i =0 ;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }}






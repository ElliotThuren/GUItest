import jdk.nashorn.internal.ir.IfNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class guii {
    private JTextArea textArea;
    private JPanel panel1;
    private JButton Nytt;
    private JButton Oppna;
    private JButton Spara;

    public guii() {
        Nytt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //JOptionPane.showInputDialog("Är du säger på att du vill rensa detta dokument? I så fall skriv: rensa");

                //JOptionPane.showMessageDialog("Nu är det rensat.");
                textArea.setText("");
            }
        });
        Oppna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                        String filename = JOptionPane.showInputDialog("")+(".txt");
                        FileReader fr = null;
                        try {
                            fr = new FileReader(filename);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        BufferedReader inFile = new BufferedReader(fr);

                        String line;
                        try {
                            while ((line = inFile.readLine()) != null) {
                                textArea.append(line);
                            }
                            inFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

        });
        Spara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                System.out.println(text);
                String filename2 = JOptionPane.showInputDialog("")+(".txt");
                FileWriter fw = null;
                try {
                    fw = new FileWriter(filename2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter outFile = new PrintWriter(bw);
                        outFile.println(text);
                    outFile.flush();
                    outFile.close();


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("guii");
        frame.setTitle("TextField");
        frame.setContentPane(new guii().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1900,1000);
    }
}

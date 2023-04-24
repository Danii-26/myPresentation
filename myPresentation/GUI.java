package myPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    //atributos
    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private Title title;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    //metodos
    public GUI(){
        initGUI();

        this.setTitle("My Presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir container y Layout del JFrame
        //Crear objetos Escucha y Control
        //Configurar JComponents
        title = new Title("A little more about me", Color.BLACK);
        myPhoto = new JButton("This is me");
        myHobby = new JButton("This is my passion");
        myExpectations = new JButton("I expect to get the best of you");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(10, 12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.SANS_SERIF,Font.PLAIN,20), Color.BLACK));
        containerImage.add(imageLabel);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        //Action Events
        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);
        //Mouse Events
        myHobby.addMouseListener(listener);
        myExpectations.addMouseListener(listener);
        myPhoto.addMouseListener(listener);
        //Key Listener
        myPhoto.addKeyListener(listener);
        myHobby.addKeyListener(listener);
        myExpectations.addKeyListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI myGui = new GUI();
            }
        });
    }

    private class Listener implements ActionListener, KeyListener, MouseListener {
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "Press button");
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);

            if(e.getSource() == myPhoto){
                containerImage.add(expectativesText);
                imageLabel.setIcon(null);
                this.image = new ImageIcon(getClass().getResource("/resources/Me.jpg"));
                imageLabel.setIcon(image);
                revalidate();
                repaint();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == myHobby && e.getClickCount() == 2){
                containerImage.remove(expectativesText);
                imageLabel.setIcon(null);
                this.image = new ImageIcon(getClass().getResource("/resources/hobby.jpg"));
                imageLabel.setIcon(image);
                revalidate();
                repaint();
            }
        }



        @Override
        public void keyPressed(KeyEvent e) {
                if (e.getSource() == myExpectations && (e.getKeyCode() == 77)) {
                    expectativesText.setText("I expect to get the best of everyone of you \n" +
                            "My contact is daniel.arias.castrillon@correounivalle.edu.co");
                    expectativesText.setBackground(null);
                    expectativesText.setForeground(Color.BLACK);
                    containerImage.add(expectativesText);
                    revalidate();
                    repaint();
                }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }
}

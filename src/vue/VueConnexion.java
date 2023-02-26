package vue; 

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

public class VueConnexion extends JFrame implements ActionListener, KeyListener {

    private JTextField txtEmail = new JTextField();
    private JPasswordField txtMdp = new JPasswordField();
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btConnexion = new JButton("Connexion");
    private JPanel panelConnexion = new JPanel();

    public VueConnexion(){
        this.setTitle("Gestion du site Filelec");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(100,100,700,300);
        this.getContentPane().setBackground(new Color(234,176,69));
        this.setLayout(null);

        // LOGO 
        ImageIcon uneImage = new ImageIcon("src/img/Filelec_logo.png");
        JLabel unLabel = new JLabel(uneImage);
        unLabel.setBounds(20,20,290,200);
        this.add(unLabel);


        //panel de connexion
        this.panelConnexion.setBounds(360,40,320,200);
        this.panelConnexion.setBackground(new Color(234,176,69));
        this.panelConnexion.setLayout(new GridLayout(3,2));
        //ajout des labels 
        this.panelConnexion.add(new JLabel("Email : "));
        this.panelConnexion.add(this.txtEmail);
        this.panelConnexion.add(new JLabel("Mdp : "));
        this.panelConnexion.add(this.txtMdp);
        // ajout des boutons
        this.panelConnexion.add(this.btAnnuler);
        this.panelConnexion.add(this.btConnexion);
        // ajout du panel sur la vue 
        this.add(this.panelConnexion);
        //rendre les boutons cliquables
        this.btAnnuler.addActionListener(this);
        this.btConnexion.addActionListener(this);
        //rendre les labels écoutables 
        this.txtEmail.addKeyListener(this);
        this.txtMdp.addKeyListener(this);

        this.setVisible(true);
    }


    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
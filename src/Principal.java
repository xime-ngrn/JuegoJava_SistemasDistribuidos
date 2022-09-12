import javax.swing.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import Logica.Caja;

/**
 *
 * 5IV7 Marín Romero Abigail
 *      Moreno Noguerón Ximena
 */
public class Principal extends JFrame implements ActionListener {

    private Caja piedras;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCentro;
    private javax.swing.JLabel jLabelPiedras;
    private javax.swing.JSpinner spinner1;
    private javax.swing.JSpinner spinner2;
    
    public Principal(){
        setLayout(null);
        setBounds(100, 100, 700, 500);
        setTitle("Juego Java");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
        
        setVisible(true);
    }
    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelCentro = new javax.swing.JLabel("Presiona el botón de comenzar");
        jLabelPiedras = new javax.swing.JLabel("");
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        
        SpinnerModel modeloSpinner = new SpinnerNumberModel(1, 1, 49, 1);
        spinner1 = new javax.swing.JSpinner();
        spinner1 = new JSpinner(modeloSpinner);
        
        SpinnerModel modeloSpinner2 = new SpinnerNumberModel(1, 1, 49, 1);
        spinner2 = new javax.swing.JSpinner();
        spinner2 = new JSpinner(modeloSpinner2);
        
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Comenzar");
        jButton1.addActionListener(this);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logica/IMG/dino13.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 160));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logica/IMG/dino31.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 160, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logica/IMG/cofre1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 90, 100));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Tirar Jugador 1");
        jButton2.setEnabled(false);
        jButton2.addActionListener(this);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jButton3.setBackground(new java.awt.Color(153, 0, 102));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Tirar Jugador 2");
        jButton3.setEnabled(false);
        jButton3.addActionListener(this);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tomar");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));
        getContentPane().add(spinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 50, -1));
        
        jLabelCentro.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabelCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));
        
        jLabelPiedras.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabelPiedras, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));
        
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tomar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));
        getContentPane().add(spinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 50, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logica/IMG/BosqueFondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }
    
    // escuchador de eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){
            JFrame jFrame = new JFrame();
            String getMessage = JOptionPane.showInputDialog(jFrame, "Ingresa la cantidad de piedras incial (entre 5 a 50)");
            if(parseInt(getMessage) <= 50 && parseInt(getMessage) >=5){
                piedras = new Caja(parseInt(getMessage));
                jLabelCentro.setText("Cantidad de piedras inicial: "+getMessage);
                jButton1.setEnabled(false);
                jButton2.setEnabled(true);
                jButton3.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(jFrame, "La cantidad "+getMessage+" no es válida");
            }      
                    
        } else if(e.getSource() == jButton2){
            JFrame jFrame2 = new JFrame();
            int piedrasJ1 = (Integer) spinner1.getValue();
            if(piedrasJ1 >= 1 && piedrasJ1 <= (piedras.getPiedras() -1)){
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame,"Cantidad de piedras del Jugador 1: "+piedrasJ1);
                int valNoMov = piedras.validacionQuitarPiedras(piedrasJ1);
                
                if(valNoMov == 1){
                    piedras.quitarPiedras(piedrasJ1);
                    jLabelPiedras.setText("Cantidad de piedras: "+piedras.getPiedras());
                    jButton2.setEnabled(false);
                    jButton3.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(jFrame, "La cantidad "+piedrasJ1+" no es válida");
                }
                
            }else{
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame,"Cantidad de piedras = "+piedrasJ1+" del Jugador 1 no es válida");
            }
            
            // validar si ya se ganó el juego
            int win = piedras.validacionGanador();
            if(win == 0){
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame,"No hay más movimientos. Ganador Jugador 1.");
                setVisible(false); 
            }
        } else if(e.getSource() == jButton3){
            JFrame jFrame2 = new JFrame();
            int piedrasJ2 = (Integer) spinner2.getValue();
            if(piedrasJ2 >= 1 && piedrasJ2 <= (piedras.getPiedras() -1)){
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame,"Cantidad de piedras del Jugador 2: "+piedrasJ2);
                int valNoMov = piedras.validacionQuitarPiedras(piedrasJ2);
                
                if(valNoMov == 1){
                    piedras.quitarPiedras(piedrasJ2);
                    jLabelPiedras.setText("Cantidad de piedras: "+piedras.getPiedras());
                    jButton2.setEnabled(true);
                    jButton3.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(jFrame, "La cantidad "+piedrasJ2+" no es válida");
                }
                
            }else{
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame,"Cantidad de piedras = "+piedrasJ2+" del Jugador 1 no es válida");
            }
            
            // validar si ya se ganó el juego
            int win = piedras.validacionGanador();
            if(win == 0){
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame,"No hay más movimientos. Ganador Jugador 1.");
                setVisible(false); 
            }
        }
    }
    
    public static void main(String args[]){
        new Principal();
    }

    
}

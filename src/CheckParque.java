
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*ohooo 
/**
 *
 * @author SNdzekos
 */
public class CheckParque extends javax.swing.JFrame {

    /**
     * Creates new form CheckParque
     */
    public CheckParque() {
        initComponents();
        
        setIconApp();
        try {
            VerificarVagas();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CheckParque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    //metodo para verificar a disponibilidade de vagas de estacionamento.
    public void VerificarVagas() throws FileNotFoundException{
     File ficheiroC=new File("entradasSaidas.txt");
    String IDA; //o id dos dados
    String TargetLin="9"; //valor da linha procurada
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    System.out.println("-------------------------------------------------------");
     System.out.println(" VAGAS DE ESTACIONAMENTO DISPONIVEIS ");
      System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    linhaA=linh.nextLine();
    IDA=linhaA.substring(0, 1);
    
    if(Linhaa>1){
        
//    System.out.println(""+linhaA);
       Scanner SCR=new Scanner(linhaA);
       SCR.useDelimiter("/");
        
        //abrir uma sequencia de for para encontrar valor de cada campo
          String cathID,cathProprietario,cathMatricula,cathMarca,cathModelo,cathEstacao, cathLugar, cathHEntrada, cathHSaida, cathTempPermaneica;
        
        //variaveis auxiliares da manipulacao.
        cathID=SCR.next();
        cathProprietario=SCR.next();
        cathMarca=SCR.next();
        cathMatricula=SCR.next();
        cathModelo=SCR.next();
        cathEstacao=SCR.next();
       cathLugar=SCR.next();
      
       cathLugar.trim();
       
       
       
       if((cathLugar).trim().equals("P1")){
           
         lblP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P2")){
           lblP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
           
       }
       if((cathLugar).trim().equals("P3")){
           lblP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
           
       }
       if((cathLugar).trim().equals("P4")){
           lblP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P5")){
           lblP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P6")){
           lblP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       } 
       if((cathLugar).trim().equals("P7")){
           lblP7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P8")){
           lblP8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P9")){
           lblP9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P10")){
//           lblP.setForeground(Color.red);
       }
       if((cathLugar).trim().equals("P11")){
           lblP11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P12")){
           lblP12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P13")){
          
           lblP13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P14")){
           
            lblP14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P15")){
           lblP15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/NoParking.png")));
       }
       if((cathLugar).trim().equals("P16")){
            lblP16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/filedVaga.png")));
       }
       if((cathLugar).trim().equals("P17")){
            lblP17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/filedVaga.png")));
       }
       if((cathLugar).trim().equals("P18")){
            lblP18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/filedVaga.png")));
       }
       if((cathLugar).trim().equals("P19")){
            lblP19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/filedVaga.png")));
       }if((cathLugar).trim().equals("P20")){
          lblP20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/filedVaga.png"))); 
       }
            
       System.out.println("******************************************************************************");
        System.out.println("VAGA:"+cathLugar);
       
        System.out.println("*********************************************************************");   
    
    }else{
        
    }
    
}

    
//    System.out.println(""+linh.nextLine());
   
    }
    
    public void setIconApp(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/pinkHomeLogo.png")));
}
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblP16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblP17 = new javax.swing.JLabel();
        lblP18 = new javax.swing.JLabel();
        lblP19 = new javax.swing.JLabel();
        lblP20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblVIPParque = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        lblP4 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        lblP5 = new javax.swing.JLabel();
        lblP6 = new javax.swing.JLabel();
        lblP7 = new javax.swing.JLabel();
        lblP8 = new javax.swing.JLabel();
        lblP13 = new javax.swing.JLabel();
        lblP9 = new javax.swing.JLabel();
        lblP11 = new javax.swing.JLabel();
        lblP12 = new javax.swing.JLabel();
        lblP1 = new javax.swing.JLabel();
        lblP15 = new javax.swing.JLabel();
        lblP14 = new javax.swing.JLabel();
        lblRotativoParque = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DISPONIBILIDADE DAS VAGAS DE ESTACIONAMENTO POR CATEGORIA.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 6, 520, 28));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 680, 50));

        lblP16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/noneFiledVaga.png"))); // NOI18N
        getContentPane().add(lblP16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 60, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("P17");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 40, -1));

        lblP17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/noneFiledVaga.png"))); // NOI18N
        getContentPane().add(lblP17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 60, 50));

        lblP18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/noneFiledVaga.png"))); // NOI18N
        getContentPane().add(lblP18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 50, 50));

        lblP19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/noneFiledVaga.png"))); // NOI18N
        getContentPane().add(lblP19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 50, 50));

        lblP20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backfoto/noneFiledVaga.png"))); // NOI18N
        lblP20.setText("----------");
        getContentPane().add(lblP20, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 50, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("P18");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 40, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("P19");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 40, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("P20");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 40, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("P16");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 40, -1));

        lblVIPParque.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parque de estacionamento V.I.P", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        getContentPane().add(lblVIPParque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 600, 150));

        lblP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP2.setText("-2");
        getContentPane().add(lblP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 40, 40));

        lblP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP4.setText("-4");
        getContentPane().add(lblP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 60, 40));

        lblP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP3.setText("-3");
        getContentPane().add(lblP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 60, 40));

        lblP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP5.setText("-5");
        getContentPane().add(lblP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 60, 40));

        lblP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP6.setText("-6");
        getContentPane().add(lblP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 50, 40));

        lblP7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP7.setText("-7");
        getContentPane().add(lblP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 40, 40));

        lblP8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP8.setText("-8");
        getContentPane().add(lblP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 50, 40));

        lblP13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP13.setText("-13");
        getContentPane().add(lblP13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 60, 40));

        lblP9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP9.setText("-9");
        getContentPane().add(lblP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 40, 40));

        lblP11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP11.setText("-11");
        getContentPane().add(lblP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 50, 40));

        lblP12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP12.setText("-12");
        getContentPane().add(lblP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 60, 40));

        lblP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP1.setText("-1");
        getContentPane().add(lblP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 40, 40));

        lblP15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP15.setText("-15");
        getContentPane().add(lblP15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 60, 40));

        lblP14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AvalableParking.png"))); // NOI18N
        lblP14.setText("-14");
        getContentPane().add(lblP14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 50, 40));

        lblRotativoParque.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parque de viaturas rotativa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        getContentPane().add(lblRotativoParque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 600, 170));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 670, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckParque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckParque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckParque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckParque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckParque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP11;
    private javax.swing.JLabel lblP12;
    private javax.swing.JLabel lblP13;
    private javax.swing.JLabel lblP14;
    private javax.swing.JLabel lblP15;
    private javax.swing.JLabel lblP16;
    private javax.swing.JLabel lblP17;
    private javax.swing.JLabel lblP18;
    private javax.swing.JLabel lblP19;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP20;
    private javax.swing.JLabel lblP3;
    private javax.swing.JLabel lblP4;
    private javax.swing.JLabel lblP5;
    private javax.swing.JLabel lblP6;
    private javax.swing.JLabel lblP7;
    private javax.swing.JLabel lblP8;
    private javax.swing.JLabel lblP9;
    private javax.swing.JLabel lblRotativoParque;
    private javax.swing.JLabel lblVIPParque;
    // End of variables declaration//GEN-END:variables
}

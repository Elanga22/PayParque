
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SNdzekos
 */
public class ListContratos extends javax.swing.JFrame {
static int LineFound;
    /**
     * Creates new form ListContratos
     */
    public ListContratos() {
        initComponents();
        
        setIconApp();
         btnExcluirContracto.setEnabled(false);
    }
  
    
    
    /*METODO PARA LISTAR OS CONTRATOS
    
    */
    
    public void ListContratos() throws IOException{
     
     
     
        String filePath="contratos.txt";
        
        File file=new File(filePath);
       try {
           BufferedReader br=new BufferedReader(new FileReader(file));
           
           String firstLine=br.readLine().trim();
           String[] columnsName=firstLine.split(",");
           
           DefaultTableModel model=(DefaultTableModel)tblContratos.getModel();
           model.setColumnIdentifiers(columnsName);
           
           
          Object[] tableLines=br.lines().toArray();
           for (int i = 0; i < tableLines.length; i++) {
               
               String line= tableLines[i].toString().trim();
               String[] dataRow=line.split("/");
               model.addRow(dataRow);
               
           }
           
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
        
     
 }
    
    /*
    FUNCAO PARA REMOVER OU EXCLUIR OS CONTRACTOS
    
    */
    
    public void pegaLinha() throws FileNotFoundException{
        
         /*
      1-Passo Filtrando codigo de referenca.
      */
       File ficheiroC=new File("contratos.txt");
    String IDA; //o id dos dados
    String TargetLin="9"; //valor da linha procurada
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    
     String cathREF="";
    System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa++;
    LineFound=Linhaa;
    System.out.println("Linha :"+LineFound);
    linhaA=linh.nextLine();    
    if(Linhaa>1){
    System.out.println(""+linhaA);
       Scanner SCR=new Scanner(linhaA);
       SCR.useDelimiter("/");
        //abrir uma sequencia de for para encontrar valor de cada campo
       
       cathREF=SCR.next();
                 
    }else{
        
    }
    
    
}
       System.out.println("******************************************************************************");
        System.out.println("Referencia :"+cathREF);
        System.out.println("*********************************************************************"); 
    }
   
    static String FilePathString="contratos.txt";
    public void excluirContratos(String filepath, int deleteLine){
        
        
     String tempFile="temp.txt";
     File oldFile=new File(filepath);
     File newFile=new File(tempFile);
     
     int line=0;
     String currentLine;
     try{
         FileWriter fw=new FileWriter(tempFile,true);
         BufferedWriter bw=new BufferedWriter(fw);
         PrintWriter pw=new PrintWriter(bw);
         
         FileReader fr=new FileReader(filepath);
         BufferedReader br=new BufferedReader(fr);
         
         
         //precorendo o numero de linhas existentes dentro do ficheiro de dados.
         
         while((currentLine=br.readLine()) !=null){
             
             line++;
             if(deleteLine !=line){
                 pw.println(currentLine);
                 
                 
             }
         }
         JOptionPane.showMessageDialog(this, "Contrato excluido !");
         pw.flush();
         pw.close();
         fr.close();
         br.close();
         bw.close();
         fw.close();
         
         //chamando o metodo para excluir o ficheiro antigo.
         
         oldFile.delete();
         File dump=new File(filepath);
         newFile.renameTo(dump);
         
         
     }
     catch(Exception e){
         
     }
     
 
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblPickEdit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContratos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaPrintContract = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaPrintID = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnExcluirContracto = new javax.swing.JButton();
        lblCathRef = new javax.swing.JLabel();
        btnCarregarLista = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nº de Documento (B.I / Passaport) ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Referência do Contracto ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 180, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 260, 30));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/findIT.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 30, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/printContrato.png"))); // NOI18N
        jButton2.setText("Print-Contrato");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 50, 150, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/printCard.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 60, 30));

        lblPickEdit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisa :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        getContentPane().add(lblPickEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 67, 340, 120));

        tblContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblContratos.setSelectionBackground(new java.awt.Color(204, 0, 51));
        tblContratos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContratos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 1310, 200));

        textAreaPrintContract.setColumns(20);
        textAreaPrintContract.setRows(5);
        jScrollPane2.setViewportView(textAreaPrintContract);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 610, 330));

        textAreaPrintID.setColumns(20);
        textAreaPrintID.setRows(5);
        jScrollPane3.setViewportView(textAreaPrintID);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 340, 180));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("GERAR CARTÃO DE ACESSO AO PARQUE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 280, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setText("IMPRESSÃO DOS DADOS DO CONTRATO PARA CADA CLIENTE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 46, 450, 40));

        btnExcluirContracto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/deletar.png"))); // NOI18N
        btnExcluirContracto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirContractoActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluirContracto, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 412, 40, 30));

        lblCathRef.setText("************");
        getContentPane().add(lblCathRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 140, 20));

        btnCarregarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/load.png"))); // NOI18N
        btnCarregarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarregarLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 412, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirContractoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirContractoActionPerformed
/*
        try {
        pegaLinha();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(ListContratos.class.getName()).log(Level.SEVERE, null, ex);
    }
        */

excluirContratos("contratos.txt",2);

       
    }//GEN-LAST:event_btnExcluirContractoActionPerformed

    private void tblContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContratosMouseClicked
        
       textAreaPrintID.setText("");
        /*Enviando os dados da linha selecionada para os labls*/
        
        DefaultTableModel valores= (DefaultTableModel) tblContratos.getModel();
        
        int row= tblContratos.getSelectedRow();
        
        String ref=( tblContratos.getModel().getValueAt(row, 0).toString());
        String nomeProp=( tblContratos.getModel().getValueAt(row, 1).toString());
        String GenroProp=( tblContratos.getModel().getValueAt(row, 2).toString());
        String NrDocumentProp=( tblContratos.getModel().getValueAt(row, 3).toString());
        String nacionalidProp=( tblContratos.getModel().getValueAt(row, 4).toString());
        String telefonProp=( tblContratos.getModel().getValueAt(row, 5).toString());
        String categorProp=( tblContratos.getModel().getValueAt(row, 6).toString());
        String marcaProp=( tblContratos.getModel().getValueAt(row, 7).toString());
        String modeloProp=( tblContratos.getModel().getValueAt(row, 8).toString());
        String motorProp=( tblContratos.getModel().getValueAt(row, 9).toString());
        String caixaProp=( tblContratos.getModel().getValueAt(row, 10).toString());
        String combustivlProp=( tblContratos.getModel().getValueAt(row, 11).toString());
        String nrChassProp=( tblContratos.getModel().getValueAt(row, 12).toString());
        String tipoVProp=( tblContratos.getModel().getValueAt(row, 13).toString());
        String anofProp=( tblContratos.getModel().getValueAt(row, 14).toString());
        String matriProp=( tblContratos.getModel().getValueAt(row, 15).toString());
        
      
        
        lblCathRef.setText(ref);
        
       btnExcluirContracto.setEnabled(true);
       
       /*REPORT DO CARD
       
       */
       Date agora=new Date();
                
    
         textAreaPrintID.setForeground(Color.gray);
       textAreaPrintID.append("--------------------------------------------------------------------------\n"
                             +"---------- CARTÃO DE ACESSO PAY-PARQUE -------------\n"
                             +"--------------------------------------------------------------------------\n"
                             +"Nome :"+nomeProp+"\n"
                             +"Nacionalidade :"+nacionalidProp+"\n"
                             +"Genero :"+GenroProp+"\n"
                             +"---------------------------------------------------------------------------\n"
                             +"Contrato :"+categorProp+"\n"
                             +"Referencia :"+ref+"\n"
                             +"---------------------------------------------------------------------------\n"
                             +"---------------Processado delo computador-------------------\n"
                             +"Data de emissão :"+agora+"\n"
                             +"---------------------------------------------------------------------------\n"
       
       
       
       
       
       
       
       
       );
       
      /* DADOS DO CONTRACTO
       
       */
      double taxaPayP=0.00;
      if((categorProp.trim()).equals("Semanal")){
          taxaPayP=300;
      }else if((categorProp.trim()).equals("Mensal")){
          taxaPayP=550;
      }else if((categorProp.trim()).equals("Anual")){
          taxaPayP=3200;
      }
      
      
      textAreaPrintContract.setText("");
      textAreaPrintContract.append("______________________________________________________________________________\n"
                                  +"----------------------------CONTRACTO DE ACESSO AO PARQUE DA PAY-PARQUE ----------------------------\n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
                                  +"Dados Pessoais:                                 Ref:"+ref+"\n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
                                  +"Nome :"+nomeProp+"                    Nº de Documentos :"+NrDocumentProp+"\n"
                                  +"Genero :"+GenroProp+"\n"
                                  +"Nacionalidade :"+nacionalidProp+"\n"
                                  +"Contacto  :"+telefonProp+"                      Categoria: "+categorProp+"\n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
                                  +"Informações da viatura :\n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
                                  +"Marca :"+marcaProp+"\n"
                                  +"Modelo :"+modeloProp+"\n"
                                  +"Motor :"+motorProp+"\n"
                                  +"Caixa :"+caixaProp+"\n"
                                  +"Combustivel :"+combustivlProp+"\n"
                                  +"Nº do quadro :"+nrChassProp+"\n"
                                  +"Tipo da Viatura :"+tipoVProp+"\n"
                                  +"Ano do fabrico :"+anofProp+"\n"
                                  +"Matricula :"+marcaProp+"\n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
                                  +"Taxa Correspondent : "+taxaPayP+"0 MT \n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
                                  +"Impresso pelo computador,  Data de Emissao:"+agora+"\n"
                                  +"----------------------------------------------------------------------------------------------------------------------------------------\n"
      
      
      
                                    
      
      );
      
      
       
       
       
          
        
    }//GEN-LAST:event_tblContratosMouseClicked

    private void btnCarregarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarListaActionPerformed
      
         try {
            // TODO add your handling code here:

            ListContratos();
        } catch (IOException ex) {
            Logger.getLogger(ListContratos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCarregarListaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if(textAreaPrintID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Selecione os dados da tabela para poder fazer a impressão !");
        }else{
            
   
    try {
        textAreaPrintID.print();
    } catch (PrinterException ex) {
        Logger.getLogger(ListContratos.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
       
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

         if(textAreaPrintID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Selecione os dados da tabela para poder fazer a impressão !");
        }else{
            
        try {
        // TODO add your handling code here:
        
        textAreaPrintContract.print();
    } catch (PrinterException ex) {
        Logger.getLogger(ListContratos.class.getName()).log(Level.SEVERE, null, ex);
    }
         }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ListContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListContratos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarLista;
    private javax.swing.JButton btnExcluirContracto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCathRef;
    private javax.swing.JLabel lblPickEdit;
    private javax.swing.JTable tblContratos;
    private javax.swing.JTextArea textAreaPrintContract;
    private javax.swing.JTextArea textAreaPrintID;
    // End of variables declaration//GEN-END:variables
}

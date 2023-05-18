

import Querys.conexao;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.SoundbankResource;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSetMetaData;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SNdzekos
 */
 

public class menu extends javax.swing.JFrame {
    
    //Metodo onload Utilizadores table
   
    
   // listUtilizadores();
    
    
    //OBJECTO DA CONEXAO 
      Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    //PERFILE PARA NOVO UTILIZADOR
    static String newProfile;
    
    
   static  String vagaP;
   static String sendAction="";
   static String  actualTime;
   static String SDHora;
   static String parqueActive;
   static String Genero="";
   static String ActionHistry="";
   static String cathNormalDate="";
   static String catchIDFiltraSaidas;
File file=new File("entradasSaidas.txt");
public void createNewFile(){
    if(!file.exists()){
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public void setIconApp(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/pinkHomeLogo.png")));
}
        

int contarLinhas=0;
public void contaLinha(){
    try {
        contarLinhas=0;
        RandomAccessFile raf=new RandomAccessFile(file, "rw");
        while(raf.readLine()!=null){
            contarLinhas++;
        }
        raf.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    }
    
   
    
}


        



public void pegaLinhaIndex() throws FileNotFoundException{
    File ficheiroC=new File("entradasSaidas.txt");
    String IDA; //o id dos dados
    String TargetLin="9"; //valor da linha procurada
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    linhaA=linh.nextLine();
    IDA=linhaA.substring(0, 1);
    
    if(IDA.equals(TargetLin)){
        System.out.println("Nr-Linha :"+Linhaa);
        System.out.println("ID :"+IDA);
        System.out.println("Conteudo :"+linhaA);
        System.out.println("--------------------------------------------------------");
        
        
        Scanner SCR=new Scanner(linhaA);
        SCR.useDelimiter("/");
        
        //abrir uma sequencia de for para encontrar valor de cada campo
        String cathID;
        String cathProprietario;
        String cathMarca;
        String cathModelo;
        String cathMatricula;
        String cathNrChassis;
        String CheckNextSP, linhaACT;
        int posiSeparador=0;
        int indexSeparador, SPX=0;
        //variaveis auxiliares da manipulacao.
       cathID=SCR.next();
       cathProprietario=SCR.next();
        cathMarca=SCR.next();
       cathModelo=SCR.next();
       cathMatricula=SCR.next();
       cathNrChassis=SCR.next();
       
         
       System.out.println("******************************************************************************");
        System.out.println("ID:"+cathID);
        System.out.println("Nome do proprietario :"+cathProprietario);
        System.out.println("Marca:"+cathMarca);
        System.out.println("Modelo:"+cathModelo);
        System.out.println("Matricula:"+cathMatricula);
        System.out.println("Numero de Quadro :"+cathNrChassis);
        System.out.println("*********************************************************************");
    }else{
        
    }
    
    
    
    
}
}
/*Carregando os dados da viatura para a entrada atravez do numero ou codigo de referencia.

*/
public void carregaContratos() throws FileNotFoundException{
    File ficheiroC=new File("contratos.txt");
    String IDA; //o id dos dados
   
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
  
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    linhaA=linh.nextLine();   
    if(Linhaa>1){
      
        Scanner SCR=new Scanner(linhaA);
        SCR.useDelimiter("/");
        
        //abrir uma sequencia de for para encontrar valor de cada campo
        String cathRF,cathProprietario,CathGenero,cathDocumento,cathNacionalidade,cathTelefone,cathCategoria,cathMarca,cathModelo,cathMotor,cathCaixa,cathCombustivel,cathNrChassis,cathTipoV, cathAnoFabrico,cathMatricula;
        
        
       cathRF=SCR.next();
       cathProprietario=SCR.next();
       CathGenero=SCR.next();
       cathDocumento=SCR.next();
       cathNacionalidade=SCR.next();
       cathTelefone=SCR.next();
       cathCategoria=SCR.next();
        cathMarca=SCR.next();
       cathModelo=SCR.next();
       cathMotor=SCR.next();
       cathCaixa=SCR.next();
       cathCombustivel=SCR.next();
       cathNrChassis=SCR.next();
       cathTipoV=SCR.next();
       cathAnoFabrico=SCR.next();
       cathMatricula=SCR.next();
       
       
       
       /*
 estacao
       */

       
       if((cathRF.trim()).equals(txtFind_EntradaSaidas.getText())){
            
           lblcatchedREF.setText(cathRF);
           txtRegist_Proprietario.setText(cathProprietario);
           txtRegist_Marca1.setText(cathMarca);
           txtRegist_Matricula.setText(cathMatricula);
           txtModeloRegist.setText(cathModelo);
           txtRegist_NrChassis.setText(cathNrChassis);
           lblStation.setText(cathCategoria.trim());
           
           /*
           Enviando a hora actual para a variavel de armazenamento da hora
           */
           lblHoraEntrada.setText(SDHora);
           
           
           
                    if(lblStation.getText().equals("")){
    
    
}else if(lblStation.getText().equals("Semanal")){
   txtRegist_TotalPagar.setText("400"); 
}if(lblStation.getText().equals("Mensal")){
     txtRegist_TotalPagar.setText("2200");
}if(lblStation.getText().equals("Mensal")){
    txtRegist_TotalPagar.setText("8000");
}
 

    }else{
           lblHoraEntrada.setText(SDHora);
        
    }
   
}
}


}

/*metodo para bloqueiar vagas ocupadas */
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
           
         rdVaga_P1.setForeground(Color.red);
         rdVaga_P1.setEnabled(false);
       }
       if((cathLugar).trim().equals("P2")){
           rdVaga_P2.setForeground(Color.red);
         rdVaga_P2.setEnabled(false);
           
       }
       if((cathLugar).trim().equals("P3")){
          rdVaga_P3.setForeground(Color.red);
         rdVaga_P3.setEnabled(false);
           
       }
       if((cathLugar).trim().equals("P4")){
           rdVaga_P4.setForeground(Color.red);
         rdVaga_P4.setEnabled(false);
       }
       if((cathLugar).trim().equals("P5")){
          rdVaga_P5.setForeground(Color.red);
         rdVaga_P5.setEnabled(false);
       }
       if((cathLugar).trim().equals("P6")){
           rdVaga_P6.setForeground(Color.red);
         rdVaga_P6.setEnabled(false);
       } 
       if((cathLugar).trim().equals("P7")){
           rdVaga_P7.setForeground(Color.red);
         rdVaga_P7.setEnabled(false);
       }
       if((cathLugar).trim().equals("P8")){
           rdVaga_P8.setForeground(Color.red);
         rdVaga_P8.setEnabled(false);
       }
       if((cathLugar).trim().equals("P9")){
           rdVaga_P9.setForeground(Color.red);
         rdVaga_P9.setEnabled(false);
       }
       if((cathLugar).trim().equals("P10")){
           rdVaga_P10.setForeground(Color.red);
         rdVaga_P10.setEnabled(false);
       }
       if((cathLugar).trim().equals("P11")){
           rdVaga_P11.setForeground(Color.red);
         rdVaga_P11.setEnabled(false);
       }
       if((cathLugar).trim().equals("P12")){
          rdVaga_P12.setForeground(Color.red);
         rdVaga_P12.setEnabled(false);
       }
       if((cathLugar).trim().equals("P13")){
          
           rdVaga_P13.setForeground(Color.red);
         rdVaga_P13.setEnabled(false);
       }
       if((cathLugar).trim().equals("P14")){
           
            rdVaga_P14.setForeground(Color.red);
         rdVaga_P14.setEnabled(false);
       }
       if((cathLugar).trim().equals("P15")){
          rdVaga_P15.setForeground(Color.red);
         rdVaga_P15.setEnabled(false);
       }
       if((cathLugar).trim().equals("P16")){
          rdVaga_P16.setForeground(Color.red);
         rdVaga_P16.setEnabled(false);  
       }
       if((cathLugar).trim().equals("P17")){
            rdVaga_P16.setForeground(Color.red);
         rdVaga_P16.setEnabled(false);
       }
       if((cathLugar).trim().equals("P18")){
            rdVaga_P18.setForeground(Color.red);
         rdVaga_P18.setEnabled(false);
       }
       if((cathLugar).trim().equals("P19")){
            rdVaga_P15.setForeground(Color.red);
         rdVaga_P15.setEnabled(false);
       }
       if((cathLugar).trim().equals("P20")){
            rdVaga_P20.setForeground(Color.red);
         rdVaga_P20.setEnabled(false);
       }
           
       
//            
//       System.out.println("******************************************************************************");
//        System.out.println("VAGA:"+cathLugar);
//       
//        System.out.println("*********************************************************************");   
    
    }else{
        
    }
    
}

    
//    System.out.println(""+linh.nextLine());
   
    }



/*Carregar dados das viaturas que deram entrada

*/
public void pegaValoreseEntradas() throws FileNotFoundException{
   
    File ficheiroC=new File("entradasSaidas.txt");
    String IDA; //o id dos dados
    String TargetLin="9"; //valor da linha procurada
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    linhaA=linh.nextLine();
    IDA=linhaA.substring(0, 1);
    
    if(Linhaa>1){
        
    
    System.out.println(""+linhaA);
       Scanner SCR=new Scanner(linhaA);
       SCR.useDelimiter("/");
        
        //abrir uma sequencia de for para encontrar valor de cada campo
        String cathID,cathProprietario,cathMatricula,cathMarca,cathModelo,cathEstacao, cathLugar, cathHEntrada, cathCategoria, cathrefere, cathData;
        
      
       String CheckNextSP, linhaACT;
        int posiSeparador=0;
        int indexSeparador, SPX=0;
        //variaveis auxiliares da manipulacao.
       cathID=SCR.next();
       cathProprietario=SCR.next();
       cathMatricula=(SCR.next()).trim();
        cathMarca=SCR.next();
       cathModelo=SCR.next();
       cathEstacao=SCR.next();
       cathLugar=SCR.next();
       cathHEntrada=SCR.next();
       cathCategoria=SCR.next();
        cathrefere=SCR.next();
       cathData=SCR.next();
       
      cathMatricula.trim();
       
       if(txtFind_EntradaSaidas.getText().equals(cathMatricula)){
           txtRegist_Marca1.setText(cathMarca);
           txtRegist_Matricula.setText(cathMatricula);
           txtRegist_Proprietario.setText(cathProprietario);
           txtModeloRegist.setText(cathModelo);
           lblHoraEntrada.setText(cathHEntrada);
           lblStation.setText(cathCategoria);
           lblcatchedREF.setText(cathrefere);
           lblDataSaidas.setText(cathData);
//
           parqueActive=cathLugar;
          lblParqueAux.setText(cathLugar);
         
       }else{
           JOptionPane.showMessageDialog(this, "Nenhuma viatura foi encontrada !");
           
       }
            
       System.out.println("******************************************************************************");
        System.out.println("ID:"+cathID);
        System.out.println("Nome do proprietario :"+cathProprietario);
        System.out.println("Marca:"+cathMarca);
        System.out.println("Modelo:"+cathModelo);
        System.out.println("Matricula:"+cathMatricula);
        System.out.println("Estação :"+cathEstacao);
         System.out.println("Parque  :"+cathLugar);
         System.out.println("Categoria :"+cathCategoria);
          System.out.println("Hora de entrada :"+cathHEntrada);
            System.out.println("Parque Ocupado :"+parqueActive);
        System.out.println("*********************************************************************");   
    
    }else{
        
    }
    if(lblStation.getText().equals("")){
    
    
}else if(lblStation.getText().equals("Semanal")){
   txtRegist_TotalPagar.setText("400"); 
}if(lblStation.getText().equals("Mensal")){
     txtRegist_TotalPagar.setText("2200");
}if(lblStation.getText().equals("Mensal")){
    txtRegist_TotalPagar.setText("8000");
}
 
    
}


//Calculando a duracao;

getDuracao();
   
//    System.out.println(""+linh.nextLine());
   


    
}




/*metodo de consulta usando a referencia*/

public void pegaValoresREFERENCIA() throws FileNotFoundException{
    
    File ficheiroC=new File("entradasSaidas.txt");
    String IDA; //o id dos dados
    String TargetLin="9"; //valor da linha procurada
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    linhaA=linh.nextLine();
    IDA=linhaA.substring(0, 1);
    
    if(Linhaa>1){
        
    
    System.out.println(""+linhaA);
       Scanner SCR=new Scanner(linhaA);
       SCR.useDelimiter("/");
        
        //abrir uma sequencia de for para encontrar valor de cada campo
        String cathID,cathProprietario,cathMatricula,cathMarca,cathModelo,cathEstacao, cathLugar, cathHEntrada, cathCategoria, cathrefere, cathData;
        
      
       String CheckNextSP, linhaACT;
        int posiSeparador=0;
        int indexSeparador, SPX=0;
        //variaveis auxiliares da manipulacao.
       cathID=SCR.next();
       cathProprietario=SCR.next();
       cathMatricula=(SCR.next()).trim();
        cathMarca=SCR.next();
       cathModelo=SCR.next();
       cathEstacao=SCR.next();
       cathLugar=SCR.next();
       cathHEntrada=SCR.next();
       cathCategoria=SCR.next();
        cathrefere=SCR.next();
       cathData=SCR.next();
      cathMatricula.trim();
       
       if(txtFind_EntradaSaidas.getText().equals(cathrefere)){
           txtRegist_Marca1.setText(cathMarca);
           txtRegist_Matricula.setText(cathMatricula);
           txtRegist_Proprietario.setText(cathProprietario);
           txtModeloRegist.setText(cathModelo);
           lblHoraEntrada.setText(cathHEntrada);
           lblStation.setText(cathCategoria);
           lblcatchedREF.setText(cathrefere);
           lblDataSaidas.setText(cathData);
//
           parqueActive=cathLugar;
          lblParqueAux.setText(cathLugar);
         
       }else{
           JOptionPane.showMessageDialog(this, "Nenhuma viatura foi encontrada !");
           
       }
            
       System.out.println("******************************************************************************");
        System.out.println("ID:"+cathID);
        System.out.println("Nome do proprietario :"+cathProprietario);
        System.out.println("Marca:"+cathMarca);
        System.out.println("Modelo:"+cathModelo);
        System.out.println("Matricula:"+cathMatricula);
        System.out.println("Estação :"+cathEstacao);
         System.out.println("Parque  :"+cathLugar);
         System.out.println("Categoria :"+cathCategoria);
          System.out.println("Hora de entrada :"+cathHEntrada);
            System.out.println("Parque Ocupado :"+parqueActive);
        System.out.println("*********************************************************************");   
    
    }else{
        
    }
    
}


if(lblStation.getText().equals("")){
    
    
}else if(lblStation.getText().equals("Semanal")){
   txtRegist_TotalPagar.setText("400"); 
}if(lblStation.getText().equals("Mensal")){
     txtRegist_TotalPagar.setText("2200");
}if(lblStation.getText().equals("Mensal")){
    txtRegist_TotalPagar.setText("8000");
}else{
    
   getDuracao(); 
}
 

//Calculando a duracao;


   
//    System.out.println(""+linh.nextLine());
   


    
}





//Habilitado os parques disponiveis e indiponiveis
public  void EnableParques(){
        
}

public void showDatas(){
    String titleLine="Marca |Modelo ";
    try {
        BufferedReader reader=new BufferedReader(new FileReader(file));
//        DefaultTableModel model=(DefaultTableModel)tblEntradaSaida.getModel();
//        model.getDataVector().removeAllElements();
//        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}


public void saveParking(){
    contaLinha();
    try {
        RandomAccessFile raf=new RandomAccessFile(file, "rw");
        for (int i = 1; i <=contarLinhas; i++) {
            raf.readLine();
        }
        
        raf.writeBytes(lblIDEntradas.getText()+"/"+txtRegist_Proprietario.getText()+"/ "+txtRegist_Matricula.getText()+"/ "+txtRegist_Marca1.getText()+"/ "+txtModeloRegist.getText()+"/ "+cmbEstacao.getSelectedItem()+"/ "+vagaP+"/ "+lblHoraEntrada.getText()+"/ "+lblStation.getText()+"/"+lblcatchedREF.getText()+"/"+lblDataNow.getText());
        raf.writeBytes(System.lineSeparator());
        raf.close();
        
        JOptionPane.showMessageDialog(this, "Nova viatura alocada para o estacionamento :"+vagaP);
        
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    }


} 
 
 String dataActual;
 static int tamanhoHora;

 static String onlineUser;
 static String perfileUtilizador;
/**
     * Creates new form menu
     */
    CardLayout cardLayouts;
    public menu(String ONL, String perl ) throws FileNotFoundException {
        initComponents();
        listUtilizadores();
        onlineUser=ONL;
        perfileUtilizador=perl;
       lblLogedUser.setText(onlineUser);
       
       /*
       DSABILITANDO CONTROLOS DE REGISTO DE ENTRADAS.
       */
       btnConfirmarPagamento.setEnabled(false);
       btnAnularPagamento.setEnabled(false);
       
       
       
       
       
       /*Desabilitando os filtros de saidas
       */
        lblDocSaidas.setVisible(false);
        rdFeacthMatricula.setVisible(false);
        rdFeacthREF.setVisible(false);
        
        /*Bloquear as estacoes*/
        geraEstacoes();
        
        
       lblprofileLoged.setText(perfileUtilizador);
      getDataHoje();
      permissoes();
     VerificarVagas();   
         lblDocSaidas.setVisible(false);
      
        /*
        Desabilitando os butoes do formulario de Cadastro de Contratos
        
        */
        btnCancelarContracto.setEnabled(false);
        btnContract_Editar.setEnabled(false);
        setIconApp();        
        TempoPermanenca();    
        Date currentTime=new Date();
       dataActual=String.valueOf(currentTime);
        lblTimeRGST.setText(dataActual);
        SimpleDateFormat horas=new SimpleDateFormat("hh:mm aa");
                activarParques();
        cardLayouts=(CardLayout)(PnlCardLayouts.getLayout());       
    }
    
    public void getMovimentoSE() throws IOException{
        
        String filePath="entradasSaidas.txt";
        
        File file=new File(filePath);
       try {
           BufferedReader br=new BufferedReader(new FileReader(file));
           
           String firstLine=br.readLine().trim();
           String[] columnsName=firstLine.split(",");
           
           DefaultTableModel model=(DefaultTableModel)tblMovimento_SaidaEntrada.getModel();
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
    public  void activarParques(){
    //ACTIVANDO A COR PADRAO DE TODOS OS CAMPOS
   rdVaga_P1.setForeground(Color.green);
 
   
}    public void desable_parques(){
        
    rdVaga_P1.setEnabled(false);
    rdVaga_P2.setEnabled(false);
    rdVaga_P3.setEnabled(false);
    rdVaga_P4.setEnabled(false);
    rdVaga_P9.setEnabled(false);
    rdVaga_P10.setEnabled(false);
    rdVaga_P11.setEnabled(false);
    rdVaga_P8.setEnabled(false);
    rdVaga_P5.setEnabled(false);
    rdVaga_P1.setEnabled(false);
    }



public static void TempoPermanenca(){
     Date currentTime=new Date();
     SimpleDateFormat horas=new SimpleDateFormat("hh:mm aa");
     Calendar dias=Calendar.getInstance();
     
    String  horaActual;
    String trimedHora;
    String passHoraValue;
    String EngHora;
    String PtHora;
    String minutosPhora;
   String  dataHoje;
 
    
    String captureMinuto,captureHora;
   
    float valCP, minutosCorresp=0;
    int timePT=00;
    double valUnit=0;
    double U1 = 100;
    double U2 = 60;
     valUnit=(U1/U2);
    
    
    System.out.println("Valor Unitario :"+valUnit);
    String periodo;
    
        horaActual=String.valueOf(horas.format(currentTime));
        tamanhoHora=horaActual.length();
        
        trimedHora=horaActual.trim();
        periodo=String.valueOf(trimedHora.subSequence(6, tamanhoHora));
        EngHora=trimedHora.substring(0, 2);
        System.out.println("Horas :"+trimedHora);
        
        
       
        
        
       System.out.println("Agoro o perdiodo E : "+periodo);
       System.out.println("Hora CHECK : "+EngHora);
       
       //Carregando minutos.
       minutosPhora=String.valueOf(horaActual.substring(3,5));
       System.out.println("Minutos : "+minutosPhora);
       
       
      
       // de 1 ate 11 temos de Dia
       //de 1 ate 11 temos da tarde
       
       if(periodo.equals("da tarde")|| periodo.equals("PM")){
           
           
           
           switch (EngHora) {
               case "01":
                   timePT=13;
                   PtHora=timePT+(horaActual.substring(2, 7));
                   System.out.println("Hora PT-pt : "+PtHora);
                   
                   break;
                    case "02":
                      timePT=14;
                   PtHora=timePT+(horaActual.substring(2, 7));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   
                   break;
                    case "03":
                      timePT=15;
                   PtHora=timePT+(horaActual.substring(2, 7));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   break;
                    case "04":
                           timePT=16;
                   PtHora=timePT+(horaActual.substring(2, 5));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   
                   break;
                    case "05":
                      timePT=18;
                   PtHora=timePT+(horaActual.substring(2, 7));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   break;
                    case "06":
                        
                      timePT=18;
                   PtHora=timePT+(horaActual.substring(2, 7));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   break;
                    case "07":
                           timePT=19;
                   PtHora=timePT+(horaActual.substring(2, tamanhoHora));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   
                   break;
                    case "08":
                      timePT=20;
                   PtHora=timePT+(horaActual.substring(2, tamanhoHora));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   break;
                    case "09":
                           timePT=21;
                   PtHora=timePT+(horaActual.substring(2, tamanhoHora));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   
                   break;
                    case "10":
                      timePT=22;
                   PtHora=timePT+(horaActual.substring(2, tamanhoHora));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   break;
                    case "11":
                      timePT=23;
                   PtHora=timePT+(horaActual.substring(2, tamanhoHora));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   break;
                    case "12":
                      timePT=00;
                   PtHora=timePT+(horaActual.substring(2, tamanhoHora));
                   System.out.println("Hora PT-pt : "+PtHora);  
                   
                   break;
               default:
                   throw new AssertionError();
           }
           actualTime=PtHora;
           SDHora=PtHora;
           
       }else{
           
           actualTime=SDHora;
           //se for de dia.
           
       }
       
      //CONVERTER HORAS POR MINUTOS.
      
      
       //Verificando os parametros de hora ignorando  o 0 no index 0 nos minutos e na hora.
      captureMinuto=minutosPhora.substring(0,1);
       if(!minutosPhora.equals("0")){
           
           System.out.println("Minutos Validos :"+minutosPhora);
           minutosCorresp=Integer.valueOf(minutosPhora);
           
//           valCP=(minutosCorresp*100)/60;
//           System.out.println("Valor correspondente :"+valCP+" MT ");
           
          
       }else{
           System.out.println("Minutos invalidos");
       }
       
       
       //calcular horas.
      
                 captureHora=String.valueOf(timePT);
                 captureHora=captureHora.substring(0, 1);
                 
       if(captureHora.equals("0")){

//           captureHora=

    if(timePT<=01){
        valCP=100;
    }else{
        
       valCP=(minutosCorresp*60)+100;
       System.out.println("Valor correspondente :"+valCP+" MT ");
    }
    
    
    //SE O PRIMEIRO INDEX FOR DIFERENTE DE 0 ENTAO
       }else{
           
           
           
        double minit,totalPG;
        minit=Double.valueOf(minutosCorresp);
       
        totalPG=(valUnit*minutosCorresp)+100;
        System.out.println("Valor correspondente :"+totalPG+"0 MT");
       
           System.out.println("Valor Unitario :"+valUnit);






           System.out.println("Minutos :"+minutosCorresp);
           
         
       }
       
       
       
        
        
        
}

/*funcao para calcular a duracao

*/


public void getDuracao(){
 
    String horaEntrada=lblHoraEntrada.getText();
    String horaSaida=lblHoraSaida.getText();
    /*
    VERIFICAR SE O VALOR DA HORA E DIFERENTE DE NULL
    */
    if(!(lblHoraSaida.equals(null))){
        System.out.println("DIFERENTE DE NULL");
    }else{
        
        System.out.println("E NUILLO");
    }    
    /*
    1-PASSO: PEGAR OS DOIS PRIMEIROS PARAMETROS DAS HORAS.
    */
    
    int horaCTS=0,horaCTE=0,minuS,minuE, thrs,tmin,td;
    
    horaCTE=Integer.valueOf((horaEntrada.trim()).substring(0,2));
    minuE=Integer.valueOf((horaEntrada.trim()).substring(3,5));
    horaCTS=Integer.valueOf(horaSaida.trim().substring(0,2));
    minuS=Integer.valueOf(horaSaida.trim().substring(3,5));
//    


	
		Date Hoje=new Date();
                String dataEnt="11/11/2022";
		String dia,mes,ano,month="";
                String diaE, mesE,anoE;
		String cumprimData, DataNormal;
		cumprimData=String.valueOf(Hoje);
		cumprimData.trim();
		int tamanho;
		tamanho=cumprimData.length();
		
		dia=cumprimData.substring(8,10);
		ano=cumprimData.substring(24,28);
		
		mes=cumprimData.substring(4,7);
                
                /*Caregando os valores da data de Entrada*/
                diaE=dataEnt.substring(0,2);
                mesE=dataEnt.substring(3,5);
                anoE=dataEnt.substring(6,10);
                
               
                
                
                
                
                
                
               
		
	switch (mes.toUpperCase()) {
	case "JAN":
		month="01";
		break;
case "FEB":
	month="02";
		break;
case "MAR":
	month="03";
	break;
case "APRIL":
	month="04";
	break;
case "JUNMAY":
	month="05";
	
	break;
case "JUN":
	month="06";
	
	break;
case "JUL":
	month="07";
	
	break;
case "AGU":
	month="08";
	
	break;
case "SET":
	month="09";
	
	break;
case "OCT":
	month="10";
	break;
case "NOV":
	month="11";
	
	break;
case "DEC":
	month="12";
	
	break;

	
	
	default:
		break;
	}
	
        /*
        concatenand os paramentors
        
        */
	DataNormal=dia.concat("-").concat(month).concat("-").concat(ano);
	cathNormalDate=DataNormal;
        
        
         /*
                convertendo os valores para inteiro
                */
                
                int datE,monthE,yearE;
                
                /*convertendo dos dados da data de entrada
                
                */
                datE=Integer.valueOf(diaE);
                monthE=Integer.valueOf(mesE);
                yearE=Integer.valueOf(anoE);
                
                
                int rmes=31,rehoras=24;
                int datS,monthS,yearS, monthNow,yearnow,dayNow,finalDurationHora=0,finalDurationDias = 0,finalDurationMinutos=0, minitNow,horanow, totalTime;
                /*convertendo dos dados da data de Saida
                
                */
                datS=Integer.valueOf(dia);
                monthS=Integer.valueOf(month);
                yearS=Integer.valueOf(ano);
                
                
                /*calulando a duracao primeiro devemos verificar se existe uma data maior que a outra.
                
                */
                /*Variavel da duracao e preco 
                
                */
                

    double valUnit=0;
    double U1 = 100;
    double U2 = 60;
     valUnit=(U1/U2);
                
                double precototal = 0;
                
                
                
                if((yearS-yearE)>=1){
                    
                    txtRegist_TotalPagar.setText("8000");
                }else{
                
                                       
                        if(horaCTS<horaCTE){
                            datS=datS-1;
                            horaCTS=horaCTS+24;
                            
                          
                        }
                        if(minuS<minuE){
                            horaCTS=horaCTS-1;
                            minuS=minuS+60;
                        }
                       minitNow=minuS-minuE;
                       horanow=horaCTS-horaCTE;
                       
                        totalTime=(horanow*60)+minitNow;
                        
                    
                        
                        if(datS<datE){
                             monthS=(monthS*31);
                             monthS=monthS-31;
                             monthS=(monthS/12);
                             datS=datS+31;
                             
                             monthNow=monthS-monthE;
                             dayNow=datS-datE;
                             finalDurationDias=((monthNow*31)+dayNow);
                             finalDurationHora=((monthNow*31)+dayNow)*24;
                             finalDurationDias=(((monthNow*31)+dayNow)*24)*60;
                             
                        }else{
                            monthNow=monthS-monthE;
                             dayNow=datS-datE;
                             finalDurationDias=((monthNow*31)+dayNow);
                             finalDurationHora=finalDurationDias*rehoras;
                             finalDurationMinutos=((finalDurationHora)*60);
                            
                            
                        }
     
                        
                       /*
                        verificando os minutos para determinar o preco !
                        */
                       finalDurationMinutos=finalDurationMinutos+totalTime;
                       if(finalDurationMinutos>60){
                           
                           precototal=finalDurationMinutos*valUnit;
                       }else{
                           
                           precototal=100;
                       }
                        
                        
                        
                
                }
                
                
		
		

    
    System.out.println("---------------------------------------------");
    System.out.println("             DURACAO OPTIDA");
    System.out.println("---------------------------------------------");
    System.out.println("Hora de Entrada :"+horaCTE+" Minutos : "+minuE);
    System.out.println("Hora de Saida   :"+horaCTS+" Minutos :"+minuS);
    System.out.println("---------------------------------------------");
    System.out.println("Data de Saida :"+DataNormal);
    System.out.println("Data de Entrada :"+dataEnt);
    System.out.println("----------------------------------------------");
    System.out.println("       CALCULANDO OS MINUTOS E VALOR");
    System.out.println("---------------------------------------------");
    System.out.println("Dias de diferenca :"+finalDurationDias);
    System.out.println("Horas de diferenca :"+finalDurationHora);
    System.out.println("Minutos de diferenca :"+finalDurationMinutos);
    System.out.println("Valor :"+precototal+"0 MT");
    System.out.println("---------------------------------------------");
    
		txtRegist_Duracao.setText(String.valueOf(finalDurationMinutos)+" Minutos");
                txtRegist_TotalPagar.setText(String.valueOf(precototal));
}

/*METODO PARA PEGAR A DATA ACTUAL*/
public void getDataHoje(){
    
    Date Hoje=new Date();
                String dataEnt="11/11/2022";
		String dia,mes,ano,month="";
                String diaE, mesE,anoE;
		String cumprimData, DataNormal;
		cumprimData=String.valueOf(Hoje);
		cumprimData.trim();
		int tamanho;
		tamanho=cumprimData.length();
		
		dia=cumprimData.substring(8,10);
		ano=cumprimData.substring(24,28);
		
		mes=cumprimData.substring(4,7);
                
                /*Caregando os valores da data de Entrada*/
                diaE=dataEnt.substring(0,2);
                mesE=dataEnt.substring(3,5);
                anoE=dataEnt.substring(6,10);
                
               
                
                
                
                
                
                
               
		
	switch (mes.toUpperCase()) {
	case "JAN":
		month="01";
		break;
case "FEB":
	month="02";
		break;
case "MAR":
	month="03";
	break;
case "APRIL":
	month="04";
	break;
case "JUNMAY":
	month="05";
	
	break;
case "JUN":
	month="06";
	
	break;
case "JUL":
	month="07";
	
	break;
case "AGU":
	month="08";
	
	break;
case "SET":
	month="09";
	
	break;
case "OCT":
	month="10";
	break;
case "NOV":
	month="11";
	
	break;
case "DEC":
	month="12";
	
	break;

	
	
	default:
		break;
	}
	
        /*
        concatenand os paramentors
        
        */
	DataNormal=dia.concat("-").concat(month).concat("-").concat(ano);
	cathNormalDate=DataNormal;
        
        lblDataNow.setText(cathNormalDate);
}

 public void picColor(){
         
     //rgb color  rgba(240, 21, 79, 0.888);
     //[153,153,153]
     
     
     int R=153;
     int G=153;
     int B=153;
     
     //encontre os layouts.
     // cardLayouts.show(PnlCardLayouts, "card2");
     
        }
 
 public static void removeRecords(String filepath, int deleteLine){
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
 
 //LimparCampos pois o registo de saidas
 public void limparCamposMovimento(){
    
     txtRegist_Duracao.setText("");
     txtRegist_TotalPagar.setText("");
     txtRegist_Marca1.setText("");
     txtModeloRegist.setText("");
     txtRegist_Proprietario.setText("");
     txtRegist_NrChassis.setText("");
     txtRegist_Matricula.setText("");
}
 
 
 /*
 
 METODO PARA PESQUISAR OU ACTUALIZAR OS DADOS DA ENTRADA DE VIATURA.
 
 */
 private Scanner x;

// public void saveSaida()throws FileNotFoundException{
//     
//      
//  
// }
 
 //metodo para registar as saidas
 

 
 
 /*GERANDO REFERENCIA DO CONTRACTO */
 public void generateContractCode() throws FileNotFoundException{
      
      int cont=100, ano;
      String referenc, referencia;
      
      /*Primeiro consultar o ultimo Contracto e Pegar os valores do numero do contracto*
      Somar o valor do ultimo contracto com mais 10 caso exista
      Se nao existir um contracto com referencia, devemos inicializar com o 100.
      */
      
      
      
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
    Linhaa=Linhaa+1;
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
       
        /*
        2-Passo converter os ultimos digitos da referencia.
        Exemplo : 2022PAY110
        */
        int refTamanh, ValidLastREF,newReferenc;
        String LastRefValue;
                refTamanh=cathREF.length();
                
                System.out.println("Tamnho da Referencia :"+refTamanh);
                LastRefValue=cathREF.substring(7, refTamanh);
                System.out.println("Codigo RF :"+LastRefValue);
                ValidLastREF=Integer.valueOf(LastRefValue);
                System.out.println("Convertido :"+ValidLastREF);
                
                
        /*
                3-Passo : Incrementar mais 10 no valor encontrado na ultima referencia
                */
        
        newReferenc=ValidLastREF+10;
        System.out.println("Novo codigo :"+newReferenc);
        
        
     /*
        4-Passo : Pegar o ano Valido na data Actual
        */
        String dataACC, anoACC;
        dataACC=dataActual;
        dataACC.trim();
                
        int tamanhoDataACC;
        tamanhoDataACC=dataACC.length();
        anoACC=dataACC.substring(24, tamanhoDataACC);
        System.out.println("Tamanho da Data:"+tamanhoDataACC);
     System.out.println("Data hoje :"+dataActual);
     System.out.println("Ano correspondente : "+anoACC);
     
     
     
     /*
     5-Passo:  Concatenar os valores dentro de uma variavel.
     */
     referencia=(String.valueOf(anoACC)).concat("PAY").concat(String.valueOf(newReferenc));
     
     System.out.println("Referencia Gerada :"+referencia);
     lblReferenciaValid.setText(referencia);
     
  } 
 
 
 
 /*
 GERAR O ID DO REGISTO DE ENTRADAS.
 */
 public void generateIDEntradas() throws FileNotFoundException{
      
     
      
      /*Primeiro consultar o ultimo Contracto e Pegar os valores do numero do contracto*
      Somar o valor do ultimo contracto com mais 10 caso exista
      Se nao existir um contracto com referencia, devemos inicializar com o 100.
      */
      
      
      
      /*
      1-Passo Filtrando codigo de referenca.
      */
       File ficheiroC=new File("entradasSaidas.txt");
    
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    
     String cathID="";
    System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    linhaA=linh.nextLine();    
    if(Linhaa>1){
    System.out.println(""+linhaA);
       Scanner SCR=new Scanner(linhaA);
       SCR.useDelimiter("/");
        //abrir uma sequencia de for para encontrar valor de cada campo
       
       cathID=SCR.next();
                 
    }else{
        
    }
    
    
}
       System.out.println("******************************************************************************");
        System.out.println("Ultimo ID :"+cathID);
        System.out.println("*********************************************************************"); 
       
        /*
        2-Passo converter os ultimos digitos da referencia.
        Exemplo : 2022PAY110
        */
        int recentID, foundID=1;
        
        foundID=Integer.valueOf(cathID);
            
                
        /*
                3-Passo : Incrementar mais 1 no valor encontrado na ultima referencia
                */
        recentID=foundID+1;
     System.out.println("NOVO ID :"+recentID);
     lblIDEntradas.setText(String.valueOf(recentID));
    
 }

 /*
 GERAR O ID DAS SAIDAS.
 */
 
 public void generateSaidasID() throws FileNotFoundException{
     
     
      
      /*Primeiro consultar o ultimo Contracto e Pegar os valores do numero do contracto*
      Somar o valor do ultimo contracto com mais 10 caso exista
      Se nao existir um contracto com referencia, devemos inicializar com o 100.
      */
      
      
      
      /*
      1-Passo Filtrando codigo de referenca.
      */
       File ficheiroC=new File("saidas.txt");
    
    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    
     String cathID="";
    System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    linhaA=linh.nextLine();    
    if(Linhaa>1){
    System.out.println(""+linhaA);
       Scanner SCR=new Scanner(linhaA);
       SCR.useDelimiter("/");
        //abrir uma sequencia de for para encontrar valor de cada campo
       
       cathID=SCR.next();
                 
    }else{
        
    }
    
    
}
       System.out.println("******************************************************************************");
        System.out.println("Ultimo ID das saidas :"+cathID);
        System.out.println("*********************************************************************"); 
       
        /*
        2-Passo converter os ultimos digitos da referencia.
        Exemplo : 2022PAY110
        */
        int recentID, foundID=1;
        
        foundID=Integer.valueOf(cathID);
            
                
        /*
                3-Passo : Incrementar mais 1 no valor encontrado na ultima referencia
                */
        recentID=foundID+1;
     System.out.println("NOVO ID das saidas  :"+recentID);
     lblIDEntradas.setText(String.valueOf(recentID));
     
    
 }


/*LISTA CONTRACTOS
 
 */
 
 /*
 CARREGANDO A LINHA DO CONTRACTO ENCONTRADO.
 */
 
 static int LineFound;
 public void pegaLinha() throws FileNotFoundException{
        
         /*
     METODO PARA ENCONTRAR O NUMERO DE LINHA DE CADA CONTRACTO.
      */
       File ficheiroC=new File("contratos.txt");
    String IDA; //o id dos dados

    int Linhaa=0;  //numero da linha precorida
   String linhaA=""; //a linha impressa.
    Scanner linh=new Scanner(ficheiroC);
    /*Proprietario, NrDocumento
Genero, Telefone
    */
        
     String cathREF="",nomeP="", nrDocument,Gender,telefon,nationalit;
    System.out.println("-------------------------------------------------------");
while(linh.hasNext()){
    Linhaa=Linhaa+1;
    
    System.out.println("Linha :"+LineFound);
    linhaA=linh.nextLine();    
    if(Linhaa>1){
    System.out.println(""+linhaA);
       Scanner SCR=new Scanner(linhaA);
       SCR.useDelimiter("/");
        //abrir uma sequencia de for para encontrar valor de cada campo
       cathREF=SCR.next();
       nomeP=SCR.next();
        Gender=SCR.next();
        nrDocument=SCR.next();
        nationalit=SCR.next();
       telefon=SCR.next();
      
       if((cathREF.trim()).equals(txtContract_FindViatura.getText())){
           LineFound=Linhaa;
            lblFoundLine.setText(String.valueOf(LineFound));
            txtContract_Proprietario.setText(nomeP);
            txtContract_Documento.setText(nrDocument);
            lblGeneroContract.setText(Gender);
            txtContract_Telefone.setText(telefon);
            
            btnCancelarContracto.setEnabled(true);
        btnContract_Editar.setEnabled(true);
        btnCancelarContracto.setEnabled(true);
        
        
        
        btnContract_Guardar.setEnabled(false);
       
   
       }else{
           
           
       }
                 
    }else{
        
    }
    
    
}
       
       System.out.println("******************************************************************************");
       System.out.println("Linha :"+LineFound);
        System.out.println("Referencia :"+cathREF);
        System.out.println("Proprietario:"+nomeP);
        System.out.println("*********************************************************************"); 
    }
 
 
 
 
 
 /*
 RESTRICOES DE ACESSO .
 */
 
 public void permissoes(){
     
     if(perfileUtilizador.equals("admin")){
         
         PnButtonRegistarEntradas.setVisible(true);
PnButtonRegistarStatus.setVisible(true);
PnButtonRegistarHistory.setVisible(true);
PnButtonRegistarContratos.setVisible(true);
PnButtonRegistarDefinicoes.setVisible(true);
         
     }else if(perfileUtilizador.equals("gestor")){
                 PnButtonRegistarEntradas.setVisible(true);
PnButtonRegistarStatus.setVisible(true);
PnButtonRegistarHistory.setVisible(true);
PnButtonRegistarContratos.setVisible(true);
PnButtonRegistarDefinicoes.setVisible(false);
         
     }else if(perfileUtilizador.equals("funcionario")){
         
                 PnButtonRegistarEntradas.setVisible(true);
PnButtonRegistarStatus.setVisible(true);
PnButtonRegistarHistory.setVisible(true);
PnButtonRegistarContratos.setVisible(false);
PnButtonRegistarDefinicoes.setVisible(false);
         
     }
 }
 
 
 /*
 gereciamento das estacoes

 */

 public void geraEstacoes(){
     
     
     if(cmbEstacao.getSelectedItem().equals("Rotativo")){
         rdVaga_P1.setVisible(true);
         rdVaga_P2.setVisible(true);
         rdVaga_P3.setVisible(true);
         rdVaga_P4.setVisible(true);
         rdVaga_P5.setVisible(true);
         rdVaga_P6.setVisible(true);
         rdVaga_P7.setVisible(true);
         rdVaga_P8.setVisible(true);
         rdVaga_P9.setVisible(true);
         rdVaga_P10.setVisible(true);
         rdVaga_P11.setVisible(false);
         rdVaga_P12.setVisible(false);
         rdVaga_P13.setVisible(false);
         rdVaga_P14.setVisible(false);
         rdVaga_P15.setVisible(false);
         rdVaga_P16.setVisible(false);
         rdVaga_P17.setVisible(false);
         rdVaga_P18.setVisible(false);
         rdVaga_P19.setVisible(false);
         rdVaga_P20.setVisible(false);
         
         
         
     }else if(cmbEstacao.getSelectedItem().equals("Normal")){
            rdVaga_P1.setVisible(false);
         rdVaga_P2.setVisible(false);
         rdVaga_P3.setVisible(false);
         rdVaga_P4.setVisible(false);
         rdVaga_P5.setVisible(false);
         rdVaga_P6.setVisible(false);
         rdVaga_P7.setVisible(false);
         rdVaga_P8.setVisible(false);
         rdVaga_P9.setVisible(false);
         rdVaga_P10.setVisible(true);
         rdVaga_P11.setVisible(true);
         rdVaga_P12.setVisible(true);
         rdVaga_P13.setVisible(true);
         rdVaga_P14.setVisible(true);
         rdVaga_P15.setVisible(true);
         rdVaga_P16.setVisible(false);
         rdVaga_P17.setVisible(false);
         rdVaga_P18.setVisible(false);
         rdVaga_P19.setVisible(false);
         rdVaga_P20.setVisible(false);
         
     }else if(cmbEstacao.getSelectedItem().equals("VIP")){
 
         rdVaga_P1.setVisible(false);
         rdVaga_P2.setVisible(false);
         rdVaga_P3.setVisible(false);
         rdVaga_P4.setVisible(false);
         rdVaga_P5.setVisible(false);
         rdVaga_P6.setVisible(false);
         rdVaga_P7.setVisible(false);
         rdVaga_P8.setVisible(false);
         rdVaga_P9.setVisible(false);
         rdVaga_P10.setVisible(false);
         rdVaga_P11.setVisible(false);
         rdVaga_P12.setVisible(false);
         rdVaga_P13.setVisible(false);
         rdVaga_P14.setVisible(false);
         rdVaga_P15.setVisible(false);
         rdVaga_P16.setVisible(true);
         rdVaga_P17.setVisible(true);
         rdVaga_P18.setVisible(true);
         rdVaga_P19.setVisible(true);
         rdVaga_P20.setVisible(true);
     }
 }
 
 //Metodo para registar utilizadores
 
 public void registNewUser(){
     
     
 
    if (lblBox3.getText().equalsIgnoreCase("Matched password")){
        
        
        JOptionPane.showMessageDialog(null, "Pode Salvar !");
  
         
         
     try{
         con=conexao.getConnection(); //objecto da conexao 
     pst=con.prepareStatement("insert into utilizadores (nome,utilizador, senha, perfile)values(?,?,?,?)");
     
     pst.setString(1, txtNomeUsuario.getText());
     pst.setString(2, txtUser.getText());
     pst.setString(3, txtSenhaUser.getText());
     pst.setString(4, perfile_User.getSelection().toString());
     
     pst.execute();
     txtNomeUsuario.setFocusable(true);
         //JOptionPane.showMessageDialog(null, "Novo utilizador registado !");
         listUtilizadores();
         
         
         //Limpar os campos
         txtNomeUsuario.setText("");
         txtUser.setText("");
         txtSenhaUser.setText("");
         newProfile="";
         txtNomeUsuario.setFocusable(true);
         
         
        
 
     }catch(Exception ex){
         
         JOptionPane.showMessageDialog(null, "Error:"+ex);
     }

         
     
    
      }else{
        
        JOptionPane.showMessageDialog(null, "Nao Pode Salvar !");
    }
       
 }
      
 //METODO PARA FILTRAR OS DADOS DO UTILIZADOR
public void listUtilizadores(){
    int c;
  
     try{
         con=conexao.getConnection();
         
         
         pst=con.prepareStatement("select * from utilizadores");
        rs=pst.executeQuery();
      
        ResultSetMetaData rsd= rs.getMetaData();
        c=rsd.getColumnCount();
       DefaultTableModel dft=(DefaultTableModel)tbListUsers.getModel();
       dft.setRowCount(0);
        while(rs.next()){
            Vector v2= new Vector();
            for(int i=1; i<=c; i++){
                v2.add(rs.getString("ID"));
                 v2.add(rs.getString("nome"));
                  v2.add(rs.getString("utilizador"));
                   v2.add(rs.getString("perfile"));
                
            }
            dft.addRow(v2);
            
        }
     }catch(Exception ex){
    
         
         JOptionPane.showMessageDialog(null, "Error:"+ex);
     }     
     
    
    
}
         
 
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlCard2 = new javax.swing.JPanel();
        parqueGrupo = new javax.swing.ButtonGroup();
        ActionGrupo = new javax.swing.ButtonGroup();
        genderContracts = new javax.swing.ButtonGroup();
        histryOption = new javax.swing.ButtonGroup();
        choseIDSaidas = new javax.swing.ButtonGroup();
        perfile_User = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblLogoMenu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PnButtonRegistarEntradas = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        PnButtonRegistarStatus = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        PnButtonRegistarHistory = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        PnButtonRegistarContratos = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        PnButtonRegistarDefinicoes = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblLogedUser = new javax.swing.JLabel();
        lblprofileLoged = new javax.swing.JLabel();
        PnlCardLayouts = new javax.swing.JPanel();
        PnlCard4 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lblDataNow = new javax.swing.JLabel();
        PnlCard3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cmbNacionalidade = new javax.swing.JComboBox<>();
        txtContract_Documento = new javax.swing.JTextField();
        rdFemenino = new javax.swing.JRadioButton();
        rdMasculino = new javax.swing.JRadioButton();
        txtContract_Telefone = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        cmbCategoriaContrato = new javax.swing.JComboBox<>();
        txtContract_Proprietario = new javax.swing.JTextField();
        lblGeneroContract = new javax.swing.JLabel();
        lblProprietarioDados = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtContract_Marca = new javax.swing.JTextField();
        txtContractModelo = new javax.swing.JTextField();
        cmbMotor = new javax.swing.JComboBox<>();
        txtContract_NrChassis = new javax.swing.JTextField();
        cmbCombustivel = new javax.swing.JComboBox<>();
        cmbTipoViatura = new javax.swing.JComboBox<>();
        cmbCaixa = new javax.swing.JComboBox<>();
        txtContract_AnoFabrico = new javax.swing.JTextField();
        txtContract_Matricula = new javax.swing.JTextField();
        lblDadosViatura = new javax.swing.JLabel();
        btnContract_Guardar = new javax.swing.JButton();
        btnCancelarContracto = new javax.swing.JButton();
        btnContract_LimparCampos = new javax.swing.JButton();
        btnListrar = new javax.swing.JButton();
        btnContract_Editar = new javax.swing.JButton();
        lblControlos = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtContract_FindViatura = new javax.swing.JTextField();
        btnFindViatura = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        lblReferenciaValid = new javax.swing.JLabel();
        lblFoundLine = new javax.swing.JLabel();
        PnlCard1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblExitSideEntradasSaidas = new javax.swing.JLabel();
        lblTimeRGST = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtModeloRegist = new javax.swing.JTextField();
        txtRegist_Matricula = new javax.swing.JTextField();
        btnRegist_EditDados = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtRegist_Marca1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRegist_NrChassis = new javax.swing.JTextField();
        txtRegist_Proprietario = new javax.swing.JTextField();
        lblStation = new javax.swing.JLabel();
        cmbEstacao = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        lblViaturaDatas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFind_EntradaSaidas = new javax.swing.JTextField();
        txtRegist_Duracao = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtRegist_TotalPagar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnAnularPagamento = new javax.swing.JButton();
        btnConfirmarPagamento = new javax.swing.JButton();
        lblTaxaUnicaPY = new javax.swing.JLabel();
        lblTaxaUnic = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblHoraEntrada = new javax.swing.JLabel();
        lblHoraSaida = new javax.swing.JLabel();
        lblAuxiliarSaida = new javax.swing.JLabel();
        lblPayments = new javax.swing.JLabel();
        rdVaga_P1 = new javax.swing.JRadioButton();
        rdVaga_P2 = new javax.swing.JRadioButton();
        rdVaga_P3 = new javax.swing.JRadioButton();
        rdVaga_P4 = new javax.swing.JRadioButton();
        rdVaga_P9 = new javax.swing.JRadioButton();
        rdVaga_P10 = new javax.swing.JRadioButton();
        rdVaga_P11 = new javax.swing.JRadioButton();
        rdVaga_P8 = new javax.swing.JRadioButton();
        rdVaga_P5 = new javax.swing.JRadioButton();
        rdVaga_P6 = new javax.swing.JRadioButton();
        rdVaga_P14 = new javax.swing.JRadioButton();
        rdVaga_P13 = new javax.swing.JRadioButton();
        rdVaga_P7 = new javax.swing.JRadioButton();
        rdVaga_P12 = new javax.swing.JRadioButton();
        rdVaga_P15 = new javax.swing.JRadioButton();
        rdVaga_P16 = new javax.swing.JRadioButton();
        rdVaga_P17 = new javax.swing.JRadioButton();
        rdVaga_P18 = new javax.swing.JRadioButton();
        rdVaga_P19 = new javax.swing.JRadioButton();
        rdVaga_P20 = new javax.swing.JRadioButton();
        btnParkStatus = new javax.swing.JButton();
        lblchosseParque = new javax.swing.JLabel();
        btnSearchVeiculo = new javax.swing.JButton();
        btnClearnFields = new javax.swing.JButton();
        btnRegistEntrada = new javax.swing.JButton();
        rdEntrada = new javax.swing.JRadioButton();
        rdSaida = new javax.swing.JRadioButton();
        lblOperation = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayments = new javax.swing.JTable();
        lblParqueAux = new javax.swing.JLabel();
        lblcatchedREF = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblDataSaidas = new javax.swing.JLabel();
        rdFeacthMatricula = new javax.swing.JRadioButton();
        rdFeacthREF = new javax.swing.JRadioButton();
        lblDocSaidas = new javax.swing.JLabel();
        lblIDEntradas = new javax.swing.JLabel();
        lblESTCAO = new javax.swing.JLabel();
        PnlCard6 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        lblDashViaturas = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbListUsers = new javax.swing.JTable();
        lblPassword = new javax.swing.JLabel();
        txtSenhaUser = new javax.swing.JTextField();
        lblNomeUsuario = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        lblUserNome = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        rdGestor = new javax.swing.JRadioButton();
        rdFuncionario = new javax.swing.JRadioButton();
        rdAdmin = new javax.swing.JRadioButton();
        btnDeleteUser = new javax.swing.JButton();
        lblBox1 = new javax.swing.JLabel();
        lblBox2 = new javax.swing.JLabel();
        lblBox3 = new javax.swing.JLabel();
        btnSaveUser = new javax.swing.JButton();
        btnEditeUser = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        btnRefreshUsers = new javax.swing.JButton();
        txtValidateSenha = new javax.swing.JTextField();
        lblPassword1 = new javax.swing.JLabel();
        lblFluxo1 = new javax.swing.JLabel();
        lblBox4 = new javax.swing.JLabel();
        PnlCard5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMovimento_SaidaEntrada = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        txtHistryReferencia = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtHistryMatricula = new javax.swing.JTextField();
        txtHistryMarca = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtHistryModelo = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnPushHistyRF = new javax.swing.JButton();
        btnPushHistyPushData = new javax.swing.JButton();
        btnPushHistyModeloMarca = new javax.swing.JButton();
        btnPushHistyMatricula = new javax.swing.JButton();
        lblMovimentoHistyrControlo = new javax.swing.JLabel();
        btnShowData = new javax.swing.JButton();
        btnHistryPrint = new javax.swing.JButton();
        rd_histrySaidas = new javax.swing.JRadioButton();
        rd_histryEntrada = new javax.swing.JRadioButton();
        lblOpcaoConsulta = new javax.swing.JLabel();

        PnlCard2.setBackground(new java.awt.Color(204, 0, 51));
        PnlCard2.setName("PlnCard2"); // NOI18N

        javax.swing.GroupLayout PnlCard2Layout = new javax.swing.GroupLayout(PnlCard2);
        PnlCard2.setLayout(PnlCard2Layout);
        PnlCard2Layout.setHorizontalGroup(
            PnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        PnlCard2Layout.setVerticalGroup(
            PnlCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 630));
        setPreferredSize(new java.awt.Dimension(1000, 664));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane1.setDividerSize(0);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 114, 230, 2));

        lblLogoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/parque logo.png"))); // NOI18N
        jPanel3.add(lblLogoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 60, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  PAY-parque Station, Lda");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 210, 20));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Sistema de controlo de parque de estacionamento");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 250, -1));

        PnButtonRegistarEntradas.setBackground(new java.awt.Color(102, 102, 102));
        PnButtonRegistarEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PnButtonRegistarEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnButtonRegistarEntradasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnButtonRegistarEntradasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PnButtonRegistarEntradasMouseExited(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/AlocarViatura.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("REGISTO DE ENTRADAS E SAIDAS");

        javax.swing.GroupLayout PnButtonRegistarEntradasLayout = new javax.swing.GroupLayout(PnButtonRegistarEntradas);
        PnButtonRegistarEntradas.setLayout(PnButtonRegistarEntradasLayout);
        PnButtonRegistarEntradasLayout.setHorizontalGroup(
            PnButtonRegistarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnButtonRegistarEntradasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        PnButtonRegistarEntradasLayout.setVerticalGroup(
            PnButtonRegistarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnButtonRegistarEntradasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(PnButtonRegistarEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        jPanel3.add(PnButtonRegistarEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 310, 70));

        PnButtonRegistarStatus.setBackground(new java.awt.Color(102, 102, 102));
        PnButtonRegistarStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PnButtonRegistarStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnButtonRegistarStatusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnButtonRegistarStatusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PnButtonRegistarStatusMouseExited(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/VagaPark.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("ESTADO DO ESTACIONAMENTO");

        javax.swing.GroupLayout PnButtonRegistarStatusLayout = new javax.swing.GroupLayout(PnButtonRegistarStatus);
        PnButtonRegistarStatus.setLayout(PnButtonRegistarStatusLayout);
        PnButtonRegistarStatusLayout.setHorizontalGroup(
            PnButtonRegistarStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnButtonRegistarStatusLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PnButtonRegistarStatusLayout.setVerticalGroup(
            PnButtonRegistarStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnButtonRegistarStatusLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PnButtonRegistarStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.add(PnButtonRegistarStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 310, -1));

        PnButtonRegistarHistory.setBackground(new java.awt.Color(102, 102, 102));
        PnButtonRegistarHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PnButtonRegistarHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnButtonRegistarHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnButtonRegistarHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PnButtonRegistarHistoryMouseExited(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/search_car.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("HISTÓRICO DO MOVIMENTO");

        javax.swing.GroupLayout PnButtonRegistarHistoryLayout = new javax.swing.GroupLayout(PnButtonRegistarHistory);
        PnButtonRegistarHistory.setLayout(PnButtonRegistarHistoryLayout);
        PnButtonRegistarHistoryLayout.setHorizontalGroup(
            PnButtonRegistarHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnButtonRegistarHistoryLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PnButtonRegistarHistoryLayout.setVerticalGroup(
            PnButtonRegistarHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnButtonRegistarHistoryLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(PnButtonRegistarHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnButtonRegistarHistoryLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnButtonRegistarHistoryLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(26, 26, 26))))
        );

        jPanel3.add(PnButtonRegistarHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 310, -1));

        PnButtonRegistarContratos.setBackground(new java.awt.Color(102, 102, 102));
        PnButtonRegistarContratos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PnButtonRegistarContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnButtonRegistarContratosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnButtonRegistarContratosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PnButtonRegistarContratosMouseExited(evt);
            }
        });

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/listarContratos.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("REGISTO DE CONTRATOS");

        javax.swing.GroupLayout PnButtonRegistarContratosLayout = new javax.swing.GroupLayout(PnButtonRegistarContratos);
        PnButtonRegistarContratos.setLayout(PnButtonRegistarContratosLayout);
        PnButtonRegistarContratosLayout.setHorizontalGroup(
            PnButtonRegistarContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnButtonRegistarContratosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PnButtonRegistarContratosLayout.setVerticalGroup(
            PnButtonRegistarContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnButtonRegistarContratosLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(PnButtonRegistarContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel3.add(PnButtonRegistarContratos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 310, -1));

        PnButtonRegistarDefinicoes.setBackground(new java.awt.Color(102, 102, 102));
        PnButtonRegistarDefinicoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PnButtonRegistarDefinicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnButtonRegistarDefinicoesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PnButtonRegistarDefinicoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PnButtonRegistarDefinicoesMouseExited(evt);
            }
        });

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/setthing menu.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("PAINEL DE CONTROLO");

        javax.swing.GroupLayout PnButtonRegistarDefinicoesLayout = new javax.swing.GroupLayout(PnButtonRegistarDefinicoes);
        PnButtonRegistarDefinicoes.setLayout(PnButtonRegistarDefinicoesLayout);
        PnButtonRegistarDefinicoesLayout.setHorizontalGroup(
            PnButtonRegistarDefinicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnButtonRegistarDefinicoesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PnButtonRegistarDefinicoesLayout.setVerticalGroup(
            PnButtonRegistarDefinicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnButtonRegistarDefinicoesLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(PnButtonRegistarDefinicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(16, 16, 16))
        );

        jPanel3.add(PnButtonRegistarDefinicoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 310, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/OnlineUser.png"))); // NOI18N
        jLabel14.setFocusable(false);
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 110, 60));

        lblLogedUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLogedUser.setForeground(new java.awt.Color(255, 255, 255));
        lblLogedUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogedUser.setText("Sing in ");
        lblLogedUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblLogedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 130, 20));

        lblprofileLoged.setForeground(new java.awt.Color(102, 102, 102));
        lblprofileLoged.setText("*******");
        jPanel3.add(lblprofileLoged, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 40));

        jSplitPane1.setLeftComponent(jPanel3);

        PnlCardLayouts.setMinimumSize(new java.awt.Dimension(690, 620));
        PnlCardLayouts.setPreferredSize(new java.awt.Dimension(690, 630));
        PnlCardLayouts.setLayout(new java.awt.CardLayout());

        PnlCard4.setBackground(new java.awt.Color(255, 255, 255));
        PnlCard4.setName("PnlCard4"); // NOI18N
        PnlCard4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pinkHomeLogo.png"))); // NOI18N
        PnlCard4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 100, 100));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("PAY-parque Station, Lda");
        PnlCard4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 330, 30));

        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setText("SISTEMA DE CONTROLO DE PARQUE DE ESTACIONAMENTO.");
        PnlCard4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 450, 30));

        lblDataNow.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblDataNow.setForeground(new java.awt.Color(102, 102, 102));
        lblDataNow.setText("*****");
        PnlCard4.add(lblDataNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 320, 20));

        PnlCardLayouts.add(PnlCard4, "card4");

        PnlCard3.setBackground(new java.awt.Color(255, 255, 255));
        PnlCard3.setName("PlnCard3"); // NOI18N
        PnlCard3.setPreferredSize(new java.awt.Dimension(690, 630));
        PnlCard3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(0, 102, 102));
        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("REGISTAR CONTRATO");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -1, 290, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/listarContratos.png"))); // NOI18N
        jLabel21.setToolTipText("");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/EXIT.png"))); // NOI18N
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 50, 50));

        PnlCard3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nome completo");
        PnlCard3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 160, 20));

        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Nacionalidade");
        PnlCard3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 110, -1));

        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Número de Telefone");
        PnlCard3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 180, 20));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("Genero :");
        PnlCard3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 60, -1));

        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Nº de B.I/Passaport");
        PnlCard3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 130, 20));

        cmbNacionalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mozambique", "Sul Africana", "Angolana", "Tanzaniana", "Somaliana", "Portuguese", "Indiana", "Swadish", "Francesa", "Nageriana", " ", " " }));
        cmbNacionalidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbNacionalidade.setDoubleBuffered(true);
        PnlCard3.add(cmbNacionalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 180, 30));

        txtContract_Documento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_Documento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_Documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 190, 30));

        genderContracts.add(rdFemenino);
        rdFemenino.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdFemenino.setForeground(new java.awt.Color(102, 102, 102));
        rdFemenino.setText("Femenino");
        rdFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemeninoActionPerformed(evt);
            }
        });
        PnlCard3.add(rdFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 90, 30));

        genderContracts.add(rdMasculino);
        rdMasculino.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdMasculino.setForeground(new java.awt.Color(102, 102, 102));
        rdMasculino.setText("Masculino");
        rdMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMasculinoActionPerformed(evt);
            }
        });
        PnlCard3.add(rdMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 100, 30));

        txtContract_Telefone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_Telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_Telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 190, 30));

        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Tipo de Contrato");
        PnlCard3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 180, 20));

        cmbCategoriaContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semanal", "Mensal", "Anual" }));
        cmbCategoriaContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbCategoriaContrato.setDoubleBuffered(true);
        cmbCategoriaContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaContratoActionPerformed(evt);
            }
        });
        PnlCard3.add(cmbCategoriaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 180, 30));

        txtContract_Proprietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_Proprietario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_Proprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 190, 30));

        lblGeneroContract.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGeneroContract.setForeground(new java.awt.Color(0, 204, 204));
        PnlCard3.add(lblGeneroContract, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 196, 120, 20));

        lblProprietarioDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Proprietario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        PnlCard3.add(lblProprietarioDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 630, 180));

        jLabel38.setText("Marca");
        PnlCard3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 90, -1));

        jLabel39.setText("Motor");
        PnlCard3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 90, -1));

        jLabel40.setText("Combustivel");
        PnlCard3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 100, -1));

        jLabel41.setText("Modelo");
        PnlCard3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 90, -1));

        jLabel42.setText("Tipo");
        PnlCard3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 70, -1));

        jLabel43.setText("Número de Quadro/Chassis");
        PnlCard3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 180, -1));

        jLabel44.setText("Caixa");
        PnlCard3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 70, -1));

        jLabel45.setText("Matricula");
        PnlCard3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 70, -1));

        jLabel46.setText("Ano de Fabrico");
        PnlCard3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 100, -1));

        txtContract_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_Marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 200, 30));

        txtContractModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContractModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtContractModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractModeloActionPerformed(evt);
            }
        });
        txtContractModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContractModeloKeyReleased(evt);
            }
        });
        PnlCard3.add(txtContractModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 200, 30));

        cmbMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disel", "Gasolina" }));
        cmbMotor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbMotor.setDoubleBuffered(true);
        cmbMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMotorActionPerformed(evt);
            }
        });
        PnlCard3.add(cmbMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 200, 30));

        txtContract_NrChassis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_NrChassis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_NrChassis, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 180, 30));

        cmbCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasoleo", "Gasolina", "Gás" }));
        cmbCombustivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        cmbCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCombustivelActionPerformed(evt);
            }
        });
        PnlCard3.add(cmbCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 180, 30));

        cmbTipoViatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turismo", "Carinha caixa", "Mini-Bus", "Metro-Bus", "Camioneta", "Tractor", " " }));
        cmbTipoViatura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbTipoViatura.setDoubleBuffered(true);
        PnlCard3.add(cmbTipoViatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 180, 30));

        cmbCaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Automatica" }));
        cmbCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbCaixa.setDoubleBuffered(true);
        cmbCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCaixaActionPerformed(evt);
            }
        });
        PnlCard3.add(cmbCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 190, 30));

        txtContract_AnoFabrico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_AnoFabrico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_AnoFabrico, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 190, 30));

        txtContract_Matricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_Matricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_Matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 190, 30));

        lblDadosViatura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da viatura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        PnlCard3.add(lblDadosViatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 630, 210));

        btnContract_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/guardar.png"))); // NOI18N
        btnContract_Guardar.setText("Guardar");
        btnContract_Guardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnContract_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContract_GuardarActionPerformed(evt);
            }
        });
        PnlCard3.add(btnContract_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 110, 40));

        btnCancelarContracto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelarContracts.png"))); // NOI18N
        btnCancelarContracto.setText("Cancelar");
        btnCancelarContracto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelarContracto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarContractoActionPerformed(evt);
            }
        });
        PnlCard3.add(btnCancelarContracto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 110, 40));

        btnContract_LimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limparCampos.png"))); // NOI18N
        btnContract_LimparCampos.setText("Limpar");
        btnContract_LimparCampos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnContract_LimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContract_LimparCamposActionPerformed(evt);
            }
        });
        PnlCard3.add(btnContract_LimparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 100, 40));

        btnListrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/printContrato.png"))); // NOI18N
        btnListrar.setText("Lista");
        btnListrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListrarActionPerformed(evt);
            }
        });
        PnlCard3.add(btnListrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, 100, 40));

        btnContract_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editarContract.png"))); // NOI18N
        btnContract_Editar.setText("Editar");
        btnContract_Editar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnContract_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContract_EditarActionPerformed(evt);
            }
        });
        PnlCard3.add(btnContract_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 90, 40));

        lblControlos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        PnlCard3.add(lblControlos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 630, 80));

        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Pesquisar pela Referencia :");
        PnlCard3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 210, 20));

        txtContract_FindViatura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContract_FindViatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard3.add(txtContract_FindViatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 200, 30));

        btnFindViatura.setBackground(new java.awt.Color(102, 102, 102));
        btnFindViatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/findIT.png"))); // NOI18N
        btnFindViatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindViaturaActionPerformed(evt);
            }
        });
        PnlCard3.add(btnFindViatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 50, 30));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setText("Referencia :");
        PnlCard3.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 56, 70, 30));

        lblReferenciaValid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReferenciaValid.setForeground(new java.awt.Color(204, 0, 51));
        lblReferenciaValid.setText("****");
        PnlCard3.add(lblReferenciaValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, 30));
        PnlCard3.add(lblFoundLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 40, 30));

        PnlCardLayouts.add(PnlCard3, "card3");

        PnlCard1.setBackground(new java.awt.Color(255, 255, 255));
        PnlCard1.setToolTipText("");
        PnlCard1.setName("Card1"); // NOI18N
        PnlCard1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REGISTAR ENTRADA E SAIDA DE VIATURAS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -1, 290, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/registCar.png"))); // NOI18N
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        lblExitSideEntradasSaidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/EXIT.png"))); // NOI18N
        lblExitSideEntradasSaidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExitSideEntradasSaidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitSideEntradasSaidasMouseClicked(evt);
            }
        });
        jPanel1.add(lblExitSideEntradasSaidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 60, 50));

        lblTimeRGST.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTimeRGST.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblTimeRGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 20, 200, 20));

        PnlCard1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Marca :");
        PnlCard1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Modelo :");
        PnlCard1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        txtModeloRegist.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModeloRegist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard1.add(txtModeloRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 160, 27));

        txtRegist_Matricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard1.add(txtRegist_Matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 160, 27));

        btnRegist_EditDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editarContract.png"))); // NOI18N
        btnRegist_EditDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegist_EditDadosActionPerformed(evt);
            }
        });
        PnlCard1.add(btnRegist_EditDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 80, 40));

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Estação");
        PnlCard1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 190, -1));

        txtRegist_Marca1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegist_Marca1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard1.add(txtRegist_Marca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 160, 27));

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Matricula");
        PnlCard1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Nº de Chassis");
        PnlCard1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 80, -1));

        txtRegist_NrChassis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegist_NrChassis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard1.add(txtRegist_NrChassis, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 160, 27));

        txtRegist_Proprietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegist_Proprietario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard1.add(txtRegist_Proprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 190, 27));

        lblStation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblStation.setForeground(new java.awt.Color(0, 204, 204));
        PnlCard1.add(lblStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 80, 30));

        cmbEstacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rotativo", "Normal", "VIP" }));
        cmbEstacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstacaoItemStateChanged(evt);
            }
        });
        cmbEstacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbEstacaoMouseClicked(evt);
            }
        });
        cmbEstacao.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbEstacaoPropertyChange(evt);
            }
        });
        PnlCard1.add(cmbEstacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 190, 27));

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Proprietario");
        PnlCard1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 190, -1));

        jLabel58.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setText("Contracto :");
        PnlCard1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 266, 70, 20));

        lblViaturaDatas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Viatura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        lblViaturaDatas.setFocusable(false);
        PnlCard1.add(lblViaturaDatas, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 137, 591, 164));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("SCAN ID-CODE ");
        PnlCard1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 100, 30));

        txtFind_EntradaSaidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        PnlCard1.add(txtFind_EntradaSaidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 170, 30));

        txtRegist_Duracao.setForeground(new java.awt.Color(102, 102, 102));
        txtRegist_Duracao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegist_Duracao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        PnlCard1.add(txtRegist_Duracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 170, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Total a pagar");
        PnlCard1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 160, 20));

        txtRegist_TotalPagar.setEditable(false);
        txtRegist_TotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtRegist_TotalPagar.setForeground(new java.awt.Color(51, 51, 51));
        txtRegist_TotalPagar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegist_TotalPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        PnlCard1.add(txtRegist_TotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 170, 30));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Valor a pagar !");
        PnlCard1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 70, -1));

        btnAnularPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/endPayment.png"))); // NOI18N
        btnAnularPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularPagamentoActionPerformed(evt);
            }
        });
        PnlCard1.add(btnAnularPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 60, 40));

        btnConfirmarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/paynow.png"))); // NOI18N
        btnConfirmarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPagamentoActionPerformed(evt);
            }
        });
        PnlCard1.add(btnConfirmarPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 70, 40));

        lblTaxaUnicaPY.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTaxaUnicaPY.setForeground(new java.awt.Color(102, 102, 102));
        lblTaxaUnicaPY.setText("100 MT");
        PnlCard1.add(lblTaxaUnicaPY, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 60, -1));

        lblTaxaUnic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTaxaUnic.setForeground(new java.awt.Color(102, 102, 102));
        lblTaxaUnic.setText("Taxa Unica");
        PnlCard1.add(lblTaxaUnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, -1, -1));

        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Hora de Saida ");
        PnlCard1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 90, -1));

        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Hora de Entrada");
        PnlCard1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 100, -1));

        lblHoraEntrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHoraEntrada.setForeground(new java.awt.Color(0, 204, 204));
        lblHoraEntrada.setText("******");
        PnlCard1.add(lblHoraEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 110, 20));

        lblHoraSaida.setForeground(new java.awt.Color(204, 0, 0));
        PnlCard1.add(lblHoraSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 110, 20));

        lblAuxiliarSaida.setText("*********");
        PnlCard1.add(lblAuxiliarSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 110, -1));

        lblPayments.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPayments.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagamento ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        PnlCard1.add(lblPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 310, 190));

        parqueGrupo.add(rdVaga_P1);
        rdVaga_P1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P1.setText("P-1");
        rdVaga_P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P1ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 50, -1));

        parqueGrupo.add(rdVaga_P2);
        rdVaga_P2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P2.setText("P-2");
        rdVaga_P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P2ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 50, -1));

        parqueGrupo.add(rdVaga_P3);
        rdVaga_P3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P3.setText("P-3");
        rdVaga_P3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P3ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 50, -1));

        parqueGrupo.add(rdVaga_P4);
        rdVaga_P4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P4.setText("P-4");
        rdVaga_P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P4ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 50, -1));

        parqueGrupo.add(rdVaga_P9);
        rdVaga_P9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P9.setText("P-9");
        rdVaga_P9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P9ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 50, -1));

        parqueGrupo.add(rdVaga_P10);
        rdVaga_P10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P10.setText("P-10");
        rdVaga_P10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P10ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 50, -1));

        parqueGrupo.add(rdVaga_P11);
        rdVaga_P11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P11.setText("P-11");
        rdVaga_P11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P11ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 50, -1));

        parqueGrupo.add(rdVaga_P8);
        rdVaga_P8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P8.setText("P-8");
        rdVaga_P8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P8ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 50, -1));

        parqueGrupo.add(rdVaga_P5);
        rdVaga_P5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P5.setText("P-5");
        rdVaga_P5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P5ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 50, -1));

        parqueGrupo.add(rdVaga_P6);
        rdVaga_P6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P6.setText("P-6");
        rdVaga_P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P6ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 50, -1));

        parqueGrupo.add(rdVaga_P14);
        rdVaga_P14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P14.setText("P-14");
        rdVaga_P14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P14ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 50, -1));

        parqueGrupo.add(rdVaga_P13);
        rdVaga_P13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P13.setText("P-13");
        rdVaga_P13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P13ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 50, -1));

        parqueGrupo.add(rdVaga_P7);
        rdVaga_P7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P7.setText("P-7");
        rdVaga_P7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P7ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 50, -1));

        parqueGrupo.add(rdVaga_P12);
        rdVaga_P12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P12.setText("P-12");
        rdVaga_P12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P12ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 50, -1));

        parqueGrupo.add(rdVaga_P15);
        rdVaga_P15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P15.setText("P-15");
        rdVaga_P15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P15ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 50, -1));

        parqueGrupo.add(rdVaga_P16);
        rdVaga_P16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P16.setText("P-16");
        rdVaga_P16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P16ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 50, -1));

        parqueGrupo.add(rdVaga_P17);
        rdVaga_P17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P17.setText("P-17");
        rdVaga_P17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P17ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 50, -1));

        parqueGrupo.add(rdVaga_P18);
        rdVaga_P18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P18.setText("P-18");
        rdVaga_P18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P18ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 50, -1));

        parqueGrupo.add(rdVaga_P19);
        rdVaga_P19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P19.setText("P-19");
        rdVaga_P19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P19ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 50, -1));

        parqueGrupo.add(rdVaga_P20);
        rdVaga_P20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdVaga_P20.setText("P-20");
        rdVaga_P20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdVaga_P20ActionPerformed(evt);
            }
        });
        PnlCard1.add(rdVaga_P20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 50, -1));

        btnParkStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnParkStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/previsualiarParks.png"))); // NOI18N
        btnParkStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParkStatusActionPerformed(evt);
            }
        });
        PnlCard1.add(btnParkStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 60, 30));

        lblchosseParque.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parque de Estacionamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        PnlCard1.add(lblchosseParque, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 270, 130));

        btnSearchVeiculo.setBackground(new java.awt.Color(153, 153, 153));
        btnSearchVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/findIT.png"))); // NOI18N
        btnSearchVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchVeiculoActionPerformed(evt);
            }
        });
        PnlCard1.add(btnSearchVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 40, 30));

        btnClearnFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limparCampos.png"))); // NOI18N
        btnClearnFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearnFieldsActionPerformed(evt);
            }
        });
        PnlCard1.add(btnClearnFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 80, 40));

        btnRegistEntrada.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistEntrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistEntrada.setForeground(new java.awt.Color(204, 204, 255));
        btnRegistEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/carHistry.png"))); // NOI18N
        btnRegistEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistEntradaActionPerformed(evt);
            }
        });
        PnlCard1.add(btnRegistEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 80, 40));

        ActionGrupo.add(rdEntrada);
        rdEntrada.setText("ENTRADA");
        rdEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEntradaActionPerformed(evt);
            }
        });
        PnlCard1.add(rdEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        ActionGrupo.add(rdSaida);
        rdSaida.setText("SAIDA");
        rdSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSaidaActionPerformed(evt);
            }
        });
        PnlCard1.add(rdSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        lblOperation.setForeground(new java.awt.Color(102, 102, 102));
        lblOperation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECIONE A OPERAÇÃO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        PnlCard1.add(lblOperation, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 210, 50));

        tblPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proprietario", "Matricula", "Marca", "Modelo", "Estação", "Lugar", "H-Entrada", "Contracto", "Referencia", "Data"
            }
        ));
        tblPayments.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblPayments);

        PnlCard1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 590, 70));

        lblParqueAux.setText("*****");
        PnlCard1.add(lblParqueAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 50, -1));
        PnlCard1.add(lblcatchedREF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 140, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Duração no praque");
        PnlCard1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 336, 160, 20));

        lblDataSaidas.setText("******");
        PnlCard1.add(lblDataSaidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 90, -1));

        choseIDSaidas.add(rdFeacthMatricula);
        rdFeacthMatricula.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rdFeacthMatricula.setText("MATRICULA");
        rdFeacthMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFeacthMatriculaActionPerformed(evt);
            }
        });
        PnlCard1.add(rdFeacthMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 90, -1));

        choseIDSaidas.add(rdFeacthREF);
        rdFeacthREF.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rdFeacthREF.setForeground(new java.awt.Color(102, 102, 102));
        rdFeacthREF.setText("CARTÃO-PAY");
        rdFeacthREF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFeacthREFActionPerformed(evt);
            }
        });
        PnlCard1.add(rdFeacthREF, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 70, 100, 20));

        lblDocSaidas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECIONE O ID USADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(153, 153, 153))); // NOI18N
        PnlCard1.add(lblDocSaidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 56, 210, 40));

        lblIDEntradas.setForeground(new java.awt.Color(255, 255, 255));
        lblIDEntradas.setText("***");
        PnlCard1.add(lblIDEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 40, -1));

        lblESTCAO.setText("***");
        PnlCard1.add(lblESTCAO, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 80, -1));

        PnlCardLayouts.add(PnlCard1, "card1");

        PnlCard6.setBackground(new java.awt.Color(255, 255, 255));
        PnlCard6.setMinimumSize(new java.awt.Dimension(740, 640));
        PnlCard6.setName("PlnCard5"); // NOI18N
        PnlCard6.setPreferredSize(new java.awt.Dimension(740, 640));
        PnlCard6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 0, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setBackground(new java.awt.Color(0, 102, 102));
        jLabel60.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Painel de Controlo");
        jPanel6.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -1, 290, 50));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/search_car.png"))); // NOI18N
        jLabel61.setToolTipText("");
        jPanel6.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, -1));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/EXIT.png"))); // NOI18N
        jLabel62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 60, 50));

        PnlCard6.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/utilizadores.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PnlCard6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 80, 80));

        jLabel63.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(102, 102, 102));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/contratos.png"))); // NOI18N
        jLabel63.setText("REGISTAR NOVO UTILIZADOR ");
        PnlCard6.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 320, 50));

        jLabel64.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("11");
        PnlCard6.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 90, 70));

        jLabel65.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("6");
        PnlCard6.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 80, 80));

        jLabel66.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(102, 102, 102));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/viaturasEstacionadas.png"))); // NOI18N
        PnlCard6.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 70, 60));

        jLabel67.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(102, 102, 102));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/viaturasRegistadas.png"))); // NOI18N
        PnlCard6.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 70, 50));

        jLabel68.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("9");
        PnlCard6.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 70, 50));

        jLabel69.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("24");
        PnlCard6.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 60, 50));

        lblDashViaturas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Viaturas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        PnlCard6.add(lblDashViaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 630, 150));

        tbListUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Utilizador", "Perfile"
            }
        ));
        jScrollPane4.setViewportView(tbListUsers);

        PnlCard6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 290, 330));

        lblPassword.setText("Nova senha/New password");
        PnlCard6.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 160, -1));
        PnlCard6.add(txtSenhaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 280, 30));

        lblNomeUsuario.setText("Nome Completo");
        PnlCard6.add(lblNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 120, -1));
        PnlCard6.add(txtNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 280, 30));

        lblUserNome.setText("Utilizador/Username");
        PnlCard6.add(lblUserNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, -1));
        PnlCard6.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 280, 30));

        perfile_User.add(rdGestor);
        rdGestor.setText("Gestor");
        rdGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdGestorActionPerformed(evt);
            }
        });
        PnlCard6.add(rdGestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 70, -1));

        perfile_User.add(rdFuncionario);
        rdFuncionario.setText("Funcionario");
        rdFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFuncionarioActionPerformed(evt);
            }
        });
        PnlCard6.add(rdFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 90, -1));

        perfile_User.add(rdAdmin);
        rdAdmin.setText("Admin");
        rdAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAdminActionPerformed(evt);
            }
        });
        PnlCard6.add(rdAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 70, -1));

        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/deletar.png"))); // NOI18N
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        PnlCard6.add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 80, 40));
        PnlCard6.add(lblBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 150, 20));

        lblBox2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PnlCard6.add(lblBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 150, 20));

        lblBox3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PnlCard6.add(lblBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 120, 20));

        btnSaveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/guardar.png"))); // NOI18N
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });
        PnlCard6.add(btnSaveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 80, 40));

        btnEditeUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editarContract.png"))); // NOI18N
        btnEditeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditeUserActionPerformed(evt);
            }
        });
        PnlCard6.add(btnEditeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 80, 40));

        jLabel73.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(102, 102, 102));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/contratos.png"))); // NOI18N
        PnlCard6.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 50, 50));

        btnRefreshUsers.setText("Refresh");
        btnRefreshUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshUsersActionPerformed(evt);
            }
        });
        PnlCard6.add(btnRefreshUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 290, -1));

        txtValidateSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValidateSenhaActionPerformed(evt);
            }
        });
        txtValidateSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValidateSenhaKeyPressed(evt);
            }
        });
        PnlCard6.add(txtValidateSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 280, 30));

        lblPassword1.setText("Senha/Passowrd");
        PnlCard6.add(lblPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 120, -1));

        lblFluxo1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estatistica :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        PnlCard6.add(lblFluxo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 330, 340));

        lblBox4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PnlCard6.add(lblBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 120, 20));

        PnlCardLayouts.add(PnlCard6, "card6");

        PnlCard5.setBackground(new java.awt.Color(255, 255, 255));
        PnlCard5.setName("PlnCard5"); // NOI18N
        PnlCard5.setPreferredSize(new java.awt.Dimension(690, 630));
        PnlCard5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setBackground(new java.awt.Color(0, 102, 102));
        jLabel48.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Historico de Entrada e saida de viaturas");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -1, 310, 50));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/menu/search_car.png"))); // NOI18N
        jLabel49.setToolTipText("");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, -1));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/EXIT.png"))); // NOI18N
        jLabel50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 60, 50));

        PnlCard5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        tblMovimento_SaidaEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMovimento_SaidaEntrada.setSelectionBackground(new java.awt.Color(204, 0, 51));
        tblMovimento_SaidaEntrada.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tblMovimento_SaidaEntrada);

        PnlCard5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 650, 320));

        jLabel51.setText("Nº de Referencia");
        PnlCard5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 140, 20));
        PnlCard5.add(txtHistryReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 120, 30));

        jLabel52.setText("Matricula da Viatura");
        PnlCard5.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 100, 130, 20));
        PnlCard5.add(txtHistryMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 120, 30));
        PnlCard5.add(txtHistryMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 60, 30));

        jLabel53.setText("Modelo e Marca da Viatura");
        PnlCard5.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 150, -1));
        PnlCard5.add(txtHistryModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 70, 30));

        jLabel54.setText("Data de Entrada");
        PnlCard5.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 100, -1));
        PnlCard5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 80, 30));

        btnPushHistyRF.setText("v");
        PnlCard5.add(btnPushHistyRF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 40, 30));

        btnPushHistyPushData.setText("v");
        PnlCard5.add(btnPushHistyPushData, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 40, 30));

        btnPushHistyModeloMarca.setText("v");
        PnlCard5.add(btnPushHistyModeloMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 40, 30));

        btnPushHistyMatricula.setText("v");
        PnlCard5.add(btnPushHistyMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 40, 30));

        lblMovimentoHistyrControlo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar historico de movimento das viaturas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        PnlCard5.add(lblMovimentoHistyrControlo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 650, 120));

        btnShowData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/load.png"))); // NOI18N
        btnShowData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDataActionPerformed(evt);
            }
        });
        PnlCard5.add(btnShowData, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 60, 40));

        btnHistryPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/printContrato.png"))); // NOI18N
        btnHistryPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistryPrintActionPerformed(evt);
            }
        });
        PnlCard5.add(btnHistryPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 60, 40));

        histryOption.add(rd_histrySaidas);
        rd_histrySaidas.setText("SAIDAS");
        rd_histrySaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_histrySaidasActionPerformed(evt);
            }
        });
        PnlCard5.add(rd_histrySaidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 150, 30));

        histryOption.add(rd_histryEntrada);
        rd_histryEntrada.setText("ENTRADAS");
        rd_histryEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_histryEntradaActionPerformed(evt);
            }
        });
        PnlCard5.add(rd_histryEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 120, 30));

        lblOpcaoConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPÇÃO PARA CONSULTA  :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        PnlCard5.add(lblOpcaoConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 400, 60));

        PnlCardLayouts.add(PnlCard5, "card5");

        jSplitPane1.setRightComponent(PnlCardLayouts);

        getContentPane().add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegist_EditDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegist_EditDadosActionPerformed
       try {
           // TODO add your handling code here:
           
           
           generateSaidasID();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }//GEN-LAST:event_btnRegist_EditDadosActionPerformed

    private void btnRegistEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistEntradaActionPerformed
      
       try {
           VerificarVagas();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
        
        if(vagaP!=null && sendAction.equals("Entrada")){
        
           
           
           try {
           //txtRegist_TotalPagar.setText("200");

           generateIDEntradas();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
           
           
        saveParking();
        
       
        
        //Enviado os dados para a tabela !
        
         DefaultTableModel model=(DefaultTableModel)tblPayments.getModel();
                
                model.addRow(new Object[]{txtRegist_Proprietario.getText(),txtRegist_Matricula.getText(), txtRegist_Marca1.getText(),txtModeloRegist.getText(), cmbEstacao.getSelectedItem(),vagaP,lblHoraEntrada.getText(),lblStation.getText(),lblcatchedREF.getText(),lblDataNow.getText()});
       }else{
           
           JOptionPane.showMessageDialog(this, "POR FAVOR SELECIONE A VAGA DE ESTACIONAMENTO");
       }    
      
    }//GEN-LAST:event_btnRegistEntradaActionPerformed

    private void btnSearchVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchVeiculoActionPerformed

             try {
           // TODO add your handling code here:
           generateSaidasID();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
             
        if(sendAction!=""){
       if(sendAction.equals("Saida")){
           
           //METODO PARA CARREGAR OS DADOS CONSULTADOS
           if(catchIDFiltraSaidas.equals("Matricula")){
               
               /*
               CASO A ENTRADA FOI DADA PELO METODO DO USO DO NUMERO DA MATRICULA
               */
                 try {
           pegaValoreseEntradas();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
               
               
           }else if(catchIDFiltraSaidas.equals("Referencia")){
             
               
               try {
                   /*
                   CASO A ENTRADA FOI DADA PELO METODO DO USO DO CARTAO DE ACESSO
                   */
                   
                   pegaValoresREFERENCIA();
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               if(lblStation.getText().equals("")){
    
    
}else if(lblStation.getText().equals("Semanal")){
   txtRegist_TotalPagar.setText("400"); 
}if(lblStation.getText().equals("Mensal")){
     txtRegist_TotalPagar.setText("2200");
}if(lblStation.getText().equals("Mensal")){
    txtRegist_TotalPagar.setText("8000");
}
                
           }else{
               
               JOptionPane.showMessageDialog(this, "Porfavor selecione o metodo de consulta !");
               
           }
           
           
          
            
       } else if(sendAction.equals("Entrada")){
           
           try {
               //           JOptionPane.showMessageDialog(this, "Falta o Metodo que busca informações da viatua no ficheiro de contratos !");

               carregaContratos();
           } catch (FileNotFoundException ex) {
               Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        }else{
            JOptionPane.showMessageDialog(this, "Porfavor selecione o tipo de acao seja ENTRADA ou SAIDA de uma viatura");
        }
       
 if(txtRegist_Matricula.getText().equals("")){
            btnConfirmarPagamento.setEnabled(false);
       btnAnularPagamento.setEnabled(false);
            
        }else{
            btnConfirmarPagamento.setEnabled(true);
       btnAnularPagamento.setEnabled(true);
        }
 
        
        
       
           
    }//GEN-LAST:event_btnSearchVeiculoActionPerformed

    private void PnButtonRegistarEntradasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarEntradasMouseExited
        // TODO add your handling code here:
        //[102,102,102]
          int R=102;
     int G=102;
     int B=102;
        PnButtonRegistarEntradas.setBackground(new Color(R,G,B));
        
        
    }//GEN-LAST:event_PnButtonRegistarEntradasMouseExited

    private void PnButtonRegistarEntradasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarEntradasMouseEntered
        // [204,0,51]
     int R=240;
     int G=0;
     int B=51;
     PnButtonRegistarEntradas.setBackground(new Color(R, G, B));
         
    }//GEN-LAST:event_PnButtonRegistarEntradasMouseEntered

    private void PnButtonRegistarStatusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarStatusMouseEntered
     int R=240;
     int G=0;
     int B=51;
     PnButtonRegistarStatus.setBackground(new Color(R, G, B));
     
    }//GEN-LAST:event_PnButtonRegistarStatusMouseEntered

    private void PnButtonRegistarStatusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarStatusMouseExited
                int R=102;
     int G=102;
     int B=102;
        PnButtonRegistarStatus.setBackground(new Color(R,G,B));
    }//GEN-LAST:event_PnButtonRegistarStatusMouseExited

    private void PnButtonRegistarHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarHistoryMouseEntered
        // TODO add your handling code here:
          int R=240;
     int G=0;
     int B=51;
     PnButtonRegistarHistory.setBackground(new Color(R, G, B));
     
    }//GEN-LAST:event_PnButtonRegistarHistoryMouseEntered

    private void PnButtonRegistarHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarHistoryMouseExited
        // TODO add your handling code here:
     int R=102;
     int G=102;
     int B=102;
        PnButtonRegistarHistory.setBackground(new Color(R,G,B));
        
    }//GEN-LAST:event_PnButtonRegistarHistoryMouseExited

    private void PnButtonRegistarContratosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarContratosMouseEntered
        // TODO add your handling code here:
     int R=240;
     int G=0;
     int B=51;
     PnButtonRegistarContratos.setBackground(new Color(R, G, B));
    }//GEN-LAST:event_PnButtonRegistarContratosMouseEntered

    private void PnButtonRegistarContratosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarContratosMouseExited
        // TODO add your handling code here:
            int R=102;
     int G=102;
     int B=102;
        PnButtonRegistarContratos.setBackground(new Color(R,G,B));
    }//GEN-LAST:event_PnButtonRegistarContratosMouseExited

    private void PnButtonRegistarDefinicoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarDefinicoesMouseEntered
        // TODO add your handling code here:
     
     //HOVER DESIGN !   
     int R=240;
     int G=0;
     int B=51;
     PnButtonRegistarDefinicoes.setBackground(new Color(R, G, B));
     //DESIGN HOVER END !
     
    }//GEN-LAST:event_PnButtonRegistarDefinicoesMouseEntered

    private void PnButtonRegistarDefinicoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarDefinicoesMouseExited
        // TODO add your handling code here:
     int R=102;
     int G=102;
     int B=102;
        PnButtonRegistarDefinicoes.setBackground(new Color(R,G,B));
    }//GEN-LAST:event_PnButtonRegistarDefinicoesMouseExited

    private void PnButtonRegistarEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarEntradasMouseClicked
        // OPEN CARD-1 WITH USER FORM !
        
        cardLayouts.show(PnlCardLayouts, "card1");
    }//GEN-LAST:event_PnButtonRegistarEntradasMouseClicked

    private void lblExitSideEntradasSaidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitSideEntradasSaidasMouseClicked
         cardLayouts.show(PnlCardLayouts, "card4");
        
    }//GEN-LAST:event_lblExitSideEntradasSaidasMouseClicked

    private void rdVaga_P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P1ActionPerformed
        
       
            vagaP="P1";
        
    }//GEN-LAST:event_rdVaga_P1ActionPerformed

    private void rdVaga_P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P2ActionPerformed
        vagaP="P2";
    }//GEN-LAST:event_rdVaga_P2ActionPerformed

    private void rdVaga_P3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P3ActionPerformed
        vagaP="P3";
    }//GEN-LAST:event_rdVaga_P3ActionPerformed

    private void rdVaga_P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P4ActionPerformed
        vagaP="P4";
    }//GEN-LAST:event_rdVaga_P4ActionPerformed

    private void rdVaga_P5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P5ActionPerformed
       vagaP="P5";
    }//GEN-LAST:event_rdVaga_P5ActionPerformed

    private void rdVaga_P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P6ActionPerformed
       vagaP="P6";
    }//GEN-LAST:event_rdVaga_P6ActionPerformed

    private void rdVaga_P7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P7ActionPerformed
       vagaP="P7";
    }//GEN-LAST:event_rdVaga_P7ActionPerformed

    private void rdVaga_P8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P8ActionPerformed
        vagaP="P8";
    }//GEN-LAST:event_rdVaga_P8ActionPerformed

    private void rdVaga_P9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P9ActionPerformed
        vagaP="P9";
    }//GEN-LAST:event_rdVaga_P9ActionPerformed

    private void rdVaga_P10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P10ActionPerformed
        vagaP="P10";
    }//GEN-LAST:event_rdVaga_P10ActionPerformed

    private void rdVaga_P11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P11ActionPerformed
      vagaP="P11";
    }//GEN-LAST:event_rdVaga_P11ActionPerformed

    private void rdVaga_P12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P12ActionPerformed
        vagaP="P12";
    }//GEN-LAST:event_rdVaga_P12ActionPerformed

    private void rdVaga_P13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P13ActionPerformed
       vagaP="P13";
    }//GEN-LAST:event_rdVaga_P13ActionPerformed

    private void rdVaga_P14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P14ActionPerformed
      vagaP="P14";
    }//GEN-LAST:event_rdVaga_P14ActionPerformed

    private void rdVaga_P15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P15ActionPerformed
       vagaP="P15";
    }//GEN-LAST:event_rdVaga_P15ActionPerformed

    private void btnParkStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParkStatusActionPerformed
        
        CheckParque chkp=new CheckParque();
        chkp.setVisible(true);
    }//GEN-LAST:event_btnParkStatusActionPerformed

    private void rdEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEntradaActionPerformed
       try {
           // TODO add your handling code here:
           generateSaidasID();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
        
        
        sendAction="Entrada";
        
        
         lblDocSaidas.setVisible(false);
        rdFeacthMatricula.setVisible(false);
        rdFeacthREF.setVisible(false);
     
              
        
    }//GEN-LAST:event_rdEntradaActionPerformed

    private void rdSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSaidaActionPerformed
        sendAction="Saida";
         try {
           // TODO add your handling code here:
           generateSaidasID();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
         
        
        lblDocSaidas.setVisible(true);
        rdFeacthMatricula.setVisible(true);
        rdFeacthREF.setVisible(true);
        lblHoraSaida.setText(actualTime);
        System.out.println("//////////////////////////////////////");
        System.out.println("HORA ACUTAL CAPTADA :"+actualTime);
                if(sendAction.equals("Entrada")){
                  
        }else if(sendAction.equals("Saida")){
            
         
        }
        
        
    }//GEN-LAST:event_rdSaidaActionPerformed

    private void PnButtonRegistarContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarContratosMouseClicked
        // TODO add your handling code here:


  cardLayouts.show(PnlCardLayouts, "card3");        
        
        
    }//GEN-LAST:event_PnButtonRegistarContratosMouseClicked

    private void PnButtonRegistarHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarHistoryMouseClicked
     cardLayouts.show(PnlCardLayouts, "card5");   
    }//GEN-LAST:event_PnButtonRegistarHistoryMouseClicked

    private void btnShowDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataActionPerformed
       try {
           pegaLinhaIndex();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
                
        try {
           getMovimentoSE();
       } catch (IOException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnShowDataActionPerformed

    private void btnContract_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContract_GuardarActionPerformed
     
        //Metodo para gerar o codigo de referencia
   
        
        /*
         ANTES DE ENVIAR OS DADOS, DEVEMOS VERIFICAR SE TODOS OS CAMPOS FORAM PREENCHIDOS.
         
         */
         if(txtContract_Proprietario.getText().equals("")|| txtContract_Documento.getText().equals("")|| txtContract_Marca.getText().equals("")||txtContractModelo.getText().equals("")|| txtContract_NrChassis.getText().equals("")|| txtContract_AnoFabrico.getText().equals("")|| txtContract_Matricula.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Porfavor preencha todos os campos origatórios !");
            
      
         }else{
                   
         
           
               contract_Query contratos=new contract_Query();
               String nacionalidad,categ,motr,cx,combustvl,tpviatura;
               nacionalidad=String.valueOf(cmbNacionalidade.getSelectedItem());
               categ=String.valueOf(cmbCategoriaContrato.getSelectedItem());
               motr=String.valueOf(cmbMotor.getSelectedItem());
               cx=String.valueOf(cmbCaixa.getSelectedItem());
               combustvl=String.valueOf(cmbCombustivel.getSelectedItem());
               tpviatura=String.valueOf(cmbTipoViatura.getSelectedItem());
        
   
        contratos.saveContractos(lblReferenciaValid.getText(),txtContract_Proprietario.getText(),Genero,txtContract_Documento.getText(),nacionalidad,txtContract_Telefone.getText(),categ,txtContract_Marca.getText(), txtContractModelo.getText(),motr,cx,combustvl, txtContract_NrChassis.getText(),tpviatura,txtContract_AnoFabrico.getText(),txtContract_Matricula.getText());
        
       
JOptionPane.showConfirmDialog(this, "Novo contracto registado com sucesso !");
             
             
             
      
         }
         
         
      
        
    }//GEN-LAST:event_btnContract_GuardarActionPerformed

    private void btnHistryPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistryPrintActionPerformed
       
       try {
           tblMovimento_SaidaEntrada.print();
       } catch (PrinterException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_btnHistryPrintActionPerformed

    private void cmbMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMotorActionPerformed

    private void btnConfirmarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPagamentoActionPerformed


        Saidas_Query registarSaidas=new Saidas_Query();
        
        registarSaidas.guardarSaidas(lblIDEntradas.getText(), txtRegist_Proprietario.getText(),txtRegist_Matricula.getText(), txtRegist_Marca1.getText(), txtModeloRegist.getText(), txtRegist_NrChassis.getText(),lblESTCAO.getText(), lblParqueAux.getText(),lblHoraEntrada.getText(),lblHoraSaida.getText(),txtRegist_Duracao.getText(), lblStation.getText(),txtRegist_TotalPagar.getText(),lblDataNow.getText());

        
    }//GEN-LAST:event_btnConfirmarPagamentoActionPerformed

    private void btnClearnFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearnFieldsActionPerformed
        limparCamposMovimento();
        
    }//GEN-LAST:event_btnClearnFieldsActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
         cardLayouts.show(PnlCardLayouts, "card4");
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
      cardLayouts.show(PnlCardLayouts, "card4");
    }//GEN-LAST:event_jLabel50MouseClicked

    private void btnFindViaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindViaturaActionPerformed
       try {
           pegaLinha();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }

      
        
    }//GEN-LAST:event_btnFindViaturaActionPerformed

    private void rdFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemeninoActionPerformed

            Genero="F";
            
            try {
           generateContractCode();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_rdFemeninoActionPerformed

    private void rdMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMasculinoActionPerformed
        Genero="M";
        try {
           generateContractCode();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_rdMasculinoActionPerformed

    private void txtContractModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContractModeloKeyReleased
         
    }//GEN-LAST:event_txtContractModeloKeyReleased

    private void cmbCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCaixaActionPerformed
       
        String CAIXA=String.valueOf(cmbCaixa.getSelectedItem());
        JOptionPane.showMessageDialog(this, CAIXA);
        System.out.println("Caixa da Viatura selecionada:"+CAIXA);
    }//GEN-LAST:event_cmbCaixaActionPerformed

    private void txtContractModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractModeloActionPerformed
      
    }//GEN-LAST:event_txtContractModeloActionPerformed

    private void cmbCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCombustivelActionPerformed

    private void cmbCategoriaContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaContratoActionPerformed
//        String Contra=String.valueOf(cmbCategoriaContrato.getSelectedItem());
//        JOptionPane.showMessageDialog(this, Contra);
//        System.out.println("Caixa da Viatura selecionada:"+Contra);
    }//GEN-LAST:event_cmbCategoriaContratoActionPerformed

    private void btnListrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListrarActionPerformed
        // TODO add your handling code here:
        
        ListContratos listContract=new ListContratos();
        listContract.setVisible(true);
        
    }//GEN-LAST:event_btnListrarActionPerformed

    private void btnCancelarContractoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarContractoActionPerformed
        // TODO add your handling code here:
        int target;
        target=Integer.valueOf(lblFoundLine.getText());
        
       removeRecords("contratos.txt",target);
        
    }//GEN-LAST:event_btnCancelarContractoActionPerformed

    private void btnContract_LimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContract_LimparCamposActionPerformed
       
        txtContractModelo.setText("");
        txtContract_Documento.setText("");
        txtContract_AnoFabrico.setText("");
        txtContract_Proprietario.setText("");
        txtContract_Telefone.setText("");
        txtContract_Marca.setText("");
        txtContract_FindViatura.setText("");
        txtContract_NrChassis.setText("");
        txtContract_Matricula.setText("");
        
    /*
        HABILITA OUTROS CONTROLES
        
        */
    
      btnCancelarContracto.setEnabled(false);
        btnContract_Editar.setEnabled(false);
        btnCancelarContracto.setEnabled(false);
        
        
        
        btnContract_Guardar.setEnabled(true);
    }//GEN-LAST:event_btnContract_LimparCamposActionPerformed

    private void btnContract_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContract_EditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContract_EditarActionPerformed

    private void jLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseClicked
        // TODO add your handling code here:
         cardLayouts.show(PnlCardLayouts, "card4");
    }//GEN-LAST:event_jLabel62MouseClicked

    private void PnButtonRegistarDefinicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarDefinicoesMouseClicked
        
          cardLayouts.show(PnlCardLayouts, "card6");
    }//GEN-LAST:event_PnButtonRegistarDefinicoesMouseClicked

    private void PnButtonRegistarStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnButtonRegistarStatusMouseClicked
       
        CheckParque checkp=new CheckParque();
        checkp.setVisible(true);
    }//GEN-LAST:event_PnButtonRegistarStatusMouseClicked

    private void rd_histryEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_histryEntradaActionPerformed
      ActionHistry="Entrada";
    }//GEN-LAST:event_rd_histryEntradaActionPerformed

    private void rd_histrySaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_histrySaidasActionPerformed
       ActionHistry="Saida";
    }//GEN-LAST:event_rd_histrySaidasActionPerformed

    private void btnAnularPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularPagamentoActionPerformed
       
       
     
    }//GEN-LAST:event_btnAnularPagamentoActionPerformed

    private void rdFeacthMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFeacthMatriculaActionPerformed
        // TODO add your handling code here:
        
        catchIDFiltraSaidas="Matricula";
    }//GEN-LAST:event_rdFeacthMatriculaActionPerformed

    private void rdFeacthREFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFeacthREFActionPerformed
        // TODO add your handling code here:
        catchIDFiltraSaidas="Referencia";
    }//GEN-LAST:event_rdFeacthREFActionPerformed

    private void rdVaga_P16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P16ActionPerformed
        // TODO add your handling code here:
         vagaP="P16";
    }//GEN-LAST:event_rdVaga_P16ActionPerformed

    private void rdVaga_P17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P17ActionPerformed
        // TODO add your handling code here:
         vagaP="P17";
    }//GEN-LAST:event_rdVaga_P17ActionPerformed

    private void rdVaga_P18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P18ActionPerformed
        // TODO add your handling code here:
         vagaP="P18";
    }//GEN-LAST:event_rdVaga_P18ActionPerformed

    private void rdVaga_P19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P19ActionPerformed
        // TODO add your handling code here:
         vagaP="P19";
    }//GEN-LAST:event_rdVaga_P19ActionPerformed

    private void rdVaga_P20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdVaga_P20ActionPerformed
        // TODO add your handling code here:
         vagaP="P20";
    }//GEN-LAST:event_rdVaga_P20ActionPerformed

    private void cmbEstacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbEstacaoMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cmbEstacaoMouseClicked

    private void cmbEstacaoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbEstacaoPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbEstacaoPropertyChange

    private void cmbEstacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstacaoItemStateChanged
        // TODO add your handling code here:
         geraEstacoes();
    }//GEN-LAST:event_cmbEstacaoItemStateChanged

    private void rdAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAdminActionPerformed
     newProfile="Admin";  
        
        
        
        
    }//GEN-LAST:event_rdAdminActionPerformed

    private void rdFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFuncionarioActionPerformed
         newProfile="Funcionario";  
         
    }//GEN-LAST:event_rdFuncionarioActionPerformed

    private void rdGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdGestorActionPerformed
         newProfile="Gestor";  
    }//GEN-LAST:event_rdGestorActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:
        
        
     
        
        
        
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        // TODO add your handling code here:
     
        //Verificar os campos
        if (txtNomeUsuario.getText().equals("") || txtUser.getText().equals("")|| txtValidateSenha.getText().equals("")){
            
            
            
           JOptionPane.showMessageDialog(null, "Todos os campos são obrigatorios...");
            
        
            
        }else{
            
             registNewUser();
            
            
        }
        
         
           //PRIMEIRO VERIFICAR SE OS CAMPOS ESTAM PREENCHIDOS
       
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void btnEditeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditeUserActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditeUserActionPerformed

    private void btnRefreshUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshUsersActionPerformed
        // TODO add your handling code here:
        
        listUtilizadores();
    }//GEN-LAST:event_btnRefreshUsersActionPerformed

    private void txtValidateSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValidateSenhaKeyPressed
        // TODO add your handling code here:
        //Mutch  the password
        
        if (txtSenhaUser.getText().equals("")||txtValidateSenha.getText().equals("")){
         
            lblBox3.setForeground(Color.red);
            lblBox3.setText("Match not Password");
            lblBox4.setForeground(Color.red);
            lblBox4.setText("Empty field");
            
            
        }else if(txtSenhaUser.getText().equals(txtValidateSenha.getText())){
         
        
            lblBox3.setForeground(Color.green);
            lblBox3.setText("Matched Password");
            lblBox4.setForeground(Color.green);
            lblBox4.setText("Matched Password");
            
            
        }else{
            
            
            lblBox3.setForeground(Color.red);
            lblBox3.setText("Password not Match");
            lblBox4.setForeground(Color.red);
            lblBox4.setText("Matched not Password");
            
            
        }
  
        
        
        
    }//GEN-LAST:event_txtValidateSenhaKeyPressed

    private void txtValidateSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValidateSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValidateSenhaActionPerformed
    
        
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new menu(onlineUser,perfileUtilizador).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ActionGrupo;
    private javax.swing.JPanel PnButtonRegistarContratos;
    private javax.swing.JPanel PnButtonRegistarDefinicoes;
    private javax.swing.JPanel PnButtonRegistarEntradas;
    private javax.swing.JPanel PnButtonRegistarHistory;
    private javax.swing.JPanel PnButtonRegistarStatus;
    private javax.swing.JPanel PnlCard1;
    private javax.swing.JPanel PnlCard2;
    private javax.swing.JPanel PnlCard3;
    private javax.swing.JPanel PnlCard4;
    private javax.swing.JPanel PnlCard5;
    private javax.swing.JPanel PnlCard6;
    private javax.swing.JPanel PnlCardLayouts;
    private javax.swing.JButton btnAnularPagamento;
    private javax.swing.JButton btnCancelarContracto;
    private javax.swing.JButton btnClearnFields;
    private javax.swing.JButton btnConfirmarPagamento;
    private javax.swing.JButton btnContract_Editar;
    private javax.swing.JButton btnContract_Guardar;
    private javax.swing.JButton btnContract_LimparCampos;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditeUser;
    private javax.swing.JButton btnFindViatura;
    private javax.swing.JButton btnHistryPrint;
    private javax.swing.JButton btnListrar;
    private javax.swing.JButton btnParkStatus;
    private javax.swing.JButton btnPushHistyMatricula;
    private javax.swing.JButton btnPushHistyModeloMarca;
    private javax.swing.JButton btnPushHistyPushData;
    private javax.swing.JButton btnPushHistyRF;
    private javax.swing.JButton btnRefreshUsers;
    private javax.swing.JButton btnRegistEntrada;
    private javax.swing.JButton btnRegist_EditDados;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnSearchVeiculo;
    private javax.swing.JButton btnShowData;
    private javax.swing.ButtonGroup choseIDSaidas;
    private javax.swing.JComboBox<String> cmbCaixa;
    private javax.swing.JComboBox<String> cmbCategoriaContrato;
    private javax.swing.JComboBox<String> cmbCombustivel;
    private javax.swing.JComboBox<String> cmbEstacao;
    private javax.swing.JComboBox<String> cmbMotor;
    private javax.swing.JComboBox<String> cmbNacionalidade;
    private javax.swing.JComboBox<String> cmbTipoViatura;
    private javax.swing.ButtonGroup genderContracts;
    private javax.swing.ButtonGroup histryOption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAuxiliarSaida;
    private javax.swing.JLabel lblBox1;
    private javax.swing.JLabel lblBox2;
    private javax.swing.JLabel lblBox3;
    private javax.swing.JLabel lblBox4;
    private javax.swing.JLabel lblControlos;
    private javax.swing.JLabel lblDadosViatura;
    private javax.swing.JLabel lblDashViaturas;
    private javax.swing.JLabel lblDataNow;
    private javax.swing.JLabel lblDataSaidas;
    private javax.swing.JLabel lblDocSaidas;
    private javax.swing.JLabel lblESTCAO;
    private javax.swing.JLabel lblExitSideEntradasSaidas;
    private javax.swing.JLabel lblFluxo1;
    private javax.swing.JLabel lblFoundLine;
    private javax.swing.JLabel lblGeneroContract;
    private javax.swing.JLabel lblHoraEntrada;
    private javax.swing.JLabel lblHoraSaida;
    private javax.swing.JLabel lblIDEntradas;
    private javax.swing.JLabel lblLogedUser;
    private javax.swing.JLabel lblLogoMenu;
    private javax.swing.JLabel lblMovimentoHistyrControlo;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblOpcaoConsulta;
    private javax.swing.JLabel lblOperation;
    private javax.swing.JLabel lblParqueAux;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPayments;
    private javax.swing.JLabel lblProprietarioDados;
    private javax.swing.JLabel lblReferenciaValid;
    private javax.swing.JLabel lblStation;
    private javax.swing.JLabel lblTaxaUnic;
    private javax.swing.JLabel lblTaxaUnicaPY;
    private javax.swing.JLabel lblTimeRGST;
    private javax.swing.JLabel lblUserNome;
    private javax.swing.JLabel lblViaturaDatas;
    private javax.swing.JLabel lblcatchedREF;
    private javax.swing.JLabel lblchosseParque;
    private javax.swing.JLabel lblprofileLoged;
    private javax.swing.ButtonGroup parqueGrupo;
    private javax.swing.ButtonGroup perfile_User;
    private javax.swing.JRadioButton rdAdmin;
    private javax.swing.JRadioButton rdEntrada;
    private javax.swing.JRadioButton rdFeacthMatricula;
    private javax.swing.JRadioButton rdFeacthREF;
    private javax.swing.JRadioButton rdFemenino;
    private javax.swing.JRadioButton rdFuncionario;
    private javax.swing.JRadioButton rdGestor;
    private javax.swing.JRadioButton rdMasculino;
    private javax.swing.JRadioButton rdSaida;
    private javax.swing.JRadioButton rdVaga_P1;
    private javax.swing.JRadioButton rdVaga_P10;
    private javax.swing.JRadioButton rdVaga_P11;
    private javax.swing.JRadioButton rdVaga_P12;
    private javax.swing.JRadioButton rdVaga_P13;
    private javax.swing.JRadioButton rdVaga_P14;
    private javax.swing.JRadioButton rdVaga_P15;
    private javax.swing.JRadioButton rdVaga_P16;
    private javax.swing.JRadioButton rdVaga_P17;
    private javax.swing.JRadioButton rdVaga_P18;
    private javax.swing.JRadioButton rdVaga_P19;
    private javax.swing.JRadioButton rdVaga_P2;
    private javax.swing.JRadioButton rdVaga_P20;
    private javax.swing.JRadioButton rdVaga_P3;
    private javax.swing.JRadioButton rdVaga_P4;
    private javax.swing.JRadioButton rdVaga_P5;
    private javax.swing.JRadioButton rdVaga_P6;
    private javax.swing.JRadioButton rdVaga_P7;
    private javax.swing.JRadioButton rdVaga_P8;
    private javax.swing.JRadioButton rdVaga_P9;
    private javax.swing.JRadioButton rd_histryEntrada;
    private javax.swing.JRadioButton rd_histrySaidas;
    private javax.swing.JTable tbListUsers;
    private javax.swing.JTable tblMovimento_SaidaEntrada;
    private javax.swing.JTable tblPayments;
    private javax.swing.JTextField txtContractModelo;
    private javax.swing.JTextField txtContract_AnoFabrico;
    private javax.swing.JTextField txtContract_Documento;
    private javax.swing.JTextField txtContract_FindViatura;
    private javax.swing.JTextField txtContract_Marca;
    private javax.swing.JTextField txtContract_Matricula;
    private javax.swing.JTextField txtContract_NrChassis;
    private javax.swing.JTextField txtContract_Proprietario;
    private javax.swing.JTextField txtContract_Telefone;
    private javax.swing.JTextField txtFind_EntradaSaidas;
    private javax.swing.JTextField txtHistryMarca;
    private javax.swing.JTextField txtHistryMatricula;
    private javax.swing.JTextField txtHistryModelo;
    private javax.swing.JTextField txtHistryReferencia;
    private javax.swing.JTextField txtModeloRegist;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtRegist_Duracao;
    private javax.swing.JTextField txtRegist_Marca1;
    private javax.swing.JTextField txtRegist_Matricula;
    private javax.swing.JTextField txtRegist_NrChassis;
    private javax.swing.JTextField txtRegist_Proprietario;
    private javax.swing.JTextField txtRegist_TotalPagar;
    private javax.swing.JTextField txtSenhaUser;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtValidateSenha;
    // End of variables declaration//GEN-END:variables
}


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SNdzekos
 */
public class Saidas_Query {
    static String Id;
   static String referencia;
static String Proprietario;
 static String Marca;
static String Modelo;
static String Matricula;
static String NrChassis;
static String estacao;
static String Contrato;
static String lugar;
static String horaEntrada;
static String horaSaida;
static String duracao;
static String dataSaida;
static String totalPago;




    File file=new File("saidas.txt");
    public void createNewFile(){
    if(!file.exists()){
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SNdzekos
 */
    
  
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

   public void guardarSaidas(String newID, String newPropriet,String newMatricula,String newMarca, String newModelo, String newChassi, String newEstacao, String newlugar, String newHentrada, String newHsaida, String newDuracao, String newContrato, String newTotalPg, String newData ){
    
    this.Id=newID;
    this.Proprietario=newPropriet;
    this.Matricula=newMatricula;
    this.Modelo=newModelo;
    this.NrChassis=newChassi;
    this.estacao=newEstacao;
    this.lugar=newlugar;
    this.horaEntrada=newHentrada;
    this.horaSaida=newHsaida;
    this.duracao=newDuracao;
    this.Contrato=newContrato;
    this.totalPago=newTotalPg;
    this.dataSaida=newData;
    
       
       
       contaLinha();
    try {
        RandomAccessFile raf=new RandomAccessFile(file, "rw");
        for (int i = 1; i <=contarLinhas; i++) {
            raf.readLine();
        }
        
        raf.writeBytes(Id+"/"+Proprietario+"/"+Matricula+"/ "+Marca+"/ "+Modelo+"/ "+NrChassis+"/ "+estacao+"/ "+lugar+"/ "+horaEntrada+"/ "+horaSaida+"/ "+duracao+"/ "+Contrato+"/ "+totalPago+"/ "+dataSaida);
        raf.writeBytes(System.lineSeparator());
        raf.close();
        
        JOptionPane.showMessageDialog(null, "Nova viatura liberada no parque"+lugar+" da estação "+estacao);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    }


} 
    
 
    
}

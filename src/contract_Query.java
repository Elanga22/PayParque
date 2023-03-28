
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SNdzekos
 */
public class contract_Query {
    
 /*  DADOS DO PROPRIETARIO  */
    static String Referencias;
 static String Proprietario;
static String NrDocumento;
 static String Nacionalidade;
static String Genero;
static String Telefone;
static String CategoriaContracto;

/*DADOS DA VIATURA */
static String Marca;
static String Modelo;
static String Motor;
static String Combustivel;
static String Caixa;
static String Chassis;
static String AnoFabrico;
static String TipoViatura;
static String Matricula;



/*CRIANDO O FICHEIRO PARA O ARMAZENAMENTO DOS DADOS*/    
    File file=new File("contratos.txt");
    public void createNewFile(){
    if(!file.exists()){
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
   
    /*FUNCAO PARA CONTAR O NUMERO DE LINHAS PRECORIDAS*/
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


/*METODO PARA ENVIAR O REGISTO*/

   public void saveContractos(String NewRefrencia,String NewProprietario, String NewGenero, String NewBI, String NewNacionalidade, String NewContact, String NewTipoContrato, String NewMarca, String NewModelo, String NewMotor , String newCaixa, String newCombustivel , String newChassis, String newTipoViatura, String newAnoFabrico, String newMatricula){
    
        /*Dados do proprietario */
        this.Referencias=NewRefrencia;
       this.Proprietario=NewProprietario;
       this.NrDocumento=NewBI;
       this.Nacionalidade=NewNacionalidade;
       this.Genero=NewGenero;
       this.Telefone=NewContact;
       this.CategoriaContracto=NewTipoContrato;
       
       /*Dados referentes a viatura do proprietario */
       this.Marca=NewMarca;
       this.Modelo=NewModelo;
       this.Chassis=newChassis;
       this.AnoFabrico=newAnoFabrico;
       this.Matricula=newMatricula;
       this.Combustivel=newCombustivel;
       this.Caixa=newCaixa;
       this.TipoViatura=newTipoViatura;
       this.Motor=NewMotor;
       
       contaLinha();
    try {
        RandomAccessFile raf=new RandomAccessFile(file, "rw");
        for (int i = 1; i <=contarLinhas; i++) {
            raf.readLine();
        }
        
        raf.writeBytes(Referencias+"/"+Proprietario+"/ "+Genero+"/ "+NrDocumento+"/ "+Nacionalidade+"/ "+Telefone+"/ "+CategoriaContracto+"/ "+Marca+"/ "+Modelo+"/ "+Motor+"/ "+Caixa+"/ "+Combustivel+"/ "+Chassis+"/"+TipoViatura+"/ "+AnoFabrico+"/ "+Matricula);
        raf.writeBytes(System.lineSeparator());
        raf.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
    }


} 
 /*GERADOR DOCODIGO DE REFERENCIA DOS CONTRACTOS */
  
}

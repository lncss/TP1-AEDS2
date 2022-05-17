import java.io.*;
import java.io.RandomAccessFile;
import javax.crypto.spec.RC2ParameterSpec;

public class TP01Q09_ArquivoEmJava{
    public static void main(String[] args)throws Exception{
       int entrada = MyIO.readInt(); // ler um numero inteiro n que indica valores reais que devem ser lidos e salvos sequencialmente no arq
       double r;

       RandomAccessFile raf = new RandomAccessFile("teste.txt", "rw"); // cria o aqr

       for(int i = 0; i < entrada; i++){ 
           r = MyIO.readDouble(); // ler os valores reais
           raf.writeDouble(r); 
       }

       raf.close(); // fechar aqr
    
       raf = new RandomAccessFile("teste.txt", "r"); // abre arq para leitura

       for(int i = entrada - 1; i >= 0; i--){
           raf.seek(i*8); 
            double numero = raf.readDouble(); // le valores

           if(numero == (int)numero){
               System.out.println((int)numero); // nn printa o 0
           }else{
               System.out.println(numero);
           }
       }
       raf.close(); // fecha arq

    }
}

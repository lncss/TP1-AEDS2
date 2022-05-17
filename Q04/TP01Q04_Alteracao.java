import java.util.Random;

public class TP01Q04_Alteracao{
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String alteracaoAleat(String texto, char letra, char subst){
        char[] palavra = texto.toCharArray();

        for(int i = 0; i != texto.length(); i++){
            if(palavra[i] == letra){
                palavra[i] = subst; // substitui a primeira letra por uma letra aleatoria gerada 
            }
        }
        return String.valueOf(palavra); // retorna a palavra com as letras trocadas
    }

    public static void main(String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;   //Desconsidera a ultima linha (FIM)
        
        Random gerador = new Random(); 

        gerador.setSeed(4); // valor igual a 4 por causa da correcao automatica

        for(int i = 0 ; i != numEntrada; i++){
            char letra1 = (char)( 'a' + Math.abs(gerador.nextInt() % 26)); // gera uma letra aletoria
            char letra2 = (char)( 'a' + Math.abs(gerador.nextInt() % 26)); 

            MyIO.println(alteracaoAleat(entrada[i], letra1, letra2));
        }
    }
}
public class TP01Q03_Ciframento {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    
    public static String encriptar(String charOriginal, int chave) { // metodo para mudar os caracteres
        char [] c = charOriginal.toCharArray(); 
        for (int i = 0; i < charOriginal.length(); i++) {
            c[i] += 3;
        }
     
        return String.valueOf(c); // retorna o caractere
    }

    public static void main(String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;
        int chave = 3; // quantidade que deslocará a mensagem por sua quantidade

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;   //Desconsidera a ultima linha (FIM)

        for(int i = 0 ; i < numEntrada; i++){
            MyIO.println(encriptar(entrada[i], chave)); // imprime a palavra cifrada
        }
        

    }
}

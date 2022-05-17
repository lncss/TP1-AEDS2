public class TP01Q11_paliRecursivo{
    
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isPalindromo(String s){
        return palindromo(s,0);
    }

     //Identifica as palavras palindromas
    public static boolean palindromo(String texto, int i){
        String inverte = "";
       
        for (i= texto.length() -1; i >= 0; i--) { 
            inverte = inverte + texto.charAt(i);
        }

        //System.out.println(contrario); //-  Funcionando.
       for(int j = 0; j < (texto.length()/2); j++){
            if(inverte.charAt(j) != texto.charAt(j)){
               return false;
            }
       }

        //System.out.println(texto);
        return true;
    }
    public static void main(String[] args){ 
        String entrada = MyIO.readLine();  

        while (true)  {
            if (isFim(entrada)) {
                break;
            }
            if(isPalindromo(entrada) == true) {
                MyIO.println("SIM");
            } else if (isPalindromo(entrada) == false) {
                if (isFim(entrada)==true) {
                    break;
                }
                else {
                    MyIO.println("NAO");
                }
            }
            entrada = MyIO.readLine();

        }
      
     }
    
}
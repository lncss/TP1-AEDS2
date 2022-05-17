public class TP01Q01_Palindromo{
    //Identifica o final do pub.in
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

     //Identifica as palavras palindromas
    public static boolean invertePalavra(String texto, int i){
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
            if(invertePalavra(entrada,0) == true) {
                MyIO.println("SIM");
            } else if (invertePalavra(entrada,0) == false) {
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
 
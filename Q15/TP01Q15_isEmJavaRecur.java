public class TP01Q15_isEmJavaRecur{
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); 
    }

    public static boolean vogal(String s){
        return isVogal(s);
    }

    public static boolean consoante(String s){
        return isConsonante(s);
    }

    public static boolean inteiro(String s){
        return isInteiro(s);
    }

    public static boolean real(String s){
        return isReal(s);
    }

    public static boolean isVogal(String texto){
        boolean resp = false;
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) == 97 || texto.charAt(i) == 101 || texto.charAt(i) == 105 ||texto.charAt(i) == 111 || texto.charAt(i) == 117 || texto.charAt(i) == 65 || texto.charAt(i) == 69 || texto.charAt(i) == 73 || texto.charAt(i) == 79 || texto.charAt(i) == 85 || texto.charAt(i) == 129 
               || texto.charAt(i) == 130 || texto.charAt(i) == 131 || texto.charAt(i) == 132 || texto.charAt(i) == 133 || texto.charAt(i) == 134 || texto.charAt(i) == 136 || texto.charAt(i) == 137 || texto.charAt(i) == 138 || texto.charAt(i) == 139 || texto.charAt(i) == 140 || texto.charAt(i) == 141 || texto.charAt(i) == 147 || texto.charAt(i) == 148 || texto.charAt(i) == 149 || texto.charAt(i) == 150 || texto.charAt(i) == 151
               || texto.charAt(i) == 160 || texto.charAt(i) == 161 || texto.charAt(i) == 162 || texto.charAt(i) == 163 || texto.charAt(i) == 198){
               cont++;
            }
        }
        if(cont == texto.length()){
            resp = true;
        }
        return resp;
    }


    public static boolean isConsonante(String texto){
        boolean resp = false;
        int cont = 0;

        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) != 97 && texto.charAt(i) != 101 && texto.charAt(i) != 105 && texto.charAt(i) != 111 && texto.charAt(i) != 117 && texto.charAt(i) != 65 && texto.charAt(i) != 69 && texto.charAt(i) != 73 && texto.charAt(i) != 79 && texto.charAt(i) != 85 && texto.charAt(i) != 129 
            && texto.charAt(i) != 130 && texto.charAt(i) != 131 && texto.charAt(i) != 132 && texto.charAt(i) != 133 && texto.charAt(i) != 134 && texto.charAt(i) != 136 && texto.charAt(i) != 137 && texto.charAt(i) != 138 && texto.charAt(i) != 139 && texto.charAt(i) != 140 && texto.charAt(i) != 141 && texto.charAt(i) != 147 && texto.charAt(i) != 148 
            && texto.charAt(i) != 149 && texto.charAt(i) != 150 && texto.charAt(i) != 151 && texto.charAt(i) != 160 && texto.charAt(i) != 161 && texto.charAt(i) != 162 && texto.charAt(i) != 163 
            && texto.charAt(i) != 198 && texto.charAt(i) != 48 && texto.charAt(i) != 49 && texto.charAt(i) != 50 && texto.charAt(i) != 51 && texto.charAt(i) != 52 && texto.charAt(i) != 53 && texto.charAt(i) != 54 && texto.charAt(i) != 55 && texto.charAt(i) != 56 && texto.charAt(i) != 57){   
                cont++;

            }
        }

        if(cont == texto.length()){
            resp = true;
        }

        return resp;
    }

    public static boolean isInteiro(String texto){
        boolean resp = false;
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) >= 48 && texto.charAt(i) <= 57){
              cont++;
            }
        }

        if(cont == texto.length()){
            resp = true;
        }
        return resp;
    }

    public static boolean isReal(String texto){
        boolean resp = false;
        int cont = 0, virg = 0;
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) >= 44 && texto.charAt(i) <= 57){
                cont++;
                if(texto.charAt(i) == 44 && texto.charAt(i) == 46){
                    virg++;
                }
            }
        }

        if(cont == texto.length()){
            if(virg > 1){
                resp = false;
            }else{
                resp = true;
            }
        }

        return resp;
    }
    public static void main(String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;
   
        do{
            entrada[numEntrada] = MyIO.readLine();
        }while (isFim(entrada[numEntrada++]) == false);
            numEntrada--;   //Desconsidera a ultima linha (FIM)
 
        for (int i = 0; i < numEntrada; i++){
            if(vogal(entrada[i]) == true){
                MyIO.print("SIM");
            }else{
                MyIO.print("NAO"); 
            }

            if(consoante(entrada[i]) == true){
                MyIO.print(" SIM");
            }else{
                MyIO.print(" NAO");
            }

            if(inteiro(entrada[i]) == true){
                MyIO.print(" SIM");
            }else{
                MyIO.print(" NAO");
            }

            if(real(entrada[i]) == true){
                MyIO.print(" SIM");
            }else{
                MyIO.print(" NAO");
            }

            MyIO.print("\n");
        }
        
    }
}
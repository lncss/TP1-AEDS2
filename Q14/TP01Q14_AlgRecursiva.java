public class TP01Q14_AlgRecursiva{
    public static int prim(String texto) { // digita na ordem e volta pro while
        return prime(texto,0);
    }

    public static int prime(String texto, int inic) { 
        for (int i = inic; i < texto.length(); i++) {
            if (texto.charAt(i) >= '0' && texto.charAt(i) <=  '9') {
                return i;  
            }
        }
        return 0;
    }
    public static int ultimo(String texto) {
        int not = texto.lastIndexOf("not"); // ultima ocorrencia
        int and = texto.lastIndexOf("and");
        int or = texto.lastIndexOf("or");
        if (not > and && not > or) { // verifica quem é maior
            return not;
        } else if (and > not && and > or) {
            return and;
        } else if (or > and && or > not){
            return or;
        }
        return 0; 
    }


    public static void main(String[] args) { 
        while(true) {
            int n= MyIO.readInt(); // quantidade de letras a serem lidas

            if (n==0) {
                break;
            }

            int[] r = new int[n]; 
            for (int i=0; i < n; i++) {
                r[i] = MyIO.readInt(); //realizar leitura do array recebido
            }
         
        String in = MyIO.readLine();
        if(in.charAt(in.length() -1) == ' '){// remover os espaços
            in = in.substring(0, in.length() - 1);
        }


        for (int i=0; i < n; i++) { 
            if (i == 0) { 
                in = in.replace("not(A)", r[0] == 0 ? "1" : "0"); 
                in = in.replace("A", r[0] == 0 ? "0" : "1"); 
            } else if (i == 1) {
                in = in.replace("not(B)", r[1] == 0 ? "1" : "0"); 
                in = in.replace("B", r[1] == 0 ? "0" : "1"); 
            }else if (i == 2) {
                in = in.replace("not(C)", r[2] == 0 ? "1" : "0");
                in = in.replace("C", r[2] == 0 ? "0" : "1"); 
            }
        }


        while(in.length() > 1) { 
            int uExp = ultimo(in);
            String exp = in.substring(uExp, in.indexOf(")", uExp) + 1); 

            if (exp.charAt(0) != 'n') { // not
                int contParametro = 1;

                for (int i = 0; i != exp.length(); i++) {
                    if (exp.charAt(i) == ',') {
                        contParametro++; //contar numero de virgulas
                    }

                }
                int[] param = new int[contParametro];
                int atual = 0;

                for (int i = 0; i != contParametro; i++) {
                    atual = prime(exp, atual);

                    String string_num = exp.substring(atual, ++atual);
                    param[i]= Integer.parseInt(string_num);
                }

                if (exp.charAt(0) == 'a') { //and
                String resp = "1";
                if (contParametro == 1) {
                    resp = String.format("%i",param[0]);
                } else {
                    for (int i = 0; i != contParametro; i++) {
                        if (param[i] == 0) { //funciona como o is fim
                            resp = "0";
                            break;
                        }
                    } 
                } 
                
                in = in.replace(exp, resp);
                } else if (exp.charAt(0)== 'o') {
                  String resp = "0";
                  if (contParametro == 1) {
                    resp = String.format("%i",param[0]);
                  } else {
                     for (int i = 0; i != contParametro; i++) {
                        if (param[i] == 1){
                            resp = "1";
                            break;
                        }
                     } 
                  }  
                  in = in.replace(exp, resp);
              } 
            } 
            else {
                if (exp.equals("not(0)")) {
                    in = in.replace("not(0)", "1");
                } else if (exp.equals("not(1)")) {
                    in = in.replace("not(1)", "0");
                }
            }
        } 
        MyIO.println(in);   
    }
}
}
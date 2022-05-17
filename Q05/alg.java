/* Crie um m´etodo iterativo que recebe uma string contendo uma
express˜ao booleana e o valor de suas entradas e retorna um booleano indicando se a express˜ao
´e verdadeira ou falsa. Cada string de entrada ´e composta por um n´umero inteiro n indicando
o n´umero de entradas da express˜ao booleana corrente. Em seguida, a string cont´em n valores
bin´arios (um para cada entrada) e a express˜ao booleana. Na sa´ıda padr˜ao, para cada linha
de entrada, escreva uma linha de sa´ıda com SIM / NAO indicando se a express˜ao corrente ´e ˜
verdadeira ou falsa. */


public class alg {

    public static int prim(String s) { // digita isso aqui na ordeme  volta pro while que parou 
        return prime(s,0);
    }

    public static int prime(String s, int inic) { // digito 
        for (int i = inic; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <=  '9') {
                return i;  // ATENÇAO QUE ELE RETORNA O i e nao 1 
            }
        }
        return 0;
    }
    public static int ultimo(String s) {
        int not = s.lastIndexOf("not"); // lastindex = indica o valor da ultima ocorrencia 
        int and = s.lastIndexOf("and");
        int or = s.lastIndexOf("or");
        if (not > and && not > or) { // verificiando quem é maior
            return not;
        } else if (and > not && and > or) {
            return and;
        } else if (or > and && or > not){
            return or;
        }
        return 0; // ?? 
    }

    public static void main(String[] args) { //primeira coisa pra digitar
        while(true) {
            int n= MyIO.readInt(); // quantidade de letras a serem lidas

            if (n==0) {
                break;
            }

            int[] r = new int[n]; //letras lidas

            for (int i=0; i < n; i++) {
                r[i] = MyIO.readInt(); //realizar leitura do array recebido
            }
         
//------------------------------------------------------------------------------------------------------------//

        String in = MyIO.readLine();//expressao completa //segunda coisa pra digitar

        if(in.charAt(in.length() -1) == ' '){//tratar a in removendo os espaços

             in = in.substring(0, in.length() - 1);
        }


        for (int i=0; i < n; i++) { //not e elementos sozinhos
            if (i == 0) { //A
                in = in.replace("not(A)", r[0] == 0 ? "1" : "0"); //not primeiro para atribuir ao A dps se nao ele atribui no A 
                in = in.replace("A", r[0] == 0 ? "0" : "1"); 
            } else if (i == 1) {
                in = in.replace("not(B)", r[1] == 0 ? "1" : "0"); //not primeiro para atribuir ao A dps se nao ele atribui no A 
                in = in.replace("B", r[1] == 0 ? "0" : "1"); 
            }else if (i == 2) {
                in = in.replace("not(C)", r[2] == 0 ? "1" : "0"); //not primeiro para atribuir ao A dps se nao ele atribui no A 
                in = in.replace("C", r[2] == 0 ? "0" : "1"); 
            }
        }
//------------------------------------------------------------------------------------------------------------//

        while(in.length() > 1) { 
            int uExp = ultimo(in);
            String exp = in.substring(uExp, in.indexOf(")", uExp) + 1); //escreve ate aqui e vai la em cima

            //-------------------------------------------//
            if (exp.charAt(0) != 'n') { //sempre compara o not primeiro para n ser substituido --- pegou apenas a primeira letra do N
                int contParametro = 1;

                for (int i = 0; i != exp.length(); i++) {
                    if (exp.charAt(i) == ',') {
                        contParametro++; //contar numero de virgula
                    }

                }
                int[] param = new int[contParametro];
                int atual = 0;

                for (int i = 0; i != contParametro; i++) {
                    atual = prime(exp, atual);

                    String string_num = exp.substring(atual, ++atual);
                    param[i]= Integer.parseInt(string_num);
                }

                //-----------------------------------//
                if (exp.charAt(0) == 'a') { //agr com and
                String resp = "1";
                if (contParametro == 1) {
                    resp = String.format("%i",param[0]);
                } else {
                    for (int i = 0; i != contParametro; i++) {
                        if (param[i] == 0) { //funciona como o is fim
                            resp = "0";
                            break;
                        }
                    } //for
                } //else
                
                in = in.replace(exp, resp);
              } //if 
              else if (exp.charAt(0)== 'o') {
                  String resp = "0";
                  if (contParametro == 1) {
                    resp = String.format("%i",param[0]);
                  } else {
                     for (int i = 0; i != contParametro; i++) {
                        if (param[i] == 1){
                            resp = "1";
                            break;
                        } //if
                     } //for

                  } //else 
                  in = in.replace(exp, resp);
              } //else if 
            } //if not
            else {
                if (exp.equals("not(0)")) {
                    in = in.replace("not(0)", "1");
                } else if (exp.equals("not(1)")) {
                    in = in.replace("not(1)", "0");
                }
            }
 

        } //while do loop
        MyIO.println(in);
        
    }
      
}
}

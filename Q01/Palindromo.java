public class Palindromo {

    public static void main (String[] args) {
        String entrada = MyIO.readLine();  

        while (true)  {
            if (isFim(entrada)) {
                break;
            }
            if(palindromoo(entrada) == true) {
                MyIO.println("SIM");
            } else if (palindromoo(entrada) == false) {
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


    public static boolean isFim(String s) {

        if (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
            return true;
        }

        return false;
    }

    public static boolean palindromoo(String s) {
        String inv = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            inv += s.charAt(i);
        }


        for (int j = 0; j < s.length(); j++) {
            if (inv.charAt(j) != s.charAt(j)) {
                return false;
            }

        }
        return true;
    }
}


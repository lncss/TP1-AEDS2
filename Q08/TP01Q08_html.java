import java.io.*;
import java.net.*;

class TP01Q08_html {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }
      return resp;
    }


    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); 
    }

    public static boolean isConsoante(char c){ //Retorna verdadeiro se o caracter for uma consoante e for uma letra minuscula (exclui maiusculos e caracteres especiais)
        if(c!='a' & c!='e' & c!='i' & c!='o' & c!='u' & c!='á'& c!='é'& c!='í'& c!='ó'& c!='ú'& c!='à'& c!='è'& c!='ì'& c!='ò'& c!='ù'& c!='ã'& c!='õ'& c!='â'& c!='ê'& c!='î'& c!='ô'& c!='û'&&(c>=97&&c<=122)){
            return true;
        }
        return false;
    }

    
   public static void main(String[] args) {
    MyIO.setCharset("utf-8");

    String html, endereco, nomeSerie;
    nomeSerie = MyIO.readLine();
    endereco = MyIO.readLine();
    int tam = 0;
    html = getHtml(endereco); //pega o html da url

    while(true){
        
        if(isFim(nomeSerie) == true){
            break;
        }

        int i1=0,i2=0,i3=0,i4=0,i5=0, //voagis
            i6=0,i7=0,i8=0,i9=0,i10=0, // vogais com acento agudo 
            i11=0,i12=0,i13=0,i14=0,i15=0, // vogais com `
            i16=0,i17=0,i18=0,i19=0,i20=0,i21=0,i22=0, // vogais com ^ e ~
            i23=0,
            i24=0,
            i25=0;
        String i26 = "";

        tam = html.length(); 
        for(int x = 0; x < tam; x++){
            if(html.charAt(x) == 'a'){ // verifica se há ocorrencia de algumas dessas letras no html, e acrescenta 1 caso seja true
                i1++;
            }else if(html.charAt(x) == 'e'){
                i2++;
            }else if(html.charAt(x) == 'i'){
                i3++;
            }else if(html.charAt(x) == 'o'){
                i4++;
            }else if(html.charAt(x) == 'u'){
                i5++;
            }else if(html.charAt(x) == 'á'){
                i6++;
            }else if(html.charAt(x) == 'é'){
                i7++;
            }else if(html.charAt(x) == 'í'){
                i8++;
            }else if(html.charAt(x) == 'ó'){
                i9++;
            }else if(html.charAt(x) == 'ú'){
                i10++;
            }else if(html.charAt(x) == 'à'){
                i11++;
            }else if(html.charAt(x) == 'è'){
                i12++;
            }else if(html.charAt(x) == 'ì'){
                i13++;
            }else if(html.charAt(x) == 'ò'){
                i14++;
            }else if(html.charAt(x) == 'ù'){
                i15++;
            }else if(html.charAt(x) == 'ã'){
                i16++;
            }else if(html.charAt(x) == 'õ'){
                i17++;
            }else if(html.charAt(x) == 'â'){
                i18++;
            }else if(html.charAt(x) == 'ê'){
                i19++;
            }else if(html.charAt(x) == 'î'){
                i20++;
            }else if(html.charAt(x) == 'ô'){
                i21++;
            }else if(html.charAt(x) == 'û'){
                i22++;
            }else if(isConsoante(html.charAt(x)) == true){ // chama o metodo isConsoante e quanta a quantidade de consoantes 
                i23++;
            }else if(html.charAt(x) == '<'){
                if(html.charAt(x+1) == 'b' && html.charAt(x+2) == 'r' && html.charAt(x+3) == '>'){
                    i24++;
                }else if(html.charAt(x+1)=='t' && html.charAt(x+2)=='a' && html.charAt(x+3)=='b' && html.charAt(x+4)=='l' && html.charAt(x+5)=='e' && html.charAt(x+6)=='>'){
                    i25++;
                } 
            }
        }

        // tira as correspondencias das letras nas tags table e br
        i1 = i1 - i25; 
        i2 = i2 - i25;
        i23 -= 3*i25;
        i23 -= 2*i24;
        i26 = nomeSerie;

        System.out.println("a("+i1+") "+"e("+i2+") "+"i("+i3+") "+"o("+i4+") "+"u("+i5+") "+"á("+i6+") "+"é("+i7+") "+"í("+i8+") "+"ó("+i9+") "+"ú("+i10+") "+"à("+i11+") "+"è("+i12+") "+"ì("+i13+") "+"ò("+i14+") "+"ù("+i15+") "+"ã("+i16+") "+"õ("+i17+") "+"â("+i18+") "+"ê("+i19+") "+"î("+i20+") "+"ô("+i21+") "+"û("+i22+") "+"consoante("+i23+") "+"<br>("+i24+") "+"<table>("+i25+") "+i26);

        nomeSerie = MyIO.readLine(); // lê a proxima série, caso seja FIM o loop se encerra
        if(isFim(nomeSerie) == true){
            break;
        }

        endereco = MyIO.readLine(); // lê o proximo endereço
        html = getHtml(endereco);
    }
      
      
   }
}
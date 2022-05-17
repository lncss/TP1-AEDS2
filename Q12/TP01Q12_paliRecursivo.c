#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool isFim(char *s){ 
    bool resp = false;

    if(s[0] == 'F' && s[1] == 'I' && s[2] == 'M'){
        resp = true;
    }
    return resp;
} 

bool invertePalindromo(char *texto,int posicao){
    char str[1000];
    strcpy(str,texto);

    int tam = strlen(texto);

    if(posicao < tam/2){
        char i = texto[posicao];
        texto[posicao] = texto[tam-posicao-1];
        texto[tam-posicao-1]=i;
        invertePalindromo(texto,posicao+1);

        int comp = strcmp(texto, str);

        if(comp == 0){
            return true;
        }else{
            return false;
        }
    }
}
bool inverte(char *texto){
    if(invertePalindromo(texto,0)){
        printf("SIM");
    }else if(invertePalindromo(texto,0) == false && isFim(texto) == false){
        printf("NAO");
    }
}

int main(){
    char entrada[1000];
    char str[1000];
    //printf("Digite uma palavra: ");

    while(isFim(entrada) == false){ // enquanto isFim eh true, a entrada ira sendo lida e salva
        scanf(" %[^\n]s", entrada);

        inverte(entrada);
        if(isFim(entrada) == true){
            break;
        }

        printf("\n");
    }
}
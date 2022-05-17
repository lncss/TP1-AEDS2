
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool isFim(char *s){ 
    if(strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M'){
        return true;
    }
    return false;
} 

bool palindromo(char *texto){
    int cont = 0;
    bool resp = false;

    for(int i = 0; i < strlen(texto); i++){
        if(texto[i] == texto[strlen(texto) - i - 1]){ // inverte os char da palavra em uma nova variavel e verifica se é igual a original
            cont++; // enquando if for true, soma um no contador
        }
    }

    if(cont == strlen(texto)){
        resp = true;
    }

    return resp;
}


int main(){
    char entrada[1000];
    //printf("Digite uma palavra: ");

    while(isFim(entrada) == false){ // enquanto isFim eh true, a entrada ira sendo lida e salva
        scanf(" %[^\n]s", entrada);
            
        if(palindromo(entrada) == true){
            printf("SIM");
        }else if(palindromo(entrada) == false && (isFim(entrada) == false)){
            printf("NAO");
        }
      printf("\n");
    }
}

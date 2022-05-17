#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char *s){
    bool resp = false;

    if(s[0] == 'F' && s[1] == 'I' && s[2] == 'M'){
        resp = true;
    }
    return resp;
}

bool isVogal(char *texto){ // verifica se a string possui somente vogais
    bool resp = false;
    int cont;
    for(int i = 0; i < strlen(texto); i++){
        if(texto[i] == 97 || texto[i] == 101 || texto[i] == 105 ||texto[i] == 111 || texto[i] == 117 || texto[i] == 65 || texto[i] == 69 || texto[i] == 73 || texto[i] == 79 || texto[i] == 85 || texto[i] == 129 
            || texto[i] == 130 || texto[i] == 131 || texto[i] == 132 || texto[i] == 133 || texto[i] == 134 || texto[i] == 136 || texto[i] == 137 || texto[i] == 138 || texto[i] == 139 || texto[i] == 140 || texto[i] == 141 || texto[i] == 147 || texto[i] == 148 || texto[i] == 149 || texto[i] == 150 || texto[i] == 151
            || texto[i] == 160 || texto[i] == 161 || texto[i] == 162 || texto[i] == 163 || texto[i] == 198){
            cont++;
        }
    }

    if(cont == strlen(texto)){
        resp = true;
    }

    return resp;

}

bool isCosoante(char *texto){ // verifica se a string é composta somente por consoantes
    bool resp = false;
    int cont = 0;
    for(int i = 0; i < strlen(texto); i++){
        if(texto[i] != 97 && texto[i] != 101 && texto[i] != 105 && texto[i] != 111 && texto[i] != 117 && texto[i] != 65 && texto[i] != 69 && texto[i] != 73 && texto[i] != 79 && texto[i] != 85 && texto[i] != 129 
            && texto[i] != 130 && texto[i] != 131 && texto[i] != 132 && texto[i] != 133 && texto[i] != 134 && texto[i] != 136 && texto[i] != 137 && texto[i] != 138 && texto[i] != 139 && texto[i] != 140 && texto[i] != 141 && texto[i] != 147 && texto[i] != 148 
            && texto[i] != 149 && texto[i] != 150 && texto[i] != 151 && texto[i] != 160 && texto[i] != 161 && texto[i] != 162 && texto[i] != 163 
            && texto[i] != 198 && texto[i] != 48 && texto[i] != 49 && texto[i] != 50 && texto[i] != 51 && texto[i] != 52 && texto[i] != 53 && texto[i] != 54 && texto[i] != 55 && texto[i] != 56 && texto[i] != 57){
            cont++;
        }
    }

    if(cont == strlen(texto)){
        resp = true;
    }
    return resp;
}

bool isInteiro(char *texto){ // verifica se na string ha numeros inteiros
    bool resp = false;
    int cont = 0;
    for(int i = 0; i < strlen(texto); i++){
        if(texto[i] >= 48 && texto[i] <= 57){
          cont++;
        }
    }

    if(cont == strlen(texto)){
        resp = true;
    }
    return resp;
}

bool isReal(char *texto){ // verifica se na string ha numeros reais
    bool resp = false;
    int virg = 0, cont = 0;
    for(int i = 0; i < strlen(texto); i++){
        if(texto[i]>= 48 && texto[i] <= 57){
            cont ++;
            if(texto[i] == 44 && texto[i] == 46){
                virg++;
            }
        }
    }

    if(cont == strlen(texto)){
        if(virg > 1){
            resp = false;
        }else{
            resp = true;
        }

    }
    return resp;
}

int main(){

    char entrada[1000];

    while(isFim(entrada) == false){ // enquanto isFim eh true, a entrada ira sendo lida e salva
        scanf(" %[^\n]s", entrada);
        
        if(isFim(entrada) == true){ // caso isFim seja true, o código termina
            break;
        }
        if(isVogal(entrada) == true){
            printf("SIM");
        }else{
            printf("NAO");
        }

        if(isCosoante(entrada) == true){
            printf(" SIM");
        }else{
            printf(" NAO");
        }
    
        if(isInteiro(entrada) == true){
            printf(" SIM");
        }else{
            printf(" NAO");
        }
          
        if(isReal(entrada) == true){
            printf(" SIM");
        }else{
            printf(" NAO");
        }

        printf("\n");
    }
    

    return 0;
}
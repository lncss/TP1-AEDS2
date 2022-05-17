#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int main(){
    int entrada;
    scanf("%d", &entrada);

    FILE *arq;
    arq = fopen("arq.txt", "w+"); // abrir um arquivo

    for(int i = 0; i != entrada; i++){
        float r;
        scanf("%f",&r);

        if(i != entrada - 1){ // num de linhas exceto a ultima(vazia)
            fprintf(arq, "%g\n", r);
        }else{
            fprintf(arq,"%g",r);
        }
    }

    fseek(arq, 0, SEEK_END); // começa do 0 e vai para o final (SEEK_END)

    for(int i = ftell(arq); i > 0; i--){
        float numero;

        if(fgetc(arq) == '\n'){
            fseek(arq, i + 2, SEEK_SET); // add a quebra de linha

            fscanf(arq,"%f", &numero); // ler numero do arq
            printf("%g\n", numero);
        }else if(i == 1){ 
            fseek(arq, i - 1, SEEK_SET);

            fscanf(arq, "%f", &numero);
            printf("%g\n", numero);
        }

        fseek(arq, i, SEEK_SET); // seta a posição do parametro
    }

    fclose(arq); // fechar o arq
    return 0;
}
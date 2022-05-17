#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdbool.h>

int main(int argc, char const *argv[])
{
    int n;
    scanf ("%d", &n); //lendo a quantidade de N para o loop

    FILE *teste; //abrindo um arquivo 
    teste = fopen ("teste.txt", "w+");

    for (int i = 0; i != n; i++) {

        float r;
        scanf ("%f", &r);
        if (i != n - 1) { //numero de linhas pq a ultima Ã© vazia
            fprintf(teste,"%g\n",r); // a quantidade de casas forem igualadas 
        } else {
            fprintf(teste,"%g",r);
        }
    }

    fseek(teste, 0, SEEK_END); // comecar da posicao ate o final --------- SEEKEND manda para o final

    for (int i = ftell(teste); i > 0; i--) { //indo ao contrario 
        float num;

        if (fgetc(teste) == '\n') { //pegar a quebra de linha
            fseek(teste, i + 2, SEEK_SET); //somar o '\n' mais o numero 

            fscanf(teste, "%f", &num); //lendo o numero no arquivo 
            printf("%g\n", num); //igualando numero de casas 

        } else if (i == 1) { // quando tiver na linha um e nao tem \n
            fseek(teste, i - 1, SEEK_SET); //

            fscanf(teste, "%f", &num); //lendo o numero no arquivo 
            printf("%g\n", num); //%g igualando numero de casas 
        }
        fseek(teste, i, SEEK_SET); //setar a posicao que voce colocou no parametro 
    } 

    fclose(teste);
    return 0;
}


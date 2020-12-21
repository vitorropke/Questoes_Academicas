#include <stdio.h>
#include<stdlib.h>

typedef struct sElemento{
	int id;
	char nome[30];
} tElemento;

void selectSort(tElemento*, int);

int main()
{
	int tamanho, contador, contadorString, chave;
	tElemento *estruturaDinamica;
    
    printf("Entre com o tamanho do vetor: ");
    scanf("%d", &tamanho);
    
    estruturaDinamica = (tElemento *)malloc(tamanho * sizeof(tElemento));
    
	for (contador = 0; contador < tamanho; contador++)
	{
		estruturaDinamica[contador].id = rand() % 100; //Valores aleatórios na estrutura estática
		
		for(contadorString = 0; contadorString < 30; contadorString++)
			estruturaDinamica[contador].nome[contadorString] = rand() % 100; //Letras aleatórias na estrutura estática
	}
	
	selectSort(estruturaDinamica, tamanho);
	
	free(estruturaDinamica);
	
	return 0;
}

void selectSort(tElemento *estruturaDinamica, int tamanho) { 
	int i, j, minimo, auxiliar;
	
	for (i = 0; i < (tamanho-1); i++) {
		minimo = i;
		
		for (j = (i + 1); j < tamanho; j++) {
			if(estruturaDinamica[j].id < estruturaDinamica[minimo].id)
				minimo = j;
		}
	
		if (estruturaDinamica[i].id != estruturaDinamica[minimo].id) {
			auxiliar = estruturaDinamica[i].id;
			estruturaDinamica[i].id = estruturaDinamica[minimo].id;
			estruturaDinamica[minimo].id = auxiliar;
		}
	}
}

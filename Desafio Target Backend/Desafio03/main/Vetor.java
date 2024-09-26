package main;

import java.util.Random;

public class Vetor {

    private int length = 366;
    private float[] vetor = new float[length];

    //Criando vetor
    public Vetor(){
        Random rand = new Random();

        //Percorre vetor
        for(int n = 0; n != vetor.length; n++){
            //Quando não for final de semana
            if(n % 7 != 0){
                vetor[n] = rand.nextFloat(500); //Insere valor aleatório entre 0 e 499
            } else {
                n++; //Não insere no final de semana
            }
        }
    }

    public void desafio03(){
        ordenar();
        System.out.println("Maior valor de faturamento: "+vetor[vetor.length-1]);
        System.out.println("Quantidade de dias acima da média: " + diasAcimaMedia(calcularMedia()));
        System.out.println("Menor valor: "+ menorValor());
    }

    //Retorna menor valor no vetor ordenado
    private float menorValor(){
        //Percorre vetor
        for(int n = 0; n < vetor.length; n++){
            if(vetor[n] != 0) return vetor[n];
        }
        return 0;
    }


    //Retorna quantidade de dias que possui o faturamento acima da média
    private int diasAcimaMedia(float media){
        int n = 0;
        //Percorre vetor
        while(vetor[n] <= media){
            n++;
            //Se encontrar um valor maior ou igual a média
            if(vetor[n] >= media){
                return vetor.length - n; //Retorna quantidades de posições restantes para comparação
                                         //O vetor está ordenado então todas as posições seguintes terão um valor maior
            }
        }
        return 0;
    }

    //Calcular média de faturamento anual
    private float calcularMedia(){
        float total = 0;
        float dias = 0;

        //Percorre vetor
        for(int n = vetor.length-1; n != 0; n--){
            //Desconsiderar zeros no cálculo
            if(vetor[n] == 0){
                break; //No vetor ordenado não existem mais valores quando chega no valor 0
            }
            //Contador de dias
            dias++;
            //Incremendo valor total
            total += vetor[n];
        }
        return total/dias; //Calcula media
    }

    public void imprimirVetor(){
        //Percorre vetor
        for(int n = 0; n != vetor.length; n++){
            System.out.println(vetor[n]);
        }
    }


    /////////
    //Ordenação HeapSort
    public void ordenar() {
        // ajustando tamanho do vetor
        length -= 1;

        // roda o método que constroi o max heap
        constroiHeap();

        // Através desse loop que a troca do valor do topo com o valor da última posição da Heap é feita
        for(int i = length; i > 0; i--){
            troca(0, length);      // Troca a posição
            length -= 1;
            maxHeap(0);
        }
    }


    // Método que constrói o Max-Heap
    private void constroiHeap() {
        int meio = length/2;

        for (int i = meio - 1; i >= 0; i--) {
            maxHeap(i);
        }
    }

    //Método para trocar posição
    private void troca(int i, int j) {
        float aux;

        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

    private void maxHeap(int pai) {
        int maior = pai;
        int left = 2 * pai + 1;
        int right = 2 * pai + 2;

        if (left <= length && vetor[left] > vetor[maior])
            maior = left;

        if (right <= length && vetor[right] > vetor[maior])
            maior = right;

        if (maior != pai) {
            troca(pai, maior);
            maxHeap(maior);
        }
    }


}

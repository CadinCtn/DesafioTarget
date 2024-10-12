package main;

public class Desafio01 {

    public int fibonacci(int num){
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }

        return fibonacci(num-1) + fibonacci(num-2);
    }

    public boolean buscarNumeroFibonacci(int numero){
        int sequencia = 0;
        while(true){
            int numeroFibonacci = fibonacci(sequencia);
            if(numeroFibonacci == numero){
                return true;
            } else if (numeroFibonacci > numero) {
                return false;
            }
            sequencia++;
        }
    }


    public static void main(String[] args){
        Desafio01 des = new Desafio01();
        int numeroProcurado = 10;
        System.out.println(des.buscarNumeroFibonacci(numeroProcurado) ? "O número pertence a sequencia." : "O número não pertence a sequencia.");


    }

}

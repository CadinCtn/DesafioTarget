package main;

public class Desafio02 {

    public void buscarLetra(String texto, char letra){
        int cont = 0;
        int index = 0;
        while(true){
            index = texto.indexOf(letra);
            texto = texto.substring(index+1);
            if(index != -1){
                cont++;
            } else {
                break;
            }
        }
        if(cont != 0){
            System.out.println("A letra '"+ letra + "' está presente e é " + (Character.isUpperCase(letra) ? "maiúscula." : "minúscula.\n" +
                               "A letra aparece " + cont + " veses."));
        } else {
            System.out.println("A letra '"+ letra + "' não aparece no texto.");
        }

    }

    public static void main(String[] args){
        Desafio02 des = new Desafio02();

        String texto = "Escreva um programa que verifique.";
        char letra = 'E';

        des.buscarLetra(texto, letra);

    }


}

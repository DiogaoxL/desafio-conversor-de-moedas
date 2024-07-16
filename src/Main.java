import api_service.BuscaMoeda;
import classes.Conversao;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        BuscaMoeda buscaMoeda = new BuscaMoeda();
        Conversao conversao = new Conversao();

        int opcao = 0;

        while (opcao != 4){
            System.out.println("1. Converter USD para BRL");
            System.out.println("2. Converter ARS para USD");
            System.out.println("3. Converter USD para COP (peso colombiano) ");
            System.out.println("4- Sair");
            System.out.print("Digete a opção: ");
             opcao = sc.nextInt();

             if (opcao == 4){
                 break;
             }
             if (opcao < 1 || opcao > 4){
                 System.out.println("Opção invalida! Tente novamente!");
                 System.out.println("-------------------------------------------------------");
                 continue;
             }

            double taxaDeConversao = buscaMoeda.BuscarMoeda(opcao);

            System.out.print("Digite a quantidade de moeda a ser convertida: ");
            double quantidade = sc.nextDouble();


            double valorConvertido = conversao.converter(taxaDeConversao, quantidade);
            System.out.println("Valor convertido: " + valorConvertido);
            System.out.println("-------------------------------------------------------");
        }
        System.out.println("programa finalizado com sucesso!");




    }
}
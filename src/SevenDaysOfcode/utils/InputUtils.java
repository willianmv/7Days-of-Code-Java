package SevenDaysOfcode.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    private final Scanner sc = new Scanner(System.in);

    public int inputIntegerNumber(int campo, int menorOpc, int maiorOpc, String  msgInput){
        while (true){
            System.out.print(msgInput);
            try{
                campo = sc.nextInt();
                if(campo < menorOpc || campo > maiorOpc){
                    System.out.println("-- INSIRA UM VALOR VÁLIDO");
                } else {
                    return campo;
                }

            }catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("-- INSIRA SOMENTE NÚMEROS INTEIROS");
            }
        }
    }

    public String inputTitulo(String campo, String msgInput){
        sc.nextLine();
        while (true){
            System.out.print(msgInput);
            campo = sc.nextLine();;
            if(campo.trim().isEmpty()){
                System.out.println("-- O TÍTULO NÃO PODE SER VAZIO");
            } else{
                return campo;
            }
        }
    }

}

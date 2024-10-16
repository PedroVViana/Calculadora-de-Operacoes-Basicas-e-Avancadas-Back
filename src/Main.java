import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> historico = new ArrayList<>();
        boolean continuar = true;

        System.out.println("Ben-vinfo à calculadora de Operações Básicas e Avançadas:");

        while (continuar) {
            try {
                System.out.println("\nEscolha a operação que deseja realizar:");
                System.out.println("1. Soma");
                System.out.println("2. Subtração");
                System.out.println("3. Multiplicação");
                System.out.println("4. Divisão");
                System.out.println("5. Raiz Quadrada");
                System.out.println("6. Exponenciação (x^y)");
                System.out.println("7. Módulo (x % y)");
                System.out.println("8. Fatorial");
                System.out.println("9. Ver Histórico");
                System.out.println("10. Sair");
                System.out.print("Digite o número da opção: ");
                int opcao = scanner.nextInt();

                if (opcao == 10) {
                    System.out.println("Encerrando a calculadora.");
                    continuar = false;
                    break;
                }

                if (opcao == 9) {
                    exibirHistorico(historico);
                    continue;
                }

                double resultado = 0;
                String operacao = "";

                 // Operações que exigem dois números
                 if (opcao >= 1 && opcao <= 7) {
                    System.out.print("Digite o primeiro número: ");
                    double num1 = scanner.nextDouble();

                    double num2 = 0;
                    if (opcao != 5) {  // Raiz quadrada não requer segundo número
                        System.out.print("Digite o segundo número: ");
                        num2 = scanner.nextDouble();
                    }

                    switch (opcao) {
                        case 1:
                            resultado = num1 + num2;
                            operacao = "Soma";
                            break;
                        case 2:
                            resultado = num1 - num2;
                            operacao = "Subtração";
                            break;
                        case 3:
                            resultado = num1 * num2;
                            operacao = "Multiplicação";
                            break;
                        case 4:
                            if (num2 == 0) {
                                System.out.println("Erro: Divisão por zero não é permitida.");
                                continue;
                            }
                            resultado = num1 / num2;
                            operacao = "Divisão";
                            break;
                        case 5:
                            if (num1 < 0) {
                                System.out.println("Erro: Raiz quadrada de número negativo não é permitida.");
                                continue;
                            }
                            resultado = Math.sqrt(num1);
                            operacao = "Raiz Quadrada";
                            break;
                        case 6:
                            resultado = Math.pow(num1, num2);
                            operacao = "Exponenciação";
                            break;
                        case 7:
                            resultado = num1 % num2;
                            operacao = "Módulo";
                            break;
                    }

                } else if (opcao == 8) {  // Fatorial
                    System.out.print("Digite um número inteiro positivo: ");
                    int num = scanner.nextInt();
                    if (num < 0) {
                        System.out.println("Erro: Fatorial de número negativo não é permitido.");
                        continue;
                    }
                    resultado = fatorial(num);
                    operacao = "Fatorial";
                } else {
                    System.out.println("Opção inválida.");
                    continue;
                }

                String calculo = operacao + ": " + resultado;
                System.out.println("Resultado: " + resultado);
                historico.add(calculo);

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira números válidos.");
                scanner.next();  // Limpa a entrada incorreta
            }
        }

        scanner.close();
    }

    private static void exibirHistorico(List<String> historico) {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma operação realizada ainda.");
        } else {
            System.out.println("\nHistórico de Operações:");
            for (String operacao : historico) {
                System.out.println(operacao);
            }
        }
    }

    // Função para calcular o fatorial
    private static long fatorial(int num) {
        long resultado = 1;
        for (int i = 2; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }
}

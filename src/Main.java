import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o salário bruto do primeiro funcionário: ");
        double salarioBruto1 = sc.nextDouble();
        calculoESalarioLiquido(salarioBruto1);

        System.out.println("Digite o salário bruto do segundo funcionário: ");
        double salarioBruto2 = sc.nextDouble();
        calculoESalarioLiquido(salarioBruto2);

        System.out.println("Digite o salário bruto do terceiro funcionário: ");
        double salarioBruto3 = sc.nextDouble();
        calculoESalarioLiquido(salarioBruto3);

        System.out.println("Digite o salário bruto do quarto funcionário: ");
        double salarioBruto4 = sc.nextDouble();
        calculoESalarioLiquido(salarioBruto4);

        System.out.println("Digite o salário bruto do quinto funcionário: ");
        double salarioBruto5 = sc.nextDouble();
        calculoESalarioLiquido(salarioBruto5);

        sc.close();
    }

    public static void calculoESalarioLiquido(double salarioBruto) {
        double descontoINSS = calculoDescontoINSS(salarioBruto);
        double descontoIR = calculoDescontoIR(salarioBruto - descontoINSS);
        double salarioLiquido = salarioBruto - descontoINSS - descontoIR;

        System.out.println("---------------------------------");
        System.out.println("Salário bruto: R$" + salarioBruto);
        System.out.println("Desconto INSS: R$ " + descontoINSS);
        System.out.println("Desconto Imposto de Renda: R$ " + descontoIR);
        System.out.println("Salário líquido: R$ " + salarioLiquido);
        System.out.println("---------------------------------");
    }

    public static double calculoDescontoINSS(double salario) {
        if (salario <= 1212.00) {
            return salario * 0.075;
        } else if (salario >= 1212.01 && salario <= 2427.35) {
            return salario * 0.09;
        } else if (salario >= 2427.36 && salario <= 3641.03) {
            return salario * 0.12;
        } else if (salario >= 3641.04 && salario <= 7087.22) {
            return salario * 0.14;
        } else {
            return 7087.22 * 0.14;
        }
    }

    public static double calculoDescontoIR(double salario) {
        if (salario <= 1903.98) {
            return 0.0;
        } else if (salario >= 1903.99 && salario <= 2826.65) {
            return salario * 0.075;
        } else if (salario >= 2826.66 && salario <= 3751.05) {
            return salario * 0.15;
        } else if (salario >= 3751.06 && salario <= 4664.68) {
            return salario * 0.225;
        } else {
            return salario * 0.275;
        }
    }
}
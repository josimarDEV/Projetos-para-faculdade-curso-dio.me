import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    int numeroConta;
    String agencia;
    String nomeCliente;
    double saldo;

    /**
     * @param args
     */
    public static void main(String[] args) {
        ContaTerminal conta = new ContaTerminal();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        conta.agencia = "0001";
        System.out.println("Informe o número da conta: ");
        conta.numeroConta = scanner.nextInt();

        scanner.nextLine();
        
        System.out.println("Informe seu nome completo: ");
        conta.nomeCliente = scanner.nextLine();


        System.out.println("Informe seu saldo: ");
        conta.saldo = scanner.nextDouble();
    
        System.out.println("Olá " + conta.nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + conta.agencia + ", conta " + conta.numeroConta + " e seu saldo " + conta.saldo + " já está disponivel para saque.");
    }
}

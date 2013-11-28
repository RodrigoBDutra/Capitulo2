package modulo02;

import java.util.Scanner;

public class PrincipalContaCorrente {
	public final static int TAM = 3;
	ContaCorrente cc[] = new ContaCorrente[TAM];
	public static int indice = 0;
	int op;
	public int getOp(){
		return this.op;
	}
	public void setOp(int op){
		if(op > indice || op <= 0){
			System.out.println("Posição inválida. Será executada para a primeira posição");
			this.op = 1;
		}
		else{
			this.op = op;
		}
	}

	public static void main(String[] args) {
		PrincipalContaCorrente obj = new PrincipalContaCorrente();
		Scanner sc = new Scanner(System.in).useDelimiter("\r\n");
		while(true){
			System.out.println("Podemos cadastrar apenas 3 contas correntes");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Sacar");
			System.out.println("3 - Depositar");
			System.out.println("4 - Consultar");
			System.out.println("9 - Sair");
			System.out.println("Entre com uma opção: ");
			int opcaoMenu = sc.nextInt();
			switch(opcaoMenu){
			case 1:
				obj.execCadastro();
				break;
			case 2:
				obj.execSaque();
				break;
			case 3:
				obj.execDeposito();
				break;
			case 4:
				obj.execConsulta();
				break;
			default:
				if(opcaoMenu == 9)
					System.exit(0);
				System.out.println("Sair");
			}
		}
	}
void execCadastro(){
	if(indice >= TAM){
		System.out.println("Todas as posições já foram ocupadas. Encerrando o programa.");
		System.exit(0);
	}
	Scanner sc = new Scanner(System.in).useDelimiter("\r\n");
	this.cc[indice] = new ContaCorrente();
	System.out.println("Digite o numero da conta: ");
	this.cc[indice].conta = sc.nextInt();
	System.out.println("Digite o numero da agencia: ");
	this.cc[indice].agencia = sc.nextInt();
	System.out.println("Digite o nome: ");
	this.cc[indice].nome = sc.next();
	System.out.println("Digite o saldo: ");
	this.cc[indice].saldo = sc.nextDouble();
	indice++;
}
void execSaque(){
	if(indice > 0){
		System.out.println("Qual posição deverá ser sacada: ");
		Scanner sc = new Scanner(System.in);
		setOp(sc.nextInt());
		System.out.println("Digite um valor: ");
		double valor = sc.nextDouble();
		int ret =this.cc[getOp() - 1].sacar(valor);
		if(ret == 0){
			System.out.println("Saque não realizado.");
		}
		else{
			System.out.println("Saque realizado.");
		}
	}
	else{
		System.out.println("Nenhuma conta foi cadastrada.");
	}
}
void execDeposito(){
	if(indice > 0){
		System.out.println("Qual posição deverá ser depositada: ");
		Scanner sc = new Scanner(System.in);
		setOp(sc.nextInt());
		System.out.println("Digite um valor: ");
		double valor = sc.nextDouble();
		this.cc[getOp() - 1].depositar(valor);
	}
	else{
		System.out.println("Nenhuma conta foi cadastrada.");
	}
}
void execConsulta(){
	if(indice > 0){
		System.out.println("Qual posição gostaria de consultar: ");
		Scanner sc = new Scanner(System.in);
		setOp(sc.nextInt());
		this.cc[getOp() - 1].imprimir();
	}
	else{
		System.out.println("Nenhuma conta cadastrada.");
	}
  }
}

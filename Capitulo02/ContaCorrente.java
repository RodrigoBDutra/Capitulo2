package modulo02;

public class ContaCorrente {
	int conta;
	int agencia;
	double saldo;
	String nome;
	
	int sacar(double valor){
		if(valor > this.saldo){
			return 0;
		}
		this.saldo = this.saldo - valor;
			return 1;
		}
	
	void depositar(double valor){
		this.saldo = this.saldo + valor;
	}
	
	void imprimir(){
		System.out.println("Nome: " + this.nome);
		System.out.println("Conta: " + this.conta);
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Saldo: " + this.saldo);
	}

}

package model.entities;

import model.exceptions.DomainException;

public class Conta {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteDeSaque;
	
	public Conta(Integer numero, String titular, Double saldo, Double limiteDeSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new DomainException("O valor precisar ser maior que zero");
		}
		saldo += valor;
	}
	
	public void sacar(double valor) {
		if (valor > limiteDeSaque) {
			throw new DomainException("O valor excede o limite de saque.");
		}
		if (valor > saldo) {
			throw new DomainException("Saldo insuficiente");
		}
		saldo -= valor;
	}
}
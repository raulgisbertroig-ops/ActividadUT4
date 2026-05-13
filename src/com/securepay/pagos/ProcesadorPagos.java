package com.securepay.pagos;

public class ProcesadorPagos {
	long idTransaccion;
	double saldo;
	char divisa;
	String titular;
	boolean cuentaActiva;

	static final int IVA_GENERAL = 21;
	static final double LIMITE_DIARIO = 10000.0;

	// Constructor corregido
	public ProcesadorPagos(long idTransaccion, double saldo, char divisa, String titular, boolean cuentaActiva) {
		this.idTransaccion = idTransaccion;
		this.saldo = saldo;
		this.divisa = divisa;
		this.titular = titular;
		this.cuentaActiva = cuentaActiva;
	}

	public static void main(String[] args) {
		System.out.println("iniciando Core Bancario");
		long idTransaccion = 9876543210L; // La 'L' indica que es Long
		double saldoActual = 1500.99;
		char divisa = '€';
		boolean cuentaActiva = true;
		String titular = "Ana García";

		ProcesadorPagos ejemplo = new ProcesadorPagos(idTransaccion, saldoActual, divisa, titular, cuentaActiva);

		double comisionCalculada = ejemplo.saldo * 0.005; // 7.504495
		int comisionReporte = (int) comisionCalculada; // Se convierte en 7
		System.out.println("Comisión real: " + comisionCalculada);
		System.out.println("Comisión reportada: " + comisionReporte); // Perdemos precisión

		boolean tieneDescubierto = false;
		double importePago = 2000.0;
		// Regla: (Sistema OK) Y (Saldo OK O Descubierto OK)
		boolean autorizacion = cuentaActiva && (saldoActual >= importePago || tieneDescubierto);

		// 2. Usamos la variable para que Eclipse deje de marcarla como "unused"
		if (autorizacion) {
			System.out.println("Pago autorizado para: " + titular);
		} else {
			System.out.println("Pago rechazado. Verifique saldo o estado de cuenta.");
		}
	}
}

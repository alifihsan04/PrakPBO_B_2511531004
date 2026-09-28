package Pekan4_2511531004;

public class RekeningGiro extends Rekening{

	private double batasOverdraft;
	
	public RekeningGiro(String nomor, String nama, double saldoAwal, String pinAwal, double batasOverdraft) {
		// memanggil inisaisi dasar dari super class 
		super(nomor, nama, saldoAwal, pinAwal);
		this.batasOverdraft = batasOverdraft;
		
	}
	
	// getter khusus giro 
	
	public double getBatasOverdraft () {
		return batasOverdraft;
	}
		 
	
}

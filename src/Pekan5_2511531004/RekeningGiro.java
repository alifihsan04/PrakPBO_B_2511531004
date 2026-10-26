package Pekan5_2511531004;

public class RekeningGiro extends Rekening{

	private double batasOverdraft;
	
	public RekeningGiro(String nomor, String nama, double saldoAwal, String pinAwal, double batasOverdraft) {
		// memanggil inisaisi dasar dari super class 
		super(nomor, nama, saldoAwal, pinAwal);
		this.batasOverdraft = batasOverdraft;
		
	}
	
	@Override
	public boolean tarikTunai(double nominal) {
		if (nominal <= 0 ) {
			System.out.println("Gagal : nominal tarik giro harus lebih dari 0 !!!");
			return false;
			}
		
		else if (nominal > (saldo + batasOverdraft)) {
			System.out.println("Transaksi gagal : Melebihi batas overdraft! maksimal penarikan: Rp " + (saldo + batasOverdraft));
			return false;
		}
		else {
			saldo -= nominal; // saldo bisa bernilai minus disini (memakan overdraft)
			
			String idTrx = "TRX-G-" + System.currentTimeMillis();
			riwayatTransaksi.add(new Transaksi(idTrx,"Debit Giro", nominal));
			
			System.out.println("Tarik tunai giro Rp " + nominal + " berhasil. saldo saat ini : Rp " + saldo);
			return true;
		}
		
		
	}
	
	// getter khusus giro 
	
	public double getBatasOverdraft () {
		return batasOverdraft;
	}
		 
	
}

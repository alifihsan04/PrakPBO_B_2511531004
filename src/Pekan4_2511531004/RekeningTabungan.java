package Pekan4_2511531004;

public class RekeningTabungan extends Rekening {

	// atribut spesifik yang hanya dimiliki oleh Tabungan
	private double sukuBunga ;
	
	// construtor sub class
	public RekeningTabungan ( String nomor, String nama, double saldoAwal, String pinAwal, double sukuBunga) {
		
		super(nomor, nama, saldoAwal, pinAwal);
		this.sukuBunga = sukuBunga;
	}
	
	public void tambahBungaAkhirBulan() {
		// menghitung bunga 
		// mengapa bisa mengakses saldo secara langsung dari Rekening Tabungan ??
		double nominalBunga = saldo * (sukuBunga / 100);
		saldo += nominalBunga; 
		
		// mencatat riwayat transaksi 
		String idTRX = "TRX-B-" + System.currentTimeMillis();
		riwayatTransaksi.add(new Transaksi(idTRX, "Bunga", nominalBunga));
		
		System.out.println("Bunga : " + sukuBunga + "% berhasil ditambahkan Rp " + nominalBunga);
	}
	
}

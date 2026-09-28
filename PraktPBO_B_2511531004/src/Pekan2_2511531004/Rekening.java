package Pekan2_2511531004;
import java.util.ArrayList;


public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	// implementasi Asosiasi ( 1 - to many)
	ArrayList<Transaksi> riwayatTransaksi;
	
	public Rekening (String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		
		// wajib menginisiasi ArrayList di dalam constructor agar tidak NullPointerException
		this.riwayatTransaksi = new ArrayList<> ();
		System.out.println("Rekening atas nama : " + namaPemilik + " berhasil dibuat dengan saldo Rp " + saldo);
		
	}
	
	public void setorTunai( double nominal) {
		if ( nominal > 0) {
			saldo += nominal;
			
			String idTrx =  "TRX-S-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx,"Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
			System.out.println("setor tunai Rp " + nominal + "berhasil. saldo saat ini : Rp " + saldo );
		} else {
			System.out.println("Gagal: nominal setor harus lebih dari 0");
		
		}
	}
	
	public void cekInformasi () {
		System.out.println("--- Info Rekening ---");
		System.out.println("No . rekening : " + nomorRekening);
		System.out.println("Nama pemilik : " + namaPemilik);
		System.out.println("Saldo Akhir :  " + saldo );
		System.out.println("-----------------------");
	}
		
	public void tarikTunai(double nominal) {
		if (nominal >= 10000 && nominal < saldo ) {
			saldo -= nominal;
			String idTrx = "TRX-T-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Debit" , nominal);
			riwayatTransaksi.add(trxBaru);
			
			System.out.println("Tarik tunai Rp " + nominal + " berhasil . saldo saaat ini Rp " + saldo);
			
		} else { 
			System.out.println("Transaksi gagal. saldo tidak mencukupi. saldo anda : " + saldo + "");
		}
	}	
	
	public void cetakMutasi() {
		System.out.println("Mutasi Rekening : " + nomorRekening );
		
		if (riwayatTransaksi.isEmpty()) {
			System.out.println("Belum ada transaksi pada rekening ini");
		} else {
			for (Transaksi t : riwayatTransaksi) {
				t.cetakDetail();
			}
		}
	}
	
	
	public static Rekening gantiAkun (ArrayList<Rekening> daftarRekening, String nomorDicari) {
		boolean ditemukan = false ; 
		
		
		for (Rekening r : daftarRekening) {
		 if (r.nomorRekening.equals(nomorDicari)) {
			 ditemukan = true;
			 System.out.println("Akun Aktif berhasil diganti ke : " + r.namaPemilik);
			 return r;
		 }
		}
		
		if (! ditemukan ) {
			System.out.println("nomor rekening tidak ditemukan");
		}
	
		return null;
}
	
	
}

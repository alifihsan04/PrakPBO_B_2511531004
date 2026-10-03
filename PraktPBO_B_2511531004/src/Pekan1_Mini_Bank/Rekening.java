package Pekan1_Mini_Bank;
import java.util.ArrayList;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	public Rekening (String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		System.out.println("Rekening atas nama : " + namaPemilik + " berhasil dibuat dengan saldo Rp " + saldo);
		
	}
	
	public void setorTunai( double nominal) {
		if ( nominal > 0) {
			saldo += nominal;
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
			System.out.println("Tarik tunai Rp " + nominal + " berhasil . saldo saaat ini Rp " + saldo);
			
		} else { 
			System.out.println("Transaksi gagal. saldo tidak mencukupi. saldo anda : " + saldo + "");
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

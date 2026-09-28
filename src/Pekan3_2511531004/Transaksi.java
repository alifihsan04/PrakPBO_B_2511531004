package Pekan3_2511531004;

public class Transaksi {
		// mengubah semua atribut menjadi private 
		private String idTransaksi;
		private String jenis;
		private double nominal;
		
		
		// constructor 
		public Transaksi (String id, String jenis, double nominal) {
			this.idTransaksi = id;
			this.jenis = jenis;
			this.nominal = nominal;
		}
		
		// hanya menyediakan Getter ( Read Only)
		public String getIdTransaksi () {
			return idTransaksi;
		}
		
		public String getJenis() {
			return jenis;
		}
		public double getNominal() {
			return nominal;
		}
		
		public void cetakDetail() {
			System.out.println("ID : " + idTransaksi + " | Jenis : " + jenis + " Nominal : Rp " + nominal);
		}

	}



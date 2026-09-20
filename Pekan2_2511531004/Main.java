package Pekan2_2511531004;

import java.util.ArrayList;
import java.util.Scanner;


	public class Main {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in) ;
			ArrayList<Rekening> daftarRekening = new ArrayList<> ();
			Rekening akunAktif = null; // objek belum diinisialisasi
			boolean isRunning = true;
			
			System.out.println("--- Sistem Perbankan Mini---");
			
			while (isRunning) {
				System.out.println("\n Menu Utama : ");
				System.out.println("1. Buka Rekening Baru ");
				System.out.println("2. Setor Tunai ");
				System.out.println("3 Tarik Tunai ");
				System.out.println("4. Cek Informasi Baru ");
				System.out.println("5. Ganti Akun");
				System.out.println("6. Cetak Mutasi");
				System.out.println("0. Keluar ");
				System.out.println("Pilih Menu : ");
				int pilihan = input.nextInt() ;
				input.nextLine(); // membersihkan buffer enter 
				
				
				switch (pilihan) {
				case 1 : 
					System.out.println("Masukkan No rekening : ");
					String no = input.nextLine();
					System.out.println("Masukkan nama Pemilik : ");
					String nama = input.nextLine();
					System.out.println("Masukkan Saldo Awal : ");
					double saldo = input.nextDouble();
					
					
					// inisialisasi object 
					akunAktif = new Rekening (no, nama, saldo);
					daftarRekening.add(akunAktif);
					break ;
					
					
				case 2 : 
					if (akunAktif == null ) {
						System.out.println("Error : mohon maaf anda belum memiliki nomor rekening !");
						
					} else { 
						System.out.println("Masukkan nominal setor : ");
						double setor = input.nextDouble();
						akunAktif.setorTunai(setor);  // memanggil method / behavior
					}
					break;
					
				case 3 : 
					if (akunAktif == null ) {
						System.out.println("error : mohon maaf anda belum membuka rekening");
					}else {
						System.out.println("Nominal yang ingin anda tarik : ");
						double tarik = input.nextDouble();
						akunAktif.tarikTunai(tarik);
					}
					break;
					
				case 4 : 
					if (akunAktif == null) {
						System.out.println("Error : anda belum membuka rekening ");
					} else { 
						akunAktif.cekInformasi();
					}
					break;
					
				case 5 : 
					System.out.println("Masukkan nomor rekening yang ingin anda cari : ");
					String nomorDicari = input.nextLine();
					
					akunAktif = Rekening.gantiAkun(daftarRekening,nomorDicari);
					break;
					
				case 6 : 
					if (akunAktif == null) {
						System.out.println("Error : Anda belum membuka rekening");
					} else {
						akunAktif.cetakMutasi();
					}
					
					break;
					
					
					
				case 0 :
					isRunning = false ;
					System.out.println("sistem ditutup. Terima Kasih !");
					break ;
					
					
					default : 
						System.out.println("Pilihan tidak valid 4");
				
							
				}
			}
			
			input.close();
		}

	}



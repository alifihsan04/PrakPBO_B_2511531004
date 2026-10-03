package Pekan4_2511531004;


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
					System.out.println("7. Simulasi Akhir Bulan (Khusus Tabungan)");
					System.out.println("0. Keluar ");
					System.out.println("Pilih Menu : ");
					int pilihan = input.nextInt() ;
					input.nextLine(); // membersihkan buffer enter 
					
					
					switch (pilihan) {
					case 1 : 
						// melakukan validasi pin terlebih dahulu, sebelum membuat Tabungan
						System.out.println("Masukkan Pin Anda : ");
						String pinAwal = input.nextLine();
						
							if(pinAwal.length() != 6 ) {
							System.out.println("Akses ditolak : Pin harus terdiri dari 6 digit");
							break;
							}
						
						System.out.println("Masukkan Saldo Awal : ");
						double saldo = input.nextDouble();
						
						System.out.println("Masukkan No rekening : ");
						String no = input.nextLine();
						input.nextLine();
						
						System.out.println("Masukkan nama Pemilik : ");
						String nama = input.nextLine();
						
						// memilih tabungan yang ingin dibuat 
						System.out.println("Pilih Produk : ");
						System.out.println("1. Tabungan Umum | 2. Giro Bisnis");
						
						System.out.println("Masukkan Pilihan : ");
						int pilihanProduk = input.nextInt();
						
						Rekening rekeningBaru; // upcasting tipe superclass 
						
							if ( pilihanProduk == 1 ) {
							System.out.println("Masukkan Suku Bunga (%) : ");
							double sukuBunga = input.nextDouble();
							input.nextLine();
							
							rekeningBaru = new RekeningTabungan(no, nama, saldo , pinAwal, sukuBunga);

							
							} else if ( pilihanProduk == 2) { 
							System.out.println("Masukkan Batas Overdraft : ");
							double batasOverdraft = input.nextDouble();
							input.nextLine();
							
							rekeningBaru = new RekeningGiro(no,nama, saldo, pinAwal, batasOverdraft);
							}
							 else { 
								System.out.println("Error : Pilihan Anda tidak valid");
								break;
							} 
						
							// inisialisasi object 
						
						akunAktif = rekeningBaru;
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
						System.out.println("Masukkan Pin anda : ");
						String pinInput = input.nextLine();
						
						if (akunAktif.otentifikasi(pinInput) ) {
							System.out.println("Masukkan Nominal yang ingin anda tarik : ");
							double tarik = input.nextDouble();
							akunAktif.tarikTunai(tarik);
							
						}else {
							System.out.println("Akses ditolak : Pin yang anda masukkan salah !");
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
						System.out.println("Masukkan Pin anda : ");
						pinInput = input.nextLine();
						if (akunAktif.otentifikasi(pinInput))  {
							akunAktif.cetakMutasi();
						} else {
							System.out.println("Akses ditolak : Pin yang anda masukkan salah! ");
						}
						
						break;
						
					case 7 : 
						if (akunAktif instanceof RekeningTabungan) {
						 RekeningTabungan tab = (RekeningTabungan) akunAktif;
						 tab.tambahBungaAkhirBulan();	
						} else { 
							System.out.println("Akses ditolak : Fitur bunga akhir bulan hanya untuk Rekening Tabungan");
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





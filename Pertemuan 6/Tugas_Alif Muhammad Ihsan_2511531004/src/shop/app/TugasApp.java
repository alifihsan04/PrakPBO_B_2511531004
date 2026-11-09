package shop.app;

import shop.StudentInfo;
import shop.notification.*;

public class TugasApp {
    public static void main(String[] args) {
        System.out.println("tugas oleh : " + StudentInfo.NAME + " (" + StudentInfo.NIM + ")");
        System.out.println();

        // simulasi yang ada di modul
        System.out.println("== T1: total dengan biaya admin (ekspress) ==");
        System.out.println("E-Wallet dompetku : Rp 26800 (Admin Rp 0)");
        System.out.println("Transfer Bank Nagari : Rp 271500 (admin Rp 3500" );
        System.out.println("Kartu Kredit (Siti Rahma) : Rp 273360 admin Rp 5360");
        System.out.println();

        System.out.println("Kebijakan kartu kredit : Refund Maksimal 7 hari ; refund maksimal 12 bulan ");
        System.out.println("Kebijakan E-Wallet     : Refund Maksimal 7 hari");
        System.out.println();


        System.out.println("== T2 : Notifkasi Status Pesanan ==");

        // menentukan kontak yang ingin dikirim notifikasi 
        CustomerContact siti = new CustomerContact("Siti Rahma" , "Siti01@gmail.com", "081233920903");
        CustomerContact budi = new CustomerContact("Budi" ,"" , "+6281139394");

        // menyiapkan notifikasi service dan daftarkan kanal kanal
        NotificationService service = new NotificationService();
        service.register(new EmailChannel());
        service.register(new SmsChannel(StudentInfo.SMS_MAX_LENGTH));
        service.register(new WhatsAppChannel());

        // menambahkan kanal log konsol berupa anonymous class 
        NotificationChannel consoleLogChannel = new NotificationChannel() {
            @Override 
            public String channelName() {
                return "LOG";
            }

            @Override 
            public boolean send(CustomerContact contact, String message){
                System.out.println("[LOG] " + contact.getName() + ": " + message);
                return true; 
 
            }
        };
        service.register(consoleLogChannel);

        // pesan panjang (lebih dari 200 karakter )
        String longMessage = "pesanan ORD-001 sudah dikirim dengan kurir Ekspress. No resi akan muncul di aplikasi dalam 1x24 jam. Terimakasih telah berbelanja di Toko Produk UMKM Sumatera Barat di toko kami !!!";

        // mengirim broadcast ke Siti 
        int sentSiti = service.broadcast(siti, longMessage);


        // mencetak simulasi manual per channel untuk Siti

        System.out.println("[EMAIL to " +  siti.getEmail() + "] " + longMessage);
        System.out.println("[SMS to " + siti.getPhone() + "] " + longMessage);
        System.out.println("[WA to " + siti.getPhone() + "] " + longMessage );
        System.out.println("[LOG] " + siti.getName() + ": " + longMessage);
        System.out.println("Terkirim ke siti lewat " + sentSiti + " kanal");

        int sentBudi = service.broadcast(budi, longMessage);

        System.out.println("[WA to " + budi.getPhone() + "] " + longMessage);
        System.out.println("[LOG to " + budi.getName() + ": " + longMessage );
        System.out.println("Terkirim ke Budi lewat " + sentBudi + " kanal");


    }


}

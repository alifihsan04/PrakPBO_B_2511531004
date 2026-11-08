package shop.notification;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private List<NotificationChannel> channels = new ArrayList<>();
    public void register(NotificationChannel channel) {
        if(channel != null) {
            channels.add(channel);
        }
    }

    // method untuk broadcast pesan ke semua kanal 
    public int broadcast(CustomerContact contact, String message) {
        int succesCount = 0;
        for (NotificationChannel channel : channels) {
            boolean succes = channel.send(contact, message) ;
            if (succes) {
                succesCount++;
            }
        }
        return succesCount;



    }
}


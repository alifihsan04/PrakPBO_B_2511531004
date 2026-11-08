package shop.notification;

public abstract class AbstractChannel implements NotificationChannel {
    protected abstract String getDestination(CustomerContact contact);
    protected abstract String prepareMessage(String message);
    protected abstract boolean sendToTarget(String destination, String message);
    
    private int sentCount = 0;
    private String lastDelivered = "";

    @Override 
    public final boolean send(CustomerContact contact, String message) {
        if (message == null || message.isBlank()) {
            return false;
        }
        
        String destination = getDestination(contact);
        if (destination == null || destination.isEmpty()) {
            return false;
        }

        // menyiapkan pesan 
        String preparedMessage = prepareMessage(message);

        // mengirim pesan
        boolean succes = sendToTarget(destination, preparedMessage);


        // jika berhasil maka catat riwayat
        if (succes) {
            sentCount++;
            lastDelivered = preparedMessage;
        }

        return succes;
    }

    public int getSentCount() {
        return sentCount;
    }
    public String getLastDelivered() {
        return lastDelivered;
    }


}


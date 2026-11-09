package shop.notification;

public class WhatsAppChannel extends AbstractChannel {

    @Override 
    public String channelName() {
        return "WhatsApp" ;
    }

    @Override 
    public String getDestination(CustomerContact contact) {
        String phone = contact.getPhone();
        if (phone == null) {
            return "";
        }
        boolean isValidLength  = phone.length() >= 10;
        boolean isPrefix = phone.startsWith("08") || phone.startsWith("62");

        if (isValidLength && isPrefix)  {
            return phone;
        }
        return "";
    }

    @Override 
    public String prepareMessage(String message) {
        return "[toko UKM] " + message ;
    }

    @Override 
    public boolean sendToTarget(String destinatoion, String message) {
        return true;
    }

}

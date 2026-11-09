package shop.notification;



public class SmsChannel extends AbstractChannel{

    private int maxLength;

    public SmsChannel(int maxLength) {
        this.maxLength = maxLength;
    }

   

    @Override 
    public String channelName() {
        return "SMS";
    }

    @Override 
    public String getDestination(CustomerContact contact) {
        String phone = contact.getPhone();
        if(phone != null && phone.startsWith("08")) {
            return phone;
        }
        return "";
    }

    @Override 
    public String prepareMessage(String message) {
        if(message.length() > maxLength) {
            if(maxLength <= 3) {
                return message.substring(0, maxLength);
            }
            return message.substring(0,maxLength - 3 ) + "..." ;
        }
        return message;
    }

    @Override 
    protected boolean sendToTarget(String destination, String message) {
        return true;
    }



}

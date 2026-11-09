package shop.notification;

public class EmailChannel extends AbstractChannel {
    @Override 
    public String channelName() {
        return "Email";
    }

    @Override 
    public String getDestination (CustomerContact contact) {
        String email = contact.getEmail();

        if (email != null && email.contains("@")){
            return email;
        }
        return "";
    }

    @Override 
    protected String prepareMessage(String message) {
        return message;
    }

    @Override 
    protected boolean sendToTarget(String destination, String message){
        return true;
    }


}

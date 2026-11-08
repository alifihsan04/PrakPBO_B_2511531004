package shop.notification;

public final class CustomerContact {

    private String name;
    private String email;
    private String phone;

    public CustomerContact( String name, String email, String phone) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nama wajib diisi !!!");
        }

        if ( email == null) {
            this.email = "";
        } else {
            this.email = email;
        }

        if (phone == null) {
            this.phone = "";
        } else {
            this.phone = phone;
        }

    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

}

package shop.model;

import shop.discount.Discountable;

public class DigitalProduct extends Product implements Discountable {
    private final String downloadURL;
    

    private final int DIGITAL_DISCOUNT_PERCENT = 10; 

    public DigitalProduct(String sku, String name, long price, String downloadURL) {
        super(sku, name, price);
        if (downloadURL == null || downloadURL.isBlank()) {
            throw new IllegalArgumentException("Download url must not be blank");
        }
        this.downloadURL = downloadURL;
    }

    public String getDownloadURL() { return downloadURL; }

    @Override 
    public String category() { return "Digital"; }


    @Override 
    public int discountPercent() { return DIGITAL_DISCOUNT_PERCENT; }

    @Override 
    public long getFinalPrice() { return applyDiscount(getPrice()); }
    
}
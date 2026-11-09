package shop.shipping;

public abstract class ShippingService {
    private final String name;

    protected ShippingService(String name) {
        
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    /*rate in Rupiah per started kilogram */
    protected abstract long ratePerKg(); // abstract method yang harus di overide subClass
 
    /* weight is rounded up : 700 g -> 1 kg, 1001 g -> 2 kg. */
    public long calculateCost (int weightGrams) {
        if (weightGrams <= 0) {
            return 0;
        }

        long kilograms = (weightGrams + 999L) / 1000;
        return kilograms * ratePerKg();
    }

}

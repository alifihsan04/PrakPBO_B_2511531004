package review.fixed;



   
    final class AddressFixed {
        private final String street;
        private final String city;

        public AddressFixed(String street, String city) {
            this.street = street;
            this.city = city;
        }

        @Override 
        public String toString() {
            return street + ", " + city;
        }
    }


   
    

    // dikon menggunakan override biaaasa, tanpa instance of 
    interface DiscountFixed {
        long apply(long price);
    }

    class FlashSaleDiscountFixed implements DiscountFixed{
        @Override 
        public long apply(long price) {
            return price - (price * 30/100);
        }

    }


    public class BadShopRefactored{
        public static void main(String[] args){
      

       
        
        AddressFixed home1 = new AddressFixed("Jl. Sudirman 10", "Padang");
        AddressFixed home2 = new AddressFixed("Jl. Sudirman 10", "Bukittinggi");
        
      
        

        DiscountFixed flashSale = new FlashSaleDiscountFixed();
        System.out.println("Harga flash sale: " + flashSale.apply(100_000));

        }
    }





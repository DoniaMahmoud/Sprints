
public class OriginalPrice implements I_Discount {
    
	public int OriginalPrice;
	
	public OriginalPrice() {
		this.OriginalPrice=0;
	}
	public OriginalPrice(int price) {
		this.OriginalPrice=price;
	}

	@Override
	public void setOriginalPrice(int originalPrice) {
		 this.OriginalPrice = originalPrice;
		
	}
	@Override
	public int getPrice() {
		return this.OriginalPrice;
	}
 
}

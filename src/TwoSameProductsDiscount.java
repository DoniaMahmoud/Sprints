
public class TwoSameProductsDiscount extends CondimentDecorator {

   public TwoSameProductsDiscount(I_Discount discount) {
	   super(discount);
   }
	
	@Override
	public I_Discount getNewPrice() {
		I_Discount d=this.discount;
		 d.setOriginalPrice((int) (discount.getPrice()*0.9));
			return d;
		
	}

}

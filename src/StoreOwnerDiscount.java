
public class StoreOwnerDiscount  extends CondimentDecorator{
	
	   public StoreOwnerDiscount(I_Discount discount) {
		   super(discount);
	   }
	@Override
	public I_Discount getNewPrice() {
	 I_Discount d=this.discount;
	 d.setOriginalPrice ((int) (discount.getPrice()*0.85));
		return d;
	}

}

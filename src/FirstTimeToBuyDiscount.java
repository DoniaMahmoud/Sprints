
public class FirstTimeToBuyDiscount extends CondimentDecorator {
	  
	public FirstTimeToBuyDiscount(I_Discount discount) {
		super(discount);
	}
	@Override
	public I_Discount getNewPrice() {
		I_Discount d=this.discount;				
		 d.setOriginalPrice((int) (discount.getPrice()*0.95));
			return d;
	}

}

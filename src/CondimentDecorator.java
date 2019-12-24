
public abstract class CondimentDecorator {
	I_Discount discount;
    public abstract I_Discount getNewPrice();
    public CondimentDecorator(I_Discount discount) {
    	this.discount=discount;
    }
   
}

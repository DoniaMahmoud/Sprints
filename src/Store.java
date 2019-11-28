public abstract class Store {
	protected String name;
	protected String type;

	public abstract void setStore_Name(String Name);
	public abstract void setStore_Type(String Type);
	public abstract String getStore_Name();
	public abstract String getStore_Type();
}

public abstract class Building {

	protected String name;
	protected String address;
	
	public Building()
	{
		name = "Building";
		address = "Address";
	}
	abstract public String getName();
	abstract public void setName(String n);
	abstract public void setAddress(String a);
	abstract public void addOccupants(Person p);
	abstract public void listOccupants();
}

import java.util.ArrayList;

public class CityHall extends Building {
	public	ArrayList<Person> currentOccupants = new ArrayList<Person>();
	
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public void setAddress(String a)
	{
		address = a;
	}
	
	public void addOccupants(Person p)
	{
		currentOccupants.add(p);
	}
	
	public void listOccupants()
	{
		for(int x = 0; x < currentOccupants.size(); x++)
		{
			System.out.printf(currentOccupants.get(x).getName());
			System.out.printf("\n");
		}
	}
}

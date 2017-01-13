import java.util.Random;
public abstract class Person {
	
	protected String cityName;
	protected String name;
	protected int age;
	protected int phoneNumber;
	private static int lastNumber = 1111111;
	private Random random = new Random();
	
	
	public Rank rank;
	
	public enum Rank
	{
		Patrol, Sergeant, Captain, Chief
	}
	
	
	public Person(){
		cityName = "Spokane";
		name = "name";
		age = random.nextInt(100);
		phoneNumber = lastNumber;
		lastNumber++;
	};
	
	abstract public String getName();
	abstract public void setName(String n);
	abstract public void payEmployee();
	abstract public int getSavings();
	abstract public void setRank(String r);
	abstract public String getRank();
}

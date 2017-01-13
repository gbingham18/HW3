
public class Police extends Person 
	implements Employee {
	private
	int Savings = 0;
	String policeRole;
	int EmployeeID = 1111;
	
	public Rank rank;
	
	public enum Rank
	{
		Patrol,
		Sergeant,
		Captain,
		Chief
	}
	
	public void payEmployee() {
		int newSavings = Savings + 100;
		Savings = newSavings;
	}
	
	public int getEmpolyeeID() {
		return EmployeeID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}

	public String getPoliceRole() {
		return policeRole;
	}

	public void setPoliceRole(String Role) {
		policeRole = Role;
	}
	
	public int getSavings()
	{
		return Savings;
	}
	
	public String getRank()
	{
		String s = "String";
		if(this.rank == Rank.Patrol)
		{
			s = "Patrol";
		}
		else if(this.rank == Rank.Sergeant)
		{
			s = "Sergeant";
		}
		else if(this.rank == Rank.Captain)
		{
			s = "Captain";
		}
		else if(this.rank == Rank.Chief)
		{
			s = "Chief";
		}
		return s;
	}
	
	public void setRank(String r)
	{
		if(r == "Patrol")
		{
			rank = Rank.Patrol;
		}
		else if(r == "Sergeant")
		{
			rank = Rank.Sergeant;
		}
		else if(r == "Captain")
		{
			rank = Rank.Captain;
		}
		else if(r == "Chief")
		{
			rank = Rank.Chief;
		}	
	}
}

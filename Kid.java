
public class Kid extends Person{
	private
	String favoriteCandy;
	
	String getFavoriteCandy()
	{
		return favoriteCandy;
	}
	
	void setFavoriteCandy(String Candy)
	{
		favoriteCandy = Candy;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void payEmployee() {}
	
	public int getSavings() { return 0; }
	
	
	public String getRank() {
		return "No Rank";
	}
	
	public void setRank(String r){}
}

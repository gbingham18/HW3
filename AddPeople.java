import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JLabel;

public class AddPeople extends javax.swing.JComponent
	implements MouseMotionListener {
	
	String message;
	Person person;
	int x = 125, y = 95;
	
	public Building[] cityBuildings = {new CityHall(), new School()};
	
	public AddPeople() {
		message = "Message";
		addMouseMotionListener(this);
	}
	public AddPeople(Person p) {
		if(p instanceof Kid)
		{
			message = p.getName() + " (Kid)";
		}
		else if(p instanceof Teacher)
		{
			message = p.getName() + " (Teacher)"; 
		}
		else
		{
			message = p.getName() + " (Police)";
		}
		person = p; //Each AddPeople object will be associated with a Person object
		addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g){
		g.drawString(this.message, 100, 150);
	}
	//Enable mouse to recognize if it has clicked on a person
	//If mouse has clicked on person, add them to correct building based on where they are dragged
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		if(x >= 15 && x <= 95 && y >= 100 && y <= 180)
		{
			placePeople(cityBuildings[0], this.person);
		}
		else if(x >= 250 && x <= 330 && y >= 100 && y >= 180)
		{
			placePeople(cityBuildings[1], this.person);
		}
		repaint();//call paintComponent
	}
	public void mouseMoved(MouseEvent e) {}
	
	//Adds Person to Building's ArrayList
	public void placePeople(Building b, Person p)
	{
		if(b instanceof CityHall)
		{
					b.addOccupants(p);
		}
		else
		{
					b.addOccupants(p);
		}
	}
}


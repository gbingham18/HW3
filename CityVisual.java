import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.Random;
import java.util.Scanner;
public class CityVisual {
	JFrame frame;
	public Person[] cityPeople = {new Kid(), new Police(), new Teacher(),
			new Kid(), new Police(), new Teacher(), 
			new Kid(), new Police(), new Teacher(),
			new Kid(), new Police(), new Teacher(),};
	
	public Building[] cityBuildings = {new CityHall(), new School()};
	
	Random rand = new Random();
	
	public static void main(String[] args)
	{
		CityVisual city = new CityVisual();
	}
	
	public CityVisual()
	{
		cityPeople[0].setName("Tim");
		cityPeople[1].setName("Rick");
		cityPeople[2].setName("Jane");
		cityPeople[3].setName("John");
		cityPeople[4].setName("Susan");
		cityPeople[5].setName("Mike");
		cityPeople[6].setName("Ally");
		cityPeople[7].setName("Ross");
		cityPeople[8].setName("Tom");
		cityPeople[9].setName("Grant");
		cityPeople[10].setName("Alex");
		cityPeople[11].setName("Dean");
		
		cityPeople[1].setRank("Patrol");
		cityPeople[4].setRank("Sergeant");
		cityPeople[7].setRank("Captain");
		cityPeople[10].setRank("Chief");
		
		cityBuildings[0].setName("CityHall");
		cityBuildings[1].setName("Whitworth");
		
		initialize(); 
		frame.setVisible(true);
	}
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(200,100,650,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		try
		{
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			URL imgUrl = getClass().getResource("/Resource/school.jpg");
			URL imgUrl2 = getClass().getResource("/Resource/CityHall.jpg");
			URL imgUrl3 = getClass().getResource("/Resource/WhitSpace.jpg");
			URL imgUrl4 = getClass().getResource("/Resource/WhitSpace.jpg");
			Image img = toolkit.getImage(imgUrl);
			Image img2 = toolkit.getImage(imgUrl2);
			Image img3 = toolkit.getImage(imgUrl3);
			Image img4 = toolkit.getImage(imgUrl4);
			img = img.getScaledInstance(60, 60,  Image.SCALE_SMOOTH);
			img2 = img2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			img3 = img3.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			img4 = img4.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			
		    ImageIcon icon = new ImageIcon(img);
		    ImageIcon icon2 = new ImageIcon(img2);
		    ImageIcon icon3 = new ImageIcon(img3);
		    ImageIcon icon4 = new ImageIcon(img4);
		    
		    JPanel p = new JPanel();
		    JPanel p_1 = new JPanel();
		    
		    //Button that lists all the Occupants in the School
		    JButton btn = new JButton(icon);
		    btn.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) {
		    		listPeopleinBuilding(cityBuildings[1]);
		    	}
		    });
		    p.setLayout(new GridLayout(0, 1, 0, 0));
		    p.add(btn);
		    frame.getContentPane().add(p, BorderLayout.EAST);
		    
		   
		    //Button that lists all the Occupants in the CityHall
		    JButton btn2 = new JButton(icon2);
		    btn2.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) {
		    		listPeopleinBuilding(cityBuildings[0]);
		    	}
		    });
		    p = new JPanel();
		    p.setLayout(new GridLayout(0, 1, 0, 0));
		    p.add(btn2);
		   
		    frame.getContentPane().add(p, BorderLayout.WEST); 
		    
		    // Center Panel (p_1) layout, adds a blank image to each side
		    // p_1 is added at the bottom of initialize()
		    p_1.setLayout(null);
		    JLabel picLabel = new JLabel(icon4);
		    p_1.add(picLabel);
		    picLabel.setBounds(15, 150, 80, 80);
		    JLabel picLabel2 = new JLabel(icon3);
		    picLabel2.setBounds(350, 150, 80, 80);
		    p_1.add(picLabel2);
		    
		    
		    //Button generates text field where user can type a Police Person's name
		    //Outputs that Police Person's rank
		    JButton btn5 = new JButton("Get Rank");
		    btn5.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) {
		    		JTextField textField = new JTextField();
		    		p_1.add(textField);
		    		textField.setLocation(170, 300);
		    		textField.setText("");
		    		for(int i = 0; i < 12; i++)
		    		{
		    			if(textField.getText() == cityPeople[i].getName())
		    			{
		    				System.out.printf(cityPeople[i].getRank());
		    			}
		    		}
		    	}
		    });
		   
		     
		   
		    //Allows for user to search for a Person and pay that Person
		    //When button is pressed, TextField appears at the bottom of the Center panel
		    //User can enter a string to search for and pay Person
		    JButton btn4 = new JButton("Pay Employee");
		    btn4.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) {
		    		JTextField textField = new JTextField();
		    		p_1.add(textField);
		    		textField.setLocation(170, 300);
		    		textField.setText("");
		    		for(int i = 0; i < 12; i++)
		    		{
		    			if(textField.getText() == cityPeople[i].getName())
		    			{
		    				cityPeople[i].payEmployee();
		    			}
		    		}
		    	}
		    }); 
		    
		   
		    
		    p = new JPanel();
		    p.add(btn4);
		    p.add(btn5);
		    frame.getContentPane().add(p, BorderLayout.SOUTH);
		    
		    //The 3 buttons below add text of a Person's name and what type of Person they are
		    JButton btn3 = new JButton ("Add Kid");
		    btn3.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) {
		    		int i = rand.nextInt(11);
		    		do {
		    			if(cityPeople[i] instanceof Kid)
		    			{
		    				AddPeople label = new AddPeople(cityPeople[i]);
		    				label.setLocation(150, 50);
		    				p_1.add(label);
		    			}
		    		} while(cityPeople[i] instanceof Teacher || cityPeople[i] instanceof Police);
				    frame.revalidate();
		    	}
		    });
		    
		    JButton btn6 = new JButton ("Add Teacher");
		    btn6.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) {
		    		int i = rand.nextInt(11);
		    		do {
		    			if(cityPeople[i] instanceof Teacher)
		    			{
		    				AddPeople label = new AddPeople(cityPeople[i]);
		    				label.setLocation(150, 50);
		    				p_1.add(label);
		    			}
		    		} while(cityPeople[i] instanceof Kid || cityPeople[i] instanceof Police);
				    frame.revalidate();
		    	}
		    });
		    
		    JButton btn7 = new JButton ("Add Police");
		    btn7.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ae) {
		    		int i = rand.nextInt(11);
		    		do {
		    			if(cityPeople[i] instanceof Police)
		    			{
		    				AddPeople label = new AddPeople(cityPeople[i]);
		    				label.setLocation(150, 50);
		    				p_1.add(label);
		    			}
		    		} while(cityPeople[i] instanceof Teacher || cityPeople[i] instanceof Kid);
		    	}
		    });
		    p = new JPanel();
		    p.add(btn3);
		    p.add(btn6);
		    p.add(btn7);
		    frame.getContentPane().add(p, BorderLayout.NORTH);
		    
		    frame.getContentPane().add(p_1, BorderLayout.CENTER);
		}
		catch(Exception ex)
		{
			System.out.printf("%s\n", ex.getMessage());
		}
	 }
	
	
	public static void listPeopleinBuilding(Building b)
	{
		b.listOccupants();
	}
}

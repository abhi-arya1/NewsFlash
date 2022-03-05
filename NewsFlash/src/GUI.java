import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.net.URISyntaxException;
import java.util.*;
import java.time.*;
import java.time.format.*;

/** 
 * GUI Setup file for a program that uses DataSource [sinbad.jar]
 * and SwingLink.java to give people news breifings gathered from 
 * multiple news sites based on their chosen genre.
 * 
 * @author Abhi Arya
 */

public class GUI
{
	// Class member vars.
	
	// Frames
	static JFrame f1 = new JFrame("NewsFlash"); // Opening Page
	static JFrame f2 = new JFrame("World News and Politics");
	static JFrame f3 = new JFrame("Sports");
	static JFrame f4 = new JFrame("Technology");
	// static JFrame f5 = new JFrame(null); was removed due to lack of content. 
	static JFrame f6 = new JFrame("Misc. News");
	static JFrame f7 = new JFrame("Health and COVID-19");
	static JFrame f8 = new JFrame("Sources");
	
	// Other Vars.
	static Image icon = Toolkit.getDefaultToolkit().getImage(
			"GENERAL_USE_DARK_BLUE_ICON_NEWS-71.png");
	static final String tr = "t";
	static final String fl = "f";
	static NewsSources n = new NewsSources();
	
	/** 
	*  Constructor
	*  
	*  @throws -- URISyntaxException if the link for the News Page is not formatted
	*			 properly. 
	*/		      
	public GUI() throws URISyntaxException
	{
		frame1Init();
		setVis(tr, f1); 
		
		// Initializes all frames once, so that way they only
		// have to be setVis and !setVis to show up. 
		frame2Init();
		frame3Init();
		frame4Init();
		// frame5Init() removed due to lack of content. 
		frame6Init();
		frame7Init();
		frame8Init();
	}
	
	/**
	 * From here on down, there are frame initializers for each
	 * section of the app. They each look similar, but have certain 
	 * specific changes unique to their class, which is why
	 * there is one for every single frame. 
	 * 
	 */
	
	// GUI Initializer ("Init" as Abbreviation)
	public static void frame1Init()
	{

		// Setting Frame
		f1.setSize(445, 370);
		f1.setLayout(null);

		// Setting App Icon
		Image icon = Toolkit.getDefaultToolkit().getImage(
				"GENERAL_USE_DARK_BLUE_ICON_NEWS-71.png");
		f1.setIconImage(icon);  
		
		// Setting Welcome and Date Text Fields
		JLabel welLabel = new JLabel("Welcome to NewsFlash");
		welLabel.setFont(new Font("Lato", Font.BOLD, 30));
	    welLabel.setForeground(Color.BLACK);
	    welLabel.setBounds(15,10,400,25); 
	    
	    JLabel dateLabel = new JLabel("The date today is: " + setDate());
	    dateLabel.setFont(new Font("Lato", Font.ITALIC, 20));
	    dateLabel.setForeground(Color.BLACK);
	    dateLabel.setBounds(15,45,400,25); 
	    
	    JLabel infoLbl = new JLabel("Choose Your Category for News from the Past Week:");
	    infoLbl.setFont(new Font("Lato", Font.PLAIN, 17));
	    infoLbl.setForeground(Color.BLACK);
	    infoLbl.setBounds(15,75,500,25); 
	    
	    // Add text elements to frame
		f1.add(welLabel);
		f1.add(dateLabel);
		f1.add(infoLbl);
		
		// Sets up Buttons for Genres for Frame 1 
		button1Init();
	}
	
	public static void button1Init()
	{
		// Setting Genre Buttons
		JButton j1 = new JButton("World News and Politics");
		j1.setFont(new Font("Lato", Font.BOLD, 16));
	    j1.setForeground(Color.BLACK);
	    j1.setBounds(15,130,400,25); 
	    
	    
	    JButton j3 = new JButton("Sports");
	  	j3.setFont(new Font("Lato", Font.BOLD, 16));
	  	j3.setForeground(Color.BLACK);
	  	j3.setBounds(15,165,400,25); 
	  	
	  	JButton j4 = new JButton("Technology");
	  	j4.setFont(new Font("Lato", Font.BOLD, 16));
	  	j4.setForeground(Color.BLACK);
	  	j4.setBounds(15,200,400,25);
	  	
	  	JButton j6 = new JButton("Health/COVID-19");
	  	j6.setFont(new Font("Lato", Font.BOLD, 16));
	  	j6.setForeground(Color.BLACK);
	  	j6.setBounds(15,235,400,25);
	  	// Numbers do not line up, because the button-order was changed. 
	  	
	  	JButton j5 = new JButton("Other News");
	  	j5.setFont(new Font("Lato", Font.BOLD, 16));
	  	j5.setForeground(Color.BLACK);
	  	j5.setBounds(15,270,400,25);
	  	
		// Add genre buttons to frame
	    f1.add(j1);
	    // f1.add(j2); [JButton j2 was removed due to lack of content]
	    f1.add(j3);
	    f1.add(j4);
	    f1.add(j5);
	    f1.add(j6);
	    
	    //Adding ActionListeners for each button to open the News topic Frame.
	    
	    // World News Button
	    j1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  setVis(fl, f1);
		    	  setVis(tr, f2);
		    	  
		      } } );
	    
	    // Sports Button
	    j3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  setVis(fl, f1);
		    	  setVis(tr, f3);
		    	  
		      } } );
	    
	    // Technology Button
	    j4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  setVis(fl, f1);
		    	  setVis(tr, f4);
		    	  
		      } } );
	    
	    // Health and COVID-19 Button 
	    j6.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  setVis(fl, f1);
		    	  setVis(tr, f7);
		    	  
		      } } );
	    
	    // Other Articles Button 
	    j5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  setVis(fl, f1);
		    	  setVis(tr, f6);
		    	  
		      } } );
	    
	    // Adds a button for the "Sources" Frame for User Transparency
	    JButton srcBut = new JButton("Sources");
	  	srcBut.setFont(new Font("Lato", Font.BOLD, 10));
	  	srcBut.setForeground(Color.BLACK);
	  	srcBut.setBounds(15,305,75,15);

	  	srcBut.addActionListener(new ActionListener() {
	  		public void actionPerformed(ActionEvent e) {

	  			setVis(fl, f1);
	  			setVis(tr, f8);

	  		} } );
	  	 
	  	f1.add(srcBut);
	}
	
	// World News + Politics Frame
	public static void frame2Init()
	{
		// Sets up the Frame
		f2.setSize(900, 800);
		f2.setLayout(null);
		f2.setIconImage(icon); 
		
		// Sets up the Panel for Links
		 JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		 p.setSize(new Dimension(900, 700));
		 p.setLocation(15, 50);
		    
		// Creates the Title Label
		JLabel welLabel = new JLabel("World News and Politics");
		welLabel.setFont(new Font("Lato", Font.BOLD, 30));
	    welLabel.setForeground(Color.BLACK);
	    welLabel.setBounds(15,10,400,25); 
	    f2.add(welLabel);
	    
	    // Adds Image to Title Section
	    JLabel img = new JLabel(new ImageIcon("25x25globe.png"));
	    img.setBounds(375,10,25,25); 
	    f2.add(img);
	    
	    // Gets all the News Pages related to World News
	    ArrayList<NewsPage> pages = n.getWorldNewsList();
	    
	    int pgCount = 1;
	    // Adds all the Newspages to the Frame
	    for(NewsPage np : pages)
	    {
	    	// Uses SwingLink.java to create Hyperlinks for all Title Labels.
		    SwingLink titleHyperlink = new SwingLink(pgCount + ") " +
		    		np.getTitle() + ": " + np.getDate(), np.getLink());
		    titleHyperlink.setFont(new Font("Lato", Font.PLAIN, 14));

		    // Adds to JPanel "p" for the Hyperlinks to work. 
		    p.add(titleHyperlink);
		    pgCount++;
	    }
	    
	    addBackButton(f2);
	    f2.add(p);
	}
	
	// Sports News Frame 
	public static void frame3Init()
	{
		// Sets up the Frame
		f3.setSize(900, 750);
		f3.setLayout(null);
		f3.setIconImage(icon);  

		// Sets up the Panel for Links
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		p.setSize(new Dimension(900, 650));
		p.setLocation(15, 50);

		// Creates the Title Label
		JLabel welLabel = new JLabel("Sports");
		welLabel.setFont(new Font("Lato", Font.BOLD, 30));
		welLabel.setForeground(Color.BLACK);
		welLabel.setBounds(15,10,400,25); 
		f3.add(welLabel);
		
		// Adds Image to Header
		JLabel img = new JLabel(new ImageIcon("25x25soccerball.png"));
	    img.setBounds(115,10,25,25); 
	    f3.add(img);

		// Gets all the News Pages related to Entertainment News
		ArrayList<NewsPage> pages = n.getSportsNewsList();
		
		int pgCount = 1;
		// Adds all the Newspages to the Frame
		for(NewsPage np : pages)
		{
			SwingLink titleHyperlink = new SwingLink(pgCount + ") " +
					np.getTitle() + ": " + np.getDate(), np.getLink());
			titleHyperlink.setFont(new Font("Lato", Font.PLAIN, 14));
			
			p.add(titleHyperlink);
			pgCount++;
		}

		addBackButton(f3);
		f3.add(p);
	}
	
	// Technology News Frame
	public static void frame4Init()
	{
		// Sets up the Frame
		f4.setSize(900, 750);
		f4.setLayout(null);
		f4.setIconImage(icon);  

		// Sets up the Panel for Links
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		p.setSize(new Dimension(900, 650));
		p.setLocation(15, 50);

		// Creates the Title Label
		JLabel welLabel = new JLabel("Technology");
		welLabel.setFont(new Font("Lato", Font.BOLD, 30));
		welLabel.setForeground(Color.BLACK);
		welLabel.setBounds(15,10,400,25); 
		f4.add(welLabel);
		
		// Adds Image to Header
		JLabel img = new JLabel(new ImageIcon("computer25x25.png"));
		img.setBounds(195,10,25,25); 
		f4.add(img);

		// Gets all the News Pages related to Entertainment News
		ArrayList<NewsPage> pages = n.getTechNewsList();
		
		int pgCount = 1;
		// Adds all the Newspages to the Frame
		for(NewsPage np : pages)
		{
			SwingLink titleHyperlink = new SwingLink(pgCount + ") " +
					np.getTitle() + ": " + np.getDate(), np.getLink());
			titleHyperlink.setFont(new Font("Lato", Font.PLAIN, 14));

			p.add(titleHyperlink);
			pgCount++;
		}

		addBackButton(f4);
		f4.add(p);
	}
	
	// Other News Frame
	public static void frame6Init()
	{
		// Sets up the Frame
		f6.setSize(900, 800);
		f6.setLayout(null);
		f6.setIconImage(icon); 
		
		// Sets up the Panel for Links
		 JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		 p.setSize(new Dimension(900, 700));
		 p.setLocation(15, 50);
		    
		// Creates the Title Label
		JLabel welLabel = new JLabel("Other News");
		welLabel.setFont(new Font("Lato", Font.BOLD, 30));
	    welLabel.setForeground(Color.BLACK);
	    welLabel.setBounds(15,10,400,25); 
	    f6.add(welLabel);
	    
	    // Adds Image to Header
	    JLabel img = new JLabel(new ImageIcon("Scroll25x25.png"));
	    img.setBounds(190,10,25,25); 
	    f6.add(img);
	
	    // Gets all the News Pages related to World News
	    ArrayList<NewsPage> pages = n.returnRandoms();
	    
	    int pgCount = 1;
	    // Adds all the Newspages to the Frame
	    for(NewsPage np : pages)
	    {
	    	// Uses SwingLink.java to create Hyperlinks for all Title Labels.
		    SwingLink titleHyperlink = new SwingLink(pgCount + ") " +
		    		np.getTitle() + ": " + np.getDate(), np.getLink());
		    titleHyperlink.setFont(new Font("Lato", Font.PLAIN, 14));

		    // Adds to JPanel "p" for the Hyperlinks to work. 
		    p.add(titleHyperlink);
		    pgCount++;
	    }
	    
	    addBackButton(f6);
	    f6.add(p);
	}
	
	// Health News Frame
	public static void frame7Init()
	{
		// Sets up the Frame
		f7.setSize(900, 750);
		f7.setLayout(null);
		f7.setIconImage(icon);  

		// Sets up the Panel for Links
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		p.setSize(new Dimension(900, 650));
		p.setLocation(15, 50);

		// Creates the Title Label
		JLabel welLabel = new JLabel("Health and COVID-19");
		welLabel.setFont(new Font("Lato", Font.BOLD, 30));
		welLabel.setForeground(Color.BLACK);
		welLabel.setBounds(15,10,400,25); 
		f7.add(welLabel);
		
		// Adds Image to Header
		JLabel img = new JLabel(new ImageIcon("25x25doctor.png"));
		img.setBounds(325,10,25,25); 
		f7.add(img);

		// Gets all the News Pages related to Entertainment News
		ArrayList<NewsPage> pages = n.getHealthNewsList();
		
		int pgCount = 1;
		// Adds all the Newspages to the Frame
		for(NewsPage np : pages)
		{
			SwingLink titleHyperlink = new SwingLink(pgCount + ") " +
					np.getTitle() + ": " + np.getDate(), np.getLink());
			titleHyperlink.setFont(new Font("Lato", Font.PLAIN, 14));

			p.add(titleHyperlink);
			pgCount++; 
		}

		addBackButton(f7);
		f7.add(p);
	}
	
	public static void frame8Init()
	{
		// Sets up the Frame
		f8.setSize(900, 750);
		f8.setLayout(null);
		f8.setIconImage(icon);  

		// Sets up the Panel for Links
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		p.setSize(new Dimension(900, 650));
		p.setLocation(15, 50);

		// Creates the Title Label
		JLabel welLabel = new JLabel("Sources");
		welLabel.setFont(new Font("Lato", Font.BOLD, 30));
		welLabel.setForeground(Color.BLACK);
		welLabel.setBounds(15,10,400,25); 
		f8.add(welLabel);
		
		// Adds Image to Header
		JLabel img = new JLabel(new ImageIcon("srcIcon25x25.png"));
		img.setBounds(140,10,25,25); 
		f8.add(img);

		// Gets all the News Pages related to Entertainment News
		
		int SrcCount = 1;
		// Adds all the Newspages to the Frame
		for(int i = 0; i < n.srcNames.length; i++)
		{
			SwingLink titleHyperlink = new SwingLink(SrcCount + ") " + 
					n.srcNames[i], n.srcs[i]);
			titleHyperlink.setFont(new Font("Lato", Font.PLAIN, 14));

			p.add(titleHyperlink);
			SrcCount++;
		}

		addBackButton(f8);
		f8.add(p);
	}
	
	
	// Adds a "back" button to the top right corner of the:
	// @param f -- the JFrame that the back button is added to. 
	public static void addBackButton(JFrame f)
	{
		JButton back = new JButton();
		back.setText("<- Back");
	    back.setFont(new Font("Lato", Font.BOLD, 10));
	    back.setForeground(Color.BLACK);
	    back.setBounds(800,15,80,25); 
	   
	    f.add(back);
	    
	    back.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  // Enables master frame "f1", disables current frame "f". 
		    	  setVis(tr, f1);
		    	  setVis(fl, f);
		    	  
		      } } );
	}
	
	// Obtains current date
	// @return -- formatted date 
	public static String setDate()
	{	
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 LocalDateTime now = LocalDateTime.now();  
		 
		 return (dtf.format(now));  
	}
	
	/**
	 * @param c -> True/False String using GUI Variables "tr" and "fl"
	 * @param f -> The frame to Set Visible or Not Visible
	 */
	public static void setVis(String c, JFrame f)
	{
		if(c.equals("t"))
			f.setVisible(true);
		else if(c.equals("f"))
			f.setVisible(false);
	}
	
}

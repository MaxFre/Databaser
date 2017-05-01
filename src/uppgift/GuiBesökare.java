package uppgift;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class GuiBesökare extends JFrame implements ActionListener {

	private Controller controller;
	private JLabel showMembers = new JLabel("Visa alla medlemmar i:");
	private JLabel showAll = new JLabel("Visa alla spelningar för:");
	private JLabel helloText = new JLabel("Visitors");
	private TextArea respons = new TextArea("RESPONS");
	private TextField Members = new TextField();
	private TextField from = new TextField();
	private JButton searchMembers = new JButton("Search");
	private JButton getFrom = new JButton("From");
	private JButton search = new JButton("Search");

	private JButton getContact = new JButton("Kontakt");
	private JButton getSpelSchema = new JButton("Schema");
	private JButton getBand = new JButton("Bandinfo");

	public GuiBesökare() {
		new JScrollPane(respons);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 500));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		;

		buildGui();
	}

	public void buildGui() {

		helloText.setFont(helloText.getFont().deriveFont(64.0f));
		respons.setFont(respons.getFont().deriveFont(20.0f));
		
		
		helloText.setBounds(50, 10, 300, 50);

		respons.setBounds(200, 100, 600, 300);

		showMembers.setBounds(20, 220, 150, 30);
		showAll.setBounds(20, 80, 150, 30);

		getFrom.setBounds(125, 120, 70, 30);
		from.setBounds(20, 120, 100, 30);
		Members.setBounds(20, 250, 100, 30);

		getContact.setBounds(530, 60, 100, 30);

		getBand.setBounds(310, 60, 100, 30);
		getSpelSchema.setBounds(420, 60, 100, 30);

		search.setBounds(30, 160, 80, 30);
		searchMembers.setBounds(30, 290, 80, 30);

		add(searchMembers);
		add(Members);
		add(getContact);
		add(getSpelSchema);
		add(getBand);
		add(search);
		add(Members);
		add(from);
		add(showAll);
		add(showMembers);
		add(helloText);
		add(respons);

		getContact.addActionListener(this);
		getSpelSchema.addActionListener(this);
		getBand.addActionListener(this);
		search.addActionListener(this);
		searchMembers.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == getContact) {
			
			String toDo = " select fnamn, enamn, band from (person as p join kontaktperson as k on p.pid=k.pid) order by fnamn asc;";
			try {				
				controller = new Controller("Contact",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Kontakperson för varje band:\n\n" +svar);
		}	
		
		
		if (e.getSource() == getSpelSchema) {
			
			String toDo = "select band,scene, tid from spelschema order by scene, tid asc;";
			try {				
				controller = new Controller("schema",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
	
		
	if (e.getSource() == getBand) {			
			String toDo = "SELECT DISTINCT band, land from(person as p join bandinfo as b on p.pid= b.pid);";
			try {				
				controller = new Controller("band", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
		if (e.getSource() == searchMembers) {
			String showBands = Members.getText();
			
			String toDo = "select fnamn,enamn from(person as p join bandinfo as b on p.pid=b.pid) where band = '" + showBands+ "'";
			try {		
				System.out.println(toDo);
				controller = new Controller("visaM", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (showBands + " medlemmar:\n"+controller.getRespons());
			respons.setText(svar);
			
		}
		
		if (e.getSource() == search) {
			
			
			String showBands = from.getText();
	
			String toDo = "select * from spelschema where band ='" + showBands+ "' order by tid";
			try {				
				controller = new Controller("visa", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			respons.setText(svar);
			System.out.println(svar);
		}
		
	  }
	}
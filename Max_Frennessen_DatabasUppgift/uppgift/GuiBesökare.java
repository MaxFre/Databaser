package uppgift;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	private JButton getMembers1 = new JButton("members");
	private JButton getMembers2 = new JButton("members");
	private JButton getMembers3 = new JButton("members");
	private JButton getMembers4 = new JButton("members");
	private JButton getMembers5 = new JButton("members");
	
	private JButton getPlays1 = new JButton("Schedule");
	private JButton getPlays2 = new JButton("Schedule");
	private JButton getPlays3 = new JButton("Schedule");
	private JButton getPlays4 = new JButton("Schedule");
	private JButton getPlays5 = new JButton("Schedule");
	
	private JLabel Ai1 = new JLabel("Ai1");

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
		respons.setFont(respons.getFont().deriveFont(18.0f));
		
		
		helloText.setBounds(50, 10, 300, 50);

		respons.setBounds(200, 100, 600, 300);

		showMembers.setBounds(20, 220, 150, 30);
		showAll.setBounds(20, 80, 150, 30);

		getFrom.setBounds(125, 120, 70, 30);
		from.setBounds(20, 120, 100, 30);
		Members.setBounds(20, 250, 100, 30);

		getContact.setBounds(530, 60, 100, 30);

		getMembers1.setBounds(800, 105, 100, 30);
		getMembers2.setBounds(800, 105, 100, 30);
		getMembers3.setBounds(800, 105, 100, 30);
		getMembers4.setBounds(800, 105, 100, 30);
		getMembers5.setBounds(800, 105, 100, 30);
		
		getPlays1.setBounds(800, 105, 100, 30);
		getPlays2.setBounds(800, 105, 100, 30);
		getPlays3.setBounds(800, 105, 100, 30);
		getPlays4.setBounds(800, 105, 100, 30);
		getPlays5.setBounds(800, 105, 100, 30);
		
		
		
		getBand.setBounds(310, 60, 100, 30);
		getSpelSchema.setBounds(420, 60, 100, 30);

		search.setBounds(30, 160, 80, 30);
		searchMembers.setBounds(30, 290, 80, 30);

	
		
		add(getPlays1);
		add(getPlays2);
		add(getPlays3);
		add(getPlays4);
		add(getPlays5);
		
		add(getMembers1);
		add(getMembers2);
		add(getMembers3);
		add(getMembers4);
		add(getMembers5);
		
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
		getMembers1.addActionListener(this);
		getMembers2.addActionListener(this);
		getMembers3.addActionListener(this);
		getMembers4.addActionListener(this);
		getMembers5.addActionListener(this);
		getPlays1.addActionListener(this);
		getPlays2.addActionListener(this);
		getPlays3.addActionListener(this);
		getPlays4.addActionListener(this);
		getPlays5.addActionListener(this);
	}

	
	public void hideButtons(){
		getMembers1.setBounds(840, 103, 90, 25);
		getMembers2.setBounds(840, 103, 90, 25);
		getMembers3.setBounds(840, 103, 90, 25);
		getMembers4.setBounds(840, 103, 90, 25);
		getMembers5.setBounds(840, 103, 90, 25);
		
		getPlays1.setBounds(840, 103, 90, 25);
		getPlays2.setBounds(840, 103, 90, 25);
		getPlays3.setBounds(840, 103, 90, 25);
		getPlays4.setBounds(840, 103, 90, 25);
		getPlays5.setBounds(840, 103, 90, 25);
	}
	
	public void showButtons(){
		getMembers1.setBounds(440, 103, 90, 20);
		getMembers2.setBounds(440, 126, 90, 20);
		getMembers3.setBounds(440, 149, 90, 20);
		getMembers4.setBounds(440, 172, 90, 20);
		getMembers5.setBounds(440, 195, 90, 20);
		
		getPlays1.setBounds(540, 103, 90, 20);
		getPlays2.setBounds(540, 126, 90, 20);
		getPlays3.setBounds(540, 149, 90, 20);
		getPlays4.setBounds(540, 172, 90, 20);
		getPlays5.setBounds(540, 195, 90, 20);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == getMembers1) {
			
			String toDo = "select fnamn, enamn, land,extra from((person join bandinfo on person.pid=bandinfo.pid) join band on bandinfo.bid=band.bid) join artistinfo on artistinfo.pid=person.pid where bandnamn='The Strokes' order by fnamn asc;";
			try {				
				controller = new Controller("visaM",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("The Strokes medlemmar:\n\n" +svar);
			hideButtons();
		}	
		
		if (e.getSource() == getMembers2) {
			
			String toDo = "select fnamn, enamn, land,extra from((person join bandinfo on person.pid=bandinfo.pid) join band on bandinfo.bid=band.bid) join artistinfo on artistinfo.pid=person.pid where bandnamn='Elvis Presley' order by fnamn asc;";
			try {				
				controller = new Controller("visaM",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Elvis Presley medlemmar:\n\n" +svar);
			hideButtons();
		}	
		if (e.getSource() == getMembers3) {
			
			String toDo = "select fnamn, enamn, land,extra from((person join bandinfo on person.pid=bandinfo.pid) join band on bandinfo.bid=band.bid) join artistinfo on artistinfo.pid=person.pid where bandnamn ='First aid kit' order by fnamn asc;";
			try {				
				controller = new Controller("visaM",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("First aid kit medlemmar:\n\n" +svar);
			hideButtons();
		}	
		if (e.getSource() == getMembers4) {
			
			String toDo = "select fnamn, enamn, land,extra from((person join bandinfo on person.pid=bandinfo.pid) join band on bandinfo.bid=band.bid) join artistinfo on artistinfo.pid=person.pid where bandnamn='Arctic Monkeys' order by fnamn asc;";
			try {				
				controller = new Controller("visaM",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Arctic Monkeys medlemmar:\n\n" +svar);
			hideButtons();
		}	
		if (e.getSource() == getMembers5) {
			
			String toDo = "select fnamn, enamn, land,extra from((person join bandinfo on person.pid=bandinfo.pid) join band on bandinfo.bid=band.bid) join artistinfo on artistinfo.pid=person.pid where bandnamn='Lisa Nilsson' order by fnamn asc;";
			try {				
				controller = new Controller("visaM",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Lisa Nilsson medlemmar:\n\n" +svar);
			hideButtons();
		}	
		
		if (e.getSource() == getPlays1) {
			
			hideButtons();
					
			String toDo = "select tid, scene from(spelschema join band on spelschema.bid=band.bid) where bandnamn='The Strokes';";
			try {				
				controller = new Controller("visa", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			
			respons.setText("The Strokes  \n" + svar);					
		}	
		
		if (e.getSource() == getPlays2) {
			
			hideButtons();
					
			String toDo = "select tid, scene from(spelschema join band on spelschema.bid=band.bid) where bandnamn='Elvis Presley';";
			try {				
				controller = new Controller("visa", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			
			respons.setText("Elvis Presley  \n" + svar);					
		}
		
		if (e.getSource() == getPlays3) {
			
			hideButtons();
					
			String toDo = "select tid, scene from(spelschema join band on spelschema.bid=band.bid) where bandnamn='First aid kit';";
			try {				
				controller = new Controller("visa", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			
			respons.setText("First aid kit  \n" + svar);					
		}
		
		if (e.getSource() == getPlays4) {
			
			hideButtons();
					
			String toDo = "select tid, scene from(spelschema join band on spelschema.bid=band.bid) where bandnamn='Arctic Monkeys';";
			try {				
				controller = new Controller("visa", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			
			respons.setText("Arctic Monkeys  \n" + svar);					
		}
		
	if (e.getSource() == getPlays5) {
			
			hideButtons();
					
			String toDo = "select tid, scene from(spelschema join band on spelschema.bid=band.bid) where bandnamn='Lisa Nilsson';";
			try {				
				controller = new Controller("visa", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			
			respons.setText("Lisa Nilsson  \n" + svar);					
		}

		if (e.getSource() == getContact) {
			hideButtons();
			String toDo = "select fnamn, enamn, bandnamn from ((person as p join kontaktperson as k on p.pid=k.pid) join band on k.bid=band.bid) order by fnamn asc;";
			try {				
				controller = new Controller("Contact",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Kontakperson för varje band:\n\n" +svar);
		}	
		
		
		if (e.getSource() == getSpelSchema) {
			hideButtons();
			String toDo = "select bandnamn, scene, tid from (spelschema as s join band as b on s.bid=b.bid);";
			try {				
				controller = new Controller("schema",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
	
		
	if (e.getSource() == getBand) {	

	
			String toDo = "select bandnamn from band;";
			try {				
				controller = new Controller("band", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
			showButtons();
		}
		
		if (e.getSource() == searchMembers) {
			String showBands = Members.getText();
			hideButtons();
			String toDo = "select fnamn, enamn, land,extra from((person join bandinfo on person.pid=bandinfo.pid) join band on bandinfo.bid=band.bid) join artistinfo on artistinfo.pid=person.pid where bandnamn='" + showBands +"' order by fnamn asc;";
			try {		
				System.out.println(toDo);
				controller = new Controller("visaM", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			

			String svar = (showBands + " medlemmar:\n"+controller.getRespons());
			respons.setText(svar);

			
		}
		
		if (e.getSource() == search) {
			
			hideButtons();
			String showBands = from.getText();
			if(showBands.length()<1){
				from.setText("Skriv nåt då");
			}
			else{
			String toDo = "select tid, scene from(spelschema join band on spelschema.bid=band.bid) where bandnamn='" +showBands +"';";
			try {				
				controller = new Controller("visa", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			if(svar.length()<1){
				respons.setText("Ingen träff");
			}
			else{
			respons.setText(showBands + "\n" + svar);
			}
			}
		}
		
	  }
	}
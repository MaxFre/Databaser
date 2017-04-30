package uppgift;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;




public class Gui extends JFrame implements ActionListener{ 

	private Controller controller;
	
	private JLabel helloText = new JLabel("FIRST PROTOTYP");
	private TextArea respons = new TextArea("RESPONS");
	private TextField who = new TextField();
	private TextField from = new TextField();
	private JButton getAll = new JButton("Get all");
	private JButton getFrom = new JButton("From");
	private JButton search = new JButton("Search");
	
	private JButton getJobbare = new JButton("Jobbare");
	private JButton getTabeller = new JButton("Tabeller");
	private JButton getContact = new JButton("Kontakt");
	private JButton getSpelSchema = new JButton("Schema");
	private JButton getBand = new JButton("Bandinfo");
	
	
	private String selectWho;
	private String fromWhat;
	
	
	
	public Gui() {

		new JScrollPane(respons);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 500));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);;
		
		buildGui();	
	}
	
	public void buildGui(){
		
		helloText.setBounds(250, 10, 200, 20);
		
		respons.setBounds(200, 100, 600, 300);
		
		getAll.setBounds(125, 80, 70, 30);
		who.setBounds(20, 80, 100, 30);
		
		getFrom.setBounds(125, 120, 70, 30);
		from.setBounds(20, 120, 100, 30);
		
		
		getTabeller.setBounds(640, 60, 100, 30);
		getContact.setBounds(530, 60, 100, 30);
		getJobbare.setBounds(200, 60, 100, 30);
		getBand.setBounds(310, 60, 100, 30);
		getSpelSchema.setBounds(420, 60, 100, 30);
		
		search.setBounds(30, 160, 80, 30);
		
		add(getTabeller);
		add(getContact);
		add(getSpelSchema);
		add(getBand);
		add(getJobbare);
		add(search);
		add(getFrom);
		add(from);
		add(who);
		add(getAll);
		add(helloText);
		add(respons);
	
		
		getJobbare.addActionListener(this);
		getTabeller.addActionListener(this);
		getContact.addActionListener(this);
		getSpelSchema.addActionListener(this);
		getBand.addActionListener(this);
		search.addActionListener(this);
		
		getAll.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == getTabeller) {
			getJobbare.setEnabled(true);
			getTabeller.setEnabled(false);
			getContact.setEnabled(true);
			getSpelSchema.setEnabled(true);
			getBand.setEnabled(true);
			
			getTabeller.setEnabled(false);
			String toDo = "\\dt";
			try {				
				controller = new Controller("tabeller",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Kontakperson för varje band:\n\n" +svar);
		}
		
		if (e.getSource() == getContact) {
			
			getJobbare.setEnabled(true);
			getTabeller.setEnabled(true);
			getContact.setEnabled(false);
			getSpelSchema.setEnabled(true);
			getBand.setEnabled(true);
			
			String toDo = " select fnamn, enamn, band from (person as p join kontaktperson as k on p.pid=k.pid) order by fnamn asc;";
			try {				
				controller = new Controller("Contact",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Kontakperson för varje band:\n\n" +svar);
		}	
		
		
		if (e.getSource() == getSpelSchema) {
			getJobbare.setEnabled(true);
			getTabeller.setEnabled(true);
			getContact.setEnabled(true);
			getSpelSchema.setEnabled(false);
			getBand.setEnabled(true);
			String toDo = "select band,scene, tid from spelschema order by scene ,tid asc;";
			try {				
				controller = new Controller("schema",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
		
		if (e.getSource() == getJobbare) {
			getJobbare.setEnabled(false);
			getTabeller.setEnabled(true);
			getContact.setEnabled(true);
			getSpelSchema.setEnabled(true);
			getBand.setEnabled(true);
			String toDo = "select p.pid, fnamn, enamn, personnummer, adress from(person p join jobbare as j on p.pid=j.pid);";
			try {				
				controller = new Controller("jobbare",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
	if (e.getSource() == getBand) {	
		getJobbare.setEnabled(true);
		getTabeller.setEnabled(true);
		getContact.setEnabled(true);
		getSpelSchema.setEnabled(true);
		getBand.setEnabled(false);
			String toDo = "SELECT DISTINCT band, land from(person as p join bandinfo as b on p.pid= b.pid);";
			try {				
				controller = new Controller("band", toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
		if (e.getSource() == getAll) {
			who.setText("<All>");
		}
		
		if (e.getSource() == search) {
			
			selectWho = who.getText();
			if(selectWho.equals("<All>")){
				selectWho = "*";
			}
			fromWhat = from.getText();
	
			try {				
				controller = new Controller(selectWho, fromWhat);
			} catch (Exception e1) {e1.printStackTrace();}
			
			
			String svar = (controller.getRespons());
			respons.setText(svar);
			System.out.println(svar);
		}
		
	}
	
}

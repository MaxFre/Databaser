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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;




public class Gui extends JFrame implements ActionListener{ 

	private Controller controller;
	
	private JLabel helloText = new JLabel("Admin");
	private TextArea respons = new TextArea("RESPONS");
	private TextField who = new TextField("*");
	private TextField from = new TextField("hund");
	private JButton getAll = new JButton("Get all");
	private JButton getFrom = new JButton("From");
	private JButton search = new JButton("Search");
	
	private JButton deleteKontakt = new JButton("Delete kontakt");
	private JButton setKontakt = new JButton("Ge kontakt");
	private JButton getJobbare = new JButton("Jobbare");
	private JButton addNewBand = new JButton("New band");
	private JButton deleteBand = new JButton("Delete band");
	private JButton addNewPlay = new JButton("Ny spelning");
	private JButton deletePlay = new JButton("Delete spelning");
	private JButton getContact = new JButton("Kontakt");
	private JButton getSpelSchema = new JButton("Schema");
	private JButton getBand = new JButton("Bandinfo");
	
	
	private String selectWho;
	private String fromWhat;
	
	
	
	public Gui() {

		new JScrollPane(respons);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000, 500));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);;
		
		buildGui();	
	}
	
	public void buildGui(){
		helloText.setFont(helloText.getFont().deriveFont(64.0f));
		respons.setFont(respons.getFont().deriveFont(16.0f));
		
		
		helloText.setBounds(20, 10, 300, 50);
		
		respons.setBounds(200, 100, 800, 300);
		
		getAll.setBounds(125, 80, 70, 30);
		who.setBounds(20, 80, 100, 30);
		
		getFrom.setBounds(125, 120, 70, 30);
		from.setBounds(20, 120, 100, 30);
		
		
		
		deleteKontakt.setBounds(5, 150, 110, 30);
		setKontakt.setBounds(5, 110, 110, 30);
		deletePlay.setBounds(5, 350, 110, 30);
		addNewPlay.setBounds(5, 310, 110, 30);
		
		deleteBand.setBounds(5, 270, 110, 30);
		addNewBand.setBounds(5, 235, 110, 30);
		
		getContact.setBounds(530, 60, 100, 30);
		getJobbare.setBounds(200, 60, 100, 30);
		getBand.setBounds(310, 60, 100, 30);
		getSpelSchema.setBounds(420, 60, 100, 30);
		
		search.setBounds(20, 160, 80, 30);
		
		add(deleteKontakt);
		add(setKontakt);
		add(deletePlay);
		add(addNewPlay);
		add(deleteBand);
		add(addNewBand);
		add(getContact);
		add(getSpelSchema);
		add(getBand);
		add(getJobbare);
		
//		add(search);
//		add(getFrom);
//		add(from);
//		add(who);
//		add(getAll);
		
		
		add(helloText);
		add(respons);
		
//		search.setEnabled(false);
//
//		while(who.getText().length() > 0 && from.getText().length() > 0) {
//			search.setEnabled(true);
//		}
		
		deleteKontakt.addActionListener(this);
		setKontakt.addActionListener(this);
		deletePlay.addActionListener(this);
		addNewPlay.addActionListener(this);
		addNewBand.addActionListener(this);
		getContact.addActionListener(this);
		getSpelSchema.addActionListener(this);
		getBand.addActionListener(this);
		search.addActionListener(this);
		getJobbare.addActionListener(this);
		getAll.addActionListener(this);
		deleteBand.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == deleteKontakt) {
			
			  String toDo ="";
			  
			  String kontaktPid = (JOptionPane.showInputDialog("Kontaktpersons id?"));
											
			  String kontaktBid = (JOptionPane.showInputDialog("BandId som kontaktperson är till för?"));

			  
			  
			  toDo = "delete from kontaktperson where pid="+kontaktPid+"and bid="+kontaktBid+";";
			
				if(toDo.length()>1){
				try {				
					controller = new Controller("",toDo);
				} catch (Exception e1) {e1.printStackTrace();}		
				}
				 toDo = "select person.pid, fnamn,enamn,band.bid,bandnamn from ((person join kontaktperson on person.pid=kontaktperson.pid )join band on kontaktperson.bid=band.bid)order by fnamn asc;";
					try {				
						controller = new Controller("AdminContact",toDo);
					} catch (Exception e1) {e1.printStackTrace();}
					String svar = (controller.getRespons());
					respons.setText("Kontakperson för varje band:\n\n" +svar);
			}
		
		if (e.getSource() == setKontakt) {
			
			  String toDo ="";
			  
			  String kontaktPid = (JOptionPane.showInputDialog("Kontaktpersons id?"));
											
			  String kontaktBid = (JOptionPane.showInputDialog("BandId som kontaktperson är till för?"));

			  
			  
			  toDo = "insert into kontaktperson(pid,bid) values (" + kontaktPid + "," + kontaktBid +");";
			
				if(toDo.length()>1){
				try {				
					controller = new Controller("",toDo);
				} catch (Exception e1) {e1.printStackTrace();}		
				}
				 toDo = "select person.pid, fnamn,enamn,band.bid,bandnamn from ((person join kontaktperson on person.pid=kontaktperson.pid )join band on kontaktperson.bid=band.bid)order by fnamn asc;";
					try {				
						controller = new Controller("AdminContact",toDo);
					} catch (Exception e1) {e1.printStackTrace();}
					String svar = (controller.getRespons());
					respons.setText("Kontakperson för varje band:\n\n" +svar);
			}
		
		if (e.getSource() == deletePlay) {
			
			  String toDo ="";
			  
			  String scene = (JOptionPane.showInputDialog("Scene?"));
											
			  String tid = (JOptionPane.showInputDialog("Tid?"));

			
			  
			  toDo = "delete from spelschema where tid='"+tid+"' and scene='"+scene+"';";
			
				if(toDo.length()>1){
				try {				
					controller = new Controller("",toDo);
				} catch (Exception e1) {e1.printStackTrace();}		
				}
				 toDo = "select bandnamn, scene, tid, sceninfo from (spelschema as s join band as b on s.bid=b.bid);";
				try {				
					controller = new Controller("Adminschema",toDo);
				} catch (Exception e1) {e1.printStackTrace();}
				String svar = (controller.getRespons());
				respons.setText(svar);
			}
		
		
		if (e.getSource() == addNewPlay) {
			
		  String toDo ="";
			
										
		  int BandId = Integer.parseInt(JOptionPane.showInputDialog("Band-Id?"));
				
		  String scene = JOptionPane.showInputDialog("Vilken scene?");

		  String tid = JOptionPane.showInputDialog("Vilken tid?");
		  
		  String extra = JOptionPane.showInputDialog("någon speciell sceninfo?");
		  
		  toDo = "insert into spelschema(bid, scene,tid, sceninfo) values (" + BandId + ",'" + scene+"', '"+tid+"','" +extra+"');";
		
			if(toDo.length()>1){
			try {				
				controller = new Controller("",toDo);
			} catch (Exception e1) {e1.printStackTrace();}		
			}
			 toDo = "select bandnamn, scene, tid, sceninfo from (spelschema as s join band as b on s.bid=b.bid);";
			try {				
				controller = new Controller("Adminschema",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
		
		
		if (e.getSource() == deleteBand) {
			
			String toDo ="";
			String deleteThis ="";
			
			int whatToDelete = Integer.parseInt(JOptionPane.showInputDialog("1.Bandnamn eller 2.Band-Id?"));
					
			if(whatToDelete==1){
				deleteThis = String.valueOf(JOptionPane.showInputDialog("Bandnamn?"));
				toDo  = "delete from band where bandnamn = '" + deleteThis+"'";
			}
			
			if(whatToDelete==2){
				 deleteThis = JOptionPane.showInputDialog("Band-Id?");
				 toDo  = "delete from band where bid = " + deleteThis;
			}
			
		
			if(toDo.length()>1){
			try {				
				controller = new Controller("DeleteBand",toDo);
			} catch (Exception e1) {e1.printStackTrace();}		
			}
			 toDo = "select bandnamn, bid from band;";
			try {				
				controller = new Controller("Adminband",toDo);
			} catch (Exception e1) {e1.printStackTrace();}	
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
		if (e.getSource() == addNewBand) {
			
			String newBandName = String.valueOf(JOptionPane.showInputDialog("Bandnamn?"));
			String newBandId = JOptionPane.showInputDialog("Bandid?");
					
			
			String toDo = "insert into band(bid,bandnamn) values ("+newBandId+",'"+newBandName+"');";
			try {				
				controller = new Controller("addBand",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			 toDo = "select bandnamn, bid from band;";
			try {				
				controller = new Controller("Adminband",toDo);
			} catch (Exception e1) {e1.printStackTrace();}	
			String svar = (controller.getRespons());
			respons.setText(svar);

		}
		
		if (e.getSource() == getContact) {
			
			String toDo = "select person.pid, fnamn,enamn,band.bid,bandnamn from ((person join kontaktperson on person.pid=kontaktperson.pid )join band on kontaktperson.bid=band.bid)order by fnamn asc;";
			try {				
				controller = new Controller("AdminContact",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText("Kontakperson för varje band:\n\n" +svar);
		}	
		
		
		if (e.getSource() == getSpelSchema) {
			
			String toDo = "select bandnamn, scene, tid, sceninfo from (spelschema as s join band as b on s.bid=b.bid);";
			try {				
				controller = new Controller("Adminschema",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			respons.setText(svar);
		}
		
		
		if (e.getSource() == getJobbare) {
			
			String toDo = "select p.pid, fnamn, enamn, personnummer, adress from(person p join jobbare as j on p.pid=j.pid);";
			try {				
				controller = new Controller("jobbare",toDo);
			} catch (Exception e1) {e1.printStackTrace();}
			String svar = (controller.getRespons());
			
			respons.setText(svar);
		}
		
	if (e.getSource() == getBand) {			
		String toDo = "select bandnamn, bid from band;";
		try {				
			controller = new Controller("Adminband", toDo);
		} catch (Exception e1) {e1.printStackTrace();}
		String svar = (controller.getRespons());
		respons.setText(svar);
		}
		
		if (e.getSource() == getAll) {
			System.out.println("test");
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

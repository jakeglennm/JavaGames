package gui;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class CODGUI extends JPanel implements ActionListener{
	private boolean DEBUG = false;
	private int count = 0;

	Random rand = new Random();
	/////////////////////////////////////////////
	//Arrays of all COD weapons and accessories//
	/////////////////////////////////////////////
	public String Primary()
	{
		String[] primes = {"M4A1","AX-50","AK-47","Kilo 141","Ram-7","725","MP7","MP5","PKM","AUG","FAL","FR 5.56","Oden","M13","FN Scar 17","Grau 5.56","P90","Uzi","PP19 Bizon","Striker 45","Model 680","R9-0 Shotgun","Origin 12 Shotgun","SA87","MG34","Holger-26","EBR-14","MK2 Carbine","Kar98K","Dragunov","HDR"};
		int num = rand.nextInt(primes.length);
		return primes[num];
	}
	
	public String Secondary()
	{
		String[] seconds = {"X16","1911",".357",".50 GS","RPG-7","Combat Knife","M19","PILA","Strela-P"};
		int num = rand.nextInt(seconds.length);
		return seconds[num];
	}
	
	public String Lethal()
	{
		String[] lethals = {"Frag","Semtex","Molotov","Throwing Knife","Claymore"};
		int num = rand.nextInt(lethals.length);
		return lethals[num];
	}
	
	public String Tactical()
	{
		String[] tacts = {"Flash Grenade","Stun Grenade","Smoke Grenade","Stim","Decoy Grenade"};
		int num = rand.nextInt(tacts.length);
		return tacts[num];
	}
	public String Perk1()
	{
		String[] perks = {"Double Time","Scavenger","E.O.D.","Tracker","Tune Up"};
		int num = rand.nextInt(perks.length);
		return perks[num];
	}
	public String Perk2()
	{
		String[] perks = {"Ghost","Hardline","Kill Chain","Overkill","Restock"};
		int num = rand.nextInt(perks.length);
		return perks[num];
	}
	public String Perk3()
	{
		String[] perks = {"Amped","Battle Hardened","Cold-Blooded","High Alert","Shrapnel","Spotter"};
		int num = rand.nextInt(perks.length);
		return perks[num];
	}
	/////////////////////////////////////////////
	//Arrays of all COD weapons and accessories//
	/////////////////////////////////////////////
	
	
	public CODGUI()
	{
		super(new GridLayout(1,0));
		 
        String[] columnNames = {"Primary", "Secondary", "Lethal", "Tactical","Perk 1","Perk 2","Perk 3"};
 
        Object[][] data = {
        {Primary(), Secondary(), Lethal(), Tactical(),Perk1(),Perk2(),Perk3()}
        };
 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700, 70));
        table.setFillsViewportHeight(true);
 
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
        
        JFrame frame = new JFrame();
		//////////////////////////
        //create button//
        //////////////////////////
        JLabel label = new JLabel("Call of Duty: MW Class Generator");
        JButton button = new JButton("Generate Class");
		button.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("COD GUI");
		frame.pack();
		frame.setVisible(true);
	}
	
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
	
	/**
     * Create the GUI and show it.
     */
	 private static void createAndShowTable() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Class Setup");
	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Create and set up the content pane.
	        CODGUI newContentPane = new CODGUI();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	
	public static void main(String[] args)
	{
		new CODGUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		createAndShowTable();
		
	}

	
}

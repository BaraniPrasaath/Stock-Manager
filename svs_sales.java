import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class svs_sales extends JFrame implements ActionListener {
    svs_dataStore stkStore = new svs_dataStore();
    svs_dataRetrive stkRetv = new svs_dataRetrive();

int a=0;
    String work = "sales";
    LinkedList<String> code = new LinkedList<>();
    LinkedList<String> item = new LinkedList<>();
    LinkedList<Integer> qty = new LinkedList<>();

    JTextField[] tf = new JTextField[60];
    JComboBox<String>[] itemCombo = new JComboBox[15]; // Combo box for auto-suggest items
    JButton b1, b2;
    JLabel la1, la2, la3, la4, la5, la6, la7, la8, la9;

    BorderLayout bl = new BorderLayout();
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();

    svs_home obj;
//LinkedList<String> availableItems = new LinkedList<>();

    String[] availableItems; // Store retrieved stock items

    svs_sales(svs_home obj1) {
        obj = obj1;
        setLayout(bl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1.setLayout(gbl);
        p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Retrieve available stock items for suggestions
        availableItems = stkRetv.retriveStock(0,901,901).toArray(new String[0]);

        // Initialize text fields and combo boxes
        for (int i = 0; i < 15; i++) {
            tf[i] = new JTextField(4); // Serial Number
            tf[i].setText(Integer.toString(i + 1));
            tf[i].setEnabled(false);
        }
        for (int i = 15; i < 30; i++) {
            tf[i] = new JTextField(4); // Code
        }
        for (int i = 30; i < 45; i++) {
            itemCombo[i - 30] = new JComboBox<>(availableItems);
            itemCombo[i - 30].setEditable(true);
            addAutoSuggest(itemCombo[i - 30]);
        }
        for (int i = 45; i < 60; i++) {
            tf[i] = new JTextField(4); // Quantity
        }

        la1 = new JLabel("Purchase Entry");
        la6 = new JLabel("Sno");
        la7 = new JLabel("Code");
        la8 = new JLabel("Item");
        la9 = new JLabel("Qty");

        b1 = new JButton("Save");
        b2 = new JButton("Quit");

        p2.add(b1);
        p3.add(b2);

        gbc.fill = GridBagConstraints.BOTH;

        // Adding fields to GridBagLayout
        arrangements(la6, 0, 0, 1, 1);
        for (int i = 0; i < 15; i++) arrangements(tf[i], 0, i + 1, 1, 1);

        arrangements(la7, 1, 0, 1, 1);
        for (int i = 15; i < 30; i++) arrangements(tf[i], 1, i - 14, 1, 1);

        arrangements(la8, 2, 0, 1, 1);
        for (int i = 0; i < 15; i++) arrangements(itemCombo[i], 2, i + 1, 1, 1);

        arrangements(la9, 3, 0, 1, 1);
        for (int i = 45; i < 60; i++) arrangements(tf[i], 3, i - 44, 1, 1);

        arrangements(p2, 2, 16, 1, 1);
        arrangements(p3, 3, 16, 1, 1);

        p4.add(la1);
        add(p4, BorderLayout.NORTH);
        add(p1);

        setSize(850, 600);
        setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    private void addAutoSuggest(JComboBox<String> comboBox) {
        JTextField textField = (JTextField) comboBox.getEditor().getEditorComponent();
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
		a = e.getKeyCode();
		if((36<a) && (a<41))
		System.out.println("hii");
		else
                filterSuggestions(comboBox, textField.getText());
            }
        });
    }

   private void filterSuggestions(JComboBox<String> comboBox, String input) {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    
    // Preserve user input and filter matches
    for (String s : availableItems) {
        if (s.toLowerCase().startsWith(input.toLowerCase())) {
            model.addElement(s);
        }
    }
    
    // Update combo box model and preserve text
    comboBox.setModel(model);
    comboBox.setSelectedItem(input);  // Keep user's current input
    
    // Show dropdown only if there are matching results
    if (model.getSize() > 0) {
        comboBox.setPopupVisible(true);
    } else {
        comboBox.setPopupVisible(false);
    }
}

    public void arrangements(Component c, int col, int row, int ht, int wd) {
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.gridheight = ht;
        gbc.gridwidth = wd;
        gbl.setConstraints(c, gbc);
        p1.add(c);
    }


public void actionPerformed(ActionEvent ae)
{
int j=0;
	if(ae.getSource()==b1)
	{
		for(int i=15;i<30;i++)
			code.add(tf[i].getText());

		for(int i=30;i<45;i++)
			item.add((String) itemCombo[i - 30].getSelectedItem());
		System.out.println(item);

String temp_qty=""; 
		for(int i=45;i<60;i++)
		{
			temp_qty = tf[i].getText();
			if(!temp_qty.isEmpty())
				qty.add(Integer.parseInt(temp_qty));
		}
int temp_qty2=0;
	
/*	for(j=0;j<15;j++)
	{		
		if((temp_code[j].equals(code.get(j))) && (temp_item[j].equals(item.get(j))))
			System.out.println("ok");
		else
			System.out.println("not ok");
	}
*/	
		//qty2 = stkRetv.retriveQty(item);	
	
int i=0;
	for(int qt : qty)
	{
		int quantity = stkRetv.retriveQty(item.get(i));
		quantity = quantity - qt;
		qty.set(i,quantity);
		stkStore.updateStock(code,item.get(i),qty.get(i));
		i++;
	}


/*	for(int qt2 : qty2)
	{
		temp_qty2 = qt2;	
		temp_qty2 = temp_qty2 + qty.get(i);
		qty.set(i,temp_qty2);
		i++;
	}
	*/

		//stkStore.updateStock(code,item,qty);
		JOptionPane.showMessageDialog(null,"Your Stored Stock");

	}
	if(ae.getSource()==b2)
		dispose();
		
		
}

}
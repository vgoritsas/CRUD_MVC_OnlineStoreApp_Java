/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestoreapp.view;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.System.exit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import onlinestoreapp.model.Model;

/**
 *
 * @author Evanggelos
 */
public class View {

    // create variable model
    private Model model;

    /**
     * GUI *
     */
    private JFrame F_general, F_Add; // create variables for JFrame
    private JButton btn_add, btn_edit, btn_delete, btn_save, btn_exit, btn_clear, btn_search, btn_s_clear; // create variables for JButton
    private JTextField JT_pname, JT_psku, JT_pprice, JT_psize, JT_id, JT_to, JT_from;
    private JLabel JL_pname, JL_psku, JL_pprice, JL_psize ,JL_from, JL_To; // create variables for JLabel
    private JPanel leftPanel, panelSearch, addPanel, rightPanel; // create variables for JPanel
    private JTable table; // create variable for JTable
    private DefaultTableModel TableModel;
    private JComboBox ComboSearch; // create variable for combobox search

    /**
     * Contructor with input Model class
     *
     * @param model
     */
    public View(Model model) {
        // initialize the model variable  from input where give from constructor
        this.model = model;

    }

    /*
        this method display the gui
     */
    public void generalView() {

        F_general = new JFrame(); // create th frame
        F_general.setTitle("TV Store - developed by Evanggelos L. Goritsas"); // set a title in my frame 
        F_general.setDefaultCloseOperation(F_general.EXIT_ON_CLOSE); // close the frame
        F_general.setSize(new Dimension(940, 580)); // size of the frame
        F_general.setLocation(new Point(300, 150)); // create position of the frame.
        F_general.setLayout(null); // set layout

        leftPanel = new JPanel(); // create panel left 
        leftPanel.setBackground(Color.WHITE); // set background
        leftPanel.setBorder(BorderFactory.createTitledBorder("General")); // create border 
        leftPanel.setLocation(new Point(0, 0)); //  create position 
        leftPanel.setSize(new Dimension(450, 550)); // create width and height from the panel
        leftPanel.setLayout(null); // set layout

        JT_id = new JTextField(20); // create id jtextfield
        JT_id.setBounds(6, 40, 40, 25); // position 
        JT_id.setBorder(null); // border

        JT_id.setEnabled(false); // disable the jtextfield.

        JL_pname = new JLabel("NAME"); // create label name
        JL_pname.setBounds(6, 70, 100, 25); // create position  name
        JL_psku = new JLabel("SKU"); // create label sku
        JL_psku.setBounds(6, 100, 100, 25); // position sku
        JL_pprice = new JLabel("PRICE"); // create label price
        JL_pprice.setBounds(6, 130, 100, 25); // position price
        JL_psize = new JLabel("SIZE"); // create label size
        JL_psize.setBounds(6, 160, 100, 25); // position size
        

        btn_add = new JButton("ADD"); // create button add
        btn_add.setBounds(7, 200, 63, 30); // create position add
        btn_edit = new JButton("EDIT"); // create button edit
        btn_edit.setBounds(72, 200, 63, 30); // create position edit
        btn_delete = new JButton("DELETE"); // creat delete button
        btn_delete.setBounds(137, 200, 90, 30); // position delete button
        btn_clear = new JButton("CLEAR"); // create clear button
        btn_clear.setBounds(229, 200, 90, 30); // position clear button
        btn_exit = new JButton("EXIT"); // create button exit 
        btn_exit.setBounds(321, 200, 63, 30); // position button exit

        JT_pname = new JTextField(20); // create name jtextfield
        JT_pname.setBounds(110, 70, 232, 25); //position name jtextfield
        JT_psku = new JTextField(20); // create sku jtextfield
        JT_psku.setBounds(110, 100, 232, 25); //position sku jtextfield
        JT_pprice = new JTextField(20); //create price jtextfield
        JT_pprice.setBounds(110, 130, 232, 25); //position jtextfield price
        JT_psize = new JTextField(20); //create size jtextfield
        JT_psize.setBounds(110, 160, 232, 25); // position  sisze jtextfield 

        leftPanel.add(btn_clear); // panel left add button clear.
        leftPanel.add(btn_edit); // panel left add button edit.
        leftPanel.add(btn_exit); // panel left add button exit.
        leftPanel.add(btn_delete); // panel left add button delete.
        leftPanel.add(btn_add); // panel left add button add.
        leftPanel.add(JT_id);  // panel left add jtexfield id.
        leftPanel.add(JL_pname); // panel left add jlabel name.
        leftPanel.add(JL_psku); // panel left add jlabel sku.
        leftPanel.add(JL_pprice); // panel left add jlabel price.
        leftPanel.add(JL_psize); // panel left add jlabel size.
        leftPanel.add(JT_pname);  // panel left add jtexfield name.
        leftPanel.add(JT_psku); // panel left add jtexfield sku.
        leftPanel.add(JT_pprice); // panel left add jtexfield price.
        leftPanel.add(JT_psize); // panel left add jtexfield size.

        panelSearch = new JPanel(); // inside leftpanel add new searchpanel 
        panelSearch.setBorder(BorderFactory.createTitledBorder("αναζήτηση")); // border
        panelSearch.setLocation(new Point(12, 240)); // position 
        panelSearch.setSize(new Dimension(420, 250)); // size
        panelSearch.setLayout(null);
        JT_from = new JTextField(20); // create label from
        JT_from.setBounds(60, 80, 302, 30); // position from - label
        JL_from = new JLabel("From");
         JL_from.setBounds(10, 80, 302, 30);
       JL_To = new JLabel("To");
       JL_To.setBounds(10, 120, 302, 30);
        JT_to = new JTextField(10);  // create jtextfield to
        JT_to.setBounds(60, 120, 302, 30); // position to jtextfield

        String[] item = {"Price", "Size"}; // combobox item in array
        ComboSearch = new JComboBox(item); // create combobox with array  
        ComboSearch.setBounds(10, 40, 200, 30); // position combobox
        ComboSearch.setSelectedIndex(1); // select default 

        btn_search = new JButton("SEARCH"); // create button search
        btn_s_clear = new JButton("CLEAR"); // create button clear
        btn_s_clear.setBounds(162, 160, 150, 30); // button clear position 
        btn_search.setBounds(10, 160, 150, 30); // button search position 
        panelSearch.add(JT_from); // panelsearch add jtextfield from
        panelSearch.add(JT_to);  // panelsearch add jtextfield from
        panelSearch.add(JL_from); // panelsearch add jtextfield from
        panelSearch.add(JL_To);
        panelSearch.add(ComboSearch); //   panelsearch add combobox
        panelSearch.add(btn_search); // add button search
        panelSearch.add(btn_s_clear); // add button clear

        leftPanel.add(panelSearch); // left panel add in panelseach  - 
        rightPanel = new JPanel(); // right panel
        rightPanel.setBackground(Color.WHITE); // background 
        rightPanel.setBorder(BorderFactory.createTitledBorder("Products")); // title 
        rightPanel.setLocation(new Point(450, 0)); // [position 
        rightPanel.setSize(new Dimension(474, 550)); // size

        table = new JTable(); // create table

        table.setRowHeight(26); // row height of the table
        view(); // run app and display data using method view();

        table.addMouseListener(new MouseListener() {
            @Override
            // when  clik row from the table
            public void mouseClicked(MouseEvent me) {
                // click table
                clickTable();
            }

            // created by themselves
            @Override
            public void mousePressed(MouseEvent me) {

            }

            //created by themselves
            @Override
            public void mouseReleased(MouseEvent me) {

            }

            //created by themselves
            @Override
            public void mouseEntered(MouseEvent me) {

            }

            //created by themselves
            @Override
            public void mouseExited(MouseEvent me) {

            }

        });

        rightPanel.add(new JScrollPane(table)); // scrollpanel table
        F_general.add(leftPanel); // in general frame add the left panel
        F_general.add(rightPanel); // in general frame add the right panel

        // exit button 
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //exit program
                exit();
            }

        });
        // clear button
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // clear the jtextfield 
                clear();
            }
        });

        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                search();

            }
        });
        // button clear from search box
        btn_s_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // clear search jtextfield
                clearSearchInputs();
                // refresh table
                view();

            }
        });
        // edit button
        btn_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // select the row
                int click = table.getSelectedRow();
                // if users not select any row from table display message.
                if (click == -1) {
                    JOptionPane.showMessageDialog(F_general, "Please select from the right table any row");
                } else {  // else call the method edit for edit  row 
                    edit();
                    // after edit row refresh table.
                    view();
                }
            }
        });

        // delete button
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // select the row
                int click = table.getSelectedRow();
                // if users not select any row from table display message.
                if (click == -1) {
                    JOptionPane.showMessageDialog(F_general, "Please select from the right table any row");
                } else { // else call the method delete for delete row 

                    delete();
                    // refresh table
                    view();
                    // clear the jtextfield
                    clear();
                }
            }
        });

        // add button
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                // save data when click add button.
                // call method 
                save();
                // after insert refresh table 
                // call view method 
                view();

            }

        });

        F_general.setResizable(false);
        F_general.setVisible(true); // enable the frame 
    }

    /*
    method view display all the data from database 
     */
    public void view() {
        /*
        at this array i will create the colums names
         */
        String[] column_names = {"ID", "NAME ", "SKU ", "PRICE", "SIZE"};
        // create object DefaultTableModel with  columns for input
        TableModel = new DefaultTableModel(column_names, 0);
        // Table set the model 
        table.setModel(TableModel);
        try {
            // get from model the method data() ;
            ResultSet res = model.data();
            /**
             * while loop to fetch data from database.
             */
            while (res.next()) {

                String id = res.getString("Id"); // get id 
                String pn = res.getString("Name"); // get name
                String psku = res.getString("Sku"); // get sku
                String pp = res.getString("Price"); // get price
                String ps = res.getString("Size"); // get size
                // create array to save variables
                String[] data = {id, pn, psku, pp, ps};

                TableModel.addRow(data);// add this array in TableModel variable where this keep DefaultTableModel(Column_names)
            }

        } catch (SQLException ex) {  // check if try has errors

            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * this method clear JTextFields
     */
    public void clear() {
        JT_id.setText("");
        JT_pname.setText("");
        JT_psku.setText("");
        JT_pprice.setText("");
        JT_psize.setText("");
    }

    /*
    this method clear search JTextfields
     */
    public void clearSearchInputs() {
        JT_from.setText("");
        JT_to.setText("");
    }

    /*
    * this method is for to clicktable
     */
    public void clickTable() {
        // click variable get from table a selected row.
        int click = table.getSelectedRow();
        /**
         * gets the value from table after we click a row. and we save into new
         * variables
         *
         */
        String id = TableModel.getValueAt(click, 0).toString();
        String pname = TableModel.getValueAt(click, 1).toString();
        String psku = TableModel.getValueAt(click, 2).toString();
        String pprice = TableModel.getValueAt(click, 3).toString();
        String psize = TableModel.getValueAt(click, 4).toString();

        /**
         * when click a row display value into JTEXTFIELD where we have create
         */
        JT_id.setText(id);
        JT_pname.setText(pname);
        JT_psku.setText(psku);
        JT_pprice.setText(pprice);
        JT_psize.setText(psize);
    }

    /**
     * THIS METHOD INSERT DATA IN DATABASE.
     *
     * @throws SQLException
     */
    public void save() {

        try {
            
            if (JT_pname.getText().equals("") || JT_psku.getText().equals("") || JT_pprice.getText().trim().length() == 0 || JT_psize.getText().trim().length()==0) {
                JOptionPane.showMessageDialog(F_Add, "Please fill all the fields");
                return;
            }
            
            //  
            String ProductName = JT_pname.getText();
            String ProductSKU = JT_psku.getText();
            
            
            double ProductPrice = Double.parseDouble(JT_pprice.getText());
            double ProductSize = Double.parseDouble(JT_psize.getText());
            
            ResultSet row = model.checkSKU(ProductSKU);

            

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * edit data.
     */
    public void edit() {
        // get id from jtextfield
        int pid = Integer.parseInt(JT_id.getText());
        //ask if you want to edit
        int question = JOptionPane.showConfirmDialog(null, "Do you want to update this product with id : " + pid + "", "Message", JOptionPane.YES_NO_OPTION);
        /**
         * gets values name , sku ,price ,size from jtextfield
         */
        String pname = JT_pname.getText();
        String psku = JT_psku.getText();
        double pprice = Double.parseDouble(JT_pprice.getText());
        double psize = Double.parseDouble(JT_psize.getText());

        try {
            // check if question variable is equal with 0 
            if (question == 0) {
                // get from the model methods sets with considering inputs 
                // eg. model.setID(Integer.parseInt(JT_id.getText()))
                model.setID(pid);
                model.setProductName(pname);
                model.setProductSku(psku);
                model.setProductPrice(pprice);
                model.setProductSize(psize);
                // if edit method from model is greater from 0 then display message to dialog 
                if (model.edit() > 0) {
                    JOptionPane.showMessageDialog(F_general, "The Recording with ID : " + pid + " updated succesfully.");
                    // call method clear - clear the jtexfield
                    clear();
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * η function αυτή διαγράφη τα δεδομένα
     */
    public void delete() {

        int pid = Integer.parseInt(JT_id.getText());
        int a = JOptionPane.showConfirmDialog(null, "Do you want to delete this product with ID : " + pid + "....", "Message", JOptionPane.YES_NO_OPTION);
        try {

            if (a == 0) {

                // set id
                model.setID(pid);
                model.delete();

                JOptionPane.showMessageDialog(F_general, "The ID " + pid + " deleted succesfully");

            }

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * exit the program
     *
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * search
     */
    public void search() {
        try {
            if(JT_from.getText().isEmpty() || JT_to.getText().isEmpty()){
                JOptionPane.showMessageDialog(F_Add, "Please fill all the fields");
                return;
            }
            // 
            double from = Double.parseDouble(JT_from.getText()); // the users can only write double
            double to = Double.parseDouble(JT_to.getText()); // the users can only write double
            String tp = ComboSearch.getSelectedItem().toString(); // select e.g price, size
            /*
             check if tp variable is equal with price String then enters in if and
             search by price else if users select size do search by size
             */
            if (tp == "Price") {

                // from class model get the method searchByPrice with the inputs into double.ResultSet retrieving the result of queries
                ResultSet rs = model.searchByPrice(from, to);
                // search
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } else {
                // from class model get the method searchBySize with the inputs into double.ResultSet retrieving the result of queries
                ResultSet rs = model.searchBySize(from, to);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

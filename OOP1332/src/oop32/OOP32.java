package oop32;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OOP32 extends JFrame implements vat{
    private ImageIcon image;
    private ImageIcon background;
    private Container c;
    private JLabel priceLabel,nameLabel,amountLabel,categoryLabel,v;
    private Font font;
    private JTextField pT, nT,aT;
    public String name;
    public double price;
    public int quantity;
    public JButton clear,addProduct,calculateTotal,clearAll;
    public JComboBox combo;
    public String category[]= { "Grocery","Fruits","Electronics","Sports"};
    public Category Grocery,Fruits,Electronics,Sports;
    public Product product;
    public String cat;
    public Category cate;
    public Store store;
    
    public OOP32()
            {
                initComponents();
            }
    public final void initComponents()
    {
        store = new Store();
        
        background= new ImageIcon(getClass().getResource("B.jpg"));
        this.setContentPane(new JLabel(background));
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);
        
        image= new ImageIcon(getClass().getResource("download.png"));
        this.setIconImage(image.getImage());
        
        
        
        Color transparent = new Color(((float) 1.0), ((float) 1.0), ((float)0), ((float) 0.5));
//        transparent=Color.decode("#FFFF00");
        font=new Font("Arial",Font.BOLD,18);
        
        priceLabel= new JLabel();
        priceLabel.setText("Price: ");
        priceLabel.setBounds(50, 80, 150,50);
        priceLabel.setFont(font);
        priceLabel.setForeground(Color.RED);
        priceLabel.setToolTipText("Enter price of the prodect");
        priceLabel.setOpaque(true);
        priceLabel.setBackground(transparent);
        c.add(priceLabel);
        
        nameLabel = new JLabel();
        nameLabel.setText("Name: ");
        nameLabel.setBounds(50,20,150,50);
        nameLabel.setFont(font);
        nameLabel.setForeground(Color.RED);
        nameLabel.setToolTipText("Enter name of the product");
        nameLabel.setOpaque(true);
        nameLabel.setBackground(transparent);
        
        
        
        c.add(nameLabel);
        
        amountLabel = new JLabel();
        amountLabel.setText("Quantity");
        amountLabel.setBounds(50,150,150,50);
        amountLabel.setFont(font);
        amountLabel.setForeground(Color.RED);
        amountLabel.setToolTipText("Enter number of products");
        amountLabel.setOpaque(true);
        amountLabel.setBackground(transparent);
        c.add(amountLabel);
        
        categoryLabel=new JLabel();
        categoryLabel.setText("Category");
        categoryLabel.setBounds(50,220,150,50);
        categoryLabel.setFont(font);
        categoryLabel.setForeground(Color.RED);
        categoryLabel.setToolTipText("Enter category: ");
        categoryLabel.setOpaque(true);
        categoryLabel.setBackground(transparent);
        c.add(categoryLabel);
        
        nT= new JTextField();
        nT.setBounds(200,20,150,50);
        nT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                String s=nT.getText();
                name=s;
                System.out.println("Name is set as: "+name);
            }
        });
        c.add(nT);
        
        pT= new JTextField();
        pT.setBounds(200,80,150,50);
        pT.addActionListener((ActionEvent ae) ->
        {
            try{
                String s=pT.getText();
                price=Double.parseDouble(s);
                System.out.println("Price is set as: "+price);
            }catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(pT,"Please input price in correct format.");
            }
            
        });
        c.add(pT);
        
        aT= new JTextField();
        aT.setBounds(200,150,150,50);
        aT.addActionListener((ActionEvent ae)->
        {
            try{
                String s = aT.getText();
                quantity=Integer.parseInt(s);
                System.out.println("Quantity is set as : "+quantity);
            }catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(pT,"Please input amount in correct format.");
            }
        });
        c.add(aT);
        
        clear=new JButton("Clear");
        clear.setBounds(10,350,150,50);
        clear.addActionListener((ActionEvent ae)->
        {
            aT.setText("");
            nT.setText("");
            pT.setText("");
            v.setVisible(false);
        });
        c.add(clear);
        
        
        v=new JLabel();
        //v.setBounds(165,400,200,50);
        v.setBounds(100,300, 300, 50);
        v.setText("Total vat: ");
        v.setFont(font);
        v.setForeground(Color.RED);
        v.setOpaque(true);
//        v.setBackground(transparent);
        v.setVisible(false);
        c.add(v);
        
        
        calculateTotal=new JButton();
        calculateTotal.setText("Calculate total");
        calculateTotal.setBounds(320,350,150,50);
        calculateTotal.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                v.setText("Total vat: "+store.getVat());
                //System.out.println("Total vat is:" + store.getVat());
                v.setVisible(true);
            }
            
        });
        c.add(calculateTotal);
        
        
        Grocery = new Category(GROCERY,category[0]);
        Fruits= new Category(FRUITS,category[1]);
        Electronics = new Category(ELECTRONICS,category[2]);
        Sports= new Category(SPORTS,category[3]);
        
        combo= new JComboBox(category);
        combo.setBounds(200,220,150,50);
        combo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                String s=combo.getSelectedItem().toString();
                switch(s)
                {
                    case "Grocery":cate=Grocery;break;
                    case "Fruits":cate=Fruits;break;
                    case "Electronics":cate=Electronics;break;
                    case "Sports":cate=Sports;break;
                }
                System.out.println(s);
                
            }
            
        });
        c.add(combo);
        
        
        
        addProduct=new JButton();
        addProduct.setText("Add product");
        addProduct.setBounds(165,350,150,50);
        addProduct.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                product =new Product(name,price,quantity,cate);
                store.addProduct(product);
            }
            
        });
        c.add(addProduct);
        
        clearAll= new JButton();
        clearAll.setBounds(10, 400, 150, 50);
        clearAll.setText("Clear All");
        clearAll.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                clearAll();
            }
            
        });
        c.add(clearAll);
    }
    
    public void clearAll()
    {
        aT.setText("");
        nT.setText("");
        pT.setText("");
        store=new Store();
        v.setText("Total vat: "+store.getVat());
        v.setVisible(false);
    }
    
    
    
    public static void main(String[] args)
    {
        OOP32 obj = new OOP32();
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setBounds(200,200,500,500);
        obj.setResizable(false);
        obj.setTitle("Vat calculation");
        
        
        
        
        
        
    }
    
}




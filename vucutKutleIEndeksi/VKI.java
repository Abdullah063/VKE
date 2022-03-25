package vucutKutleIEndeksi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import odev1.txtPane;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class VKI extends JFrame {

	private JPanel contentPane;
	private JTextField txtWeigth;
	private JTextField txtLength;
	private ButtonGroup cinsiyet;
	private JLabel lblProfil;
	private double length,weigth;
	private double vke;
	private String str;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VKI frame = new VKI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static boolean isInteger(String str) 
	{
		 int count = 0 ;
	     for (int i = 0; i < str.length(); i++) 
		 {
			 int ch = (int)str.charAt(i);
			 if (ch>47&&ch<58) 
			 {
			     count++;
			 }
	 
	     }
		 if (count==str.length()) 
		 {
			return true;
		 }
		 if (str.equals(null)) 
		 {
			return false;
		 }
		 return false;
		  
		 
    } 
    public boolean inputControl() 
    {
    	 length = Double.parseDouble(txtLength.getText());
	     weigth =  Double.parseDouble(txtWeigth.getText());

		if ((length<0)||(weigth<0)) 
	    {
			 return false;
		}

    	return true;
    }
    public void calculate() 
    {
    	 length = Double.parseDouble(txtLength.getText());
		 weigth =  Double.parseDouble(txtWeigth.getText());
		 vke = weigth/((length*length)/10000);
		 String Svki =  new DecimalFormat("##.##").format(vke).replace(",",".");
		 vke = Double.parseDouble(Svki);
    }
    public void print() 
    {
    	lblProfil.setText("<html>Vücut Kitle Endeksiniz (BMI) : " +vke+"<br/>Sonuç :"
    			          +" "+str+" <br/>Ýdeal Kilonuz : "+ normalWeigth() +" </html>");
    }
    public void vkeCalculate() 
    {
    	calculate();
    	if (18.5>vke)
    	{
    		str = "Zayýf";
		}
    	else if (18.5<=vke && 24.9>vke)
    	{
    		str = "Normal";
		}
    	else if (25<=vke && 29.9>vke) 
    	{
    		str = "Hafif þiþman";
		}
    	else if (30<=vke && 34.9>vke) 
    	{
    		str = "Þiþman";
		}
    	else if (35<=vke && 44.9>vke) 
		{
    		str = "Saðlýk açýsýndan önemli";
		}
    	else if (45<=vke && 99.9>vke) 
		{
    		str = "Aþýrý þiþman";
		}
    	else
		{
    		str = "Morbid (ölümcül) þiþman";
		}
    	print();
    	
    }
    // kadýn ve  erkek için idaal kiloyu hesaplamak için
    public int normalWeigth() 
    {
    	int normal;
    	switch (cinsiyet.getSelection().getActionCommand())
    	{
		     case "1":   normal= (int)length-102;
		          break;
		     case "2":   normal= (int)length-107;  
		          break;
		     default:    normal= (int)length-102;
			      break;      
		}
		return normal;
    }
    public VKI() 
    {
    	setResizable(false);
		setTitle("V\u00FCcut Kitle Endeksi Hesaplama");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cinsiyetiniz :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 31, 88, 34);
		contentPane.add(lblNewLabel);
		
		JRadioButton rBtnKadin = new JRadioButton("Kad\u0131n");
		rBtnKadin.setSelected(true);
		rBtnKadin.setBounds(124, 40, 64, 21);
		rBtnKadin.setActionCommand("1");
		contentPane.add(rBtnKadin);
		
		JRadioButton rBtnErkek = new JRadioButton("Erkek");
		rBtnErkek.setBounds(190, 40, 74, 21);
		rBtnErkek.setActionCommand("2");
		contentPane.add(rBtnErkek);
		
	    cinsiyet = new ButtonGroup();
		cinsiyet.add(rBtnErkek);
		cinsiyet.add(rBtnKadin);
		
		JLabel lblNewLabel_1 = new JLabel("Kilonuz :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(39, 87, 53, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Boyunuz :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(28, 124, 64, 13);
		contentPane.add(lblNewLabel_2);
		
		txtWeigth = new JTextField();
		txtWeigth.setBounds(92, 92, 53, 19);
		contentPane.add(txtWeigth);
		txtWeigth.setColumns(10);
		
		txtLength = new JTextField();
		txtLength.setBounds(92, 122, 53, 19);
		contentPane.add(txtLength);
		txtLength.setColumns(10);
		
		JButton btnCalculate = new JButton("Hesapla");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(txtWeigth.getText().isEmpty()) && !(txtLength.getText().isEmpty()))
				{
					if ((isInteger(txtWeigth.getText())  &&  isInteger(txtLength.getText())) && inputControl())
					{
						vkeCalculate();	
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Hatalý kilo veye boy deðeri lütfen tekrar kontrol ediniz!!");		
					}
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Deðerler boþ girilemez !!");		
				}
			}
		});
		btnCalculate.setForeground(Color.BLACK);
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalculate.setBounds(92, 155, 84, 27);
		contentPane.add(btnCalculate);
		
		JButton btnClear = new JButton("Temizle");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblProfil.setText(null);
			}
		});
		btnClear.setBounds(257, 155, 85, 27);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel_3 = new JLabel("cm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(155, 121, 27, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("kg");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(155, 88, 27, 24);
		contentPane.add(lblNewLabel_4);
		
		lblProfil = new JLabel("");
		lblProfil.setBounds(206, 87, 220, 63);
		contentPane.add(lblProfil);
	}
}

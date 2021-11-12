import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
class ClientApplicationForServerProject{
	JFrame f;
	JPanel p,panel;
	JLabel background,fname,mname,lname,wts_no,mob_no,label;
	JLabel heading,school,clg,branch,sem,stu_class;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JRadioButton b1,b2;
	JTextArea ta1,ta2;
	JButton submit;
	JScrollPane scroll;
	ClientApplicationForServerProject(){
		f = new JFrame("Registration Form");
		Font font = new Font("Californian FB",Font.BOLD,20);
		Border border = BorderFactory.createLineBorder(Color.BLACK);

		//header
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0,0,0,60));
		panel.setBounds(0,0,1000,70);
		heading = new JLabel("Enquiry Form");
		heading.setBounds(0,0,1000,70);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Times New Roman",Font.BOLD,28));
		heading.setHorizontalAlignment(JLabel.CENTER);
		panel.add(heading);

		//form panel
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(0,0,0,60));
		p.setBounds(20,100,880,210);
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		fname = new JLabel("*First Name");
		fname.setBounds(10,25,110,20);
		fname.setFont(font);
		fname.setForeground(Color.WHITE);
		p.add(fname);
		t1 = new JTextField();
		t1.setBounds(130,20,150,30);
		t1.setBorder(border);
		t1.setFont(font);
		p.add(t1);

		mname = new JLabel("Middle Name");
		mname.setBounds(300,25,120,20);
		mname.setFont(font);
		mname.setForeground(Color.WHITE);
		p.add(mname);
		t2 = new JTextField();
		t2.setBounds(430,20,150,30);
		t2.setBorder(border);
		t2.setFont(font);
		p.add(t2);

		lname = new JLabel("*Last Name");
		lname.setBounds(600,25,110,20);
		lname.setFont(font);
		lname.setForeground(Color.WHITE);
		p.add(lname);
		t3 = new JTextField();
		t3.setBounds(720,20,150,30);
		t3.setBorder(border);
		t3.setFont(font);
		p.add(t3);

		wts_no = new JLabel("*Whatsapp Number");
		wts_no.setBounds(30,95,180,20);
		wts_no.setFont(font);
		wts_no.setForeground(Color.WHITE);
		p.add(wts_no);
		t4 = new JTextField();
		t4.setBounds(220,90,150,30);
		t4.setBorder(border);
		t4.setFont(font);
		p.add(t4);

		mob_no = new JLabel("Mobile Number");
		mob_no.setBounds(420,95,150,20);
		mob_no.setFont(font);
		mob_no.setForeground(Color.WHITE);
		p.add(mob_no);
		t5 = new JTextField();
		t5.setBounds(580,90,150,30);
		t5.setBorder(border);
		t5.setFont(font);
		p.add(t5);

		label = new JLabel("Student of : ");
		label.setBounds(10,160,120,20);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		p.add(label);

		b1 = new JRadioButton("College");
		b1.setBounds(150,160,100,23);
		b1.setFont(font);
		b1.setBackground(Color.WHITE);
		b2 = new JRadioButton("School");
		b2.setBounds(280,160,100,23);
		b2.setFont(font);
		b2.setBackground(Color.WHITE);
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		p.add(b1);
		p.add(b2);

		//institute information
		school = new JLabel("Name of School");
		school.setBounds(30,350,160,20);
		school.setFont(font);
		school.setForeground(Color.WHITE);
		ta1 = new JTextArea();
		ta1.setBounds(220,340,600,50);
		ta1.setFont(font);
		ta1.setWrapStyleWord(true);
		ta1.setLineWrap(true);
		ta1.setBorder(border);

		clg = new JLabel("Name of College");
		clg.setBounds(30,350,160,20);
		clg.setFont(font);
		clg.setForeground(Color.WHITE);
		ta2 = new JTextArea();
		ta2.setBounds(220,340,600,50);
		ta2.setFont(font);
		ta2.setWrapStyleWord(true);
		ta2.setLineWrap(true);
		ta2.setBorder(border);

		branch = new JLabel("Branch");
		branch.setBounds(30,430,80,20);
		branch.setFont(font);
		branch.setForeground(Color.WHITE);
		t6 = new JTextField();
		t6.setBounds(130,430,100,25);
		t6.setFont(font);
		t6.setBorder(border);

		sem = new JLabel("Semester");
		sem.setBounds(260,430,80,20);
		sem.setFont(font);
		sem.setForeground(Color.WHITE);
		t7 = new JTextField();
		t7.setBounds(360,430,100,25);
		t7.setFont(font);
		t7.setBorder(border);

		stu_class = new JLabel("Student Class");
		stu_class.setBounds(30,430,120,20);
		stu_class.setFont(font);
		stu_class.setForeground(Color.WHITE);
		t8 = new JTextField();
		t8.setBounds(170,430,100,25);
		t8.setFont(font);
		t8.setBorder(border);

		//buttons
		submit = new JButton("Submit");
		submit.setBounds(30,530,120,30);
		submit.setFont(font);
		submit.setBackground(new Color(248,242,224));
		submit.setBorder(border);

		//background
		ImageIcon background_image = new ImageIcon("C:/Users/Raavi/Pictures/background2.jpg");
		background = new JLabel("",background_image,JLabel.CENTER);
		background.setBounds(0,0,1000,670);
		background.add(p);
		background.add(panel);
		background.add(submit);

		//listeners
		CustomItemListener il = new CustomItemListener(this);
		b1.addItemListener(il);
		b2.addItemListener(il);
		CustomActionListener al = new CustomActionListener(this);
		submit.addActionListener(al);

		//frame
		f.add(background);
		f.setLayout(null);
		f.setSize(1000,670);
		f.setVisible(true);
		}
	public static void main(String[] args){
		new ClientApplicationForServerProject();
		}
	}

class CustomActionListener implements ActionListener{
	ClientApplicationForServerProject ef;
	CustomActionListener(ClientApplicationForServerProject ef){
		this.ef = ef;
		}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==ef.submit){
			if(ef.t1.getText().equals("")||ef.t3.getText().equals("")||ef.t4.getText().equals(""))
				JOptionPane.showMessageDialog(null,"Please fill the required fields!!");
			else{
				Socket socket1=null;
				ObjectInputStream in=null;
				ObjectOutputStream out=null;
				try{
					socket1=new Socket("localhost", 10);
					out= new ObjectOutputStream( socket1.getOutputStream());
					in= new ObjectInputStream (socket1.getInputStream( ));
					System.out.println("Connected");
					writeInfo(in, out);
					}
				catch(IOException ioe){
					System.out.println("can't connect");
					}
				}
			}
		}

	public void writeInfo(ObjectInputStream in, ObjectOutputStream out){
		    StudentInfo p1 = new StudentInfo( );
			p1.s_fname=ef.t1.getText();
			p1.s_mname=ef.t2.getText();
			p1.s_lname=ef.t3.getText();
			p1.wno=ef.t4.getText();
			p1.mno=ef.t5.getText();
			p1.schname=ef.ta1.getText();
			p1.clgname=ef.ta2.getText();
			p1.s_branch=ef.t6.getText();
			p1.s_sem=ef.t7.getText();
			p1.s_class=ef.t8.getText();
			System.out.println(p1.s_fname + p1.s_mname +p1.s_class+p1.mno);
		try{
			out.writeObject(p1);
			clearFields();
			int response = JOptionPane.showConfirmDialog(null,"Response Recorded! Do you want to submit another response?","Confirm",JOptionPane.YES_NO_OPTION);
			if(response==JOptionPane.NO_OPTION)
				System.exit(0);
			}
	 	catch(Exception ee){
			System.out.println("can't send data" + ee);
			}
		}

	public void clearFields(){
		ef.t1.setText(null);
		ef.t2.setText(null);
		ef.t3.setText(null);
		ef.t4.setText(null);
		ef.t5.setText(null);
		ef.ta1.setText(null);
		ef.t8.setText(null);
		ef.ta2.setText(null);
		ef.t6.setText(null);
		ef.t7.setText(null);
		}
	}

class CustomItemListener implements ItemListener{
	ClientApplicationForServerProject ef;
	CustomItemListener(ClientApplicationForServerProject ef){
		this.ef = ef;
		}
	public void itemStateChanged(ItemEvent e){
		if(e.getItem()==ef.b1){
			ef.background.add(ef.clg);
			ef.background.add(ef.ta2);
			ef.background.add(ef.branch);
			ef.background.add(ef.t6);
			ef.background.add(ef.sem);
			ef.background.add(ef.t7);
			ef.background.remove(ef.stu_class);
			ef.background.remove(ef.t8);
			ef.background.remove(ef.school);
			ef.background.remove(ef.ta1);
			ef.f.repaint();
			}
		if(e.getItem()==ef.b2){
			ef.background.add(ef.school);
			ef.background.add(ef.ta1);
			ef.background.add(ef.stu_class);
			ef.background.add(ef.t8);
			ef.background.remove(ef.branch);
			ef.background.remove(ef.t6);
			ef.background.remove(ef.sem);
			ef.background.remove(ef.t7);
			ef.background.remove(ef.clg);
			ef.background.remove(ef.ta2);
			ef.f.repaint();
			}
		}
	}

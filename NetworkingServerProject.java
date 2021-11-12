import java.net.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class NetworkingServerProject{
	JFrame fr;
	JTable table;
	DefaultTableModel model;
	JScrollPane scroll;
    ServerSocket socket1;
    Socket clientconnection;
    public NetworkingServerProject(){
		fr = new JFrame("Enquiry Information");
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		String col[] = {"Enquiry No.","First Name","Middle Name","Last Name","Whatsapp No.","Mobile No.","School Name","Class","College Name","Branch","Semester"};
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		table.setModel(model);
		table.setFont(new Font("FZShuTi",Font.PLAIN,18));
		table.setRowHeight(30);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll = new JScrollPane(table);
		scroll.setBounds(20,20,500,400);
		scroll.setBorder(border);
		scroll.setViewportView(table);
		scroll.getViewport().setBackground(Color.WHITE);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(10).setPreferredWidth(150);

		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(scroll.getWidth(),40));
		th.setFont(new Font("FZShuTi",Font.BOLD,18));
		th.setBackground(Color.GRAY);
		th.setForeground(Color.WHITE);
		showTableData();
		fr.add(scroll);
		fr.setLayout(null);
		fr.setSize(700,700);
		fr.setVisible(true);
   	try{
		socket1=new ServerSocket(10);
	    System.out.println("server is now ready....");
	    while(true){
	    	clientconnection=socket1.accept(); /*waiting for clients to connect*/
	    	if(clientconnection!=null)
	    		System.out.println("Client connected");
	        Thread t = new MyThread(clientconnection , this);
	        t.start();
	    	}
	   	}
     catch(Exception ioe){
	    System.out.println("error");
	   	}
	}
	public static void main(String[] args){
		new NetworkingServerProject();
		}
	public void showTableData(){
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int q,i,id,deleteItem;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enquiryform","root","Raavi@123");
			ps = con.prepareStatement("select * from enquiry");
			rs = ps.executeQuery();
			ResultSetMetaData stData = rs.getMetaData();
			q = stData.getColumnCount();
			model.setRowCount(0);
			while(rs.next()){
				Vector columnData = new Vector();
				for(i=1; i<=q; i++){
					columnData.add(rs.getString("enquiryNo"));
					columnData.add(rs.getString("firstName"));
					columnData.add(rs.getString("middleName"));
					columnData.add(rs.getString("lastName"));
					columnData.add(rs.getString("whatsappNo"));
					columnData.add(rs.getString("mobileNo"));
					columnData.add(rs.getString("schoolName"));
					columnData.add(rs.getString("classNo"));
					columnData.add(rs.getString("collegeName"));
					columnData.add(rs.getString("branch"));
					columnData.add(rs.getString("sem"));
					}
				model.addRow(columnData);
				}
			}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			}
		}
}

class MyThread extends Thread{
	ObjectInputStream in=null;
	ObjectOutputStream out=null;
	NetworkingServerProject nsp;
	MyThread(Socket request, NetworkingServerProject nsp){
		this.nsp = nsp;
		try{
			in=new ObjectInputStream (request.getInputStream());
			out=new ObjectOutputStream(request.getOutputStream());
			}
		catch(IOException io){
			System.out.println("can't take i/o stream");
			}
		}

	public void run(){
		Connection c = null;
		PreparedStatement ps = null;
		try{
			while(true){
				StudentInfo  p1 = (StudentInfo)in.readObject( );
				System.out.println(p1.s_fname + p1.s_mname +p1.s_class+p1.mno);

                String sql = "insert into enquiry(firstName, middleName, lastName, whatsappNo, mobileNo, schoolName, classNo, collegeName, branch, sem)"
							+ "value (?,?,?,?,?,?,?,?,?,?)";

				System.out.println(sql);
				System.out.println(p1.s_fname + p1.s_mname +p1.s_class+p1.mno);

				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/enquiryform","root","Raavi@123");
		  		ps = c.prepareStatement(sql);
				ps.setString(1,p1.s_fname);
				ps.setString(2,p1.s_mname);
				ps.setString(3,p1.s_lname);
				ps.setString(4,p1.wno);
				ps.setString(5,p1.mno);
				ps.setString(6,p1.schname);
				ps.setString(7,p1.s_class);
				ps.setString(8,p1.clgname);
				ps.setString(9,p1.s_branch);
				ps.setString(10,p1.s_sem);
				int k=ps.executeUpdate();
				nsp.showTableData();
				if(k==1)
					out.writeObject("success");
				else
				   out.writeObject("failed");
				}
			}
			catch(SQLException e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, e);
				}
			catch(Exception e){
				System.out.println("second");
				JOptionPane.showMessageDialog(null, e);
				}
		  	}
	  	}




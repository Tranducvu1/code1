package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



import Model.ConnectDB;



public class informationhouse extends JFrame{
	JFrame lb = new JFrame("Quản lý nhân khẩu thường trú");
	JLabel IDmatt = new JLabel("MATT");
	JTextField tfmatt = new JTextField(15);
	JLabel lbhk = new JLabel("Sổ hộ khẩu");
	JTextField tfhk = new JTextField(15);
	JLabel lbnk = new JLabel("Mã nhân khẩu ");
	JTextField tfqh = new JTextField(15);
	JLabel lbqh = new JLabel("Quan hệ CH");
	JTextField tfnk = new JTextField(15);
	JLabel lbt = new JLabel("Từ");
	JTextField tft = new JTextField(15);
	JLabel lbncd = new JLabel("Ngày chuyển đến");
	JTextField tfncd = new JTextField(15);
	JLabel lbnot = new JLabel("Nơi ở trước ");
	JTextField tfnot = new JTextField(15);
	JButton btnadd = new JButton ("Add");
	JButton btndelete = new JButton ("Delete");
	JButton btnnew = new JButton ("Reset");
	JButton btnupdate = new JButton ("Update");
	JButton btnsearch = new JButton ("Find");
	JButton btnSee = new JButton ("See");
	JButton btncancel = new JButton ("Cancel");
	JButton btnback = new JButton("Back");

	JButton btnexit = new JButton("Exit");
	JTextField tfsearch = new JTextField(10);
	JLabel lbtools = new JLabel("Tools");
	JLabel btnMenu = new JLabel("Meuu");
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbhouse = new JTable();
	JScrollPane sp = new JScrollPane(tbhouse);
	public informationhouse() {
		jframehouse();
		buttonhouse();
		tbhouse.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row = tbhouse.getSelectedRow();
				tfmatt.setText((String)tbhouse.getValueAt(row, 0));
				tfhk.setText((String)tbhouse.getValueAt(row, 1));
				tfnk.setText((String)tbhouse.getValueAt(row, 2));
				tfqh.setText((String)tbhouse.getValueAt(row, 3));
				tft.setText((String)tbhouse.getValueAt(row, 4));
				tfncd.setText((String)tbhouse.getValueAt(row, 5));
				tfnot.setText((String)tbhouse.getValueAt(row, 6));
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	public void DisplayHouse() {
		ConnectDB conn = new ConnectDB();
		rs=conn.listnhankhau("Select * from nhankhau");
		String column[] = {"MATT", "Số hộ khẩu","Mã nhân khẩu","Quan hệ ","Từ","Ngày chuyển đến ","Nơi ở trước"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
       
		
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("MATT"), rs.getString("SShokhau"),rs.getString("Manhankhau"),rs.getString("Quanhe"),rs.getString("Tu"),rs.getString("Ngaychuyenden"),rs.getString("Noiotruoc")};    
				
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	
	public void HouseFind() {
		ConnectDB cn = new ConnectDB();
	   rs=cn.listnhankhau("Select * from nhankhau where MATT = '"+tfmatt.getText()+"'");
		String column[] = {"MATT", "Số hộ khẩu","Mã nhân khẩu","Quan hệ","Từ","Ngay chuyển đến ","Nơi ở trước"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("MATT"), rs.getString("SShokhau"),rs.getString("Manhankhau"),rs.getString("Quanhe"),rs.getString("Tu"),rs.getString("Ngaychuyenden"),rs.getString("Noiotruoc")};    
				
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	public void jframehouse() {
		JPanel pnid = new JPanel();
		pnid.add(IDmatt);
		pnid.add(tfmatt);
		pnid.add(lbhk);
		pnid.add(tfhk);
		pnid.add(lbnk);
		pnid.add(tfnk);
		pnid.add(lbqh);
		pnid.add(tfqh);
		pnid.add(lbt);
		pnid.add(tft);
		pnid.add(lbncd);
		pnid.add(tfncd);
		pnid.add(lbnot);
		pnid.add(tfnot);
		pnid.setLayout(new GridLayout(7,2));
		IDmatt.setForeground(Color.BLUE);
		lbhk.setForeground(Color.BLUE);
		lbnk.setForeground(Color.BLUE);
		lbqh.setForeground(Color.BLUE);
		lbt.setForeground(Color.BLUE);
		lbncd.setForeground(Color.BLUE);
		lbnot.setForeground(Color.BLUE);
		Border bd = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdhouse= BorderFactory.createTitledBorder(bd, "Database");
		pnid.setBorder(tbdhouse);
		pnid.setBackground(Color.WHITE);
		
		JPanel pnbt = new JPanel();
		pnbt.add(btnadd);
		pnbt.add(btnupdate);
		pnbt.add(btndelete);
		pnbt.add(btnsearch);
		pnbt.add(btnnew);
		pnbt.add(btnSee);
		pnbt.add(btncancel);
		pnbt.add(btnback);
		pnbt.setLayout(new GridLayout(2,4));
		btncancel.setBackground(Color.YELLOW);
		btnback.setBackground(Color.YELLOW);
		btnsearch.setBackground(Color.YELLOW);
		btnupdate.setBackground(Color.YELLOW);
		btnnew.setBackground(Color.YELLOW);
		btndelete.setBackground(Color.YELLOW);
		btnadd.setBackground(Color.YELLOW);
		btnSee.setBackground(Color.YELLOW);
		JPanel pninfor = new JPanel();
		Border bdhouse = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdcus= BorderFactory.createTitledBorder(bdhouse, "Quản lý nhân khẩu thường trú");
		pninfor.setBorder(tbdcus);
		pninfor.add(sp);
		pninfor.setBackground(Color.WHITE);
		lb.setLocation(200,100);
		
		Container cont5 = lb.getContentPane();
		cont5.add(pnid,BorderLayout.CENTER);
		cont5.add(pninfor,BorderLayout.EAST);
		cont5.add(pnbt,BorderLayout.SOUTH);
		DisplayHouse();
		lb.pack();
		lb.setSize(950,550);
		lb.setVisible(true);

		btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SignUp();
				lb.dispose();
			}
		});
		btncancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			lb.dispose();
			}
		});
		ConnectDB con = new ConnectDB();
			rs=con.listnhankhau("Select * from nhankhau");
			String column[] = {"MATT", "Số hộ khẩu","Mã nhân khẩu","Quan hệ","Từ","Ngày chuyển đến ","Nơi ở trước"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	       
			
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("MATT"), rs.getString("SShokhau"),rs.getString("Manhankhau"),rs.getString("Quanhe"),rs.getString("Tu"),rs.getString("Ngaychuyenden"),rs.getString("Noiotruoc")};    
					
					
					tm.addRow(data);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tbhouse.setModel(tm);
		
	}
	


	public void buttonhouse() {
		btnnew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new informationhouse();
				lb.dispose();
			}
		});
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//thÃªm dá»¯ liá»‡u
				ConnectDB cn = new ConnectDB();
				try {
					int record = cn.executeDB("Insert into nhankhau values('"+tfmatt.getText()+"','"+tfhk.getText()+"','"+tfnk.getText()+"','"+tfqh.getText()+"','"+tft.getText()+"','"+tfncd.getText()+"','"+tfnot.getText()+"')");
					if (record>0) JOptionPane.showMessageDialog(null, "Insert Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DisplayHouse();
			}
		});
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				try {
					int record = cn.executeDB("Delete from nhankhau where MATT = '"+tfmatt.getText()+"'");
					if (record>0) JOptionPane.showMessageDialog(null, "Delete Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DisplayHouse();
			}
		});
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				try {
					if(tfhk.getText().length() !=0) {
						int record1 = cn.executeDB("Update nhankhau set SShokhau = '"+tfhk.getText()+"' where MATT = '"+tfmatt.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfnk.getText().length()!=0) {
						int record1 = cn.executeDB("Update nhankhau set Manhankhau = '"+tfnk.getText()+"' where MATT = '"+tfmatt.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfqh.getText().length()!=0) {
						int record1 = cn.executeDB("Update nhankhau set Quanhe = '"+tfqh.getText()+"' where MATT = '"+tfmatt.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tft.getText().length()!=0) {
						int record1 = cn.executeDB("Update nhankhau set Tu = '"+tft.getText()+"' where MATT = '"+tfmatt.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfncd.getText().length()!=0) {
						int record1 = cn.executeDB("Update nhankhau set Ngaychuyenden = '"+tfncd.getText()+"' where MATT = '"+tfmatt.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfnot.getText().length()!=0) {
						int record1 = cn.executeDB("Update nhankhau set Noiotruoc = '"+tfnot.getText()+"' where MATT = '"+tfmatt.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				DisplayHouse();
			}
		});
		
		btnsearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				HouseFind();
			}
		});
	
		
		btnSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jtable2();
				lb.dispose();
			}
		});
	
		
	}
public void jtable2() {
	JFrame ftb = new JFrame();
	JTable tbhouse = new JTable();
	JScrollPane ctrl = new JScrollPane(tbhouse);
	JButton btnback = new JButton("Back");
	JButton btncancel = new JButton("Cancel");
	ftb.setLocation(200,100);
	
	JPanel pntb = new JPanel();
	ctrl.setPreferredSize(new Dimension(850, 450));
	Border bd2 = BorderFactory.createLineBorder(Color.CYAN);
	TitledBorder tbdll= BorderFactory.createTitledBorder(bd2, "Informationhouse");
	pntb.setBorder(tbdll);
	pntb.add(ctrl);
	
	btnback.setForeground(Color.RED);
	btncancel.setForeground(Color.RED);
	btnback.setBackground(Color.YELLOW);
	btncancel.setBackground(Color.YELLOW);
	JPanel pnbt = new JPanel();
	pnbt.add(btnback);
	pnbt.add(btncancel);
	Container conttb = ftb.getContentPane();
	conttb.add(pntb);
	conttb.add(pnbt, BorderLayout.SOUTH);
	ftb.setSize(900,500);
	ftb.setVisible(true);
	btncancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
				ftb.dispose();;
			
			}
	});
	btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			new informationhouse();
			ftb.dispose();
			}
		});
ConnectDB con = new ConnectDB();
// trong sql thÃ¬ pháº£i dÃ¹ng DefaultTableModel náº¿u k sáº½ bá»‹ trÃ¹ng dá»¯ liá»‡u
	rs=con.listnhankhau("Select * from nhankhau");
	String column[] = {"MATT", "Số hộ khẩu","Mã nhân khẩu","Quan hệ","Từ","Ngay chuyển đến ","Nơi ở trước"};
    DefaultTableModel tm = new DefaultTableModel (column, 0);
    try {
		while (rs.next()) {
			Object data[]= {rs.getString("MATT"), rs.getString("SShokhau"),rs.getString("Manhankhau"),rs.getString("Quanhe"),rs.getString("Tu"),rs.getString("Ngaychuyenden"),rs.getString("Noiotruoc")};    
			
			
			tm.addRow(data);
		
		}
		tbhouse.setModel(tm);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
package Auction;

import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import GuiBuilder.ButtonBuilder;

public class ProductListTable {

private static JTable table;
private JFrame frame;
private DefaultTableModel data;

	public ProductListTable(int x, int y, int width, int height, JFrame frame) {
		
		this.frame = frame;
		ButtonBuilder buttonBuilder = new ButtonBuilder(frame);

		ProductList productList = new ProductList();
		data = productList.selectList("");

		table = new JTable(data);
		 
		JScrollPane scrollPane = new JScrollPane(table);
		 
		table.getColumnModel().getColumn(4).setCellRenderer(new AuctionStartButton());
		table.getColumnModel().getColumn(4).setCellEditor(new AuctionStartButton());
		 
		
		scrollPane.setLocation(15, 70);
		scrollPane.setSize(500, 500);
		frame.add(scrollPane);
	}

	public static String getData() {
		
		int row = table.getSelectedRow();
		if(row == -1) return null;
			

		return table.getValueAt(row, 0)+"";
	}

}

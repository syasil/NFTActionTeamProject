package Auction;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;




public class AuctionStartButton extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

	JButton button;
	String data;
	
    public AuctionStartButton(){
    	button = new JButton("add");
    	button.addActionListener(e -> {
    		
    		new AuctionStartFrame(ProductListTable.getData());
            
        });
    }
    
    @Override
	public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
    	
    	
		return button;
	}
	@Override
	public Object getCellEditorValue() {
		
		
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return button;
	}
}
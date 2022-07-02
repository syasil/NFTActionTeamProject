package Auction;

import javax.swing.JFrame;

import GuiBuilder.ButtonBuilder;
import GuiBuilder.LabelBuilder;
import GuiBuilder.TableBuilder;
import GuiBuilder.TextFieldBuilder;
import GuiBuilder.TextPaneBuilder;

public class AuctionRegisterPage {
private JFrame auctionRegisterFrame;
	
	public AuctionRegisterPage() {
		
		auctionRegisterFrame = new JFrame();
		auctionRegisterFrame.setBounds(100, 100, 600, 630);
		auctionRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		auctionRegisterFrame.getContentPane().setLayout(null);
		
		auctionRegisterFrame.setVisible(true);
		
		BuildAuctionRegisterPage();
		
	}

	private void BuildAuctionRegisterPage() {
		
		TextPaneBuilder textPaneBuilder = new TextPaneBuilder(auctionRegisterFrame);
		TextFieldBuilder textFieldBuilder = new TextFieldBuilder(auctionRegisterFrame);
		ButtonBuilder buttonbuilder = new ButtonBuilder(auctionRegisterFrame);
		LabelBuilder labelBuilder = new LabelBuilder(auctionRegisterFrame);
		TableBuilder tableBuilder = new TableBuilder(auctionRegisterFrame);
		
		textFieldBuilder.BuildProductSearchTextField(15, 15, 500, 40);
		buttonbuilder.BuildProductSearchButton(525, 15, 40, 40, "검색");
		tableBuilder.BuildProductListTable(15, 70, 500, 500);
		
	}
	
	
}

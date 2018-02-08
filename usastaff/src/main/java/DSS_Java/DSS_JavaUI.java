package DSS_Java;

/**
Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2008, 2010

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
Schedule Contract with IBM Corp.
*/
/**
 * genericAuthenticationUI.java
 *
 * Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved.
 * Cognos (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: This code sample makes calls to IBM Cognos Mashup Service.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.apache.log4j.BasicConfigurator;



@SuppressWarnings("serial")
public class DSS_JavaUI extends JFrame{


		// The following variables represent the dialog components.
		private JTextArea textAreaPane;
		private TextField camNameSpace;
		private TextField camUserName;
		private TextField camPassword;
		private TextField reportID;
		private TextField serverURL;
		private JButton outputButton;
		private ButtonGroup fmtbgroup;

		private String myNameSpace=null;
		private String myUserName=null;
		private String myPassword=null;
		private String myReportID=null;
		private String myURL=null;
		private String myFMT=null;

		genericAuthentication myGenericApplication = new genericAuthentication();

		// This is the constructor.
		public DSS_JavaUI(String title) {
			// Set the title of the frame, even before the variables are declared.
			super(title);
			addComponents();
		}


		// Add all components to the frame's panel.
		private void addComponents() {
			JMenuBar mBar = new JMenuBar();
			this.setJMenuBar(mBar);

			// declare menuItems
			JMenuItem exit;
			JMenuItem about;

			// Add and populate the File menu.
			JMenu fileMenu = new JMenu("File");
			mBar.add(fileMenu);

			exit = new JMenuItem("Exit");
			fileMenu.add(exit);
			exit.addActionListener(new MenuHandler());

			// Add and populate the Help menu.
			JMenu helpMenu = new JMenu("Help");
			mBar.add(helpMenu);

			about = new JMenuItem("About");
			helpMenu.add(about);
			about.addActionListener(new MenuHandler());

			JPanel mainPanel = createMainPanel();
			JPanel outputPanel = createOutputPanel();
			JPanel panel = new JPanel(new BorderLayout());
			panel.add(mainPanel, BorderLayout.NORTH);
			panel.add(outputPanel);

			setContentPane(panel);
		}

		private JPanel createOutputPanel() {
			// Add the status text pane.
			textAreaPane = new JTextArea();
			JScrollPane areaScrollPane = new JScrollPane(textAreaPane);
			areaScrollPane
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			areaScrollPane.setPreferredSize(new Dimension(500, 275));

			//Create the output panel and it's layout objects
			GridBagLayout layout = new GridBagLayout();
			JPanel outputPanel = new JPanel(layout);

			GridBagConstraints layoutConstraints = new GridBagConstraints();
			layoutConstraints.weightx = 1.0;
			layoutConstraints.weighty = 1.0;
			layoutConstraints.fill = GridBagConstraints.BOTH;
			layout.setConstraints(areaScrollPane, layoutConstraints);
			outputPanel.add(areaScrollPane);

			outputPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
					.createCompoundBorder(BorderFactory
							.createTitledBorder("Output"), BorderFactory
							.createEmptyBorder(5, 5, 5, 5)), outputPanel
					.getBorder()));

			return outputPanel;
		}

		private JPanel createMainPanel() {
			//Create text field
			camNameSpace= new TextField(20);
			camUserName=new TextField(20);
			camPassword=new TextField(20);
			camPassword.setEchoChar('*');
			reportID = new TextField(45);
			serverURL=new TextField(45);
			camNameSpace.setText("DSS_CAP");
			camUserName.setText("");
			serverURL.setText("https://data.stage.usastaffing.gov/ibmcognos/bi/v1/disp");
			reportID.setText("/content/folder[@name='USA Staffing Packages and Folders']/package[@name='Staffing Reports']/folder[@name='Data Self Service']/report[@name='Vacancy Data Self Service']");

			// Create a panel for the namespace text field
			JPanel nameSpacePanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
			nameSpacePanel.add(new JLabel("Name Space:"));
			nameSpacePanel.add(camNameSpace);

			// Create a panel for the user name text field
			JPanel userNamePanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
			userNamePanel.add(new JLabel("User Name:   "));
			userNamePanel.add(camUserName);

			// Create a panel for the password text field
			JPanel passwordPanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
			passwordPanel.add(new JLabel("Password:     "));
			passwordPanel.add(camPassword);

			// Create a GridLayout panel and add in text field panels
			JPanel mainPanel1 = new JPanel(new GridLayout(3, 0));
			mainPanel1.add(nameSpacePanel);
			mainPanel1.add(userNamePanel);
			mainPanel1.add(passwordPanel);

			// Create a panel for the report ID
			JPanel reportIDPanel=new JPanel( new FlowLayout(FlowLayout.LEFT));
			reportIDPanel.add(new JLabel("Report:         "));
			reportIDPanel.add(reportID);

			//Create a panel for Server
			JPanel serverURLPanel=new JPanel( new FlowLayout(FlowLayout.LEFT));
			serverURLPanel.add(new JLabel("Server URL:"));
			serverURLPanel.add(serverURL);

			//get output button panel
			JPanel reportOutputPanel = createMainButtonPanel();

			//create a GridLayout panel and add in ReportID text field and output button
			JPanel mainPanel2 = new JPanel(new GridLayout(3, 0));
			mainPanel2.add(reportIDPanel);
			mainPanel2.add(serverURLPanel);
			mainPanel2.add(reportOutputPanel);

			JPanel mainPanel=new JPanel(new GridLayout(1,2));
			mainPanel.add(mainPanel1);
			mainPanel.add(mainPanel2);

			return mainPanel;
		}

		private JPanel createMainButtonPanel() {
			// Create the button Panel
			JPanel buttonPanel = new JPanel( new FlowLayout(FlowLayout.LEFT));
			// Create and add the Button to the Panel
			outputButton = new JButton("Report Output");
			outputButton.addActionListener(new allButtonsHandler());
			buttonPanel.add(outputButton, BorderLayout.EAST);
			JRadioButton LDXButton   = new JRadioButton("LDX", true);
	        JRadioButton SimpleButton    = new JRadioButton("Simple");
	        JRadioButton HTMLButton = new JRadioButton("HTML");
	        JRadioButton JSONButton    = new JRadioButton("JSON");
	        JRadioButton DataButton = new JRadioButton("DataSet");
	        fmtbgroup = new ButtonGroup();
	        fmtbgroup.add(LDXButton);
	        fmtbgroup.add(SimpleButton);
	        fmtbgroup.add(HTMLButton);
	        fmtbgroup.add(JSONButton);
	        fmtbgroup.add(DataButton);
	        buttonPanel.add(LDXButton);
	        buttonPanel.add(SimpleButton);
	        buttonPanel.add(HTMLButton);
	        buttonPanel.add(JSONButton);
	        buttonPanel.add(DataButton);

			return buttonPanel;
		}

		// handle menu bar buttons
		private class MenuHandler implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JMenuItem menuClicked = (JMenuItem) e.getSource();
					if (menuClicked.getText() == "Exit") {
						System.exit(0);
					}
					if (menuClicked.getText() == "About") {
						JOptionPane.showMessageDialog(((JMenuItem) e.getSource())
								.getParent(), "Java Data Self Service Sample Application\n\n"
								+ "Version 1.0.0\n"
								+ "This application demonstrates the IBM Cognos Mashup Service",
								"About Java Data Self Service Sample",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
										"../../images/about.gif"));
					}
				} catch (Exception ex) {
				}
			}
		}


		// The following is the button event handler.
		private class allButtonsHandler implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {

				String reportOutput=null;

				JButton buttonPressed = ((JButton) e.getSource());

				if (buttonPressed == outputButton) {

				    textAreaPane.setText("");

					myNameSpace=camNameSpace.getText();
					myUserName=camUserName.getText();
					myPassword=camPassword.getText();
					myReportID=reportID.getText();
					myURL=serverURL.getText();
					myFMT="LDX";
					for (Enumeration<AbstractButton> buttons = fmtbgroup.getElements(); buttons.hasMoreElements();) {
			            AbstractButton button = buttons.nextElement();
			            if (button.isSelected()) {
			                myFMT=button.getText();
			            }
			        }
					if (myFMT == "LDX")
					{
						myFMT="layoutDataXML";
					}


					if(myNameSpace.equalsIgnoreCase("")||myUserName.equalsIgnoreCase("")||myReportID.equalsIgnoreCase("")||myURL.equalsIgnoreCase(""))
					{
						textAreaPane.setText("Please make sure you have input all the text field ...");
					}
					else
					{
						myGenericApplication.setURL(myURL);
						reportOutput=myGenericApplication.getReportOutput(myNameSpace, myUserName, myPassword, myReportID, myFMT);
     					textAreaPane.setText(reportOutput);
					}
				}
			}
		}


		// Create the main method to execute the application.
		public static void main(String args[]) {
			BasicConfigurator.configure();
			DSS_JavaUI frame = new DSS_JavaUI("Java Data Self Service Sample");
			// Create a WindowAdapter so the application
			// is exited when the window is closed.
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
						System.exit(0);
				}
			});

			frame.textAreaPane.setText("");

			// Set the size of the frame and display it.
			frame.setSize(930, 440);
			frame.setVisible(true);
			frame.setResizable(true);
			frame.camUserName.requestFocusInWindow();

		}

}

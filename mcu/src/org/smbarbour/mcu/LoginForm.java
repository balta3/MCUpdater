package org.smbarbour.mcu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.smbarbour.mcu.MCLoginException.ResponseType;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class LoginForm extends JDialog {

	private static final long serialVersionUID = 494448102754040724L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblStatus;
	/**
	 * Create the dialog.
	 */
	public LoginForm(final MainForm parent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/art/mcu-icon.png")));
		setTitle("Minecraft Login");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		final LoginForm window = this;
		setBounds(100, 100, 250, 75);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {0, 60, 0, 0};
		gbl_contentPanel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		
				{
					//Username
					JLabel lblUsername = new JLabel("Username:");
					GridBagConstraints gbc_lblUsername = new GridBagConstraints();
					gbc_lblUsername.anchor = GridBagConstraints.WEST;
					gbc_lblUsername.fill = GridBagConstraints.VERTICAL;
					gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
					gbc_lblUsername.gridx = 1;
					gbc_lblUsername.gridy = 1;
					contentPanel.add(lblUsername, gbc_lblUsername);
				}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(5, 5));
			GridBagConstraints gbc_rigidArea = new GridBagConstraints();
			gbc_rigidArea.anchor = GridBagConstraints.WEST;
			gbc_rigidArea.fill = GridBagConstraints.VERTICAL;
			gbc_rigidArea.insets = new Insets(0, 0, 5, 0);
			gbc_rigidArea.gridx = 0;
			gbc_rigidArea.gridy = 0;
			contentPanel.add(rigidArea, gbc_rigidArea);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(5);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.anchor = GridBagConstraints.NORTHWEST;
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut.gridx = 0;
			gbc_horizontalStrut.gridy = 3;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		
		{
			JLabel lblPassword = new JLabel("Password:");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.WEST;
			gbc_lblPassword.fill = GridBagConstraints.VERTICAL;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
			gbc_lblPassword.gridx = 1;
			gbc_lblPassword.gridy = 2;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			txtUsername = new JTextField(parent.getConfig().getProperty("userName",""));
			GridBagConstraints gbc_txtUsername = new GridBagConstraints();
			gbc_txtUsername.anchor = GridBagConstraints.NORTH;
			gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
			gbc_txtUsername.gridx = 2;
			gbc_txtUsername.gridy = 1;
			contentPanel.add(txtUsername, gbc_txtUsername);
		}
				{
					txtPassword = new JPasswordField();
					GridBagConstraints gbc_txtPassword = new GridBagConstraints();
					gbc_txtPassword.anchor = GridBagConstraints.NORTH;
					gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtPassword.gridx = 2;
					gbc_txtPassword.gridy = 2;
					contentPanel.add(txtPassword, gbc_txtPassword);
				}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 5, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				GridBagLayout gbl_buttonPane = new GridBagLayout();
				gbl_buttonPane.columnWidths = new int[]{78, 78, 78, 0, 0};
				gbl_buttonPane.rowHeights = new int[]{23, 0};
				gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				buttonPane.setLayout(gbl_buttonPane);
				{
					lblStatus = new JLabel("");
					lblStatus.setForeground(Color.RED);
					lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
					GridBagConstraints gbc_lblStatus = new GridBagConstraints();
					gbc_lblStatus.anchor = GridBagConstraints.WEST;
					gbc_lblStatus.gridwidth = 2;
					gbc_lblStatus.fill = GridBagConstraints.BOTH;
					gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
					gbc_lblStatus.gridx = 0;
					gbc_lblStatus.gridy = 0;
					buttonPane.add(lblStatus, gbc_lblStatus);
				}
				{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancel");
					cancelButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							window.dispose();
						}
						
					});
					JButton okButton = new JButton("OK");
					okButton.setActionCommand("OK");
					okButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							try {
								getContentPane().setEnabled(false);
								LoginData response = login(txtUsername.getText(), String.valueOf(txtPassword.getPassword()));
								parent.setLoginData(response);
								parent.getConfig().setProperty("userName", txtUsername.getText());
								parent.writeConfig(parent.getConfig());
								parent.setPlayerName(response.getUserName());
								window.dispose();
								
							} catch (MCLoginException e) {
								lblStatus.setText(e.getMessage());
							} finally {
								getContentPane().setEnabled(true);
							}
							
						}
						
					});
					GridBagConstraints gbc_okButton = new GridBagConstraints();
					gbc_okButton.anchor = GridBagConstraints.EAST;
					gbc_okButton.fill = GridBagConstraints.BOTH;
					gbc_okButton.insets = new Insets(0, 0, 0, 5);
					gbc_okButton.gridx = 2;
					gbc_okButton.gridy = 0;
					buttonPane.add(okButton, gbc_okButton);
					getRootPane().setDefaultButton(okButton);
					GridBagConstraints gbc_cancelButton = new GridBagConstraints();
					gbc_cancelButton.anchor = GridBagConstraints.EAST;
					gbc_cancelButton.fill = GridBagConstraints.BOTH;
					gbc_cancelButton.gridx = 3;
					gbc_cancelButton.gridy = 0;
					buttonPane.add(cancelButton, gbc_cancelButton);				
				}
			}
		}
		setSize(320, 125);

	}

	public LoginData login(String username, String password) throws MCLoginException {
	    try {
	      HashMap<String, Object> localHashMap = new HashMap<String, Object>();
	      localHashMap.put("user", username);
	      localHashMap.put("password", password);
	      localHashMap.put("version", Integer.valueOf(13));
	      String str = HTTPSUtils.executePost("https://login.minecraft.net/", localHashMap);
	      if (str == null) {
	        //showError("Can't connect to minecraft.net");
	    	throw new MCLoginException(ResponseType.NOCONNECTION);
	      }
	      if (!str.contains(":")) {
	        if (str.trim().equals("Bad login")) {
	        	throw new MCLoginException(ResponseType.BADLOGIN);
	        } else if (str.trim().equals("Old version")) {
	        	throw new MCLoginException(ResponseType.OLDVERSION);
	        } else if (str.trim().equals("User not premium")) {
	        	throw new MCLoginException(ResponseType.OLDLAUNCHER);
	        } else {
	        	throw new MCLoginException(str);
	        }
	      }
	      String[] arrayOfString = str.split(":");

/*
	      HashMap<String,String> loginParams = new HashMap<String, String>();
	      loginParams.put("userName", arrayOfString[2].trim());
	      loginParams.put("latestVersion", arrayOfString[0].trim());
	      loginParams.put("downloadTicket", arrayOfString[1].trim());
	      loginParams.put("sessionId", arrayOfString[3].trim());
	      return loginParams;
	      */
	      LoginData login = new LoginData();
	      login.setUserName(arrayOfString[2].trim());
	      login.setLatestVersion(arrayOfString[0].trim());
	      login.setSessionId(arrayOfString[3].trim());
	      return login;
	      
	    } catch (MCLoginException mcle) {
	    	throw mcle;
	    } catch (Exception localException) {
	    	localException.printStackTrace();
	    	throw localException;
	    }
	  }
}


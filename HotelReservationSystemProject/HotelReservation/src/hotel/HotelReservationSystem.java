package hotel;


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.*;

public class HotelReservationSystem {	
	
//	private static UserDatabase userList = new UserDatabase();
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		final JLabel text = new JLabel("Please select the type of User");

		//add "Guest" and "Manager" buttons
		JButton managerButton = new JButton("Manager");
		JButton guestButton = new JButton("Guest");

		//add MouseListeners to buttons
		guestButton.addMouseListener(
				new MouseListener()
				{
					public void mouseClicked(MouseEvent arg0) {
						aGuestOption();
						frame.dispose();
					}

					public void mouseEntered(MouseEvent arg0) {}

					public void mouseExited(MouseEvent arg0) {}

					public void mousePressed(MouseEvent arg0) {}

					public void mouseReleased(MouseEvent arg0) {}

				});

		managerButton.addMouseListener(
				new MouseListener()
				{
					public void mouseClicked(MouseEvent arg0) {
						aManagerOption();
						frame.dispose();							
					}

					public void mouseEntered(MouseEvent arg0) {}

					public void mouseExited(MouseEvent arg0) {}

					public void mousePressed(MouseEvent arg0) {}

					public void mouseReleased(MouseEvent arg0) {}

				});

		frame.setLayout(new FlowLayout());
		frame.add(text);
		frame.add(managerButton);
		frame.add(guestButton);


		frame.pack();
		frame.setVisible(true);		
	}


	public static void aGuestOption()
	{
		JFrame frame = new JFrame();
		final JLabel text = new JLabel("Hello! Welcome to CIJ Hotel. Today is " + LocalDate.now().toString() + ".");

		//add "Sign up" and "Sign in" buttons
		JButton signUpButton = new JButton("Sign Up");
		JButton signInButton = new JButton("Sign In");


		//add mouseListener to buttons
		signUpButton.addMouseListener(
				new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						signUp();
						frame.dispose();

					}

					public void mouseEntered(MouseEvent arg0) {}

					public void mouseExited(MouseEvent arg0) {}

					public void mousePressed(MouseEvent arg0) {}

					public void mouseReleased(MouseEvent arg0) {}	
				});

		signInButton.addMouseListener(
				new MouseListener(){

					public void mouseClicked(MouseEvent e) {
						signIn();
						frame.dispose();
					}

					public void mouseEntered(MouseEvent e) {}

					public void mouseExited(MouseEvent e) {}

					public void mousePressed(MouseEvent e) {}

					public void mouseReleased(MouseEvent e) {}

				});

		frame.setLayout(new FlowLayout());
		frame.add(text);
		frame.add(signUpButton);
		frame.add(signInButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void signUp()
	{
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		final int FIELD_WIDTH = 30;
		String[] requestTexts = {"Please enter your name: ", "Please enter an ID: ", "Please enter a password: "};
		int fieldNum = requestTexts.length;



		SpringLayout layout = new SpringLayout(); 
		ArrayList<JTextField> answerTextList = new ArrayList<>();
		for (int i = 0; i<fieldNum; i++)
		{
			Container aContainer = new Container();
			aContainer.setLayout(layout);

			JLabel text = new JLabel(requestTexts[i]);
			JTextField textAnswer = new JTextField(FIELD_WIDTH);
			text.setLabelFor(textAnswer);

			aContainer.add(text);
			aContainer.add(textAnswer);

			layout.putConstraint(SpringLayout.WEST, textAnswer, 10, SpringLayout.EAST, text);
			layout.putConstraint(SpringLayout.NORTH, textAnswer, 10, SpringLayout.NORTH, aContainer);

			layout.putConstraint(SpringLayout.EAST, aContainer,10,SpringLayout.EAST, textAnswer);
			layout.putConstraint(SpringLayout.SOUTH, aContainer, 10 , SpringLayout.SOUTH, textAnswer);

			answerTextList.add(textAnswer);
			frame.add(aContainer);
		}


		JButton doneButton = new JButton("Done");
		doneButton.addMouseListener(
				new MouseListener(){

					public void mouseClicked(MouseEvent e) {								
						String emptyAreaError = new String("Please fill out this area");
						boolean startWrite = false;
						for (int i = 0; i<answerTextList.size();i++)
						{
							if((answerTextList.get(i).getText()).equals("") || (answerTextList.get(i).getText()).equals(emptyAreaError) )
							{
								answerTextList.get(i).setText(emptyAreaError);
								startWrite = false;
								break;
							}
							else {startWrite = true;}


						}

						if (startWrite == true){
							String aName = (answerTextList.get(0)).getText();
							String aID = (answerTextList.get(1)).getText();
							String aPassword = (answerTextList.get(2)).getText();
				//			User g = new Guest(aName, aID, aPassword);
						//	userList.addGuest(g);

							try {
								File file = new  File("userList.txt");

								if (!file.exists()) {
									file.createNewFile();
								}

								FileWriter fw = new FileWriter(file,true);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter pw = new PrintWriter(bw);

								pw.println(aName+","+aID+","+aPassword);
								bw.close();
							} 

							catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						aGuestOption();
						frame.dispose();
					}

					public void mouseEntered(MouseEvent e) {}

					public void mouseExited(MouseEvent e) {}

					public void mousePressed(MouseEvent e) {}

					public void mouseReleased(MouseEvent e) {}
				});

		frame.add(doneButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void signIn(){
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		final int FIELD_WIDTH = 30;
		String[] requestTexts = {"ID: ", "Password: "};
		int fieldNum = requestTexts.length;



		SpringLayout layout = new SpringLayout(); 
		ArrayList<JTextField> answerTextList = new ArrayList<>();
		for (int i = 0; i<fieldNum; i++)
		{
			Container aContainer = new Container();
			aContainer.setLayout(layout);

			JLabel text = new JLabel(requestTexts[i]);
			JTextField textAnswer = new JTextField(FIELD_WIDTH);
			text.setLabelFor(textAnswer);

			aContainer.add(text);
			aContainer.add(textAnswer);

			layout.putConstraint(SpringLayout.WEST, textAnswer, 10, SpringLayout.EAST, text);
			layout.putConstraint(SpringLayout.NORTH, textAnswer, 10, SpringLayout.NORTH, aContainer);

			layout.putConstraint(SpringLayout.EAST, aContainer,10,SpringLayout.EAST, textAnswer);
			layout.putConstraint(SpringLayout.SOUTH, aContainer, 10 , SpringLayout.SOUTH, textAnswer);

			answerTextList.add(textAnswer);
			frame.add(aContainer);
		}


		JButton logInButton = new JButton("Log In");
		logInButton.addMouseListener(
				new MouseListener(){

					public void mouseClicked(MouseEvent e) {
						String emptyAreaError = new String("Please fill out this area");
						boolean startAccCheck = false;
						for (int i = 0; i<answerTextList.size();i++)
						{
							if((answerTextList.get(i).getText()).equals("") || (answerTextList.get(i).getText()).equals(emptyAreaError) )
							{
								answerTextList.get(i).setText(emptyAreaError);
								startAccCheck = false;
								break;
							}
							else {
								startAccCheck = true;
							}
						}
						File userList = new File("userList.txt");
						boolean logInSuccess = false;
						if (startAccCheck == true)
						{
							try {
								Scanner in = new Scanner(new FileReader(userList));
								while(in.hasNextLine()){

									String currentLine = in.nextLine();
									//	System.out.println(currentLine);
									String[] split = currentLine.split(",");
									//	System.out.println(split[0]+split[1]+split[2]);
									User tempUser = new Guest(split[0],split[1],split[2]); //needs to go through userList to see if guest has registered
									//    System.out.println(split[1].length());
									//   System.out.println(split[2].length());
									//  System.out.println(answerTextList.get(0).getText());
									// System.out.println(answerTextList.get(1).getText());
									logInSuccess = tempUser.verification((answerTextList.get(0).getText()), (answerTextList.get(1).getText()));

									if (logInSuccess)
									{
										ReservationFrame resFrame = new ReservationFrame(tempUser);
										resFrame.makeReservationFrame();
										frame.dispose();
										break;
									}
								}
							} 
							catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}

					public void mouseEntered(MouseEvent e) {}

					public void mouseExited(MouseEvent e) {}

					public void mousePressed(MouseEvent e) {}

					public void mouseReleased(MouseEvent e) {}

				});

		frame.add(logInButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void aManagerOption()
	{
//		JFrame frame = new JFrame();
//		final int FIELD_WIDTH = 30;
//		final JTextField text = new JTextField(FIELD_WIDTH);
//		text.setText("Hello, CIJ Manager! Today's date is: " + LocalDate.now().toString() + "\nWhat would you like to do today?");
//
//		JButton loadReservationButton = new JButton("Load Existing Reservations");
//		JButton viewInformationButton = new JButton("View Room Information");
//		JButton saveButton = new JButton("Save");
//		JButton quitButton = new JButton("Quit");
//
//		frame.setLayout(new FlowLayout());
//		frame.add(text);
//		frame.add(loadReservationButton);
//		frame.add(viewInformationButton);
//		frame.add(saveButton);
//		frame.add(quitButton);
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);			
	}
}




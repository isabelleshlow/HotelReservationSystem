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
import java.sql.Date;
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
										System.out.println("Log in successful");
										frame.dispose();
										break;
									}
								}
								if(!logInSuccess)
								{
									System.out.println("Failed to log in");
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
		
		JFrame frame = new JFrame();
		final int FIELD_WIDTH = 30;
		final JTextField text = new JTextField(FIELD_WIDTH);
		text.setText("Hello! Today's date is: " + LocalDate.now().toString());
		final JLabel text1 = new JLabel("Hello! Today's date is: " + LocalDate.now().toString() + ". What would you like to do?");
		// MATA - added rooms; first 10 are economic and last 10 are luxurious
		Room[] rooms = new Room[20];
		
		for(int i = 0; i < rooms.length; i++)
		{
			if(i >= 10)
			{
				rooms[i] = new Room("L");
			}
			else
			{
				rooms[i] = new Room("E");
			}
		}
		
		// MATA - ArrayList containing all guest reservations
		ArrayList<Reservation> allReservations = new ArrayList<Reservation>();
		
		//add buttons
		JButton loadButton = new JButton("Load");
		JButton viewButton = new JButton("View");
		JButton saveButton = new JButton("Save");
		JButton quitButton = new JButton("Quit");
		
		//add ActionListener to button
		loadButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e)
	    													{
																try 
																{
																	File reservations = new  File("reservations.txt");

																	if(!reservations.exists()) 
																	{
																		reservations.createNewFile();
																	}
		        
																	Scanner in = new Scanner(new FileReader(reservations));
		        
																	while(in.hasNextLine())
																	{
																		String currentLine = in.nextLine();
																		String[] split = currentLine.split(",");
																		String guest = split[0];
																		
																		// parse startDate into a LocalDate variable
																		String[] dateParse = split[1].split("/");
																		
										    	    					String month = dateParse[0];
										    	    					int monthConverter = Integer.valueOf(month);
										    	    					
										    	    					
										    	    					String day = dateParse[1];
										    	    					int dayConverter = Integer.valueOf(day);
										    	    					
										    	    					
										    	    					String year = dateParse[2];
										    	    					int yearConverter = Integer.valueOf(year);
										    	    					
										    	    					
										    	    					LocalDate startDate = LocalDate.of(yearConverter, monthConverter, dayConverter);
										    	    					
										    	    					// parse endDate into a LocalDate variable
										    	    					dateParse = split[2].split("/");
																		
										    	    					month = dateParse[0];
										    	    					monthConverter = Integer.valueOf(month);
										    	    					
										    	    					day = dateParse[1];
										    	    					dayConverter = Integer.valueOf(day);										    	    					
										    	    					
										    	    					year = dateParse[2];
										    	    					yearConverter = Integer.valueOf(year);
										    	    					
										    	    					LocalDate endDate = LocalDate.of(yearConverter, monthConverter, dayConverter);
										    	    					
										    	    					String roomType = split[3];
																		int roomNumber = Integer.parseInt(split[4]);																			
																		
																		if(roomType.equals("E"))
																		{
																			Room theRoom = rooms[roomNumber + 9];
																			theRoom.book(startDate, endDate);
																			// convert LocalDates to Dates because of Reservation constructor
																			Reservation r = new Reservation(Date.valueOf(startDate), Date.valueOf(endDate), guest, theRoom, "");
																			allReservations.add(r);
																		}
																		if(roomType.equals("L"))
																		{
																			Room theRoom = rooms[roomNumber - 1];
																			theRoom.book(startDate, endDate);
																			// convert LocalDates to Dates because of Reservation constructor
																			Reservation r = new Reservation(Date.valueOf(startDate), Date.valueOf(endDate), guest, theRoom, "");
																			allReservations.add(r);
																		}
																	}
																	in.close();
																} 
		    
																catch (IOException e1) 
																{
																	e1.printStackTrace();
																}
																
																System.out.println("Reservations successfully loaded");
	    													}
														   });
		
		viewButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e)
	    													{
																
	    													}
	    												  });
		
		saveButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e)
															{
																System.out.println("System successfully saved");
															}
														  });
		
		quitButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e)
															{
																System.out.println("System successfully saved and exited");
																// close frame
																frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
															}
														  });
		
		frame.setLayout(new FlowLayout());
		frame.add(text1);
		frame.add(loadButton);
		frame.add(viewButton);
		frame.add(saveButton);
		frame.add(quitButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	}
	
}


package com.qarri.three_tier;

import java.io.*;
import java.net.*;

public class TCPClient {

	@SuppressWarnings({})
	public static void main(String argv[]) throws Exception {
		int establish_connection = 1;
		Socket clientSocket;
		String firstname;
		String lastname;
		String mobile;
		String username;
		String password;
		String access_level;
		String json_string;
		int repeat = 1;
		App app = new App();
		Person person;

		while (establish_connection == 1) {
			repeat = 1;
			clientSocket = new Socket("localhost", 6789);

			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());

			while (repeat == 1) {
				int choice = 0;
				System.out.println("To add a person press 1:");
				System.out.println("To delete a person press 2:");
				System.out.println("To retrieve person press 3:");
				System.out.println("To update person press 4:");
				System.out.println("To EXIT press 5:");
				choice = Integer.parseInt(inFromUser.readLine());
				switch (choice) {
				case 1:
					System.out.println("Student first name:");
					firstname = inFromUser.readLine();
					System.out.println("Student last name:");
					lastname = inFromUser.readLine();
					System.out.println("Student mobile:");
					mobile = inFromUser.readLine();
					System.out.println("Student username:");
					username = inFromUser.readLine();
					System.out.println("Student password:");
					password = inFromUser.readLine();
					System.out.println("Student access_level:");
					access_level = inFromUser.readLine();
					person = new Person(firstname, lastname, mobile, username, password, access_level);
					json_string = app.otoj(person);
					outToServer.writeUTF("post:" + json_string);
					System.out.println(inFromServer.readUTF());
					break;

				case 2:
					System.out.println("Student username:");
					username = inFromUser.readLine();
					outToServer.writeUTF("delete:" + username);
					System.out.println(inFromServer.readUTF());
					break;

				case 3:
					System.out.println("Student username:");
					username = inFromUser.readLine();
					outToServer.writeUTF("get:" + username);
					System.out.println("Person: " + inFromServer.readUTF());
					break;

				case 4:
					System.out.println("Student first name:");
					firstname = inFromUser.readLine();
					System.out.println("Student last name:");
					lastname = inFromUser.readLine();
					System.out.println("Student mobile:");
					mobile = inFromUser.readLine();
					System.out.println("Student username:");
					username = inFromUser.readLine();
					System.out.println("Student password:");
					password = inFromUser.readLine();
					System.out.println("Student access_level:");
					access_level = inFromUser.readLine();
					person = new Person(firstname, lastname, mobile, username, password, access_level);
					json_string = app.otoj(person);
					outToServer.writeUTF("put:" + json_string);
					System.out.println(inFromServer.readUTF());
					break;
				default:
					break;
				}

				System.out.println("\npress 1 for MENU / press 0 to EXIT:");
				repeat = Integer.parseInt(inFromUser.readLine());
			}
			clientSocket.close();
			System.out.println("\npress 1 to Reconnect / press 0 to EXIT:");
			establish_connection = Integer.parseInt(inFromUser.readLine());
		}
	}
}

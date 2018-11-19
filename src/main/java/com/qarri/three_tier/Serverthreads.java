package com.qarri.three_tier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Serverthreads extends Thread {
	private String json_string = null;
	private String message = null;
	private String command = null;
	private DataInputStream inFromClient = null;
	private DataOutputStream outToClient = null;
	private App app = null;
	private DBhandler db = null;
	private Parser par;
	private Person person = null;

	Serverthreads(Socket client) throws IOException {
		this.inFromClient = new DataInputStream(client.getInputStream());
		this.outToClient = new DataOutputStream(client.getOutputStream());
		this.app = new App();
		this.db = new DBhandler();
	}

	private void logic() throws IOException {

		while (true) {
			message = inFromClient.readUTF();
			par = app.parse(message);

			command = par.getcommand();

			if (command.equals("post")) {
				person = app.jtoo(par.getjson_string());
				try {
					db.save(person);
					outToClient.writeUTF("success: {" + person.getusername() + "} successfully registered.");
				} catch (Exception e) {
					outToClient.writeUTF("error: duplicate username");
				}
			}
			if (command.equals("get")) {
				person = db.get(par.getjson_string());
				json_string = app.otoj(person);
				if (json_string.equals("null")) {
					outToClient.writeUTF("error: {" + par.getjson_string() + "} not found");
				} else
					outToClient.writeUTF(json_string);
				continue;
			}
			if (command.equals("delete")) {
				try {
					db.delete(par.getjson_string());
					outToClient.writeUTF("success: {" + par.getjson_string() + "} successfully deleted.");
				} catch (Exception e) {
					outToClient.writeUTF("error: {" + par.getjson_string() + "} not found");
				}
				continue;
			}
			if (command.equals("put")) {
				person = app.jtoo(par.getjson_string());
				try {
					db.update(person);
					outToClient.writeUTF("success: {" + person.getusername() + "} successfully updated.");
				} catch (Exception e) {
					outToClient.writeUTF("error: {" + person.getusername() + "} not found");
				}
				continue;
			}
		}

	}

	public void run() {

		try {
			logic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

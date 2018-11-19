package com.qarri.three_tier;

import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		App app = new App();
		Person person = new Person("firstname", "lastname", "mobile", "username", "password", "access_level");
		String json = "put:"+app.otoj(person);
		System.out.println(json);
		Parser parser = app.parse(json);
		Person p = app.jtoo(parser.getjson_string());
		System.out.println(parser.getcommand());
		System.out.println(p.toString());
		
	}

}

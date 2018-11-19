package com.qarri.three_tier;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	// Attributes.
	private ObjectMapper mapper;

	// Constructors.
	// Default no-parameter constructors.
	public App() {
        mapper = new ObjectMapper();
    }

	public String otoj(Person person) throws JsonProcessingException {
		return mapper.writeValueAsString(person);
	}

	public Person jtoo(String json_string) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(json_string, Person.class);
	}

	public StringBuilder BtoS(byte[] a) {
		if (a == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; a[i] != 0; i++) {
			sb.append((char) a[i]);
		}
		return sb;
	}

	public Parser parse(String str) {
		Parser par = new Parser();
		String split[] = str.split(":", 2);
		par.setcommand(split[0]);
		par.setjson_string(split[1]);
		return par;
	}

}

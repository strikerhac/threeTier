package com.qarri.three_tier;

public class Parser {
	private String command;
	private String json_string;
	
	public String getcommand(){
        return this.command;
    }

    //public method to set the age variable
    public void setcommand(String command){
        this.command = command;
    }
    
    public String getjson_string(){
        return this.json_string;
    }

    //public method to set the age variable
    public void setjson_string(String json_string){
        this.json_string = json_string;
    }
}

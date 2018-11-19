package com.qarri.three_tier;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Person{
	@Id
	public String username;
	public String first_name;
	public String last_name;
	public String mobile;
	public String password;
	public String access_level;
	
	public Person() {
		
	}
	
	public Person(String firstname, String lastname, String mobile, String username, String password, String access_level){
		this.first_name = firstname;
		this.last_name = lastname;
		this.mobile = mobile;
		this.username = username;
		this.password = password;	
		this.access_level = access_level;
	}
	
	public String getfirst_name(){
        return this.first_name;
    }

    //public method to set the age variable
    public void setfirst_name(String fname){
        this.first_name = fname;
    }
    public String getlast_name(){
        return this.last_name;
    }

    //public method to set the age variable
    public void setlast_name(String lname){
        this.last_name = lname;
    }
    public String getmobile(){
        return this.mobile;
    }

    //public method to set the age variable
    public void setmobile(String mobile){
        this.mobile = mobile;
    }
    public String getusername(){
        return this.username;
    }

    //public method to set the age variable
    public void setusername(String username){
        this.username = username;
    }
    
    public String getpassword(){
        return this.password;
    }

    //public method to set the age variable
    public void setpassword(String password){
        this.password = password;
    }
    
    public String getaccess_level(){
        return this.access_level;
    }

    //public method to set the age variable
    public void setaccess_level(String access_level){
        this.access_level = access_level;
    }
    @Override
    public String toString(){ 
	     return "First_Name: " + first_name + " Last_Name: " + last_name + " mobile: "
	            + mobile + " username: " + username + " password: " + password + " Access Level: "+ access_level+" " ;
	}

	 
}
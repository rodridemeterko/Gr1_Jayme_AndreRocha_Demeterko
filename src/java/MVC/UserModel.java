/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

public class UserModel {
	private long Id;
	private String name;
	private String user;
	private String password;
	
	public UserModel(){
		
	}
	
	public UserModel(String name,String user,String password){
		this.Id = 0;
		this.name = name;
		this.user = user;
		this.password = password;
	}
	public Long getId(){
		return Id;
	}
	public void setId(long Id){
		this.Id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

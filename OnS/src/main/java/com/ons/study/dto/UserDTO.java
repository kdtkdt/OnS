package com.ons.study.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
int id;
String user_email, password, nickname;
public UserDTO() {
	System.out.println("UserDTO 기본 생성자 호출");
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser_email() {
	return user_email;
}
public void setUser_email(String user_email) {
	this.user_email = user_email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}


}

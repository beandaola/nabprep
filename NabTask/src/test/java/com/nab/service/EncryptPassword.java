package com.nab.service;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptPassword {
	
	public static void main(String[] args) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword("shine");
		String txt = encryptor.encrypt("1234");
		System.out.println(txt);
	}
	
	
}

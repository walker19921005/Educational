package com.cjrj.edu.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
	private static final transient Logger log = Logger.getLogger(TestLog4j.class);

	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException,
			NoSuchAlgorithmException, UnsupportedEncodingException, BadPaddingException, NoSuchPaddingException {

		PropertyConfigurator.configure("src/log4j.properties");
		log.info("��¼��־��Ϣ�����ڿ���̨���");
		log.error("���Լ�¼������Ϣ���������Ϊ����");
	}
}

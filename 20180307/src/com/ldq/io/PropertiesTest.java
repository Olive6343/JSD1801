package com.ldq.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("jdbc1_1.propertise");
		Properties p = new Properties();
		p.load(is);
	}
}

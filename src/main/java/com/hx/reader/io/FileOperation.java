package com.hx.reader.io;

import java.io.File;
import java.io.IOException;

public class FileOperation {

	public static void main(String[] args) {
		File f = new File("F:\\dir.txt");
		try {
			f.createNewFile();
			f.mkdir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

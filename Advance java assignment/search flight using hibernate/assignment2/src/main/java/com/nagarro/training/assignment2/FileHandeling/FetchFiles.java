package com.nagarro.training.assignment2.FileHandeling;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

public class FetchFiles {
	public List<String> fetch() {
		String path = "C:\\Users\\manpreetsingh04\\OneDrive\\Desktop\\Assignment Links";
		FileFilter csvFilter = (File file) -> file.getName().endsWith(".csv");
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles(csvFilter);
		String filename;
		List<String> listOfAllFiles = new ArrayList<>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				filename = path + "\\" + file.getName();
				listOfAllFiles.add(filename);
			}
		}
		return listOfAllFiles;
	}

}

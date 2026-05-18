package com.betacom.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.betacom.interfaces.GeneralProcess;

public class SequentialManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin SequentialManager");
		String filePath = "/Users/gerard/Downloads/fileToRead.txt";
		String filePathOut = "/Users/gerard/Downloads/fileToWrite.txt";
		
		List<String> records = readFile(filePath);
		for (String record:records) {
			System.out.println(record);
		}
		
		List<String> rWrite = new ArrayList<String>();
		rWrite.add("write 1");
		rWrite.add("write 2");
		rWrite.add("write 3");
		rWrite.add("write 4");
 		rWrite.add("write 5");
		rWrite.add("write 6");
		rWrite.add("write 7");		
		rWrite.add("write 8");
		rWrite.add("write 9");
		rWrite.add("write 10");
		rWrite.add("write 11");

		System.out.println("Numero di righe scrite :" + writeFile(filePathOut, rWrite, false));
		
		
		return false;
	}

	private List<String> readFile(String path){
		List<String> r = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line = reader.readLine();
			while (line != null) {
				r.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return r;
	}
	
	private int writeFile(String path,List<String> inp) {
		int num = 0;
		File f = new File(path);
		
		if (f.exists()) {
			System.out.println("file :" + path + " exists");
			f.delete();
		}
		try (FileWriter o = new FileWriter(f)){
			
			for (String rec:inp) {
				o.write(rec);
				o.write("\n");
				num++;
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return num;
	}
	/*
	 * mode = true -> extend file
	 *      = false -> replace
	 */
	private int writeFile(String path,List<String> inp, boolean mode) {
		int num = 0;
		
		try (FileWriter o = new FileWriter(path, mode)){
			
			for (String rec:inp) {
				o.write(rec);
				o.write("\n");
				num++;
			}
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return num;
	}
}

package com.file_handling_utility;

import java.io.*;
import java.util.Scanner;

public class FileHandler {
public static void writeFile(String fileName,String content) {
	try(FileWriter writer=new FileWriter(fileName)){
		writer.write(content);
		System.out.println("Your content was written successfully into the file");
	}
	catch(IOException e) {
		System.out.println("Error writing file : "+e.getMessage());	
	}
}
public static void readFile(String fileName) {
	try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
		String line;
		System.out.println("\nContent in the file is : ");
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
	}
	catch(IOException e) {
		System.out.println("Error reading file : "+e.getMessage());
	}
}
public static void appendFile(String fileName,String content) {
	try(FileWriter writer=new FileWriter(fileName,true)){
		writer.write("\n"+content);
		System.out.println("The new content was appended into file successfully");
	}
	catch(IOException e) {
		System.out.println("Error appending file : "+e.getMessage());
	}
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the file name (with .txt extension) to create : ");
	String fileName=sc.nextLine();
	File file=new File(fileName);
	try {
		if(file.exists()) {
			System.out.println("File is already exists : "+fileName);
		}
		else {
			if(file.createNewFile()){
				System.out.println("New file was created successfully : "+fileName);
			}
		}
	}
	catch(IOException e) {
		System.out.println("Error handling file : "+e.getMessage());
	}
	while(true) {
		System.out.println("\nChoose an operation to perform : ");
		System.out.println("1.Write (over-write file)");
		System.out.println("2.Append (add to file)");
		System.out.println("3.Read (displays file content)");
		System.out.println("4.Exit");
		System.out.print("Enter your choice : ");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:System.out.println("Enter text to over-write into the file : ");
		String writeContent=sc.nextLine();
		writeFile(fileName,writeContent);
		break;
		case 2:System.out.println("Enter text to append into the file : ");
		String appendContent=sc.nextLine();
		appendFile(fileName,appendContent);
		break;
		case 3:readFile(fileName);
		break;
		case 4:System.out.println("Exiting program....");
		sc.close();
		return;
		default:System.out.println("Invalid choice, please try again.");
		}
	}
}
}

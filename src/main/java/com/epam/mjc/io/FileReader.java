package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {


    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0;

        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int ch;
            while ((ch = fileInputStream.read()) != -1){
                //System.out.print((char)ch);
                if((char)ch != '\r'){
                    stringBuilder.append((char)ch);
                }
                else {
                    String[] strings = stringBuilder.toString().split(": ");

                    if(strings[0].equalsIgnoreCase("name"))
                        name = strings[1];
                    else if(strings[0].equalsIgnoreCase("\nage"))
                        age = Integer.parseInt(strings[1]);
                    else if(strings[0].equalsIgnoreCase("\nemail"))
                        email = strings[1];
                    else if(strings[0].equalsIgnoreCase("\nphone"))
                        phone = Long.parseLong(strings[1]);

                    stringBuilder = new StringBuilder();

                }
            }
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not exist");
        } catch (IOException e) {
            System.out.println("IO");
        }

        return new Profile(name, age, email, phone);
    }
}

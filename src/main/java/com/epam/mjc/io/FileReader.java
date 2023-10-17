package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FileReader {

    public Profile getDataFromFile(File file){
        List<String> data = new ArrayList<>();
        String lines;
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            while ((lines = Objects.requireNonNull(bufferedReader).readLine()) != null) {
                String[] strings = lines.split(" ");
                data.add(strings[1]);
                i++;
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return new Profile(data.get(0),Integer.parseInt(data.get(1)),data.get(2),Long.parseLong(data.get(3)));
    }
}
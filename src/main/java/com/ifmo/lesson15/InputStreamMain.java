package com.ifmo.lesson15;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamMain {

    private String readToString(File file) throws IOException{
        try(FileInputStream in = new FileInputStream(file); ByteArrayOutputStream bout = new ByteArrayOutputStream()){
            byte [] b = new byte[1024];
        }



        return null;
    }
    public static void main(String[] args) {


    }
}

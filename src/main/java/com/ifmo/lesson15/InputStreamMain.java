package com.ifmo.lesson15;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class InputStreamMain {

    private String readToString(File file) throws IOException{
        try(FileInputStream in = new FileInputStream(file); ByteArrayOutputStream bout = new ByteArrayOutputStream()){
            byte [] b = new byte[1024];
        }

        return null;
    }
    public static void main(String[] args) throws IOException {
    RandomInputStream ra = new RandomInputStream(new Random(),100);
        byte[] bytes = ra.readAllBytes();
        System.out.println(Arrays.toString(bytes));

        SawInputStream sa = new SawInputStream(7,19);
        bytes = sa.readAllBytes();
        System.out.println(Arrays.toString(bytes));


    }
}

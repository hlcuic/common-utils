package com.hello.io;

import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/demo.text");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("fasfdsafasfsafsfsdfsdfsdfdsfsdfdsfsdfsdfdsfsdfffffffff");
        bw.close();
    }
}

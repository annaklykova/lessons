package com.ifmo.lesson15;

import java.io.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/*
    Реализуйте все методы с использованием потоков ввода-вывода.
 */
public class IOStreamTasks {
    public static void main(String[] args) throws IOException {
        File src = new File("/Users/ankly/IdeaProjects/lessons/src/main/resources/test.txt");
        File dst = new File("/Users/ankly/IdeaProjects/lessons/src/main/resources/wap2.txt");
        File dstDir = new File("/Users/ankly/IdeaProjects/lessons/src/main/resources/files/");
        File dstFile = new File("/Users/ankly/IdeaProjects/lessons/src/main/resources/newFile");

        try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
            copy(in, out);
        }
        List<File> files = split(src,dstDir,2);
        System.out.println(files);

        assembly(files,dstFile);
    }

    public static void copy(InputStream src, OutputStream dst) throws IOException {
        // TODO implement

            byte[] buf = new byte[1024];
            int len;
            while ((len = src.read(buf)) > 0)
                dst.write(buf, 0, len);
    }

    /**
     * Последовательно разбивает файл на несколько более мелких, равных
     * указанному размеру. Последний файл может быть меньше задданого
     * размера.
     *
     * @param file Файл, который будет разбит на несколько.
     * @param dstDir Директория, в которой будут созданы файлы меньшего размера.
     * @param size Размер каждого файла-части, который будет создан.
     * @return Список файлов-частей в том порядке, в котором они должны считываться.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static List<File> split(File file, File dstDir, int size) throws IOException {
        List<File> files = new ArrayList<>();
        int numberSymbol = 0;

        int filesQuantity = (int) (file.length() % size == 0 ? file.length() / size : file.length() / size + 1);
        int lastSize = (int) (file.length() % size == 0 ? size : file.length() % size);
        System.out.println(filesQuantity);
        System.out.println(file.length());
        dstDir.mkdir();

        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
        for (int i = 0; i < filesQuantity; i++) {
            File fOut = new File(dstDir+"/f"+i+".txt");
            try (RandomAccessFile rafOut = new RandomAccessFile(fOut, "rw")) {
                raf.seek(numberSymbol);
            if (i == filesQuantity-1) size = lastSize;

                byte[] buf = new byte[size];
                int len = raf.read(buf);
                rafOut.write(buf, 0, len);

                numberSymbol = numberSymbol + size;
                System.out.println(fOut.length());
                files.add(fOut);
            }
        }
        }
            return files;
    }

    /**
     * Собирает из частей один файл.
     *
     * @param files Список файлов в порядке чтения.
     * @param dst Файл, в который будут записаны все части.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void assembly(List<File> files, File dst) throws IOException {

        int numberSymbol = 0;
        try (RandomAccessFile rafNew = new RandomAccessFile(dst, "rw")) {
            for (int i = 0; i < files.size(); i++) {
                try (RandomAccessFile rafOut = new RandomAccessFile(files.get(i), "r")) {
                    rafNew.seek(numberSymbol);
                    byte[] buf = new byte[(int)files.get(i).length()];
                    rafOut.read(buf);
                    rafNew.write(buf);
                    System.out.println(dst.length());
                    numberSymbol = numberSymbol + (int)files.get(i).length();
                }
            }
        }
        System.out.println(dst.length());
    }

    /**
     * Шифрует/дешифрует поток с помощью XOR. В качестве ключа используется пароль.
     *
     * @param src Входящий поток, данные которого будут зашифрованы/расшифрованы.
     * @param dst Выходящий поток, куда будут записаны зашифрованные/расшифрованные данные.
     * @param passphrase Пароль.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(InputStream src, OutputStream dst, String passphrase) throws IOException {

    }

    /**
     * Шифрует/дешифрует файл с помощью файла-ключа.
     *
     * @param src Файл, который должен быть зашифрован/расшифрован.
     * @param dst Файл, куда будут записаны зашифрованные/расшифрованные данные.
     * @param key Файл-ключ.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(File src, File dst, File key) throws IOException {

    }
}

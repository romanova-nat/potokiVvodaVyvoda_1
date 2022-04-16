package ru.netoligy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] dir = {"src", "res", "savegames", "temp"};
        String[] dirScr = {"main", "test"};
        String[] failSrcMain = {"Main.java", "Utils.java"};
        String[] dirRes = {"drawables", "vectors", "icons"};
        String[] failTemp = {"temp.txt"};

        StringBuilder stringBuilder = new StringBuilder();

        dirCreate(dir, "D:\\Ystanovka_JavaCore_1.1\\src\\ru\\netoligy\\Games\\", stringBuilder);
        dirCreate(dirScr, "D:\\Ystanovka_JavaCore_1.1\\src\\ru\\netoligy\\Games\\src\\", stringBuilder);
        dirCreate(dirRes, "D:\\Ystanovka_JavaCore_1.1\\src\\ru\\netoligy\\Games\\res\\", stringBuilder);

        fileCreate(failSrcMain, "D:\\Ystanovka_JavaCore_1.1\\src\\ru\\netoligy\\Games\\src\\main\\", stringBuilder);
        fileCreate(failTemp, "D:\\Ystanovka_JavaCore_1.1\\src\\ru\\netoligy\\Games\\temp\\", stringBuilder);
    }

    public static void dirCreate(String[] dir, String adress, StringBuilder stringBuilder) {
        for (int i = 0; i < dir.length; i++) {
            String inputAdress = adress + dir[i];
            File file = new File(inputAdress);
            String massage = null;
            if (file.mkdir()) {
                massage = "Каталог " + dir[i] + " создан. \n";
            }
            stringBuilder.append(massage);
        }
    }

    public static void fileCreate(String[] failTemp, String adress, StringBuilder stringBuilder) throws IOException {
        for (int i = 0; i < failTemp.length; i++) {
            String inputAdress = adress + failTemp[i];
            File file = new File(inputAdress);
            String massage = null;
            try {
                if (file.createNewFile()) {
                    massage = "Файл " + failTemp[i] + " создан. \n";
                }
                stringBuilder.append(massage);
            } catch (IOException e) {
                stringBuilder.append("Файл \" + i +  \" НЕ создан. \\n");
            }
        }

        try {
            FileWriter fileWriter = new FileWriter("D:\\Ystanovka_JavaCore_1.1\\src\\ru\\netoligy\\Games\\temp\\temp.txt");
            fileWriter.write(String.valueOf(stringBuilder));
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Не записано");
        }
    }
}


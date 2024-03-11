package ru.igor.dm.lesson7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

/*Считать оба CSV файла и объединить их по полю ID в один result.csv,
 где будут следующие поля: ID,NAME,PRICE.

Желательно реализовать доп. функционал:
Если для каких-то ID не будет значений в обоих файлах, то записать их
в один файл errors.csv, где будет лишь одно поле ID.*/

    public static void main(String[] args) throws IOException {

        File filePrice = Path.of("src", "main", "java", "ru", "igor", "dm", "lesson7", "items-price.csv").toFile();
        File fileName = Path.of("src", "main", "java", "ru", "igor", "dm", "lesson7", "items-name.csv").toFile();
        File fileResult = Path.of("src", "main", "java", "ru", "igor", "dm", "lesson7", "result.csv").toFile();
        File fileErrors = Path.of("src", "main", "java", "ru", "igor", "dm", "lesson7", "errors.csv").toFile();

        List<String> listPrice = new ArrayList<>();
        List<String> listName = new ArrayList<>();
        List<String> listResult = new ArrayList<>();
        List<String> listErrorsName = new ArrayList<>();
        List<String> listErrorsPrice = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String result;
            while ((line = reader.readLine()) != null) {
                String checkLine = line.substring(2);
                if (checkLine.isBlank()) {
                    listErrorsName.add(line);
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == ',') {
                            for (int j = i + 1; j < line.length(); j++) {
                                if (line.charAt(j) == ',') {
                                    result = line.substring(0, j);
                                    listName.add(result);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePrice))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String checkLine = line.substring(2);
                if (checkLine.isBlank()) {
                    listErrorsPrice.add(line);
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == ',') {
                            listPrice.add(line.substring(i + 1));
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < listPrice.size(); i++) {
                listResult.add(listName.get(i) + "," + listPrice.get(i));
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileResult))) {
                for (String s : listResult) {
                    writer.write(s);
                    writer.newLine();
                }
            }


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileErrors))) {
                for (int i = 0; i < listErrorsName.size(); i++) {
                    if (listErrorsName.get(i).equals(listErrorsPrice.get(i))) {
                        writer.write(listErrorsName.get(i));
                        writer.newLine();
                    }
                }

            }
        }
    }
}


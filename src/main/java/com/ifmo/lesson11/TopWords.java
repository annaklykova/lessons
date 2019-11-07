package com.ifmo.lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TopWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("/Users/ankly/IdeaProjects/lessons/src/main/resources/wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        System.out.println();
        System.out.println(top10Words(words));
        System.out.println(top10Phrases(words));
        System.out.println(charactersFrequency(words));
    }

    public static Map<String, Integer> top10Words(List<String> lines) {
        // todo implement
        Map<String,Integer> mapW = new HashMap<>();
        for (String line : lines) {
            if (!mapW.containsKey(line)) mapW.put(line, 1);
            else mapW.replace(line, mapW.get(line) + 1);
        }
        return topMap(mapW);
    }

    public static Map<String, Integer> top10Phrases(List<String> words) {
        // todo implement
        Map<String,Integer> mapW = new HashMap<>();
        for (int i = 0; i < words.size()-1; i++) {
            String newPhrase=words.get(i)+" "+words.get(i+1);
            if (!mapW.containsKey(newPhrase)) mapW.put(newPhrase,1);
            else mapW.replace(newPhrase, mapW.get(newPhrase) + 1);
        }
        return topMap(mapW);
    }

    public static Map<Character, Integer> charactersFrequency(List<String> words) {
        // todo implement
        Map<Character,Integer> mapW = new HashMap<>();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                Character ch = word.charAt(j);
                if (!mapW.containsKey(word.charAt(j))) mapW.put(ch, 1);
                else mapW.replace(ch, mapW.get(ch) + 1);
            }
        }
        return mapW;
    }

    public static Map<String,Integer> topMap(Map<String, Integer> mapW){
        List<Integer> integerList = new ArrayList<>(mapW.values());
        integerList.sort(Comparator.reverseOrder());
        Map<String,Integer> topMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<String, Integer> entry : mapW.entrySet()) {
                if (integerList.get(i) == entry.getValue()) topMap.put(entry.getKey(),entry.getValue());
            }
        }
        return topMap;
    }
}

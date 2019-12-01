package com.ifmo.lesson21;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TopWordsThreads {
public static Map<String,Integer> wordTotalMap = new HashMap<>();
public static final Object monitor = new Object();

    public static void main(String[] args) throws IOException, InterruptedException {
        final int p = Runtime.getRuntime().availableProcessors();

        File text = new File("/Users/ankly/IdeaProjects/lessons/src/main/resources/wap.txt");
        List<String> lines = Files.readAllLines(text.toPath());
        List<String> words = words(lines);

        List<ProcessorThread> threads = new ArrayList<>();
        int size = words.size()/p;
        for (int i = 0; i < p; i++) {
            List<String> partWords;
            if (i == (p-1)) partWords = new ArrayList<>(words.subList(i*size, words.size()));
            else partWords = new ArrayList<>(words.subList(i*size, size*(i+1)));
            threads.add(new ProcessorThread(partWords));
        }
        for (ProcessorThread t: threads) {
            t.start();
        }
        for (ProcessorThread t: threads) {
            t.join();
        }
        System.out.println(topMap(wordTotalMap,10));
    }

    private static List<String> words(List<String> lines){
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit =
                    line.toLowerCase()
                            .replaceAll("\\p{Punct}", " ")
                            .trim()
                            .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }
        return words;
    }

    public static class ProcessorThread extends Thread {
        private final Map<String,Integer> wordMap = new HashMap<>();;
        private final List<String> words;

        public ProcessorThread(List<String> words) {
            this.words = words;
        }
        private  synchronized void mergeMap(){
            synchronized (monitor) {
                wordMap.forEach((k,v) -> {
                    if (wordTotalMap.containsKey(k)) {
                        wordTotalMap.replace(k, wordTotalMap.get(k) + v);
                    } else {
                        wordTotalMap.put(k, v);
                    }
                });
            }
        }
        @Override
        public void run() {
            for (String w : words) {
                if (!wordMap.containsKey(w)) wordMap.put(w, 1);
                else wordMap.replace(w, wordMap.get(w) + 1);
            }
            mergeMap();
        }
    }

    private static Map<String,Integer> topMap(Map<String, Integer> mapW, int top){
        List<Integer> integerList = new ArrayList<>(mapW.values());
        integerList.sort(Comparator.reverseOrder());
        Map<String,Integer> topMap = new HashMap<>();
        for (int i = 0; i < top; i++) {
            for (Map.Entry<String, Integer> entry : mapW.entrySet()) {
                if (integerList.get(i) == entry.getValue()) topMap.put(entry.getKey(),entry.getValue());
            }
        }
        return topMap;
    }

}

//top
//{the=34302, a=10413, that=7713, his=7957, in=8967, and=21835, of=14974, to=16632, he=9671, ”=8615}
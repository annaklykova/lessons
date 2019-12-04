package lesson22;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QMain{
public static final String POISON_PILL = new String();
    public static void main(String[] args) throws IOException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        BlockingQueue<Map<String,Integer>> resultQueue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(queue,resultQueue);
        Worker w1 = new Worker(queue,resultQueue);
        Worker w2 = new Worker(queue,resultQueue);
        Worker w3 = new Worker(queue,resultQueue);
        Worker w4 = new Worker(queue,resultQueue);

        producer.start();
        w1.start();
        w2.start();
        w3.start();
        w4.start();
    }

    public static class Producer extends Thread {
        Map<String,Integer> wordTotalMap = new HashMap<>();
        File text = new File("/Users/ankly/IdeaProjects/lessons/src/main/resources/wap.txt");
        List<String> lines = Files.readAllLines(text.toPath());
        List<String> words = words(lines);

        private final BlockingQueue<String> linesQueue;
        BlockingQueue<Map<String,Integer>> resultQueue;


        public Producer(BlockingQueue<String> linesQueue, BlockingQueue<Map<String,Integer>> resultQueue) throws IOException {
            this.linesQueue = linesQueue;
            this.resultQueue = resultQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < words.size(); i++) {
                linesQueue.offer(words.get(i));
            }
            linesQueue.offer(POISON_PILL);

            for (int i = 0; i < 4; i++) {
                Map<String,Integer> map = null;
                try {
                    map = resultQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.forEach((k,v) -> {
                    if (wordTotalMap.containsKey(k)) {
                        wordTotalMap.replace(k, wordTotalMap.get(k) + v);
                    } else {
                        wordTotalMap.put(k, v);
                    }
                });
            }
            System.out.println(topMap(wordTotalMap,10));
        }
    }

    public static class Worker extends Thread {
        private final BlockingQueue<String> linesQueue;
        private final BlockingQueue<Map<String,Integer>> resultQueue;
        private final Map<String,Integer> wordMap = new HashMap<>();

        public Worker(BlockingQueue<String> linesQueue,BlockingQueue<Map<String,Integer>> resultQueue) {
            this.linesQueue = linesQueue;
            this.resultQueue = resultQueue;
        }
        @Override
        public void run() {
            while (!isInterrupted()){
                String word = null;
                try {
                    word = linesQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (word == POISON_PILL) {
                    linesQueue.offer(word);
                    resultQueue.offer(wordMap);
                    interrupt();
                }
                else {
                    if (!wordMap.containsKey(word)) wordMap.put(word, 1);
                    else wordMap.replace(word, wordMap.get(word) + 1);
                }
            }
        }
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

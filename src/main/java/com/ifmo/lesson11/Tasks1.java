package com.ifmo.lesson11;

import com.ifmo.lesson11.inner.Message;
import com.ifmo.lesson11.inner.MessageGenerator;
import com.ifmo.lesson11.inner.MessagePriority;

import java.util.*;

/**
 * Created by xmitya on 17.10.16.
 */
public class Tasks1 {

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(100);

        countEachPriority(messages);
        countCountEachCode(messages);
        countUniqueMessages(messages);

        System.out.println("Genuine messages in natural order: \n" + genuineMessagesInOriginalOrder(messages));

        removeEach(generator.generate(100), MessagePriority.LOW);
        removeOther(generator.generate(100), MessagePriority.URGENT);
    }

    private static void countEachPriority(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого приоритета.
        // Ответ необходимо вывести в консоль.
        Map<MessagePriority,Integer> priorityMap = new HashMap<>();
        messages.stream().map(Message::getPriority).forEach(priority -> {
            if (priorityMap.containsKey(priority)) {
                priorityMap.replace(priority, priorityMap.get(priority) + 1);
            } else {
                priorityMap.put(priority, 1);
            }
        });
        System.out.println(priorityMap);
    }

    private static void countCountEachCode(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого кода сообщения.
        // Ответ необходимо вывести в консоль.
        Map<Integer,Integer> codeMap = new HashMap<>();
        messages.stream().map(Message::getCode).forEach(code ->{
            if (codeMap.containsKey(code)){
                codeMap.replace(code,codeMap.get(code)+1);
            } else {
                codeMap.put(code,1);
            }
        });
        System.out.println(codeMap);
    }

    private static void countUniqueMessages(List<Message> messages) {
        // Сосчитайте количество уникальных сообщений.
        // Ответ необходимо вывести в консоль.
        List<Message> uniqueList = new ArrayList<>();
        for (Message m : messages) {
            if (!uniqueList.contains(m)) uniqueList.add(m);
        }
        System.out.println(uniqueList.size());
    }

    private static List<Message> genuineMessagesInOriginalOrder(List<Message> messages) {
        // Здесь необходимо вернуть только неповторяющиеся сообщения и в том порядке, в котором
        // они встречаются в первоначальном списке. Например, мы на входе имеем такие сообщения:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}],
        // то на выходе должны получить:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}].
        // Т.е. остались только уникальные значения, и порядок их поступления сохранен.
        List<Message> uniqueList = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            if (!uniqueList.contains(messages.get(i))) uniqueList.add(messages.get(i));
        }
        System.out.println(uniqueList);
        System.out.println(uniqueList.size());
        return uniqueList;
    }

    private static void removeEach(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции каждое сообщение с заданным приоритетом.
        System.out.printf("Before remove each: %s, %s\n", priority, messages);
        messages.removeIf(message -> priority.equals(message.getPriority()));
        System.out.printf("After remove each: %s, %s\n", priority, messages);
    }

    private static void removeOther(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет.
        System.out.printf("Before remove other: %s, %s\n", priority, messages);
        messages.removeIf(message -> !priority.equals(message.getPriority()));
        System.out.printf("After remove other: %s, %s\n", priority, messages);
    }
}

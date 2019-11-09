package com.ifmo.lesson11;

import com.ifmo.lesson11.inner.Message;
import com.ifmo.lesson11.inner.MessageGenerator;
import com.ifmo.lesson11.inner.MessagePriority;
import com.ifmo.lesson11.inner.User;

import java.util.*;

import static com.ifmo.lesson11.inner.UserGenerator.generate;

/**
 * Created by xmitya on 20.10.16.
 */
public class Tasks2 {
    public static void main(String[] args) {
        List<User> userList = generate(5);
        System.out.println(userList);
        System.out.println(sortedByCompanyAndName(userList));
        System.out.println(sortedBySalaryAndName(userList));
        System.out.println(sortedBySalaryAgeCompanyAndName(userList));

        MessageGenerator generator = new MessageGenerator();
        List<Message> messages = generator.generate(10);
        sortByPriority(messages);
        System.out.println(messages);
    }

    private static void sortByPriority(List<Message> messages) {
        messages.sort((o1, o2) -> Integer.compare(o2.getPriority().ordinal(),o1.getPriority().ordinal()));
    }

    private static NavigableSet<User> sortedByCompanyAndName(List<User> users) {
        Comparator<User> comp = new UserCompanyComparator().thenComparing(new UserNameComparator());
        NavigableSet<User> us = new TreeSet<>(comp);
        us.addAll(users);
        return us;
    }

    private static NavigableSet<User> sortedBySalaryAndName(List<User> users) {
        Comparator<User> comp = new UserSalaryComparator().thenComparing(new UserNameComparator());
        NavigableSet<User> us = new TreeSet<>(comp);
        us.addAll(users);
        return us;
    }

    private static NavigableSet<User> sortedBySalaryAgeCompanyAndName(List<User> users) {
        Comparator<User> comp = new UserSalaryComparator()
                                           .thenComparing(new UserAgeComparator()
                                           .thenComparing(new UserNameComparator()));
        NavigableSet<User> us = new TreeSet<>(comp);
        us.addAll(users);
        return us;
    }

    private static <T> Iterator<T> viewIterator(Iterable<T> it1, Iterable<T> it2) {
        return null;
    }

    public static class UserCompanyComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2){
            int result = user1.getCompany().compareTo(user2.getCompany());
            return (result != 0) ? (int)(result/Math.abs(result)) : 0;
        }
    }
    public static class UserNameComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2){
            int result = user1.getName().compareTo(user2.getName());
            return (result != 0) ? (int)(result/Math.abs(result)) : 0;
        }

    }
    public static class UserAgeComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2){
            return Integer.compare(user1.getAge(), user2.getAge());
        }

    }
    public static class UserSalaryComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2){
            return Integer.compare(user1.getSalary(), user2.getSalary());
        }
    }
}

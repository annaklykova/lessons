package com.ifmo.lesson24;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {
    private static Map<Long, User> users = new ConcurrentHashMap<>();
    private static List<Account> accounts = new CopyOnWriteArrayList<>();
    private static BlockingQueue<Transaction> transactionQueue =new LinkedBlockingQueue<>();
//    BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue<>();
    static final Object monitor = new Object();

    private static class User {
        private final long id;
        private final String name;

        private User(long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static class Account {
//        static final Object monitor = new Object();

        private final long id;
        private final long userId;
        private long amount;

        private Account(long id, long userId, long amount) {
            this.id = id;
            this.userId = userId;
            this.amount = amount;
        }
    }

    private static class Transaction {
        private final BigInteger transactionId;
        private final long fromAccountId;
        private final long toAccountId;
        private final long amount;
        private final boolean success;

        private Transaction(long fromAccountId, long toAccountId, long amount, boolean success) {
            this.success = success;
            this.transactionId = new BigInteger("" + System.currentTimeMillis() + fromAccountId + toAccountId + amount);
            this.fromAccountId = fromAccountId;
            this.toAccountId = toAccountId;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "transactionId=" + transactionId +
                    ", fromAccountId=" + fromAccountId +
                    ", toAccountId=" + toAccountId +
                    ", amount=" + amount +
                    ", success=" + success +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Logger logger = new Logger(transactionQueue);
        logger.start();
        User user1 = new User(123,"Petya");
        User user2 = new User(456,"Vanya");
        User user3 = new User(789,"Lesha");
        users.put(user1.id,user1);
        users.put(user2.id,user2);
        users.put(user3.id,user3);
        Account account1 = new Account( 12345,123,3000);
        Account account2 = new Account(2345,123,5000);
        Account account3 = new Account(4365476,123,3000);
        Account account4 = new Account(465464,456,7000);
        Account account5 = new Account(456544634,456,3000);
        Account account6 = new Account(11111,789,8000);
        Account account7 = new Account(333,789,3000);
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        accounts.add(account6);
        accounts.add(account7);
        for (Account a: accounts) {
            System.out.println(a.id +" "+a.amount);
        }

        List<Thread> threads = new ArrayList<>();
        threads.add(logger);

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(){
                Random rnd = new Random();
                int accountFrom = generateInRange(1,accounts.size()-1,rnd);
                int accountTo = generateInRange(1,accounts.size()-1,rnd);
                int amount = generateInRange(1, 4000,rnd);
                @Override
                public void run() {
                    transferMoney(accounts.get(accountFrom),accounts.get(accountTo),amount);
                }
            };
            thread.start();
            threads.add(thread);
        }

        //потоки висят, не завершаются
        for (Thread t: threads) t.join(0);
        for (Thread t: threads) t.interrupt();




        // 1. Сгенерируйте пользователей и их аккаунты (все идентификаторы должны быть уникальны).
        // 2. Переводите деньги со случайного аккаунта на случайный в 100 потоках.
        // Другими словами, создайте 100 потоков или пул из 100 потоков, в которых
        // выполните перевод вызовом метода transferMoney().



    }

    // TODO Самая главная часть работы!
    public static void transferMoney(Account from, Account to, long amount) {

        synchronized (monitor){
            Transaction transaction;
            boolean success;
            if (amount>from.amount || from.id==to.id) {
                success = false;
            }
            else {
                from.amount=from.amount-amount;
                to.amount = to.amount+amount;
                success = true;
            }
            transaction = new Transaction(from.id,to.id,amount,success);
            transactionQueue.offer(transaction);
        }
    }
        // 1. Атомарно и потокобезопасно перевести деньги в количестве 'amount' со счёта 'from' на счёт 'to'.
        // 2. Создать объект Transaction, содержащий информацию об операции и отправить в очередь
        // потоку Logger, который проснётся и напечатает её.

    static class Logger extends Thread {
    int count = 0;
        private final BlockingQueue<Transaction> transactionQueue;

        Logger(BlockingQueue<Transaction> transactionQueue) {
            this.transactionQueue = transactionQueue;
        }
        @Override
        public void run() {
            while (!isInterrupted()) {
                Transaction transaction = null;
                try {
                    transaction = transactionQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(transaction);
                count++;
                System.out.println(count);
            }
        }

    }
    private static int generateInRange(int min, int max, Random rnd) {
        int res = -1;
        while (res < min)
            res = rnd.nextInt(max + 1);
        return res;
    }
    }


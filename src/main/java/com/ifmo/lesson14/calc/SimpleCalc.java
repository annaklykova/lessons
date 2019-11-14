package com.ifmo.lesson14.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Добавьте поддержку переменных.
 * Синтаксис следующий.
 * Объявление переменной через символ '=':
 * x = 8
 *
 * Имя переменной не может быть числом.
 *
 * Использование в выражении вместо одного или двух аргументов:
 * x + 2
 * Результат: 10.
 *
 * Калькулятор должен выбрасывать соответствующие исключения с
 * подробными описаниями ошибок и как их исправить. Например,
 * если имя переменной не найдено или использовался неверный синтаксис.
 */
public class SimpleCalc {
    static Map<String,Integer> map = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();

            if ("exit".equals(line))
                break;

            try {
                System.out.println("Answer is: " + calculate(line));
            }
            catch (CalcException e) {
                System.err.println("Error occurred: ");

                e.printStackTrace();
            }
        }
    }

    static int calculate(String line) throws CalcException {

        int op1;
        int op2;

        String[] operands = line.split(" ");
        if (line.contains("=")) {
            if (operands.length != 3)
                throw new CalcException("Expression must have only 3 operands separated with space (e.g. a = 4): " + line);
            try {
                parseOperand(operands[0]);
            } catch (CalcException e) {
                map.put(operands[0], parseOperand(operands[2]));
                System.out.println(map);
                return parseOperand(operands[2]);
        }
            throw new CalcException("Expression with = must not have int parameters (e.g. a = 4): " + line);
        }


            else {
            if (!line.contains("+") && !line.contains("-"))
                throw new CalcException("Expression must contain '+' or '-': " + line);


            if (operands.length != 3)
                throw new CalcException("Expression must have only 3 operands separated with space (e.g. 2 + 4): " + line);

            OPERATOR operator = OPERATOR.parse(operands[1]);
            try {
                op1 = parseOperand(operands[0]);
            } catch (CalcException e){
              if (map.containsKey(operands[0])) {
                  System.out.println(map.get(operands[0]));
                  op1 = map.get(operands[0]);
              } else throw new CalcException("param not found " + line);
            }
            try {
                 op2 = parseOperand(operands[2]);
            } catch (CalcException e){
                if (map.containsKey(operands[2])) {
                    System.out.println(map.get(operands[2]));
                    op2 = map.get(operands[2]);
                } else throw new CalcException("param not found " + line);
            }


            return operator.apply(op1, op2);
        }
    }

    private static int parseOperand(String string) throws CalcException {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            throw new CalcException("Wrong operand, must be only integer number: " + string, e);
        }
    }

    private enum OPERATOR {
        PLUS, MINUS;

        int apply(int arg1, int arg2) throws CalcException {
            switch (this) {

                case PLUS:
                    return arg1 + arg2;

                case MINUS:
                    return arg1 - arg2;
            }

            throw new CalcException("Unsupported operator: " + this);
        }

        static OPERATOR parse(String str) throws CalcException {
            switch (str) {
                case "+":
                    return PLUS;

                case "-":
                    return MINUS;
            }

            throw new CalcException("Incorrect operator: " + str);
        }
    }
}

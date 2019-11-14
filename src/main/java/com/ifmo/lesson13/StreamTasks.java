package com.ifmo.lesson13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class StreamTasks {

    private static final List<String> COUNTRIES = Arrays.asList("Russia", "France", "Great Britain", "Germany", "Spain");
    private static final List<String> NAMES = Arrays.asList("Bob", "Alice", "Nick", "Ted", "Anna", "David", "Zack", "Stacy", "Helen", "Julia");

    private static final int MIN_AGE = 1;
    private static final int MAX_AGE = 99;

    static class Person {
        final String name;
        final int age;
        final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        List<Person> people = generatePeople(100).collect(Collectors.toList());

        List<String> countries = countriesSortedByTheirPopulationDescending(people.stream());
        String countryThatHasMostKids = countryThatHasMostKids(people.stream());
        Map<String, Long> populationByCountry = populationByCountry(people.stream());

        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);
    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {

        return  people
                .collect(groupingBy(person -> person.country, counting()))
                .entrySet().parallelStream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Entry::getKey)
                .collect(Collectors.toList());

    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {


        return people.filter(p -> p.age < 18)
                .collect(groupingBy(p -> p.country,counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey).orElse("un");
    }

    // Метод возвращает карту стран их населения.
    public static Map<String, Long> populationByCountry(Stream<Person> people) {

        return people
                .collect(groupingBy(p -> p.country,counting()));
    }

    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static Stream<Person> generatePeople(int number) {
        List<Person> p = new ArrayList<>(number);

        Random rnd = new Random();

        for (int i = 0; i < number; i++) {
            p.add(new Person(
                    NAMES.get(rnd.nextInt(NAMES.size())),
                    generateInRange(MIN_AGE, MAX_AGE, rnd),
                    COUNTRIES.get(rnd.nextInt(COUNTRIES.size()))
            ));
        }

        return p.stream();
    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {

        HashMap<Integer, Set<String>> result = words
                .stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        HashMap::new,
                        Collectors.mapping(identity(),Collectors.toSet()))
                );

//                .stream()
//                .parallel()
//                .collect(HashMap::new,
//                        (map, word) -> {
//                            map.computeIfAbsent(word.length(), s -> new HashSet<>()).add(word);
//                        },
//                        (left, right) -> {
//                            for (HashMap.Entry<Integer, Set<String>> e : right.entrySet()) {
//                                left.merge(e.getKey(), e.getValue(),
//                                        (l1, l2) -> {
//                                            l1.addAll(l2);
//                                            return l1;
//                                        });
//                            }
//                        });

         return result;
    }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
         Integer sum = words.stream().map(String::length).reduce((a,b) -> (a+b))
                 .orElse(0);

        return sum/words.size();
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {

         return words.stream()
                 .collect(Collectors.groupingBy(
                         String::length,
                         HashMap::new,
                         Collectors.mapping(identity(),Collectors.toSet())))
                 .entrySet()
                 .stream()
                 .max(Comparator.comparingLong(Map.Entry::getKey))
                 .map(Map.Entry::getValue)
                 .orElse(null);


    }


    private static int generateInRange(int min, int max, Random rnd) {
        int res = -1;

        while (res < min)
            res = rnd.nextInt(max + 1);

        return res;
    }

    private static int round(int num, int roundTo) {
        return num / roundTo * roundTo;
    }
}

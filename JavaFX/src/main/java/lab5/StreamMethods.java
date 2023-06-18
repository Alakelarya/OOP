package lab5;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMethods {


    public static int getAverage(List<Integer> list) {
        return (int) list.stream()
                .mapToInt(e -> e).average()
                .orElse(0);
    }

    public static String getNew(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .collect(Collectors.joining());
    }

    public static List<Integer> getPow(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(x -> x * x)
                .toList();
    }

    public static List<String> getSortForAlphabet(List<String> list, String firstElement) {
        return list.stream()
                .filter(x -> x.startsWith(firstElement))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
    }

    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((x, y) -> y)
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> getEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .reduce((x, y) -> x + y)
                .stream().toList();
    }

    public static Map<String, String> getMap(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(x -> String.valueOf(x.charAt(0)), y -> y.substring(1)));
    }

}

package hiu.junyoung.hiuLib;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArrayUtil {
    private static final Random RANDOM = new Random();

    /**
     * 리스트를 time번 셔플하여 반환 (원본 불변)
     */
    public static <T> List<T> shuffle(List<T> arr, int time) {
        List<T> result = new ArrayList<>(arr);
        for (int i = 0; i < time; i++) {
            Collections.shuffle(result);
        }
        return result;
    }

    public static <T> List<T> shuffle(List<T> arr) {
        return shuffle(arr, 1);
    }

    /**
     * 리스트에서 무작위 요소 하나 반환, 비어있으면 null
     */
    public static <T> T getRandomElement(List<T> arr) {
        if (arr == null || arr.isEmpty()) return null;
        return arr.get(RANDOM.nextInt(arr.size()));
    }

    /**
     * 조건에 맞는 첫 번째 요소 반환, 없으면 null (JS Array.find() 동일)
     */
    public static <T> T find(List<T> arr, Predicate<T> callback) {
        for (T item : arr) {
            if (callback.test(item)) return item;
        }
        return null;
    }

    /**
     * 조건을 통과한 모든 요소를 담은 새 리스트 반환
     */
    public static <T> List<T> filter(List<T> arr, Predicate<T> callback) {
        List<T> result = new ArrayList<>();
        for (T item : arr) {
            if (callback.test(item)) result.add(item);
        }
        return result;
    }

    /**
     * 지정한 인덱스에 요소를 삽입한 새 리스트 반환 (원본 불변)
     */
    public static <T> List<T> addAt(List<T> arr, T obj, int index) {
        List<T> result = new ArrayList<>(arr);
        result.add(index, obj);
        return result;
    }

    /**
     * 지정한 인덱스의 요소를 제거한 새 리스트 반환 (원본 불변)
     */
    public static <T> List<T> removeAt(List<T> arr, int index) {
        List<T> result = new ArrayList<>(arr);
        result.remove(index);
        return result;
    }

    /**
     * 각 요소를 mapper 함수로 변환한 새 리스트 반환
     */
    public static <T, R> List<R> map(List<T> arr, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : arr) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public static <T> List<T> toList(Collection<T> collection) {
        return collection.stream().toList();
    }

    /**
     * 모든 요소를 delimiter로 이어 붙인 문자열 반환
     */
    public static <T> String join(List<T> arr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (T item : arr) {
            if (!sb.isEmpty()) sb.append(delimiter);
            sb.append(item.toString());
        }
        return sb.toString();
    }

    /**
     * 각 요소를 mapper로 변환 후 delimiter로 이어 붙인 문자열 반환
     */
    public static <T> String join(List<T> arr, Function<T, String> mapper, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (T item : arr) {
            if (!sb.isEmpty()) sb.append(delimiter);
            sb.append(mapper.apply(item));
        }
        return sb.toString();
    }
}

package info.pragmaticdeveloper.stream;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SortingMapTest {

    @Test
    void testSortMapByValuesDesc() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    @Test
    void testSortMapByValuesDescCollectionsComparator() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    @Test
    void testSortMapByValuesAscDefaultOrder() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    @Test
    void testSortMapByValuesAsc() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    @Test
    void testSortMapByKeysDesc() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    @Test
    void testSortMapByKeysAsc() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    @Test
    void testSortMapByKeysCollectionsComparatorDesc() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    @Test
    void testSortMapByKeysCollectionsComparatorAsc() {
        Map<Integer, String> userMap = createMap();
        Map<Integer, String> sortedUserMap = userMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (name1, name2) -> name2, LinkedHashMap::new));
        System.out.println("Before sorting :" + userMap);
        System.out.println("After sorting :" + sortedUserMap);
    }

    private Map<Integer, String> createMap() {
        Map<Integer, String> userMap = new HashMap<>();
        userMap.put(2, "Filex");
        userMap.put(4, "Eduard");
        userMap.put(1, "Camron");
        userMap.put(5, "Devender");
        userMap.put(3, "Alex");
        userMap.put(6, "Bob");
        userMap.put(7, "Bob");
        return userMap;
    }
}

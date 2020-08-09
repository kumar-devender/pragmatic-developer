package info.pragmaticdeveloper.planeseatallocation;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

public class PlaneSeatAllocator {
    private Predicate<String> notEmpty = str -> !str.isEmpty();
    private static List<Character> leftPossibleOccupancy = asList('B', 'C', 'D', 'E');
    private static List<Character> middlePossibleOccupancy = asList('D', 'E', 'F', 'G');
    private static List<Character> rightPossibleOccupancy = asList('F', 'G', 'H', 'J');

    public int solution(int N, String S) {
        Map<Integer, Set<Character>> occupiedSeatInEachRows = convertToSeat(S).stream()
                .collect(groupingBy(Seat::getRowNumber, mapping(Seat::getSeatLabel, toSet())));

        return IntStream.rangeClosed(1, N)
                .map(rowNumber ->
                        countPossibleSeatAllocationInRow(
                                occupiedSeatInEachRows.getOrDefault(rowNumber, new HashSet<>())
                        )
                ).sum();
    }

    private int countPossibleSeatAllocationInRow(Set<Character> reservedSeatOfRow) {
        return Stream.of(leftPossibleOccupancy, middlePossibleOccupancy, rightPossibleOccupancy)
                .filter(possibleOccupancy -> canReserve(possibleOccupancy, reservedSeatOfRow))
                .peek(newOccupancy -> allocateSeat(reservedSeatOfRow, newOccupancy))
                .mapToInt(occupied -> 1)
                .sum();
    }

    private void allocateSeat(Set<Character> reservedSeatOfRow, List<Character> newSeatAllocation) {
        reservedSeatOfRow.addAll(newSeatAllocation);
    }

    private boolean canReserve(List<Character> seatToBeReserve, Set<Character> reservedSeatOfRow) {
        return seatToBeReserve.stream()
                .noneMatch(reservedSeatOfRow::contains);
    }

    private List<Seat> convertToSeat(String reservedSeats) {
        return Arrays.stream(reservedSeats.split(" ")).sorted()
                .filter(notEmpty)
                .map(this::buildSeat)
                .collect(Collectors.toList());
    }

    private Seat buildSeat(String seat) {
        return new Seat(seat.charAt(1), Character.getNumericValue(seat.charAt(0)));
    }
}

package info.pragmaticdeveloper.dsa.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class TopHotelFinder {

    private static final int POSITIVE_REVIEW_SCORE = 3;
    private static final int NEGATIVE_REVIEW_SCORE = -1;

    public Integer[] find(int[] hotels, String[] reviews, String positiveKeywords, String negativeKeywords, int k) {
        var positive = convertToSet(positiveKeywords);
        var negative = convertToSet(negativeKeywords);
        var topHotels = new Integer[k];
        return IntStream.range(0, hotels.length)
                .boxed()
                // Calculate score for each review
                .map(index -> new Review(hotels[index], getReviewScore(reviews[index], positive, negative)))
                .collect(groupingBy(Review::getHotelId))
                .entrySet()
                .stream()
                // Sum all review scores for each hotel
                .collect(toMap(Map.Entry::getKey, e -> sumAllReviewScore(e.getValue())))
                .entrySet()
                .stream()
                // high review score should be on top so order by Total review score in reverse order. If review score is same for two hotel and lower id hotel will appear first so order by
                .sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed().thenComparingInt(Map.Entry::getKey))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).toArray(topHotels);
    }

    private int sumAllReviewScore(List<Review> reviews) {
        return reviews.stream()
                .mapToInt(Review::getReviewScore)
                .sum();
    }

    private int getReviewScore(String review, Set<String> positive, Set<String> negative) {
        return Arrays.stream(review.split(" "))
                .map(token -> {
                    if (positive.contains(token)) {
                        return POSITIVE_REVIEW_SCORE;
                    }
                    if (negative.contains(token)) {
                        return NEGATIVE_REVIEW_SCORE;
                    }
                    return 0;
                })
                .mapToInt(score -> score)
                .sum();
    }

    static class Review {
        private final int hotelId;
        private final int reviewScore;

        public Review(int hotelId, int reviewScore) {
            this.hotelId = hotelId;
            this.reviewScore = reviewScore;
        }

        public int getHotelId() {
            return hotelId;
        }

        public int getReviewScore() {
            return reviewScore;
        }
    }

    private Set<String> convertToSet(String positiveKeywords) {
        return Arrays.stream(positiveKeywords.split(" "))
                .collect(Collectors.toSet());
    }
}

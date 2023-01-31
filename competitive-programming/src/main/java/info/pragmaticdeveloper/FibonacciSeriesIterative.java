package info.pragmaticdeveloper;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSeriesIterative {

    public int generateSeries(int term) {
        final List<Integer> series = new ArrayList<>();
        series.add(0);
        series.add(1);
        for (int i = 2; i < term + 1; i++) {
            series.add(series.get(i - 2) + series.get(i - 1));
        }
        return series.get(term);
    }
}

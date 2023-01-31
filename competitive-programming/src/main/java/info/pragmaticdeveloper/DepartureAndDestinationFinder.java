package info.pragmaticdeveloper;

import java.util.*;
//https://tutorialhorizon.com/algorithms/departure-and-destination-cities-in-a-given-itinerary/
public class DepartureAndDestinationFinder {
    public static void main(String[] args) {
        List<List<String>> boardingPass = new ArrayList<>();
        List<String> bp1 = new ArrayList<>();
        bp1.add("Dallas");
        bp1.add("New York");
        boardingPass.add(bp1);
        List<String> bp2 = new ArrayList<>();
        bp2.add("Dallas");
        bp2.add("Austin");
        boardingPass.add(bp2);
        List<String> bp3 = new ArrayList<>();
        bp3.add("Austin");
        bp3.add("Dallas");
        boardingPass.add(bp3);
        List<String> bp4 = new ArrayList<>();
        bp4.add("New York");
        bp4.add("Seattle");
        boardingPass.add(bp4);
        List<String> bp5 = new ArrayList<>();
        bp5.add("Seattle");
        bp5.add("Houston");
        boardingPass.add(bp5);
        find(boardingPass);
    }

    static void find(List<List<String>> boardingPass) {
        List<String> source = new ArrayList<>();
        List<String> desti = new ArrayList<>();

        for (List<String> pass : boardingPass) {
            String src = pass.get(0);
            String destination = pass.get(1);

            if (!source.remove(destination)) {
                desti.add(destination);
            }
            if (!desti.remove(src)) {
                source.add(src);
            }
        }
        System.out.println(source);
        System.out.println(desti);
    }
}

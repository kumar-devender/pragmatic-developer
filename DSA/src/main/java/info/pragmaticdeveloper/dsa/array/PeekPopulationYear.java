package info.pragmaticdeveloper.dsa.array;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public class PeekPopulationYear {
    public int getPeekPopulationYear(Person[] persons) {
        int firstBirthYear = getBirthYear(persons, Integer::min);
        int lastBirthYear = getBirthYear(persons, Integer::max);
        int[] populationByYear = updatePopulationByYear(persons, firstBirthYear, lastBirthYear);
        int maxRunningSumIndex = getMaxRunningSumIndex(populationByYear);
        return firstBirthYear + maxRunningSumIndex;
    }

    private int getMaxRunningSumIndex(int[] populationByYear) {
        int runningSum = 0;
        int maxRunningSum = 0;
        int yearOfPeek = 0;

        for (int index = 0; index < populationByYear.length; index++) {
            runningSum += populationByYear[index];
            if (runningSum > maxRunningSum) {
                maxRunningSum = runningSum;
                yearOfPeek = index;
            }
        }
        return yearOfPeek;
    }

    private int[] updatePopulationByYear(Person[] persons,
                                         int firstBirthYear, int lastBirthYear) {
        int[] populationByYear = new int[lastBirthYear - firstBirthYear + 1];
        for (Person p : persons) {
            addDelta(populationByYear, p.getBirthYear() - firstBirthYear, 1);
            addDelta(populationByYear, p.getDeathYear() - firstBirthYear + 1, -1);
        }
        return populationByYear;
    }

    private void addDelta(int[] populationByYear, int index, int value) {
        if (index > populationByYear.length - 1) {
            return;
        }
        populationByYear[index] = populationByYear[index] + value;
    }


    private int getBirthYear(Person[] persons, IntBinaryOperator op) {
        return Stream.of(persons)
                .mapToInt(Person::getBirthYear)
                .reduce(op).getAsInt();
    }

    public static class Person {
        private int birthYear;
        private int deathYear;

        public Person(int birthYear, int deathYear) {
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(int birthYear) {
            this.birthYear = birthYear;
        }

        public int getDeathYear() {
            return deathYear;
        }

        public void setDeathYear(int deathYear) {
            this.deathYear = deathYear;
        }
    }
}

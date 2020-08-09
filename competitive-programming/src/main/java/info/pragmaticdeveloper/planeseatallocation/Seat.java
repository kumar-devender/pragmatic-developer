package info.pragmaticdeveloper.planeseatallocation;

public class Seat {
    private int rowNumber;
    private char seatLabel;

    public Seat(char seatLabel, int rowNumber) {
        this.seatLabel = seatLabel;
        this.rowNumber = rowNumber;
    }

    public char getSeatLabel() {
        return seatLabel;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    @Override
    public String toString() {
        return "{\n" +
                '"' + "rowNumber" + '"' + ":" + rowNumber +
                ",\n" + '"' + "seatLabel" + '"' + ":" + seatLabel +
                "\n}";
    }
}

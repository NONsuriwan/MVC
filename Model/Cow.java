package Model;

public class Cow {
    private String cowID;
    private String color;
    private int years;
    private int months;

    public Cow(String cowID, String color, int years, int months) {
        this.cowID = cowID;
        this.color = color;
        this.years = years;
        this.months = months;
    }

    public String getCowID() {
        return cowID;
    }

    public String getColor() {
        return color;
    }

    public String getAge() {
        return years + "year-" + months + "months";
    }

    public int getTotalMonths() {
        return (years * 12) + months;
    }

    public int getYears() {
        return years;
    }

    public int getMonths() {
        return months;
    }
}

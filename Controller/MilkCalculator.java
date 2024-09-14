package Controller;

import Model.Cow;

public class MilkCalculator {

    private int totalPlainMilk = 0;
    private int totalChocolateMilk = 0;
    private int totalStrawberryMilk = 0;

    public int calculatePlainMilk(int totalMonths) {
        return Math.max(0, 120 - totalMonths);
    }

    public int calculateChocolateMilk(int years) {
        return Math.max(0, 40 - years);
    }

    public int calculateStrawberryMilk(int months) {
        return Math.max(0, 30 - months);
    }

    public String calculateMilkForCow(Cow cow) {
        String color = cow.getColor();
        int plainMilkAmount = calculatePlainMilk(cow.getTotalMonths());
        int chocolateMilkAmount = calculateChocolateMilk(cow.getYears());
        int strawberryMilkAmount = calculateStrawberryMilk(cow.getMonths());
        int milkAmount = 0;
        String milkType = "";

        if (color.equals("White")) {
            milkAmount = plainMilkAmount;
            milkType = "นมจืด";
            totalPlainMilk += plainMilkAmount;
        } else if (color.equals("Brown")) {
            milkAmount = chocolateMilkAmount;
            milkType = "นมช็อกโกแลต";
            totalChocolateMilk += chocolateMilkAmount;
        } else if (color.equals("Pink")) {
            milkAmount = strawberryMilkAmount;
            milkType = "นมสตรอว์เบอร์รี่";
            totalStrawberryMilk += strawberryMilkAmount;
        }

        return String.format("CowID=%s, Colour=%s, Age=%s, ผลิต%sได้ %d ลิตร\n" +
                             "รวมจำนวนนมทั้งหมดที่ผลิตได้: นมจืด=%d ลิตร, นมช็อกโกแลต=%d ลิตร, นมสตรอว์เบอร์รี่=%d ลิตร", 
                             cow.getCowID(), cow.getColor(), cow.getAge(), milkType, milkAmount,
                             totalPlainMilk, totalChocolateMilk, totalStrawberryMilk);
    }
}

package Controller;

import Model.Cow;
import Model.CowData;

public class DatabaseValidation {
    private CowData cowData;
    private MilkCalculator milkCalculator;

    public DatabaseValidation() {
        cowData = new CowData();
        milkCalculator = new MilkCalculator();
    }

    public String validateAndGetCowInfo(String cowID) {
        if (!isValidCowID(cowID)) {
            return "รหัสวัวไม่ถูกต้อง: ต้องเป็นตัวเลข 8 หลักและไม่ขึ้นต้นด้วยเลข 0";
        }

        Cow cow = cowData.getCowByID(cowID);
        if (cow == null) {
            return "ไม่พบข้อมูลวัวในระบบ";
        }

        return milkCalculator.calculateMilkForCow(cow);
    }

    private boolean isValidCowID(String cowID) {
        return cowID.matches("[1-9][0-9]{7}");
    }
}

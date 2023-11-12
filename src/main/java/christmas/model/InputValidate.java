package christmas.model;

public class InputValidate {
    public static void dateRangeCheck(Integer givenDate) {
        if(givenDate > 31) throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        if(givenDate < 0) throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}

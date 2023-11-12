package christmas.controller;

import christmas.model.InputValidate;
import christmas.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController() {
        this.inputView = new InputView();
    }

    public Integer getVisitDay() {
        String givenDate = inputView.readDate();
        try{
            Integer result = Integer.parseInt(givenDate);
            InputValidate.dateRangeCheck(result);
            return result;
        }catch (IllegalArgumentException e)
        {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return getVisitDay();
        }
    }
}

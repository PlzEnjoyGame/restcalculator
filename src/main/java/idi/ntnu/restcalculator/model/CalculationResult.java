package idi.ntnu.restcalculator.model;

/**
 * @author Vladimir Lenkov
 * @since 20/03/2023
 */
public class CalculationResult {
    private boolean success;
    private double answer;
    private String message;
    private String calculation;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }
}

package idi.ntnu.restcalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
public class CalculatorController {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @CrossOrigin(origins = "http://localhost:8081/")
    @PostMapping("/calculate")
    public CalculationResult calculate(@RequestBody Map<String, String> data) {
        CalculationResult result = new CalculationResult();
        try {
            logger.info("Received calculation request: {}", data.get("expression"));
            double answer = CalculatorService.evaluate(data.get("expression"));
            logger.info("Responding to client with the following answer: {}", answer);
            result.setCalculation(data.get("expression"));
            result.setSuccess(true);
            result.setAnswer(answer);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Invalid expression");
        }
        return result;
    }

    /*
     * Java Spring Model
     */
    public static class CalculationResult {
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

}
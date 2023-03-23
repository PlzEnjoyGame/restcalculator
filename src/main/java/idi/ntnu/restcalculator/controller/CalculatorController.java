package idi.ntnu.restcalculator.controller;

import idi.ntnu.restcalculator.model.CalculationResult;
import idi.ntnu.restcalculator.model.Expression;
import idi.ntnu.restcalculator.model.User;
import idi.ntnu.restcalculator.repository.ExpressionRepository;
import idi.ntnu.restcalculator.repository.UserRepository;
import idi.ntnu.restcalculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class CalculatorController {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    ExpressionRepository expressionRepository;

    @Autowired
    UserRepository userRepository;

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

    @GetMapping(path = "/expressions")
    public List<Expression> getAllExpressions() {
        return expressionRepository.findAll();
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }




}
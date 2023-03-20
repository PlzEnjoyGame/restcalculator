package idi.ntnu.restcalculator;

import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Vladimir Lenkov
 * @since 03/03/2023
 */
@Service
public class CalculatorService {
    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");

    public CalculatorService() {
    }

    static double evaluate(String expression) {
        try {
            Object result = engine.eval(expression);
            if (result instanceof Number) {
                return ((Number) result).doubleValue();
            } else {
                throw new IllegalArgumentException("Invalid expression: " + expression);
            }
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Invalid expression: " + expression, e);
        }
    }
}

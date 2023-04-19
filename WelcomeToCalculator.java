package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping ("/calculator")
public class WelcomeToCalculator {
    private final CalculatorService service;

    public WelcomeToCalculator(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String welcome() {
        return "<b>Добро пожаловать в калькулятор<b>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "Введите 2 параметра";
        }
        return num1 + " + " + num2 + " = " + service.sum(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "Введите 2 параметра";
        }
        return num1 + " - " + num2 + " = " + service.minus(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "Введите 2 параметра";
        }
        return num1 + " * " + num2 + " = " + service.multiply(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()){
            return "Введите 2 параметра";
    }
        if (num2.equals("0")){
    return "<b>ДЕЛИТЬ НА 0 НЕЛЬЗЯ<b>";
        }
            return num1 + " / " + num2 + " = " + service.divide(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    }






package by.tms.springbootcalculcator.controller;

import by.tms.springbootcalculcator.entity.Operation;
import by.tms.springbootcalculcator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/operation")
    public String operation() {
        return "operation";
    }

    @PostMapping("/operation")
    public String operation(Operation operation, Model model){
        Optional<Operation> resultOperation = calculatorService.calculate(operation);
        if(resultOperation.isPresent()) {
            model.addAttribute("result", resultOperation.get());
        } else {
            model.addAttribute("result", "error");
        }
        return "operation";
    }

    @GetMapping("/history")
    public String history(Model model){
        model.addAttribute("operationHistory", calculatorService.getHistory());
        return "history";
    }
}

package by.tms.springbootcalculcator.service;

import by.tms.springbootcalculcator.dao.InMemoryOperationDao;
import by.tms.springbootcalculcator.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculatorService {

    @Autowired
    private InMemoryOperationDao operationDao;

    public Optional<Operation> calculate(Operation operation){
        switch (operation.getOperation()) {

            case "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationDao.save(operation);
                return Optional.of(operation);
            case "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationDao.save(operation);
                return Optional.of(operation);
            case "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationDao.save(operation);
                return Optional.of(operation);
            case "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationDao.save(operation);
                return Optional.of(operation);
        }
        return Optional.empty();
    }

    public List<Operation> getHistory(){
        return operationDao.findAll();
    }
}

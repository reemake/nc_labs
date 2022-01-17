package validation.validators;

import contracts.Contract;
import validation.Status;
import validation.ValidationMessage;
import validation.Validator;

import java.time.LocalDate;

/**
 * Class that implements contract date validation
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Validator
 */
public class ContractDatesValidator implements Validator {

    @Override
    public ValidationMessage validate(Contract contract) {
        ValidationMessage message = new ValidationMessage();
        LocalDate startDate = contract.getStartDate();
        LocalDate expirationDate = contract.getExpirationDate();
        if (expirationDate.isBefore(startDate)) {
            message.setStatus(Status.FAIL);
            message.setMessage("ошибка - указанная дата истечения контракта введена некорректно!");
        }
        return message;
    }
}

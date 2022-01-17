package validation.validators;

import contracts.Contract;
import validation.Status;
import validation.ValidationMessage;
import validation.Validator;

/**
 * Class that implements person age validation
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Validator
 */
public class PersonAgeValidator implements Validator {

    @Override
    public ValidationMessage validate(Contract contract) {
        ValidationMessage message = new ValidationMessage();
        if (contract.getOwner().getAge() < 18) {
            message.setStatus(Status.FAIL);
            message.setMessage("ошибка - возраст клиента меньше 18 лет!");
        }
        return message;
    }
}

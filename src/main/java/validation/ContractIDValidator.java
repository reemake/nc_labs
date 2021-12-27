package validation;

import contracts.Contract;

/**
 * Class that implements contract ID validation
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Validator
 */
public class ContractIDValidator implements Validator {

    @Override
    public ValidationMessage validate(Contract contract) {
        ValidationMessage message = new ValidationMessage();
        if (contract.getID() < 0) {
            message.setStatus(Status.FAIL);
            message.setMessage("ошибка - значение идентификатора контракта не может быть отрицательным!");
        }
        return message;
    }
}

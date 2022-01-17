package validation;

import contracts.Contract;
import validation.validators.ContractDatesValidator;
import validation.validators.ContractIDValidator;
import validation.validators.PersonAgeValidator;

/**
 * Interface which is defining the validation method
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see ContractDatesValidator
 * @see ContractIDValidator
 * @see PersonAgeValidator
 */
public interface Validator {

    /**
     * Method for performing validation
     * @param contract object of Contract class
     */
    ValidationMessage validate(Contract contract);

}

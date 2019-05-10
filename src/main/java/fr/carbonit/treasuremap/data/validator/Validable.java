package fr.carbonit.treasuremap.data.validator;

/**
 * A validable object is an object which returns a validator class
 */
public interface Validable {
    Validator getValidator();
}

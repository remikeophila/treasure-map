package fr.carbonit.treasuremap.data.validator;

/**
 * A validable object is an object which returns a validator object
 */
public interface Validable {
    Validator getValidator();
}

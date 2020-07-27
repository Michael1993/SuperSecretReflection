package com.javax1.secret.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The outcome of the operation.
 */
public class OperationTest {

    @Test
    @DisplayName("The agent approaches the entrance and gives the password")
    void entrance() {
        Assertions.assertDoesNotThrow(Operation::enter);
    }
}

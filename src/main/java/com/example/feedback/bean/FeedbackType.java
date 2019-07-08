package com.example.feedback.bean;

import java.util.Arrays;
import java.util.Optional;

public enum FeedbackType {
	
	VERYBAD(0), BAD(1), AVERAGE(2), GOOD(3), VERYGOOD(4), EXCELLENT(5);
	
	private final int value;
    
	private FeedbackType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static Optional<FeedbackType> valueOf(int value) {
        return Arrays.stream(values())
            .filter(legNo -> legNo.value == value)
            .findFirst();
    }
    
}

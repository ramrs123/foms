package com.gemini.foms.exception;

public class CheckoutNotAllowedException extends RuntimeException {
    public CheckoutNotAllowedException(String s) {
        super(s);
    }
}

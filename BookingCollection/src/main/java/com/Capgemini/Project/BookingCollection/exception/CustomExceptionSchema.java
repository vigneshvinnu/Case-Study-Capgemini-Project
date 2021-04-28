package com.Capgemini.Project.BookingCollection.exception;

public class CustomExceptionSchema {
    private static final long serialVersionUID = 1L;
    private String message;

    public CustomExceptionSchema() {
    }

    public CustomExceptionSchema(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

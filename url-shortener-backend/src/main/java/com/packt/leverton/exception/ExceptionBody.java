package com.packt.leverton.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Set;

@JsonSerialize
public class ExceptionBody {

    Integer status;
    String error;
    Set<String> messages;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Set<String> getMessages() {
        return messages;
    }

    public void setMessages(Set<String> messages) {
        this.messages = messages;
    }

    public ExceptionBody(final Integer status, final String error, final Set<String> messages) {
        this.status = status;
        this.error = error;
        this.messages = messages;
    }

}

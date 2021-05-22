package edu.sdccd.cisc191.f;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountRequest {
    private RequestType requestType;
    private long cardNumber;
    private String PIN;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(AccountRequest accountRequest) throws Exception {
        return objectMapper.writeValueAsString(accountRequest);
    }
    public static AccountRequest fromJSON(String input) throws Exception {
        return objectMapper.readValue(input, AccountRequest.class);
    }

    protected AccountRequest() {

    }

    public AccountRequest(RequestType requestType, long cardNumber, String PIN) {
        this.requestType = requestType;
        this.cardNumber = cardNumber;
        this.PIN = PIN;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}

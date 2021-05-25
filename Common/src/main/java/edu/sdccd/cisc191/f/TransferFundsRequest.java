package edu.sdccd.cisc191.f;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class that represents the Transfer Funds Requests. To transfer money between accounts.
 *
 * @author Oriel Sanchez
 * @author Eric Kim
 */
public class TransferFundsRequest {
    private RequestType requestType;
    private long senderCardNumber;
    private double transferAmount;
    private long recipientCardNumber;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Creates the transferFundsRequest object into json format to send within socket.
     *
     * @param  transferFundsRequest transferFundsRequest
     * @return transferFundsRequest as a string
     */
    public static String toJSON(TransferFundsRequest transferFundsRequest) throws Exception {
        return objectMapper.writeValueAsString(transferFundsRequest);
    }

    /**
     * Creates the transferFundsRequest object into json format to send within socket.
     *
     * @param  input          reads an transferFundsRequest formatted as a string
     * @return converts the input string into an transferFundsRequest
     */
    public static TransferFundsRequest fromJSON(String input) throws Exception {
        return objectMapper.readValue(input, TransferFundsRequest.class);
    }

    protected TransferFundsRequest() {}

    /**
     * Creates the transferFundsRequest object that accepts 4 parameters.
     * This constructor is used to initialize the transferFundsRequest object in order to begin the transfer.
     *
     * @param requestType            one of four account request types: Account, Deposit, Withdraw, Transfer
     * @param senderCardNumber       cardNumber that is sending the money
     * @param transferAmount         amount to transfer
     * @param recipientCardNumber    cardNumber receiving the money
     */
    public TransferFundsRequest(RequestType requestType, long senderCardNumber, double transferAmount, long recipientCardNumber) {
        this.requestType = requestType;
        this.senderCardNumber = senderCardNumber;
        this.transferAmount = transferAmount;
        this.recipientCardNumber = recipientCardNumber;
    }

    /**
     * Gets the requestType
     *
     * @return The requestType as an object of requestType
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * Sets the requestType
     */
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * Gets the sender card number from the transferFundsRequest object
     *
     * @return the carbNumber as a long variable
     */
    public long getSenderCardNumber() {
        return senderCardNumber;
    }

    /**
     * Sets the sender card number for transferFundsRequest object
     */
    public void setSenderCardNumber(long senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    /**
     * Gets the transfer amount from transferFundsRequest object
     *
     * @return the amount as a double
     */
    public double getTransferAmount() {
        return transferAmount;
    }

    /**
     * Sets the transfer amount to the transferFundsRequest object
     */
    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    /**
     * Gets the receiving card number from transferFundsRequest object
     *
     * @return the cardNumber as a long
     */
    public long getRecipientCardNumber() {
        return recipientCardNumber;
    }

    /**
     * Sets the receiving card number for transferFundsRequest object
     */
    public void setRecipientCardNumber(long recipientCardNumber) {
        this.recipientCardNumber = recipientCardNumber;
    }
}

package edu.sdccd.cisc191.f;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class that represents the Transfer Funds Responses. To transfer money between accounts.
 *
 * @author Oriel Sanchez
 * @author Eric Kim
 */
public class TransferFundsResponse {
    private boolean transferSuccessful;
    private double balance;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Creates the transferFundsResponse object into json format to send within socket.
     *
     * @param  transferFundsResponse transferFundsResponse
     * @return transferFundsResponse as a string
     */
    public static String toJSON(TransferFundsResponse transferFundsResponse) throws Exception {
        return objectMapper.writeValueAsString(transferFundsResponse);
    }

    /**
     * Creates the transferFundsResponse object into json format to send within socket.
     *
     * @param  input  reads an transferFundsResponse formatted as a string
     * @return converts the input string into an transferFundsResponse
     */
    public static TransferFundsResponse fromJSON(String input) throws Exception {
        return objectMapper.readValue(input, TransferFundsResponse.class);
    }

    protected TransferFundsResponse() {}

    /**
     * Creates the transferFundsResponse object that accepts 2 parameters.
     *
     * @param transferSuccessful  boolean if the transfer was successful
     * @param balance             new balance of the receiving account
     */
    public TransferFundsResponse(boolean transferSuccessful, double balance) {
        this.transferSuccessful = transferSuccessful;
        this.balance = balance;
    }

    /**
     * Checks the status of the transfer
     *
     * @return if the transfer was successful
     */
    public boolean isTransferSuccessful() {
        return transferSuccessful;
    }

    /**
     * Sets the status of the transfer
     */
    public void setTransferSuccessful(boolean transferSuccessful) {
        this.transferSuccessful = transferSuccessful;
    }

    /**
     * Gets the new balance of the account receiving the money
     *
     * @return the new balance as a double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the new balance after the money is transferred
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

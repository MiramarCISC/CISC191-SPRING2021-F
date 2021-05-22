package edu.sdccd.cisc191.f.client;

import edu.sdccd.cisc191.f.*;

import java.net.*;
import java.io.*;

/**
 * This program opens a connection to a computer specified
 * as the first command-line argument.  If no command-line
 * argument is given, it prompts the user for a computer
 * to connect to.  The connection is made to
 * the port specified by LISTENING_PORT.  The program reads one
 * line of text from the connection and then closes the
 * connection.  It displays the text that it read on
 * standard output.  This program is meant to be used with
 * the server program, DateServer, which sends the current
 * date and time on the computer where the server is running.
 */

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public AccountResponse sendAccountRequest(long cardNumber, String PIN) throws Exception {
        out.println(AccountRequest.toJSON(new AccountRequest(RequestType.ACC, cardNumber, PIN)));
        return AccountResponse.fromJSON(in.readLine());
    }

    public DepositResponse sendDepositRequest(long cardNumber, double depositAmount) throws Exception {
        out.println(DepositRequest.toJSON(new DepositRequest(RequestType.DEP, cardNumber, depositAmount)));
        return DepositResponse.fromJSON(in.readLine());
    }

    public WithdrawResponse sendWithdrawRequest(long cardNumber, double withdrawAmount) throws Exception {
        out.println(WithdrawRequest.toJSON(new WithdrawRequest(RequestType.WIT, cardNumber, withdrawAmount)));
        return WithdrawResponse.fromJSON(in.readLine());
    }

    public TransferFundsResponse sendTransferFundsRequest(long senderCardNumber, double transferAmount, long recipientCardNumber) throws Exception {
        out.println(TransferFundsRequest.toJSON(new TransferFundsRequest(RequestType.TRA, senderCardNumber, transferAmount, recipientCardNumber)));
        return TransferFundsResponse.fromJSON(in.readLine());
    }


    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
} //end class Client


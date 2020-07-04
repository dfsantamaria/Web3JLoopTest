/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web3jlooptest;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

/**
 *
 * @author danie
 */
public class web3jLoopTest
{
  public static void main (String[]args)
  {
    
      try {
          String the_service="https://proud-withered-violet.ropsten.quiknode.pro/5698455e8356fba0380b17cb2ee8e08453e66d5b/";
          Web3j web3 = Web3j.build(new HttpService(the_service));
          CompletableFuture<EthGetBalance> balance = web3.ethGetBalance("0x7a7f3F3B111236138FFBEe7F54d0743C4B1cb10F", DefaultBlockParameterName.LATEST).sendAsync(); 
          BigInteger amount =  balance.get().getBalance();
          System.out.println(amount);
      } 
      catch (InterruptedException ex) {
          Logger.getLogger(web3jLoopTest.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ExecutionException ex) {
          Logger.getLogger(web3jLoopTest.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}


 

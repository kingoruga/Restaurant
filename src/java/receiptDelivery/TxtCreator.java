/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiptDelivery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author syntel
 */
public class TxtCreator {

    public void generateTxtReceipt(List<String> order) {
        try (PrintWriter writer = new PrintWriter(new File("C:/Receipts/receipt.txt"))) {
            writer.println("Receipt");
            writer.println("Delivery Address:");
            writer.println(order.get(0));
            writer.println(order.get(1));
            writer.println(order.get(2));
            writer.println(order.get(3));
            writer.println();
            writer.println("Price:");
            writer.println(order.get(4));
            writer.println();
            writer.println("Payment method:");
            writer.println(order.get(5));
            writer.println();
            writer.println("Delivery date and time:");
            writer.println(order.get(6) + " " + order.get(7));
            writer.println();
            writer.println("Food item:");
            writer.println(order.get(8));
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
    }

}

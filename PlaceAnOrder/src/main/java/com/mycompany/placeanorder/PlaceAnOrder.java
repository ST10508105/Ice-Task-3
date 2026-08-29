/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.placeanorder;

import java.util.Scanner;

/**
 *
 * @author uwais
 */
public class PlaceAnOrder {
    
    private static final int[] ITEM_NUMBERS = {111, 222, 333, 444};
    private static final double[] PRICES    = {0.89, 1.47, 2.43, 5.99};

    public static void main(String[] args) {
    
         System.out.println("Current Inventory");
        System.out.println("------------------------");
        System.out.println("Item Number" + "\t" + "Price ($)");
        for (int i = 0; i < ITEM_NUMBERS.length; i++)
        {
            System.out.println(ITEM_NUMBERS[i] + "\t\t" + PRICES[i]);
        }
        System.out.println();
        
        
        
        Scanner input = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing)
        {
            try
            {
                System.out.print("Enter item number (or -1 to quit): ");
                String itemInputStr = input.nextLine().trim();

                // Allow the user to quit the loop
                if (itemInputStr.equals("-1"))
                {
                    keepGoing = false;
                    continue;
                }

                System.out.print("Enter quantity: ");
                String quantityInputStr = input.nextLine().trim();

                int itemNumber = validateItemNumber(itemInputStr);
                int quantity = validateQuantity(quantityInputStr);

                double price = findPrice(itemNumber);

                double total = price * quantity;
                System.out.printf("Order accepted! Total amount due: $%.2f%n%n", total);
            }
            catch (OrderException e)
            {
               
                System.out.println(e.getMessage());
                System.out.println();
            }
        }

        System.out.println("Thank you for using Serendipity Gifts ordering system.");
        input.close();
    }

  
    private static int validateItemNumber(String itemInputStr) throws OrderException
    {
        int itemNumber;
        try
        {
            itemNumber = Integer.parseInt(itemInputStr);
        }
        catch (NumberFormatException e)
        {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_NOT_NUMERIC));
        }

        if (itemNumber < 0)
        {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_TOO_LOW));
        }
        if (itemNumber > 9999)
        {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_TOO_HIGH));
        }

        return itemNumber;
    }

    
    private static int validateQuantity(String quantityInputStr) throws OrderException
    {
        int quantity;
        try
        {
            quantity = Integer.parseInt(quantityInputStr);
        }
        catch (NumberFormatException e)
        {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.QUANTITY_NOT_NUMERIC));
        }

        if (quantity < 1)
        {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.QUANTITY_TOO_LOW));
        }
        if (quantity > 12)
        {
            throw new OrderException(OrderMessages.getMessage(OrderMessages.QUANTITY_TOO_HIGH));
        }

        return quantity;
    }

   
    private static double findPrice(int itemNumber) throws OrderException
    {
        for (int i = 0; i < ITEM_NUMBERS.length; i++)
        {
            if (ITEM_NUMBERS[i] == itemNumber)
            {
                return PRICES[i];
            }
        }
        throw new OrderException(OrderMessages.getMessage(OrderMessages.ITEM_NOT_FOUND));
    }
        
        
    }






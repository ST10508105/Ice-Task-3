/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.placeanorder;

/**
 *
 * @author uwais
 */
public class OrderMessages {
    public static final int ITEM_NOT_NUMERIC   = 0;
    public static final int ITEM_TOO_LOW       = 1;
    public static final int ITEM_TOO_HIGH      = 2;
    public static final int QUANTITY_NOT_NUMERIC = 3;
    public static final int QUANTITY_TOO_LOW   = 4;
    public static final int QUANTITY_TOO_HIGH  = 5;
    public static final int ITEM_NOT_FOUND     = 6;
    
    private static final String[] MESSAGES = {
        "Error: Item number must be numeric.",
        "Error: Item number is too low - it cannot be less than 0.",
        "Error: Item number is too high - it cannot be greater than 9999.",
        "Error: Quantity must be numeric.",
        "Error: Quantity is too low - it must be at least 1.",
        "Error: Quantity is too high - it cannot exceed 12.",
        "Error: Item number does not correspond to any valid item in inventory."
    };
    
   public static String getMessage(int index)
    {
        if (index < 0 || index >= MESSAGES.length)
        {
            return "Error: Unknown error occurred.";
        }
        return MESSAGES[index];
    } 
    
    
    
    
    
}

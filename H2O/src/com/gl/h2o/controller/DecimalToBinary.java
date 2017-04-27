package com.gl.h2o.controller;

import java.util.*;
public class DecimalToBinary
{
  public static void main(String[] args) 
  { 
    Scanner in = new Scanner(System.in);
 
    // Create and initiate Stack object
    Stack<Integer> stack = new Stack<Integer>();
 
    // take input 
    System.out.println("Enter the decimal number: ");
    int num = in.nextInt();
 
    while (num != 0)
    {
      int d = num % 2;
      stack.push(d);
      num /= 2;
    } 
 
    System.out.print("\nBinary converted representation is:");
    while (!(stack.isEmpty() ))
    {
      System.out.print(stack.pop());
    }
    System.out.println();
  }
}

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

	class StringRev2{
    public static void main(String args[]){
    String str[] = "He is the one".split(" ");
    StringBuilder finalStr=new StringBuilder("");
        for(int i = str.length-1; i>= 0 ;i--){
            finalStr.append(new StringBuilder(str[i]).append(" "));
        }
        System.out.println(finalStr);
    }
}

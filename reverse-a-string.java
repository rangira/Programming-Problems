public String reverseString(String s){
    if (s.length() == 0) 
         return s;

    return reverseString(s.substring(1)) + s.charAt(0);
}

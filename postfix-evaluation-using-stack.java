public static int evalPostfix(String exp) {

    int res = 0;

    myStack list = new myStack();
    int n1;     //result of 1st popping
    int n2;     // result of 2nd popping


    for (int i = 0; i < exp.length(); i++) {
        char ch = exp.charAt(i);


            if (ch == ' ') {
            } else {
                if (ch > '0' && ch < '9') {
                    list.push(ch);
                    //          list.printS();
                } else {
                    n1 = Integer.parseInt("" + list.pop());
                    n2 = Integer.parseInt("" + list.pop());

                    switch (ch) {
                        case '+':
                            list.push(n1 + n2);
                            break;
                        case '-':
                            list.push(n1 - n2);
                            break;
                        case '*':
                            list.push(n1 * n2);
                            break;
                        case '/':
                            list.push(n1 / n2);
                            break;

                        default:
                            System.out.println("Invalid operator order!");
                    }
                }
            }
        }

    res = Integer.parseInt("" + list.pop());

    return res;
}

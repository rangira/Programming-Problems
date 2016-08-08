class Stack<E> {
  private final int size;

  private int top;

  private E[] elements;

  public Stack() {
    this(10);
  }

  public Stack(int s) {
    size = s > 0 ? s : 10;
    top = -1;

    elements = (E[]) new Object[size]; // create array
  }

  public void push(E pushValue) {
    if (top == size - 1) // if stack is full
      throw new FullStackException(String.format("Stack is full, cannot push %s", pushValue));

    elements[++top] = pushValue; // place pushValue on Stack
  }

  public E pop() {
    if (top == -1) // if stack is empty
      throw new EmptyStackException("Stack is empty, cannot pop");

    return elements[top--]; // remove and return top element of Stack
  }
}

class EmptyStackException extends RuntimeException {
  public EmptyStackException() {
    this("Stack is empty");
  }

  public EmptyStackException(String exception) {
    super(exception);
  }
}

class FullStackException extends RuntimeException {
  public FullStackException() {
    this("Stack is full");
  }

  public FullStackException(String exception) {
    super(exception);
  }
}

 class MainClass {

  public static void main(String args[]) {
    double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
    int[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    String [] strElements = {"rudra","rud","cs","course"};

    Stack<Double> doubleStack = new Stack<Double>(5);
    Stack<Integer> integerStack = new Stack<Integer>(10);
    Stack<String> strStack = new Stack<String>(10);

    // test Push Double
    try {
      System.out.println("\nPushing elements onto doubleStack");

      for (double element : doubleElements) {
        System.out.printf("%.1f ", element);
        doubleStack.push(element);
      }
    } catch (FullStackException fullStackException) {
      System.err.println();
      fullStackException.printStackTrace();
    }

    // test Pop Double

    try {
      System.out.println("\nPopping elements from doubleStack");
      double popValue;

      while (true) {
        popValue = doubleStack.pop(); // pop from doubleStack
        System.out.printf("%.1f ", popValue);
      }
    } catch (EmptyStackException emptyStackException) {
      System.err.println();
      emptyStackException.printStackTrace();
    }

    // test push method with integer stack
    try {
      System.out.println("\nPushing elements onto integerStack");

      for (int element : integerElements) {
        System.out.printf("%d ", element);
        integerStack.push(element);
      }
    } catch (FullStackException fullStackException) {
      System.err.println();
      fullStackException.printStackTrace();
    }
    // test pop method with integer stack
    try {
      System.out.println("\nPopping elements from integerStack");
      int popValue; // store element removed from stack

      // remove all elements from Stack
      while (true) {
        popValue = integerStack.pop();
        System.out.printf("%d ", popValue);
      }
    } catch (EmptyStackException emptyStackException) {
      System.err.println();
      emptyStackException.printStackTrace();
    }
   //test push for strings
   
   try {
      System.out.println("\nPushing elements onto stringStack");

      for (String element : strElements) {
        System.out.printf("%s ", element);
        strStack.push(element);
      }
    } catch (FullStackException fullStackException) {
      System.err.println();
      fullStackException.printStackTrace();
    }
    //test pop for strings
    try {
      System.out.println("\nPopping elements from stringStack");
      String popValue; // store element removed from stack

      // remove all elements from Stack
      while (true) {
        popValue = strStack.pop();
        System.out.printf("%s ", popValue);
      }
    } catch (EmptyStackException emptyStackException) {
      System.err.println();
      emptyStackException.printStackTrace();
    }
  }
}

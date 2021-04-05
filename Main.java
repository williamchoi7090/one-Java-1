import java.util.Stack;

public class Main {
  public static int evaluate(String expression) {
    char[] main = expression.toCharArray();
    Stack<Integer> val = new Stack<Integer>();
    Stack<Character> java = new Stack<Character>();
    for (int n = 0; n < main.length; n++) {
      if (main[n] == ' ')
        continue;
      if (main[n] >= '0' && main[n] <= '9') {
        StringBuffer sbuf = new StringBuffer();
        while (n < main.length && main[n] >= '0' && main[n] <= '9')
          sbuf.append(main[n++]);
        val.push(Integer.parseInt(sbuf.toString()));
        n--;
      } else if (main[n] == '(')
        java.push(main[n]);
      else if (main[n] == ')') {
        while (java.peek() != '(')
          val.push(applyjv(java.pop(), val.pop(), val.pop()));
        java.pop();
      } else if (main[n] == '+' || main[n] == '-' || main[n] == '*' || main[n] == '/') {
        while (!java.empty() && hasPrecedence(main[n], java.peek()))
          val.push(applyjv(java.pop(), val.pop(), val.pop()));
        java.push(main[n]);
      }
    }
    while (!java.empty())
      val.push(applyjv(java.pop(), val.pop(), val.pop()));
    return val.pop();
  }

  public static boolean hasPrecedence(char jv1, char jv2) {
    if (jv2 == '(' || jv2 == ')')
      return false;
    if ((jv1 == '*' || jv1 == '/') && (jv2 == '+' || jv2 == '-'))
      return false;
    else
      return true;
  }

  public static int applyjv(char jv, int b, int a) {
    switch (jv) {
    case '+':
      return a + b;
    case '-':
      return a - b;
    case '*':
      return a * b;
    case '/':
      if (b == 0)
        throw new UnsupportedOperationException("Cannot divide by zero");
      return a / b;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println("25+5*2= " + Main.evaluate("25+5*2"));
    System.out.println("5-*2+5= " + Main.evaluate("50*2+5"));
    System.out.println("100*(2+5)= " + Main.evaluate("100*(2+5)"));
    System.out.println("100*5+2-/5= " + Main.evaluate("100*5+20/5"));
    System.out.println("100*(2+5)/25= " + Main.evaluate("100*(2+5)/25"));
  }
}mport java.util.Stack;

public class Main {
  public static int evaluate(String expression) {
    char[] main = expression.toCharArray();
    Stack<Integer> val = new Stack<Integer>();
    Stack<Character> java = new Stack<Character>();
    for (int n = 0; n < main.length; n++) {
      if (main[n] == ' ')
        continue;
      if (main[n] >= '0' && main[n] <= '9') {
        StringBuffer sbuf = new StringBuffer();
        while (n < main.length && main[n] >= '0' && main[n] <= '9')
          sbuf.append(main[n++]);
        val.push(Integer.parseInt(sbuf.toString()));
        n--;
      } else if (main[n] == '(')
        java.push(main[n]);
      else if (main[n] == ')') {
        while (java.peek() != '(')
          val.push(applyjv(java.pop(), val.pop(), val.pop()));
        java.pop();
      } else if (main[n] == '+' || main[n] == '-' || main[n] == '*' || main[n] == '/') {
        while (!java.empty() && hasPrecedence(main[n], java.peek()))
          val.push(applyjv(java.pop(), val.pop(), val.pop()));
        java.push(main[n]);
      }
    }
    while (!java.empty())
      val.push(applyjv(java.pop(), val.pop(), val.pop()));
    return val.pop();
  }

  public static boolean hasPrecedence(char jv1, char jv2) {
    if (jv2 == '(' || jv2 == ')')
      return false;
    if ((jv1 == '*' || jv1 == '/') && (jv2 == '+' || jv2 == '-'))
      return false;
    else
      return true;
  }

  public static int applyjv(char jv, int b, int a) {
    switch (jv) {
    case '+':
      return a + b;
    case '-':
      return a - b;
    case '*':
      return a * b;
    case '/':
      if (b == 0)
        throw new UnsupportedOperationException("Cannot divide by zero");
      return a / b;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println("25+5*2= " + Main.evaluate("25+5*2"));
    System.out.println("5-*2+5= " + Main.evaluate("50*2+5"));
    System.out.println("100*(2+5)= " + Main.evaluate("100*(2+5)"));
    System.out.println("100*5+2-/5= " + Main.evaluate("100*5+20/5"));
    System.out.println("100*(2+5)/25= " + Main.evaluate("100*(2+5)/25"));
  }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Calculator implements ActionListener{
    public static JTextField text;
    public static boolean Error = false;
    public static Stack<Character> op = new Stack<Character>();
    public static Stack<Double> number = new Stack<Double>();

    public static void createbutton(Container p, String title, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints){
        JButton b = new JButton(title);
        b.setPreferredSize(new Dimension(50, 50));
        b.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        switch(title){
            case "(":case ")":case "%":case "AC":case "/":case "*":case "-":case "+":
                b.setForeground(Color.BLACK);
                b.setBackground(new java.awt.Color(210,210,210));
                break;
            case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":case ".":
                b.setForeground(Color.BLACK);
                b.setBackground(Color.WHITE);
                break;
            case "=":
                b.setForeground(Color.WHITE);
                b.setBackground(new java.awt.Color(71, 141, 222));
                break;
        }
        // b.setBackground(Color.WHITE);
        gridBagLayout.setConstraints(b, gridBagConstraints);
        b.addActionListener(new Calculator());
        p.add(b);
    }
    public static void main(String[] args){
        JFrame f = new JFrame("Basic Caculator");
        JPanel p = new JPanel();
        
        GridBagLayout layout = new GridBagLayout();
        p.setLayout(layout);
        
        text = new JTextField();
        GridBagConstraints c = new GridBagConstraints();
        Font font = new Font("SansSerif", Font.PLAIN, 30);
        text.setFont(font);
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;
        c.gridwidth = GridBagConstraints.REMAINDER;
        p.add(text, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;c.ipady = 30;
        createbutton(p,"(",layout,c);
        createbutton(p,")",layout,c);
        createbutton(p,"%",layout,c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        createbutton(p,"AC",layout,c);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;c.ipady = 30;
        createbutton(p,"7",layout,c);
        createbutton(p,"8",layout,c);
        createbutton(p,"9",layout,c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        createbutton(p,"/",layout,c);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;c.ipady = 30;
        createbutton(p,"4",layout,c);
        createbutton(p,"5",layout,c);
        createbutton(p,"6",layout,c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        createbutton(p,"*",layout,c);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;c.ipady = 30;
        createbutton(p,"1",layout,c);
        createbutton(p,"2",layout,c);
        createbutton(p,"3",layout,c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        createbutton(p,"-",layout,c);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 100;c.ipady = 30;
        createbutton(p,"0",layout,c);
        createbutton(p,".",layout,c);
        createbutton(p,"=",layout,c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        createbutton(p,"+",layout,c);
        
        f.add(p);
        f.setSize(625,625);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String commad = e.getActionCommand();
        
        if(commad.charAt(0) == 'A'){
            Error = false;
            text.setText("");
        }
        else if(commad.charAt(0) == '='){
            String str = eval(text.getText());
            if(Error){
                text.setText("ERROR");
                Error = false;
            } 
            else text.setText(str);
        }
        else{
            if(commad.charAt(0) >= '0' && commad.charAt(0) <= '9'){   
                int num = Integer.parseInt(commad);
                text.setText(text.getText() + num);
            }
            else{
                text.setText(text.getText() + commad);
            }
        }
    }

    public static String eval(String expression){
        char[] arr = expression.toCharArray();
        String operand = "";
        for(int i = 0 ; i < expression.length() ; i++){
            if(Character.isDigit(arr[i]) || arr[i] == '.'){
                char next = (i+1 < expression.length() ? arr[i+1] : '\0');
                operand += arr[i];
                if(!Character.isDigit(next) && next != '.'){
                    double var = Double.parseDouble(operand);
                    // System.out.println(var);
                    number.push(var);
                    operand = "";
                }
            }   
            else if(isOperator(arr[i])){
                if(op.empty() || getPrecedence(arr[i]) > getPrecedence(op.peek())){
                    // System.out.println(arr[i]);
                    op.push(arr[i]);
                }
                else{
                    while(!op.empty() && getPrecedence(arr[i]) <= getPrecedence(op.peek())){
                        // System.out.println(op.peek());
                        char top = op.peek();op.pop();
                        operation(top);
                    }
                    op.push(arr[i]);
                }
            }
            else if(arr[i] == '('){
                op.push(arr[i]);
            }
            else if(arr[i] == ')'){
                while(!op.empty() && op.peek() != '('){
                    char top = op.peek();op.pop();
                    operation(top);
                }

                if(!op.empty() && op.peek() == '('){
                    op.pop();
                }
                else{
                    Error = true;
                    break;
                }
            }
        }
        while(!op.empty() && !Error){
            if(!isOperator(op.peek())){
                Error = true;
                break;
            }
            char top = op.peek();op.pop();
            operation(top);
        }
        if(!Error){
            double result; 
            if(number.empty()) result = 0;
            else result = number.peek();number.pop();
            init();
            return Double.toString(result);
        }
        else{
            init();
            return "";
        }
    }

    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '/' || c == '*' || c == '%';
    }

    public static int getPrecedence(char c){
        if(c == '*' || c == '/' || c == '%'){
            return 2;
        }
        else if(c == '+' || c == '-'){
            return 1;
        }
        else return 0;
    }

    public static void operation(char operator){
        if(number.size() < 2){
            // System.out.println("Surprise!2" + number.size() + number.peek());
            Error = true;
        }
        else{
            double ans = 0;
            double op2 = number.peek();number.pop();
            double op1 = number.peek();number.pop();
            // System.out.println(op1);
            // System.out.println(op2);
            switch(operator){
                case '+':
                    ans = op1 + op2;
                    number.push(ans);
                    break;
                case '-':
                    ans = op1 - op2;
                    number.push(ans);
                    break; 
                case '/':
                    ans = op1 / op2;
                    number.push(ans);
                    break;
                case '*':
                    ans = op1 * op2;
                    number.push(ans);
                    break;
                case '%':
                    ans = op1 % op2;
                    number.push(ans);
                default:
                    break;
            }
        }
    }

    public static void init(){
        while(!op.empty()){
            op.pop();
        }
        while(!number.empty()){
            number.pop();
        }
    }
}
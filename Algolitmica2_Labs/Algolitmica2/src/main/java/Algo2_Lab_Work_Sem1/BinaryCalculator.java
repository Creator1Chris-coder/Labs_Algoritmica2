package Algo2_Lab_Work_Sem1;

public class BinaryCalculator {
    private int op1;
    private int op2;
    private String operando;

    public BinaryCalculator(int op1, int op2, String operando) {
        this.op1 = op1;
        this.op2 = op2;
        this.operando = operando;
    }

    public int calcular() {
        switch (operando) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if (op2 != 0) {
                    return op1 / op2;
                } else {
                    throw new ArithmeticException("División por cero");
                }
            default:
                throw new IllegalArgumentException("Operador inválido: " + operando);
        }
    }

    public static void main(String[] args) {
        BinaryCalculator calc = new BinaryCalculator(10, 5, "+");
        System.out.println("Resultado: " + calc.calcular());
    }
}

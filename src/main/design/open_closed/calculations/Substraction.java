package open_closed.calculations;

public class Substraction implements Operation
{
    private double firstOperand;
    private double secondOperand;
    private double result = 0.0;

    public Substraction(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    //Setters and getters

    @Override
    public void performOperation() {
        result = firstOperand - secondOperand;
    }

    @Override
    public double getResult() {
        return result;
    }
}
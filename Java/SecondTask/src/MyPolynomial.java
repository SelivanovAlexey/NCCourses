import java.math.*;

public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial(double... coeffs) { // индекс коэффицента соответствует степени переменной при которой он находится
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String polynom=""+coeffs[coeffs.length-1];
        for (int i = coeffs.length-1; i > 1; i--){
            polynom+="x^"+i+(0 > coeffs[i-1] ? coeffs[i-1] : "+"+coeffs[i-1]);  //если коэффицент отрицательный, то плюс перед ним не пишем
        }
        return polynom+="x"+(0 > coeffs[0] ? coeffs[0] : "+"+coeffs[0]);
    }

    public double evaluate(double x){
        double res = 0.0;
        for (int i = coeffs.length -1; i>=0; i--){
            res+=Math.pow(x,i)*coeffs[i];
        }
        return res;
    }

    public MyPolynomial add(MyPolynomial right){
        MyPolynomial newPol = new MyPolynomial(new double[Math.max(this.getDegree(),right.getDegree())+1]);
        for (int i = 0; i<=this.getDegree();i++) {
            newPol.coeffs[i]+=this.coeffs[i];
        }
        for (int i = 0; i<=right.getDegree();i++) {
            newPol.coeffs[i]+=right.coeffs[i];
        }
        return newPol;
    }

    public MyPolynomial multiply(MyPolynomial right){
        MyPolynomial newPol = new MyPolynomial(new double[this.getDegree()+right.getDegree()+1]);
        for (int i = 0; i <= this.getDegree(); i++){
            for (int j = 0; j <= right.getDegree(); j++){
                newPol.coeffs[i+j] += (this.coeffs[i] * right.coeffs[j]);
            }
        }
        return newPol;
    }

}

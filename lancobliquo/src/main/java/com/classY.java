
public class classY {
     public static double calcularObliquoY(double v0, double angulo) {
    double radianos = Math.toRadians(angulo); // converte o ângulo em graus para radianos
    double v0y = v0 * Math.sin(radianos);
    return v0y;
     }
}
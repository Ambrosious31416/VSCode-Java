import java.util.Scanner;

public class ASCII_A_Texto {
    public static void main(String[] args) throws Exception {
        try (Scanner X = new Scanner(System.in)) {
            System.out.println("Escribe el codigo ASCII: ");
            String Codigo_ASCII = X.nextLine();
            String resultado = Desifrar(Codigo_ASCII);
            System.out.println(resultado);
        }
    }

    public static String Desifrar(String Codigo_ASCII) {
        StringBuilder Mensaje = new StringBuilder();
        int i = 0;
        int Contador_Vocales = 0;
        boolean Encontrado = false;
        while (i < Codigo_ASCII.length()) {
            for (int j = 0; j <= 3; j++) {
                if (i + j <= Codigo_ASCII.length()) {
                    try {
                        int Codigo = Integer.parseInt(Codigo_ASCII.substring(i, i + j));
                        if (Codigo >= 32 && Codigo <= 122) {
                            char caracter = (char) Codigo;
                            Mensaje.append(caracter);
                            if ("AEIOUaeiou".indexOf(caracter) != -1) {
                                Contador_Vocales++;
                            }
                            i += j;
                            Encontrado = true;
                            break;
                        }
                    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());

                    }
                }
                if (!Encontrado) {
                    i++;
                }
            }
        }
        return Mensaje.toString() + "\nNúmero de vocales: " + Contador_Vocales;
    }
}
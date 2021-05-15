import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
public class ValidadorSenha {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            String senha = scanner.nextLine();







            if (caracterEspecial(senha) == false && caracterExigido(senha) == true && espacoVazio(senha) == false) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");
            }

        }





    }
    private static boolean espacoVazio(String palavra){
        String busca = "(?=.*\\s).{6,32}";

        return palavra.matches(busca);
    }

    private static boolean caracterEspecial(String palavra){
        String busca = "(?=.*\\W).{6,32}";

        return palavra.matches(busca);
    }

    private static boolean caracterExigido(String outrapalavra) {
        String busca = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,32}";

        return outrapalavra.matches(busca);
    }
}


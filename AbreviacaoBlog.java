import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class AbreviacaoBlog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // criando listas
        ArrayList list = new ArrayList();
        ArrayList listAlterada = new ArrayList();
        ArrayList listaPalavras = new ArrayList();
        ArrayList listaPalavrasAlteradas = new ArrayList();
        Set<Character> letraInicial = new HashSet<>();
        Set<String>palavraOrdenada = new TreeSet<>();

        // Criando variáveis
        String frase = "";
        String palavraSt = "";
        String palavra = "";
        String maiorPalavra = "";
        String palavraAntiga = "";
        String palavraNova = "";
        Integer contador = 0;
        Integer contadorPonto = 0;


        // Criando lista das palavras e letras
        while (st.hasMoreElements()) {
            palavraSt = st.nextToken();

            // Verificando a existência de ponto, se houver para
            if (palavraSt.indexOf('.')>-1 & palavraSt.length()>1){
                palavraSt = palavraSt.replaceAll("\\.","");
                contadorPonto ++;
                list.add(palavraSt);
                letraInicial.add(palavraSt.charAt(0));
                break;
            }

            // para palavras sem ponto e/ou pontos isolados
            if (palavraSt.indexOf('.')==-1) {
                list.add(palavraSt);
                letraInicial.add(palavraSt.charAt(0));
            } else {break;}
        }

        // separando as palavras maiores
        for (Character letra : letraInicial){

            for (int j = 0; j < list.size(); j++){
                palavra = (String) list.get(j);
                if (letra == palavra.charAt(0)){
                    if (palavra.length() > 2 & palavra.length() > contador) {
                        contador = palavra.length();
                        maiorPalavra = palavra;
                    }
                }
            }

            // Evitando a duplicidade e criando lista das palavras
            contador = 0;
            if (listaPalavras.size() > 0){
                if ( maiorPalavra != listaPalavras.get(listaPalavras.size()-1)) {
                    listaPalavras.add(maiorPalavra);
                    listaPalavrasAlteradas.add(maiorPalavra.charAt(0)+".");
                }
            }
            else {
                listaPalavras.add(maiorPalavra);
                listaPalavrasAlteradas.add(maiorPalavra.charAt(0)+".");
            }
        }

        // Copiando lista para troca de palavras
        listAlterada = (ArrayList)list.clone();


        // Trocando a palavra pela letra
        for (int i = 0; i < listaPalavras.size(); i++){
            palavraAntiga = (String) listaPalavras.get(i);
            palavraNova = palavraAntiga.charAt(0)+".";
            Collections.replaceAll(listAlterada, palavraAntiga, palavraNova );
        }

        // Montando a frase
        for (int i=0; i< list.size(); i++){
            frase = frase + listAlterada.get(i) + " ";
        }
        // if (contadorPonto > 0){
        //      frase = frase + ".";
        //  }

        // Ordenando as palavras
        palavraOrdenada.addAll(listaPalavras);



        // Imprimindo os valores
        System.out.println(frase);
        System.out.println(palavraOrdenada.size());
        for (String valor : palavraOrdenada){
            System.out.println(valor.charAt(0)+"."+" = "+valor);
        }



    }
}


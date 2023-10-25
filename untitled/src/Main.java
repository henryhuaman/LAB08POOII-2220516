import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String nombres = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // a
        List<String> cadAleatoria = Stream.generate(()->{
            int longitud = generarNumeroAleatorio(0,9);
            return Stream.generate(()-> {
                        int index = generarNumeroAleatorio(0,nombres.length()-1);
                        return nombres.charAt(index);
                    }).limit(longitud)
                    .map(Objects::toString)
                    .collect(Collectors.joining());
        }).limit(10)
                .map(Object::toString)
                .toList();

        System.out.println(cadAleatoria);

        //b.
        int comp = (int) cadAleatoria.stream().
                filter(word -> word.isEmpty())
                .count();

        System.out.println("numero de cadena que son nulas: "+comp);

        //c.
        int cadSupCinco = (int) cadAleatoria.stream().filter(word -> word.length()>5).count();

        System.out.println("numero de cadena que tienen longitud mayor ae 5  : "+cadSupCinco);

        //d.
        int cadS = (int) cadAleatoria.stream().filter(word -> word.startsWith("s")).count();
        System.out.println("numero de cademas que comienzan con S: "+cadS);

        //e.
        List<String> notCadEmp = cadAleatoria.stream().filter(word ->!word.isEmpty()).collect(Collectors.toList());
        System.out.println("lista sin cadenas vacias: "+notCadEmp);

        //f.
        List<String> listCadSupCinco = notCadEmp.stream().filter(word -> word.length()>5).collect(Collectors.toList());
        System.out.println("lista con cadenas con mas de 5 caracteres: "+listCadSupCinco);

        //g.
        String concat = listCadSupCinco.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println("lista concatenada: "+concat);


        //2.
    }
    public static int generarNumeroAleatorio(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("El valor mínimo debe ser menor que el valor máximo.");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
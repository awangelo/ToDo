package util;

import java.util.Scanner;

// InputUtil sera uma classe que nao deve ser instanciada nunca, por isso o uso de final.
public final class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    // Construtor privado para evitar instancia.
    private InputUtil() {
        throw new AssertionError();
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        int v = sc.nextInt();
        flush();
        return v;
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static void flush() {
        sc.nextLine();
    }
}
package com.el173.enigma.cipher;

class Motor {
    private static int[] s_b;
    private final static String k = "yourkeycomeshere";

    private static void sw(int[] s, int i, int j) {
        int t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    private static void itbx(String k, int kl) {
        s_b = new int[256];
        for (int i = 0; i < 256; i++)
            s_b[i] = i;
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (s_b[i] + k.charAt(i % kl) + j) % 256;
            sw(s_b, i, j);
        }
    }


    private static String g_c(String cipher) {
        int index = 0;
        int i = 0;
        int j = 0;
        StringBuffer plain = new StringBuffer();
        while (index < cipher.length() / 2) {
            i = (++i) % 256;
            j = (s_b[i] + j) % 256;
            sw(s_b, i, j);
            int temp = s_b[(s_b[i] + s_b[j]) % 256];
            StringBuffer tmp = new StringBuffer();
            tmp.append(cipher.charAt(index * 2));
            tmp.append(cipher.charAt(index * 2 + 1));
            int a = Integer.parseInt(tmp.toString(), 16);
            plain.append((char) (a ^ temp));
            index++;
        }

        return plain.toString();
    }

    private static String c_g(String plain) {
        int index = 0;
        int i = 0;
        int j = 0;
        StringBuffer cipher = new StringBuffer();
        while (index < plain.length()) {
            i = (++i) % 256;
            j = (s_b[i] + j) % 256;
            sw(s_b, i, j);
            int temp = s_b[(s_b[i] + s_b[j]) % 256];
            int a = plain.charAt(index);
            cipher.append(Integer.toHexString((temp ^ a)).length() == 2 ? Integer.toHexString((temp ^ a)).toUpperCase()
                    : ("0" + Integer.toHexString((temp ^ a)).toUpperCase()));
            index++;
        }

        return cipher.toString();
    }

    String descifrar(String s) {
        itbx(k, k.length());
        String newS = g_c(s);
        return  newS;
    }

    String cifrar(String s) {
        itbx(k, k.length());
        String newS = c_g(s);
        return  newS;
    }

}

package com.company;

import java.security.Key;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, String[]> dictionary = new HashMap<>();
        dictionary.put("дом", new String[]{"жилище", "хата", "берлога", "крыша"});
        dictionary.put("прекрасный", new String[]{"замечательный", "восхитительный", "шикарный"});
        dictionary.put("человек", new String[]{"сапиенс", "персона", "индивид", "личность"});
        dictionary.put("большой", new String[]{"огромный", "громадный", "великий"});

        for (Map.Entry<String, String[]> item : dictionary.entrySet()) {
            System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));

        }
        Map<String, String[]> bigDictionary = new HashMap<>();
        bigDictionary.putAll(dictionary);
        Set<String>keys = dictionary.keySet();

        Iterator<String[]>iterator = bigDictionary.values().iterator();
        while (iterator.hasNext()){
            for (int i = 0; i < keys.size(); i++) {
                String[] key = iterator.next();
                ArrayList<String[]> kkkk = new ArrayList<>();
                Collections.addAll(ArrayList< String[] >key);
            }
        }


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Tape a word:");
            String text = scanner.nextLine();
            String[] words = text.split(" ");
            for (String word : words) {
                try {
                    String[] synoniums = dictionary.get(word);
                    Random r = new Random();
                    int l = r.nextInt(synoniums.length);
                    System.out.print(synoniums[l] + " ");
                } catch (Exception e) {
                    System.out.println("There is no such word in dictionary");
                }
            }
            System.out.println();
        }


    }
}

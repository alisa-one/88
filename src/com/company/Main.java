package com.company;

import java.security.Key;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String[]> dictionary = new HashMap<>();
        HashMap<String, String[]> bigDictionary = new HashMap<>();
        dictionary.put("дом", new String[]{"жилище", "хата", "берлога", "крыша"});
        dictionary.put("прекрасный", new String[]{"замечательный", "восхитительный", "шикарный"});
        dictionary.put("человек", new String[]{"сапиенс", "персона", "индивид", "личность"});
        dictionary.put("большой", new String[]{"огромный", "громадный", "великий"});


        bigDictionary.putAll(dictionary);

        Set<String> keys = dictionary.keySet();

        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String oldKey = iterator.next();
            String[] oldValues = dictionary.get(oldKey);
            for (int i = 0; i < oldValues.length; i++) {
                String newKey = oldValues[i];
                ArrayList<String> valuesAsList = new ArrayList<>();
                Collections.addAll(valuesAsList, oldValues);
                valuesAsList.remove(newKey);
                valuesAsList.add(oldKey);
                String[] newValues = new String[valuesAsList.size()];
                valuesAsList.toArray(newValues);
                bigDictionary.put(newKey, newValues);
            }
        }
        for (Map.Entry<String, String[]> item : bigDictionary.entrySet()) {
            System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Tape a word:");
            String text = scanner.nextLine();
            String[] words = text.split(" ");
            for (String word : words) {
                try {
                    String[] synoniums = bigDictionary.get(word);
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

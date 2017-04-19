package fr.thiiozz.utils;


import fr.thiiozz.model.MongoWine;

import java.util.Random;

public class WineGenerator {
    private static String WINE_NAME_LIST[] = {"Chateau PUYGUERAUD", "Chateau LA PRADE", "Chateau REAUT", "Domaine de la solitude",
            "Château Latour Martillac", "Domaine de Chevalier", "Château Pape Clément", "Château Smith-Haut-Lafitte"};

    private static Random rand = new Random();

    public static MongoWine generateAndGetWine() {
        return new MongoWine(
                WINE_NAME_LIST[generateRandIntInInterval(0, WINE_NAME_LIST.length - 1)],
                generateRandIntInInterval(1950, 2016),
                generateRandIntInInterval(10, 200)
        );
    }

    private static int generateRandIntInInterval(int intervalStart, int intervalEnd){
        return rand.nextInt((intervalEnd - intervalStart) + 1) + intervalStart;
    }
}

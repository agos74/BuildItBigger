package com.example.jokes;

import java.util.Random;

public class JavaJokes {

    private final String[] jokes = new String[5];

    public JavaJokes() {
        jokes[0] = "What is red and smells like blue paint? Red paint.";
        jokes[1] = "A: Are not you wearing your wedding ring on the wrong finger?\n" +
                "B: Yes I am, I married the wrong woman.";
        jokes[2] = "Teacher: Maria please point to America on the map.\n" +
                "Maria: This is it.\n" +
                "Teacher: Well done. Now class, who found America?\n" +
                "Class: Maria did.";
        jokes[3] = "Teacher: Jack, what do you know about the Dead Sea?\n" +
                "Jack: I did not even know it was ill.";
        jokes[4] = "Where do zombies go swimming?\n" +
                "In the Dead Sea!";
    }

    public String getJoke() {
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}

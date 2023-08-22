package util;

import java.util.Random;

public class RandomNumber {
    public int GetRandomNumberInt(int maxValue) {
        Random r = new Random();
        return r.nextInt(maxValue) + 1;
    }
}

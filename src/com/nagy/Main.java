package com.nagy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        System.out.println(today);
        LocalDateTime alsoToday = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        System.out.println(alsoToday);

    }
}

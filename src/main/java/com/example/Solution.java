package com.example;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

  public static void main (String args[]){
      Game game = new Game();

      System.out.println("Game starts");

      do game = GameProcessor.process(game, ThreadLocalRandom.current().nextInt(0, 1 + 1));
      while (game.status == 0);

      System.out.println("Game ends");
  }
}

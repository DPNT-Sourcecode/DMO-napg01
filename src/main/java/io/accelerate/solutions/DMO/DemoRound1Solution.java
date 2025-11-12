package io.accelerate.solutions.DMO;

import io.accelerate.runner.SolutionNotImplementedException;

public class DemoRound1Solution {
  public int increment(int x) {
    return x + 1;
  }

  public String toUppercase(String text) {
    return text.toUpperCase();
  }

  public String letterToSanta() {
    return "Dear Santa, I want to rule the world.";
  }

  public int countLines(String text) {
    return Math.toIntExact(text.lines().count());
  }
}

package io.accelerate.solutions.DMO;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

class Waves {
  private static final String waveString = "____....~~~~''''~~~~....____";
  private static final int waveStringLength = waveString.length();

  private static final DecimalFormat df;

  static {
    df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.CEILING);
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      run(new ConsoleOutputSink(), Float.parseFloat(scanner.nextLine()));
    }
  }

  interface OutputSink {
    void print(String text);
  }

  static final class ConsoleOutputSink implements OutputSink {
    @Override
    public void print(String text) {
      System.out.print(text);
    }
  }

  static final class StringOutputSink implements OutputSink {
    private final StringBuilder builder = new StringBuilder();

    @Override
    public void print(String text) {
      builder.append(text);
    }

    public String content() {
      return builder.toString();
    }
  }

    public static String mid(String text, float startingIndex, float numChars) {
        return text.substring(Math.round(startingIndex - 1), Math.round(startingIndex + numChars - 1));
  }

  public static void run(OutputSink outputSink, float numberOfWaves) {
    final float waveLength = (float) waveStringLength / numberOfWaves;
    final float charsPerIteration = waveLength / (float) 7;
    System.err.println(charsPerIteration);

    for (int i = 0; i < numberOfWaves; i++) {
      for (int j = 1; j <= waveStringLength; j += 4) {
        outputSink.print(mid(waveString, j, charsPerIteration));
      }
    }
  }
}






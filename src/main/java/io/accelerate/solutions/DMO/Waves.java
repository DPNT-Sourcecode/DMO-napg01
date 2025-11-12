package io.accelerate.solutions.DMO;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

class Waves {
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

    void println();
  }

  static final class ConsoleOutputSink implements OutputSink {
    @Override
    public void print(String text) {
      System.out.print(text);
    }

    @Override
    public void println() {
      System.out.println();
    }
  }

  static final class StringOutputSink implements OutputSink {
    private final StringBuilder builder = new StringBuilder();

    @Override
    public void print(String text) {
      builder.append(text);
    }

    @Override
    public void println() {
      builder.append(System.lineSeparator());
    }

    public String content() {
      return builder.toString();
    }
  }

  private static final class Output {
    private final OutputSink sink;

    private Output(OutputSink sink) {
      this.sink = sink;
    }

    private void print(String variable) {
      sink.print(variable);
    }

    private void println() {
      sink.println();
    }
  }

  public static int asInt(float variable) {
    return Math.round(variable);
  }

  public static String mid(String text, float startingIndex, float numChars) {
    return text.substring(asInt(startingIndex - 1), asInt(startingIndex + numChars - 1));
  }

  public static void run(OutputSink outputSink, float numberOfWaves) {
    float scalarE = 7;
    float scalarI = 1;
    float scalarJ = 0;
    float scalarMS = 4;
    final String waveString = "____....~~~~''''~~~~....____";
    final float waveStringLength = (float) waveString.length();
    final float waveLength = waveStringLength / numberOfWaves;
    final float charsPerIteration = waveLength / scalarE;
    boolean loopActive11 = false;

    Output output = new Output(outputSink);

    int iterations = 0;

    i:
    for (int i = 0; i < numberOfWaves; i++) {
      int label = 10;
      loopActive11 = false;

      mainLoop:
      while (true) {
        iterations += 1;
        if (iterations > 99999) {
          output.print("INFINITE LOOP DETECTED. STOPPING EXECUTION.");
          output.println();
          break;
        }

        switch (label) {
          // 10FORI=1TOFSTEP1
          case 10:
            label = 11;
            break;
          // 11FORJ=1TOLSTEPMS
          case 11:
            label = 12;
            if (!loopActive11) {
              scalarJ = 1;
              loopActive11 = true;
            }
            if ((scalarJ - waveStringLength) * scalarMS > 0) {
              label = 14;
            }
            break;
          // 12PRINTMID$(W$,J,S);
          case 12:
            label = 13;
            output.print(mid(waveString, scalarJ, charsPerIteration));
            break;
          // 13NEXTJ
          case 13:
            scalarJ = scalarJ + scalarMS;
            label = 11;
            break;
          // 14NEXTI
          case 14:
            scalarI = scalarI + 1;
            continue i;
          default:
            throw new IllegalStateException("The label " + label + " is not recognized.");
        }
      }
    }
    output.println();
  }
}




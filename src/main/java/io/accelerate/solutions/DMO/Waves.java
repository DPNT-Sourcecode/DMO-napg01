package io.accelerate.solutions.DMO;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

class Waves {
  @FunctionalInterface
  interface InputProviderScalar {
    float fetch();
  }

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

    public StringBuilder builder() {
      return builder;
    }
  }

  private static final class Output {
    private final OutputSink sink;
    private int currentLineCharCount = 0;

    private Output(OutputSink sink) {
      this.sink = sink;
    }

    private void print(String variable) {
      sink.print(variable);
      currentLineCharCount += variable.length();
    }

    private void print(float variable) {
      String text = df.format(variable);
      sink.print(text);
      currentLineCharCount += text.length();
    }

    private void println() {
      sink.println();
      currentLineCharCount = 0;
    }

    private String tab(float numSpaces) {
      return " ".repeat(Math.round(numSpaces - currentLineCharCount));
    }
  }

  public static int asInt(float variable) {
    return Math.round(variable);
  }

  public static float roundDownToInt(float variable) {
    return (float) Math.floor(variable);
  }

  public static float random(int positiveInt) {
    return 0.5f;
  }

  public static String mid(String text, float startingIndex, float numChars) {
    return text.substring(asInt(startingIndex - 1), asInt(startingIndex + numChars - 1));
  }

  public static float len(String text) {
    return (float) text.length();
  }

  public static void run(OutputSink outputSink, float numberOfWaves) {
    int label = 5;

    float scalarE = 7;
    float scalarI = 0;
    float scalarJ = 0;
    float scalarMS = 4;
    float scalarN = 0;
    float scalarS = 0;
    String waveString = "____....~~~~''''~~~~....____";
      float waveStringLength = len(waveString);
    boolean loopActive11 = false;
    boolean loopActive10 = false;

    Output output = new Output(outputSink);

    int iterations = 0;

    mainLoop:
    while (true) {
      iterations += 1;
      if (iterations > 99999) {
        output.print("INFINITE LOOP DETECTED. STOPPING EXECUTION.");
        output.println();
        break mainLoop;
      }

      if (loopActive11 && label > 13) loopActive11 = false;
      if (loopActive10 && label > 14) loopActive10 = false;

      switch (label) {
        // 5N=L/F:S=N/E
        case 5:
          label = 10;
          scalarN = waveStringLength / numberOfWaves;
          scalarS = scalarN / scalarE;
          break;
        // 10FORI=1TOFSTEP1
        case 10:
          label = 11;
          if (loopActive10 == false) {
            scalarI = 1;
            loopActive10 = true;
          }
          if ((scalarI - numberOfWaves) * 1 > 0) {
            label = 90;
          }
          break;
        // 11FORJ=1TOLSTEPMS
        case 11:
          label = 12;
          if (loopActive11 == false) {
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
          output.print(mid(waveString, scalarJ, scalarS));
          break;
        // 13NEXTJ
        case 13:
          label = 14;
          scalarJ = scalarJ + scalarMS;
          label = 11;
          break;
        // 14NEXTI
        case 14:
          label = 90;
          scalarI = scalarI + 1;
          label = 10;
          break;
        // 90PRINT
        case 90:
          label = 99;
          output.println();
          break;
        // 99END
        case 99:
          label = 9999;
          label = 9999;
          break;
        case 9999:
          break mainLoop;
        default:
          throw new IllegalStateException("The label " + label + " is not recognized.");
      }
    }
  }
}




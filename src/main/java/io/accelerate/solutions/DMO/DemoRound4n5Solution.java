package io.accelerate.solutions.DMO;

public class DemoRound4n5Solution {
  public String waves(Integer numberOfWaves) {
    var outputSink = new Waves.StringOutputSink();
    Waves.run(outputSink, numberOfWaves);
    return outputSink.content();
  }
}


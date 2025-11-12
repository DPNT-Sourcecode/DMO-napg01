package io.accelerate.solutions.DMO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class WavesTest {
  @Test
  public void oneWave() {
    var waves = new DemoRound4n5Solution();
    var result = waves.waves(1);
    assertThat(result, is("____....~~~~''''~~~~....____"));
  }

  @Test
  public void twoWaves() {
    var waves = new DemoRound4n5Solution();
    var result = waves.waves(2);
    assertThat(result, is("__..~~''~~..____..~~''~~..__"));
  }

  @Test
  public void threeWaves() {
    var waves = new DemoRound4n5Solution();
    var result = waves.waves(3);
    assertThat(result, is("_.~'~.__.~'~.__.~'~._"));
  }

  @Test
  public void fourWaves() {
    var waves = new DemoRound4n5Solution();
    var result = waves.waves(4);
    assertThat(result, is("_.~'~.__.~'~.__.~'~.__.~'~._"));
  }
}



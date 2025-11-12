package io.accelerate.solutions.DMO;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoRound2Solution {
    public int arraySum(List<Integer> integerList) {
        return integerList.stream().mapToInt(x -> x).sum();
    }

    public List<Integer> intRange(int start, int end) {
        return IntStream.range(start, end).boxed().toList();
    }

    public List<Integer> filterPass(List<Integer> integerList, int threshold) {
        return integerList.stream().filter(x -> x >= threshold).toList();
    }
}


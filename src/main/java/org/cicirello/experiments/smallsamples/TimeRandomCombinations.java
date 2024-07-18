/*
 * Experiments generating small random samples.
 * Copyright (C) 2024 Vincent A. Cicirello
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.cicirello.experiments.smallsamples;

import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;
import org.cicirello.math.rand.EnhancedRandomGenerator;
import org.cicirello.math.rand.IndexPair;
import org.cicirello.math.rand.IndexTriple;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Experimental comparison of using arrays vs record objects when using results of methods that
 * generate pairs and triples of distinct integers.
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, <a
 *     href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a>
 */
public class TimeRandomCombinations {

  private static final long seed = 42;
  private static final EnhancedRandomGenerator generator =
      new EnhancedRandomGenerator(new SplittableRandom(seed));

  // This is to test cases, where array for result already exists.
  private static final int[] preConstructedArray2 = new int[2];
  private static final int[] preConstructedArray3 = new int[3];

  @State(Scope.Benchmark)
  public static class ExecutionPlan {

    @Param({"16", "64", "256", "1024"})
    public int n;
  }

  @Benchmark
  @Fork(value = 1)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @BenchmarkMode(Mode.AverageTime)
  public int nextIntPairReturningArray(ExecutionPlan plan) {
    int[] result = generator.nextIntPair(plan.n, null);
    int sum = result[0] + result[1];
    return sum;
  }

  @Benchmark
  @Fork(value = 1)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @BenchmarkMode(Mode.AverageTime)
  public int nextIntPairReturningIndexPair(ExecutionPlan plan) {
    IndexPair result = generator.nextIntPair(plan.n);
    int sum = result.i() + result.j();
    return sum;
  }

  @Benchmark
  @Fork(value = 1)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @BenchmarkMode(Mode.AverageTime)
  public int nextIntPairPreconstructedArray(ExecutionPlan plan) {
    generator.nextIntPair(plan.n, preConstructedArray2);
    int sum = preConstructedArray2[0] + preConstructedArray2[1];
    return sum;
  }

  @Benchmark
  @Fork(value = 1)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @BenchmarkMode(Mode.AverageTime)
  public int nextIntTripleReturningArray(ExecutionPlan plan) {
    int[] result = generator.nextIntTriple(plan.n, null);
    int sum = result[0] + result[1] + result[2];
    return sum;
  }

  @Benchmark
  @Fork(value = 1)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @BenchmarkMode(Mode.AverageTime)
  public int nextIntTripleReturningIndexPair(ExecutionPlan plan) {
    IndexTriple result = generator.nextIntTriple(plan.n);
    int sum = result.i() + result.j() + result.k();
    return sum;
  }

  @Benchmark
  @Fork(value = 1)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  @BenchmarkMode(Mode.AverageTime)
  public int nextIntTriplePreconstructedArray(ExecutionPlan plan) {
    generator.nextIntTriple(plan.n, preConstructedArray3);
    int sum = preConstructedArray3[0] + preConstructedArray3[1] + preConstructedArray3[2];
    return sum;
  }
}

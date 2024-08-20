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

import org.cicirello.math.rand.EnhancedRandomGenerator;
import org.cicirello.util.ArrayFiller;
import org.cicirello.util.ArrayMinimumLengthEnforcer;

/**
 * Implementation of Algorithm L from:
 *
 * <p>Kim-Hung Li. 1994. Reservoir-sampling algorithms of time complexity O(n(1 + log(N/n))). ACM
 * Trans. Math. Softw. 20, 4 (Dec. 1994), 481-493. https://doi.org/10.1145/198429.198435
 */
public final class ReservoirL {

  /**
   * Randomly samples k distinct elements from {0, 1, ..., n-1}.
   *
   * @param n size of set to sample from
   * @param k sample size
   * @param result an array for result, which if null or too small a new such array will be created.
   * @param generator source of randomness
   */
  public static int[] sampleReservoirL(
      int n, int k, int[] result, EnhancedRandomGenerator generator) {
    if (k > n) throw new IllegalArgumentException("k must be no greater than n");
    result = ArrayMinimumLengthEnforcer.enforce(result, k);
    ArrayFiller.fillPartial(result, k);
    double w = Math.exp(Math.log(generator.nextDouble()) / k);
    int i = k + (int) (Math.log(generator.nextDouble()) / Math.log(1 - w));
    while (i < n) {
      result[generator.nextInt(k)] = i;
      w = w * Math.exp(Math.log(generator.nextDouble()) / k);
      i += (int) (Math.log(generator.nextDouble()) / Math.log(1 - w)) + 1;
    }
    return result;
  }
}

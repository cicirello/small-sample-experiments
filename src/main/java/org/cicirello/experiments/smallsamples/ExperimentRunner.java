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

import java.io.IOException;

/**
 * Experiments generating small random samples.
 *
 * @author <a href=https://www.cicirello.org/ target=_top>Vincent A. Cicirello</a>, <a
 *     href=https://www.cicirello.org/ target=_top>https://www.cicirello.org/</a>
 */
public class ExperimentRunner {

  public static void main(String[] args) throws IOException {
    printCopyrightAndLicense();
    org.openjdk.jmh.Main.main(args);
  }

  /** Prints copyright and license notices. */
  private static void printCopyrightAndLicense() {
    System.out.println();
    System.out.println("Experiments generating small random samples");
    System.out.println("Copyright (C) 2024 Vincent A. Cicirello");
    System.out.println("This program comes with ABSOLUTELY NO WARRANTY.  This is free");
    System.out.println("software, and you are welcome to redistribute it under certain");
    System.out.println("conditions.  See the GNU General Public License for more");
    System.out.println("details: https://www.gnu.org/licenses/gpl-3.0.html");
    System.out.println();
  }
}

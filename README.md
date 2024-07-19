# Code to reproduce experiments from: Algorithms for Generating Small Random Samples

This repository contains the code and raw experiment data for the the following report:

> Vincent A. Cicirello. 2024. [Algorithms for Generating Small Random Samples](https://reports.cicirello.org/24/008/). Technical Report ALG-24-008, Cicirello.org, May 2024. [[PDF]](https://reports.cicirello.org/24/008/ALG-24-008.pdf)

The experiments utilize the [&rho;&mu;](https://rho-mu.cicirello.org/) library, version 4.0.0,
which is automatically imported during the build from the [Maven Central 
Repository](https://central.sonatype.com/artifact/org.cicirello/rho-mu).

## Building

To build the experiments with Maven, execute the following at the command line:

```shell
mvn clean package
```

The requirements for building the experiments is the same as for building
[&rho;&mu;](https://rho-mu.cicirello.org/) version 4.0.0. which is Java 17+.

## Running the Experiments

The above builds a `jar-with-dependencies` that is executable, and which will be found 
within the target directory, which is created if it doesn't already exist. You can then 
run it with the following:

```shell
java -jar target/small-sample-experiments-1.0.0-jar-with-dependencies.jar
```

## Data

If you just want to inspect the results from my run, you can find the data in [results.txt](results.txt).

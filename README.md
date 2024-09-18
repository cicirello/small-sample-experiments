# Code to reproduce experiments from: Algorithms for Generating Small Random Samples

Copyright &copy; 2024 Vincent A. Cicirello

This repository contains the code and raw experiment data for the the following journal article:

> Vincent A. Cicirello. 2024. [Algorithms for Generating Small Random Samples](https://www.cicirello.org/publications/cicirello2024spe.html). *Software: Practice and Experience*, 2024. doi:[10.1002/spe.3379](https://doi.org/10.1002/spe.3379). Access the [[Full-Text]](https://onlinelibrary.wiley.com/share/author/J3S4KWMDVFFZNMFS9RY5?target=10.1002/spe.3379).

The experiments utilize the [&rho;&mu;](https://rho-mu.cicirello.org/) library, version 4.2.0,
which is automatically imported during the build from the [Maven Central 
Repository](https://central.sonatype.com/artifact/org.cicirello/rho-mu).

| __DOI__ | [![DOI](doi.svg)](https://doi.org/10.1002/spe.3379) |
| :--- | :--- |
| __License__ | [![GitHub](https://img.shields.io/github/license/cicirello/small-sample-experiments)](LICENSE) | 

## Building

To build the experiments with Maven, execute the following at the command line:

```shell
mvn clean package
```

The requirements for building the experiments is the same as for building
[&rho;&mu;](https://rho-mu.cicirello.org/) version 4.2.0. which is Java 17+.

## Running the Experiments

The above builds a `jar-with-dependencies` that is executable, and which will be found 
within the target directory, which is created if it doesn't already exist. You can then 
run it with the following:

```shell
java -jar target/small-sample-experiments-1.0.0-jar-with-dependencies.jar
```

Note that this will take a couple hours to run in its entirety.

## Data

If you just want to inspect the results from my run, you can find the data 
in [results.txt](results.txt).

There is an additional data file, [results-with-rho-mu-4.0.0.txt](results-with-rho-mu-4.0.0.txt), 
from earlier runs with &rho;&mu; 4.0.0, where the `nextIntTriple` was implemented differently, 
and which didn't include reservoir L for comparison. This is the data for the version of the
experiments from earlier preprint versions of the paper.

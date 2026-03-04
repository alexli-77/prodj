<div align="center">
  <h1>ProDJ</h1>
</div>

`ProDJ` is a tool for serializing Java objects to plain code.
It uses these capabilities to automatically generate test-cases from a
production workload.

See [Serializing Java Objects in Plain Code](http://arxiv.org/pdf/2405.11294) (Julian Wachter, Deepika Tiwari, Martin Monperrus and Benoit Baudry), Journal of Software and Systems, 2025.

```bibtex
@article{2405.11294,
 title = {Serializing Java Objects in Plain Code},
 journal = {Journal of Systems and Software},
 year = {2025},
 doi = {10.1016/j.jss.2025.112721},
 author = {Julian Wachter and Deepika Tiwari and Martin Monperrus and Benoit Baudry},
 url = {http://arxiv.org/pdf/2405.11294},
}
```

## Setup
The easiest way to get an executable version of `ProDJ` is to use the provided
`flake.nix`:
1. Enter a dev-shell using `nix develop`
2. Run `java -jar rockstofetch/target/rockstofetch.jar --statistics <config file>`.
   You can find example config files in `rockstofetch/src/test/resources/`.

_____________________________________________

Updates on 20260303

Environment:

Maven : Apache Maven 3.9.12 

Java : openjdk version "17.0.18"

Windows X64

##How to run this project?

Step 1:

Compile and package : mvn -DskipTests package

Step 2:

Put the prodj\rockstofetch\src\test\resources\CodeMonkey.pdf to the root path of the Pdfbox

Step 3:

git clone https://github.com/apache/pdfbox.git -b trunk

Compile and package Pdfbox.

Step 4:

For windows: java -jar rockstofetch/target/rockstofetch.jar --statistics rockstofetch/src/test/resources/pdfbox_windows.json

For Mac: ...

For Linux: ...

## What will happen?

Data and new tests will be generated in the Pdfbox. 

## How the run the generated tests?

Set-Location 'C:\your_path\pdfbox'; mvn -Dtest=*RockyTest -Dsurefire.failIfNoSpecifiedTests=false test

![Generated tests](prodj\rockstofetch\src\test\resources\Capture.png)

# P4Grammar

CREATORS:

Philip Holler

Magnus Kirkegaard

Mads Faber

Mads Bau

Asger Bertel

Hannah Lockey
_________________________________________________
BEFORE GETTING STARTED
1. Install the IntelliJ ANTLR plugin called 'ANTLR v4 Grammar Plugin, v1.9'

2. Have Java 11 installed
_________________________________________________________________________

BUILD AND RUN THE COMPILER
1. Set the file to be compiled in the Compiler class.
2. Use the Maven build 'Build and run compiler'
_____________________________
BUILD AND RUN GENERATED MODULE
1. Use the Maven build 'Build and run Generated Module'

_________________________________
BUILD AND RUN TESTS
1. Use the Maven build "Build and run tests" (this also builds the compiler)

____________________________
TEST COVERAGE

1. Use the Maven build "Build and run tests"
2. Go to analyze -> Show Code Coverage Data -> + -> Select the /target/coverage-reports/jacoco-unit.exec 

___________________________________________
RUN JASMIN CODE / JAVA BYTE CODE VERSION
1. Set the source fil in the compiler to ByteCodeTestProgram.pvt
2. Compile using maven build 'Build and run compiler'. This gives the file PivotClass.J in the project root dir
3. Download jasmin .Jar file with this link (https://sourceforge.net/projects/jasmin/)
4. Use the Jasmin.jar file to translate from jasmin to ByteCode using the terminal and the following command '
java  -jar jasmin.jar PivotClass.j'
5. Run the ByteCode in the terminal with the following command 'java PivotClass'

HAVE FUN!

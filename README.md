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

BUILD THE COMPILER

1. Use the Maven build "Build Compiler"
________________________________________________
RUN THE COMPILER

This will translate the source file from Pivot language to Java.

1. Set the file to be compiled in the Compiler class under SOURCE_FILE (The file to be compiled must be located in the testProgramsPivot directory)

2. Run the Compiler.main class to compile a file
_____________________________
BUILD AND RUN GENERATED MODULE

1. Use the Maven build "Build Generated Module" to build the newly generated code.
2. Run the Main.main inside the server package

_________________________________
BUILD AND RUN TESTS
1. Use the Maven build "Build and run tests" (this also builds the compiler)


HAVE FUN!

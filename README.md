# P4Grammar

MAKE THE PROGRAM WORK
1. Import libraries to projekt from the libs folder
2. Chose the Pivot file in main class under String SOURCE_FILE
3. Run the /P4Grammar/src/main/Main.java class

_________________________________________________________________________

CHANGE THE GRAMMAR

If you want to change anything in the grammar, you need to download the following ANTLR plugins for intellij:
1. ANTLR v4 grammar plugin (version 1.9)
2. ANTLRWorks (version 1.3.1)

Also make sure to configure ANTLR. This is done by right clicking the grammarfile (.g4) and click configure ANTLR.
This should open up a new window.

Inside this window make sure, that the following options are checked:
1. Auto-generate parsers upon save
2. Generate Parse-tree visitor

Also inside the window fill out the following textboxes:
1. Output directory where all output is generated -> ".../P4Grammar/gen src/"
2. Package/namespace for the generated code -> "antlr"
________________________________________________
HAVE FUN!
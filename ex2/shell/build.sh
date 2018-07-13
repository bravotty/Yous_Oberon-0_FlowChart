cd ..
javac -d bin -classpath ../bin src/exceptions/*.java
javac -d bin -classpath ../bin src/OberonLexical.java
cd bin
javac -d . ../src/OberonComplierProgram.java
javac -d . ../src/Main.java
cd ..


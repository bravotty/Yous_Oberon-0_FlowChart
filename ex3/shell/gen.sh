cd ..
cd src
java -jar ../jflex/jflex-1.6.1.jar oberon.flex
java -jar ../javacup/java-cup-11b.jar -parser Parser -symbols Symbol -nonterms oberon.cup  
cd ..

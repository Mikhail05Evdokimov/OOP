javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.mevdokimov1

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\mevdokimov1\Heapsort.java

mkdir .\make\jar
jar cf .\make\jar\heapsort.jar -C .\make\bin .
java -classpath .\make\jar\Heapsort.jar ru.nsu.mevdokimov1.Heapsort

javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.mevdokimov1

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\mevdokimov1\MyStack.java

mkdir .\make\jar
jar cf .\make\jar\MyStack.jar -C .\make\bin .
# takesbug

```
mvn clean package
java -cp target/classes:target/dependency/* com.github.piotrkot.Bug
```
* Navigate to localhost:8080
* Clicking on *Bug* button results in exception IOException: Stream closed (https://github.com/yegor256/takes/issues/495)
* Clicking on *click* dropdown and mouse over options results in IOException: empty request (https://github.com/yegor256/takes/issues/495)
* When you navigate to localhost:8080/form, provide input name and submit than you will see the "hello 'user'!" message. When you go directly to localhost:8080/hello then the application hangs (https://github.com/yegor256/takes/issues/560)

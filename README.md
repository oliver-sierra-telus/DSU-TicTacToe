# TICTACTOE CONSOLE VERSION

## COMPILE

```bash
mvn compile
```

## EXECUTE

### Menu to select the UI
```bash
mvn exec:java -Dexec.mainClass=com.dsu.tictactoe.App
```

### Execute direct with Swing

```bash
mvn exec:java -Dexec.mainClass=com.dsu.tictactoe.App  -Dexec.args="1"
```

### Execute direct with Console

```bash
mvn exec:java -Dexec.mainClass=com.dsu.tictactoe.App  -Dexec.args="2"
```

## Error

If you have problems with the command you can try

```bash
mvn exec:java "-Dexec.mainClass=com.dsu.tictactoe.App"
```
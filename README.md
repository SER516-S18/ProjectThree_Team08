# ProjectThree_Team08

How to run

## Build jar file

```bash
$> git clone https://github.com/SER516/ProjectThree_Team08
$> cd ProjectThree_Team08
$> mvn package
```

## Start the server

Open a terminal and run the following command in the `target` directory:

```bash
$> java -jar ProjectThree_Team08-1.0-SNAPSHOT-jar-with-dependencies.jar
```

_If you are on Windows, make sure to change the classpath separator to ; instead of :_

## Launch a first client

Open a second terminal and run the following command in the `target` directory:

```bash
$> java -cp "ProjectThree_Team08-1.0-SNAPSHOT.jar:lib/*" client.controller.Client
```

_If you are on Windows, make sure to change the classpath separator to ; instead of :_



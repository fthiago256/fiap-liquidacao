./gradlew build

$ docker build --build-arg JAR_FILE=build/libs/\*.jar -t liquidacao/liquidacao-docker .

docker run -p 8081:8081 docker.io/liquidacao/liquidacao-docker
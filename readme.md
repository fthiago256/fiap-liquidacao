#FIAP MBA Arquitetura de Soluções

###Para buildar use:
`./gradlew build`

###Para buildar a imagem docker:
`docker build --build-arg JAR_FILE=build/libs/\*.jar -t liquidacao/liquidacao-docker .`

###Para rodar:
`docker run -p 8081:8081 docker.io/liquidacao/liquidacao-docker`

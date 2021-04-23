# FIAP MBA Arquitetura de Soluções
Este projeto é parte do entregável do trabalho da fase 6 do MBA de Arquitetura de soluções da FIAP
### Alunos
Mathias Arno Ludwig
Thiago Oliveira Ferreira

### Para buildar use:
```bash
./gradlew build`
```

### Para buildar a imagem docker:
```bash
docker build --build-arg JAR_FILE=build/libs/\*.jar -t liquidacao/liquidacao-docker .
```

### Para rodar:
```bash
docker run -p 8081:8081 docker.io/liquidacao/liquidacao-docker
```

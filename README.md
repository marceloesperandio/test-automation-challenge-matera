# 🧪 Desafio Técnico Matera - Cat Facts Breeds API

Este projeto automatiza os testes da API pública [Cat Facts](https://catfact.ninja/breeds), com foco no endpoint `/breeds`, como parte de um desafio técnico da empresa Matera.

As tecnologias e ferramentas utilizadas são:

- 🧪 **Cucumber (BDD)**
- ☕ **Java 21+**
- 🔧 **RestAssured**
- ✅ **JUnit 5**
- 📦 **Maven**
- 📊 **Allure Reports (opcional)**

---

## 📁 Estrutura do Projeto

```
src
├── main
│   └── java
│       ├── constants
│       │   ├── Endpoints.java
│       │   └── Path.java
│       ├── model
│       │   ├── BreedModel.java
│       │   ├── BreedResponseModel.java
│       │   └── LinkModel.java
│       ├── utils
│       │   ├── ConfigReader.java
│       │   └── Log.java
│       └── validations
│           └── BreedsFactory.java
├── test
│   ├── java
│   │   ├── api
│   │   │   └── BreedApi.java
│   │   ├── runners
│   │   │   └── TestRunners.java
│   │   └── steps
│   │       ├── CatFactsSteps.java
│   │       └── Hooks.java
│   └── resources
│       └── features
│           └── CatFacts.feature
```

---

## 🔗 Endpoint Testado

- `GET https://catfact.ninja/breeds?limit={value}`

---

## 📜 Pré-requisitos

- Java 21+
- Maven 3.11+
- IDE como IntelliJ ou VSCode

---

## ▶️ Executando os testes

```bash
# Executar os testes
mvn test

# Gerar relatório em HTML (com Allure)
mvn clean test
allure serve target/allure-results
```

---

## 🧪 Exemplos de Cenários

```gherkin
Feature: Cat Facts Breeds API

  @functional_tests @positive_tests
  Scenario: Valid request with limit=20
    Given I send a GET request with limit 20
    Then the response status code should be 200
    And the breeds list should contain 20 items

  @functional_tests @positive_tests
  Scenario: Valid request with limit=5
    Given I send a GET request with limit 5
    Then the response status code should be 200
    And the breeds list should contain 5 items

  @functional_tests @positive_tests
  Scenario: Valid request with limit=1
    Given I send a GET request with limit 1
    Then the response status code should be 200
    And the breeds list should contain 1 item

  @functional_tests @negative_tests
  Scenario: Invalid request with negative limit
    Given I send a GET request with limit -1
    Then the response status code should not be 200

  @functional_tests @negative_tests
  Scenario: Invalid request with large limit
    Given I send a GET request with limit 10000
    Then the response status code should not be 200

  @functional_tests @negative_tests
  Scenario: Invalid request with limit as string
    Given I send a GET request with invalid string limit
    Then the response status code should not be 200
```

---

## 🧠 Principais Classes

### ✅ `BreedsFactory.java`
Gera um objeto mockados (ou podemos criar um metodo que gere randomicante as informações) representando respostas da API, úteis para testes offline ou unitários.

### ✅ `BreedApi.java`
Centraliza a lógica de chamadas HTTP para o endpoint `/breeds` com uso do RestAssured.

### 🧠 `CatFactsSteps.java`
Implementa os passos descritos nos cenários Gherkin, conectando o Cucumber à lógica de teste.

### 🏃 `TestRunners.java`
Executa os testes BDD com Cucumber, definindo localização dos arquivos e plugins de relatório.

### 🔁 `Hooks.java`
Define ações globais executadas antes e depois de cada cenário, como logs ou limpeza de estado..

---

## 📈 Relatórios Allure (opcional)

Para visualizar relatórios Allure:

1. Adicione o plugin ao `pom.xml`:
```xml
<plugin>
  <groupId>io.qameta.allure</groupId>
  <artifactId>allure-maven</artifactId>
  <version>2.15.2</version>
</plugin>
```

2. Execute:
```bash
mvn clean test
allure serve target/allure-results
```

---

## 👨‍💻 Autor

- Marcelo Esperandio Lúcio
- QA Engineer | SDET

---

## 📄 Licença

Este projeto é de uso educacional e demonstração técnica.
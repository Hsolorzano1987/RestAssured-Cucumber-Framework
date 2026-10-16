# 🧪 RestAssured BDD - API Testing Framework

> Framework de automatización de pruebas de API construido con **Java 17**, **Maven**, **Cucumber (BDD)** y **RestAssured**, siguiendo el patrón **Page Object Model** adaptado a APIs y buenas prácticas de testing profesional.

[![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.18-23D96C?logo=cucumber&logoColor=white)](https://cucumber.io/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5.11-25A162?logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.5.0-6DB33F)](https://rest-assured.io/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](#-licencia)

> 🚧 **Proyecto en desarrollo activo.** Se irán agregando nuevos escenarios y recursos a medida que avance.

---

## 📋 Tabla de contenidos

- [Descripción](#-descripción)
- [Stack tecnológico](#-stack-tecnológico)
- [Arquitectura del framework](#-arquitectura-del-framework)
- [Requisitos previos](#-requisitos-previos)
- [Instalación](#-instalación)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Cómo ejecutar los tests](#-cómo-ejecutar-los-tests)
- [Escenarios BDD (Gherkin)](#-escenarios-bdd-gherkin)
- [Reportes](#-reportes)
- [Integración con CI/CD](#-integración-con-cicd)
- [Convenciones y buenas prácticas](#-convenciones-y-buenas-prácticas)
- [Roadmap](#-roadmap)
- [Autor](#-autor)
- [Licencia](#-licencia)

---

## 📖 Descripción

Este repositorio contiene un **framework de automatización de pruebas de API** diseñado bajo el enfoque **BDD (Behavior-Driven Development)**. Los escenarios se escriben en **Gherkin** (lenguaje natural) y se ejecutan mediante **Cucumber**, mientras que las interacciones HTTP se realizan con **RestAssured**.

**Características principales:**

- ✅ **BDD con Gherkin**: escenarios legibles por negocio y técnicos.
- ✅ **Separación de capas**: `features` (especificaciones), `steps` (lógica), `requests` (llamadas HTTP), `models` (DTOs), `utilities` (helpers).
- ✅ **Hooks de ciclo de vida**: configuración y limpieza centralizada con `@BeforeAll`, `@AfterAll`, etc.
- ✅ **Data-driven testing**: uso de **JavaFaker** para datos dinámicos y **Jackson** para serialización/deserialización.
- ✅ **Validación de esquemas JSON**: integración con `json-schema-validator`.
- ✅ **Logging estructurado**: Log4j 2 + SLF4J.
- ✅ **Reportes HTML** generados por Cucumber.

---

## 🛠 Stack tecnológico

| Herramienta | Versión | Rol |
|---|---|---|
| [Java](https://www.oracle.com/java/) | `17` | Lenguaje de programación |
| [Maven](https://maven.apache.org/) | `3.9+` | Gestor de dependencias y build |
| [Cucumber](https://cucumber.io/) | `7.18.0` | Motor BDD y ejecución de escenarios |
| [JUnit 5](https://junit.org/junit5/) | `5.11.0-M2` | Plataforma de ejecución de tests |
| [RestAssured](https://rest-assured.io/) | `5.5.0` | Cliente HTTP y validación de respuestas |
| [Jackson](https://github.com/FasterXML/jackson) | `2.17.1` | Serialización/deserialización JSON |
| [JavaFaker](https://github.com/DiUS/java-faker) | `1.0.2` | Generación de datos de prueba |
| [Log4j 2](https://logging.apache.org/log4j/2.x/) | `2.23.1` | Logging |
| [SLF4J](https://www.slf4j.org/) | `2.0.13` | Fachada de logging |

---

## 🏗 Arquitectura del framework

El framework sigue una **arquitectura en capas** que separa la especificación (feature), la orquestación (step definitions), la lógica de negocio (requests) y los datos (models):

```
┌─────────────────────────────────────────────┐
│           Features (.feature)                │  ← Gherkin: lenguaje de negocio
├─────────────────────────────────────────────┤
│        Step Definitions (steps/)             │  ← Traducción Gherkin → Java
├─────────────────────────────────────────────┤
│         Requests (requests/)                 │  ← Llamadas HTTP con RestAssured
├─────────────────────────────────────────────┤
│          Models (models/)                    │  ← DTOs / POJOs
├─────────────────────────────────────────────┤
│        Utilities (utilities/)                │  ← Helpers, config, readers
└─────────────────────────────────────────────┘
```

**Flujo de ejecución:**

1. Se cargan las `features` desde `src/test/resources/features/`.
2. El motor de Cucumber busca los `steps` en `hooks` y `steps` (configurado en `junit-platform.properties`).
3. Cada step ejecuta una acción sobre `requests/`, que usa `RestAssured` para hacer la petición HTTP.
4. Las respuestas se validan con asserts de JUnit 5 y `json-schema-validator`.
5. Los `hooks` se encargan de la configuración global y limpieza.

---

## ✅ Requisitos previos

| Herramienta | Verificar con |
|---|---|
| Java 17 (JDK) | `java -version` |
| Maven 3.9+ | `mvn -version` |
| Git | `git --version` |

> 💡 El proyecto incluye el **Maven Wrapper** (`mvnw` / `mvnw.cmd`), por lo que **no necesitas instalar Maven** si no quieres. El wrapper descarga la versión correcta automáticamente.

---

## 📦 Instalación

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/Hsolorzano1987/RestAssuredTestNgBDD.git
   cd RestAssuredTestNgBDD
   ```

2. **Compilar el proyecto** (descarga dependencias)

   ```bash
   mvn clean compile
   # o usando el wrapper:
   ./mvnw clean compile
   ```

   En Windows:
   ```powershell
   .\mvnw.cmd clean compile
   ```

3. **Verificar que todo esté listo**

   ```bash
   mvn clean test -Dgroups="regression" -DskipTests=false
   ```

---

## 🗂 Estructura del proyecto

```
RestAssuredTestNgBDD/
├── .mvn/wrapper/                    # Maven Wrapper
├── src/
│   ├── main/
│   │   └── resources/               # Recursos de la aplicación (si aplica)
│   └── test/
│       ├── java/
│       │   ├── hooks/               # Hooks de Cucumber (@Before, @After)
│       │   ├── models/              # DTOs / POJOs (request/response)
│       │   ├── principal/           # Clase runner principal (RunTests)
│       │   ├── requests/            # Lógica de llamadas HTTP con RestAssured
│       │   ├── steps/               # Step Definitions (Gherkin → Java)
│       │   └── utilities/           # Helpers, readers, config
│       └── resources/
│           ├── features/            # Archivos .feature (Gherkin)
│           │   ├── auth/
│           │   ├── posts/
│           │   ├── products/
│           │   └── users/
│           ├── logs/                # Archivos de log
│           ├── requestsBody/        # JSONs de payload para requests
│           ├── schemas/             # JSON Schemas para validación
│           └── junit-platform.properties  # Config de Cucumber/JUnit
├── .gitignore
├── mvnw / mvnw.cmd                  # Maven Wrapper scripts
├── openReport.sh                    # Script para abrir reporte HTML
├── runSuite.sh                      # Script para ejecutar suite de regresión
├── pom.xml
└── README.md
```

| Carpeta | Propósito |
|---|---|
| `hooks/` | Configuración y limpieza por escenario/feature |
| `models/` | Clases que representan los JSON de request/response |
| `requests/` | Encapsula las llamadas HTTP (RestAssured) por recurso |
| `steps/` | Implementación Java de cada paso Gherkin |
| `utilities/` | Funciones auxiliares: lectura de JSON, config, etc. |
| `features/` | Escenarios en Gherkin organizados por dominio |

---

## ▶️ Cómo ejecutar los tests

### Ejecutar toda la suite

```bash
mvn clean test
# o con wrapper:
./mvnw clean test
```

### Ejecutar solo el grupo de regresión

```bash
./mvnw clean test -Dgroups="regression"
```

### Ejecutar un feature específico

```bash
./mvnw clean test -Dcucumber.features="src/test/resources/features/users"
```

### Ejecutar por tag de Cucumber

```bash
./mvnw clean test -Dcucumber.filter.tags="@smoke"
```

### Usar el script incluido

```bash
# Linux/Mac
./runSuite.sh

# Windows (con Git Bash)
sh runSuite.sh
```

> 📌 `runSuite.sh` ejecuta `./mvnw clean test -Dgroups="regression"`

### Ver el reporte

```bash
# Linux/Mac
./openReport.sh

# Windows
start target/cucumber-html-reports/overview-features.html
```

---

## 🥒 Escenarios BDD (Gherkin)

Los escenarios se escriben en **Gherkin** y se organizan por dominio funcional:

| Feature | Ruta | Descripción |
|---|---|---|
| **Auth** | `features/auth/` | Login, registro, tokens |
| **Posts** | `features/posts/` | CRUD de publicaciones |
| **Products** | `features/products/` | CRUD de productos |
| **Users** | `features/users/` | CRUD de usuarios |

**Ejemplo de escenario:**

```gherkin
Feature: Users API

  Scenario: Obtener un usuario existente
    Given el endpoint "/users/1" está disponible
    When realizo una petición GET al endpoint
    Then el código de respuesta es 200
    And el body contiene el campo "name"
```

**Configuración de Cucumber** (`junit-platform.properties`):

```properties
cucumber.features=src/test/resources/features
cucumber.glue=hooks,steps
cucumber.plugin=pretty,json:target/cucumber/report.json
```

---

## 📊 Reportes

El proyecto genera un **reporte HTML de Cucumber** tras cada ejecución:

- **Ubicación:** `target/cucumber-html-reports/overview-features.html`
- **Contenido:** escenarios ejecutados, pasos passed/failed, tiempos, stack traces.

Para abrirlo:

```bash
# Linux/Mac
open target/cucumber-html-reports/overview-features.html

# Windows
start target/cucumber-html-reports/overview-features.html
```

---

## 🔄 Integración con CI/CD

El proyecto está preparado para integrarse con **GitHub Actions**. Un workflow básico sería:

```yaml
name: API Tests

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Run tests
        run: mvn clean test -Dgroups="regression"
      - name: Upload report
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: cucumber-report
          path: target/cucumber-html-reports/
```

> ⚠️ **Pendiente:** Este workflow aún no está implementado en el repositorio. Forma parte del roadmap.

---

## 🧭 Convenciones y buenas prácticas

- 📝 **Nombres de escenarios** descriptivos y en lenguaje de negocio.
- 🏷 **Tags** para organizar suites: `@smoke`, `@regression`, `@auth`, etc.
- 🧩 **Step Definitions** delgados: delegan la lógica a `requests/` y `utilities/`.
- 📦 **Models** como POJOs con Jackson para serialización limpia.
- 🔒 **Nunca** subir credenciales, tokens o archivos `.env` al repositorio.
- ✅ **Ejecutar localmente** antes de hacer push (`mvn clean test`).
- 📂 **Un feature por recurso** (users, posts, products, auth).

---

## 🗺 Roadmap

> 🚧 Proyecto **en desarrollo activo**.

- [x] Estructura base del framework BDD.
- [x] Integración de Cucumber + JUnit 5 + RestAssured.
- [x] Features para auth, users, posts y products.
- [x] Hooks de configuración y limpieza.
- [x] Reporte HTML de Cucumber.
- [ ] Cobertura completa de escenarios CRUD.
- [ ] Integración con CI/CD (GitHub Actions).
- [ ] Reporte con Allure.
- [ ] Data-driven testing con archivos externos (CSV/Excel).
- [ ] Validación de contratos con JSON Schema (parcialmente implementado).

---

## 👤 Autor

**Hernán Solórzano** — [@Hsolorzano1987](https://github.com/Hsolorzano1987)

---

<p align="center">
  Hecho con ❤️ usando <a href="https://cucumber.io/">Cucumber</a> + <a href="https://rest-assured.io/">RestAssured</a> + <a href="https://junit.org/junit5/">JUnit 5</a>
</p>

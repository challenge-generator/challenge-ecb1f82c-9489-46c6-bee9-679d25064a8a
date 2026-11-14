# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Mejora la Robustez de la API de Pagos**.

| | |
|---|---|
| Tema | Manejo de Excepciones y Depuración Efectiva |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- com.fasterxml.jackson.core:jackson-databind
- org.mockito:mockito-core
- org.postgresql:postgresql
- org.projectlombok:lombok
- org.springframework.boot:spring-boot-starter-actuator
- org.springframework.boot:spring-boot-starter-aop
- org.springframework.boot:spring-boot-starter-data-jpa
- org.springframework.boot:spring-boot-starter-validation

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Identificación de Excepciones**: Documento que lista las excepciones identificadas y sus categorías.
- **Fase 2 — Implementación de Manejo de Excepciones**: Código que implementa el manejo de excepciones en la API de Pagos.
- **Fase 3 — Depuración Efectiva**: Documento que describe las técnicas de depuración utilizadas y los problemas resueltos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/infrastructure/payment/PaymentRepositoryAdapter.java` — La fase "Identificación de Excepciones" se implementa aqui: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (2)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/domain/exception/PaymentValidationException.java` — `ValidationError.getField`
      Se invoca `getField` sobre `ValidationError`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/domain/exception/PaymentValidationException.java` — `ValidationError.getMessage`
      Se invoca `getMessage` sobre `ValidationError`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (11)

- `src/main/java/Application.java`
- `pom.xml`
- `src/main/java/domain/Payment.java`
- `src/main/java/domain/exception/PaymentCriticalException.java`
- `src/main/java/domain/exception/PaymentNonCriticalException.java`
- `src/main/java/domain/exception/PaymentValidationException.java`
- `src/main/java/domain/PaymentRepository.java`
- `src/main/java/application/dto/PaymentRequest.java`
- `src/main/java/infrastructure/payment/PaymentRepositoryAdapter.java`
- `src/main/resources/application.yml`
- `src/main/java/resources/application.yml`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/pragma/payments` (ausente)
- `src/main/java/com/pragma/payments/domain` (ausente)
- `src/main/java/com/pragma/payments/domain/exception` (ausente)
- `src/main/java/com/pragma/payments/application` (ausente)
- `src/main/java/com/pragma/payments/application/dto` (ausente)
- `src/main/java/com/pragma/payments/infrastructure` (ausente)
- `src/main/java/com/pragma/payments/infrastructure/audit` (ausente)
- `src/main/java/com/pragma/payments/infrastructure/payment` (ausente)
- `src/main/resources` (presente)
- `src/test/java/com/pragma/payments` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2
- Brecha que el reto ataca: Maneja correctamente las excepciones y depura el código para encontrar problemas cuando sea necesario., Maneja correctamente las excepciones y depura el código para encontrar problemas cuando sea necesario.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*

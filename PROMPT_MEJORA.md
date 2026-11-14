# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/infrastructure/payment/PaymentRepositoryAdapter.java` — La fase "Identificación de Excepciones" se implementa aqui: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/domain/exception/PaymentValidationException.java` — `ValidationError.getField`: Se invoca `getField` sobre `ValidationError`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/domain/exception/PaymentValidationException.java` — `ValidationError.getMessage`: Se invoca `getMessage` sobre `ValidationError`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Maneja correctamente las excepciones y depura el código para encontrar problemas cuando sea necesario., Maneja correctamente las excepciones y depura el código para encontrar problemas cuando sea necesario.

### Reto
- Tema: Manejo de Excepciones y Depuración Efectiva
- Seniority: advanced-l2
- Tipo: practical
- Título: Mejora la Robustez de la API de Pagos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Identificación de Excepciones — objetivo: Identificar y categorizar las excepciones que pueden ocurrir en la API de Pagos. — entregable (NO resolver): Documento que lista las excepciones identificadas y sus categorías.
- Fase 2: Implementación de Manejo de Excepciones — objetivo: Implementar el manejo de excepciones en la API de Pagos. — entregable (NO resolver): Código que implementa el manejo de excepciones en la API de Pagos.
- Fase 3: Depuración Efectiva — objetivo: Implementar técnicas de depuración efectiva para identificar y resolver problemas en la API de Pagos. — entregable (NO resolver): Documento que describe las técnicas de depuración utilizadas y los problemas resueltos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/main/java/Application.java ===
package com.pragma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pragma"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/domain/Payment.java ===
package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import domain.exception.PaymentValidationException;

public class Payment {
    private final UUID id;
    private final String accountId;
    private final BigDecimal amount;
    private final String currency;
    private final String recipientAccount;
    private final LocalDateTime createdAt;
    private PaymentStatus status;

    public Payment(UUID id, String accountId, BigDecimal amount, String currency,
                  String recipientAccount, LocalDateTime createdAt, PaymentStatus status) {
        this.id = id;
        this.accountId = validateAccountId(accountId);
        this.amount = validateAmount(amount);
        this.currency = validateCurrency(currency);
        this.recipientAccount = validateRecipientAccount(recipientAccount);
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.status = status != null ? status : PaymentStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    private String validateAccountId(String accountId) {
        if (accountId == null || accountId.trim().isEmpty()) {
            throw new PaymentValidationException("Account ID cannot be null or empty");
        }
        return accountId;
    }

    private BigDecimal validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PaymentValidationException("Amount must be positive");
        }
        return amount;
    }

    private String validateCurrency(String currency) {
        if (currency == null || currency.trim().isEmpty() || currency.trim().length() != 3) {
            throw new PaymentValidationException("Currency must be a 3-letter code");
        }
        return currency.toUpperCase();
    }

    private String validateRecipientAccount(String recipientAccount) {
        if (recipientAccount == null || recipientAccount.trim().isEmpty()) {
            throw new PaymentValidationException("Recipient account cannot be null or empty");
        }
        return recipientAccount;
    }

    public enum PaymentStatus {
        PENDING,
        PROCESSED,
        FAILED,
        REVERSED
    }
}

// === ARCHIVO: src/main/java/domain/exception/PaymentCriticalException.java ===
package domain.exception;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentCriticalException extends RuntimeException {
    private final UUID errorId;
    private final LocalDateTime timestamp;
    private final String serviceName;
    private final String errorCode;

    public PaymentCriticalException(String message, String serviceName, String errorCode) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
    }

    public PaymentCriticalException(String message, Throwable cause, String serviceName, String errorCode) {
        super(message, cause);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String toLogString() {
        return String.format("[CRITICAL] ErrorId=%s, Timestamp=%s, Service=%s, Code=%s, Message=%s",
                errorId, timestamp, serviceName, errorCode, getMessage());
    }

    public static PaymentCriticalException fromExternalServiceFailure(String serviceName, String errorCode, Throwable cause) {
        String message = String.format("Critical failure in external service %s with error code %s", serviceName, errorCode);
        return new PaymentCriticalException(message, cause, serviceName, errorCode);
    }

    public static PaymentCriticalException databaseUnavailable(String serviceName) {
        return new PaymentCriticalException("Database is unavailable", serviceName, "DB_UNAVAILABLE");
    }

    public static PaymentCriticalException auditServiceFailure(String serviceName) {
        return new PaymentCriticalException("Audit service failed to record payment", serviceName, "AUDIT_FAILURE");
    }
}

// === ARCHIVO: src/main/java/domain/exception/PaymentNonCriticalException.java ===
package domain.exception;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import domain.Payment;

public class PaymentNonCriticalException extends Exception {
    private final UUID errorId;
    private final LocalDateTime timestamp;
    private final String serviceName;
    private final String errorCode;
    private final Severity severity;

    public enum Severity {
        LOW,
        MEDIUM,
        HIGH
    }

    public PaymentNonCriticalException(String message, String serviceName, String errorCode, Severity severity) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
        this.severity = severity;
    }

    public PaymentNonCriticalException(String message, Throwable cause, String serviceName, String errorCode, Severity severity) {
        super(message, cause);
        this.errorId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.serviceName = serviceName;
        this.errorCode = errorCode;
        this.severity = severity;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String toLogString() {
        return String.format("[NON_CRITICAL] ErrorId=%s, Timestamp=%s, Service=%s, Code=%s, Severity=%s, Message=%s",
                errorId, timestamp, serviceName, errorCode, severity, getMessage());
    }

    public static PaymentNonCriticalException insufficientFunds(String accountId, BigDecimal amount, String currency) {
        String message = String.format("Insufficient funds in account %s for amount %s %s", accountId, amount, currency);
        return new PaymentNonCriticalException(message, "PaymentService", "INSUFFICIENT_FUNDS", Severity.HIGH);
    }

    public static PaymentNonCriticalException duplicatePayment(String paymentId) {
        String message = String.format("Payment with ID %s already processed", paymentId);
        return new PaymentNonCriticalException(message, "PaymentService", "DUPLICATE_PAYMENT", Severity.MEDIUM);
    }

    public static PaymentNonCriticalException invalidRecipient(String recipientAccount) {
        String message = String.format("Recipient account %s is invalid or blocked", recipientAccount);
        return new PaymentNonCriticalException(message, "PaymentService", "INVALID_RECIPIENT", Severity.MEDIUM);
    }

    public static PaymentNonCriticalException fromExternalServiceWarning(String serviceName, String errorCode, String message) {
        return new PaymentNonCriticalException(message, serviceName, errorCode, Severity.LOW);
    }
}

// === ARCHIVO: src/main/java/domain/exception/PaymentValidationException.java ===
package domain.exception;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PaymentValidationException extends RuntimeException {
    private final UUID errorId;
    private final List<ValidationError> validationErrors;

    public static class ValidationError {
        private final String field;
        private final String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

    public PaymentValidationException(String message) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.validationErrors = Collections.emptyList();
    }

    public PaymentValidationException(String message, List<ValidationError> validationErrors) {
        super(message);
        this.errorId = UUID.randomUUID();
        this.validationErrors = Collections.unmodifiableList(validationErrors);
    }

    public UUID getErrorId() {
        return errorId;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public String toLogString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[VALIDATION] ErrorId=").append(errorId)
          .append(", Message=").append(getMessage());

        if (!validationErrors.isEmpty()) {
            sb.append(", Errors=[");
            for (int i = 0; i < validationErrors.size(); i++) {
                ValidationError error = validationErrors.get(i);
                sb.append("{field=").append(error.getField())
                  .append(", message=").append(error.getMessage())
                  .append("}");
                if (i < validationErrors.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public static PaymentValidationException forSingleField(String field, String message) {
        return new PaymentValidationException("Validation failed for field: " + field,
                List.of(new ValidationError(field, message)));
    }

    public static PaymentValidationException forMultipleFields(List<ValidationError> errors) {
        String message = String.format("Validation failed for %d fields", errors.size());
        return new PaymentValidationException(message, errors);
    }
}

// === ARCHIVO: src/main/java/domain/PaymentRepository.java ===
package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import domain.exception.PaymentNonCriticalException;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(UUID id);
    boolean existsById(UUID id);

    default void validatePaymentDoesNotExist(UUID paymentId) {
        if (existsById(paymentId)) {
            try {
                throw new PaymentNonCriticalException(
                    "Payment with ID " + paymentId + " already exists",
                    "PaymentRepository",
                    "DUPLICATE_PAYMENT",
                    PaymentNonCriticalException.Severity.MEDIUM
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }
    }

    default void validatePaymentCanBeProcessed(Payment payment) {
        if (payment == null) {
            try {
                throw new PaymentNonCriticalException(
                    "Payment cannot be null",
                    "PaymentRepository",
                    "NULL_PAYMENT",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }

        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            try {
                throw new PaymentNonCriticalException(
                    "Payment amount must be positive",
                    "PaymentRepository",
                    "INVALID_AMOUNT",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }

        if (payment.getAccountId() == null || payment.getAccountId().isBlank()) {
            try {
                throw new PaymentNonCriticalException(
                    "Account ID cannot be null or blank",
                    "PaymentRepository",
                    "INVALID_ACCOUNT_ID",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }

        if (payment.getRecipientAccount() == null || payment.getRecipientAccount().isBlank()) {
            try {
                throw new PaymentNonCriticalException(
                    "Recipient account cannot be null or blank",
                    "PaymentRepository",
                    "INVALID_RECIPIENT",
                    PaymentNonCriticalException.Severity.HIGH
                );
            } catch (PaymentNonCriticalException e) {
                throw new RuntimeException(e);
            }
        }
    }

    default boolean isPaymentPending(Payment payment) {
        return payment != null && payment.getStatus() == Payment.PaymentStatus.PENDING;
    }

    default boolean isPaymentCompleted(Payment payment) {
        return payment != null && payment.getStatus() == Payment.PaymentStatus.PENDING;
    }

    default boolean isPaymentFailed(Payment payment) {
        return payment != null && payment.getStatus() == Payment.PaymentStatus.FAILED;
    }

    default Payment createNewPayment(UUID id, String accountId, BigDecimal amount, 
                                     String currency, String recipientAccount) {
        return new Payment(
            id,
            accountId,
            amount,
            currency,
            recipientAccount,
            LocalDateTime.now(),
            Payment.PaymentStatus.PENDING
        );
    }

    default void markPaymentAsCompleted(Payment payment) {
        if (payment != null) {
            payment.setStatus(Payment.PaymentStatus.PENDING);
        }
    }

    default void markPaymentAsFailed(Payment payment) {
        if (payment != null) {
            payment.setStatus(Payment.PaymentStatus.FAILED);
        }
    }

    default void markPaymentAsPending(Payment payment) {
        if (payment != null) {
            payment.setStatus(Payment.PaymentStatus.PENDING);
        }
    }
}

// === ARCHIVO: src/main/java/application/dto/PaymentRequest.java ===
package application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record PaymentRequest(
    @NotNull(message = "Account ID cannot be null")
    @Size(min = 1, message = "Account ID cannot be empty")
    String accountId,

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    BigDecimal amount,

    @NotNull(message = "Currency cannot be null")
    @Size(min = 3, max = 3, message = "Currency must be a 3-letter code")
    String currency,

    @NotNull(message = "Recipient account cannot be null")
    @Size(min = 1, message = "Recipient account cannot be empty")
    String recipientAccount
) {
}

// === ARCHIVO: src/main/java/infrastructure/payment/PaymentRepositoryAdapter.java ===
package infrastructure.payment;

import domain.Payment;
import domain.PaymentRepository;
import java.util.Optional;
import java.util.UUID;

public class PaymentRepositoryAdapter implements PaymentRepository {

    @Override
    public Payment save(Payment payment) {
        // TODO(reto): Implementar la persistencia del pago en la base de datos.
        // El método debe guardar el Payment y retornarlo con su estado actualizado.
        // Considerar el manejo de errores de base de datos.
        throw new UnsupportedOperationException("TODO(reto): Implementar persistencia del pago");
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        // TODO(reto): Implementar la búsqueda de un pago por su ID.
        // Retorna un Optional con el pago si existe, o vacío si no se encuentra.
        throw new UnsupportedOperationException("TODO(reto): Implementar búsqueda por ID");
    }

    @Override
    public boolean existsById(UUID id) {
        // TODO(reto): Verificar si existe un pago con el ID proporcionado.
        // Retorna true si existe, false en caso contrario.
        throw new UnsupportedOperationException("TODO(reto): Implementar verificación de existencia");
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: payment-api
  datasource:
    url: jdbc:postgresql://localhost:5432/paymentdb
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
    open-in-view: false
  jackson:
    serialization:
      write-dates-as-timestamps: false
    deserialization:
      fail-on-unknown-properties: false
    default-property-inclusion: non_null

server:
  port: 8080
  servlet:
    context-path: /api
  compression:
    enabled: true
    mime-types: application/json,application/xml,text/html,text/xml,text/plain

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
      base-path: /actuator
  endpoint:
    health:
      show-details: when_authorized
      probes:
        enabled: true
  health:
    db:
      enabled: true
    diskspace:
      enabled: true
  metrics:
    export:
      prometheus:
        enabled: true

logging:
  level:
    root: INFO
    com.example: DEBUG
    org.springframework.web: INFO
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.jdbc.core: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  file:
    name: logs/payment-api.log
    max-size: 10MB
    max-history: 30

app:
  payment:
    retry:
      max-attempts: 3
      initial-interval: 1000
      multiplier: 2.0
    circuit-breaker:
      failure-threshold: 5
      wait-duration: 30000
      half-open-requests: 3
    rate-limit:
      requests-per-second: 100
      burst-capacity: 200

// === ARCHIVO: src/main/java/resources/application.yml ===
spring:
  application:
    name: payments-api
  datasource:
    url: jdbc:postgresql://localhost:5432/paymentsdb
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
      pool-name: PaymentsHikariPool
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
    open-in-view: false
  jackson:
    serialization:
      write-dates-as-timestamps: false
    deserialization:
      fail-on-unknown-properties: false
    default-property-inclusion: non_null

server:
  port: 8080
  servlet:
    context-path: /api/v1
    encoding:
      charset: UTF-8
      enabled: true
      force: true

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
      base-path: /actuator
  endpoint:
    health:
      show-details: always
      show-components: always
  health:
    livenessState:
      enabled: true
    readinessState:
      enabled: true
    db:
      enabled: true
  metrics:
    export:
      prometheus:
        enabled: true

logging:
  level:
    root: INFO
    com.pragma: DEBUG
    org.springframework.web: DEBUG
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.postgresql: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  file:
    name: logs/payments-api.log
    max-size: 10MB
    max-history: 30

app:
  payment:
    max-amount: 100000.00
    supported-currencies: USD,EUR,MXN,GBP
    retry-attempts: 3
    timeout-seconds: 30
  audit:
    enabled: true
    async: true

resilience4j:
  circuitbreaker:
    instances:
      paymentService:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
  retry:
    instances:
      paymentService:
        maxAttempts: 3
        waitDuration: 2s
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
  ratelimiter:
    instances:
      paymentService:
        registerHealthIndicator: false
        limitForPeriod: 100
        limitRefreshPeriod: 1s
        timeoutDuration: 0

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
```

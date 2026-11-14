# Mejora la Robustez de la API de Pagos

La API de Pagos de nuestro sistema de banca en línea debe manejar correctamente las excepciones y permitir una depuración efectiva para identificar y resolver problemas rápidamente. La API interactúa con el servicio de procesamiento de pagos y el sistema de auditoría. Debe asegurar que los errores críticos se manejen de manera que no afecten la disponibilidad del servicio y que los errores no críticos se registren para su posterior análisis.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Manejo de Excepciones y Depuración Efectiva |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Identificación de Excepciones

**Objetivo:** Identificar y categorizar las excepciones que pueden ocurrir en la API de Pagos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Analiza el flujo de la API de Pagos y determina los posibles puntos de falla.
- Categoriza las excepciones en críticas y no críticas.
- Documenta las excepciones identificadas y sus categorías.

**Entregable:** Documento que lista las excepciones identificadas y sus categorías.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las interacciones con servicios externos y las validaciones de entrada.
- Piensa en los diferentes tipos de errores que pueden ocurrir (por ejemplo, timeouts, errores de validación, fallos de red).

</details>

### Fase 2: Implementación de Manejo de Excepciones

**Objetivo:** Implementar el manejo de excepciones en la API de Pagos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Utiliza las categorías de excepciones identificadas en la fase anterior para implementar el manejo de excepciones en la API.
- Asegúrate de que las excepciones críticas no afecten la disponibilidad del servicio y que las excepciones no críticas se registren adecuadamente.
- Prueba el manejo de excepciones con diferentes escenarios de error.

**Entregable:** Código que implementa el manejo de excepciones en la API de Pagos.

<details>
<summary>Pistas de conocimiento</summary>

- Usa bloques try-catch para capturar y manejar las excepciones.
- Considera el uso de registros para documentar las excepciones no críticas.

</details>

### Fase 3: Depuración Efectiva

**Objetivo:** Implementar técnicas de depuración efectiva para identificar y resolver problemas en la API de Pagos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Utiliza herramientas de depuración para identificar y resolver problemas en la API de Pagos.
- Documenta las técnicas de depuración utilizadas y los problemas resueltos.
- Prueba la API con diferentes escenarios de error para verificar la efectividad de las técnicas de depuración implementadas.

**Entregable:** Documento que describe las técnicas de depuración utilizadas y los problemas resueltos.

<details>
<summary>Pistas de conocimiento</summary>

- Usa el depurador integrado en tu IDE para identificar problemas en el código.
- Considera el uso de logs y registros para rastrear el flujo de la API y detectar errores.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las excepciones y por qué son importantes en la API de Pagos?
- **paraQueSirve**: ¿Para qué sirve el manejo de excepciones en la API de Pagos?
- **comoSeUsa**: ¿Cómo se implementa el manejo de excepciones en la API de Pagos?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir en la API de Pagos y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica el manejo de excepciones en la API de Pagos?

## Criterios de Evaluacion

- Identificación y categorización de excepciones en la API de Pagos.
- Implementación del manejo de excepciones en la API de Pagos.
- Uso de técnicas de depuración para identificar y resolver problemas en la API de Pagos.
- Documentación de las excepciones identificadas, el manejo de excepciones implementado y las técnicas de depuración utilizadas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*

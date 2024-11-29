# Sistema de Misiones de los Caballeros del Zodiaco

Este proyecto tiene como objetivo modelar un sistema de misiones de los Caballeros del Zodiaco utilizando programación orientada a objetos (POO) y estructuras de datos.

## Objetivos

- **Aplicar conocimientos adquiridos:** Usar conceptos de POO y estructuras de datos.
- **Análisis de problemas:** Identificar los datos y procesos relevantes.
- **Evaluación de soluciones:** Proponer alternativas y justificar la solución seleccionada en base a principios de estructuras de datos.

## Descripción del Problema

Los Caballeros del Zodiaco tienen asignadas misiones para proteger la paz y la justicia del Santuario. Cada misión asignada a un caballero incluye los siguientes atributos:

### Atributos de la misión:
- **ID del caballero:** Identificador único.
- **Nombre del caballero.**
- **Rango del caballero:** Bronce, Plata o Oro.
- **Constelación del caballero.**
- **Nivel de poder:** Valor entre 1 y 10.
- **Misión asignada.**
- **Nivel de dificultad de la misión:** Valor entre 1 y 5.
- **Recompensa por misión:** En monedas doradas.
- **Aporte al Fondo del Santuario:** 10% de la recompensa.
- **Impuesto del Reino de Atena:** Según la siguiente tabla:

| Recompensa Anual          | Impuesto                       |
|---------------------------|--------------------------------|
| <= 100,000                | 0%                             |
| > 100,000 y <= 200,000    | 12% del exceso sobre 100,000   |
| > 200,000 y <= 400,000    | 25% del exceso sobre 200,000   |
| > 400,000                 | 35% del exceso sobre 400,000   |

## Requerimientos del Programa

1. **Registrar los datos de un caballero**:
   - ID, nombre, rango, constelación, nivel de poder, misión, nivel de dificultad, recompensa.
   
2. **Modificar los datos de un caballero**:
   - Modificación de datos utilizando el **ID** como referencia.
   
3. **Listar los caballeros registrados**:
   - Mostrar toda la información de los caballeros registrados.

4. **Generar informe detallado**:
   - Informe con los siguientes datos:
     - Nombre del caballero.
     - Rango.
     - Constelación.
     - Nivel de poder.
     - Misión asignada.
     - Recompensa.
     - Aporte al Fondo del Santuario.
     - Impuesto del Reino.
     - Recompensa neta a recibir (Recompensa - Impuestos - Aporte).

## Implementación

La implementación utiliza **listas enlazadas** para almacenar la información de los caballeros. Se incluye un sistema para agregar, modificar, listar y ordenar los datos, así como para calcular los aportes e impuestos.

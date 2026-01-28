# LegendaryContent

A small **legendary content** mod built to dogfood **LegendaryCore** (Hytale mod foundation).

## Purpose

This repo intentionally implements encounter mechanics *outside* LegendaryCore first.
Only proven seams get promoted into core.

## What's here

- A toy encounter definition (`ToyLightningEncounterDefinition`).
- A content-side script abstraction (`EncounterScript`) and example script (`ToyLightningScript`).
- Content-side wiring:
  - `ScriptedEncounterManager` (decorates `EncounterManager` to call script hooks on join/end)
  - `ScriptEventBridge` (subscribes to core events for start/end and calls script hooks)

## Run tests

```
./gradlew clean test
```

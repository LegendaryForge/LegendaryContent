# LegendaryContent

A small **legendary content** mod built to dogfood **LegendaryCore** (Hytale mod foundation).

## Purpose

This repo intentionally implements encounter mechanics *outside* LegendaryCore first.
Only proven seams get promoted into core.

## What's here

- A toy encounter definition (`ToyLightningEncounterDefinition`).
- A content-side script abstraction (`EncounterScript`) and example script (`ToyLightningScript`).
- Content-side wiring:
  - `ScriptedEncounterManager` (decorates `EncounterManager` to call script hooks on join)
  - `ScriptEventBridge` (subscribes to core events for start/end and calls script hooks)

## Run tests

```
./gradlew clean test
```

## Scope boundary (important)

This repo focuses on **content-side behavior** once a player is admitted to an encounter (start semantics, spectator joins, script hooks, deterministic patterns).

**Party membership / access control** (e.g., PARTY_ONLY, INVITE_ONLY, late-joiner rules, PartyDirectory wiring) is treated as a **separate concern** and is validated in:
- **LegendaryCore** integration tests
- **LegendaryDogfood** consumer-side contract tests

LegendaryContent intentionally avoids coupling content scripts to party mechanics unless a specific content feature requires it.

# LegendaryContent

LegendaryContent is a dogfooding and validation mod used to test LegendaryCore and Legendary gameplay systems in a controlled environment.

This repository exists to validate encounter lifecycle seams, activation wiring, and content-side behavior outside of Core before APIs are promoted upstream.

---

## Purpose

LegendaryContent intentionally implements behavior on the content side first.

Only seams that prove:
- necessary,
- stable,
- and generally reusable

are candidates for eventual promotion into LegendaryCore.

This keeps Core minimal and prevents premature abstraction.

---

## What’s Here

- Dogfood harness tests that validate end-to-end behavior against live code
- Composite-build style experiments when needed to test cross-repo integration
- Content-side wiring and proof-of-concept systems

---

## License

MIT License. See `LICENSE`.

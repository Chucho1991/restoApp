# Agent Instructions

## Objective
Ensure every method in the backend and frontend is documented with a concise description of intent, inputs, and outputs.

## Scope
- Backend: all public methods in controllers, services, repositories, and domain helpers.
- Frontend: all public methods in services, components, and shared utilities.

## Documentation Standards
- Add a brief doc comment above each method.
- Describe what the method does, expected inputs, and return value or side effects.
- Keep comments short; avoid restating obvious code.
- Use the existing language conventions in each file (JavaDoc in Java, TSDoc/JSDoc in TS).
- Do not change method behavior while documenting.

## Validation
- If a file lacks method documentation, add comments without altering signatures or logic.
- Prefer minimal edits focused on documentation only.

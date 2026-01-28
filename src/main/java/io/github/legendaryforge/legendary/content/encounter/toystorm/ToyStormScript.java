package io.github.legendaryforge.legendary.content.encounter.toystorm;

import io.github.legendaryforge.legendary.content.EncounterScript;
import io.github.legendaryforge.legendary.core.api.encounter.EncounterInstance;
import io.github.legendaryforge.legendary.core.api.encounter.ParticipationRole;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class ToyStormScript implements EncounterScript {

private final Map<UUID, PhaseMachine> phasesByInstance = new ConcurrentHashMap<>();
private final Map<UUID, Integer> participantsByInstance = new ConcurrentHashMap<>();

@Override
public void onStart(EncounterInstance instance, UUID triggeringPlayerId) {
Objects.requireNonNull(instance, "instance");
Objects.requireNonNull(triggeringPlayerId, "triggeringPlayerId");

PhaseMachine phases = phasesByInstance.computeIfAbsent(instance.instanceId(), k -> new PhaseMachine());
phases.enter(EncounterPhase.CHARGE, p -> {});
participantsByInstance.putIfAbsent(instance.instanceId(), 0);
}

@Override
public void onJoin(EncounterInstance instance, UUID playerId, ParticipationRole role) {
Objects.requireNonNull(instance, "instance");
Objects.requireNonNull(playerId, "playerId");
Objects.requireNonNull(role, "role");

if (role != ParticipationRole.PARTICIPANT) {
return;
}

UUID id = instance.instanceId();
participantsByInstance.merge(id, 1, Integer::sum);

PhaseMachine phases = phasesByInstance.computeIfAbsent(id, k -> new PhaseMachine());
int participants = participantsByInstance.getOrDefault(id, 0);

if (participants == 1) {
phases.enter(EncounterPhase.DISCHARGE, p -> {});
} else if (participants == 2) {
phases.enter(EncounterPhase.RECOVERY, p -> {});
}
}

@Override
public void onEnd(EncounterInstance instance) {
Objects.requireNonNull(instance, "instance");
// idempotent end; keep state for post-end queries if desired
}

public EncounterPhase phaseFor(UUID instanceId) {
PhaseMachine phases = phasesByInstance.get(instanceId);
return phases == null ? null : phases.current();
}
}

package io.github.legendaryforge.legendary.content;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.legendaryforge.legendary.core.api.encounter.EncounterAnchor;
import io.github.legendaryforge.legendary.core.api.encounter.EncounterContext;
import io.github.legendaryforge.legendary.core.api.encounter.EncounterInstance;
import io.github.legendaryforge.legendary.core.api.encounter.EndReason;
import io.github.legendaryforge.legendary.core.api.encounter.EncounterManager;
import io.github.legendaryforge.legendary.core.api.encounter.JoinResult;
import io.github.legendaryforge.legendary.core.api.encounter.ParticipationRole;
import io.github.legendaryforge.legendary.core.api.id.ResourceId;
import io.github.legendaryforge.legendary.core.internal.runtime.DefaultCoreRuntime;
import java.util.Map;
import org.junit.jupiter.api.Test;

public final class ContentScenarioTest {

    private record SimpleContext(EncounterAnchor anchor, Map<String, Object> metadata) implements EncounterContext {}

    @Test
    void toyLightningEncounter_flow() {
        DefaultCoreRuntime runtime = new DefaultCoreRuntime();
        EncounterManager encounters = runtime.encounters();

        ToyLightningEncounterDefinition def = new ToyLightningEncounterDefinition(
                ResourceId.of("legendarycontent", "toy_lightning")
        );

        EncounterAnchor anchor = EncounterAnchor.of(
                ResourceId.of("legendarycontent", "world"),
                ResourceId.of("legendarycontent", "arena_alpha")
        );

        EncounterContext ctx = new SimpleContext(anchor, Map.of("note", "content_scenario"));
        EncounterInstance instance = encounters.create(def, ctx);

        assertEquals(JoinResult.SUCCESS, encounters.join(java.util.UUID.randomUUID(), instance, ParticipationRole.PARTICIPANT));
        assertEquals(JoinResult.SUCCESS, encounters.join(java.util.UUID.randomUUID(), instance, ParticipationRole.SPECTATOR));

        encounters.end(instance, EndReason.COMPLETED);
        assertEquals(JoinResult.DENIED_STATE, encounters.join(java.util.UUID.randomUUID(), instance, ParticipationRole.SPECTATOR));
    }
}

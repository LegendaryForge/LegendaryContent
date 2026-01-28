package io.github.legendaryforge.legendary.content;

import java.util.UUID;

public record ToyLightningRewardDecision(
UUID instanceId,
ToyLightningScript.RewardTier rewardTier,
int rewardPoints
) {}

package io.github.legendaryforge.legendary.content;

import java.util.Objects;

public final class ToyLightningRewardEvaluator {

private ToyLightningRewardEvaluator() {}

public static ToyLightningRewardDecision decide(ToyLightningEndSummary summary) {
Objects.requireNonNull(summary, "summary");

int points = switch (summary.rewardTier()) {
case NONE -> 0;
case MINOR -> 10;
case MAJOR -> 25;
};

return new ToyLightningRewardDecision(summary.instanceId(), summary.rewardTier(), points);
}
}

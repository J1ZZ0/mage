
package mage.cards.c;

import java.util.UUID;
import mage.abilities.costs.common.SacrificeTargetCost;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.Predicates;

/**
 *
 * @author TheElk801
 */
public final class CostlyPlunder extends CardImpl {

    private static final FilterControlledPermanent filter = new FilterControlledPermanent("an artifact or creature");

    static {
        filter.add(Predicates.or(
                CardType.ARTIFACT.getPredicate(),
                CardType.CREATURE.getPredicate()
        ));
    }

    public CostlyPlunder(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{1}{B}");

        // As an additional cost to cast Costly Plunder, sacrifice an artifact or creature.
        this.getSpellAbility().addCost(new SacrificeTargetCost(1, 1, filter));

        // Draw two cards.
        this.getSpellAbility().addEffect(new DrawCardSourceControllerEffect(2));
    }

    private CostlyPlunder(final CostlyPlunder card) {
        super(card);
    }

    @Override
    public CostlyPlunder copy() {
        return new CostlyPlunder(this);
    }
}

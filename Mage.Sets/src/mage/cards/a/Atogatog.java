
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeTargetCost;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.dynamicvalue.common.SacrificeCostCreaturesPower;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.filter.common.FilterControlledCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public final class Atogatog extends CardImpl {

    private static final FilterControlledCreaturePermanent filter = new FilterControlledCreaturePermanent("an Atog creature");

    static {
        filter.add(TargetController.YOU.getControllerPredicate());
        filter.add(SubType.ATOG.getPredicate());
    }

    public Atogatog(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{W}{U}{B}{R}{G}");
        addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.ATOG);

        this.power = new MageInt(5);
        this.toughness = new MageInt(5);

        DynamicValue xValue = SacrificeCostCreaturesPower.instance;
        // Sacrifice an Atog creature: Atogatog gets +X/+X until end of turn, where X is the sacrificed creature's power.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new BoostSourceEffect(xValue, xValue,Duration.EndOfTurn),
                new SacrificeTargetCost(1,1,new FilterControlledCreaturePermanent(SubType.ATOG, "an Atog creature"))));
        
    }

    private Atogatog(final Atogatog card) {
        super(card);
    }

    @Override
    public Atogatog copy() {
        return new Atogatog(this);
    }
}

package org.mage.test.cards.triggers;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

public class VegaTheWatcherTest extends CardTestPlayerBase {
    @Test
    public void vegaDrawFromExile() {
    setStrictChooseMode(true);
    addCard(Zone.BATTLEFIELD, playerA, "Island", 8);  // Foretell cost 2 mana and {1}{U} for foretell cast from exile
    addCard(Zone.BATTLEFIELD, playerA, "Vega, The Watcher"); // Whenever you cast a spell from anywhere other than your hand, draw a card
    addCard(Zone.HAND, playerA, "Behold the Multiverse");  // (Instant) Scry 2 and draw 2 cards
    addCard(Zone.HAND, playerA, "Air Marshal");
    
    castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA,"Air Marshal");
    activateAbility(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Fore");
    activateAbility(2, PhaseStep.PRECOMBAT_MAIN, playerA, "Foretell {1}{U}");
    setStopAt(2, PhaseStep.END_TURN);
    execute();
    

    assertPermanentCount(playerA, "Air Marshal", 1);
    assertExileCount(playerA, "Behold the Multiverse", 0); // no longer in exile
    assertGraveyardCount(playerA, "Behold the Multiverse", 1);  // now in graveyard
    assertHandCount(playerA, 3); // 3 cards drawn
    }
}



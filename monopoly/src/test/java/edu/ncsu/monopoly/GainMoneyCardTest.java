package edu.ncsu.monopoly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GainMoneyCardTest {
	Card gainMoneyCard;
	GameMaster gameMaster;

	@Before
	public void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCGainMoney());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		gainMoneyCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
		gameMaster.getGameBoard().addCard(gainMoneyCard);
	}

	@Test
	public void testGainMoneyCardAction() {
		int origMoney = gameMaster.getCurrentPlayer().getMoney();
		Card card = gameMaster.drawCCCard();
		assertEquals(gainMoneyCard, card);
		card.applyAction();
		assertEquals(origMoney + 50, gameMaster.getCurrentPlayer().getMoney());
	}

	@Test
	public void testGainMoneyCardUI() {
		gameMaster.movePlayer(0, 1);
		assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
		assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
		gameMaster.btnDrawCardClicked();
		assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
		assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
	}
}
	
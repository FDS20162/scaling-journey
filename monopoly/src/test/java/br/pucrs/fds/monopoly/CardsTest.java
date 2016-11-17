package br.pucrs.fds.monopoly;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.pucrs.fds.monopoly.Card;
import br.pucrs.fds.monopoly.GameBoardCCGainMoney;
import br.pucrs.fds.monopoly.GameMaster;
import br.pucrs.fds.monopoly.MockGUI;
import br.pucrs.fds.monopoly.MoneyCard;

public class CardsTest {
	Card ccCard, chanceCard;

	GameMaster gameMaster;

	@Before
	public void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCGainMoney());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		ccCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
		chanceCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CHANCE);
		gameMaster.getGameBoard().addCard(ccCard);
	}

	@Test
	public void testCardType() {
		Card card = gameMaster.drawCCCard();
		assertEquals(Card.TYPE_CC, ccCard.getCardType());
		card = gameMaster.drawChanceCard();
		assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
	}
}

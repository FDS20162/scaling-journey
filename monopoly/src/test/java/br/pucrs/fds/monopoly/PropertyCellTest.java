
package br.pucrs.fds.monopoly;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.pucrs.fds.monopoly.GameMaster;
import br.pucrs.fds.monopoly.MockGUI;
import br.pucrs.fds.monopoly.PropertyCell;
import br.pucrs.fds.monopoly.SimpleGameBoard;

public class PropertyCellTest {

	GameMaster gameMaster;

	@Before
	public void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new SimpleGameBoard());
		gameMaster.setNumberOfPlayers(2);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
	}

	@Test
	public void testPlayerAction() {
		PropertyCell cell = (PropertyCell) gameMaster.getGameBoard().queryCell("Blue 3");
		int cellIndex = gameMaster.getGameBoard().queryCellIndex("Blue 3");
		gameMaster.movePlayer(0, cellIndex);
		gameMaster.getPlayer(0).purchase();
		gameMaster.switchTurn();
		gameMaster.movePlayer(1, cellIndex);
		cell.playAction();
		assertEquals(1500 - cell.getRent(), gameMaster.getPlayer(1).getMoney());
		assertEquals(1380 + cell.getRent(), gameMaster.getPlayer(0).getMoney());
	}
}

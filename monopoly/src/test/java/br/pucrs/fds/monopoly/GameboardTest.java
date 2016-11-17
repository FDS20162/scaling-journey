package br.pucrs.fds.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pucrs.fds.monopoly.Cell;
import br.pucrs.fds.monopoly.GameBoard;
import br.pucrs.fds.monopoly.PropertyCell;
import br.pucrs.fds.monopoly.SimpleGameBoard;


public class GameboardTest  {

	Cell cell;
	GameBoard gameBoard;
	
	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		cell = new PropertyCell();
		cell.setName("TempCell");
	}

	@Test
	public void testAddCell() {
		assertEquals(1, gameBoard.getCellNumber());
		gameBoard.addCell(cell);
		assertEquals(2, gameBoard.getCellNumber());
	}
	
	@Test
	public void testCellsForMonopoly() {
		GameBoard gb = new SimpleGameBoard();
		PropertyCell[] properties = gb.getPropertiesInMonopoly("blue");
		assertEquals("Blue 1", properties[0].getName());
		assertEquals("Blue 2", properties[1].getName());
		assertEquals("Blue 3", properties[2].getName());
		assertEquals(3, properties.length);
	}
	
	@Test
	public void testPropertyNumberForColor() {
		PropertyCell cell1 = new PropertyCell();
		cell1.setName("Blue 1");
		cell1.setColorGroup("blue");
		PropertyCell cell2 = new PropertyCell();
		cell2.setName("Blue 2");
		cell2.setColorGroup("blue");
		PropertyCell cell3 = new PropertyCell();
		cell3.setName("Green 1");
		cell3.setColorGroup("green");
		
		gameBoard.addCell(cell1);
		gameBoard.addCell(cell2);
		gameBoard.addCell(cell3);
		assertEquals(2, gameBoard.getPropertyNumberForColor("blue"));
		assertEquals(1, gameBoard.getPropertyNumberForColor("green"));
	}
	
	@Test
	public void testQueryCell() {
		gameBoard.addCell(cell);
		assertSame(cell,gameBoard.queryCell("TempCell"));
	}
	
	@Test
	public void testQueryCellIndex() {
		gameBoard.addCell(cell);
		assertEquals(0,gameBoard.queryCellIndex("Go"));
		assertEquals(1,gameBoard.queryCellIndex("TempCell"));
	}
}
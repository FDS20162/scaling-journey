package br.pucrs.fds.monopoly.gui;

import br.pucrs.fds.monopoly.Cell;

public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    public String format(Cell cell) {
    	return GOTO_JAIL_LABEL;
	}
}

package br.pucrs.fds.monopoly.gui;

import br.pucrs.fds.monopoly.Cell;

public class GoCellInfoFormatter implements CellInfoFormatter {
    
    public static final String GO_CELL_LABEL = "<html><b>Go</b></html>";
    
    public String format(Cell cell) {
        return GO_CELL_LABEL;
    }
}

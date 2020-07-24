public class Cell {
    private int row;
    private int column;
    private int color;

    public Cell(int row, int column, int color) {
        super();
        this.row = row;
        this.column = column;
        this.color = color;
    }

    /**
     * Get the row for this cell
     */
    public int getRow() {
        return row;
    }

    /**
     * Set the row for this cell
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Get the column for this cell
     */
    public int getColumn() {
        return column;
    }

    /**
     * Set the column for this cell
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Get the color for this cell
     */
    public int getColor() {
        return color;
    }

    /**
     * Set the color for this cell
     */
    public void setColor(int color) {
        this.color = color;
    }

}


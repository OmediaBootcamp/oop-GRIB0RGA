package dev.omedia.section_8.exercise_39;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted = 0;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel < 0 || tonerLevel > 100 ? -1 : tonerLevel;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount <= 0 || tonerAmount + tonerLevel > 100) {
            return -1;
        }
        this.tonerLevel = tonerLevel + tonerAmount;
        return this.tonerLevel;
    }

    public int getPagesPrinted() {
        return this.pagesPrinted;
    }

    public int printPages(int pages) {
        boolean pagesToPrintAreEven = pages % 2 == 0;
        int pagesToPrintForDuplexScenario = pagesToPrintAreEven ? pages / 2 : pages / 2 + pages % 2;
        int pagesToPrint = this.duplex ? pagesToPrintForDuplexScenario : pages;
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }


}

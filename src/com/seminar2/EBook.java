package com.seminar2;

public class EBook extends DigitalProduct {

    private String author;
    private int pageCount;
    private String format;

    public EBook(String name, double price, char grade, double fileSizeMb, String downloadUrl,
                 String author, int pageCount, String format) {
        super(name, price, grade, fileSizeMb, downloadUrl);
        this.author = author;
        this.pageCount = pageCount;
        this.format = format;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void download() {
        System.out.println("Downloading e-book \"" + getName() + "\" by " + author
                + " (" + format + ", " + pageCount + " pages, " + getFileSizeMb() + " MB)");
    }
}

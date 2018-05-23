package com.entor.bms.entity;

import java.util.Objects;

public class BookInfo {
    private Integer bid;// 书籍编码
    private String bookName;// 书籍名称
    private Integer amount;// 数量

    public BookInfo() {
    }

    public BookInfo(Integer bid, String bookName, Integer amount) {
        this.bid = bid;
        this.bookName = bookName;
        this.amount = amount;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return Objects.equals(bid, bookInfo.bid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bid);
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bid=" + bid +
                ", bookName='" + bookName + '\'' +
                ", amount=" + amount +
                '}';
    }
}

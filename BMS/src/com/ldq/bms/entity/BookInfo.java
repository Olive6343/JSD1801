package com.ldq.bms.entity;

public class BookInfo {
   

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInfo other = (BookInfo) obj;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		return true;
	}

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
    public String toString() {
        return "BookInfo{" +
                "bid=" + bid +
                ", bookName='" + bookName + '\'' +
                ", amount=" + amount +
                '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		return result;
	}
}

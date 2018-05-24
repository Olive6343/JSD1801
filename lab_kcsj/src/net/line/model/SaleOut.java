package net.line.model;

public class SaleOut {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SaleOut [saleName=" + saleName + ", saleNo=" + saleNo
				+ ", saleTime=" + saleTime + ", No=" + No + ", goodsNo="
				+ goodsNo + ", goodsName=" + goodsName + ", Price=" + Price
				+ ", Amount=" + Amount + ", Money=" + Money + "]";
	}

	/**
	 * @return the time
	 */
	public String getSaleTime() {
		return saleTime;
	}

	/**
	 * @param time the time to set
	 */
	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}

	//销售人、销售单号、发票号、采购物料编码、采购物料名称、单价、数量、总价、折扣
	private String saleName;
	private String saleNo;
	private String saleTime;
	private String No;
	private String goodsNo;
	private String goodsName;
	private float Price;
	private int Amount;
	private float Money;
	
	public SaleOut(){
		
	}
	
	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getSaleNo() {
		return saleNo;
	}

	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public float getMoney() {
		return Money;
	}

	public void setMoney(float money) {
		Money = money;
	}


	
	
	
}

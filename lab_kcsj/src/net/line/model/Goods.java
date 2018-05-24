package net.line.model;

/**
 * @author Administrator
 *
 */
public class Goods {
	/**
	 * @return the suppliername
	 */
	public String getSuppliername() {
		return suppliername;
	}
	/**
	 * @param suppliername the suppliername to set
	 */
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * @param standard the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}
	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	private String goodsid;       //物料编号
	private String goodsname;     //物料名称
	private String suppliername;  //供应商
	private String standard;      //规格
	private String units;         //单位
	private double price;         //单价
	private String description;   //描述
	
	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Goods(){
		
	}
	
	
	

}

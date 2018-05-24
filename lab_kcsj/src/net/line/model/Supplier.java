package net.line.model;

public class Supplier {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supplier [spId=" + spId + ", spName=" + spName + ", spGoods="
				+ spGoods + "]";
	}
	/**
	 * @return the spId
	 */
	public String getSpId() {
		return spId;
	}
	/**
	 * @param spId the spId to set
	 */
	public void setSpId(String spId) {
		this.spId = spId;
	}
	/**
	 * @return the spName
	 */
	public String getSpName() {
		return spName;
	}
	/**
	 * @param spName the spName to set
	 */
	public void setSpName(String spName) {
		this.spName = spName;
	}
	/**
	 * @return the spGoods
	 */
	public String getSpGoods() {
		return spGoods;
	}
	/**
	 * @param spGoods the spGoods to set
	 */
	public void setSpGoods(String spGoods) {
		this.spGoods = spGoods;
	}
	private String spId;
	private String spName;
	private String spGoods;
	
	
}

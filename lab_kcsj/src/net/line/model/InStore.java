package net.line.model;

public class InStore {
		
	
		private String storeno; 	//入库编号
		private String storetype; 	//入库类型
		private String storemgr; 	//仓库管理员
		private String goodsid;		//商品编号
		private String goodsname;	//商品名
		private float goodsprice;	//商品价格
		private int goodsamount;	//商品数量
		private float goodsmoney;	//商品总价
		private String supplier;	//供应商
		private String storetime;	//入库时间
		private String description; //备注
		/**
		 * @return the storeno
		 */
		public InStore(){
			
		}
		
		public String getStoreno() {
			return storeno;
		}
		/**
		 * @param storeno the storeno to set
		 */
		public void setStoreno(String storeno) {
			this.storeno = storeno;
		}
		/**
		 * @return the storetype
		 */
		public String getStoretype() {
			return storetype;
		}
		/**
		 * @param storetype the storetype to set
		 */
		public void setStoretype(String storetype) {
			this.storetype = storetype;
		}
		/**
		 * @return the storemgr
		 */
		public String getStoremgr() {
			return storemgr;
		}
		/**
		 * @param storemgr the storemgr to set
		 */
		public void setStoremgr(String storemgr) {
			this.storemgr = storemgr;
		}
		/**
		 * @return the goodsid
		 */
		public String getGoodsid() {
			return goodsid;
		}
		/**
		 * @param goodsid the goodsid to set
		 */
		public void setGoodsid(String goodsid) {
			this.goodsid = goodsid;
		}
		/**
		 * @return the goodsname
		 */
		public String getGoodsname() {
			return goodsname;
		}
		/**
		 * @param goodsname the goodsname to set
		 */
		public void setGoodsname(String goodsname) {
			this.goodsname = goodsname;
		}
		/**
		 * @return the goodsprice
		 */
		public float getGoodsprice() {
			return goodsprice;
		}
		/**
		 * @param goodsprice the goodsprice to set
		 */
		public void setGoodsprice(float goodsprice) {
			this.goodsprice = goodsprice;
		}
		/**
		 * @return the goodsamount
		 */
		public int getGoodsamount() {
			return goodsamount;
		}
		/**
		 * @param goodsamount the goodsamount to set
		 */
		public void setGoodsamount(int goodsamount) {
			this.goodsamount = goodsamount;
		}
		/**
		 * @return the goodsmoney
		 */
		public float getGoodsmoney() {
			return goodsmoney;
		}
		/**
		 * @param goodsmoney the goodsmoney to set
		 */
		public void setGoodsmoney(float goodsmoney) {
			this.goodsmoney = goodsmoney;
		}
		/**
		 * @return the supplier
		 */
		public String getSupplier() {
			return supplier;
		}
		/**
		 * @param supplier the supplier to set
		 */
		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}
		/**
		 * @return the storetime
		 */
		public String getStoretime() {
			return storetime;
		}
		/**
		 * @param storetime the storetime to set
		 */
		public void setStoretime(String storetime) {
			this.storetime = storetime;
		}
		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "InStore [storeno=" + storeno + ", storetype=" + storetype
					+ ", storemgr=" + storemgr + ", goodsid=" + goodsid
					+ ", goodsname=" + goodsname + ", goodsprice=" + goodsprice
					+ ", goodsamount=" + goodsamount + ", goodsmoney="
					+ goodsmoney + ", supplier=" + supplier + ", storetime="
					+ storetime + ", description=" + description + "]";
		}
		
	
		
		

		
	}

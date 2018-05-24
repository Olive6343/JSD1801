package net.line.model;
/**
 * 用户
 * @author Administrator
 *
 */
public class User {
	
	
	private String userid;
	private String pwd;
	private String job;
	
	
	public User(){
		
	}


	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}


	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}


	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}


	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}


	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

}

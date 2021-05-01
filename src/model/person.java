package model;

public class person {
	private char name;
	private String nickName;
	private int cantMovit;
	private int possicion;
	/**
	 * @param name
	 * @param nickName
	 */
	public person(char name, String nickName) {
		super();
		this.name = name;
		this.nickName = nickName;
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getCantMovit() {
		return cantMovit;
	}
	public void setCantMovit(int cantMovit) {
		this.cantMovit = cantMovit;
	}
	public int getPossicion() {
		return possicion;
	}
	public void setPossicion(int possicion) {
		this.possicion = possicion;
	}
	
	
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

public class PontoModel {
	private long pontoId;
	private long mapId;
	private int x;
	private int y;
	private String SSID;
	private int level;
	
	public PontoModel(){
		
	}
	
	public PontoModel(Long mapId,int x,int y,String SSID,int level){
		this.pontoId = 0;
		this.mapId = mapId;
		this.x = x;
		this.y = y;
		this.SSID = SSID;
		this.level = level;
	}

	public long getPontoId() {
		return pontoId;
	}

	public void setPontoId(long pontoId) {
		this.pontoId = pontoId;
	}

	public long getMapId() {
		return mapId;
	}

	public void setMapId(long mapId) {
		this.mapId = mapId;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}

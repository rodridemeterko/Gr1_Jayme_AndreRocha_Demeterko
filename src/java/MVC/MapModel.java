/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

public class MapModel {
	private long mapId;
	private long userId;
	private String url;
	
	public MapModel(){
		
	}
	
	public MapModel(long user,String url){
		this.mapId = 0;
		this.userId = user;
		this.url = url;
	}

	public long getMapId() {
		return mapId;
	}

	public void setMapId(long mapId) {
		this.mapId = mapId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
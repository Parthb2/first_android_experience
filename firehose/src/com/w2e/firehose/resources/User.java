package com.w2e.firehose.resources;

import org.json.JSONObject;

import android.util.Log;

public class User {

	private long id;
	private String name;
	private String screenName;
	private String location;
	private String profileImageUrl;
	private String url;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	
	public static User fromJSON(String json) {
		try {
			JSONObject jsonObject = new JSONObject(json);
			return fromJSON(jsonObject);
		} catch (Exception e) {
			Log.e(User.class.getName(), "Error deserializing:", e);
		}
		return null;
	}
	
	public static User fromJSON(JSONObject jsonObject) {
		if (null == jsonObject) {
			return null;
		}

		try {
			User user = new User();
			user.id = jsonObject.getLong("id");
			user.name = jsonObject.getString("name");
			user.screenName = jsonObject.getString("screen_name");
			user.location = jsonObject.getString("location");
			user.profileImageUrl = jsonObject.getString("profile_image_url");
			user.url = jsonObject.getString("url");
			return user;
		} catch (Exception e) {
			Log.e(User.class.getName(), "Error deserializing:", e);
		}
		return null;
	}

}

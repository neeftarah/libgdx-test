package com.frappagames.libgdxtest.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Base64Coder;
import com.gamesparks.sdk.IGSPlatform;
import com.gamesparks.sdk.api.GSData;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;

public class LibGdxPlatform implements IGSPlatform {
	@Override
	public File getWritableLocation() {
		return null;
	}

	@Override
	public void executeOnMainThread(Runnable runnable) {
		Gdx.app.postRunnable(runnable);
	}

	@Override
	public String getDeviceId() {
		return null;
	}

	@Override
	public String getDeviceOS() {
		return null;
	}

	@Override
	public String getPlatform() {
		return null;
	}

	@Override
	public String getSDK() {
		return null;
	}

	@Override
	public String getDeviceType() {
		return null;
	}

	@Override
	public GSData getDeviceStats() {
		return null;
	}

	@Override
	public String getPlayerId() {
		return null;
	}

	@Override
	public String getAuthToken() {
		return null;
	}

	@Override
	public void setPlayerId(String s) {

	}

	@Override
	public void setAuthToken(String s) {

	}

	@Override
	public Object getHmac(String nonce, String secret) {
		try
		{
			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");

			sha256_HMAC.init(secret_key);

			//return Base64.encodeBase64String(sha256_HMAC.doFinal(nonce.getBytes("UTF-8")));
			return new String(Base64Coder.encode(sha256_HMAC.doFinal(nonce.getBytes("UTF-8"))));
		}
		catch (Exception e)
		{
			return null;
		}    }

	@Override
	public void logMessage(String s) {
		Gdx.app.log("Gamesparks", s);
	}

	@Override
	public void logError(Throwable throwable) {
		Gdx.app.error("Gamesparks", throwable.getMessage(), throwable);
	}
}
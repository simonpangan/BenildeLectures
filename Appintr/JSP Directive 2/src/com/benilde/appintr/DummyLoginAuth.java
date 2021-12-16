package com.benilde.appintr;

public class DummyLoginAuth implements LoginService {

	@Override
	public boolean login(String username, String password) {
		return username.equals("eric") && password.equals("test");
	}
}

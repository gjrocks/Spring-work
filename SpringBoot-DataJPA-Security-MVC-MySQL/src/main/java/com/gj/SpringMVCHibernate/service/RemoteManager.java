package com.gj.SpringMVCHibernate.service;

import org.springframework.stereotype.Service;

@Service
public class RemoteManager implements IRemoteManager {

	@Override
	public void getSomethingFromSomeWhere() {
		System.out.println("Came here for testing");
	}

}

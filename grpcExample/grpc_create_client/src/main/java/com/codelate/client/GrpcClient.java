package com.codelate.client;

import com.codelate.model.protos.AuthenticationGrpc;
import com.codelate.model.protos.AuthenticationGrpc.AuthenticationBlockingStub;
import com.codelate.model.protos.AuthenticationWrapper.APIResponse;
import com.codelate.model.protos.AuthenticationWrapper.LoginRequest;
import com.codelate.model.protos.AuthenticationWrapper.NoArguments;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) throws InterruptedException {
		//create channel to communicate with server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 56000).usePlaintext().build();
		
		//BlockingStub for synchronous call
		//newStub for async calls
		//futureStub -->
		AuthenticationBlockingStub authenticationBlockingStub = AuthenticationGrpc.newBlockingStub(channel);
		APIResponse loginResponse = authenticationBlockingStub.login(getLoginRequest());
		System.out.println(loginResponse);
		
		Thread.sleep(2000);
		
		//FOR logout
		APIResponse logoutResponse = authenticationBlockingStub.logout(NoArguments.newBuilder().build());
		System.out.println(logoutResponse);
		
	}

	private static LoginRequest getLoginRequest() {
		LoginRequest loginRequest = LoginRequest.newBuilder()
				.setId(83)
				.setName("Avishek")
				.setPassword("Avishek3")
				.build();
		return loginRequest;
	}

}

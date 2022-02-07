package com.codelate.service;

import com.codelate.model.protos.AuthenticationGrpc.AuthenticationImplBase;
import com.codelate.model.protos.AuthenticationWrapper.APIResponse;
import com.codelate.model.protos.AuthenticationWrapper.APIResponse.Builder;
import com.codelate.model.protos.AuthenticationWrapper.LoginRequest;
import com.codelate.model.protos.AuthenticationWrapper.NoArguments;

import io.grpc.stub.StreamObserver;

public class AuthenticationService extends AuthenticationImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside login method....");
		
		//capture the request
		String id = Integer.toString(request.getId());
		String name = request.getName();
		String password = request.getPassword();
		
		//create response
		Builder APIResponseBuilder = APIResponse.newBuilder();
		
		if(password.equals(name.concat(id))) {
			APIResponseBuilder.setResponseCode(200).setResponseMessage("Successfully logged in");
		}
		else {
			APIResponseBuilder.setResponseCode(200).setResponseMessage("Authentication failed. Please add name and id as password");
		}
		
		//send responseObserver as streamObserver
		responseObserver.onNext(APIResponseBuilder.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(NoArguments request, StreamObserver<APIResponse> responseObserver) {
		APIResponse APIResponseBuilder = APIResponse.newBuilder()
				.setResponseCode(200)
				.setResponseMessage("Logged off successfully")
				.build();
		responseObserver.onNext(APIResponseBuilder);
		responseObserver.onCompleted();
	}

}

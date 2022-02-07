package com.codelate.server;

import java.io.IOException;

import com.codelate.service.AuthenticationService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
				.forPort(56000)
				.addService(new AuthenticationService())
				.build();
		server.start();
		System.out.println("server has started at port:"+server.getPort());
		server.awaitTermination();
	}

}

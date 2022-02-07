package com.codelate.service;

import java.io.FileOutputStream;
import java.io.IOException;

import com.codelate.model.protos.Employee;

public class EmployeeWriter {
	public static void main(String[] args) throws IOException {
		Employee employee = Employee.newBuilder()
				.setId(11111)
				.setName("Avishek")
				.setDesignation("Developer")
				.build();

		String outputFilename = "serialize_Employee";
		System.out.println("saving Employee to file:" + outputFilename);

		FileOutputStream output = new FileOutputStream(outputFilename);
		employee.writeTo(output);
		if (output != null) {
			output.close();
		}
	}
}

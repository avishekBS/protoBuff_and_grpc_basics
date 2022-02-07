package com.codelate.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.codelate.model.protos.Employee;
import com.codelate.model.protos.Employee.Builder;

public class EmployeeReader {
	public static void main(String[] args) throws IOException {
		Builder employeeBuilder = Employee.newBuilder();

		String filename = "serialize_Employee";

		FileInputStream readStream = new FileInputStream(filename);
		Employee employee = employeeBuilder.mergeFrom(readStream).build();
		if (readStream != null) {
			readStream.close();
		}
		System.out.println(employee.toString());
	}
}

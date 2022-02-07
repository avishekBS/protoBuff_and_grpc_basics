package com.codelate.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.codelate.model.protos.Employee;
import com.codelate.model.protos.Employee.DEPARTMENT;
import com.codelate.model.protos.EmployeeWrapper;
import com.codelate.model.protos.ProjectDetails;

public class EmployeeWriter {
	public static void main(String[] args) throws IOException {

		Employee employee = Employee.newBuilder()
				.setId(11111)
				.setName("Avishek")
				.setDesignation("Developer")
				.setProjectId(345678L)
				.setFixedSalary(54678.69f)
				.setVariableSalary(5678.98)
				.setDepartment(DEPARTMENT.IT)
				.addAllSkills(getSkills())
				.putAllAssessmentScore(getAssessmentScores())
				.setProjectdetails(getProjectDetails())
				.build();
		String outputFilename = "serialize_Employee";
		System.out.println("saving Employee to file:" + outputFilename);

		FileOutputStream output = new FileOutputStream(outputFilename);
		employee.writeTo(output);
		if (output != null) {
			output.close();
		}
	}

	private static ProjectDetails getProjectDetails() {
		return ProjectDetails.newBuilder()
					.setProjectName("XXXX")
					.setProjectCode(00067)
					.build();
	}

	private static Map<String, Integer> getAssessmentScores() {
		Map<String, Integer> assessmentScores = new HashMap<>();
		assessmentScores.put("AWS", 75);
		assessmentScores.put("AZURE", 86);
		assessmentScores.put("GCP", 94);
		return assessmentScores;
	}

	private static ArrayList<String> getSkills() {
		ArrayList<String> skills = new ArrayList<String>();
		skills.add("Java");
		skills.add("Python");
		return skills;
	}
}

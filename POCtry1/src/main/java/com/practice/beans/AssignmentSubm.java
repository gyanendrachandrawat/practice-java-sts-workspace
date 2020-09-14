package com.practice.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "assignmentsubm")
public class AssignmentSubm {

	@Id
	@Column(name = "assignId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assignId;

	@Column(name = "assignTitle")
	private String assignTitle;

	@Column(name = "file")
	private String file;

	@Column(name = "assignStatus")
	private String assignStatus;

	@Column(name = "studentId", unique = true)
	private Integer studentId;

	@Column(name = "grades")
	private Character grades;

	@Column(name = "result")
	private String result;

	/**
	 * 
	 */
	public AssignmentSubm() {
		super();
	}

	/**
	 * @param assignId
	 * @param assignTitle
	 * @param assignStatus
	 * @param studentId
	 * @param grades
	 * @param result
	 */
	public AssignmentSubm(Integer assignId, String assignTitle, String assignStatus, Integer studentId,
			Character grades, String result) {
		super();
		this.assignId = assignId;
		this.assignTitle = assignTitle;
		this.assignStatus = assignStatus;
		this.studentId = studentId;
		this.grades = grades;
		this.result = result;
	}

	/**
	 * @return the assignId
	 */
	public Integer getAssignId() {
		return assignId;
	}

	/**
	 * @param assignId the assignId to set
	 */
	public void setAssignId(Integer assignId) {
		this.assignId = assignId;
	}

	/**
	 * @return the assignTitle
	 */
	public String getAssignTitle() {
		return assignTitle;
	}

	/**
	 * @param assignTitle the assignTitle to set
	 */
	public void setAssignTitle(String assignTitle) {
		this.assignTitle = assignTitle;
	}

	/**
	 * @return the assignStatus
	 */
	public String getAssignStatus() {
		return assignStatus;
	}

	/**
	 * @param assignStatus the assignStatus to set
	 */
	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}

	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the grades
	 */
	public Character getGrades() {
		return grades;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(Character grades) {
		this.grades = grades;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the file
	 */
	public String getfile() {
		return file;
	}

	/**
	 * @param file2 the file to set
	 */
	public void setfile(String file2) {
		this.file = file2;
	}

}

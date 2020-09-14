//package com.practice.beans;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "assignments")
//public class Assignment {
//	
//	@Column(name = "assignmentid")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer assignmentId;
//	
//	@Column(name = "assignmenttitle")
//	private String assignmentTitle;
//	
//	@Column(name = "filelocation")
//	private String fileLocation;
//
//	public Assignment() {
//		super();
//	}
//
//	public Assignment(Integer assignmentId, String assignmentTitle, String fileLocation) {
//		super();
//		this.assignmentId = assignmentId;
//		this.assignmentTitle = assignmentTitle;
//		this.fileLocation = fileLocation;
//	}
//
//	public Integer getAssignmentId() {
//		return assignmentId;
//	}
//
//	public void setAssignmentId(Integer assignmentId) {
//		this.assignmentId = assignmentId;
//	}
//
//	public String getAssignmentTitle() {
//		return assignmentTitle;
//	}
//
//	public void setAssignmentTitle(String assignmentTitle) {
//		this.assignmentTitle = assignmentTitle;
//	}
//
//	/**
//	 * @return the fileLocation
//	 */
//	public String getFileLocation() {
//		return fileLocation;
//	}
//
//	/**
//	 * @param fileLocation the fileLocation to set
//	 */
//	public void setFileLocation(String fileLocation) {
//		this.fileLocation = fileLocation;
//	}
//
//}

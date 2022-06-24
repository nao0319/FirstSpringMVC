package com.example.first.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	@Id
	@Min(value = 1000, message = "1000以上の数値で入力してください")
	@NotNull(message="社員番号の入力は必須です")
	@Column(name = "no")
	private Integer no;

	@Column(name = "name")
	@NotBlank(message="氏名の入力は必須です")
	private String name;

	@Column(name = "salary")
	@NotNull(message="給与額の入力は必須です")
	private Integer salary;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "dept_no")
	private Department dept;

	@Column(name = "dept_no", insertable = false, updatable = false)
	private Integer deptNo;

	//constracta
	public Employee() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Employee(Integer no, String name, Integer salary) {
		this.no = no;
		this.name = name;
		this.salary = salary;
	}

	public Employee(Integer no, String name, Integer salary, Department dept) {
		this(no, name, salary);
		this.dept = dept;
	}
	
	public Employee(@Min(value = 1000, message = "1000以上の数値で入力してください") @NotNull(message = "社員番号の入力は必須です") Integer no,
			@NotBlank(message = "氏名の入力は必須です") String name, @NotNull(message = "給与額の入力は必須です") Integer salary,
			Department dept, Integer deptNo) {
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.deptNo = deptNo;
	}

	//getter,setter
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

}

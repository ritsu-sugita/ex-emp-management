package jp.co.sample.domain;

import java.security.Timestamp;

public class Employee {
	private Integer id;
	private String name;
	private String image;
	private String gender;
	private Timestamp hire_date;
	private String mail_adress;
	private String zip_code;
	private String address;
	private String telephone;
	private Integer salary;
	private String characteristics;
	private Integer dependents_count;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getHire_date() {
		return hire_date;
	}

	public void setHire_date(Timestamp hire_date) {
		this.hire_date = hire_date;
	}

	public String getMail_adress() {
		return mail_adress;
	}

	public void setMail_adress(String mail_adress) {
		this.mail_adress = mail_adress;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public Integer getDependents_count() {
		return dependents_count;
	}

	public void setDependents_count(Integer dependents_count) {
		this.dependents_count = dependents_count;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hire_date="
				+ hire_date + ", mail_adress=" + mail_adress + ", zip_code=" + zip_code + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependents_count=" + dependents_count + "]";
	}
}


public class Employees {
	private String firstName, surname, dateOfBirth, email, telephone, mobile;
	private int employeeID;
	
	public Employees(int employeeID, String firstName, String surname, String dateOfBirth, String email, String telephone, String mobile) {
		this.setEmployeeID(employeeID);
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setDateOfBirth(dateOfBirth);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setMobile(mobile);
	}
	
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public int getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}
}


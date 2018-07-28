
public class Members {
	
	private String firstName, surname, dateOfBirth, email, telephone, mobile;
	private int memberID;	
	
	Members(int memberID, String firstName, String surname, 
			String dateOfBirth, String email, 
			String telephone, String mobile) {
		// TODO Auto-generated constructor stub
			this.setMemberID(memberID);
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
		public int getMemberID() {
			return memberID;
		}
		public void setMemberID(int memberID) {
			this.memberID = memberID;
		}
				
}



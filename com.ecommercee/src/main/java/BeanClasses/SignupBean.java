package BeanClasses;

public class SignupBean {
	
		public String email;
		public String mobile;
		public String password;
		public String username;
		public String typeofuser;
		public SignupBean( String username,String email,String mobilenumber, String password, String typeofuser) {

			this.email = email;
			this.username=username;
			this.mobile = mobilenumber;
			this.password = password;
            this.typeofuser=typeofuser;		
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobilenumber() {
			return mobile;
		}
		public void setMobilenumber(String mobilenumber) {
			this.mobile = mobilenumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String gettypeofuser() {
			return typeofuser;
		}
		
}

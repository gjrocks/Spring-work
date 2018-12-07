package org.jzen.invoicing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jzen.invoicing.entity.enums.UserStatusType;


@Entity
@Table(name = "user_details")

public class UserDetail implements Serializable{
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "userID", nullable = false)
	 private Integer id;

	 @Column(name = "user_name")
	 private String username;
	 
	 @Column(name = "email")
	 private String email;
	 
	 @Column(name = "password")
	 private String password;
	 
	 @Column(name = "super_admin")
	 private boolean isSuperAdmin;
	 

	 @Column(name = "enabled")
	 private boolean isEnabled;
	 
	 
	 
	 @Column(name = "user_created_date")
	 private Date createdDate;
	 
	 @Column(name = "user_updated_date")
	 private Date updatedDate;
	 
	 @Column(name = "failed_attempts")
	 private int failedAttempts;
	 
	 @Column(name = "user_locked_until_date")
	 private Date lockedUntilDate;
	 
	 @Column(name = "user_status")
	 private int userStatus;
	 
	 
	 
	 private Date dob;
	
	 
	
	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;	
	}

	@Transient
		private CustomAuthories[] authorities;
		
		private String authority; //comma separated

		private void populateAuthorites(String authority2) {
			if(authority2!=null){
				String [] temp=authority2.split(",");
				authorities=new CustomAuthories[temp.length];
				for(int i=0;i<temp.length;i++){
					authorities[i]=new CustomAuthories(temp[i]);
				}
			}
			
		}

		public CustomAuthories[] getAuthorities() {
			if(authorities!=null)
			return authorities;
			else {
				populateAuthorites(this.getAuthority());
				return authorities;
			}
		}

		public void setAuthorities(CustomAuthories[] authorities) {
			this.authorities = authorities;
		}
		
		public String getAuthority() {
			return authority;
		}

		public void setAuthority(String authority) {
			this.authority = authority;
			if(authority!=null)
				populateAuthorites(authority);
		}

		
		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}
	 
	public Date getLockedUntilDate() {
		return lockedUntilDate;
	}
	public void setLockedUntilDate(Date lockedUntilDate) {
		this.lockedUntilDate = lockedUntilDate;
	}
	public int getFailedAttempts() {
		return failedAttempts;
	}
	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		  if (password != null) {
	            this.password = password.trim();
	        } else {
	            this.password = password;
	        }
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}



	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}



	


	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof UserDetail)) return false;
	        UserDetail userDetail = (UserDetail) o;
	        //using email here as id is only generated when persisting it
	        return Objects.equals(getEmail(), userDetail.getEmail());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getId());
	    }
	 
	    //used by sprig jpa
	    public UserDetail() {
		}

		
		// used for testing using datajpatest
		public UserDetail(String username, String email, String password, boolean isEnabled, String role,
				Date createdDate) {

			this.username = username;
			this.email = email;
			this.password = password;
			this.isEnabled=isEnabled;
			
			
			this.createdDate = createdDate;
		
	   
		}

		public boolean isEnabled() {
			return isEnabled;
		}

		public void setEnabled(boolean enabled) {
			this.isEnabled = enabled;
		}
	 
	 

}

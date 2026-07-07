package com.fis.banking_parent.com.fis.banking_parent.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
	public class Customer {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long customerId;

	    @Column(nullable = false)
	    private String customerName;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false, unique = true)
	    private String mobileNumber;

	    @Column(nullable = false)
	    private String city;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private KycStatus kycStatus;
	    
	    public KycStatus getKycStatus() {
			return kycStatus;
		}

		public void setKycStatus(KycStatus kycStatus) {
			this.kycStatus = kycStatus;
		}

		public Long getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(Long customerId) {
	        this.customerId = customerId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getMobileNumber() {
	        return mobileNumber;
	    }

	    public void setMobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }
	
}

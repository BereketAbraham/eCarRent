package mum.edu.cs.cs425.project.ecarrent.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@Column(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	@Column(name = "payment_date")
//	@NotNull(message = "*Please provide payment date") 
	private Double paymentDate;

	@Column(name = "payment_type")
//	@NotNull(message = "*Please provide payment type") 
    private String paymentType;

	@Column(name = "card_number")
//	@NotNull(message = "*Please provide payment card type") 
    private Long cardNumber;
    
	@Column(name = "card_csv")
//	@NotNull(message = "*Please provide payment card CSV") 
    private Integer cardCSV;
    
	@Column(name = "total_price") 
    private Double totalPrice;
    
	@Column(name = "payment_status")
//	@NotNull 
	private String paymentStatus;
	
	@OneToOne(mappedBy = "payment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Booking booking;
	
	@OneToOne
	@JoinColumn(name="address_id", nullable = true, unique = true)
    private Address billingAddress;
	
	public Payment() {}

	public Payment(Long paymentId, Double paymentDate,
			String paymentType, Long cardNumber, Integer cardCSV, Double totalPrice, Address billingAddress,
			String paymentStatus, Booking booking) {
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.cardCSV = cardCSV;
		this.totalPrice = totalPrice;
		this.billingAddress = billingAddress;
		this.paymentStatus = paymentStatus;
		this.booking = booking;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Double paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getCardCSV() {
		return cardCSV;
	}

	public void setCardCSV(Integer cardCSV) {
		this.cardCSV = cardCSV;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
		
}
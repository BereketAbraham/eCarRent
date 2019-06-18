package mum.edu.cs.cs425.project.ecarrent.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	
	@Id
	@Column(name = "vehicle_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicleId;
	
	@Column(name = "vehicle_number")
	@NotNull(message = "*Please provide vehicle number")
	private String vehicleNumber;
	
	@Column(name = "plate_number")
    private Integer plateNumber;
	
	@Column(name = "make")
	@NotNull(message = "*Please provide make")
    private String make;
	
	@Column(name = "model")
	@NotNull(message = "*Please provide model")
    private String model;
	
	@Column(name = "year")
	@NotNull(message = "*Please provide year")
    private Integer year;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable = false)
	@NotNull(message = "*Please select category")
	private Category category;
	
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private List<Booking> bookings;
    
	public Vehicle() {}

	public Vehicle(Long vehicleId, String vehicleNumber, Integer plateNumber, String make, String model,
			Integer year) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.plateNumber = plateNumber;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Integer getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(Integer plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
}

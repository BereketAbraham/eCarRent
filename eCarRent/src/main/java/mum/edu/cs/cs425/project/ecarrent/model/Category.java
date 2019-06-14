package mum.edu.cs.cs425.project.ecarrent.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	@Column(name = "category_name")
	@NotNull(message = "*Please provide category name")   
    private String categoryName;

	@Column(name = "seats")
	@NotNull(message = "*Please provide number of seats")
    private Integer seats;

	@Column(name = "doors")
	@NotNull(message = "*Please provide number of doors")
    private Integer doors;

	@Column(name = "fuel_economy")
	@NotNull(message = "*Please provide fuel economy")
    private Integer fuelEconomy;
	
	@Column(name = "rate_per_day")
	@NotNull(message = "*Please provide rate per day")
	private Float ratePerDay;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles;

	public Category() {}

	public Category(Long categoryId, @NotNull(message = "*Please provide category name") String categoryName,
			Integer seats, Integer doors, Integer fuelEconomy, Float ratePerDay) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.seats = seats;
		this.doors = doors;
		this.fuelEconomy = fuelEconomy;
		this.ratePerDay = ratePerDay;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public Integer getFuelEconomy() {
		return fuelEconomy;
	}

	public void setFuelEconomy(Integer fuelEconomy) {
		this.fuelEconomy = fuelEconomy;
	}

	public Float getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(Float ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}

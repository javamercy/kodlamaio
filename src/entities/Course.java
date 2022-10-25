package entities;

public class Course implements Entity {

	private int id;
	private int categoryId;
	private String name;
	private double price;

	public Course(int id, int categoryId, String name, double price) {

		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	public Course() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

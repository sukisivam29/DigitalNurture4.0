import java.util.*;

public class Product {
	int productID;
	String productName;
	String category;

	public Product(int productID, String productName, String category) {
		this.productID = productID;
		this.productName = productName;
		this.category = category;
	}

	public String toString() {
		return "[" + productID + "] " + productName + " - " + category;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Product product[] = {
				new Product(100, "Headphone", "Electronics"),
				new Product(101, "Milk", "Dairy"),
				new Product(103, "Shirt", "Fashion"),
				new Product(104, "Shoe", "Fashion")
		};

		System.out.println("Search the product here...");
		String search = sc.next();

		EcomerceSearch ecs = new EcomerceSearch();

		// Linear search on unsorted array
		Product ls = ecs.linear_search(product, search);

		// Sort array by productName before binary search
		Arrays.sort(product, new Comparator<Product>() {
			public int compare(Product a, Product b) {
				return a.productName.compareToIgnoreCase(b.productName);
			}
		});

		Product bs = ecs.binary_search(product, search);

		System.out.println("Linear Search : " + (ls != null ? ls : "Product Not Found!!"));
		System.out.println("Binary Search : " + (bs != null ? bs : "Product Not Found!!"));
	}
}

class EcomerceSearch {

	// Linear Search
	public Product linear_search(Product[] product, String search) {
		for (Product p : product) {
			if (p.productName.equalsIgnoreCase(search)) {
				return p;
			}
		}
		return null;
	}

	// Binary Search (on sorted array)
	public Product binary_search(Product[] product, String search) {
		int left = 0;
		int right = product.length - 1;
		search = search.toLowerCase();

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int cmp = product[mid].productName.toLowerCase().compareTo(search);

			if (cmp == 0) {
				return product[mid];
			} else if (cmp < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return null;
	}
}

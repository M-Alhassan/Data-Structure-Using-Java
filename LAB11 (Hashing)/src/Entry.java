public class Entry<T> {

	public T dataObject;
	public String status;

	public Entry() {

		status = "E";

	}
	public T getDataObject() {
		return dataObject;
	}
	
	public String getStatus() {
		return status;
	}
	@Override

	public String toString() {

		return dataObject.toString();

	}

	public int hash() {

		return dataObject.hashCode();

	}

}
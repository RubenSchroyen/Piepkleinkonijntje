package worms.model;

public class Type<T> 
{
	private T value;
	
	public Type() 
	{
	}

	public T getValue() 
	{
		return value;
	}

	public Type(T value) 
	{
		this.value = value;
	}

}

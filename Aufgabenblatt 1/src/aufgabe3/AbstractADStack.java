/**
 * 
 */
package aufgabe3;

/**
 * @author Imon Bashir, Elham Esmat
 */

public abstract class AbstractADStack implements ADStack
{
	public abstract void pushImpl(Object object);
	public abstract Object topImpl();
	public abstract void popImpl();
	public abstract String getStringRepresentationImpl();
		
	@Override
	public void push(Object object)
	{
		assert object != null : "Vorbedingung verletzt: object != null";
		pushImpl(object);
	}

	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}

	@Override
	public abstract int size();


	@Override
	public Object top()
	{
		assert isEmpty() == false : "Vorbedingung verletzt: isEmpty() == false";
		return topImpl();
	}

	@Override
	public void pop()
	{
		assert isEmpty() == false : "Vorbedingung verletzt: isEmpty() == false";
		popImpl();
	}

	@Override
	public String getStringRepresentation()
	{
		assert isEmpty() == false : "Vorbedingung verletzt: isEmpty() == false";
		return getStringRepresentationImpl();
	}
	
	

}

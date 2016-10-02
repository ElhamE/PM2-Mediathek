package aufgabe3.array;

import aufgabe3.AbstractADStack;

public class ADStackArrayImpl extends AbstractADStack
{
	private Object[] _arrayStack;

	private int _kardinalitaet;

	public ADStackArrayImpl()
	{
		_arrayStack = new Object[5];
		_kardinalitaet = 0;
	}

	@Override
	public void pushImpl(Object object)
	{
		if (!isEmpty())
		{
			pruefeKapazitaet();
			for (int index = (_kardinalitaet - 1); index >= 0  ; --index)
			{
				_arrayStack[index + 1] = _arrayStack[index];
			}			
		}
		_arrayStack[0] = object;
		++_kardinalitaet;
	}

	/**
	 * Überprüft, ob die Kardinalität des Arrays gleich der Kapazität ist und
	 * verdoppelt das Array gegebenenfalls.
	 */
	private void pruefeKapazitaet()
	{
		if (_kardinalitaet == _arrayStack.length)
		{
			Object[] kopie = _arrayStack.clone();
			_arrayStack = new Object[2 * _arrayStack.length];
			for (int index = 0; index < _kardinalitaet; ++index)
			{
				_arrayStack[index] = kopie[index];
			}
		}
	}

	@Override
	public Object topImpl()
	{
		return _arrayStack[0];
	}

	@Override
	public void popImpl()
	{
		for (int index = 0; index < _kardinalitaet - 1 ; ++index)
		{
			_arrayStack[index] = _arrayStack[index + 1];
		}
		_arrayStack[_kardinalitaet - 1] = null;
		--_kardinalitaet;
		/*verkleinere das Array gegebenfalls, falls es geleert wurde*/
		if (isEmpty())
		{
			_arrayStack = new Object[5];
		}
	}

	@Override
	public String getStringRepresentationImpl()
	{
		String result = "";
		for (int index = 0; index < _kardinalitaet; ++index)
		{
			result = result + _arrayStack[index].toString() + "\n";
		}
		return result;
	}

	@Override
	public int size()
	{
		return _kardinalitaet;
	}

}

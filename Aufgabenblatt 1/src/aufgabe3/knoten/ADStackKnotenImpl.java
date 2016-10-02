package aufgabe3.knoten;

import aufgabe3.AbstractADStack;

/**
 * Ein Knoten für eine einfach verkettete Liste.
 * 
 * @author Imon Bashir, Elham Esmat
 */

public class ADStackKnotenImpl extends AbstractADStack
{
	private StackKnoten _anfang;
	
	public ADStackKnotenImpl()
	{
		_anfang = null;
	}

	@Override
	public void pushImpl(Object object)
	{
		_anfang = new StackKnoten(object, _anfang);
	}

	@Override
	public Object topImpl()
	{
		return _anfang.getInhalt();
	}

	@Override
	public void popImpl()
	{
		_anfang = _anfang.getNachfolger();
	}

	@Override
	public String getStringRepresentationImpl()
	{
		StackKnoten aktuellerKnoten = _anfang;
		String result = "";
		do
		{
			result = result + (aktuellerKnoten.getInhalt().toString());
			aktuellerKnoten = aktuellerKnoten.getNachfolger();
		}
		while (aktuellerKnoten != null);
		return result;
	}

	@Override
	public int size()
	{
		StackKnoten aktuellerKnoten = _anfang;
		int zaehler = 0;
		while (aktuellerKnoten != null)
		{
			++zaehler;
			aktuellerKnoten = aktuellerKnoten.getNachfolger();
		}
		return zaehler;
	}

}

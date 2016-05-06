import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedList;

class StartUpAufgabe2
{
	public static void main(String[] args)
	{
		CollectionExperiment colEx = new CollectionExperiment();
		colEx.experimentiereMit(new LinkedList<String>());
		colEx.experimentiereMit(new HashSet<String>());
		colEx.experimentiereMit(new Stack<String>());
	}
}

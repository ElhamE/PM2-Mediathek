import java.util.Collection;

class CollectionExperiment
{

	public void schreibeCollectionAufConsole(Collection<String> collection)
	{
		for (String string : collection)
		{
			System.out.print(string + " ");
		}
		System.out.print("| ");
	}

	public void experimentiereMit(Collection<String> collection)
	{		
		collection.add("Imon");
		collection.add("Elham");
		collection.add("Imon");
		schreibeCollectionAufConsole(collection);
		
		collection.remove("Imon");
		schreibeCollectionAufConsole(collection);
		
		collection.addAll(collection);
		schreibeCollectionAufConsole(collection);
		
		System.out.print(collection.size() + " | ");
	
		collection.clear();
		schreibeCollectionAufConsole(collection);
		
		System.out.println();
	}
}

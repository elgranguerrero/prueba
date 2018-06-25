package HashListaEnlazada;

public class LinkedList<Type extends Comparable<Type>> {
	
	protected int count;		//variable to store the number of elements in the list
	
	//indica el primero de la lista
	protected NodeList<Type> first; //pointer to the first node of the list
	
	//indica el ultimo de la lista
	protected NodeList<Type> last;  //pointer to the last node of the list 

	//default constructor
	//Initializes the list to an empty state.
	//Postcondition: first = null, last = null, count = 0
	public LinkedList(){
		first = null;
		last = null;
		count = 0;
	}
	
	
	
	
	//****************--------------------****************
	//Initializes the list to an empty state.
	//Postcondition: first = null, last = null, count = 0
	public void initializeList(){
		//Here write your code
		first = null;
		last = null;
		count = 0;
		
	}
	//Function to determine whether the list is empty. 
	//Postcondition: Returns true if the list is empty; otherwise, returns false.
   	public boolean isEmpty(){
		//Here write your code
   		if(first==null) {
   			return true;
   		}else {
   			return false;
   		}
   		
	}

	//Function to return the number of nodes in the list.
	//Postcondition: The value of count is returned.
	public int length(){ 
		//Here write your code
		return count;
	}

	
	
	//****************--------------------****************
 	//Function to delete all the nodes from the list.
  	//Postcondition: first = null, last = null, count = 0
	protected void destroyList(){
		//Here write your code
		/*first = null;
		last = null;
		count = 0;*/
		initializeList();
		
	}
	
	
	
	
	
	

	//Function to determine whether searchItem is in the list.
	//Postcondition: Returns true if searchItem is found in the list;
	//               otherwise, it returns false.
	public boolean search(Type searchItem){
		
		NodeList<Type> aux =first;
		
		/*while(aux!= null && !aux.getInfo().equals(searchItem)) {
			aux = aux.getLink();
		}*/
		while(aux!= null) {
			 //if(aux.getInfo().equals(searchItem)) {
			if(aux.getInfo().compareTo(searchItem)==0){
				 return true;
			 }
			aux = aux.getLink();
		}
		
		return false;

		
		/*if (aux != null) {
			return true;
		}else {
			return false;
		}*/
		
	}

    public void insertFirst(Type newItem)
	{
		if (this.isEmpty()) {
			first =new NodeList<Type>(newItem);
			last =first;
		}
		else {
			first = new NodeList<Type>(newItem,first);
		}
		count++;
    		
	}
    	
    	
	//Function to return newItem at the end of the list.
	//Postcondition: first points to the new list, newItem is inserted at 
	//               the end of the list, and last points to the last node
	//               in the list.
	public void insertLast(Type newItem)
	{		
		if (this.isEmpty()) {
			first = new NodeList<Type>(newItem);
			last = first;
		}else {
			
			/*NodeList<Type> nuevo=new NodeList(newItem);
			last.setLink(nuevo);*/
			
			last.setLink(new NodeList<Type>(newItem));
			last = last.getLink();
		}
		count++;
		
	}


  	//Function to delete deleteItem from the list.
 	//Postcondition: If found, the node containing deleteItem is deleted from the 
	//               list, first points to the first node, and last points 
	//                to the last node of the updated list. 
	public void deleteNode(Type deleteItem) {
		NodeList<Type> aux =first;
		NodeList<Type> ant =null;
		
		if(first.getInfo().compareTo(deleteItem) == 0) {
			if(first==last) 
				last=null;
			first = first.getLink();
			
		}
		else {
		
			//while(aux!= null && !aux.getInfo().equals(deleteItem)) {
			while(aux!= null && aux.getInfo().compareTo(deleteItem)!=0) {
				ant = aux;
				aux = aux.getLink();
			}
			
			if (aux!=null) {
				ant.setLink(aux.getLink());
				if(last==aux)
					last=ant;
				System.out.println("eliminado");
				count--;
			}
			else 
				System.out.println("Item not found");
		
		
	}}
	
	public String toString() {
		String st="";
		NodeList<Type> aux=first;
		
		while(aux!=null) {
			st += aux.getInfo()+" ; ";
			aux=aux.getLink();
		}
		
		return st;
	}
	
	public Type buscaMay() {
		
		if (this.isEmpty())
			return null;
		else {
		Type mayor = first.getInfo();
		NodeList<Type> aux = first;
		for (;aux != null;aux = aux.getLink() )
			if(aux.getInfo().compareTo(mayor)>0)
				mayor = aux.getInfo();
		return mayor;
		}			
	}

}

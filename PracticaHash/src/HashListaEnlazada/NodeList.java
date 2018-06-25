package HashListaEnlazada;

public class NodeList<Type>{
	private	Type info;
	private NodeList<Type> link;
	//Initializes the values of node
	//Postcondition: this.info = info, this.link = null
   	public NodeList(Type info){
		this.info = info;
		this.link = null;    
    }

	//Initializes the values of node
	//Postcondition: this.info = info, this.link = link
   	public NodeList(Type info, NodeList<Type> link){
		this.info = info;	//informaicon
		this.link = link;	//siguiente 
    }
   	
   	
   	public Type getInfo() {return info;}
   	public NodeList<Type> getLink() {return link;}
   	public void setInfo(Type info) { this.info = info; }
   	public void setLink(NodeList<Type> link) { this.link = link; }
} 
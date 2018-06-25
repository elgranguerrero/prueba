package HashListaEnlazada;
import java.util.ArrayList;

public class Hash<E extends Comparable<E>> {
	
	protected class Element{
		E key;
		int mark;
		public Element(int mark, E key) {
			this.mark=mark;
			this.key=key;
		}
		public String toString() {
			return key.toString();
		}
	}
	protected ArrayList<LinkedList> table;
	protected int m;
	//protected LinkedList<E> linked;
	
	public Hash(int n) {
		for(int i=n;n>=i;i--) {
			int cont=0;
			for (int j=1;j<=i;j++){
				if (i%j==0) {
					cont++;
				}
			}
			if (cont<=2) {
				this.m=i;
				break;
			}
		}
		System.out.println(this.m);
		this.table=new ArrayList<LinkedList>(m);
		for(int i=0;i<m;i++) {
			this.table.add(new LinkedList<E>());
		}
		//this.linked=new LinkedList<E>();
	}
	private int funcionHash(E key) {
		return key.hashCode()%this.m;
	}
	public void insert(E key) {
		int dressHash=funcionHash(key);
		if(table.get(dressHash).isEmpty() ) {
			table.get(dressHash).insertFirst(key);
		}
		else {
			dressHash=cuadraticaProbing(dressHash);
			table.get(dressHash).insertLast(key);
		}
	}
	private int cuadraticaProbing(int dressHash){
		int posInit = dressHash;
		int posCua=dressHash;
		int i=0;
		do{
		if (table.get(posCua).isEmpty())
			return posCua; //se encontró posicion
		i++;
		posCua = (dressHash + (i*i)) % this.m;
		} while (posCua != posInit && i<4);
		return posCua; // no hay espacio disponible
	}
	/*private int cudraticaProbing(int dressHash,E key){
		int posInit = dressHash;
		int posCua=dressHash;
		int i=0;
		do{
			if (table.get(posCua).key==null) return -1;
			else if (table.get(posCua).key.compareTo(key)==0)
				return posCua; //se encontró posicion
			i++;
			posCua = (dressHash + (i*i)) % this.m;
			} while (posCua != posInit && i<4);
		return -1; // no hay espacio disponible
	}
	public boolean search(E key) {
		if (_search(key)==null) return false;
		return true;
	}
	private E _search(E key) {
		int dressHash=funcionHash(key);
		if(table.get(dressHash).mark==1 && table.get(dressHash).key.compareTo(key)==0) {
			return  table.get(dressHash).key;
		}
		else {
			dressHash=cudraticaProbing(dressHash,key);
			if (dressHash==-1) {
				return null;
			}
			else {
				return table.get(dressHash).key;
			}
		}
	}*/
	public String toString() {
		String s="D.real\td.Hash\tkey\n";
		int i=0;
		for(LinkedList<E> item:table) {
			s+=(i++)+"\t-->\t";
			if (item.isEmpty()==false)
				s=s+item.toString()+"\n";
			else
				s+="empty\n";
		}
		return s;
	}
}
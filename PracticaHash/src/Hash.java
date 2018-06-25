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
	protected ArrayList<Element> table;
	protected int m;
	
	public Hash(int n) {
		for(int i=n;n>=i;i--) {
			int cont=0;
			for (int j=1;j<=i;j++){
				if (i%j==0) {
					cont++;
				}
			}
			if (cont<=2) {
				float cap=(float) 0.4*i;
				this.m=(int) (i+cap);
				break;
			}
		}
		System.out.println(this.m);
		this.table=new ArrayList<Element>(m);
		for(int i=0;i<m;i++) {
			this.table.add(new Element(0,null));
		}
	}
	private int funcionHash(E key) {
		return key.hashCode()%this.m;
	}
	public void insert(E key) {
		int dressHash=funcionHash(key);
		if(table.get(dressHash).mark==1 && table.get(dressHash).key.compareTo(key)==0) {
			System.out.println(key+" ya fue ingresada");
			return;
		}
		else {
			dressHash=cuadraticaProbing(dressHash);
			if (dressHash==-1) {
				System.out.println("La tabla esta llena");
				return;
			}
			else {
				table.set(dressHash, new Element(1,key));
			}
		}
	}
	private int linearProbing(int dressHash){
		int posInit = dressHash;
		do{
		if (table.get(dressHash).mark==0)
			return dressHash; //se encontró posicion
		dressHash = (dressHash + 1) % this.m;
		} while (dressHash != posInit);
		return -1; // no hay espacio disponible
	}
	private int linearProbing(int dressHash,E key){
		int posInit = dressHash;
		do{
		if (table.get(dressHash).key==null) return -1;
		else if (table.get(dressHash).key.compareTo(key)==0)
			return dressHash; //se encontró posicion
		dressHash = (dressHash + 1) % this.m;
		} while (dressHash != posInit);
		return -1; // no hay espacio disponible
	}
	private int cuadraticaProbing(int dressHash){
		int posInit = dressHash;
		int posCua=dressHash;
		int i=0;
		do{
		if (table.get(posCua).mark==0)
			return posCua; //se encontró posicion
		i++;
		posCua = (dressHash + (i*i)) % this.m;
		} while (posCua != posInit);
		return -1; // no hay espacio disponible
	}
	private int cudraticaProbing(int dressHash,E key){
		int posInit = dressHash;
		int posCua=dressHash;
		int i=0;
		do{
			if (table.get(posCua).key==null) return -1;
			else if (table.get(posCua).key.compareTo(key)==0)
				return posCua; //se encontró posicion
			i++;
			posCua = (dressHash + (i*i)) % this.m;
			} while (posCua != posInit);
		return -1; // no hay espacio disponible
	}
	public boolean search(E key) {
		if (_search(key)==-1) return false;
		return true;
	}
	private int _search(E key) {
		int dressHash=funcionHash(key);
		if(table.get(dressHash).mark==1 && table.get(dressHash).key.compareTo(key)==0) {
			return  dressHash;
		}
		else {
			dressHash=cudraticaProbing(dressHash,key);
			if (dressHash==-1) {
				return -1;
			}
			else {
				return dressHash;
			}
		}
	}
	public void remove(E key) {
		int dressRemove=_search(key);
		if (dressRemove==-1)
			System.out.println("No se encontro el elemento");
		else{
			Element auxKey=table.get(dressRemove);
			auxKey.mark=0;
			table.set(dressRemove,auxKey);
		}
	}
	public String toString() {
		String s="D.real\td.Hash\tkey\n";
		int i=0;
		for(Element item:table) {
			s+=(i++)+"\t-->\t";
			if (item!=null && item.mark==1)
				s+=funcionHash(item.key)+"\t\t"+item.key+"\n";
			else
				s+="empty\n";
		}
		return s;
	}
}
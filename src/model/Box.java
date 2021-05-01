package model;

public class Box {
	private int Name;
	private char S;
	private char E;
	private person P;
	private int s1;
	private int p1;
	
	private Box next;
	private Box Last;
	private Box next2;
	private Box Last2;
	
	//inicio y fin de s y p
	
	private Boolean S_head;
	private Boolean s_tail;
	private Boolean p_head;
	private Boolean p_tail;
	
	/**
	 * @param name
	 * @param s
	 * @param e
	 * @param p
	 */
	
	public Box(int name, char s, char e) {
		super();
		this.Name = name;
		this.S = s;
		this.E = e;
	}
	
	
	public int getName() {
		return Name;
	}
	public void setName(int name) {
		Name = name;
	}
	public char getS() {
		return S;
	}
	public void setS(char s) {
		S = s;
	}
	public char getE() {
		return E;
	}
	public void setE(char e) {
		E = e;
	}
	public person getP() {
		return P;
	}
	public void setP(person p) {
		P = p;
	}
	public int getS1() {
		return s1;
	}
	public void setS1(int s1) {
		this.s1 = s1;
	}
	public int getP1() {
		return p1;
	}
	public void setP1(int p1) {
		this.p1 = p1;
	}

	
	//controler the direcction
	public Box getNext() {
		return next;
	}
	public void setNext(Box next) {
		this.next = next;
	}
	public Box getLast() {
		return Last;
	}
	public void setLast(Box Last) {
		this.Last = Last;
	}
	public Box getNext2() {
		return next2;
	}
	public void setNext2(Box next2) {
		this.next2 = next2;
	}
	public Box getLast2() {
		return Last2;
	}
	public void setLast2(Box last2) {
		Last2 = last2;
	}
	
	
	//set and get of the head tail
	public Boolean getS_head() {
		return S_head;
	}
	public void setS_head(Boolean s_head) {
		S_head = s_head;
	}
	public Boolean getS_tail() {
		return s_tail;
	}
	public void setS_tail(Boolean s_tail) {
		this.s_tail = s_tail;
	}
	public Boolean getP_head() {
		return p_head;
	}
	public void setP_head(Boolean p_head) {
		this.p_head = p_head;
	}
	public Boolean getP_tail() {
		return p_tail;
	}
	public void setP_tail(Boolean p_tail) {
		this.p_tail = p_tail;
	}
	
	
	
	@Override
	public String toString() {
		return "Box [S=" + S + ", E=" + E + ", P=" + P + "]";
	}

	
	
}

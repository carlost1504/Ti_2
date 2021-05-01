package model;

import java.util.Random;

public class board {
	private Box first;
	private Box next;
	private int filas;
	private int columnas;
	
	public board(int filas,int columnas) {
		this.filas=filas;
		this.columnas=columnas;
	}
	
	public boolean estVacia() {
		return first==null;
	}
	
	
	public void create(int row,int column,int cont,int numCol, char s, char e) {
		if(row>0) {
			int name=row*column;
			Box ng=new Box( name,  s,  e);
			name--;
			if(!estVacia()) {
				first=ng;
				createRows(cont,first,column,1,numCol+1,  s,  e);
				create(row-1,column,cont+1,numCol, s,  e);
				
			}else{
				Box current=findNext(first);
				if(current.getNext2() ==null) {
					createRows(cont,ng,column,1,numCol+1,  s,  e);
					current.setNext2(ng);
					ng.setNext2(current);
					linkRows(current,current.getNext2(),column,1);
					create(row-1,column,cont+1,numCol, s,  e);
				}
			}
		}
	}
	
	private Box findNext(Box g) {
		if(g.getNext2()==null) {
			return g;
		}
		else {
			return findNext(g.getNext2());
		}
	}
	
	private void createRows(int cont,Box g,int c,int contCol,int numCol, char s, char e) {
		if(c>1) {
			int col=c*contCol;
			Box ng=new Box(col , s,  e);
			if(g.getLast2()==null) {
				g.setLast2(ng);
				ng.setLast(g);
				createRows(cont,ng,c-1,contCol+1,numCol+1, s,  e);
			}
			else {
				Box current=g.getNext();
				createRows(cont,current,c,contCol,numCol+1, s,  e);
			}	
		}
	}
	
	private void linkRows(Box g1,Box g2,int col,int cont) {
		if(cont<col) {
		Box current=g1.getNext();
		Box temp=g2.getNext();
		current.setNext2(temp);
		temp.setLast2(current);
		linkRows(current,temp,col,cont+1);
		}
	}
	
	public void asignaName(Box aux,int name) {
		Box ax2Prime= aux;
		name++;
		if(aux!=null) {
			aux.setName(name);
			aux =aux.getNext();
			asignaName(aux,name);
		}else {
			Box ax3;
			ax3=ax2Prime.getNext2();
			ax3.setName(name);
			asignaName(ax3,name);
		}
	}
	
	public void addSnake(Box aux,int totalS,int cantRow,int acum,int space,int cont) {
		Box ax2Prime= aux;
		int romT =(int) Math.floor(Math.random()*(cantRow-0+1)+0);
		boolean exit=false;
		if(totalS>=0) {
			if(aux!=null) {
				if(romT==1&&aux.getE()!='E'&& exit==false) {
					aux.setS('s');
					if(cont==1) {
						aux.setS_tail(true);
					}else if(cont==0) {
						aux.setS_tail(true);
					}
					
					totalS--;
					acum++;
				}
				aux =aux.getNext();
				addSnake(aux, totalS,cantRow, acum, space,cont);
			}else if(exit==false) {
				Box ax3;
				ax3=ax2Prime.getNext2();
				if(romT==1&&ax3.getE()!='e'&& exit==false) {
					ax3.setS('s');
					if(cont==1) {
						ax3.setS_tail(true);
					}else if(cont==0) {
						ax3.setS_tail(true);
					}
					totalS--;
					acum++;
					space++;
					if(space==2) {
						exit=true;
						cont++;
					}
				}
			space--;
			if(space==0) {
				exit=false;
			}
			addSnake(ax3, totalS,cantRow,acum,space,cont);
			}
		addSnake(aux, totalS,cantRow, acum, space,cont);
		}
	}
	
	
	private void asignSE(int row,int column){
		int cantRow=(int)(row*0.20);
		int cantColumn=(int)(column*0.20);
		int totalS=cantRow*cantColumn;
		int space=0;
		int acum=0;
		int cont=0;
		if(!estVacia()) {
			addSnake( first, totalS, cantRow, acum, space,cont);
			addStairs(first, totalS, cantRow, acum, space,cont);
			
		}
	}
	
	public void addStairs(Box aux,int totalS,int cantRow,int acum,int space,int cont) {
		Box ax2Prime= aux;
		int romT =(int) Math.floor(Math.random()*(cantRow-0+1)+0);
		boolean exit=false;
		if(totalS>=0) {
			if(aux!=null) {
				if(romT==1&&aux.getS()!='s'&& exit==false) {
					aux.setE('e');
					if(cont==1) {
						aux.setS_tail(true);
					}else if(cont==0) {
						aux.setS_tail(true);
					}
					totalS--;
					acum++;
				}
				aux =aux.getNext();
				addStairs(aux, totalS,cantRow, acum, space,cont);
			}else if(exit==false) {
				Box ax3;
				ax3=ax2Prime.getNext2();
				if(romT==1&&ax3.getS()!='s'&& exit==false) {
					ax3.setE('e');
					if(cont==1) {
						ax3.setS_tail(true);
					}else if(cont==0) {
						ax3.setS_tail(true);
					}
					totalS--;
					acum++;
					space++;
					if(space==2) {
						exit=true;
					}
				}
				space--;
				if(space==0) {
					exit=false;
				}
				addStairs(ax3, totalS,cantRow,acum,space,cont);
			}
			addStairs(aux, totalS,cantRow, acum, space,cont);
		}
	}
	
	public int dado() {
		
	}
	
}

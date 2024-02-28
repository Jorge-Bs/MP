package uo.mp2223.util.collections.impl;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp2223.util.collections.List;

public abstract class AbstractList<T> implements List<T> {

	int numberOfElements;
	
	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o)!=-1;
	}

	@Override
	public boolean add(T element) {
		add(size(), element);
		return true;
		
	}
	@Override
	public boolean remove(Object o) {
		ArgumentChecks.isTrue(o!=null,"Objeto invalido");
		int index = indexOf(o);
		if(index ==-1) return false;
		remove(index);
		return true;
	}
	
	
	public boolean equals(Object o) {
		if(o== null) return false;
		if(o== this)return true;
		if(!(o instanceof List))return false;
		
		List<?> that =(List<?>) o;
		if(this.size()!= that.size()) return false;
		for(int i=0;i<size();i++) {
			Object a1= this.get(i);
			Object a2 = that.get(i);
			if(!(a1.equals(a2))) return false;
		}
		return true;
	}
	
	public int hashCode() {
		int result=1;
		for(int i=0; i<size();i++) {
			Object element =this.get(i);
			result = 31 *result +(element.hashCode());
		}
		return result;
	}
	

}

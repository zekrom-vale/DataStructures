package heap;

public class Heap{


	protected int depth(final int index){
		return (int)Math.ceil(Math.log(index+2)/Math.log(2))-1;
	}

	protected int fromRight(final int index){
		return index-(int)Math.pow(2, this.depth(index))+1;
	}

	protected int left(final int index){
		return 2*index+1;
	}

	protected int parent(final int index){
		return (index-1)/2;
	}

	protected int right(final int index){
		return 2*(index+1);
	}
}

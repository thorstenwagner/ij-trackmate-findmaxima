package de.biomedical_imaging.ij.findmax;


import java.util.Comparator;

import net.imglib2.Point;
import net.imglib2.RandomAccess;
import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.RealType;

public class FindMaximaSpotComparator< T extends RealType< T > & NativeType< T >>  implements Comparator<Point> {

	RandomAccess<T> ra;
	
	public FindMaximaSpotComparator(RandomAccess<T> ra) {
		// TODO Auto-generated constructor stub
		this.ra = ra;
	}
	
	@Override
	public int compare(Point o1, Point o2) {
		ra.setPosition(o1);
		double val1 = ra.get().getRealDouble();
		
		ra.setPosition(o2);
		double val2 = ra.get().getRealDouble();
		if(val1>val2){
			return 1;
		}
		if(val1<val2){
			return -1;
		}
		
		return 0;
	}

}

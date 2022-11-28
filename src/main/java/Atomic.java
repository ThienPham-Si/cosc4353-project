import java.util.*;

public class Atomic {
    private int atomicID;

    public void PrimitiveElement(int atomicId) {
		atomicID = atomicId;
	}

	public int getAtomicID() {
		return atomicID;
	}


    public int getMyTypeId() {
		return atomicID;
	}
}

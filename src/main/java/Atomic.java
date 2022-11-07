import java.util.*;

public class Atomic {
    private int atomicID;

    public PrimitiveElement(int atomicId) {
		atomicID = atomicId;
	}

    public int getMyTypeId() {
		return atomicID;
	}
}

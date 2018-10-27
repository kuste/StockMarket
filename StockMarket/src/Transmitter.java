
public interface Transmitter {

	void add(Receiver r);
	void remove(Receiver r);
	void notifyRec();

}

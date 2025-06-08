public interface HexGame{

	public void setSize(String str);
	public int getSize();
	public void setPlayer(int num);
	public void reset();
	public void load();
	public void save();
	public void undo();
	
}


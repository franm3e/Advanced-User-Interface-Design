/********************************************************/
/*  Class: Classification.java                          */
/*  Generated by UML2Android                            */
/*  Author: Francisco Martinez Esteso                   */
/********************************************************/

package es.uclm.daui.datarunning;


import java.util.ArrayList;

public class Classification implements PersistentDomainClass {

	public long _id = -1;
	public String time;
	public ArrayList<Position> positions = new ArrayList<Position>();
	public Integer year;

	@Override
	public long getId(DbHelper db) {
		if (_id==-1) { // _id not set yet.
			_id = db.createClassification(this);
		}
			return _id;
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long __id) {
		_id = __id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String _time) {
		time =_time;
	}

	public ArrayList<Position> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Position> _positions) {
		positions =_positions;
	}

	public void addPosition(Position _position) {
		positions.add(_position);
		// _position.setClassification(getId()); /* Asign FK id. */
	}

	public void removePosition(Position _position) {
		positions.remove(_position);
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer _year) {
		year =_year;
	}
}

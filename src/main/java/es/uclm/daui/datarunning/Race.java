/********************************************************/
/*  Class: Race.java                                    */
/*  Generated by UML2Android                            */
/*  Author: Francisco Martinez Esteso                   */
/********************************************************/

package es.uclm.daui.datarunning;


import java.util.ArrayList;

public class Race implements PersistentDomainClass {

	public long _id = -1;

	public String Name;
	public String Locality;
	public ArrayList<Classification> classifications = new ArrayList<Classification>();
	public ArrayList<Survey> surveys = new ArrayList<Survey>();
	public Integer Distance;
    

	@Override
	public long getId(DbHelper db) {
		if (_id==-1) { // _id not set yet.
			_id = db.createRace(this);
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

	public String getName() {
		return Name;
	}

	public void setName(String _Name) {
		Name =_Name;
	}

	public String getLocality() {
		return Locality;
	}

	public void setLocality(String _Locality) {
		Locality =_Locality;
	}

	public ArrayList<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(ArrayList<Classification> _classifications) {
		classifications =_classifications;
	}

	public void addClassification(Classification _classification) {
		classifications.add(_classification);
		// _classification.setRace(getId()); /* Asign FK id. */
	}
	public void removeClassification(Classification _classification) {
		classifications.remove(_classification);
	}

	public ArrayList<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(ArrayList<Survey> _surveys) {
		surveys =_surveys;
	}

	public void addSurvey(Survey _survey) {
		surveys.add(_survey);
		// _survey.setRace(getId()); /* Asign FK id. */
	}

	public void removeSurvey(Survey _survey) {
		surveys.remove(_survey);
	}

	public Integer getDistance() {
		return Distance;
	}

	public void setDistance(Integer _Distance) {
		Distance =_Distance;
	}
}

